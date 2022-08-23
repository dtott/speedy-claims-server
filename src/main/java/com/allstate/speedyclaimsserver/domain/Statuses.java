package com.allstate.speedyclaimsserver.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Statuses {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String status;
    private String description;
    private boolean open;

    public Statuses() {
    }

    public String getStatus() {
        return status;
    }

    public String getDescription() {
        return description;
    }

    public boolean isOpen() {
        return open;
    }
}
