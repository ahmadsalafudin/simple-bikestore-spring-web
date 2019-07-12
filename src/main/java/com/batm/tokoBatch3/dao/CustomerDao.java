package com.batm.tokoBatch3.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.batm.tokoBatch3.model.Customer;
import com.batm.tokoBatch3.service.CustomerService;

	@Service
	public class CustomerDao implements CustomerService {

		private EntityManagerFactory emf;

		@Autowired
		public void setEmf(EntityManagerFactory emf) {
			this.emf = emf;
		}

		@Override
		public List<Customer> listCustomer() {
			EntityManager em = emf.createEntityManager();
			return em.createQuery("from Customer", Customer.class).getResultList();

		}

		@Override
		public Customer saveOrUpdate(Customer customer) {
			EntityManager em = emf.createEntityManager();
			em.getTransaction().begin();
			Customer saved = em.merge(customer);
			em.getTransaction().commit();
			return saved;

		}

		@Override
		public Customer getIdUser(Integer idCustomer) {
			EntityManager em = emf.createEntityManager();
			return em.find(Customer.class, idCustomer);
		}

		@Override
		public void hapus(Integer idCustomer) {
			EntityManager em = emf.createEntityManager();
			em.getTransaction().begin();
			em.remove(em.find(Customer.class, idCustomer));
			em.getTransaction().commit();
		}

	
}
