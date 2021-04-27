package pl.pkrysztofiak.controls;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class ComboBoxApp extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        ComboBox<String> comboBox = new ComboBox<>(
                FXCollections.observableArrayList(
                        "oneaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", "two", "three",
                        "four", "five", "six", "seven"));
        StackPane stackPane = new StackPane(comboBox);
        stackPane.setPrefSize(400, 400);
        primaryStage.setScene(new Scene(stackPane));
        primaryStage.show();

    }
}