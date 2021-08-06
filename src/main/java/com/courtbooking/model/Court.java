package com.courtbooking.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "court")
public class Court implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, updatable = false)
    private long id;

    @Column(name = "court_name")
    String courtName;

    public Court() {
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setCourtName(String courtName) {
        this.courtName = courtName;
    }

    public long getId() {
        return id;
    }

    public String getCourtName() {
        return courtName;
    }
}
