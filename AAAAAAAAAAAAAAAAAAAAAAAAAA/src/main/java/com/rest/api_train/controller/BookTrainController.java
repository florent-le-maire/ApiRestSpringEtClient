package com.rest.api_train.controller;


import com.rest.api_train.entity.BookTrain;
import com.rest.api_train.service.BookTrainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookTrainController {
    
    @Autowired
    private BookTrainService service;

    @PostMapping("/addbookTrain")
    public BookTrain addBookTrain(@RequestBody BookTrain bookTrain){
        return service.saveBookTrain(bookTrain);
    }

    @PostMapping("/addbookTrains")
    public List<BookTrain> addBookTrains(@RequestBody List<BookTrain> bookTrains){
        return service.saveBookTrains(bookTrains);
    }

    @GetMapping("/bookTrains")
    public List<BookTrain> findAllBookTrains(){
        return service.getBookTrains();
    }

    @GetMapping("/bookTrainById/{id}")
    @ResponseBody
    public ResponseEntity<BookTrain> findBookTrainById(@PathVariable String id){
        BookTrain t = service.getBookTrainById(id);
        if( t == null){
            return new ResponseEntity<BookTrain>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<BookTrain>(t,HttpStatus.OK);
    }

//    @PutMapping("/updatebookTrain")
//    public BookTrain updateBookTrain(@RequestBody BookTrain bookTrain){
//        return service.updateBookTrain(bookTrain);
//    }

    @DeleteMapping("/deletebookTrain/{id}")
    @ResponseBody
    public ResponseEntity<String> deleteBookTrain(@PathVariable String id){
        if(service.deleteBookTrain(id) == null){
            return new ResponseEntity<String>("Erreur lors de la suppression",HttpStatus.NOT_ACCEPTABLE);
        }
        return new ResponseEntity<String>("ok",HttpStatus.OK);
    }
}
