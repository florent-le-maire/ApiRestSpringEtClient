package com.rest.api_train.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Train {
    @Id
    private String numTrain;
    private String villeDepart;
    private String villeArrivee;
    private int heureDepart; // Format : 1230 = 12h30

    public String getNumTrain() {
        return numTrain;
    }

    public String getVilleDepart() {
        return villeDepart;
    }

    public String getVilleArrivee() {
        return villeArrivee;
    }

    public int getHeureDepart() {
        return heureDepart;
    }

    public void setNumTrain(String numTrain) {
        this.numTrain = numTrain;
    }

    public void setVilleDepart(String villeDepart) {
        this.villeDepart = villeDepart;
    }

    public void setVilleArrivee(String villeArrivee) {
        this.villeArrivee = villeArrivee;
    }

    public void setHeureDepart(int heureDepart) {
        this.heureDepart = heureDepart;
    }

    @OneToMany(mappedBy = "currentTrain")
    private Set<BookTrain> bookTrains;


    @Override
    public String toString() {
        return "Train{" +
                "numTrain='" + numTrain + '\'' +
                ", villeDepart='" + villeDepart + '\'' +
                ", villeArrivee='" + villeArrivee + '\'' +
                ", heureDepart=" + heureDepart +
                '}';
    }
}
