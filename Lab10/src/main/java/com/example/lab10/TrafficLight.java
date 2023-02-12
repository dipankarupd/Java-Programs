package com.example.lab10;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

import javafx.application.*;
import javafx.geometry.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.*;
import javafx.stage.*;

public class TrafficLight extends Application {

    private Label labeledmessage1;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage MainStage1) {
        labeledmessage1 = new Label();
        labeledmessage1.setMinSize(250, 50);
        labeledmessage1.setStyle("-fx-font-size: 24;");

        RadioButton RButton = new RadioButton("Red");
        RButton.setOnAction(e -> {
            labeledmessage1.setText("Stop");
            labeledmessage1.setTextFill(Color.RED);
        });

        RadioButton YButton = new RadioButton("Yellow");
        YButton.setOnAction(e -> {
            labeledmessage1.setText("Wait");
            //labeledmessage1.setTextFill(Color.YELLOW);
            labeledmessage1.setTextFill(Color.YELLOW);
        });

        RadioButton GButton = new RadioButton("Green");
        GButton.setOnAction(e -> {
            labeledmessage1.setText("Go");
            labeledmessage1.setTextFill(Color.GREEN);
        });

        ToggleGroup toggleGroup = new ToggleGroup();
        RButton.setToggleGroup(toggleGroup);
        YButton.setToggleGroup(toggleGroup);
        GButton.setToggleGroup(toggleGroup);

        VBox root = new VBox(10, labeledmessage1, RButton, YButton, GButton);
        root.setPadding(new Insets(10));
        root.setPrefSize(300, 200);

        Scene scene = new Scene(root);
        MainStage1.setScene(scene);
        MainStage1.setTitle("Traffic Signal");
        MainStage1.show();
    }
}