package com.maratonaJSF.controller;

import java.io.Serializable;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

@Named
// @RequestScoped // inicia por requisão post, ao acessar ou enviar requições tais como click de buttons.
@ViewScoped //A sessão se inicia ao usuario carregar ou acessar, e finaliza ao fechar ou outcome por qualquer componente com tal função.
// @SessionScoped //A Sessão inicia e finaliza com o carregamento no navegador.
// @ApplicationScoped // Uma unica sessão existente por aplicação rodando.
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
