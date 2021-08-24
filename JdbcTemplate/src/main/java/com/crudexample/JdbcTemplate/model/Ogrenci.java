package com.crudexample.JdbcTemplate.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
public class Ogrenci {
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // bu class 'a model diyebiliriz
    // bu class bir POJO 'dur (plain old java object)
    private int id;

    private int number;

    private String name;

    public Ogrenci(int id, int number, String name) {
        this.id = id;
        this.number = number;
        this.name = name;
    }

    @Override
    public String toString() {
        return id + " - " + number + " - " + name;
    }
}