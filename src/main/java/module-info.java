module ch.ictbz.autosimulator.autoimulator {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires java.desktop;


    opens ch.ictbz.autosimulator.autoimulator to javafx.fxml;
    exports ch.ictbz.autosimulator.autoimulator;
}