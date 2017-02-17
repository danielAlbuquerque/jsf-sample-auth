package br.com.daniel.beans;

import br.com.daniel.dao.LoginDAO;
import java.sql.SQLException;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;


@SessionScoped
@ManagedBean
public class Login {
    
    private static final long serialVersionUID = 1094801825228386363L;
    
    private String pwd;
    private String msg;
    private String user;
    
    
    /**
     * Creates a new instance of Login
     */
    public Login() {
    }

    public String validateUsernamePassword() throws SQLException {
        boolean valid = LoginDAO.validate(user, pwd);
        if(valid) {
            HttpSession session = SessionUtils.getSession();
            session.setAttribute("username", user);
            return "admin";
        }else{
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,"Incorrect Username and Passowrd", "Please enter correct username and Password"));
            return "login";
        }
    }
    
    public String logout() {
        return "";
    }
    
    /**
     * @return the pwd
     */
    public String getPwd() {
        return pwd;
    }

    /**
     * @param pwd the pwd to set
     */
    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    /**
     * @return the msg
     */
    public String getMsg() {
        return msg;
    }

    /**
     * @param msg the msg to set
     */
    public void setMsg(String msg) {
        this.msg = msg;
    }

    /**
     * @return the user
     */
    public String getUser() {
        return user;
    }

    /**
     * @param user the user to set
     */
    public void setUser(String user) {
        this.user = user;
    }
    
}
