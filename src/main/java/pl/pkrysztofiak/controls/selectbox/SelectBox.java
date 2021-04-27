package pl.pkrysztofiak.controls.selectbox;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.function.Function;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.ObjectPropertyBase;
import javafx.beans.value.ChangeListener;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Bounds;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.stage.Popup;

public class SelectBox<T> extends Region implements Initializable {

    private HBox root;

    private final ObservableList<T> items = FXCollections.observableArrayList();

    private final SelectBoxList<T> selectBoxList = new SelectBoxList<>(items);

    private final Popup popup = new Popup();

    @FXML
    private StackPane arrowButton;

    @FXML
    private Label selectedItemLabel;

    
    private final ObjectProperty<ObservableList<T>> itemsProperty = new ObjectPropertyBase<ObservableList<T>>() {

        @Override
        protected void invalidated() {
            items.setAll(get());
        }

        @Override
        public Object getBean() {
            return this;
        }

        @Override
        public String getName() {
            return "items";
        }
    };


    public SelectBox() {
        this(FXCollections.observableArrayList());
    }

    public SelectBox(ObservableList<T> items) {
        itemsProperty.set(items);
        loadFxml();
        getChildren().add(root);

        popup.getContent().setAll(selectBoxList);

        registerListeners();
    }

    public void setStringValueFactory(Function<T, String> toStringFunction) {
        selectBoxList.setStringValueFactory(toStringFunction);
    }

    private void loadFxml() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("SelectBox.fxml"));
        fxmlLoader.setController(this);
        try {
            root = fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void registerListeners() {
        arrowButton.setOnMouseClicked(event -> {
            Bounds localToScreen = localToScreen(getBoundsInLocal());
            popup.show(this, localToScreen.getMinX(), localToScreen.getMaxY() - 1);
            popup.setAutoHide(true);
        });

        selectBoxList.selectedItemProperty().addListener((ChangeListener<T>) (observable, oldValue, newValue) -> {
            if (newValue != null) {
                selectedItemLabel.setText(newValue.toString());
            }
        });
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    @Override
    protected double computeMinWidth(double height) {
        return root.minWidth(height);
    }

    @Override
    protected double computeMinHeight(double width) {
        return root.minHeight(width);
    }

    @Override
    protected double computePrefWidth(double height) {
        double selectBoxListPrefWidth = selectBoxList.prefWidth(height);
        double prefWidth = super.computePrefWidth(height);
        return Math.max(prefWidth, selectBoxListPrefWidth);
    }

    @Override
    protected double computeMaxWidth(double height) {
        return computePrefWidth(height);
    }

    @Override
    protected double computeMaxHeight(double width) {
        return computePrefHeight(width);
    }

    @Override
    protected void layoutChildren() {
        layoutInArea(root, 0., 0., getWidth(), getHeight(), 0, new Insets(0.), true, true, HPos.LEFT, VPos.TOP);
    }
}