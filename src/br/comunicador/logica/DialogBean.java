package br.comunicador.logica;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.primefaces.context.RequestContext;




@ManagedBean
@SessionScoped
public class DialogBean {  
    
    public void showMessage() {  
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "What we do in life", "Echoes in eternity.");  
          
        RequestContext.getCurrentInstance().showMessageInDialog(message);  
    }  
}  