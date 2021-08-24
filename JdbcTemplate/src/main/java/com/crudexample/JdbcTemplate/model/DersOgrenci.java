package com.crudexample.JdbcTemplate.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@Getter
public class DersOgrenci
{
	private int kayitId;

	private int ogrenciId;

	public int getKayitId() {
		return kayitId;
	}

	public void setKayitId(int kayitId) {
		this.kayitId = kayitId;
	}

	public int getOgrenciId() {
		return ogrenciId;
	}

	public void setOgrenciId(int ogrenciId) {
		this.ogrenciId = ogrenciId;
	}

	public int getDersId() {
		return dersId;
	}

	public void setDersId(int dersId) {
		this.dersId = dersId;
	}

	private int dersId;

	public DersOgrenci(int kayitId, int ogrenciId, int dersId) {
		this.kayitId = kayitId;
		this.ogrenciId = ogrenciId;
		this.dersId = dersId;
	}
}