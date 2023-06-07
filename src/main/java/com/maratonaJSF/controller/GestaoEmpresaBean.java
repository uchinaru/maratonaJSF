package com.maratonaJSF.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.maratonaJSF.models.Empresa;
import com.maratonaJSF.repository.Empresas;
import com.maratonaJSF.util.FacesMessages;

@Named
// @RequestScoped // inicia por requis�o post, ao acessar ou enviar requi��es tais como click de buttons.
@ViewScoped //A sess�o se inicia ao usuario carregar ou acessar, e finaliza ao fechar ou outcome por qualquer componente com tal fun��o.
// @SessionScoped //A Sess�o inicia e finaliza com o carregamento no navegador.
// @ApplicationScoped // Uma unica sess�o existente por aplica��o rodando.
public class GestaoEmpresaBean implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	private Empresas empresas;
	
	private int totalEmp = 0;
	
	@Inject
	private FacesMessages messages;
	
	private List<Empresa> listaEmpresas;
	
	public void carregaEmpresas() {
		listaEmpresas = empresas.carregaEmpresas();
		totalEmp = listaEmpresas.size();
	}
	
	private String termoPesquisa;

	public List<Empresa> getListaEmpresas() {
		return listaEmpresas;
	}

	public void pesquisar() {
		listaEmpresas = empresas.pesquisar(termoPesquisa);
		
		if (listaEmpresas.isEmpty()) {
			messages.info("Sem dados para exibir nesta pesquisa");
		}
	}
	
	public int getTotalEmp() {
		return totalEmp;
	}

	public void setTotalEmp(int totalEmp) {
		this.totalEmp = totalEmp;
	}
	
	public String getTermoPesquisa() {
		return termoPesquisa;
	}
	
	public void setTermoPesquisa(String termoPesquisa) {
		this.termoPesquisa = termoPesquisa;
	}
}
