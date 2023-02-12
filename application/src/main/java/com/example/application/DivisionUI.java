package com.example.application;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;
public class DivisionUI extends Application {

    private TextField input1;
    private TextField input2;
    private TextField ResultOut;

    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage mainS) {
        mainS.setTitle("Division of Integers");

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(10);
        grid.setHgap(10);

        Label label1 = new Label("First Number :");
        grid.add(label1, 0, 0);

        input1 = new TextField();
        grid.add(input1, 1, 0);

        Label label2 = new Label("Second Number :");
        grid.add(label2, 0, 1);

        input2 = new TextField();
        grid.add(input2, 1, 1);

        Label resultLabel = new Label("Final Result:");
        grid.add(resultLabel, 0, 3);

        ResultOut = new TextField();
        ResultOut.setEditable(false);
        grid.add(ResultOut, 1, 3);

        Button divideButton = new Button("Divide");
        divideButton.setOnAction(new EventHandler<ActionEvent>() {

            public void handle(ActionEvent event) {
                try {
                    int i1 = Integer.parseInt(input1.getText());
                    int i2 = Integer.parseInt(input2.getText());
                    if (i2 == 0) {
                        throw new ArithmeticException();
                    }
                    int result = i1 / i2;
                    ResultOut.setText(Integer.toString(result));
                } catch (NumberFormatException ex) {
                    showError("Invalid Input", "Both must be integers");
                } catch (ArithmeticException ex) {
                    showError("Invalid Input", "Second number cannot be zero");
                }
            }
        });
        grid.add(divideButton, 1, 2);

        Scene scene = new Scene(grid, 300, 150);
        mainS.setScene(scene);
        mainS.show();
    }

    private void showError(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}