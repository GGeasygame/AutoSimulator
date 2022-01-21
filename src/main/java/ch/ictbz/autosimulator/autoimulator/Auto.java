package ch.ictbz.autosimulator.autoimulator;

import javax.sound.sampled.*;
import java.io.IOException;

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
    public int getAktuellerGang() {
        aktuellerGang = 1;
        if (getAktuelleGeschwindigkeit() <= 10) aktuellerGang = 1;
        else if (getAktuelleGeschwindigkeit() > 10 && getAktuelleGeschwindigkeit() <= 20) aktuellerGang = 2;
        else if (getAktuelleGeschwindigkeit() > 20 && getAktuelleGeschwindigkeit() <= 40) aktuellerGang = 3;
        else if (getAktuelleGeschwindigkeit() > 40 && getAktuelleGeschwindigkeit() <= 70) aktuellerGang = 4;
        else if (getAktuelleGeschwindigkeit() > 70 && getAktuelleGeschwindigkeit() <= 100) aktuellerGang = 5;
        else if (getAktuelleGeschwindigkeit() > 100) aktuellerGang = 6;
        return aktuellerGang;
    }
    public boolean getMotorStatus() { return istMotorGestartet; }


    public void starteMotor() {
        istMotorGestartet = true;
    }
    public void schalteMotorAus() {
        istMotorGestartet = false;
    }
    public void gibGas() {
        if (istMotorGestartet) {
            if (aktuelleGeschwindigkeit + ps / 10 <= ps)
                aktuelleGeschwindigkeit += ps / 10;
            else
                aktuelleGeschwindigkeit = ps;
        }
    }


    public void bremse() {

        if  (aktuelleGeschwindigkeit - ps / 10 >= 0)
            aktuelleGeschwindigkeit -= ps / 10;
        else
            aktuelleGeschwindigkeit = 0;
    }

    public void hupe() throws LineUnavailableException, IOException, UnsupportedAudioFileException {
        AudioInputStream audioInputStream =
                AudioSystem.getAudioInputStream(
                        this.getClass().getResource("sound/Car-Horn.wav"));
        Clip clip = AudioSystem.getClip();
        clip.open(audioInputStream);
        clip.start();
    }

    @Override
    public String toString() {
        return this.getMarke();
    }

}
