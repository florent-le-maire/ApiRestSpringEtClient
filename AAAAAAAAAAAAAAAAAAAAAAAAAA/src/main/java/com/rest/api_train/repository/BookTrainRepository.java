package com.rest.api_train.repository;

import com.rest.api_train.entity.BookTrain;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookTrainRepository extends JpaRepository<BookTrain, String> {
}
