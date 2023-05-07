package com.maratonaJSF.service;

import java.io.Serializable;

import javax.inject.Inject;

import com.maratonaJSF.models.Empresa;
import com.maratonaJSF.repository.Empresas;
import com.maratonaJSF.util.Transacional;

public class CadastroEmpresaService implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private Empresas empresas;

    @Transacional
    public void salvar(Empresa empresa) {
        empresas.guardar(empresa);
    }

    @Transacional
    public void excluir(Empresa empresa) {
        empresas.remover(empresa);
    }

}