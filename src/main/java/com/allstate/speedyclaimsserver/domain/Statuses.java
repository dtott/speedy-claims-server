package com.allstate.speedyclaimsserver.domain;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

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

    public Statuses(Integer id, String status, String description, boolean open) {
        this.id = id;
        this.status = status;
        this.description = description;
        this.open = open;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isOpen() {
        return open;
    }

    public void setOpen(boolean open) {
        this.open = open;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Statuses statuses = (Statuses) o;
        return Objects.equals(id, statuses.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}


