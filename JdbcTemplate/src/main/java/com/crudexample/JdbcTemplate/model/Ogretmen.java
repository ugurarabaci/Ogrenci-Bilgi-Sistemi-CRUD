package com.crudexample.JdbcTemplate.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Getter

public class Ogretmen {
    // bu class 'a model diyebiliriz
    // bu class bir POJO 'dur (plain old java object)
    private int id;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Ogretmen(int id, String name) {
        this.id = id;
        this.name = name;
    }
}