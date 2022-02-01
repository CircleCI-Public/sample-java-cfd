package com.circleci.continuousfooddelivery.repositories;

import com.circleci.continuousfooddelivery.jpa.MenuItemJpa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MenuRepo extends JpaRepository<MenuItemJpa, Integer> {
}
