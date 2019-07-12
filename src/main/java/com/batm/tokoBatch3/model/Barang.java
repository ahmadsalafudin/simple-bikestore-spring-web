package com.batm.tokoBatch3.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Version;

@Entity
public class Barang {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer idBarang;
	private String namaBarang;
	private Integer Jumlah;
	private Double Harga;

	@Version
	@Column(name = "optVersion", columnDefinition = "Integer DEFAULT 0")

	private Integer version;

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	public Integer getIdBarang() {
		return idBarang;
	}

	public void setIdBarang(Integer idBarang) {
		this.idBarang = idBarang;
	}

	public String getNamaBarang() {
		return namaBarang;
	}

	public void setNamaBarang(String namaBarang) {
		this.namaBarang = namaBarang;
	}

	public Integer getJumlah() {
		return Jumlah;
	}

	public void setJumlah(Integer jumlah) {
		Jumlah = jumlah;
	}

	public Double getHarga() {
		return Harga;
	}

	public void setHarga(Double harga) {
		Harga = harga;
	}

}
