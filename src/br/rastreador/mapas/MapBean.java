package br.rastreador.mapas;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import org.primefaces.event.map.OverlaySelectEvent;
import org.primefaces.model.map.DefaultMapModel;
import org.primefaces.model.map.LatLng;
import org.primefaces.model.map.MapModel;
import org.primefaces.model.map.Polyline;

import br.comunicador.baseDados.ManipulaBanco;
 

@ManagedBean
public class MapBean implements Serializable {  
  
	private MapModel polylineModel;  
	private String latitude ;
    private String longitude ;
	  
    public MapBean() {  
        polylineModel = new DefaultMapModel(); 

          
        //Shared coordinates  
        LatLng coord1 = new LatLng(-33.6,-46.5);  
        LatLng coord2 = new LatLng(-53.10,-45.90770883560045);  
        LatLng coord3 = new LatLng(-33.10815111110, -45.95970883560045); 
      
        
        LatLng coord4 = new LatLng(-25.10815111110, -45.70770883560045);  
      
        //Polyline  
        Polyline polyline = new Polyline();  
        polyline.getPaths().add(coord1);  
        polyline.getPaths().add(coord2);  
        polyline.getPaths().add(coord3);  
        polyline.getPaths().add(coord4);  
          
        polyline.setStrokeWeight(10);  
        polyline.setStrokeColor("#FF9900");  
        polyline.setStrokeOpacity(0.7);  
          
        polylineModel.addOverlay(polyline);  
    }  
  
    public MapModel getPolylineModel() {  
        return polylineModel;  
    } 
    
    public String getLatitude() {  
    	ManipulaBanco mb = new ManipulaBanco();
    	String s[] = mb.buscaCordenanda();
    	latitude = s[0];
    	System.out.println("latitude read  : "+s[0] + " longitude read : " + s[1]);
        return latitude;  
    }  
    
    public String getLongitude() { 
    	ManipulaBanco mb = new ManipulaBanco();
    	String s[] = mb.buscaCordenanda();
    	longitude = s[1];
    	System.out.println("latitude read  : "+s[0] + " longitude read : " + s[1]);
    	
        return longitude;  
    } 
    
    public void onPolylineSelect(OverlaySelectEvent event) {  
        addMessage(new FacesMessage(FacesMessage.SEVERITY_INFO, "Polyline Selected", null));  
    }  
      
    public void addMessage(FacesMessage message) {  
        FacesContext.getCurrentInstance().addMessage(null, message);  
    }  
}  
                      