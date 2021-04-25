package pl.pkrysztofiak.controls;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class App extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        ComboBox<String> comboBox = new ComboBox<>();
        StackPane stackPane2 = new StackPane(comboBox);
        stackPane2.setPrefSize(100, 100);

        TextField textField = new TextField();
        StackPane stackPane = new StackPane(textField);
        stackPane.setPrefSize(100, 100);

        VBox vBox = new VBox(stackPane, stackPane2);
        Scene scene = new Scene(vBox, 400, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}