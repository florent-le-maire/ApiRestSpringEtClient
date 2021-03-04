package com.rest.api_train.service;

import com.rest.api_train.entity.BookTrain;
import com.rest.api_train.entity.Train;
import com.rest.api_train.repository.TrainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrainService {
    @Autowired
    private TrainRepository repository;

    public Train saveTrain(Train train){
        return repository.save(train);
    }

    public List<Train> saveTrains(List<Train> trains){
        return repository.saveAll(trains);
    }

    public List<Train> getTrains(){
        return repository.findAll();
    }
    public Train getTrainById(String id){
        return repository.findById(id).orElse(null);
    }

    public Train getTrainByVilleDepart(String villeDepart){
        return repository.findByVilleDepart(villeDepart);
    }

    public String deleteTrain(String id){

        try {
            repository.deleteById(id);
            return "remove"+id;
        }
        catch (Exception e){
            return null;
        }
    }
    public Train updateTrain(Train train){
        Train existingTrain = repository.findById(train.getNumTrain()).orElse(null);
        if(existingTrain != null){
            existingTrain.setVilleArrivee(train.getVilleArrivee());
            existingTrain.setHeureDepart(train.getHeureDepart());
            existingTrain.setVilleDepart(train.getVilleDepart());
            return repository.save(existingTrain);
        }
        return null;
    }

}
