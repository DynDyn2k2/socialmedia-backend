package com.socialmedia.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Types {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Long getId() {
        return id;
    }

    private String typeName;

    // Mối quan hệ 1 nhiều với bài ghim
    @OneToMany(mappedBy = "type")
    private List<Pins> pins = new ArrayList<>();

    public List<Pins> getPins() {
        return pins;
    }

    public void setPins(List<Pins> pins) {
        this.pins = pins;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

}