package pl.pkrysztofiak.controls;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import pl.pkrysztofiak.controls.selectbox.SelectBox;

public class App extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        //        ComboBox<String> comboBox = new ComboBox<>();
        //        StackPane stackPane2 = new StackPane(comboBox);
        //        stackPane2.setPrefSize(100, 100);
        //
        //        TextField textField = new TextField();
        //        StackPane stackPane = new StackPane(textField);
        //        stackPane.setPrefSize(100, 100);
        //
        //        VBox vBox = new VBox(stackPane, stackPane2);
        //        Scene scene = new Scene(vBox, 400, 400);
        //        primaryStage.setScene(scene);
        //        primaryStage.show();

        SelectBox<String> selectBox = new SelectBox<>(
                FXCollections.observableArrayList("Jeden", "Dwa", "Trzydafdasfsdadfsdaffsdafdsfdsa"));

        StackPane stackPane = new StackPane(selectBox);
        stackPane.setPrefSize(400, 400);
        stackPane.setStyle("-fx-background-color: rgb(60, 63, 65)");
        primaryStage.setScene(new Scene(stackPane));
        primaryStage.show();
        //        TableColumn<String, Employee> tableColumn = new TableColumn<>();
        //        tableColumn.setCellValueFactory(value);
    }
}

class Employee {

    private final String name;
    private final String surname;

    public Employee(String name, String surname) {
        super();
        this.name = name;
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

}