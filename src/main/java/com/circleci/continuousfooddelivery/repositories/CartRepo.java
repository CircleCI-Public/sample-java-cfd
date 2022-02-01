package com.circleci.continuousfooddelivery.repositories;

import com.circleci.continuousfooddelivery.jpa.CartJpa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepo extends JpaRepository<CartJpa, String> {
}
