/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jugendfeuerwehrleitstelle.objects;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Timo
 */
public class Einsatz {
    
    private int id;
    
    private String anruferName;
    private String anruferStraße;
    private String anruferOrt;
    private String anruferTelefon;
    
    private String einsatzStraße;
    private String einsatzHausnummer;
    private String einsatzPLZ;
    private String einsatzOrt;
    private String einsatzKreuzung;
    
    private String stichwort;
    private String beschreibung;
    
    private Date einsatzDatum;
    private Date einsatzZeit;

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the anruferName
     */
    public String getAnruferName() {
        return anruferName;
    }

    /**
     * @param anruferName the anruferName to set
     */
    public void setAnruferName(String anruferName) {
        this.anruferName = anruferName;
    }

    /**
     * @return the anruferStraße
     */
    public String getAnruferStraße() {
        return anruferStraße;
    }

    /**
     * @param anruferStraße the anruferStraße to set
     */
    public void setAnruferStraße(String anruferStraße) {
        this.anruferStraße = anruferStraße;
    }

    /**
     * @return the anruferOrt
     */
    public String getAnruferOrt() {
        return anruferOrt;
    }

    /**
     * @param anruferOrt the anruferOrt to set
     */
    public void setAnruferOrt(String anruferOrt) {
        this.anruferOrt = anruferOrt;
    }

    /**
     * @return the anruferTelefon
     */
    public String getAnruferTelefon() {
        return anruferTelefon;
    }

    /**
     * @param anruferTelefon the anruferTelefon to set
     */
    public void setAnruferTelefon(String anruferTelefon) {
        this.anruferTelefon = anruferTelefon;
    }

    /**
     * @return the einsatzStraße
     */
    public String getEinsatzStraße() {
        return einsatzStraße;
    }

    /**
     * @param einsatzStraße the einsatzStraße to set
     */
    public void setEinsatzStraße(String einsatzStraße) {
        this.einsatzStraße = einsatzStraße;
    }

    /**
     * @return the einsatzHausnummer
     */
    public String getEinsatzHausnummer() {
        return einsatzHausnummer;
    }

    /**
     * @param einsatzHausnummer the einsatzHausnummer to set
     */
    public void setEinsatzHausnummer(String einsatzHausnummer) {
        this.einsatzHausnummer = einsatzHausnummer;
    }

    /**
     * @return the einsatzPLZ
     */
    public String getEinsatzPLZ() {
        return einsatzPLZ;
    }

    /**
     * @param einsatzPLZ the einsatzPLZ to set
     */
    public void setEinsatzPLZ(String einsatzPLZ) {
        this.einsatzPLZ = einsatzPLZ;
    }

    /**
     * @return the einsatzOrt
     */
    public String getEinsatzOrt() {
        return einsatzOrt;
    }

    /**
     * @param einsatzOrt the einsatzOrt to set
     */
    public void setEinsatzOrt(String einsatzOrt) {
        this.einsatzOrt = einsatzOrt;
    }

    /**
     * @return the einsatzKreuzung
     */
    public String getEinsatzKreuzung() {
        return einsatzKreuzung;
    }

    /**
     * @param einsatzKreuzung the einsatzKreuzung to set
     */
    public void setEinsatzKreuzung(String einsatzKreuzung) {
        this.einsatzKreuzung = einsatzKreuzung;
    }

    /**
     * @return the stichwort
     */
    public String getStichwort() {
        return stichwort;
    }

    /**
     * @param stichwort the stichwort to set
     */
    public void setStichwort(String stichwort) {
        this.stichwort = stichwort;
    }

    /**
     * @return the beschreibung
     */
    public String getBeschreibung() {
        return beschreibung;
    }

    /**
     * @param beschreibung the beschreibung to set
     */
    public void setBeschreibung(String beschreibung) {
        this.beschreibung = beschreibung;
    }

    /**
     * @return the einsatzDatum
     */
    public Date getEinsatzDatum() {
        return einsatzDatum;
    }

    /**
     * @param einsatzDatum the einsatzDatum to set
     */
    public void setEinsatzDatum(Date einsatzDatum) {
        this.einsatzDatum = einsatzDatum;
    }

    /**
     * @return the einsatzZeit
     */
    public Date getEinsatzZeit() {
        return einsatzZeit;
    }

    /**
     * @param einsatzZeit the einsatzZeit to set
     */
    public void setEinsatzZeit(Date einsatzZeit) {
        this.einsatzZeit = einsatzZeit;
    }

    public Einsatz() {
    }

    public Einsatz(int id, String anruferName, String anruferStraße, String anruferOrt, String anruferTelefon, String einsatzStraße, String einsatzHausnummer, String einsatzPLZ, String einsatzOrt, String einsatzKreuzung, String stichwort, String beschreibung, Date einsatzDatum, Date einsatzZeit) {
        this.id = id;
        this.anruferName = anruferName;
        this.anruferStraße = anruferStraße;
        this.anruferOrt = anruferOrt;
        this.anruferTelefon = anruferTelefon;
        this.einsatzStraße = einsatzStraße;
        this.einsatzHausnummer = einsatzHausnummer;
        this.einsatzPLZ = einsatzPLZ;
        this.einsatzOrt = einsatzOrt;
        this.einsatzKreuzung = einsatzKreuzung;
        this.stichwort = stichwort;
        this.beschreibung = beschreibung;
        this.einsatzDatum = einsatzDatum;
        this.einsatzZeit = einsatzZeit;
    }

    @Override
    public String toString() {
        
        DateFormat dfDate = new SimpleDateFormat("dd.MM.yy");
        DateFormat dfTime = new SimpleDateFormat("HH:mm");
        
        return id + " | "+ dfDate.format(einsatzDatum) + " " + dfTime.format(einsatzZeit) + " | " + einsatzOrt + " | " + stichwort;
    }
    
    
    
    
}
