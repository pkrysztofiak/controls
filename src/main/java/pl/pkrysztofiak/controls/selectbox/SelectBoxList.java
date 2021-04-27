package pl.pkrysztofiak.controls.selectbox;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.function.Function;

import javafx.beans.property.ReadOnlyObjectProperty;
import javafx.beans.value.ChangeListener;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class SelectBoxList<T> extends VBox implements Initializable {

    private final FilteredList<T> filteredItems;

    @FXML
    private ListView<T> listView;

    @FXML
    private TextField filterTextField;

    private Function<T, String> toStringFunction = t -> t.toString();

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
        listView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        registerListeners();
    }

    private void registerListeners() {
        filterTextField.textProperty().addListener((ChangeListener<String>) (observable, oldValue, filterText) -> {
            if (filterText != null && !filterText.isEmpty()) {
                filteredItems.setPredicate(t -> toStringFunction.apply(t).contains(filterText));
            } else {
                filteredItems.setPredicate(t -> true);
            }
        });
    }

    public ReadOnlyObjectProperty<T> selectedItemProperty() {
        return listView.getSelectionModel().selectedItemProperty();
    }

    public void setStringValueFactory(Function<T, String> toStringFunction) {
        this.toStringFunction = toStringFunction;
    }

    @Override
    protected double computePrefWidth(double height) {
        return super.computePrefWidth(height);
    }
}