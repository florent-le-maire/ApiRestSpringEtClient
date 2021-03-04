package com.rest.api_train.controller;

import com.rest.api_train.entity.BookTrain;
import com.rest.api_train.entity.Train;
import com.rest.api_train.service.BookTrainService;
import com.rest.api_train.service.TrainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TrainController {

    @Autowired
    private TrainService service;

    @Autowired
    private BookTrainService serviceBookTrain;

    @PostMapping("/addtrain")
    public Train addTrain(@RequestBody Train train){
        return service.saveTrain(train);
    }

    @PostMapping("/addtrains")
    public List<Train> addTrains(@RequestBody List<Train> trains){
        return service.saveTrains(trains);
    }

    @GetMapping("/trains")
    public List<Train> findAllTrains(){
        return service.getTrains();
    }

    @GetMapping("/trainById/{id}")
    @ResponseBody
    public ResponseEntity<Train> findTrainById(@PathVariable String id){
        Train t = service.getTrainById(id);
        if(t == null){
            return new ResponseEntity<Train>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<Train>(t,HttpStatus.OK);
    }
    @GetMapping("/trainByVille/{ville}")
    @ResponseBody
    public ResponseEntity<Train> findTrainByVille(@PathVariable String ville){
        Train t =  service.getTrainByVilleDepart(ville);
        if(t == null){
            return new ResponseEntity<Train>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<Train>(t,HttpStatus.OK);
    }

    @PutMapping("/updatetrain")
    @ResponseBody
    public ResponseEntity<Train> updateTrain(@RequestBody Train train){
        System.out.println(train);
        Train t = service.updateTrain(train);
        if(t == null){
            return new ResponseEntity<Train>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<Train>(t,HttpStatus.OK);
    }

    @DeleteMapping("/deletetrain/{id}")
    @ResponseBody
    public ResponseEntity<String> deleteTrain(@PathVariable String id){
        List<BookTrain> bookTrains = serviceBookTrain.getBookTrains();
        for (BookTrain bk : bookTrains) {
            if (bk.getCurrentTrain().getNumTrain().equals(id)) {
                serviceBookTrain.deleteBookTrain(bk.getBookNumber());
            }
        }

        if(service.deleteTrain(id) == null){
            return new ResponseEntity<String>("Erreur lors de la suppression", HttpStatus.NOT_ACCEPTABLE);
        }
        return new ResponseEntity<String>("ok",HttpStatus.OK);
    }
}
