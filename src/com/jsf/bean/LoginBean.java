package com.jsf.bean;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@ManagedBean
@SessionScoped
public class LoginBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String usuario;
	private String senha;
	public boolean usuarioLogado;
	
	public static boolean validate(String usuario, String senha) {
		if(usuario.equals("admin") && senha.equals("admin") ){
			return true;
		}else{
			return false;
		}
	}
	
	public String getSenha() {
		return senha;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	
	public String loginValidacao() {
        boolean valid = validate(this.usuario, this.senha);
        if (valid) {
            HttpSession session = SessionContext.getSession();
            session.setAttribute("usuario", usuario);
            return "index?faces-redirect=true";
        } else {
            FacesContext.getCurrentInstance().addMessage(
                    null,  new FacesMessage(FacesMessage.SEVERITY_WARN,
                            "Usuário ou Senha Incorretos!",
                            "Porfavor informe usuario e senha corretos!"));
            return "login";
        }
    }
 
    //logout event, invalidate session
    public String logout() {
        HttpSession session = SessionContext.getSession();
        session.invalidate();
        return "login?faces-redirect=true";
    }
	
    public boolean isUsuarioLogado() {
		return usuarioLogado;
	}
    public void setUsuarioLogado(boolean usuarioLogado) {
		this.usuarioLogado = usuarioLogado;
	}
   
    
}
