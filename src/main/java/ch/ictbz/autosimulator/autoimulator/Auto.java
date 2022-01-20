package ch.ictbz.autosimulator.autoimulator;

import java.util.Timer;
import java.util.TimerTask;

public class Auto {
    private String marke;
    private int ps;
    private int aktuelleGeschwindigkeit;
    private int aktuellerGang;
    private boolean istMotorGestartet;

    public Auto(String marke, int ps) {
        setMarke(marke);
        setPs(ps);
    }


    // setters and getters
    public String getMarke() { return marke; }
    public void setMarke(String marke) { this.marke = marke; }
    public int getPs() { return ps; }
    public void setPs(int ps) { this.ps = ps; }
    public int getAktuelleGeschwindigkeit() { return aktuelleGeschwindigkeit; }
    public int getAktuellerGang() { return aktuellerGang; }

    public void starteMotor() {

    }
    public void schalteMotorAus() {

    }
    public void gibGas() {
        Timer speedTimer = new Timer();
        speedTimer.schedule(timerTaskSpeed, 1000);
        aktuelleGeschwindigkeit += 5 * Math.sqrt(ps);
    }
    TimerTask timerTaskSpeed = new TimerTask() {
        @Override
        public void run() {
            // Continue here
        }
    };


    public void bremse() {

    }
    public void hupe() {

    }

    @Override
    public String toString() {
        return this.getMarke();
    }

}
