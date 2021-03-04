package com.rest.api_train.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Entity
public class BookTrain {
    @Id
    private String bookNumber;

    @ManyToOne()
    private Train currentTrain;
    private int numberPlaces;

    public String getBookNumber() {
        return bookNumber;
    }

    public Train getCurrentTrain() {
        return currentTrain;
    }

    public int getNumberPlaces() {
        return numberPlaces;
    }

    public void setBookNumber(String bookNumber) {
        this.bookNumber = bookNumber;
    }

    public void setCurrentTrain(Train currentTrain) {
        this.currentTrain = currentTrain;
    }

    public void setNumberPlaces(int numberPlaces) {
        this.numberPlaces = numberPlaces;
    }
}
