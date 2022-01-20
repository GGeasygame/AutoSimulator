module ch.ictbz.autosimulator.autoimulator {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;


    opens ch.ictbz.autosimulator.autoimulator to javafx.fxml;
    exports ch.ictbz.autosimulator.autoimulator;
}