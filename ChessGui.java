import javafx.application.Application;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import javafx.collections.FXCollections;
import javafx.scene.layout.VBox;
import javafx.scene.Scene;
import javafx.collections.ObservableList;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.beans.binding.Bindings;
import javafx.application.Platform;
import javafx.scene.layout.HBox;
import javafx.scene.control.Alert;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.scene.control.TextField;

/**
     * creates a table of chess games
     *
     * @author nfiroj3
     * @version 1
     */
public class ChessGui extends Application {

    private TextField filterField = new TextField();

/**
     * @param stage representing the Stage object
     */
    @Override
    public void start(Stage stage) {
        // instance of ObservableList
        ChessDb chess = new ChessDb();

        ObservableList<ChessGame> chessGames =
            FXCollections.observableArrayList(chess.getGames());
        TableView<ChessGame> table = createTable(chessGames);

        // filtered search button
        FilteredList<ChessGame> filteredData =
            new FilteredList<>(chessGames, p -> true);

        filterField.textProperty().addListener((observable, oldValue, newValue)
            -> {
                filteredData.setPredicate(game -> {
                        if (newValue == null || newValue.isEmpty()) {
                            return true;
                        }

                        String lowerCaseFilter = newValue.toLowerCase();

                        if (game.getEvent().toLowerCase().
                            contains(lowerCaseFilter)) {
                            return true;
                        } else if (game.getSite().toLowerCase().
                            contains(lowerCaseFilter)) {
                            return true;
                        } else if (game.getDate().toLowerCase().
                            contains(lowerCaseFilter)) {
                            return true;
                        } else if (game.getWhite().toLowerCase().
                            contains(lowerCaseFilter)) {
                            return true;
                        } else if (game.getBlack().toLowerCase().
                            contains(lowerCaseFilter)) {
                            return true;
                        } else if (game.getResult().toLowerCase().
                            contains(lowerCaseFilter)) {
                            return true;
                        }
                        return false;
                    });
            });

        SortedList<ChessGame> sortedData = new SortedList<>(filteredData);
        sortedData.comparatorProperty().bind(table.comparatorProperty());
        table.setItems(sortedData);

        // buttons
        // view game
        Button viewGame = new Button("View Game");
        viewGame.setOnAction(e -> {
                ChessGame chessGame =
                    table.getSelectionModel().getSelectedItem();
                viewDialog(chessGame);
            });
        viewGame.disableProperty().bind(
            Bindings.isEmpty(table.getSelectionModel().getSelectedItems()));

        // exit out of game | dismiss game
        Button dismiss = new Button("Dismiss");
        dismiss.setOnAction(e -> Platform.exit());

        // set up hbox
        HBox buttons = new HBox();
        buttons.getChildren().addAll(viewGame, dismiss, filterField);

        // set up vbox
        VBox vbox = new VBox();
        vbox.getChildren().addAll(table, buttons);

        // finally!!
        Scene scene = new Scene(vbox);
        stage.setScene(scene);
        stage.setTitle("Chess DB GUI");
        stage.show();

    }

/**
     * @return table TableView of chessGames
     */
    private TableView<ChessGame>
        createTable(ObservableList<ChessGame> chessGames) {
        // create table from the chessGames ObservableList
        TableView<ChessGame> table = new TableView<ChessGame>();
        table.setItems(chessGames);

        // table columns
        TableColumn<ChessGame, String> event =
            new TableColumn<ChessGame, String>("Event");
        event.setCellValueFactory(new PropertyValueFactory("event"));
        TableColumn<ChessGame, String> site =
            new TableColumn<ChessGame, String>("Site");
        site.setCellValueFactory(new PropertyValueFactory("site"));
        TableColumn<ChessGame, String> date =
            new TableColumn<ChessGame, String>("Date");
        date.setCellValueFactory(new PropertyValueFactory("date"));
        TableColumn<ChessGame, String> white =
            new TableColumn<ChessGame, String>("White");
        white.setCellValueFactory(new PropertyValueFactory("white"));
        TableColumn<ChessGame, String> black =
            new TableColumn<ChessGame, String>("Black");
        black.setCellValueFactory(new PropertyValueFactory("black"));
        TableColumn<ChessGame, String> result =
            new TableColumn<ChessGame, String>("Result");
        result.setCellValueFactory(new PropertyValueFactory("result"));

        // set up all columns
        table.getColumns().setAll(event, site, date, white, black, result);
        return table;
    }

/**
     * @param chessGame passed into retrieve specific info from it
     */
    private void viewDialog(ChessGame chessGame) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(chessGame.getEvent());
        alert.setHeaderText(String.format("%s at %s", chessGame.getEvent(),
            chessGame.getSite()));
        alert.setContentText(getGame(chessGame));
        alert.showAndWait();
    }

/**
     * @param chessGame representing object from which we will pull data
     * @return chessList representing the list of moves conducted in a game
     */
    private String getGame(ChessGame chessGame) {
        return String.format("%s%n%s%n%s%n%s%n%s%n%s%n%s", chessGame.getEvent(),
            chessGame.getSite(), chessGame.getDate(), chessGame.getWhite(),
            chessGame.getBlack(), chessGame.getResult(), getMoves(chessGame));
    }

    private String getMoves(ChessGame chessGame) {
        int i = 1;
        String chessList = "";
        try {
            while (!chessGame.getMove(i).isEmpty()) {
                chessList += chessGame.getMove(i);
                chessList += "\n";
                i++;
            }
        } catch (IndexOutOfBoundsException e) {
            System.out.println("IndexOutOfBoundsException has occurred.\n"
                + "The following is printed out: " + e.getMessage());
        }
        return chessList;
    }

}