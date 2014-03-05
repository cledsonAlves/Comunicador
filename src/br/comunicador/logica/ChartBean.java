package br.comunicador.logica;
import java.io.Serializable;

import javax.faces.bean.ManagedBean;

import org.primefaces.model.chart.CartesianChartModel;
import org.primefaces.model.chart.ChartSeries;
import org.primefaces.model.chart.LineChartSeries;
import org.primefaces.model.chart.PieChartModel;
 

@ManagedBean(name = "chartBean")
public class ChartBean implements Serializable {  
  
    private CartesianChartModel linearModel;  
  
    private CartesianChartModel categoryModel;  
    private PieChartModel pieModel;  
  
    public ChartBean() {  
        createLinearModel();  
        createCategoryModel();  
        createPieModel(); 
    }  
  
    public CartesianChartModel getLinearModel() {  
        return linearModel;  
    }  
  
    public CartesianChartModel getCategoryModel() {  
        return categoryModel;  
    }  
  
    private void createLinearModel() {  
        linearModel = new CartesianChartModel();  
  
        LineChartSeries series1 = new LineChartSeries();  
        series1.setLabel("Series 1");  
  
        series1.set(1, 2);  
        series1.set(2, 1);  
        series1.set(3, 3);  
        series1.set(4, 6);  
        series1.set(5, 8);  
  
        LineChartSeries series2 = new LineChartSeries();  
        series2.setLabel("Series 2");  
        series2.setMarkerStyle("diamond");  
  
        series2.set(1, 6);  
        series2.set(2, 3);  
        series2.set(3, 2);  
        series2.set(4, 7);  
        series2.set(5, 9);  
  
        linearModel.addSeries(series1);  
        linearModel.addSeries(series2);  
    }  
  
    private void createCategoryModel() {  
        categoryModel = new CartesianChartModel();  
  
        ChartSeries boys = new ChartSeries();  
        boys.setLabel("2013");  
  
        boys.set("Eduardo", 520);  
        boys.set("Miqueias", 280);  
        boys.set("Marcos", 144);  
        boys.set("Alan", 98);  
        boys.set("Carlos", 0); 
        boys.set("Douglas", 0);  
     
  
        ChartSeries girls = new ChartSeries();  
        girls.setLabel("2014");  
  
        girls.set("Eduardo", 171);  
        girls.set("Miqueias", 123);  
        girls.set("Marcos", 2);  
        girls.set("Alan", 34);  
        girls.set("Carlos",4);  
        girls.set("Douglas", 10); 
     
        categoryModel.addSeries(boys);  
        categoryModel.addSeries(girls);  
    }  
    
    
  
    public PieChartModel getPieModel() {  
        return pieModel;  
    }  
  
    private void createPieModel() {  
        pieModel = new PieChartModel();  
  
        pieModel.set("Miqueias", 910);  
        pieModel.set("Alan", 325);  
        pieModel.set("Eduardo",1020);  
        pieModel.set("Douglas", 100);
        pieModel.set("Carlos Silva", 100);
        
    }
}  
        