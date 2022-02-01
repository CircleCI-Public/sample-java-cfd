package com.circleci.continuousfooddelivery.repositories;

import com.circleci.continuousfooddelivery.jpa.ImageJpa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageRepo extends JpaRepository<ImageJpa, Integer> {
}
