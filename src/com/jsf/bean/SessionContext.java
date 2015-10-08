package com.jsf.bean;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class SessionContext {
	private static SessionContext instance;
	 
	public static HttpSession getSession() {
	        return (HttpSession) FacesContext.getCurrentInstance()
	                .getExternalContext().getSession(false);
	    }
	public static HttpServletRequest getRequest() {
        return (HttpServletRequest) FacesContext.getCurrentInstance()
                .getExternalContext().getRequest();
    }
 
    public static String getUsuarioNome() {
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
                .getExternalContext().getSession(false);
        return session.getAttribute("usuario").toString();
    }
 
    public static String getUserId() {
        HttpSession session = SessionContext.getSession();
        if (session != null)
            return (String) session.getAttribute("usuario");
        else
            return null;
    }
	//Abaixo codigo novo
      
    private SessionContext(){
         
    }
    


}
