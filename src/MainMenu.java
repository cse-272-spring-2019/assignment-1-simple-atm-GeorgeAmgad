import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


class MainMenu {
    private Stage stage = new Stage();
    private Scene scene;
    private Account account;
    private String portal;

    MainMenu(Account account) {
        this.account = account;
    }

    private void prepareScene() {

        stage.initStyle(StageStyle.UNDECORATED);

        Button prev = new Button("  Previous  ");
        Button next = new Button("    Next    ");
        Button balance = new Button("           Balance           ");
        Button withdraw = new Button(" Withdraw ");
        Button deposit = new Button(" Deposit  ");
        Label display = new Label();
        display.setAlignment(Pos.CENTER);

        GridPane grid = new GridPane();
        grid.add(prev, 0, 0);
        grid.add(display, 1, 0);
        grid.add(next, 2, 0);
        grid.add(withdraw, 0, 1);
        grid.add(balance, 1, 1);
        grid.add(deposit, 2, 1);

        grid.setPadding(new Insets(7, 7, 7, 7));
        grid.setAlignment(Pos.CENTER);

        grid.setHgap(7.0);
        grid.setVgap(7.0);

        scene = new Scene(grid, 325, 75);

        balance.setOnAction(Event -> display.setText("     " + account.getCurrentBalance()));

        deposit.setOnAction(Event -> {
            if (!stage.isShowing()) {
                stage.showAndWait();
                account.deposit(portal);
                display.setText("   Deposited : " + portal);
            }
        });

        withdraw.setOnAction(Event -> {
            if (!stage.isShowing()) {
                stage.showAndWait();
                if (account.withdraw(portal)) display.setText("withdrawn : " + portal);
                else display.setText("   insufficient funds!");
            }
        });

        next.setOnAction(Event -> display.setText("   " + account.next()));

        prev.setOnAction(Event -> display.setText("   " + account.prev()));

    }

    Scene getScene() {
        this.prepareScene();
        return scene;
    }

    void setPortal(String portal) {
        this.portal = portal;
    }

    void setNumPad(NumPad numPad) {
        stage.setScene(numPad.getScene());
    }

    void closeStage() {
        stage.close();
    }
}
