package com.maratonaJSF.controller;

import java.util.List;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

import com.maratonaJSF.models.RamoAtividade;

public class RamoAtividadeConverter implements Converter {

	private List<RamoAtividade> listaRamoAtividade;
	
	public RamoAtividadeConverter(List<RamoAtividade> listaRamoAtividade) {
		this.listaRamoAtividade = listaRamoAtividade;
	};
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		if (value == null) {
			return null;
		}

		Long id = Long.parseLong(value);

		for (RamoAtividade ramoAtividade : listaRamoAtividade) {
			if (id.equals(ramoAtividade.getId())) {
				return ramoAtividade;
			}
		}

		return null;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if(value == null) {
			return null;
		}
		
		RamoAtividade ramoAtividade = (RamoAtividade) value;
		
		return ramoAtividade.getId().toString();
	}

}
