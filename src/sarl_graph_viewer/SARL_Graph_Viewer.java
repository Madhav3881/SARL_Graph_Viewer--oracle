/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sarl_graph_viewer;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.StackedBarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SplitPane;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import javafx.scene.image.Image;

/**
 *
 * @author madhav
 */
public class SARL_Graph_Viewer extends Application {
      BorderPane root = new BorderPane();
    
   Connection conn;
     ObservableList<XYChart.Series<String , Double>> data1 = FXCollections.observableArrayList();
     ObservableList<XYChart.Series<String , Double>> data2 = FXCollections.observableArrayList();
     ObservableList<XYChart.Series<String , Double>> data3 = FXCollections.observableArrayList();
     
     ObservableList<XYChart.Series<String , Double>> data4 = FXCollections.observableArrayList();
     
     ObservableList<XYChart.Series<String , Double>> data5 = FXCollections.observableArrayList();
     
     ObservableList<XYChart.Series<String , Double>> data6 = FXCollections.observableArrayList();
     
     ObservableList<XYChart.Series<String , Double>> data7 = FXCollections.observableArrayList();
     ObservableList<XYChart.Series<String , Double>> data8 = FXCollections.observableArrayList();
     ObservableList<XYChart.Series<String , Double>> data9 = FXCollections.observableArrayList();
     ObservableList<XYChart.Series<String , Double>> data10 = FXCollections.observableArrayList();
     ObservableList<XYChart.Series<String , Double>> data11 = FXCollections.observableArrayList();
     ObservableList<XYChart.Series<String , Double>> data12 = FXCollections.observableArrayList();
      
      XYChart.Series<String, Double> s1 = new XYChart.Series<>();
      XYChart.Series<String, Double> s2 = new XYChart.Series<>();
      XYChart.Series<String, Double> s3 = new XYChart.Series<>();
      XYChart.Series<String, Double> s4 = new XYChart.Series<>();
      XYChart.Series<String, Double> s5 = new XYChart.Series<>();
      
      XYChart.Series<String, Double> s9 = new XYChart.Series<>();
      XYChart.Series<String, Double> s10 = new XYChart.Series<>();
      XYChart.Series<String, Double> s35 = new XYChart.Series<>();
      XYChart.Series<String, Double> s36 = new XYChart.Series<>();
      XYChart.Series<String, Double> s37 = new XYChart.Series<>();
      XYChart.Series<String, Double> s38 = new XYChart.Series<>();
      XYChart.Series<String, Double> s39 = new XYChart.Series<>();
      XYChart.Series<String, Double> s40 = new XYChart.Series<>();
      
      XYChart.Series<String, Double> s11 = new XYChart.Series<>();
      XYChart.Series<String, Double> s12 = new XYChart.Series<>();
      XYChart.Series<String, Double> s13 = new XYChart.Series<>();
      XYChart.Series<String, Double> s14 = new XYChart.Series<>();
      XYChart.Series<String, Double> s15 = new XYChart.Series<>();
      
      XYChart.Series<String, Double> s19 = new XYChart.Series<>();
      XYChart.Series<String, Double> s20 = new XYChart.Series<>();
      XYChart.Series<String, Double> s21 = new XYChart.Series<>();
      XYChart.Series<String, Double> s22 = new XYChart.Series<>();
      XYChart.Series<String, Double> s23 = new XYChart.Series<>();
      
      XYChart.Series<String, Double> s27 = new XYChart.Series<>();
      XYChart.Series<String, Double> s28 = new XYChart.Series<>();
      XYChart.Series<String, Double> s29 = new XYChart.Series<>();
      XYChart.Series<String, Double> s30 = new XYChart.Series<>();
      XYChart.Series<String, Double> s31 = new XYChart.Series<>();
      
      XYChart.Series<String, Double>[] sa1 = new XYChart.Series[5];
      XYChart.Series<String, Double>[] sa2 = new XYChart.Series[5];
      XYChart.Series<String, Double>[] sa3 = new XYChart.Series[5];
      XYChart.Series<String, Double>[] sa4 = new XYChart.Series[5];
      
      String x;
      String y;
      Stage stage1 = new Stage();
      
      SimpleDateFormat fr = new SimpleDateFormat("dd-MMM-yyyy");
      
       CategoryAxis xAxis1 = new CategoryAxis();
        NumberAxis yAxis1 = new NumberAxis(); 
        
        CategoryAxis xAxis4 = new CategoryAxis();
        NumberAxis yAxis4 = new NumberAxis(); 
        
        CategoryAxis xAxis5 = new CategoryAxis();
        NumberAxis yAxis5 = new NumberAxis(); 
        
        CategoryAxis xAxis6 = new CategoryAxis();
        NumberAxis yAxis6 = new NumberAxis();
    
    public ObservableList<XYChart.Series<String, Double>> barData_Year(){
        
         try{
            conn = CONNECT.ConnecterDb();
            ResultSet rs = conn.createStatement().executeQuery("select add_months(sysdate,-60) from dual");
            while(rs.next()){
            y = fr.format(rs.getDate(1)).toString();
            }
            }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        
        data1.clear();
        
        try{
            conn = CONNECT.ConnecterDb();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select to_char(VRDATE , 'yyyy'),SUM(QTYORDER*PROD_SIZE/1000)-NVL(SUM(QTYCANCELLED*PROD_SIZE/1000),0) from view_sarl_contribution_sheet Where STATE_CODE = 'TS' AND ITEM_NATURE ='PG' AND DIV_CODE LIKE 'O%' AND VRDATE >= '"+y+"' Group By to_char(VRDATE , 'yyyy') order by to_char(VRDATE , 'yyyy')");
            s1.getData().clear();
            while (rs.next()){
                s1.getData().add(new XYChart.Data(rs.getString(1),rs.getDouble(2)));
            }
            data1.addAll(s1);
            s1.setName("Telangana");
            
        }
        
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        try{
            conn = CONNECT.ConnecterDb();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select to_char(VRDATE , 'yyyy'),SUM(QTYORDER*PROD_SIZE/1000)-NVL(SUM(QTYCANCELLED*PROD_SIZE/1000),0) from view_sarl_contribution_sheet Where STATE_CODE = 'AP' AND ITEM_NATURE ='PG' AND DIV_CODE LIKE 'O%' AND VRDATE >= '"+y+"' Group By to_char(VRDATE , 'yyyy') order by to_char(VRDATE , 'yyyy')");
            s2.getData().clear();
            while (rs.next()){
                s2.getData().add(new XYChart.Data(rs.getString(1),rs.getDouble(2)));
            }
            data1.addAll(s2);
            s2.setName("Andhra Pradesh");
            
        }
        
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        try{
            conn = CONNECT.ConnecterDb();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select to_char(VRDATE , 'yyyy'),SUM(QTYORDER*PROD_SIZE/1000)-NVL(SUM(QTYCANCELLED*PROD_SIZE/1000),0) from view_sarl_contribution_sheet Where STATE_CODE = 'KA' AND ITEM_NATURE ='PG' AND DIV_CODE LIKE 'O%' AND VRDATE >= '"+y+"' Group By to_char(VRDATE , 'yyyy') order by to_char(VRDATE , 'yyyy')");
            s3.getData().clear();
            while (rs.next()){
                s3.getData().add(new XYChart.Data(rs.getString(1),rs.getDouble(2)));
            }
            data1.addAll(s3);
            s3.setName("Karnataka");
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        try{
            conn = CONNECT.ConnecterDb();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select to_char(VRDATE , 'yyyy'),SUM(QTYORDER*PROD_SIZE/1000)-NVL(SUM(QTYCANCELLED*PROD_SIZE/1000),0) from view_sarl_contribution_sheet Where STATE_CODE = 'MH' AND ITEM_NATURE ='PG' AND DIV_CODE LIKE 'O%' AND VRDATE >= '"+y+"' Group By to_char(VRDATE , 'yyyy') order by to_char(VRDATE , 'yyyy')");
            s4.getData().clear();
            while (rs.next()){
                s4.getData().add(new XYChart.Data(rs.getString(1),rs.getDouble(2)));
            }
            data1.addAll(s4);
            s4.setName("Maharashtra");
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        try{
            conn = CONNECT.ConnecterDb();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select to_char(VRDATE , 'yyyy'),SUM(QTYORDER*PROD_SIZE/1000)-NVL(SUM(QTYCANCELLED*PROD_SIZE/1000),0) from view_sarl_contribution_sheet Where (STATE_CODE != 'TS' AND STATE_CODE != 'AP' AND STATE_CODE != 'MH' AND STATE_CODE != 'KA') AND ITEM_NATURE ='PG' AND DIV_CODE LIKE 'O%' AND VRDATE >= '"+y+"' Group By to_char(VRDATE , 'yyyy') order by to_char(VRDATE , 'yyyy')");
            s5.getData().clear();
            while (rs.next()){
                s5.getData().add(new XYChart.Data(rs.getString(1),rs.getDouble(2)));
            }
            data1.addAll(s5);
            s5.setName("Others");
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        return data1;
    }
    
     public ObservableList<XYChart.Series<String, Double>> barData_Month(){
         
         try{
            conn = CONNECT.ConnecterDb();
            ResultSet rs = conn.createStatement().executeQuery("select add_months(sysdate,-9) from dual");
            while(rs.next()){
            y = fr.format(rs.getDate(1)).toString();
            }
            }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        
        try{
            conn = CONNECT.ConnecterDb();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select to_char(VRDATE , 'yyyy-mm'),SUM(QTYORDER*PROD_SIZE/1000)-NVL(SUM(QTYCANCELLED*PROD_SIZE/1000),0) from view_sarl_contribution_sheet Where STATE_CODE = 'TS' AND ITEM_NATURE ='PG' AND DIV_CODE LIKE 'O%' AND VRDATE >= '"+y+"' Group By to_char(VRDATE , 'yyyy-mm') order by to_char(VRDATE , 'yyyy-mm')");
            s11.getData().clear();
            while (rs.next()){
                s11.getData().add(new XYChart.Data(rs.getString(1),rs.getDouble(2)));
            }
            data4.addAll(s11);
            s11.setName("Telangana"); 
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        try{
            conn = CONNECT.ConnecterDb();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select to_char(VRDATE , 'yyyy-mm'),SUM(QTYORDER*PROD_SIZE/1000)-NVL(SUM(QTYCANCELLED*PROD_SIZE/1000),0) from view_sarl_contribution_sheet Where STATE_CODE = 'AP' AND ITEM_NATURE ='PG' AND DIV_CODE LIKE 'O%' AND VRDATE >= '"+y+"' Group By to_char(VRDATE , 'yyyy-mm') order by to_char(VRDATE , 'yyyy-mm')");
            s12.getData().clear();
            while (rs.next()){
                s12.getData().add(new XYChart.Data(rs.getString(1),rs.getDouble(2)));
            }
            data4.addAll(s12);
            s12.setName("Andhra Pradesh");
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        try{
            conn = CONNECT.ConnecterDb();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select to_char(VRDATE , 'yyyy-mm'),SUM(QTYORDER*PROD_SIZE/1000)-NVL(SUM(QTYCANCELLED*PROD_SIZE/1000),0) from view_sarl_contribution_sheet Where STATE_CODE = 'KA' AND ITEM_NATURE ='PG' AND DIV_CODE LIKE 'O%' AND VRDATE >= '"+y+"' Group By to_char(VRDATE , 'yyyy-mm') order by to_char(VRDATE , 'yyyy-mm')");
            s13.getData().clear();
            while (rs.next()){
                s13.getData().add(new XYChart.Data(rs.getString(1),rs.getDouble(2)));
            }
            data4.addAll(s13);
            s13.setName("Karnataka");
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        try{
            conn = CONNECT.ConnecterDb();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select to_char(VRDATE , 'yyyy-mm'),SUM(QTYORDER*PROD_SIZE/1000)-NVL(SUM(QTYCANCELLED*PROD_SIZE/1000),0) from view_sarl_contribution_sheet Where STATE_CODE = 'MH' AND ITEM_NATURE ='PG' AND DIV_CODE LIKE 'O%' AND VRDATE >= '"+y+"' Group By to_char(VRDATE , 'yyyy-mm') order by to_char(VRDATE , 'yyyy-mm')");
            s14.getData().clear();
            while (rs.next()){
                s14.getData().add(new XYChart.Data(rs.getString(1),rs.getDouble(2)));
            }
            data4.addAll(s14);
            s14.setName("Maharashtra");
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        try{
            conn = CONNECT.ConnecterDb();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select to_char(VRDATE , 'yyyy-mm'),SUM(QTYORDER*PROD_SIZE/1000)-NVL(SUM(QTYCANCELLED*PROD_SIZE/1000),0) from view_sarl_contribution_sheet Where (STATE_CODE != 'TS' AND STATE_CODE != 'AP' AND STATE_CODE != 'MH' AND STATE_CODE != 'KA') AND ITEM_NATURE ='PG' AND DIV_CODE LIKE 'O%' AND VRDATE >= '"+y+"' Group By to_char(VRDATE , 'yyyy-mm') order by to_char(VRDATE , 'yyyy-mm')");
            s15.getData().clear();
            while (rs.next()){
                s15.getData().add(new XYChart.Data(rs.getString(1),rs.getDouble(2)));
            }
            data4.addAll(s15);
            s15.setName("Others");
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        return data4;
    }
     
      public ObservableList<XYChart.Series<String, Double>> barData_Week(){
          
           try{
            conn = CONNECT.ConnecterDb();
            ResultSet rs = conn.createStatement().executeQuery("select add_months(sysdate,-3) from dual");
            while(rs.next()){
            y = fr.format(rs.getDate(1)).toString();
            }
            }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        
        try{
            conn = CONNECT.ConnecterDb();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select to_char(VRDATE , 'yyyy-ww'),SUM(QTYORDER*PROD_SIZE/1000)-NVL(SUM(QTYCANCELLED*PROD_SIZE/1000),0) from view_sarl_contribution_sheet Where STATE_CODE = 'TS' AND ITEM_NATURE ='PG' AND DIV_CODE LIKE 'O%' AND VRDATE >= '"+y+"'  Group By to_char(VRDATE , 'yyyy-ww') order by to_char(VRDATE , 'yyyy-ww')");
            s19.getData().clear();
            while (rs.next()){
                s19.getData().add(new XYChart.Data(rs.getString(1),rs.getDouble(2)));
            }
            data5.addAll(s19);
            s19.setName("Telangana");
            
        }
        
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        try{
            conn = CONNECT.ConnecterDb();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select to_char(VRDATE , 'yyyy-ww'),SUM(QTYORDER*PROD_SIZE/1000)-NVL(SUM(QTYCANCELLED*PROD_SIZE/1000),0) from view_sarl_contribution_sheet Where STATE_CODE = 'AP' AND ITEM_NATURE ='PG' AND DIV_CODE LIKE 'O%' AND VRDATE >= '"+y+"' Group By to_char(VRDATE , 'yyyy-ww') order by to_char(VRDATE , 'yyyy-ww')");
            s20.getData().clear();
            while (rs.next()){
                s20.getData().add(new XYChart.Data(rs.getString(1),rs.getDouble(2)));
            }
            data5.addAll(s20);
            s20.setName("Andhra Pradesh");
            
        }
        
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        try{
            conn = CONNECT.ConnecterDb();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select to_char(VRDATE , 'yyyy-ww'),SUM(QTYORDER*PROD_SIZE/1000)-NVL(SUM(QTYCANCELLED*PROD_SIZE/1000),0) from view_sarl_contribution_sheet Where STATE_CODE = 'KA' AND ITEM_NATURE ='PG' AND DIV_CODE LIKE 'O%' AND VRDATE >= '"+y+"' Group By to_char(VRDATE , 'yyyy-ww') order by to_char(VRDATE , 'yyyy-ww')");
            s21.getData().clear();
            while (rs.next()){
                s21.getData().add(new XYChart.Data(rs.getString(1),rs.getDouble(2)));
            }
            data5.addAll(s21);
            s21.setName("Karnataka");
            
        }
        
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        try{
            conn = CONNECT.ConnecterDb();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select to_char(VRDATE , 'yyyy-ww'),SUM(QTYORDER*PROD_SIZE/1000)-NVL(SUM(QTYCANCELLED*PROD_SIZE/1000),0) from view_sarl_contribution_sheet Where STATE_CODE = 'MH' AND ITEM_NATURE ='PG' AND DIV_CODE LIKE 'O%' AND VRDATE >= '"+y+"' Group By to_char(VRDATE , 'yyyy-ww') order by to_char(VRDATE , 'yyyy-ww')");
            s22.getData().clear();
            while (rs.next()){
                s22.getData().add(new XYChart.Data(rs.getString(1),rs.getDouble(2)));
            }
            data5.addAll(s22);
            s22.setName("Maharashtra");
            
        }
        
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        try{
            conn = CONNECT.ConnecterDb();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select to_char(VRDATE , 'yyyy-ww'),SUM(QTYORDER*PROD_SIZE/1000)-NVL(SUM(QTYCANCELLED*PROD_SIZE/1000),0) from view_sarl_contribution_sheet Where (STATE_CODE != 'TS' AND STATE_CODE != 'AP' AND STATE_CODE != 'MH' AND STATE_CODE != 'KA') AND ITEM_NATURE ='PG' AND DIV_CODE LIKE 'O%' AND VRDATE >= '"+y+"' Group By to_char(VRDATE , 'yyyy-ww') order by to_char(VRDATE , 'yyyy-ww')");
            s23.getData().clear();
            while (rs.next()){
                s23.getData().add(new XYChart.Data(rs.getString(1),rs.getDouble(2)));
            }
            data5.addAll(s23);
            s23.setName("Others");
            
        }
        
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        return data5;
    }
      
       public ObservableList<XYChart.Series<String, Double>> barData_Day(){
           
            try{
            conn = CONNECT.ConnecterDb();
            ResultSet rs = conn.createStatement().executeQuery("select (sysdate-9) from dual");
            while(rs.next()){
            y = fr.format(rs.getDate(1)).toString();
            }
            }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        
        try{
            conn = CONNECT.ConnecterDb();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select VRDATE ,SUM(QTYORDER*PROD_SIZE/1000)-NVL(SUM(QTYCANCELLED*PROD_SIZE/1000),0) from view_sarl_contribution_sheet Where STATE_CODE = 'TS' AND ITEM_NATURE ='PG' AND DIV_CODE LIKE 'O%' AND VRDATE >= '"+y+"' Group By VRDATE order by VRDATE");
            s27.getData().clear();
            while (rs.next()){
                s27.getData().add(new XYChart.Data(rs.getString(1),rs.getDouble(2)));
            }
            data6.addAll(s27);
            s27.setName("Telangana");
            
        }
        
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        try{
            conn = CONNECT.ConnecterDb();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select VRDATE,SUM(QTYORDER*PROD_SIZE/1000)-NVL(SUM(QTYCANCELLED*PROD_SIZE/1000),0) from view_sarl_contribution_sheet Where STATE_CODE = 'AP' AND ITEM_NATURE ='PG' AND DIV_CODE LIKE 'O%' AND VRDATE >= '"+y+"' Group By VRDATE order by VRDATE");
            s28.getData().clear();
            while (rs.next()){
                s28.getData().add(new XYChart.Data(rs.getString(1),rs.getDouble(2)));
            }
            data6.addAll(s28);
            s28.setName("Andhra Pradesh");
            
        }
        
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        try{
            conn = CONNECT.ConnecterDb();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select VRDATE,SUM(QTYORDER*PROD_SIZE/1000)-NVL(SUM(QTYCANCELLED*PROD_SIZE/1000),0) from view_sarl_contribution_sheet Where STATE_CODE = 'KA' AND ITEM_NATURE ='PG' AND DIV_CODE LIKE 'O%' AND VRDATE >= '"+y+"' Group By VRDATE order by VRDATE");
            s29.getData().clear();
            while (rs.next()){
                s29.getData().add(new XYChart.Data(rs.getString(1),rs.getDouble(2)));
            }
            data6.addAll(s29);
            s29.setName("Karnataka");
            
        }
        
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        try{
            conn = CONNECT.ConnecterDb();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select VRDATE,SUM(QTYORDER*PROD_SIZE/1000)-NVL(SUM(QTYCANCELLED*PROD_SIZE/1000),0) from view_sarl_contribution_sheet Where STATE_CODE = 'MH' AND ITEM_NATURE ='PG' AND DIV_CODE LIKE 'O%' AND VRDATE >= '"+y+"' Group By VRDATE order by VRDATE");
            s30.getData().clear();
            while (rs.next()){
                s30.getData().add(new XYChart.Data(rs.getString(1),rs.getDouble(2)));
            }
            data6.addAll(s30);
            s30.setName("Maharashtra");
            
        }
        
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        try{
            conn = CONNECT.ConnecterDb();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select VRDATE,SUM(QTYORDER*PROD_SIZE/1000)-NVL(SUM(QTYCANCELLED*PROD_SIZE/1000),0) from view_sarl_contribution_sheet Where (STATE_CODE != 'TS' AND STATE_CODE != 'AP' AND STATE_CODE != 'MH' AND STATE_CODE != 'KA') AND ITEM_NATURE ='PG' AND DIV_CODE LIKE 'O%' AND VRDATE >= '"+y+"' Group By VRDATE order by VRDATE");
            s31.getData().clear();
            while (rs.next()){
                s31.getData().add(new XYChart.Data(rs.getString(1),rs.getDouble(2)));
            }
            data6.addAll(s31);
            s31.setName("Others");
            
        }
        
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        return data6;
    }
       
     public ObservableList<XYChart.Series<String, Double>> barData1(){
        
        
        try{
            conn = CONNECT.ConnecterDb();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select PRICE_LIST_PROD,SUM(QTYORDER*PROD_SIZE/1000)-NVL(SUM(QTYCANCELLED*PROD_SIZE/1000),0) from view_sarl_contribution_sheet where to_char(VRDATE,'yyyy') = '"+x+"' AND ITEM_NATURE ='PG' AND DIV_CODE LIKE 'O%'Group By PRICE_LIST_PROD");
            s9.getData().clear();
            while (rs.next()){
                s9.getData().add(new XYChart.Data(rs.getString(1),rs.getDouble(2)));
            }
            data2.addAll(s9);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        return data2;
    }
     
    /*  public ObservableList<XYChart.Series<String, Double>> barData2(){
        
        
        try{
            conn = CONNECT.ConnecterDb();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select distinct(SUBSTRING(ITEM_NAME,1,5)) As id, substring(ITEM_NAME,1,9),SUM(QTYORDER*PROD_SIZE/1000)-NVL(SUM(QTYCANCELLED*PROD_SIZE/1000),0) from view_sarl_contribution_sheet where year(VRDATE) = "+x+" AND ITEM_NATURE ='PG' AND DIV_CODE LIKE 'O%' AND (ITEM_NAME not like '%KRISHNA%' AND ITEM_NAME not like '%MOTHER%' AND ITEM_NAME not like '%NATURALLE%' AND ITEM_NAME not like '%NATURRALLE%' AND ITEM_NAME not like '%RUCHIRRA%' AND ITEM_NAME not like '%SUNSURRE%') Group By id");
            s10.getData().clear();
            while (rs.next()){
                s10.getData().add(new XYChart.Data(rs.getString(2),rs.getDouble(3)));
            }
            data3.addAll(s10);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        return data3;
    }
      */
       public ObservableList<XYChart.Series<String, Double>> barData3(){
        
        
        try{
            conn = CONNECT.ConnecterDb();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select PRICE_LIST_PROD,SUM(QTYORDER*PROD_SIZE/1000)-NVL(SUM(QTYCANCELLED*PROD_SIZE/1000),0) from view_sarl_contribution_sheet where to_char(VRDATE,'yyyy-mm') = '"+x+"' AND ITEM_NATURE ='PG' AND DIV_CODE LIKE 'O%'Group By PRICE_LIST_PROD");
            s35.getData().clear();
            while (rs.next()){
                s35.getData().add(new XYChart.Data(rs.getString(1),rs.getDouble(2)));
            }
            data7.addAll(s35);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        return data7;
    }
     
    /*  public ObservableList<XYChart.Series<String, Double>> barData4(){
        
        
        try{
            conn = CONNECT.ConnecterDb();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select distinct(SUBSTRING(ITEM_NAME,1,5)) As id, substring(ITEM_NAME,1,9),SUM(QTYORDER*PROD_SIZE/1000)-NVL(SUM(QTYCANCELLED*PROD_SIZE/1000),0) from view_sarl_contribution_sheet where MONTH(VRDATE) = "+x+" AND ITEM_NATURE ='PG' AND DIV_CODE LIKE 'O%' AND (ITEM_NAME not like '%KRISHNA%' AND ITEM_NAME not like '%MOTHER%' AND ITEM_NAME not like '%NATURALLE%' AND ITEM_NAME not like '%NATURRALLE%' AND ITEM_NAME not like '%RUCHIRRA%' AND ITEM_NAME not like '%SUNSURRE%') Group By id");
            s36.getData().clear();
            while (rs.next()){
                s36.getData().add(new XYChart.Data(rs.getString(2),rs.getDouble(3)));
            }
            data8.addAll(s36);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        return data8;
    }
     */
       public ObservableList<XYChart.Series<String, Double>> barData5(){
        
        
        try{
            conn = CONNECT.ConnecterDb();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select PRICE_LIST_PROD,SUM(QTYORDER*PROD_SIZE/1000)-NVL(SUM(QTYCANCELLED*PROD_SIZE/1000),0) from view_sarl_contribution_sheet where to_char(VRDATE,'yyyy-ww') = '"+x+"' AND ITEM_NATURE ='PG' AND DIV_CODE LIKE 'O%'Group By PRICE_LIST_PROD");
            s37.getData().clear();
            while (rs.next()){
                s37.getData().add(new XYChart.Data(rs.getString(1),rs.getDouble(2)));
            }
            data9.addAll(s37);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        return data9;
    }
     
    /*  public ObservableList<XYChart.Series<String, Double>> barData6(){
        
        
        try{
            conn = CONNECT.ConnecterDb();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select distinct(SUBSTRING(ITEM_NAME,1,5)) As id, substring(ITEM_NAME,1,9),SUM(QTYORDER*PROD_SIZE/1000)-NVL(SUM(QTYCANCELLED*PROD_SIZE/1000),0) from view_sarl_contribution_sheet where WEEK(VRDATE) = "+x+" AND ITEM_NATURE ='PG' AND DIV_CODE LIKE 'O%' AND (ITEM_NAME not like '%KRISHNA%' AND ITEM_NAME not like '%MOTHER%' AND ITEM_NAME not like '%NATURALLE%' AND ITEM_NAME not like '%NATURRALLE%' AND ITEM_NAME not like '%RUCHIRRA%' AND ITEM_NAME not like '%SUNSURRE%') Group By id");
            s38.getData().clear();
            while (rs.next()){
                s38.getData().add(new XYChart.Data(rs.getString(2),rs.getDouble(3)));
            }
            data10.addAll(s38);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        return data10;
    }
      */
       public ObservableList<XYChart.Series<String, Double>> barData7(){
        
        
        try{
            conn = CONNECT.ConnecterDb();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select PRICE_LIST_PROD,SUM(QTYORDER*PROD_SIZE/1000)-NVL(SUM(QTYCANCELLED*PROD_SIZE/1000),0) from view_sarl_contribution_sheet where VRDATE = '"+x+"' AND ITEM_NATURE ='PG' AND DIV_CODE LIKE 'O%'Group By PRICE_LIST_PROD");
            s39.getData().clear();
            while (rs.next()){
                s39.getData().add(new XYChart.Data(rs.getString(1),rs.getDouble(2)));
            }
            data11.addAll(s39);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        return data11;
    }
     
    /*  public ObservableList<XYChart.Series<String, Double>> barData8(){
        
        
        try{
            conn = CONNECT.ConnecterDb();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select distinct(SUBSTRING(ITEM_NAME,1,5)) As id, substring(ITEM_NAME,1,9),SUM(QTYORDER*PROD_SIZE/1000)-NVL(SUM(QTYCANCELLED*PROD_SIZE/1000),0) from view_sarl_contribution_sheet where DAY(VRDATE) = "+x+" AND ITEM_NATURE ='PG' AND DIV_CODE LIKE 'O%' AND (ITEM_NAME not like '%KRISHNA%' AND ITEM_NAME not like '%MOTHER%' AND ITEM_NAME not like '%NATURALLE%' AND ITEM_NAME not like '%NATURRALLE%' AND ITEM_NAME not like '%RUCHIRRA%' AND ITEM_NAME not like '%SUNSURRE%') Group By id");
            s40.getData().clear();
            while (rs.next()){
                s40.getData().add(new XYChart.Data(rs.getString(2),rs.getDouble(3)));
            }
            data12.addAll(s40);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        return data12;
    }
      */
    
    @Override
    public void start(Stage primaryStage) {
        
         SplitPane sp = new SplitPane();
         Scene scene = new Scene(root, 1280, 720);
         Scene s = new Scene(sp, 1280,720);
         
         primaryStage.setTitle("SARL Graph Viewer");
         primaryStage.setScene(scene);
         primaryStage.getIcons().add(new Image("file:logo3.png"));
         primaryStage.show();
         
          xAxis1.setLabel("Year");
          yAxis1.setLabel("Sale Quantity in Tonne");
          
          xAxis4.setLabel("Month");
          yAxis4.setLabel("Sale Quantity in Tonne");
          
          xAxis5.setLabel("Week");
          yAxis5.setLabel("Sale Quantity in Tonne");
          
          xAxis6.setLabel("Day");
          yAxis6.setLabel("Sale Quantity in Tonne");
        
        Button btn = new Button("Back");
        Button b1 = new Button("State Analysis");
        Button b2 = new Button("District Analysis");
        Button b3 = new Button("Product Analysis");
        Button b4 = new Button("Custom Analysis");
        
        MenuItem btn1 = new MenuItem("Year");
        MenuItem btn2 = new MenuItem("Month");
        MenuItem btn3 = new MenuItem("Week");
        MenuItem btn4 = new MenuItem("Day");
        
        MenuButton m = new MenuButton("Select",null,btn1,btn2,btn3,btn4);
        
        ToolBar t1 = new ToolBar();
        
        t1.getItems().addAll(b1,b2,b3,b4,m);
        root.setTop(t1);
       
       b1.setOnAction(e->{
           try{
           Class.forName("sarl_graph_viewer.State_Analysis.StateMain");
           primaryStage.close();
           new sarl_graph_viewer.State_Analysis.StateMain().start(stage1);
           }
           catch(Exception i){
               JOptionPane.showMessageDialog(null, i);
           }
       });
       
        b2.setOnAction(e->{
           try{
           Class.forName("sarl_graph_viewer.District_Analysis.DistrictMain");
           primaryStage.close();
           new sarl_graph_viewer.District_Analysis.DistrictMain().start(stage1);
           }
           catch(Exception i){
               JOptionPane.showMessageDialog(null, i);
           }
       });
        
         b3.setOnAction(e->{
           try{
           Class.forName("sarl_graph_viewer.Product_Analysis.ProductMain");
           primaryStage.close();
           new sarl_graph_viewer.Product_Analysis.ProductMain().start(stage1);
           }
           catch(Exception i){
               JOptionPane.showMessageDialog(null, i);
           }
       });
         
          b4.setOnAction(e->{
           try{
           Class.forName("sarl_graph_viewer.Custom_Analysis.CustomMain");
           primaryStage.close();
           new sarl_graph_viewer.Custom_Analysis.CustomMain().start(stage1);
           }
           catch(Exception i){
               JOptionPane.showMessageDialog(null, i);
           }
       });
       
        btn1.setOnAction(e->{
            
            StackedBarChart bc1 = new StackedBarChart(xAxis1,yAxis1,barData_Year());
            root.setCenter(bc1);
            data4.clear(); data5.clear(); data6.clear();
            s11.getData().clear(); s12.getData().clear(); s13.getData().clear(); s14.getData().clear(); s15.getData().clear();
            s19.getData().clear(); s20.getData().clear(); s21.getData().clear(); s22.getData().clear(); s23.getData().clear();
            s27.getData().clear(); s28.getData().clear(); s29.getData().clear(); s30.getData().clear(); s31.getData().clear();
        });
        
          btn2.setOnAction(e->{
              
            StackedBarChart bc4 = new StackedBarChart(xAxis4,yAxis4,barData_Month());
            root.setCenter(bc4);
            data1.clear(); data5.clear(); data6.clear();
            s1.getData().clear(); s2.getData().clear(); s3.getData().clear(); s4.getData().clear(); s5.getData().clear();
            s19.getData().clear(); s20.getData().clear(); s21.getData().clear(); s22.getData().clear(); s23.getData().clear();
            s27.getData().clear(); s28.getData().clear(); s29.getData().clear(); s30.getData().clear(); s31.getData().clear();
        });
          
            btn3.setOnAction(e->{
                
            StackedBarChart bc5 = new StackedBarChart(xAxis5,yAxis5,barData_Week());
            root.setCenter(bc5);
            data1.clear(); data4.clear(); data6.clear();
            s1.getData().clear(); s2.getData().clear(); s3.getData().clear(); s4.getData().clear(); s5.getData().clear();
            s11.getData().clear(); s12.getData().clear(); s13.getData().clear(); s14.getData().clear(); s15.getData().clear(); 
            s27.getData().clear(); s28.getData().clear(); s29.getData().clear(); s30.getData().clear(); s31.getData().clear(); 
        });
            
              btn4.setOnAction(e->{
            
            StackedBarChart bc6 = new StackedBarChart(xAxis6,yAxis6,barData_Day());
            root.setCenter(bc6);
            data1.clear(); data4.clear(); data5.clear();
            s1.getData().clear(); s2.getData().clear(); s3.getData().clear(); s4.getData().clear(); s5.getData().clear();
            s11.getData().clear(); s12.getData().clear(); s13.getData().clear(); s14.getData().clear(); s15.getData().clear();
            s19.getData().clear(); s20.getData().clear(); s21.getData().clear(); s22.getData().clear(); s23.getData().clear();
        });
              
            StackedBarChart bc4 = new StackedBarChart(xAxis4,yAxis4,barData_Month());
            root.setCenter(bc4);
        
        
          CategoryAxis xAxis2 = new CategoryAxis();
          NumberAxis yAxis2 = new NumberAxis();
          
          CategoryAxis xAxis3 = new CategoryAxis();
          NumberAxis yAxis3 = new NumberAxis();
          
          sa1[0] = s1; sa1[1] = s2; sa1[2] = s3; sa1[3] = s4; sa1[4] = s5;
          sa2[0] = s11; sa2[1] = s12; sa2[2] = s13; sa2[3] = s14; sa2[4] = s15;
          sa3[0] = s19; sa3[1] = s20; sa3[2] = s21; sa3[3] = s22; sa3[4] = s23;
          sa4[0] = s27; sa4[1] = s28; sa4[2] = s29; sa4[3] = s30; sa4[4] = s31;
          
        for(int i = 0 ;i < 5; i ++){ 
        for(XYChart.Data<String,Double> data : sa1[i].getData()){
            Node n1 = data.getNode();
            n1.setOnMouseClicked(e->{
                x = data.getXValue();
                primaryStage.setScene(s);
                BarChart bc2 = new BarChart(xAxis2,yAxis2,barData1());
                xAxis2.setLabel("Product");
                yAxis2.setLabel("Sale Quantity in Tonne");
                
               /* BarChart bc3 = new BarChart(xAxis3,yAxis3,barData2());
                xAxis3.setLabel("Product");
                yAxis3.setLabel("Sale Quantity in Tonne");
                */
                sp.getItems().addAll(bc2,btn);
                primaryStage.show();
                
                 btn.setOnAction(i1-> {
                    data2.clear();
                    data3.clear();
                    s9.getData().clear();
                    s10.getData().clear();

                    sp.getItems().clear();

                    primaryStage.setScene(scene);
                    primaryStage.show();
                    });
                });
            }
        }
        for(int i = 0 ;i < 5; i ++){ 
        for(XYChart.Data<String,Double> data : sa2[i].getData()){
            Node n1 = data.getNode();
            n1.setOnMouseClicked(e->{
                x = data.getXValue();
                primaryStage.setScene(s);
                BarChart bc2 = new BarChart(xAxis2,yAxis2,barData3());
                xAxis2.setLabel("Product");
                yAxis2.setLabel("Sale Quantity in Tonne");
                
              /*  BarChart bc3 = new BarChart(xAxis3,yAxis3,barData4());
                xAxis3.setLabel("Product");
                yAxis3.setLabel("Sale Quantity in Tonne");
                */
                sp.getItems().addAll(bc2,btn);
                primaryStage.show();
                
                 btn.setOnAction(i1->{
                    data7.clear();
                    data8.clear();
                    s35.getData().clear();
                    s36.getData().clear();

                    sp.getItems().clear();

                    primaryStage.setScene(scene);
                    primaryStage.show();
                    });
                });
            }
        }
        for(int i = 0 ;i < 5; i ++){ 
        for(XYChart.Data<String,Double> data : sa3[i].getData()){
            Node n1 = data.getNode();
            n1.setOnMouseClicked(e->{
                x = data.getXValue();
                primaryStage.setScene(s);
                BarChart bc2 = new BarChart(xAxis2,yAxis2,barData5());
                xAxis2.setLabel("Product");
                yAxis2.setLabel("Sale Quantity in Tonne");
                
               /* BarChart bc3 = new BarChart(xAxis3,yAxis3,barData6());
                xAxis3.setLabel("Product");
                yAxis3.setLabel("Sale Quantity in Tonne");
                */
                sp.getItems().addAll(bc2,btn);
                primaryStage.show();
                
                 btn.setOnAction(i1-> {
                    data9.clear();
                    data10.clear();
                    s37.getData().clear();
                    s38.getData().clear();

                    sp.getItems().clear();

                    primaryStage.setScene(scene);
                    primaryStage.show();
                    });
                });
            }
        }
        for(int i = 0 ;i < 5; i ++){ 
        for(XYChart.Data<String,Double> data : sa4[i].getData()){
            Node n1 = data.getNode();
            n1.setOnMouseClicked(e->{
                x = fr.format(data.getXValue());
                primaryStage.setScene(s);
                BarChart bc2 = new BarChart(xAxis2,yAxis2,barData7());
                xAxis2.setLabel("Product");
                yAxis2.setLabel("Sale Quantity in Tonne");
                
               /* BarChart bc3 = new BarChart(xAxis3,yAxis3,barData8());
                xAxis3.setLabel("Product");
                yAxis3.setLabel("Sale Quantity in Tonne");
                */
                sp.getItems().addAll(bc2,btn);
                primaryStage.show();
                
                 btn.setOnAction(i1->{
                    data11.clear();
                    data12.clear();
                    s39.getData().clear();
                    s40.getData().clear();

                    sp.getItems().clear();
                    primaryStage.setScene(scene);
                    primaryStage.show();
                    });
                });
            }
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
