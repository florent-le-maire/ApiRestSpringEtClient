package com.rest.api_train.repository;

import com.rest.api_train.entity.Train;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrainRepository extends JpaRepository<Train, String> {
    Train findByVilleDepart(String villeDepart);
}
