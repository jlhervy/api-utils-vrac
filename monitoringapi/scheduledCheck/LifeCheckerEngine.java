package com.example.monitoringapi.scheduledCheck;

import com.example.monitoringapi.LifeCheckEntity;
import com.example.monitoringapi.LifeCheckRepository;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.logging.Logger;

@Service
public class LifeCheckerEngine {

    static final Logger LOGGER =
            Logger.getLogger(LifeCheckerEngine.class.getName());


    private final LifeCheckRepository repository;

    public LifeCheckerEngine(LifeCheckRepository repository) {
        this.repository = repository;
    }

    @Scheduled(fixedRateString = "${interval}")
    @Async
    public void computePrice() {
        LifeCheckEntity entity = new LifeCheckEntity(Instant.now(), Boolean.TRUE);
        this.repository.save(entity);
        LOGGER.info("New entity has been saved"+
                LocalDateTime.now().toEpochSecond(ZoneOffset.UTC));
    }

}
