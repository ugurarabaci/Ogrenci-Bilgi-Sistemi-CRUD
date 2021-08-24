package com.crudexample.JdbcTemplate.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Getter
public class Ders {
    public Ders(int dersId, int ogretmenId, int konuId) {
        this.dersId = dersId;
        this.ogretmenId = ogretmenId;
        this.konuId = konuId;
    }

    // bu class 'a model diyebiliriz
    // bu class bir POJO 'dur (plain old java object)
    private int dersId;
    private int ogretmenId;

    public int getDersId() {
        return dersId;
    }

    public void setDersId(int dersId) {
        this.dersId = dersId;
    }

    public int getOgretmenId() {
        return ogretmenId;
    }

    public void setOgretmenId(int ogretmenId) {
        this.ogretmenId = ogretmenId;
    }

    public int getKonuId() {
        return konuId;
    }

    public void setKonuId(int konuId) {
        this.konuId = konuId;
    }

    private int konuId;
}