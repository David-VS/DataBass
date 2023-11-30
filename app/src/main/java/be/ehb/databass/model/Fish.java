package be.ehb.databass.model;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity
public class Fish {

    @PrimaryKey(autoGenerate = true)
    private int id;
    private String naam;
    private String kleur;

    public Fish() {
    }

    @Ignore
    public Fish(int id, String naam, String kleur) {
        this.id = id;
        this.naam = naam;
        this.kleur = kleur;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public String getKleur() {
        return kleur;
    }

    public void setKleur(String kleur) {
        this.kleur = kleur;
    }
}
