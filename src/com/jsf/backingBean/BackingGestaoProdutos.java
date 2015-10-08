package com.jsf.backingBean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;


@ManagedBean(name="gpBacking2")
@ViewScoped
public class BackingGestaoProdutos {
	
	private boolean campoEditavel= false;
	
	public void botaoEdiar(){
		if(isCampoEditavel()){
			this.campoEditavel = false;
		}else{
			this.campoEditavel = true;
		}
	}
	public boolean isCampoEditavel() {
		return campoEditavel;
	}
	public void setCampoEditavel(boolean campoEditavel) {
		this.campoEditavel = campoEditavel;
	}
}
