/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.batm.tokoBatch3.dao;

import com.batm.tokoBatch3.model.Barang;
import com.batm.tokoBatch3.service.BarangService;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class BarangDao implements BarangService{

    private EntityManagerFactory emf;

    
    @Autowired
    public void setEmf(EntityManagerFactory emf) {
        this.emf = emf;
    }
    
    
    @Override
    public List<Barang> listbarang() {
        EntityManager em = emf.createEntityManager();
        return em.createQuery("from Barang", Barang.class).getResultList();
        
    }

    @Override
    public Barang saveOrUpdate(Barang barang) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Barang saved = em.merge(barang);
        em.getTransaction().commit();
        return saved;
    
    }


	@Override
	public Barang getIdUser(Integer idBarang) {
		EntityManager em = emf.createEntityManager();
	return em.find(Barang.class, idBarang);
	}


	@Override
	public void hapus(Integer idBarang) {
		EntityManager  em =  emf.createEntityManager();
		em.getTransaction().begin();
		em.remove(em.find(Barang.class, idBarang));
		em.getTransaction().commit();
	}

}
