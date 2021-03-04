package com.rest.api_train.service;

import com.rest.api_train.entity.BookTrain;
import com.rest.api_train.repository.BookTrainRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookTrainService {

    @Autowired
    private BookTrainRepository repository;

    public BookTrain saveBookTrain(BookTrain bookTrain) {
        return repository.save(bookTrain);
    }

    public List<BookTrain> saveBookTrains(List<BookTrain> bookTrains) {
        return repository.saveAll(bookTrains);
    }

    public List<BookTrain> getBookTrains() {
        return repository.findAll();
    }

    public BookTrain getBookTrainById(String id) {
        return repository.findById(id).orElse(null);
    }


    public String deleteBookTrain(String id) {
        try {
            repository.deleteById(id);
            return "remove" + id;
        } catch (Exception e) {
            return null;
        }
    }

    public BookTrain updateBookTrain(BookTrain bookTrain) {
        BookTrain existingBookTrain = repository.findById(bookTrain.getBookNumber()).orElse(null);
        existingBookTrain.setCurrentTrain(bookTrain.getCurrentTrain());
        existingBookTrain.setNumberPlaces(bookTrain.getNumberPlaces());
        return repository.save(existingBookTrain);
    }
}
