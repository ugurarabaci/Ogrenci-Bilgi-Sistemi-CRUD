package com.crudexample.JdbcTemplate.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@Getter
public class Konu {
	// bu class 'a model diyebiliriz
	// bu class bir POJO 'dur (plain old java object)
	private int id;
	private String konu;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getKonu() {
		return konu;
	}

	public void setKonu(String konu) {
		this.konu = konu;
	}

	public Konu(int id, String konu) {
		this.id = id;
		this.konu = konu;
	}
}