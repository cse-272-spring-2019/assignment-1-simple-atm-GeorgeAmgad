import javafx.application.Application;
import javafx.stage.Stage;

public class ATM_machine extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("ATM machine");

        Account account = new Account();
        CardInsertion cardInsertion = new CardInsertion(primaryStage, account);
        MainMenu mainMenu = new MainMenu(account);
        NumPad numPad = new NumPad(mainMenu);

        mainMenu.setNumPad(numPad);
        cardInsertion.setMainMenu(mainMenu);

        primaryStage.setScene(cardInsertion.getScene());
        primaryStage.show();
    }
}
