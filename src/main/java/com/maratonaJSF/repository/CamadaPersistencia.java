package com.maratonaJSF.repository;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.maratonaJSF.models.Empresa;
import com.maratonaJSF.models.RamoAtividade;
import com.maratonaJSF.models.TipoEmpresa;

public class CamadaPersistencia {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("projeto_jpa");

        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin(); // Necessario em casos de inser��o de dados, caso seja feito sem, os valores ser�o perdidos.

        // Declarando os reposit�rios
        RamoAtividades ramoAtividades = new RamoAtividades(em);
        Empresas empresas = new Empresas(em);

        // Buscando as informa��es do banco
        List<RamoAtividade> listaDeRamoAtividades = ramoAtividades.pesquisar("");
        List<Empresa> listaDeEmpresas = empresas.pesquisar("");
        System.out.println(listaDeEmpresas);

        // Criando uma empresa
        Empresa empresa = new Empresa();
        empresa.setNomeFantasia("Jo�o da Silva");
        empresa.setCnpj("41.952.519/0001-57");
        empresa.setRazaoSocial("Jo�o da Silva 41952519000157");
        empresa.setTipo(TipoEmpresa.MEI);
        empresa.setDataFundacao(new Date());
        empresa.setRamoAtividade(listaDeRamoAtividades.get(0));

        // Salvando a empresa
        empresas.guardar(empresa);

        em.getTransaction().commit();

        // Verificando se a inser��o funcionou
        List<Empresa> listaDeEmpresas2 = empresas.pesquisar("");
        System.out.println(listaDeEmpresas2);

        em.close();
        emf.close();
    }

}