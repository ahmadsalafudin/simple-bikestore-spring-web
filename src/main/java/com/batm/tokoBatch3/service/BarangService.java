package com.batm.tokoBatch3.service;

import com.batm.tokoBatch3.model.Barang;

import java.util.List;

public interface BarangService {

	List<Barang> listbarang();

	Barang saveOrUpdate(Barang barang);

	Barang getIdUser(Integer id);

	void hapus(Integer id);

}
