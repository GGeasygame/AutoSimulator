package ch.ictbz.autosimulator.autoimulator;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;

public class Controller {
    @FXML
    private ComboBox comboBoxCars;
    @FXML
    private Label labelHorsePower;

    public void initialise() {
        // Fill combobox with cars
        ObservableList<Auto> autos = FXCollections.observableArrayList();
        autos.add(new Auto("Porsche", 250));
        autos.add(new Auto("Opel", 90));
        autos.add(new Auto("Ferrari", 370));
        comboBoxCars.setItems(autos);

    }

    @FXML
    private void onComboBoxCars() {
        // Select car
        Auto auto = (Auto)comboBoxCars.getValue();

        // Adjust ps display
        labelHorsePower.setText("PS: " + String.valueOf(auto.getPs()));

    }

    public void onButtonKey(ActionEvent actionEvent) {
    }

    public void onButtonHonk(ActionEvent actionEvent) {
    }

    public void onButtonBreak(ActionEvent actionEvent) {
    }

    public void onButtonAccelerate(ActionEvent actionEvent) {
    }
}