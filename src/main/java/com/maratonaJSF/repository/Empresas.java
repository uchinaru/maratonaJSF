package com.maratonaJSF.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.maratonaJSF.models.Empresa;

public class Empresas implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager manager;

	public Empresas() {

	}

	public Empresas(EntityManager manager) {
		this.manager = manager;
	}

	public Empresa porId(Long id) {
		return manager.find(Empresa.class, id); // buscando empresa por seu ID na model empresa.class
	}

	@SuppressWarnings("unchecked")
	public List<Empresa> pesquisar(String nome) {
		Query query = manager.createQuery("from Empresa where nomeFantasia like :nomeFantasia");
		query.setParameter("nomeFantasia", nome + "%");
		
		return query.getResultList();
	}

	public Empresa guardar(Empresa empresa) {
		
		return manager.merge(empresa); //Inserindo no banco a empresa informada
	}

	public void remover(Empresa empresa) {
		empresa = porId(empresa.getId());
		manager.remove(empresa); // somente remove e que estiver no contexto do EntityManager
	}
}
