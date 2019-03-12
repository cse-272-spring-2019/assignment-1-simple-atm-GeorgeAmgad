import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

class NumPad {
    private Scene scene;
    private MainMenu mainMenu;
    private StringBuilder input;

    NumPad(MainMenu mainMenu) {
        this.mainMenu = mainMenu;
    }

    private void prepareScene() {

        input = new StringBuilder();

        Button n1 = new Button("   1   ");
        Button n2 = new Button("   2   ");
        Button n3 = new Button("   3   ");
        Button n4 = new Button("   4   ");
        Button n5 = new Button("   5   ");
        Button n6 = new Button("   6   ");
        Button n7 = new Button("   7   ");
        Button n8 = new Button("   8   ");
        Button n9 = new Button("   9   ");
        Button delete = new Button(" Del  ");
        Button n0 = new Button("   0   ");
        Button enter = new Button("Enter");
        Label display = new Label();
        display.setAlignment(Pos.CENTER);

        GridPane grid = new GridPane();
        GridPane numbers = new GridPane();

        numbers.add(display, 0, 0);
        numbers.add(n1, 0, 1);
        numbers.add(n2, 1, 1);
        numbers.add(n3, 2, 1);
        numbers.add(n4, 0, 2);
        numbers.add(n5, 1, 2);
        numbers.add(n6, 2, 2);
        numbers.add(n7, 0, 3);
        numbers.add(n8, 1, 3);
        numbers.add(n9, 2, 3);
        numbers.add(delete, 0, 4);
        numbers.add(n0, 1, 4);
        numbers.add(enter, 2, 4);

        numbers.setAlignment(Pos.CENTER);

        numbers.setHgap(5.0);
        numbers.setVgap(5.0);

        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setAlignment(Pos.CENTER);

        grid.setHgap(5.0);
        grid.setVgap(5.0);

        grid.add(display, 0, 0);
        grid.add(numbers, 0, 1);

        scene = new Scene(grid, 170, 170);

        n1.setOnAction(event -> {
            input.append(1);
            display.setText("   " + input.toString());
        });
        n2.setOnAction(event -> {
            input.append(2);
            display.setText("   " + input.toString());
        });
        n3.setOnAction(event -> {
            input.append(3);
            display.setText("   " + input.toString());
        });
        n4.setOnAction(event -> {
            input.append(4);
            display.setText("   " + input.toString());
        });
        n5.setOnAction(event -> {
            input.append(5);
            display.setText("   " + input.toString());
        });
        n6.setOnAction(event -> {
            input.append(6);
            display.setText("   " + input.toString());
        });
        n7.setOnAction(event -> {
            input.append(7);
            display.setText("   " + input.toString());
        });
        n8.setOnAction(event -> {
            input.append(8);
            display.setText("   " + input.toString());
        });
        n9.setOnAction(event -> {
            input.append(9);
            display.setText("   " + input.toString());
        });
        n0.setOnAction(event -> {
            input.append(0);
            display.setText("   " + input.toString());
        });

        delete.setOnAction(Event -> {
            if (input.length() > 0) input.deleteCharAt(input.length() - 1);
            display.setText("   " + input.toString());
        });

        enter.setOnAction(Event -> {
            if (input.length() != 0) mainMenu.setPortal(input.toString());
            else mainMenu.setPortal("0");
            display.setText("");
            input.delete(0, input.length());
            mainMenu.closeStage();

        });
    }

    Scene getScene() {
        this.prepareScene();
        return scene;
    }
}
