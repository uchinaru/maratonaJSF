package com.maratonaJSF.controller;

import java.io.Serializable;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

@Named
// @RequestScoped // inicia por requis�o post, ao acessar ou enviar requi��es tais como click de buttons.
@ViewScoped //A sess�o se inicia ao usuario carregar ou acessar, e finaliza ao fechar ou outcome por qualquer componente com tal fun��o.
// @SessionScoped //A Sess�o inicia e finaliza com o carregamento no navegador.
// @ApplicationScoped // Uma unica sess�o existente por aplica��o rodando.
public class GestaoEmpresaBean implements Serializable{
	private static final long serialVersionUID = 1L;
	private static Integer Numero = 0;
	
	public GestaoEmpresaBean() {
		Numero++;
	}
	
	public Integer getNumero() {
		return Numero; 
	}
}
