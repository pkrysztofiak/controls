package pl.pkrysztofiak.controls.selectbox;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;

public class SelectBoxList<T> extends VBox implements Initializable {

    private final ObservableList<T> filteredItems;

    @FXML
    private ListView<T> listView;

    public SelectBoxList(ObservableList<T> items) {
        filteredItems = new FilteredList<>(items);
        loadFxml();
    }

    private void loadFxml() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("SelectBoxList.fxml"));
        fxmlLoader.setController(this);
        fxmlLoader.setRoot(this);
        
        try {
            fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        listView.setItems(filteredItems);
    }
}