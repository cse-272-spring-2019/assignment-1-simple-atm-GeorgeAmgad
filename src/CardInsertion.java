import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

class CardInsertion {

    private Scene scene;
    private Stage stage;
    private Account account;
    private MainMenu mainMenu;

    CardInsertion(Stage stage, Account account) {
        this.stage = stage;
        this.account = account;
    }

    private void prepareScene() {

        Label label = new Label(" Card Number : ");
        TextField cardField = new TextField();
        Button insert = new Button("  Insert  ");
        Label validate = new Label();

        GridPane grid = new GridPane();
        grid.add(label, 0, 0);
        grid.add(cardField, 1, 0);
        grid.add(insert, 1, 1);
        grid.add(validate, 1, 2);
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setAlignment(Pos.CENTER);
        grid.setVgap(5);
        grid.setHgap(5);

        insert.setOnAction(event -> {
            if (account.validate(cardField.getText())) {
                stage.setScene(mainMenu.getScene());
            } else {
                validate.setText("Unknown card");
            }
        });

        scene = new Scene(grid, 275, 90);
    }

    Scene getScene() {
        this.prepareScene();
        return scene;
    }

    void setMainMenu(MainMenu mainMenu) {
        this.mainMenu = mainMenu;
    }
}
