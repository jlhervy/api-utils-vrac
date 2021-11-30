package com.example.monitoringapi;

import org.springframework.data.jpa.repository.JpaRepository;

public interface LifeCheckRepository extends JpaRepository<LifeCheckEntity, Long> {

}