package ch.ictbz.autosimulator.autoimulator;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;

import java.io.IOException;

public class Application extends javafx.application.Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Auto Simulation");
        stage.setScene(scene);
        stage.show();
        Controller controller = fxmlLoader.getController();
        controller.initialise();
    }

    public static void main(String[] args) {
        launch();
    }
}