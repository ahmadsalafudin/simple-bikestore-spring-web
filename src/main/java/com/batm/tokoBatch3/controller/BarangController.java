package com.batm.tokoBatch3.controller;

import com.batm.tokoBatch3.model.Barang;
import com.batm.tokoBatch3.service.BarangService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller

public class BarangController {

	private BarangService barangService;

	@Autowired
	public void setBarangService(BarangService barangService) {
		this.barangService = barangService;
	}

	@RequestMapping("/barang")
	public String barang(Model model) {
		model.addAttribute("barang", barangService.listbarang());
		return "barang";
	}

	@RequestMapping(value = "/barang/create", method = RequestMethod.GET)
	public String tampilkanForm(Model model) {

		model.addAttribute("barang", new Barang());
		return "formAddBarang";
	}

	@RequestMapping(value = "/barang/create", method = RequestMethod.POST)
	public String simpanDataBarang(Model model, Barang barang) {
		model.addAttribute("barang", barangService.saveOrUpdate(barang));
		return "redirect:/barang";
	}

	@RequestMapping(value = "/barang/edit/{idBarang}", method = RequestMethod.GET)
	public String editData(@PathVariable Integer idBarang, Model model) {
		model.addAttribute("barang", barangService.getIdUser(idBarang));
		return "formEditBarang";
	}

	@RequestMapping(value = "/barang/hapus/{idBarang}")
	public String hapus(@PathVariable Integer idBarang) {
		barangService.hapus(idBarang);
		return "redirect:/barang";
	}
}
