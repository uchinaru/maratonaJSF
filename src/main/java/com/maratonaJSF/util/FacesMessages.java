package com.maratonaJSF.util;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class FacesMessages implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private void add(String msg, FacesMessage.Severity serverity) {
		FacesMessage facesMessages = new FacesMessage(msg);
		facesMessages.setSeverity(serverity);
		
		FacesContext.getCurrentInstance().addMessage(null, facesMessages);
	}
	
	public void info(String info) {
		add(info, FacesMessage.SEVERITY_INFO);
	}

}
