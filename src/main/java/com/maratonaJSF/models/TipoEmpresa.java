package com.maratonaJSF.models;

public enum TipoEmpresa {
	
	MEI("Microempreendedor Individual"),
	EIRELI("Empresa Individual de responsabilidade Limitada"),
	LTDA("Sociedade Limitada"),
	SA("Sociedade Anônima");
	
	private String descricao;
	
	private TipoEmpresa(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

}
