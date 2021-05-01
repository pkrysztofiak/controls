package pl.pkrysztofiak.controls.segmentation;

import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.VBox;

public class SegmentationSelectBox extends VBox {

    public SegmentationSelectBox(ObservableList<Series> series, ObservableList<Segmentation> segmentations) {

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("SegmentationSelectBox"));

    }
}