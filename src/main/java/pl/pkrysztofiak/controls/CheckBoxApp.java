package pl.pkrysztofiak.controls;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class CheckBoxApp extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        CheckBox checkBox = new CheckBox("Check Box");
        StackPane stackPane = new StackPane(checkBox);
        stackPane.setPrefSize(400, 400);

        primaryStage.setScene(new Scene(stackPane));
        primaryStage.show();
    }
}