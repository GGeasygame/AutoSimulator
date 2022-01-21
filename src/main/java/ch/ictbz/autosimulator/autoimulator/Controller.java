package ch.ictbz.autosimulator.autoimulator;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

public class Controller {
    @FXML
    private TextField textFieldSpeed;
    @FXML
    private TextField textFieldGear;
    @FXML
    private Button onIdButtonAccelerate;
    @FXML
    private Button onIdButtonBreak;
    @FXML
    private ComboBox comboBoxCars;
    @FXML
    private Label labelHorsePower;

    private Auto auto;
    private Timer drive;
    private boolean driveTimerIsOn = false;
    private Timer speedTimer;
    private Timer breakTimer;

    public void initialise() {
        // Fill combobox with cars
        ObservableList<Auto> autos = FXCollections.observableArrayList();
        autos.add(new Auto("Porsche", 250));
        autos.add(new Auto("Opel", 90));
        autos.add(new Auto("Ferrari", 370));
        comboBoxCars.setItems(autos);


    }

    private void drive() {
        onComboBoxCars();
        onIdButtonAccelerate.setOnMousePressed(event -> {
            speedTimer = new Timer();
            TimerTask timerTaskSpeed = new TimerTask() {
                @Override
                public void run() {
                    auto.gibGas();
                    updateSpeedGear();
                }
            };
            speedTimer.schedule(timerTaskSpeed, 1, 1000);

        });
        onComboBoxCars();
        onIdButtonAccelerate.setOnMouseReleased(event -> {
            speedTimer.cancel();
        });
        onComboBoxCars();
        onIdButtonBreak.setOnMousePressed(event -> {
            breakTimer = new Timer();
            TimerTask timerTaskBreak = new TimerTask() {
                @Override
                public void run() {
                    auto.bremse();
                    updateSpeedGear();
                }
            };
            breakTimer.schedule(timerTaskBreak, 1, 1000);
        });
        onComboBoxCars();
        onIdButtonBreak.setOnMouseReleased(event -> {
            breakTimer.cancel();
        });
        onComboBoxCars();



        onComboBoxCars();
    }
    private void updateSpeedGear() {
        textFieldSpeed.setText(String.valueOf(auto.getAktuelleGeschwindigkeit()));
        textFieldGear.setText(String.valueOf(auto.getAktuellerGang()));
    }


    @FXML
    private void onComboBoxCars() {
        // Select car
        auto = (Auto) comboBoxCars.getValue();

        // Adjust ps display
        labelHorsePower.setText("PS: " + String.valueOf(auto.getPs()));

    }

    public void onButtonKey() {
        if (auto.getMotorStatus())
            auto.schalteMotorAus();
        else
            auto.starteMotor();

        if (driveTimerIsOn) {
            drive.cancel();
            driveTimerIsOn = false;
        } else {
            drive = new Timer();
            TimerTask timerTaskDrive = new TimerTask() {
                @Override
                public void run() {
                    if (auto != null) {
                        drive();
                    }
                }
            };
            drive.schedule(timerTaskDrive, 1, 200);
            driveTimerIsOn = true;
        }


    }


    public void onButtonHonk() throws LineUnavailableException, IOException, UnsupportedAudioFileException {
        auto.hupe();
    }
}