/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.daniel.beans;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author DanielAlbuquerque
 */
public class SessionUtils {
    public static HttpSession getSession() {
        return (HttpSession) FacesContext.getCurrentInstance()
                .getExternalContext().getSession(false);
    }
    
    public static HttpServletRequest getRequest() {
        return (HttpServletRequest) FacesContext.getCurrentInstance()
				.getExternalContext().getRequest();
    }
    
    public static String getUserName() {
        HttpSession session = getSession();
        return session.getAttribute("username").toString();
    }
    
    public static String getUserId() {
        HttpSession session = getSession();
        if(session != null) {
            return (String)session.getAttribute("userId");
        } else {
            return null;
        }
    }
}
