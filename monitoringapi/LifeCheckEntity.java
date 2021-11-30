package com.example.monitoringapi;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.Instant;
import java.util.Objects;

@Table(name = "life_check")
@Entity
public class LifeCheckEntity {

    private @Id
    @GeneratedValue
    Long id;

    private Instant timestamp;

    private Boolean isOK;

    public LifeCheckEntity() {
    }

    public LifeCheckEntity(Instant timestamp, Boolean isOK) {
        this.timestamp = timestamp;
        this.isOK = isOK;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Instant getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Instant timestamp) {
        this.timestamp = timestamp;
    }

    public Boolean getOK() {
        return isOK;
    }

    public void setOK(Boolean OK) {
        isOK = OK;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LifeCheckEntity)) return false;
        LifeCheckEntity lifeCheckEntity = (LifeCheckEntity) o;
        return id.equals(lifeCheckEntity.id) && timestamp.equals(lifeCheckEntity.timestamp) && isOK.equals(lifeCheckEntity.isOK);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, timestamp, isOK);
    }

    @Override
    public String toString() {
        return "LifeCheck{" +
                "id=" + id +
                ", timestamp=" + timestamp +
                ", isOK=" + isOK +
                '}';
    }
}