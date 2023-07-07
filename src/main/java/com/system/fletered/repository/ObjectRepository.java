package com.system.fletered.repository;

import com.system.fletered.entities.Object;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ObjectRepository extends JpaRepository<Object, Long> {
}