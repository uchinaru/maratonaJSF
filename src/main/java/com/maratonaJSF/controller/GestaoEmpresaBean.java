package com.maratonaJSF.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.convert.Converter;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.maratonaJSF.models.Empresa;
import com.maratonaJSF.models.RamoAtividade;
import com.maratonaJSF.models.TipoEmpresa;
import com.maratonaJSF.repository.Empresas;
import com.maratonaJSF.repository.RamoAtividades;
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
	@Inject
	private FacesMessages messages;
	@Inject
	private RamoAtividades ramoAtividades;
	private int totalEmp = 0;
	private Converter RamoAtividadeConverter;
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
		totalEmp = listaEmpresas.size();
		
		if (listaEmpresas.isEmpty()) {
			messages.info("Sem dados para exibir nesta pesquisa");
		}
	}
	
	public TipoEmpresa[] getTiposEmpresa() {
		return TipoEmpresa.values();
	}
	
	public List<RamoAtividade> completarRamoAtividade(String termo){
		
		List<RamoAtividade> listaRamoAtividade = ramoAtividades.pesquisar(termo);
		RamoAtividadeConverter = new RamoAtividadeConverter(listaRamoAtividade);
		
		return listaRamoAtividade;
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

	public Converter getRamoAtividadeConverter() {
		return RamoAtividadeConverter;
	}

	public void setRamoAtividadeConverter(Converter ramoAtividadeConverter) {
		RamoAtividadeConverter = ramoAtividadeConverter;
	}
	
	
}
