package ticTacToe;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class TicTacToeApplication extends Application {

    private Button[][] buttons = new Button[3][3];
    private String player = "X";

    @Override
    public void start(Stage window) {

        BorderPane layout = new BorderPane();
        layout.setPrefSize(400, 400);
        Label text = new Label("Turn: X");
        text.setFont(Font.font("Monospaced", 40));

        layout.setTop(text);

        GridPane gridPane = new GridPane();

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                Button button = new Button();
                buttons[i][j] = button;
                button.setFont(Font.font("Monospaced", 40));
                gridPane.add(button, i, j);

                button.setOnAction((event) -> {

                    if (!isWinner()) {
                        clickButton(button);
                        if (isWinner()) {
                            text.setText("The end!");
                            return;
                        }

                        text.setText("Turn: " + player);
                    }

                    if (allButtonsAreFull(buttons)) {
                        text.setText("Game Over");
                    }

                });
            }
        }

        layout.setCenter(gridPane);
        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.show();
    }

    private boolean allButtonsAreFull(Button[][] buttons) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (buttons[i][j].getText().isEmpty()) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isWinner() {

        return rowWin() || (columnWin()) || diagonalWin();
    }

    private boolean rowWin() {
        if ((!buttons[0][0].getText().isEmpty())
                && buttons[0][0].getText().equals(buttons[0][1].getText())
                && (buttons[0][0].getText().equals(buttons[0][2].getText()))) {
            player = buttons[0][0].getText();
            return true;
        }

        if ((!buttons[1][0].getText().isEmpty())
                && (buttons[1][0].getText().equals(buttons[1][1].getText())
                && (buttons[1][0].getText().equals(buttons[1][2].getText())))) {
            player = buttons[1][0].getText();
            return true;

        }

        if ((!buttons[2][0].getText().isEmpty())
                && (buttons[2][0].getText().equals(buttons[2][1].getText())
                && (buttons[2][0].getText().equals(buttons[2][2].getText())))) {
            player = buttons[2][0].getText();
            return true;
        }
        return false;
    }

    private boolean columnWin() {
        if ((!buttons[0][0].getText().isEmpty())
                && buttons[0][0].getText().equals(buttons[1][0].getText())
                && (buttons[0][0].getText().equals(buttons[2][0].getText()))) {
            player = buttons[0][0].getText();
            return true;
        }
        if ((!buttons[0][1].getText().isEmpty())
                && (buttons[0][1].getText().equals(buttons[1][1].getText())
                && (buttons[0][1].getText().equals(buttons[2][1].getText())))) {
            player = buttons[0][1].getText();
            return true;
        }
        if ((!buttons[0][2].getText().isEmpty())
                && (buttons[0][2].getText().equals(buttons[1][2].getText())
                && (buttons[0][2].getText().equals(buttons[2][2].getText())))) {
            player = buttons[0][2].getText();
            return true;
        }
        return false;
    }

    private boolean diagonalWin() {
        if ((!buttons[0][0].getText().isEmpty())
                && buttons[0][0].getText().equals(buttons[1][1].getText())
                && (buttons[0][0].getText().equals(buttons[2][2].getText()))) {
            player = buttons[0][0].getText();
            return true;
        }

        if ((!buttons[0][2].getText().isEmpty())
                && (buttons[0][2].getText().equals(buttons[1][1].getText())
                && (buttons[0][2].getText().equals(buttons[2][0].getText())))) {
            player = buttons[0][2].getText();
            return true;
        }
        return false;
    }

    private boolean buttonIsEmpty(Button button) {
        return button.getText().isEmpty();
    }

    private void clickButton(Button button) {
        if (buttonIsEmpty(button)) {
            button.setText(player);

            if ("X".equals(player)) {
                player = "O";
            } else {
                player = "X";
            }

        }
    }

    public static void main(String[] args) {
        launch(TicTacToeApplication.class
        );
    }
}
