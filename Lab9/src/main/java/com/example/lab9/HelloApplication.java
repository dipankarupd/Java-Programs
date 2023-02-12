package com.example.lab9;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class HelloApplication extends Application {
    private TextField RField;
    private boolean StartNNo = true;
    private double No1;
    private String operation = "";

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Calculator");

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setPadding(new Insets(25, 25, 25, 25));
        grid.setVgap(10);
        grid.setHgap(10);

        RField = new TextField();
        RField.setEditable(false);
        grid.add(RField, 0, 0, 5, 1);

        Button btn7 = new Button("7");
        btn7.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                updateRField("7");
            }
        });
        grid.add(btn7, 0, 2);

        Button btn8 = new Button("8");
        btn8.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                updateRField("8");
            }
        });
        grid.add(btn8, 1, 2);

        Button btn9 = new Button("9");
        btn9.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                updateRField("9");
            }
        });
        grid.add(btn9, 2, 2);

        Button btnAdd = new Button("+");
        btnAdd.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                performOperation("+");
            }
        });
        grid.add(btnAdd, 3, 1);

        Button btn4 = new Button("4");
        btn4.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                updateRField("4");
            }
        });
        grid.add(btn4, 0, 3);

        Button btn5 = new Button("5");
        btn5.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                updateRField("5");
            }
        });
        grid.add(btn5, 1, 3);

        Button btn6 = new Button("6");
        btn6.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                updateRField("6");
            }
        });
        grid.add(btn6, 2, 3);

        Button btnSubtract = new Button("-");
        btnSubtract.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                performOperation("-");
            }
        });
        grid.add(btnSubtract, 3, 2);

        Button btn1 = new Button("1");
        btn1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                updateRField("1");
            }
        });
        grid.add(btn1, 0, 4);

        Button btn2 = new Button("2");
        btn2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                updateRField("2");
            }
        });
        grid.add(btn2, 1, 4);

        Button btn3 = new Button("3");
        btn3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                updateRField("3");
            }
        });
        grid.add(btn3, 2, 4);

        Button btnMultiply = new Button("*");
        btnMultiply.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                performOperation("*");
            }
        });
        grid.add(btnMultiply, 3, 3);

        Button btn0 = new Button("0");
        btn0.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                updateRField("0");
            }
        });
        grid.add(btn0, 1, 5);

        Button btnClear = new Button("C");
        btnClear.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                RField.clear();
                StartNNo = true;
                No1 = 0;
                operation = "";
            }
        });
        grid.add(btnClear, 0, 1);

        Button btnEqual = new Button("=");
        btnEqual.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                performOperation("=");
            }
        });
        grid.add(btnEqual, 2, 1);

        Button DivB = new Button("/");
        DivB.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                performOperation("/");
            }
        });
        grid.add(DivB, 3, 4);

        Scene scene = new Scene(grid, 300, 250);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void updateRField(String input) {
        if (StartNNo) {
            RField.clear();
            StartNNo = false;
        }
        RField.appendText(input);
    }

    private void performOperation(String operator) {
        try {
            if (!operation.isEmpty()) {
                double no2 = Double.parseDouble(RField.getText());
                switch (operation) {
                    case "+":
                        No1 = No1 + no2;
                        break;
                    case "-":
                        No1 = No1 - no2;
                        break;
                    case "*":
                        No1 = No1 * no2;
                        break;
                    case "/":
                        if (no2 == 0) {
                            throw new ArithmeticException("Cannot divide by zero");
                        }
                        No1 = No1 / no2;
                        break;
                }
                RField.setText(String.valueOf(No1));
                StartNNo = true;
            } else {
                No1 = Double.parseDouble(RField.getText());
                StartNNo = true;
            }
            if (!operator.equals("=")) {
                operation = operator;
            } else {
                operation = "";
            }
        } catch (NumberFormatException e) {
            RField.setText("Invalid input");
            StartNNo = true;
            operation = "";
        } catch (ArithmeticException e) {
            RField.setText("Error: " + e.getMessage());
            StartNNo = true;
            operation = "";
        }
    }
}
