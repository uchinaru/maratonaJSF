package com.maratonaJSF.repository;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import com.maratonaJSF.models.Empresa;

public class SchemaGeneration {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("projeto_jpa");
		EntityManager em = emf.createEntityManager();
		
		List<Empresa> lista = em.createQuery("from Empresa", Empresa.class).getResultList();
		
		for (Empresa empresa : lista) {
			
			System.out.println("ID: " + empresa.getId() +" Nome: "+ empresa.getNomeFantasia());
		}
	}
}
