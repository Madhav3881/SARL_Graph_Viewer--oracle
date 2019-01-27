/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sarl_graph_viewer.Custom_Analysis;

import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.StackedBarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBoxTreeItem;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.ToolBar;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.controlsfx.control.CheckTreeView;
import sarl_graph_viewer.CONNECT;

/**
 *
 * @author madhav
 */
public class CustomMain extends Application {
    
    Date d;
    Stage stage1 = new Stage();
    Connection conn;
    
    String a;
    String date1;
    String date2;
    String x;
    String y ;
    String z = "";
    String group;
    String option1;
    String option2;
    String option3;
    String sql = "";
    String ma = "";
    String date;
    String labels[] = new String[1000];
    int i1 = 0;
    int i2= 0;
    int i3 = 0;
    int i4 = 0;
    int i5 = 0;
    int i6 = 0;
    int i7 = 0;
    String test1 = "";
    String test2 = "";
    String test3 = "";
    String test4 = "";
    String test5 = "";
    String test6 = "";
    String test7 = "";
    String pi1 = "";
    String pi2 = "";
    String pi3 = "";
    String pi4 = "";
    String pi5 = "";
    String pi6 = "";
    String pi7 = "";
    String table = "ENTITY_CODE,TCODE,VRDATE,VRNO,ACC_CODE,FREIGHT_BASIS,TRANTYPE,ITEM_CODE,DIV_CODE,STATE_CODE,DISTRICT,TNATURE,ITEM_NAME,ITEM_NATURE,AREA_CODE,SUPPLIER_TYPE,INPUT_ITEM_CODE,AQTYORDER,QTYORDER,QTYCANCELLED,AUMTOUM,SLNO,AMENDNO,AFIELD1,PROD_SIZE,PRICE_LIST_PROD,GRP_AREA_NAME,AQTY,QTY,FB,IC,DC,EC,AC,ITN,(SUM(AFIELD1)/SUM(QTYORDER))/(SUM(QTYORDER*PROD_SIZE/1000)-NVL(SUM(QTYCANCELLED*PROD_SIZE/1000),0)),(SUM(GET_CRUDE_RATE(DIV_CODE,ITEM_CODE,VRDATE,ITEM_NATURE,'NETRATE',VRNO)*GET_PG_PACK_SIZE(DIV_CODE,ITEM_CODE,'SIZE',VRDATE)*QTYORDER)/SUM(QTYORDER))*SUM(QTYORDER),((SUM(AFIELD1)-NVL(SUM(QTY*GET_PG_PACK_SIZE(DC,IC,'EXP',VRDATE)),0)-NVL((SUM(GET_FRT_RATE(DC,IC,AREA_CODE,'P',vrdate,FB)*QTY)),0)-NVL(SUM(GET_SARL_SCHEME_RATE(ACC_CODE,IC,VRDATE)*QTY),0)-\n" +
                    "SUM(NVL(FNC_SWG_SCHEME(EC,DC,ACC_CODE,VRDATE,VRNO,IC,QTY,'AMT',AREA_CODE,FREIGHT_BASIS),0))-\n" +
                    "NVL(SUM(GET_FRT_RATE(DC,IC,AREA_CODE,'S',vrdate,FREIGHT_BASIS)*QTY),0)))-((SUM(NVL(GET_CRUDE_RATE(DC,IC,VRDATE,ITN,'NETRATE',VRNO),0)*GET_PG_PACK_SIZE(DC,IC,'SIZE',VRDATE)*QTY)/SUM(QTY))*SUM(QTY)),(((SUM(AFIELD1)-NVL(SUM(QTY*GET_PG_PACK_SIZE(DC,IC,'EXP',VRDATE)),0)-NVL((SUM(GET_FRT_RATE(DC,IC,AREA_CODE,'P',vrdate,FB)*QTY)),0)-NVL(SUM(GET_SARL_SCHEME_RATE(ACC_CODE,IC,VRDATE)*QTY),0)-\n" +
                    "SUM(NVL(FNC_SWG_SCHEME(EC,DC,ACC_CODE,VRDATE,VRNO,IC,QTY,'AMT',AC,FB),0))-\n" +
                    "NVL(SUM(GET_FRT_RATE(DC,IC,AC,'S',vrdate,FB)*QTY),0)))-((SUM(GET_CRUDE_RATE(DC,IC,VRDATE,ITN,'NETRATE',VRNO)*GET_PG_PACK_SIZE(DC,IC,'SIZE',VRDATE)*QTY)/SUM(QTY))*SUM(QTY)))/(SUM(QTY*GET_PG_PACK_SIZE(DC,IC,'SIZE',VRDATE))/1000)";
    
    TextField tx1 = new TextField();
    
    ObservableList<javafx.scene.chart.PieChart.Data> datapie = FXCollections.observableArrayList();
    ObservableList<javafx.scene.chart.PieChart.Data> datapie1 = FXCollections.observableArrayList();
    
    ObservableList<XYChart.Series<String , Double>> data = FXCollections.observableArrayList();
    ObservableList<XYChart.Series<String , Double>> data1 = FXCollections.observableArrayList();
    ObservableList<XYChart.Series<String , Double>> datad = FXCollections.observableArrayList();
    ObservableList<XYChart.Series<String , Double>> datad1 = FXCollections.observableArrayList();
    ObservableList<XYChart.Series<String , Double>> datad2 = FXCollections.observableArrayList();
    
    XYChart.Series<String, Double> s1 = new XYChart.Series<>();
    XYChart.Series<String, Double> s2 = new XYChart.Series<>();
    XYChart.Series<String, Double> s3 = new XYChart.Series<>();
    XYChart.Series<String, Double> s4 = new XYChart.Series<>();
    XYChart.Series<String, Double> s5 = new XYChart.Series<>();
    XYChart.Series<String, Double> s6 = new XYChart.Series<>();
    XYChart.Series<String, Double> s7 = new XYChart.Series<>();
    XYChart.Series<String, Double> s8 = new XYChart.Series<>();
    XYChart.Series<String, Double> sd = new XYChart.Series<>();
    XYChart.Series<String, Double> sd1 = new XYChart.Series<>();
    XYChart.Series<String, Double> sd2 = new XYChart.Series<>();
    
    XYChart.Series<String, Double> s11 = new XYChart.Series<>();
    ObservableList<XYChart.Series<String , Double>> data2 = FXCollections.observableArrayList();
    
    ObservableList<String> options1 = FXCollections.observableArrayList("Date","Item Name","District","State","Year","Month","Week","Brand");
    ObservableList<String> options2 = FXCollections.observableArrayList("Quantity in Tonne","Rate per Tonne","Cost Value","Contribution","Contribution Per Tonne");
    ObservableList<String> options3 = FXCollections.observableArrayList("All States","Telangana","Andhra Pradesh","Maharashtra","Karnataka","Tamil Nadu","Gujarat","Chattisgarh","Madhya Pradesh");
    
    CheckBoxTreeItem<String> ch = new CheckBoxTreeItem<>("Select All");
        //parent chech box decleration
        CheckBoxTreeItem<String> p1 = new CheckBoxTreeItem<>("NATURRALLE");
        CheckBoxTreeItem<String> p2 = new CheckBoxTreeItem<>("SUNSURRE");
        CheckBoxTreeItem<String> p3 = new CheckBoxTreeItem<>("KRISHNA BRAND");
        CheckBoxTreeItem<String> p4 = new CheckBoxTreeItem<>("SRE KRISHNA");
        CheckBoxTreeItem<String> p5 = new CheckBoxTreeItem<>("MOTHER'S CHOICE");
        CheckBoxTreeItem<String> p6 = new CheckBoxTreeItem<>("RUCHIRRA");
        CheckBoxTreeItem<String> p7 = new CheckBoxTreeItem<>("OTHERS");
        //children checkbox array list decleration
        List<CheckBoxTreeItem<String>> checkboxes1 = new ArrayList<>();
        List<CheckBoxTreeItem<String>> checkboxes2 = new ArrayList<>();
        List<CheckBoxTreeItem<String>> checkboxes3 = new ArrayList<>();
        List<CheckBoxTreeItem<String>> checkboxes4 = new ArrayList<>();
        List<CheckBoxTreeItem<String>> checkboxes5 = new ArrayList<>();
        List<CheckBoxTreeItem<String>> checkboxes6 = new ArrayList<>();
        List<CheckBoxTreeItem<String>> checkboxes7 = new ArrayList<>();
        //formating date function
        SimpleDateFormat fr = new SimpleDateFormat("dd-MMM-yyyy");
        //export table function
        public void exportTable(String sql,String name){
        try{
            conn = CONNECT.ConnecterDb();
        HSSFWorkbook wb = new HSSFWorkbook(); 
        HSSFSheet sheet = wb.createSheet("data");
        HSSFRow header = sheet.createRow(0);//setting hedder row
        header.createCell(0).setCellValue("ENTITY CODE");
        header.createCell(1).setCellValue("TCODE");
        header.createCell(2).setCellValue("VRDATE");
        header.createCell(3).setCellValue("VRNO");
        header.createCell(4).setCellValue("ACC CODE");
        header.createCell(5).setCellValue("FREIGHT BASIS");
        header.createCell(6).setCellValue("TRANTYPE");
        header.createCell(7).setCellValue("ITEM CODE");
        header.createCell(8).setCellValue("DIV CODE");
        header.createCell(9).setCellValue("STATE CODE");
        header.createCell(10).setCellValue("DISTRICT");
        header.createCell(11).setCellValue("TNATURE");
        header.createCell(12).setCellValue("ITEM NAME");
        header.createCell(13).setCellValue("ITEM NATURE");
        header.createCell(14).setCellValue("AREA CODE");
        header.createCell(15).setCellValue("SUPPLIER TYPE");
        header.createCell(16).setCellValue("INPUT ITEM CODE");
        header.createCell(17).setCellValue("AQTYORDER");
        header.createCell(18).setCellValue("QTYORDER");
        header.createCell(19).setCellValue("QTYCANCELLED");
        header.createCell(20).setCellValue("AUMTOUM");
        header.createCell(21).setCellValue("SLNO");
        header.createCell(22).setCellValue("AMENDNO");
        header.createCell(23).setCellValue("AFIELD1");
        header.createCell(24).setCellValue("PROD_SIZE");
        header.createCell(25).setCellValue("PRICE LIST PROD");
        header.createCell(26).setCellValue("GRP AREA NAME");
        header.createCell(27).setCellValue("AQTY");
        header.createCell(28).setCellValue("QTY");
        header.createCell(29).setCellValue("FB");
        header.createCell(30).setCellValue("IC");
        header.createCell(31).setCellValue("DC");
        header.createCell(32).setCellValue("EC");
        header.createCell(33).setCellValue("AC");
        header.createCell(34).setCellValue("ITN");
        header.createCell(35).setCellValue("RATE PER TONNE");
        header.createCell(36).setCellValue("COST VALUE");
        header.createCell(37).setCellValue("CONTRIBUTION");
        header.createCell(38).setCellValue("CONTRIBUTION PER TONNE");
        ResultSet rs = conn.createStatement().executeQuery(sql);
        for(int i = 1;rs.next();i++){
            HSSFRow row = sheet.createRow(i);//set values
                row.createCell(0).setCellValue(rs.getString(1));
                row.createCell(1).setCellValue(rs.getString(2));
                row.createCell(2).setCellValue(rs.getDate(3));
                row.createCell(3).setCellValue(rs.getString(4));
                row.createCell(4).setCellValue(rs.getString(5));
                row.createCell(5).setCellValue(rs.getString(6));
                row.createCell(6).setCellValue(rs.getString(7));
                row.createCell(7).setCellValue(rs.getString(8));
                row.createCell(8).setCellValue(rs.getString(9));
                row.createCell(9).setCellValue(rs.getString(10));
                row.createCell(10).setCellValue(rs.getString(11));
                row.createCell(11).setCellValue(rs.getString(12));
                row.createCell(12).setCellValue(rs.getString(13));
                row.createCell(13).setCellValue(rs.getString(14));
                row.createCell(14).setCellValue(rs.getString(15));
                row.createCell(15).setCellValue(rs.getString(16));
                row.createCell(16).setCellValue(rs.getString(17));
                row.createCell(17).setCellValue(rs.getInt(18));
                row.createCell(18).setCellValue(rs.getInt(19));
                row.createCell(19).setCellValue(rs.getInt(20));
                row.createCell(20).setCellValue(rs.getDouble(21));
                row.createCell(21).setCellValue(rs.getDouble(22));
                row.createCell(22).setCellValue(rs.getDouble(23));
                row.createCell(23).setCellValue(rs.getDouble(24));
                row.createCell(24).setCellValue(rs.getDouble(25));
                row.createCell(25).setCellValue(rs.getString(26));
                row.createCell(26).setCellValue(rs.getString(27));
                row.createCell(27).setCellValue(rs.getInt(28));
                row.createCell(28).setCellValue(rs.getInt(29));
                row.createCell(29).setCellValue(rs.getString(30));
                row.createCell(30).setCellValue(rs.getString(31));
                row.createCell(31).setCellValue(rs.getString(32));
                row.createCell(32).setCellValue(rs.getString(33));
                row.createCell(33).setCellValue(rs.getString(34));
                row.createCell(34).setCellValue(rs.getString(35));
                row.createCell(35).setCellValue(rs.getDouble(36));
                row.createCell(36).setCellValue(rs.getDouble(37));
                row.createCell(37).setCellValue(rs.getDouble(38));
                row.createCell(38).setCellValue(rs.getDouble(39));
        }//file creation and display
        FileOutputStream file = new FileOutputStream("/temp/"+name+".xls");
        wb.write(file);
        file.close();
        
        if (Desktop.isDesktopSupported()) {
    
        File myFile = new File("/temp/"+name+".xls");
        Desktop.getDesktop().open(myFile);
        
        myFile.deleteOnExit();
        }

        
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
     }
        //remove all children chechboxes
        public void remove(){
        p1.getChildren().clear();
        p2.getChildren().clear();
        p3.getChildren().clear();
        p4.getChildren().clear();
        p5.getChildren().clear();
        p6.getChildren().clear();
        p7.getChildren().clear();
    }
        //adding children checkboxes
    public void add(){
        try{
            conn = CONNECT.ConnecterDb();
            ResultSet rs = conn.createStatement().executeQuery("select distinct ITEM_CODE,ITEM_NAME from view_sarl_contribution_sheet where (ITEM_NAME like '%NATUR%' OR ITEM_NAME like '%Natur%') AND ITEM_NATURE ='PG' AND DIV_CODE LIKE 'O%' AND VRDATE <= '"+date2+"' AND VRDATE >= '"+date1+"'");
            for(int j = 0;rs.next();j++){
            labels[j] = rs.getString(2);
            i1 = j;
            }
        for (int j = 0; j < labels.length; j++) {
        CheckBoxTreeItem<String> checkbox = new CheckBoxTreeItem<>(labels[j]);
        checkboxes1.add(checkbox); //for further use you add it to the list
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        
        try{
            conn = CONNECT.ConnecterDb();
            ResultSet rs = conn.createStatement().executeQuery("select distinct ITEM_CODE,ITEM_NAME from view_sarl_contribution_sheet where (ITEM_NAME like '%SUNSU%' OR ITEM_NAME like '%Sunsu%') AND ITEM_NATURE ='PG' AND DIV_CODE LIKE 'O%' AND VRDATE <= '"+date2+"' AND VRDATE >= '"+date1+"'");
            for(int j = 0;rs.next();j++){
            labels[j] = rs.getString(2);
            i2 = j;
            }
        for (int j = 0; j < labels.length; j++) {
        CheckBoxTreeItem<String> checkbox = new CheckBoxTreeItem<>(labels[j]);
        checkboxes2.add(checkbox); //for further use you add it to the list
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        
        try{
            conn = CONNECT.ConnecterDb();
            ResultSet rs = conn.createStatement().executeQuery("select distinct ITEM_CODE,ITEM_NAME from view_sarl_contribution_sheet where (ITEM_NAME like '%KRISHNA B%' OR ITEM_NAME like '%Krishna B%') AND ITEM_NATURE ='PG' AND DIV_CODE LIKE 'O%' AND VRDATE <= '"+date2+"' AND VRDATE >= '"+date1+"'");
            for(int j = 0;rs.next();j++){
            labels[j] = rs.getString(2);
            i3= j;
            }
        for (int j = 0; j < labels.length; j++) {
        CheckBoxTreeItem<String> checkbox = new CheckBoxTreeItem<>(labels[j]);
        checkboxes3.add(checkbox); //for further use you add it to the list
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        
        try{
            conn = CONNECT.ConnecterDb();
            ResultSet rs = conn.createStatement().executeQuery("select distinct ITEM_CODE,ITEM_NAME from view_sarl_contribution_sheet where (ITEM_NAME like '%SRE K%' OR ITEM_NAME like '%SRI K%' OR ITEM_NAME like '%Sre K%' OR ITEM_NAME like '%Sri K%') AND ITEM_NATURE ='PG' AND DIV_CODE LIKE 'O%' AND VRDATE <= '"+date2+"' AND VRDATE >= '"+date1+"'");
            for(int j = 0;rs.next();j++){
            labels[j] = rs.getString(2);
            i4 = j;
            }
        for (int j = 0; j < labels.length; j++) {
        CheckBoxTreeItem<String> checkbox = new CheckBoxTreeItem<>(labels[j]);
        checkboxes4.add(checkbox); //for further use you add it to the list
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        
        try{
            conn = CONNECT.ConnecterDb();
            ResultSet rs = conn.createStatement().executeQuery("select distinct ITEM_CODE,ITEM_NAME from view_sarl_contribution_sheet where (ITEM_NAME like '%MOTHE%' OR ITEM_NAME like '%Mothe%') AND ITEM_NATURE ='PG' AND DIV_CODE LIKE 'O%' AND VRDATE <= '"+date2+"' AND VRDATE >= '"+date1+"'");
            for(int j = 0;rs.next();j++){
            labels[j] = rs.getString(2);
            i5 = j;
            }
        for (int j = 0; j < labels.length; j++) {
        CheckBoxTreeItem<String> checkbox = new CheckBoxTreeItem<>(labels[j]);
        checkboxes5.add(checkbox); //for further use you add it to the list
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        
        try{
            conn = CONNECT.ConnecterDb();
            ResultSet rs = conn.createStatement().executeQuery("select distinct ITEM_CODE,ITEM_NAME from view_sarl_contribution_sheet where (ITEM_NAME like '%RUCHI%' OR ITEM_NAME like '%Ruchi%') AND ITEM_NATURE ='PG' AND DIV_CODE LIKE 'O%' AND VRDATE <= '"+date2+"' AND VRDATE >= '"+date1+"'");
            for(int j = 0;rs.next();j++){
            labels[j] = rs.getString(2);
            i6 = j;
            }
        for (int j = 0; j < labels.length; j++) {
        CheckBoxTreeItem<String> checkbox = new CheckBoxTreeItem<>(labels[j]);
        checkboxes6.add(checkbox); //for further use you add it to the list
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        
        try{
            conn = CONNECT.ConnecterDb();
            ResultSet rs = conn.createStatement().executeQuery("select distinct ITEM_CODE,ITEM_NAME from view_sarl_contribution_sheet where ITEM_NAME not like '%NATUR%' AND ITEM_NAME not like '%SUNSU%' AND ITEM_NAME not like '%KRISH%' AND ITEM_NAME not like '%SRE K%' AND ITEM_NAME not like '%SRI K%' AND ITEM_NAME not like '%MOTHE%' AND ITEM_NAME not like '%RUCHI%' AND ITEM_NAME not like '%Natur%' AND ITEM_NAME not like '%Sunsu%' AND ITEM_NAME not like '%Krish%' AND ITEM_NAME not like '%Sre K%' AND ITEM_NAME not like '%Sri K%' AND ITEM_NAME not like '%Mothe%' AND ITEM_NAME not like '%Ruchi%' AND ITEM_NATURE ='PG' AND DIV_CODE LIKE 'O%' AND VRDATE <= '"+date2+"' AND VRDATE >= '"+date1+"'");
            for(int j = 0;rs.next();j++){
            labels[j] = rs.getString(2);
            i7 = j;
            }
        for (int j = 0; j < labels.length; j++) {
        CheckBoxTreeItem<String> checkbox = new CheckBoxTreeItem<>(labels[j]);
        checkboxes7.add(checkbox); //for further use you add it to the list
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        
        
        for(int k = 0;k <= i1;k++){
        p1.getChildren().add(checkboxes1.get(k));
        }
        
        for(int k = 0;k <= i2;k++){
        p2.getChildren().add(checkboxes2.get(k));
        }
        
        for(int k = 0;k <= i3;k++){
        p3.getChildren().add(checkboxes3.get(k));
        }
        
        for(int k = 0;k <= i4;k++){
        p4.getChildren().add(checkboxes4.get(k));
        }
        
        for(int k = 0;k <= i5;k++){
        p5.getChildren().add(checkboxes5.get(k));
        }
        
        for(int k = 0;k <= i6;k++){
        p6.getChildren().add(checkboxes6.get(k));
        }
        
        for(int k = 0;k <= i7;k++){
        p7.getChildren().add(checkboxes7.get(k));
        }
    }
    //date for setting in d1
    public Date date(){
        try{
            conn = CONNECT.ConnecterDb();
            ResultSet rs = conn.createStatement().executeQuery("select add_months(sysdate,-1) from dual");
            while(rs.next()){
            d = rs.getDate(1);
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        return d;
    }
    //function for preparing bar chart
    public ObservableList<XYChart.Series<String, Double>> barData(){
        
         try{
            conn = CONNECT.ConnecterDb();
            ResultSet rs = conn.createStatement().executeQuery("Select "+x+","+y+" from view_sarl_contribution_sheet where "+z+" ("+test1+" ITEM_CODE = 'MADHAV') AND ITEM_NATURE ='PG' AND DIV_CODE LIKE 'O%' AND VRDATE <= '"+date2+"' AND VRDATE >= '"+date1+"' "+group+"");
            while(rs.next()){
                s1.getData().add(new XYChart.Data(rs.getString(1), rs.getDouble(2)));
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
            }
        data.addAll(s1);
        s1.setName("NATURRALLE");
        
        try{
            conn = CONNECT.ConnecterDb();
            ResultSet rs = conn.createStatement().executeQuery("Select "+x+","+y+" from view_sarl_contribution_sheet where  "+z+" ("+test2+" ITEM_CODE = 'MADHAV') AND ITEM_NATURE ='PG' AND DIV_CODE LIKE 'O%' AND VRDATE <= '"+date2+"' AND VRDATE >= '"+date1+"' "+group+"");
            while(rs.next()){
                s2.getData().add(new XYChart.Data(rs.getString(1), rs.getDouble(2)));
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
            }
        data.addAll(s2);
        s2.setName("SUNSURRE");
        
        try{
            conn = CONNECT.ConnecterDb();
            ResultSet rs = conn.createStatement().executeQuery("Select "+x+","+y+" from view_sarl_contribution_sheet where "+z+" ("+test3+" ITEM_CODE = 'MADHAV') AND ITEM_NATURE ='PG' AND DIV_CODE LIKE 'O%' AND VRDATE <= '"+date2+"' AND VRDATE >= '"+date1+"' "+group+"");
            while(rs.next()){
                s3.getData().add(new XYChart.Data(rs.getString(1), rs.getDouble(2)));
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
            }
        data.addAll(s3);
        s3.setName("KRISHNA BRAND");
        
        try{
            conn = CONNECT.ConnecterDb();
            ResultSet rs = conn.createStatement().executeQuery("Select "+x+","+y+" from view_sarl_contribution_sheet where "+z+" ("+test4+" ITEM_CODE = 'MADHAV') AND ITEM_NATURE ='PG' AND DIV_CODE LIKE 'O%' AND VRDATE <= '"+date2+"' AND VRDATE >= '"+date1+"' "+group+"");
            while(rs.next()){
                s4.getData().add(new XYChart.Data(rs.getString(1), rs.getDouble(2)));
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
            }
        data.addAll(s4);
        s4.setName("SRE KRISHNA");
        
        try{
            conn = CONNECT.ConnecterDb();
            ResultSet rs = conn.createStatement().executeQuery("Select "+x+","+y+" from view_sarl_contribution_sheet where "+z+" ("+test5+" ITEM_CODE = 'MADHAV') AND ITEM_NATURE ='PG' AND DIV_CODE LIKE 'O%' AND VRDATE <= '"+date2+"' AND VRDATE >= '"+date1+"' "+group+"");
            while(rs.next()){
                s5.getData().add(new XYChart.Data(rs.getString(1), rs.getDouble(2)));
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
            }
        data.addAll(s5);
        s5.setName("MOTHER'S CHOICE");
        
        try{
            conn = CONNECT.ConnecterDb();
            ResultSet rs = conn.createStatement().executeQuery("Select "+x+","+y+" from view_sarl_contribution_sheet where "+z+" ("+test6+" ITEM_CODE = 'MADHAV') AND ITEM_NATURE ='PG' AND DIV_CODE LIKE 'O%' AND VRDATE <= '"+date2+"' AND VRDATE >= '"+date1+"' "+group+"");
            while(rs.next()){
                s6.getData().add(new XYChart.Data(rs.getString(1), rs.getDouble(2)));
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
            }
        data.addAll(s6);
        s6.setName("RUCHIRRA");
        
        try{
            conn = CONNECT.ConnecterDb();
            ResultSet rs = conn.createStatement().executeQuery("Select "+x+","+y+" from view_sarl_contribution_sheet where "+z+" ("+test7+" ITEM_CODE = 'MADHAV') AND ITEM_NATURE ='PG' AND DIV_CODE LIKE 'O%' AND VRDATE <= '"+date2+"' AND VRDATE >= '"+date1+"' "+group+"");
            while(rs.next()){
                s7.getData().add(new XYChart.Data(rs.getString(1), rs.getDouble(2)));
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
            }
        data.addAll(s7);
        s7.setName("OTHERS");
        
        
        return data;
    }
    
    //funtion for preparing line chart
    public ObservableList<XYChart.Series<String, Double>> lineData(){
        
        try{
            conn = CONNECT.ConnecterDb();
            ResultSet rs = conn.createStatement().executeQuery("Select "+x+","+y+" from view_sarl_contribution_sheet where "+z+" ("+test1+test2+test3+test4+test5+test6+test7+" ITEM_CODE = 'madhav') AND ITEM_NATURE ='PG' AND DIV_CODE LIKE 'O%' AND VRDATE <= '"+date2+"' AND VRDATE >= '"+date1+"' "+group+"");
            while(rs.next()){
                s8.getData().add(new XYChart.Data(rs.getString(1), rs.getDouble(2)));
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
            }
        data1.addAll(s8);
        return data1;
    }
    
    
    public ObservableList<XYChart.Series<String, Double>> barData_default(){
        
        try{
            conn = CONNECT.ConnecterDb();
            ResultSet rs = conn.createStatement().executeQuery("select PRICE_LIST_PROD,(((SUM(AFIELD1)-NVL(SUM(QTY*GET_PG_PACK_SIZE(DC,IC,'EXP',VRDATE)),0)-NVL((SUM(GET_FRT_RATE(DC,IC,AREA_CODE,'P',vrdate,FB)*QTY)),0)-NVL(SUM(GET_SARL_SCHEME_RATE(ACC_CODE,IC,VRDATE)*QTY),0)-\n" +
"SUM(NVL(FNC_SWG_SCHEME(EC,DC,ACC_CODE,VRDATE,VRNO,IC,QTY,'AMT',AC,FB),0))-\n" +
"NVL(SUM(GET_FRT_RATE(DC,IC,AC,'S',vrdate,FB)*QTY),0)))-((SUM(GET_CRUDE_RATE(DC,IC,VRDATE,ITN,'NETRATE',VRNO)*GET_PG_PACK_SIZE(DC,IC,'SIZE',VRDATE)*QTY)/SUM(QTY))*SUM(QTY)))/(SUM(QTY*GET_PG_PACK_SIZE(DC,IC,'SIZE',VRDATE))/1000) from view_sarl_contribution_sheet where VRDATE >= '"+a+"' AND ITEM_NATURE ='PG' AND DIV_CODE LIKE 'O%' Group By PRICE_LIST_PROD");
            while(rs.next()){
                sd.getData().add(new XYChart.Data(rs.getString(1), rs.getDouble(2)));
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        sd.setName("Contribution");
        datad.addAll(sd);
        return datad;
    }
    
    public ObservableList<XYChart.Series<String, Double>> barData_default1(){
        
        try{
            conn = CONNECT.ConnecterDb();
            ResultSet rs = conn.createStatement().executeQuery("select PRICE_LIST_PROD,"+y+" from view_sarl_contribution_sheet where "+z+" ("+test1+test2+test3+test4+test5+test6+test7+" ITEM_CODE = 'madhav') AND ITEM_NATURE ='PG' AND DIV_CODE LIKE 'O%' AND VRDATE <= '"+date2+"' AND VRDATE >= '"+date1+"' Group By PRICE_LIST_PROD");
            while(rs.next()){
                sd1.getData().add(new XYChart.Data(rs.getString(2), rs.getDouble(3)));
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        sd1.setName("Brand");
        datad1.addAll(sd1);
        return datad1;
    }
    
     public ObservableList<XYChart.Series<String, Double>> lineData_default(){
        
        try{
            conn = CONNECT.ConnecterDb();
            ResultSet rs = conn.createStatement().executeQuery("select PRICE_LIST_PROD,"+y+" from view_sarl_contribution_sheet where "+z+" ("+test1+test2+test3+test4+test5+test6+test7+" ITEM_NAME like 'madhav') AND ITEM_NATURE ='PG' AND DIV_CODE LIKE 'O%' AND VRDATE <= '"+date2+"' AND VRDATE >= '"+date1+"' Group By PRICE_LIST_PROD");
            while(rs.next()){
                sd2.getData().add(new XYChart.Data(rs.getString(2), rs.getDouble(3)));
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        sd2.setName("Brand");
        datad2.addAll(sd2);
        return datad2;
    }
    
    public void pieData(){
        
        try{
            conn = CONNECT.ConnecterDb();
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("Select "+x+","+y+" from view_sarl_contribution_sheet where "+z+" ("+test1+test2+test3+test4+test5+test6+test7+" ITEM_NAME = 'madhav') AND VRDATE <= '"+date2+"' AND VRDATE >= '"+date1+"' AND ITEM_NATURE ='PG' AND DIV_CODE LIKE 'O%' "+group+"");
        
        while(rs.next()){
            datapie.addAll(new javafx.scene.chart.PieChart.Data(rs.getString(1),rs.getDouble(2)));
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public void pieData1(){
        
        try{
            conn = CONNECT.ConnecterDb();
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("select PRICE_LIST_PROD,"+y+" from view_sarl_contribution_sheet where "+z+" ("+test1+test2+test3+test4+test5+test6+test7+" ITEM_NAME like 'madhav') AND ITEM_NATURE ='PG' AND DIV_CODE LIKE 'O%' AND VRDATE <= '"+date2+"' AND VRDATE >= '"+date1+"' Group By PRICE_LIST_PROD");
        
        while(rs.next()){
            datapie1.addAll(new javafx.scene.chart.PieChart.Data(rs.getString(1),rs.getDouble(2)));
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public ObservableList<XYChart.Series<String, Double>> barData2(){
        try{
            conn = CONNECT.ConnecterDb();
            ResultSet rs = conn.createStatement().executeQuery(sql);
            while(rs.next()){
                s11.getData().add(new XYChart.Data(rs.getString(1), rs.getDouble(2)));
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        data2.addAll(s11);
        return data2;
    }
    
    @Override
    public void start(Stage primaryStage) {
        BorderPane root = new BorderPane();
        BorderPane root1 = new BorderPane();
        BorderPane root2 = new BorderPane();
        Scene scene = new Scene(root, 1280, 720);
        Scene scene1 = new Scene(root1, 1280, 720);
        Scene scene2 = new Scene(root2, 1280, 720);
        ToolBar t1 = new ToolBar();
        ToolBar t2 = new ToolBar();
        
        DatePicker d1 = new DatePicker(date().toLocalDate());
        DatePicker d2 = new DatePicker(LocalDate.now());
        
        Button btnbk = new Button("Back");
        Button btn = new Button("Back");
        Button btnback1 = new Button("Back");
        Button btnback2 = new Button("Back");
        Button btn1 = new Button("Bar Chart");
        Button btn2 = new Button("Line Chart");
        Button btn3 = new Button("Pie Chart");
        Button refresh = new Button("Refresh");
        
        Label l1 = new Label("From");
        Label l2 = new Label("To");
        
        ComboBox cb1 = new ComboBox(options1);
        ComboBox cb2 = new ComboBox(options2);
        ComboBox cb3 = new ComboBox(options3);
        
        cb3.getSelectionModel().selectFirst();
        
        cb1.setPromptText("Coulmn 1");
        cb2.setPromptText("Coulmn 2");
        
        t1.getItems().addAll(l1,d1,l2,d2,cb1,cb2,cb3,refresh);
        t2.getItems().addAll(btnbk,btn1,btn2,btn3);
        
        a = fr.format(date()).toString();
        
        CategoryAxis xAxis = new CategoryAxis();
        NumberAxis yAxis = new NumberAxis();
        BarChart bc = new BarChart(xAxis,yAxis,barData_default());
        xAxis.setLabel("Product");
        yAxis.setLabel("Contribution per tonne");
        
        refresh.setOnAction(e->{
            date1 = fr.format(Date.valueOf(d1.getValue())).toString();
            date2 = fr.format(Date.valueOf(d2.getValue())).toString();
            remove();
            add();
        });
        date1 = fr.format(Date.valueOf(d1.getValue())).toString();
        date2 = fr.format(Date.valueOf(d2.getValue())).toString();
        add();
        
        CategoryAxis xAxis1 = new CategoryAxis();
        NumberAxis yAxis1 = new NumberAxis();
        
        CategoryAxis xAxis2 = new CategoryAxis();
        NumberAxis yAxis2 = new NumberAxis();
        
        CategoryAxis xAxis3 = new CategoryAxis();
        NumberAxis yAxis3 = new NumberAxis();
        
        CategoryAxis xAxis4 = new CategoryAxis();
        NumberAxis yAxis4 = new NumberAxis();
        
        CategoryAxis xAxis5 = new CategoryAxis();
        NumberAxis yAxis5 = new NumberAxis();
        
        CategoryAxis xAxis6 = new CategoryAxis();
        NumberAxis yAxis6 = new NumberAxis();
        
        CategoryAxis xAxis7 = new CategoryAxis();
        NumberAxis yAxis7 = new NumberAxis();
        
        btn1.setOnAction(e->{
            
        try{
                conn = CONNECT.ConnecterDb();
                ResultSet rs = conn.createStatement().executeQuery("select distinct ITEM_CODE from view_sarl_contribution_sheet where ITEM_NAME like '%NATUR%' AND VRDATE <= '"+date2+"' AND VRDATE >= '"+date1+"'");
                for(int k = 0;rs.next();k++){
                if(checkboxes1.get(k).isSelected()){
                test1 = test1+"ITEM_CODE = '"+rs.getString(1)+"' OR ";
                    }
                }
            }
             catch(Exception i){
                 JOptionPane.showMessageDialog(null, i);
             }
            
            try{
                conn = CONNECT.ConnecterDb();
                ResultSet rs = conn.createStatement().executeQuery("select distinct ITEM_CODE from view_sarl_contribution_sheet where ITEM_NAME like '%SUNSU%' AND VRDATE <= '"+date2+"' AND VRDATE >= '"+date1+"'");
                for(int k = 0;rs.next();k++){
                if(checkboxes2.get(k).isSelected()){
                test2 = test2+"ITEM_CODE = '"+rs.getString(1)+"' OR ";
                    }
                }
            }
             catch(Exception i){
                 JOptionPane.showMessageDialog(null, i);
             }
            
            try{
                conn = CONNECT.ConnecterDb();
                ResultSet rs = conn.createStatement().executeQuery("select distinct ITEM_CODE from view_sarl_contribution_sheet where ITEM_NAME like '%KRISHNA B%' AND VRDATE <= '"+date2+"' AND VRDATE >= '"+date1+"'");
                for(int k = 0;rs.next();k++){
                if(checkboxes3.get(k).isSelected()){
                test3 = test3+"ITEM_CODE = '"+rs.getString(1)+"' OR ";
                    }
                }
            }
             catch(Exception i){
                 JOptionPane.showMessageDialog(null, i);
             }
            
            try{
                conn = CONNECT.ConnecterDb();
                ResultSet rs = conn.createStatement().executeQuery("select distinct ITEM_CODE from view_sarl_contribution_sheet where (ITEM_NAME like '%SRE K%' OR ITEM_NAME like '%SRI K%') AND VRDATE <= '"+date2+"' AND VRDATE >= '"+date1+"'");
                for(int k = 0;rs.next();k++){
                if(checkboxes4.get(k).isSelected()){
                test4 = test4+"ITEM_CODE = '"+rs.getString(1)+"' OR ";
                    }
                }
            }
             catch(Exception i){
                 JOptionPane.showMessageDialog(null, i);
             }
            
            try{
                conn = CONNECT.ConnecterDb();
                ResultSet rs = conn.createStatement().executeQuery("select distinct ITEM_CODE from view_sarl_contribution_sheet where ITEM_NAME like '%MOTHE%' AND VRDATE <= '"+date2+"' AND VRDATE >= '"+date1+"'");
                for(int k = 0;rs.next();k++){
                if(checkboxes5.get(k).isSelected()){
                test5 = test5+"ITEM_CODE = '"+rs.getString(1)+"' OR ";
                    }
                }
            }
             catch(Exception i){
                 JOptionPane.showMessageDialog(null, i);
             }
            
            try{
                conn = CONNECT.ConnecterDb();
                ResultSet rs = conn.createStatement().executeQuery("select distinct ITEM_CODE from view_sarl_contribution_sheet where ITEM_NAME like '%RUCHI%' AND VRDATE <= '"+date2+"' AND VRDATE >= '"+date1+"'");
                for(int k = 0;rs.next();k++){
                if(checkboxes6.get(k).isSelected()){
                test6 = test6+"ITEM_CODE = '"+rs.getString(1)+"' OR ";
                    }
                }
            }
             catch(Exception i){
                 JOptionPane.showMessageDialog(null, i);
             }
            
            try{
                conn = CONNECT.ConnecterDb();
                ResultSet rs = conn.createStatement().executeQuery("select distinct ITEM_CODE from view_sarl_contribution_sheet where ITEM_NAME not like '%NATUR%' AND ITEM_NAME not like '%SUNSU%' AND ITEM_NAME not like '%KRISH%' AND ITEM_NAME not like '%SRE K%' AND ITEM_NAME not like '%SRI K%' AND ITEM_NAME not like '%MOTHE%' AND ITEM_NAME not like '%RUCHI%' AND VRDATE <= '"+date2+"' AND VRDATE >= '"+date1+"'");
                for(int k = 0;rs.next();k++){
                if(checkboxes7.get(k).isSelected()){
                test7 = test7+"ITEM_CODE = '"+rs.getString(1)+"' OR ";  
                    }
                }
            }
             catch(Exception i){
                 JOptionPane.showMessageDialog(null, i);
             }
        
        option3 = cb3.getValue().toString();
        if(option3 == "Telangana"){
            z = "STATE_CODE = 'TS' AND ";
        }
        if(option3 == "Andhra Pradesh"){
            z = "STATE_CODE = 'AP' AND ";
        }
        if(option3 == "Maharashtra"){
            z = "STATE_CODE = 'MH' AND ";
        }
        if(option3 == "Karnataka"){
            z = "STATE_CODE = 'KA' AND ";
        }
        if(option3 == "Tamil Nadu"){
            z = "STATE_CODE = 'TN' AND ";
        }
        if(option3 == "Gujarat"){
            z = "STATE_CODE = 'GJ' AND ";
        }
        if(option3 == "Chattisgarh"){
            z = "STATE_CODE = 'CG' AND ";
        }
        if(option3 == "Madhya Pradesh"){
            z = "STATE_CODE = 'MP' AND ";
        }
        option1 = cb1.getValue().toString();
        if(option1 == "Date"){
            x = " VRDATE ";
        }
        if(option1 == "Item Name"){
            x = " ITEM_NAME ";
        }
        if(option1 == "District"){
            x = " DISTRICT ";
        }
        if(option1 == "Year"){
            x = " to_char(VRDATE , 'yyyy') ";
        }
        if(option1 == "Month"){
            x = " to_char(VRDATE , 'mm') ";
        }
        if(option1 == "Week"){
            x = " to_char(VRDATE , 'ww') ";
        }
        if(option1 == "Brand"){
            x = " PRICE_LIST_PROD ";
        }
        option2 = cb2.getValue().toString();
        if(option2 == "Quantity in Tonne"){
            y = "SUM(QTYORDER*PROD_SIZE/1000)-NVL(SUM(QTYCANCELLED*PROD_SIZE/1000),0)";
        }
        if(option2 == "Rate per Tonne"){
            y = "(SUM(AFIELD1)/SUM(QTYORDER))/(SUM(QTYORDER*PROD_SIZE/1000)-NVL(SUM(QTYCANCELLED*PROD_SIZE/1000),0)) ";
        }
        if(option2 == "Cost Value"){
            y = "(SUM(GET_CRUDE_RATE(DIV_CODE,ITEM_CODE,VRDATE,ITEM_NATURE,'NETRATE',VRNO)*GET_PG_PACK_SIZE(DIV_CODE,ITEM_CODE,'SIZE',VRDATE)*QTYORDER)/SUM(QTYORDER))*SUM(QTYORDER)";
        }
        if(option2 == "Contribution"){
            y = "((SUM(AFIELD1)-NVL(SUM(QTY*GET_PG_PACK_SIZE(DC,IC,'EXP',VRDATE)),0)-NVL((SUM(GET_FRT_RATE(DC,IC,AREA_CODE,'P',vrdate,FB)*QTY)),0)-NVL(SUM(GET_SARL_SCHEME_RATE(ACC_CODE,IC,VRDATE)*QTY),0)-\n" +
                "SUM(NVL(FNC_SWG_SCHEME(EC,DC,ACC_CODE,VRDATE,VRNO,IC,QTY,'AMT',AREA_CODE,FREIGHT_BASIS),0))-\n" +
                "NVL(SUM(GET_FRT_RATE(DC,IC,AREA_CODE,'S',vrdate,FREIGHT_BASIS)*QTY),0)))-((SUM(NVL(GET_CRUDE_RATE(DC,IC,VRDATE,ITN,'NETRATE',VRNO),0)*GET_PG_PACK_SIZE(DC,IC,'SIZE',VRDATE)*QTY)/SUM(QTY))*SUM(QTY)) ";
        }
        if(option2 == "Contribution Per Tonne"){
            y = "(((SUM(AFIELD1)-NVL(SUM(QTY*GET_PG_PACK_SIZE(DC,IC,'EXP',VRDATE)),0)-NVL((SUM(GET_FRT_RATE(DC,IC,AREA_CODE,'P',vrdate,FB)*QTY)),0)-NVL(SUM(GET_SARL_SCHEME_RATE(ACC_CODE,IC,VRDATE)*QTY),0)-\n" +
                "SUM(NVL(FNC_SWG_SCHEME(EC,DC,ACC_CODE,VRDATE,VRNO,IC,QTY,'AMT',AC,FB),0))-\n" +
                "NVL(SUM(GET_FRT_RATE(DC,IC,AC,'S',vrdate,FB)*QTY),0)))-((SUM(GET_CRUDE_RATE(DC,IC,VRDATE,ITN,'NETRATE',VRNO)*GET_PG_PACK_SIZE(DC,IC,'SIZE',VRDATE)*QTY)/SUM(QTY))*SUM(QTY)))/(SUM(QTY*GET_PG_PACK_SIZE(DC,IC,'SIZE',VRDATE))/1000) ";
        }
        
        if(option1 == "State"){
            z = "";
            x = "STATE_CODE";
        }
        
        group = " Group By "+x+"";
        
        date1 = fr.format(Date.valueOf(d1.getValue())).toString();
        date2 = fr.format(Date.valueOf(d2.getValue())).toString();
        
        if(option2 != "Rate per Tonne" && option2 != "Contribution Per Tonne" && option1 != "Brand"){
        StackedBarChart bc1 = new StackedBarChart(xAxis1,yAxis1,barData());
        xAxis1.setLabel(option1);
        yAxis1.setLabel(option2);
        root1.setCenter(bc1);
        }
        
        if((option2 == "Rate per Tonne" || option2 == "Contribution Per Tonne")&& option1 != "Brand"){
        BarChart bc2 = new BarChart(xAxis4,yAxis4,lineData());
        xAxis4.setLabel(option1);
        yAxis4.setLabel(option2);
        root1.setCenter(bc2);
        }
        if(option1 == "Brand"){
            BarChart bc3 = new BarChart(xAxis6,yAxis6,barData_default1());
            xAxis6.setLabel(option1);
            yAxis6.setLabel(option2);
            root1.setCenter(bc3);
        }
        
        for(XYChart.Data<String,Double> datad : s1.getData()){
            if(x == "STATE_CODE"){
            Node n1 = datad.getNode();
            n1.setOnMouseClicked(c->{
                
                ma = datad.getXValue();
                sql = "select DISTRICT,"+y+" from view_sarl_contribution_sheet where STATE_CODE = '"+ma+"' AND VRDATE <= '"+date2+"' AND VRDATE >= '"+date1+"' AND ITEM_NAME like '%NATUR%' AND ITEM_NATURE ='PG' AND DIV_CODE LIKE 'O%' group by DISTRICT";
                BarChart bc2 = new BarChart(xAxis3,yAxis3,barData2()); 
                xAxis3.setLabel("District");
                yAxis3.setLabel(option2);
                
                for(XYChart.Data<String,Double> dataxl : s11.getData()){
                    Node n2 = dataxl.getNode();
                    n2.setOnMouseClicked(r->{
                        exportTable("select "+table+" from view_sarl_contribution_sheet where DISTRICT = '"+dataxl.getXValue()+"' AND VRDATE <= '"+date2+"' AND VRDATE >= '"+date1+"' AND ITEM_NAME like '%NATUR%' AND ITEM_NATURE ='PG' AND DIV_CODE LIKE 'O%'",dataxl.getXValue());
                    });
                }
                
                root2.setCenter(bc2);
                root2.setBottom(btnback1);
                primaryStage.setScene(scene2);
                primaryStage.show();
                
                btnback1.setOnAction(b->{
                    data2.clear();
                    s11.getData().clear();
                    primaryStage.setScene(scene1);
                    primaryStage.show();
                    });
                });
            }
        }
            
            for(XYChart.Data<String,Double> datad : s2.getData()){
                if(x == "STATE_CODE"){
            Node n1 = datad.getNode();
            n1.setOnMouseClicked(c->{
                
                ma = datad.getXValue();
                sql = "select DISTRICT,"+y+" from view_sarl_contribution_sheet where STATE_CODE = '"+ma+"' AND VRDATE <= '"+date2+"' AND VRDATE >= '"+date1+"' AND ITEM_NAME like '%SUNSU%' AND ITEM_NATURE ='PG' AND DIV_CODE LIKE 'O%' group by DISTRICT";
                BarChart bc2 = new BarChart(xAxis3,yAxis3,barData2()); 
                xAxis3.setLabel("District");
                yAxis3.setLabel(option2);
                
                for(XYChart.Data<String,Double> dataxl : s11.getData()){
                    Node n2 = dataxl.getNode();
                    n2.setOnMouseClicked(r->{
                        exportTable("select "+table+" from view_sarl_contribution_sheet where DISTRICT = '"+dataxl.getXValue()+"' AND VRDATE <= '"+date2+"' AND VRDATE >= '"+date1+"' AND ITEM_NAME like '%SUNSU%' AND ITEM_NATURE ='PG' AND DIV_CODE LIKE 'O%'",dataxl.getXValue());
                    });
                }
                
                root2.setCenter(bc2);
                root2.setBottom(btnback1);
                primaryStage.setScene(scene2);
                primaryStage.show();
                
                btnback1.setOnAction(b->{
                    data2.clear();
                    s11.getData().clear();
                    primaryStage.setScene(scene1);
                    primaryStage.show();
                    });
                });
            }
        }
            for(XYChart.Data<String,Double> datad : s3.getData()){
                if(x == "STATE_CODE"){
            Node n1 = datad.getNode();
            n1.setOnMouseClicked(c->{
                
                ma = datad.getXValue();
                sql = "select DISTRICT,"+y+" from view_sarl_contribution_sheet where STATE_CODE = '"+ma+"' AND VRDATE <= '"+date2+"' AND VRDATE >= '"+date1+"' AND ITEM_NAME like '%KRISH%' AND ITEM_NATURE ='PG' AND DIV_CODE LIKE 'O%' group by DISTRICT";
                BarChart bc2 = new BarChart(xAxis3,yAxis3,barData2()); 
                xAxis3.setLabel("District");
                yAxis3.setLabel(option2);
                
                for(XYChart.Data<String,Double> dataxl : s11.getData()){
                    Node n2 = dataxl.getNode();
                    n2.setOnMouseClicked(r->{
                        exportTable("select "+table+" from view_sarl_contribution_sheet where DISTRICT = '"+dataxl.getXValue()+"' AND VRDATE <= '"+date2+"' AND VRDATE >= to_date('"+date1+"','yyyy/mm/dd') AND ITEM_NAME like '%KRISH%' AND ITEM_NATURE ='PG' AND DIV_CODE LIKE 'O%'",dataxl.getXValue());
                    });
                }
                
                root2.setCenter(bc2);
                root2.setBottom(btnback1);
                primaryStage.setScene(scene2);
                primaryStage.show();
                
                btnback1.setOnAction(b->{
                    data2.clear();
                    s11.getData().clear();
                    primaryStage.setScene(scene1);
                    primaryStage.show();
                    });
                });
            }
        }
            for(XYChart.Data<String,Double> datad : s4.getData()){
                if(x == "STATE_CODE"){
            Node n1 = datad.getNode();
            n1.setOnMouseClicked(c->{
                
                ma = datad.getXValue();
                sql = "select DISTRICT,"+y+" from view_sarl_contribution_sheet where STATE_CODE = '"+ma+"' AND VRDATE <= '"+date2+"' AND VRDATE >= '"+date1+"' AND ITEM_NAME like '%SRE K%' AND ITEM_NATURE ='PG' AND DIV_CODE LIKE 'O%' group by DISTRICT";
                BarChart bc2 = new BarChart(xAxis3,yAxis3,barData2()); 
                xAxis3.setLabel("District");
                yAxis3.setLabel(option2);
                
                for(XYChart.Data<String,Double> dataxl : s11.getData()){
                    Node n2 = dataxl.getNode();
                    n2.setOnMouseClicked(r->{
                        exportTable("select "+table+" from view_sarl_contribution_sheet where DISTRICT = '"+dataxl.getXValue()+"' AND VRDATE <= '"+date2+"' AND VRDATE >= '"+date1+"' AND ITEM_NAME like '%SRE K%' AND ITEM_NATURE ='PG' AND DIV_CODE LIKE 'O%'",dataxl.getXValue());
                    });
                }
                
                root2.setCenter(bc2);
                root2.setBottom(btnback1);
                primaryStage.setScene(scene2);
                primaryStage.show();
                
                btnback1.setOnAction(b->{
                    data2.clear();
                    s11.getData().clear();
                    primaryStage.setScene(scene1);
                    primaryStage.show();
                    });
                });
            }
        }
            for(XYChart.Data<String,Double> datad : s5.getData()){
                if(x == "STATE_CODE"){
            Node n1 = datad.getNode();
            n1.setOnMouseClicked(c->{
                
                ma = datad.getXValue();
                sql = "select DISTRICT,"+y+" from view_sarl_contribution_sheet where STATE_CODE = '"+ma+"' AND VRDATE <= '"+date2+"' AND VRDATE >= '"+date1+"' AND ITEM_NAME like '%MOTHE%' AND ITEM_NATURE ='PG' AND DIV_CODE LIKE 'O%' group by DISTRICT";
                BarChart bc2 = new BarChart(xAxis3,yAxis3,barData2()); 
                xAxis3.setLabel("District");
                yAxis3.setLabel(option2);
                
                for(XYChart.Data<String,Double> dataxl : s11.getData()){
                    Node n2 = dataxl.getNode();
                    n2.setOnMouseClicked(r->{
                        exportTable("select "+table+" from view_sarl_contribution_sheet where DISTRICT = '"+dataxl.getXValue()+"' AND VRDATE <= '"+date2+"' AND VRDATE >= '"+date1+"' AND ITEM_NAME like '%MOTHE%' AND ITEM_NATURE ='PG' AND DIV_CODE LIKE 'O%'",dataxl.getXValue());
                    });
                }
                
                root2.setCenter(bc2);
                root2.setBottom(btnback1);
                primaryStage.setScene(scene2);
                primaryStage.show();
                
                btnback1.setOnAction(b->{
                    data2.clear();
                    s11.getData().clear();
                    primaryStage.setScene(scene1);
                    primaryStage.show();
                    });
                });
            }
        }
            for(XYChart.Data<String,Double> datad : s6.getData()){
                if(x == "STATE_CODE"){
            Node n1 = datad.getNode();
            n1.setOnMouseClicked(c->{
                
                ma = datad.getXValue();
                sql = "select DISTRICT,"+y+" from view_sarl_contribution_sheet where STATE_CODE = '"+ma+"' AND VRDATE <= '"+date2+"' AND VRDATE >= '"+date1+"' AND ITEM_NAME like '%RUCHI%' AND ITEM_NATURE ='PG' AND DIV_CODE LIKE 'O%' group by DISTRICT";
                BarChart bc2 = new BarChart(xAxis3,yAxis3,barData2()); 
                xAxis3.setLabel("District");
                yAxis3.setLabel(option2);
                
                for(XYChart.Data<String,Double> dataxl : s11.getData()){
                    Node n2 = dataxl.getNode();
                    n2.setOnMouseClicked(r->{
                        exportTable("select "+table+" from view_sarl_contribution_sheet where DISTRICT = '"+dataxl.getXValue()+"' AND VRDATE <= '"+date2+"' AND VRDATE >= '"+date1+"' AND ITEM_NAME like '%RUCHI%' AND ITEM_NATURE ='PG' AND DIV_CODE LIKE 'O%'",dataxl.getXValue());
                    });
                }
                
                root2.setCenter(bc2);
                root2.setBottom(btnback1);
                primaryStage.setScene(scene2);
                primaryStage.show();
                
                btnback1.setOnAction(b->{
                    data2.clear();
                    s11.getData().clear();
                    primaryStage.setScene(scene1);
                    primaryStage.show();
                    });
                });
            }
        }
            for(XYChart.Data<String,Double> datad : s7.getData()){
                if(x == "STATE_CODE"){
            Node n1 = datad.getNode();
            n1.setOnMouseClicked(c->{
                
                ma = datad.getXValue();
                sql = "select DISTRICT,"+y+" from view_sarl_contribution_sheet where STATE_CODE = '"+ma+"' AND VRDATE <= '"+date2+"' AND VRDATE >= '"+date1+"' AND ITEM_NAME not like '%NATUR%' AND ITEM_NAME not like '%SUNSU%' AND ITEM_NAME not like '%KRISH%' AND ITEM_NAME not like '%SRE K%' AND ITEM_NAME not like '%MOTHE%' AND ITEM_NAME not like '%RUCHI%' AND ITEM_NATURE ='PG' AND DIV_CODE LIKE 'O%' group by DISTRICT";
                BarChart bc2 = new BarChart(xAxis3,yAxis3,barData2()); 
                xAxis3.setLabel("District");
                yAxis3.setLabel(option2);
                
                for(XYChart.Data<String,Double> dataxl : s11.getData()){
                    Node n2 = dataxl.getNode();
                    n2.setOnMouseClicked(r->{
                        exportTable("select "+table+" from view_sarl_contribution_sheet where DISTRICT = '"+dataxl.getXValue()+"' AND VRDATE <= '"+date2+"' AND VRDATE >= '"+date1+"' AND ITEM_NAME not like '%NATUR%' AND ITEM_NAME not like '%SUNSU%' AND ITEM_NAME not like '%KRISH%' AND ITEM_NAME not like '%SRE K%' AND ITEM_NAME not like '%MOTHE%' AND ITEM_NAME not like '%RUCHI%' AND ITEM_NATURE ='PG' AND DIV_CODE LIKE 'O%'",dataxl.getXValue());
                    });
                }
                
                root2.setCenter(bc2);
                root2.setBottom(btnback1);
                primaryStage.setScene(scene2);
                primaryStage.show();
                
                btnback1.setOnAction(b->{
                    data2.clear();
                    s11.getData().clear();
                    primaryStage.setScene(scene1);
                    primaryStage.show();
                    });
                });
            }
        }
            for(XYChart.Data<String,Double> data : s1.getData()){
                if(x == " VRDATE "){
                Node n1 = data.getNode();
                n1.setOnMouseClicked(c->{
                    
                        date = data.getXValue();
                   exportTable("select "+table+" from view_sarl_contribution_sheet where VRDATE = '"+date+"' AND "+z+" ("+test1+" ITEM_NAME = 'madhav') AND ITEM_NATURE ='PG' AND DIV_CODE LIKE 'O%'",data.getXValue());
                });
            }
        }
            for(XYChart.Data<String,Double> data : s2.getData()){
                if(x == " VRDATE "){
                Node n1 = data.getNode();
                n1.setOnMouseClicked(c->{
                    
                        date = data.getXValue();
                   exportTable("select "+table+" from view_sarl_contribution_sheet where VRDATE = '"+date+"' AND "+z+" ("+test2+" ITEM_NAME = 'madhav') AND ITEM_NATURE ='PG' AND DIV_CODE LIKE 'O%'",data.getXValue());
                });
            }
        }
            for(XYChart.Data<String,Double> data : s3.getData()){
                if(x == " VRDATE "){
                Node n1 = data.getNode();
                n1.setOnMouseClicked(c->{
                    
                        date = data.getXValue();
                   exportTable("select "+table+" from view_sarl_contribution_sheet where VRDATE = '"+date+"' AND "+z+" ("+test3+" ITEM_NAME = 'madhav') AND ITEM_NATURE ='PG' AND DIV_CODE LIKE 'O%'",data.getXValue());
                });
            }
        }
            for(XYChart.Data<String,Double> data : s4.getData()){
                if(x == " VRDATE "){
                Node n1 = data.getNode();
                n1.setOnMouseClicked(c->{
                    
                        date = data.getXValue();
                   exportTable("select "+table+" from view_sarl_contribution_sheet where VRDATE = '"+date+"' AND "+z+" ("+test4+" ITEM_NAME = 'madhav') AND ITEM_NATURE ='PG' AND DIV_CODE LIKE 'O%'",data.getXValue());
                    
                });
            }
        }
            for(XYChart.Data<String,Double> data : s5.getData()){
                if(x == " VRDATE "){
                Node n1 = data.getNode();
                n1.setOnMouseClicked(c->{
                    
                        date = data.getXValue();
                   exportTable("select "+table+" from view_sarl_contribution_sheet where VRDATE = '"+date+"' AND "+z+" ("+test5+" ITEM_NAME = 'madhav') AND ITEM_NATURE ='PG' AND DIV_CODE LIKE 'O%'",data.getXValue());
                    
                });
            }
        }
            for(XYChart.Data<String,Double> data : s6.getData()){
                if(x == " VRDATE "){
                Node n1 = data.getNode();
                n1.setOnMouseClicked(c->{
                    
                        date = data.getXValue();
                   exportTable("select "+table+" from view_sarl_contribution_sheet where VRDATE = '"+date+"' AND "+z+" ("+test6+" ITEM_NAME = 'madhav') AND ITEM_NATURE ='PG' AND DIV_CODE LIKE 'O%'",data.getXValue());
                    
                });
            }
        }
            for(XYChart.Data<String,Double> data : s7.getData()){
                if(x == " VRDATE "){
                Node n1 = data.getNode();
                n1.setOnMouseClicked(c->{
                    
                        date = data.getXValue();
                   exportTable("select "+table+" from view_sarl_contribution_sheet where VRDATE = '"+date+"' AND "+z+" ("+test7+" ITEM_NAME = 'madhav') AND ITEM_NATURE ='PG' AND DIV_CODE LIKE 'O%'",data.getXValue());
                    
                });
            }
        }
            for(XYChart.Data<String,Double> data : s1.getData()){
                if(option1 == "Item Name"){
                Node n1 = data.getNode();
                n1.setOnMouseClicked(c->{
                    
                        date = data.getXValue();
                        System.out.print(date);
                   exportTable("select "+table+" from view_sarl_contribution_sheet where ITEM_NAME like '%"+date+"%' AND "+z+" ITEM_NATURE ='PG' AND DIV_CODE LIKE 'O%' AND VRDATE <= '"+date2+"' AND VRDATE >= '"+date1+"'","new1");
                    
                });
            }
        }
            for(XYChart.Data<String,Double> data : s2.getData()){
                if(option1 == "Item Name"){
                Node n1 = data.getNode();
                n1.setOnMouseClicked(c->{
                    
                        date = data.getXValue();
                        System.out.print(date);
                   exportTable("select "+table+" from view_sarl_contribution_sheet where ITEM_NAME like '%"+date+"%' AND "+z+" ITEM_NATURE ='PG' AND DIV_CODE LIKE 'O%' AND VRDATE <= '"+date2+"' AND VRDATE >= '"+date1+"'","new2");
                    
                });
            }
        }
            for(XYChart.Data<String,Double> data : s3.getData()){
                if(option1 == "Item Name"){
                Node n1 = data.getNode();
                n1.setOnMouseClicked(c->{
                    
                        date = data.getXValue();
                        System.out.print(date);
                   exportTable("select "+table+" from view_sarl_contribution_sheet where ITEM_NAME like '%"+date+"%' AND "+z+" ITEM_NATURE ='PG' AND DIV_CODE LIKE 'O%' AND VRDATE <= '"+date2+"' AND VRDATE >= '"+date1+"'","new3");
                    
                });
            }
        }
            for(XYChart.Data<String,Double> data : s4.getData()){
                if(option1 == "Item Name"){
                Node n1 = data.getNode();
                n1.setOnMouseClicked(c->{
                    
                        date = data.getXValue();
                        System.out.print(date);
                   exportTable("select "+table+" from view_sarl_contribution_sheet where ITEM_NAME like '%"+date+"%' AND "+z+" ITEM_NATURE ='PG' AND DIV_CODE LIKE 'O%' AND VRDATE <= '"+date2+"' AND VRDATE >= '"+date1+"'","new4");
                    
                });
            }
        }
            for(XYChart.Data<String,Double> data : s5.getData()){
                if(option1 == "Item Name"){
                Node n1 = data.getNode();
                n1.setOnMouseClicked(c->{
                    
                        date = data.getXValue();
                        System.out.print(date);
                   exportTable("select "+table+" from view_sarl_contribution_sheet where ITEM_NAME like '%"+date+"%' AND "+z+" ITEM_NATURE ='PG' AND DIV_CODE LIKE 'O%' AND VRDATE <= '"+date2+"' AND VRDATE >= '"+date1+"'","new5");
                    
                });
            }
        }
            for(XYChart.Data<String,Double> data : s6.getData()){
                if(option1 == "Item Name"){
                Node n1 = data.getNode();
                n1.setOnMouseClicked(c->{
                    
                        date = data.getXValue();
                        System.out.print(date);
                   exportTable("select "+table+" from view_sarl_contribution_sheet where ITEM_NAME like '%"+date+"%' AND "+z+" ITEM_NATURE ='PG' AND DIV_CODE LIKE 'O%' AND VRDATE <= '"+date2+"' AND VRDATE >= '"+date1+"'","new6");
                    
                });
            }
        }
            for(XYChart.Data<String,Double> data : s7.getData()){
                if(option1 == "Item Name"){
                Node n1 = data.getNode();
                n1.setOnMouseClicked(c->{
                    
                        date = data.getXValue();
                        System.out.print(date);
                   exportTable("select "+table+" from view_sarl_contribution_sheet where ITEM_NAME like '%"+date+"%' AND "+z+" ITEM_NATURE ='PG' AND DIV_CODE LIKE 'O%' AND VRDATE <= '"+date2+"' AND VRDATE >= '"+date1+"'","new7");
                    
                });
            }
        }
            for(XYChart.Data<String,Double> data : s1.getData()){
                if(x == " YEAR(VRDATE) "||x == " MONTH(VRDATE) "|| x == " WEEK(VRDATE) "){
                Node n1 = data.getNode();
                n1.setOnMouseClicked(c->{
                    
                        date = data.getXValue();
                   exportTable("select "+table+" from view_sarl_contribution_sheet where "+x+" = "+date+" AND "+z+" ("+test1+" ITEM_NAME = 'madhav') AND ITEM_NATURE ='PG' AND DIV_CODE LIKE 'O%' AND VRDATE <= '"+date2+"' AND VRDATE >= '"+date1+"'",data.getXValue());
                    
                });
            }
        }
            for(XYChart.Data<String,Double> data : s2.getData()){
                if(x == " YEAR(VRDATE) "||x == " MONTH(VRDATE) "|| x == " WEEK(VRDATE) "){
                Node n1 = data.getNode();
                n1.setOnMouseClicked(c->{
                    
                        date = data.getXValue();
                   exportTable("select "+table+" from view_sarl_contribution_sheet where "+x+" = "+date+" AND "+z+" ("+test2+" ITEM_NAME = 'madhav') AND ITEM_NATURE ='PG' AND DIV_CODE LIKE 'O%' AND VRDATE <= '"+date2+"' AND VRDATE >= '"+date1+"'",data.getXValue());
                    
                });
            }
        }
            for(XYChart.Data<String,Double> data : s3.getData()){
                if(x == " YEAR(VRDATE) "||x == " MONTH(VRDATE) "|| x == " WEEK(VRDATE) "){
                Node n1 = data.getNode();
                n1.setOnMouseClicked(c->{
                    
                        date = data.getXValue();
                   exportTable("select "+table+" from view_sarl_contribution_sheet where "+x+" = "+date+" AND "+z+" ("+test3+" ITEM_NAME = 'madhav') AND ITEM_NATURE ='PG' AND DIV_CODE LIKE 'O%' AND VRDATE <= '"+date2+"' AND VRDATE >= '"+date1+"'",data.getXValue());
                    
                });
            }
        }
            for(XYChart.Data<String,Double> data : s4.getData()){
                if(x == " YEAR(VRDATE) "||x == " MONTH(VRDATE) "|| x == " WEEK(VRDATE) "){
                Node n1 = data.getNode();
                n1.setOnMouseClicked(c->{
                    
                        date = data.getXValue();
                   exportTable("select "+table+" from view_sarl_contribution_sheet where "+x+" = "+date+" AND "+z+" ("+test4+" ITEM_NAME = 'madhav') AND ITEM_NATURE ='PG' AND DIV_CODE LIKE 'O%' AND VRDATE <= '"+date2+"' AND VRDATE >= '"+date1+"'",data.getXValue());
                    
                });
            }
        }
            for(XYChart.Data<String,Double> data : s5.getData()){
                if(x == " YEAR(VRDATE) "||x == " MONTH(VRDATE) "|| x == " WEEK(VRDATE) "){
                Node n1 = data.getNode();
                n1.setOnMouseClicked(c->{
                    
                        date = data.getXValue();
                   exportTable("select "+table+" from view_sarl_contribution_sheet where "+x+" = "+date+" AND "+z+" ("+test5+" ITEM_NAME = 'madhav') AND ITEM_NATURE ='PG' AND DIV_CODE LIKE 'O%' AND VRDATE <= '"+date2+"' AND VRDATE >= '"+date1+"'",data.getXValue());
                    
                });
            }
        }
            for(XYChart.Data<String,Double> data : s6.getData()){
                if(x == " YEAR(VRDATE) "||x == " MONTH(VRDATE) "|| x == " WEEK(VRDATE) "){
                Node n1 = data.getNode();
                n1.setOnMouseClicked(c->{
                    
                        date = data.getXValue();
                   exportTable("select "+table+" from view_sarl_contribution_sheet where "+x+" = "+date+" AND "+z+" ("+test6+" ITEM_NAME = 'madhav') AND ITEM_NATURE ='PG' AND DIV_CODE LIKE 'O%' AND VRDATE <= '"+date2+"' AND VRDATE >= '"+date1+"'",data.getXValue());
                    
                });
            }
            }
            for(XYChart.Data<String,Double> data : s7.getData()){
                if(x == " YEAR(VRDATE) "||x == " MONTH(VRDATE) "|| x == " WEEK(VRDATE) "){
                Node n1 = data.getNode();
                n1.setOnMouseClicked(c->{
                    
                        date = data.getXValue();
                   exportTable("select "+table+" from view_sarl_contribution_sheet where "+x+" = "+date+" AND "+z+" ("+test7+" ITEM_NAME = 'madhav') AND ITEM_NATURE ='PG' AND DIV_CODE LIKE 'O%' AND VRDATE <= '"+date2+"' AND VRDATE >= '"+date1+"'",data.getXValue());
                    
                });
            }
        }
        btn.setOnAction(i->{
            data1.clear(); datad1.clear();
            s1.getData().clear(); sd1.getData().clear();
            data.clear();
            s1.getData().clear(); s2.getData().clear(); s3.getData().clear(); s4.getData().clear(); s5.getData().clear(); s6.getData().clear(); s7.getData().clear(); s8.getData().clear();
            test1 = ""; test2 = ""; test3 = ""; test4 = ""; test5 = ""; test6 = ""; test7 = "";
            primaryStage.setScene(scene);
            primaryStage.show();
        });
        
        root1.setBottom(btn);
        primaryStage.setScene(scene1);
        primaryStage.show();
        });
        
        btn2.setOnAction(e->{
            
        try{
                conn = CONNECT.ConnecterDb();
                ResultSet rs = conn.createStatement().executeQuery("select distinct ITEM_CODE from view_sarl_contribution_sheet where ITEM_NAME like '%NATUR%' AND VRDATE <= '"+date2+"' AND VRDATE >= '"+date1+"'");
                for(int k = 0;rs.next();k++){
                if(checkboxes1.get(k).isSelected()){
                test1 = test1+"ITEM_CODE = '"+rs.getString(1)+"' OR ";
                    }
                }
            }
             catch(Exception i){
                 JOptionPane.showMessageDialog(null, i);
             }
            
            try{
                conn = CONNECT.ConnecterDb();
                ResultSet rs = conn.createStatement().executeQuery("select distinct ITEM_CODE from view_sarl_contribution_sheet where ITEM_NAME like '%SUNSU%' AND VRDATE <= '"+date2+"' AND VRDATE >= '"+date1+"'");
                for(int k = 0;rs.next();k++){
                if(checkboxes2.get(k).isSelected()){
                test2 = test2+"ITEM_CODE = '"+rs.getString(1)+"' OR ";
                    }
                }
            }
             catch(Exception i){
                 JOptionPane.showMessageDialog(null, i);
             }
            
            try{
                conn = CONNECT.ConnecterDb();
                ResultSet rs = conn.createStatement().executeQuery("select distinct ITEM_CODE from view_sarl_contribution_sheet where ITEM_NAME like '%KRISHNA B%' AND VRDATE <= '"+date2+"' AND VRDATE >= '"+date1+"'");
                for(int k = 0;rs.next();k++){
                if(checkboxes3.get(k).isSelected()){
                test3 = test3+"ITEM_CODE = '"+rs.getString(1)+"' OR ";
                    }
                }
            }
             catch(Exception i){
                 JOptionPane.showMessageDialog(null, i);
             }
            
            try{
                conn = CONNECT.ConnecterDb();
                ResultSet rs = conn.createStatement().executeQuery("select distinct ITEM_CODE from view_sarl_contribution_sheet where (ITEM_NAME like '%SRE K%' OR ITEM_NAME like '%SRI K%') AND VRDATE <= '"+date2+"' AND VRDATE >= '"+date1+"'");
                for(int k = 0;rs.next();k++){
                if(checkboxes4.get(k).isSelected()){
                test4 = test4+"ITEM_CODE = '"+rs.getString(1)+"' OR ";
                    }
                }
            }
             catch(Exception i){
                 JOptionPane.showMessageDialog(null, i);
             }
            
            try{
                conn = CONNECT.ConnecterDb();
                ResultSet rs = conn.createStatement().executeQuery("select distinct ITEM_CODE from view_sarl_contribution_sheet where ITEM_NAME like '%MOTHE%' AND VRDATE <= '"+date2+"' AND VRDATE >= '"+date1+"'");
                for(int k = 0;rs.next();k++){
                if(checkboxes5.get(k).isSelected()){
                test5 = test5+"ITEM_CODE = '"+rs.getString(1)+"' OR ";
                    }
                }
            }
             catch(Exception i){
                 JOptionPane.showMessageDialog(null, i);
             }
            
            try{
                conn = CONNECT.ConnecterDb();
                ResultSet rs = conn.createStatement().executeQuery("select distinct ITEM_CODE from view_sarl_contribution_sheet where ITEM_NAME like '%RUCHI%' AND VRDATE <= '"+date2+"' AND VRDATE >= '"+date1+"'");
                for(int k = 0;rs.next();k++){
                if(checkboxes6.get(k).isSelected()){
                test6 = test6+"ITEM_CODE = '"+rs.getString(1)+"' OR ";
                    }
                }
            }
             catch(Exception i){
                 JOptionPane.showMessageDialog(null, i);
             }
            
            try{
                conn = CONNECT.ConnecterDb();
                ResultSet rs = conn.createStatement().executeQuery("select distinct ITEM_CODE from view_sarl_contribution_sheet where ITEM_NAME not like '%NATUR%' AND ITEM_NAME not like '%SUNSU%' AND ITEM_NAME not like '%KRISH%' AND ITEM_NAME not like '%SRE K%' AND ITEM_NAME not like '%SRI K%' AND ITEM_NAME not like '%MOTHE%' AND ITEM_NAME not like '%RUCHI%' AND VRDATE <= '"+date2+"' AND VRDATE >= '"+date1+"'");
                for(int k = 0;rs.next();k++){
                if(checkboxes7.get(k).isSelected()){
                test7 = test7+"ITEM_CODE = '"+rs.getString(1)+"' OR ";  
                    }
                }
            }
             catch(Exception i){
                 JOptionPane.showMessageDialog(null, i);
             }
        
        option3 = cb3.getValue().toString();
        if(option3 == "Telangana"){
            z = "STATE_CODE = 'TS' AND ";
        }
        if(option3 == "Andhra Pradesh"){
            z = "STATE_CODE = 'AP' AND ";
        }
        if(option3 == "Maharashtra"){
            z = "STATE_CODE = 'MH' AND ";
        }
        if(option3 == "Karnataka"){
            z = "STATE_CODE = 'KA' AND ";
        }
        if(option3 == "Tamil Nadu"){
            z = "STATE_CODE = 'TN' AND ";
        }
        if(option3 == "Gujarat"){
            z = "STATE_CODE = 'GJ' AND ";
        }
        if(option3 == "Chattisgarh"){
            z = "STATE_CODE = 'CG' AND ";
        }
        if(option3 == "Madhya Pradesh"){
            z = "STATE_CODE = 'MP' AND ";
        }
        option1 = cb1.getValue().toString();
        if(option1 == "Date"){
            x = " VRDATE ";
        }
        if(option1 == "Item Name"){
            x = " ITEM_NAME ";
        }
        if(option1 == "District"){
            x = " DISTRICT ";
        }
        if(option1 == "Year"){
            x = " to_char(VRDATE , 'yyyy') ";
        }
        if(option1 == "Month"){
            x = " to_char(VRDATE , 'mm') ";
        }
        if(option1 == "Week"){
            x = " to_char(VRDATE , 'ww') ";
        }
        option2 = cb2.getValue().toString();
        if(option2 == "Quantity in Tonne"){
            y = "SUM(QTYORDER*PROD_SIZE/1000)-NVL(SUM(QTYCANCELLED*PROD_SIZE/1000),0)";
        }
        if(option2 == "Rate per Tonne"){
            y = "(SUM(AFIELD1)/SUM(QTYORDER))/(SUM(QTYORDER*PROD_SIZE/1000)-NVL(SUM(QTYCANCELLED*PROD_SIZE/1000),0)) ";
        }
        if(option2 == "Cost Value"){
            y = "(SUM(GET_CRUDE_RATE(DIV_CODE,ITEM_CODE,VRDATE,ITEM_NATURE,'NETRATE',VRNO)*GET_PG_PACK_SIZE(DIV_CODE,ITEM_CODE,'SIZE',VRDATE)*QTYORDER)/SUM(QTYORDER))*SUM(QTYORDER)";
        }
        if(option2 == "Contribution"){
            y = "((SUM(AFIELD1)-NVL(SUM(QTY*GET_PG_PACK_SIZE(DC,IC,'EXP',VRDATE)),0)-NVL((SUM(GET_FRT_RATE(DC,IC,AREA_CODE,'P',vrdate,FB)*QTY)),0)-NVL(SUM(GET_SARL_SCHEME_RATE(ACC_CODE,IC,VRDATE)*QTY),0)-\n" +
                "SUM(NVL(FNC_SWG_SCHEME(EC,DC,ACC_CODE,VRDATE,VRNO,IC,QTY,'AMT',AREA_CODE,FREIGHT_BASIS),0))-\n" +
                "NVL(SUM(GET_FRT_RATE(DC,IC,AREA_CODE,'S',vrdate,FREIGHT_BASIS)*QTY),0)))-((SUM(NVL(GET_CRUDE_RATE(DC,IC,VRDATE,ITN,'NETRATE',VRNO),0)*GET_PG_PACK_SIZE(DC,IC,'SIZE',VRDATE)*QTY)/SUM(QTY))*SUM(QTY)) ";
        }
        if(option2 == "Contribution Per Tonne"){
            y = "(((SUM(AFIELD1)-NVL(SUM(QTY*GET_PG_PACK_SIZE(DC,IC,'EXP',VRDATE)),0)-NVL((SUM(GET_FRT_RATE(DC,IC,AREA_CODE,'P',vrdate,FB)*QTY)),0)-NVL(SUM(GET_SARL_SCHEME_RATE(ACC_CODE,IC,VRDATE)*QTY),0)-\n" +
                "SUM(NVL(FNC_SWG_SCHEME(EC,DC,ACC_CODE,VRDATE,VRNO,IC,QTY,'AMT',AC,FB),0))-\n" +
                "NVL(SUM(GET_FRT_RATE(DC,IC,AC,'S',vrdate,FB)*QTY),0)))-((SUM(GET_CRUDE_RATE(DC,IC,VRDATE,ITN,'NETRATE',VRNO)*GET_PG_PACK_SIZE(DC,IC,'SIZE',VRDATE)*QTY)/SUM(QTY))*SUM(QTY)))/(SUM(QTY*GET_PG_PACK_SIZE(DC,IC,'SIZE',VRDATE))/1000) ";
        }
        
        if(option1 == "State"){
            z = "";
            x = "STATE_CODE";
        }
        
        group = " Group By "+x+"";
        
        date1 = fr.format(Date.valueOf(d1.getValue())).toString();
        date2 = fr.format(Date.valueOf(d2.getValue())).toString();
        
        if(option2 != "Rate per Tonne" && option2 != "Contribution Per Tonne" && option1 != "Brand"){
        LineChart lc1 = new LineChart(xAxis2,yAxis2,lineData());
        xAxis2.setLabel(option1);
        yAxis2.setLabel(option2);
        root1.setCenter(lc1);
        }
        
        if((option2 == "Rate per Tonne" || option2 == "Contribution Per Tonne") && option1 != "Brand"){
        LineChart lc2 = new LineChart(xAxis5,yAxis5,barData());
        xAxis4.setLabel(option1);
        yAxis4.setLabel(option2);
        root1.setCenter(lc2);
        }
        
        if(option1 == "Brand"){
            LineChart lc3 = new LineChart(xAxis7,yAxis7,lineData_default());
            xAxis7.setLabel(option1);
            yAxis7.setLabel(option2);
            root1.setCenter(lc3);
        }
        
        btn.setOnAction(i->{
            data1.clear(); datad2.clear();
            s1.getData().clear(); sd2.getData().clear();
            data.clear();
            s1.getData().clear(); s2.getData().clear(); s3.getData().clear(); s4.getData().clear(); s5.getData().clear(); s6.getData().clear(); s7.getData().clear(); s8.getData().clear(); 
            test1 = ""; test2 = ""; test3 = ""; test4 = ""; test5 = ""; test6 = ""; test7 = "";
            
            primaryStage.setScene(scene);
            primaryStage.show();
        });
        
        root1.setBottom(btn);
        primaryStage.setScene(scene1);
        primaryStage.show();
        });
        
        btn3.setOnAction(e->{
            
        try{
                conn = CONNECT.ConnecterDb();
                ResultSet rs = conn.createStatement().executeQuery("select distinct ITEM_CODE from view_sarl_contribution_sheet where ITEM_NAME like '%NATUR%' AND VRDATE <= '"+date2+"' AND VRDATE >= '"+date1+"'");
                for(int k = 0;rs.next();k++){
                if(checkboxes1.get(k).isSelected()){
                test1 = test1+"ITEM_CODE = '"+rs.getString(1)+"' OR ";
                    }
                }
            }
             catch(Exception i){
                 JOptionPane.showMessageDialog(null, i);
             }
            
            try{
                conn = CONNECT.ConnecterDb();
                ResultSet rs = conn.createStatement().executeQuery("select distinct ITEM_CODE from view_sarl_contribution_sheet where ITEM_NAME like '%SUNSU%' AND VRDATE <= '"+date2+"' AND VRDATE >= '"+date1+"'");
                for(int k = 0;rs.next();k++){
                if(checkboxes2.get(k).isSelected()){
                test2 = test2+"ITEM_CODE = '"+rs.getString(1)+"' OR ";
                    }
                }
            }
             catch(Exception i){
                 JOptionPane.showMessageDialog(null, i);
             }
            
            try{
                conn = CONNECT.ConnecterDb();
                ResultSet rs = conn.createStatement().executeQuery("select distinct ITEM_CODE from view_sarl_contribution_sheet where ITEM_NAME like '%KRISHNA B%' AND VRDATE <= '"+date2+"' AND VRDATE >= '"+date1+"'");
                for(int k = 0;rs.next();k++){
                if(checkboxes3.get(k).isSelected()){
                test3 = test3+"ITEM_CODE = '"+rs.getString(1)+"' OR ";
                    }
                }
            }
             catch(Exception i){
                 JOptionPane.showMessageDialog(null, i);
             }
            
            try{
                conn = CONNECT.ConnecterDb();
                ResultSet rs = conn.createStatement().executeQuery("select distinct ITEM_CODE from view_sarl_contribution_sheet where (ITEM_NAME like '%SRE K%' OR ITEM_NAME like '%SRI K%') AND VRDATE <= '"+date2+"' AND VRDATE >= '"+date1+"'");
                for(int k = 0;rs.next();k++){
                if(checkboxes4.get(k).isSelected()){
                test4 = test4+"ITEM_CODE = '"+rs.getString(1)+"' OR ";
                    }
                }
            }
             catch(Exception i){
                 JOptionPane.showMessageDialog(null, i);
             }
            
            try{
                conn = CONNECT.ConnecterDb();
                ResultSet rs = conn.createStatement().executeQuery("select distinct ITEM_CODE from view_sarl_contribution_sheet where ITEM_NAME like '%MOTHE%' AND VRDATE <= '"+date2+"' AND VRDATE >= '"+date1+"'");
                for(int k = 0;rs.next();k++){
                if(checkboxes5.get(k).isSelected()){
                test5 = test5+"ITEM_CODE = '"+rs.getString(1)+"' OR ";
                    }
                }
            }
             catch(Exception i){
                 JOptionPane.showMessageDialog(null, i);
             }
            
            try{
                conn = CONNECT.ConnecterDb();
                ResultSet rs = conn.createStatement().executeQuery("select distinct ITEM_CODE from view_sarl_contribution_sheet where ITEM_NAME like '%RUCHI%' AND VRDATE <= '"+date2+"' AND VRDATE >= '"+date1+"'");
                for(int k = 0;rs.next();k++){
                if(checkboxes6.get(k).isSelected()){
                test6 = test6+"ITEM_CODE = '"+rs.getString(1)+"' OR ";
                    }
                }
            }
             catch(Exception i){
                 JOptionPane.showMessageDialog(null, i);
             }
            
            try{
                conn = CONNECT.ConnecterDb();
                ResultSet rs = conn.createStatement().executeQuery("select distinct ITEM_CODE from view_sarl_contribution_sheet where ITEM_NAME not like '%NATUR%' AND ITEM_NAME not like '%SUNSU%' AND ITEM_NAME not like '%KRISH%' AND ITEM_NAME not like '%SRE K%' AND ITEM_NAME not like '%SRI K%' AND ITEM_NAME not like '%MOTHE%' AND ITEM_NAME not like '%RUCHI%' AND VRDATE <= '"+date2+"' AND VRDATE >= '"+date1+"'");
                for(int k = 0;rs.next();k++){
                if(checkboxes7.get(k).isSelected()){
                test7 = test7+"ITEM_CODE = '"+rs.getString(1)+"' OR ";  
                    }
                }
            }
             catch(Exception i){
                 JOptionPane.showMessageDialog(null, i);
             }
        
        option3 = cb3.getValue().toString();
        if(option3 == "Telangana"){
            z = "STATE_CODE = 'TS' AND ";
        }
        if(option3 == "Andhra Pradesh"){
            z = "STATE_CODE = 'AP' AND ";
        }
        if(option3 == "Maharashtra"){
            z = "STATE_CODE = 'MH' AND ";
        }
        if(option3 == "Karnataka"){
            z = "STATE_CODE = 'KA' AND ";
        }
        if(option3 == "Tamil Nadu"){
            z = "STATE_CODE = 'TN' AND ";
        }
        if(option3 == "Gujarat"){
            z = "STATE_CODE = 'GJ' AND ";
        }
        if(option3 == "Chattisgarh"){
            z = "STATE_CODE = 'CG' AND ";
        }
        if(option3 == "Madhya Pradesh"){
            z = "STATE_CODE = 'MP' AND ";
        }
        option1 = cb1.getValue().toString();
        if(option1 == "Date"){
            x = " VRDATE ";
        }
        if(option1 == "Item Name"){
            x = " ITEM_NAME ";
        }
        if(option1 == "District"){
            x = " DISTRICT ";
        }
        if(option1 == "Year"){
            x = " to_char(VRDATE , 'yyyy') ";
        }
        if(option1 == "Month"){
            x = " to_char(VRDATE , 'mm') ";
        }
        if(option1 == "Week"){
            x = " to_char(VRDATE , 'ww') ";
        }
        option2 = cb2.getValue().toString();
        if(option2 == "Quantity in Tonne"){
            y = "SUM(QTYORDER*PROD_SIZE/1000)-NVL(SUM(QTYCANCELLED*PROD_SIZE/1000),0)";
        }
        if(option2 == "Rate per Tonne"){
            y = "(SUM(AFIELD1)/SUM(QTYORDER))/(SUM(QTYORDER*PROD_SIZE/1000)-NVL(SUM(QTYCANCELLED*PROD_SIZE/1000),0)) ";
        }
        if(option2 == "Cost Value"){
            y = "(SUM(GET_CRUDE_RATE(DIV_CODE,ITEM_CODE,VRDATE,ITEM_NATURE,'NETRATE',VRNO)*GET_PG_PACK_SIZE(DIV_CODE,ITEM_CODE,'SIZE',VRDATE)*QTYORDER)/SUM(QTYORDER))*SUM(QTYORDER)";
        }
        if(option2 == "Contribution"){
            y = "((SUM(AFIELD1)-NVL(SUM(QTY*GET_PG_PACK_SIZE(DC,IC,'EXP',VRDATE)),0)-NVL((SUM(GET_FRT_RATE(DC,IC,AREA_CODE,'P',vrdate,FB)*QTY)),0)-NVL(SUM(GET_SARL_SCHEME_RATE(ACC_CODE,IC,VRDATE)*QTY),0)-\n" +
                "SUM(NVL(FNC_SWG_SCHEME(EC,DC,ACC_CODE,VRDATE,VRNO,IC,QTY,'AMT',AREA_CODE,FREIGHT_BASIS),0))-\n" +
                "NVL(SUM(GET_FRT_RATE(DC,IC,AREA_CODE,'S',vrdate,FREIGHT_BASIS)*QTY),0)))-((SUM(NVL(GET_CRUDE_RATE(DC,IC,VRDATE,ITN,'NETRATE',VRNO),0)*GET_PG_PACK_SIZE(DC,IC,'SIZE',VRDATE)*QTY)/SUM(QTY))*SUM(QTY)) ";
        }
        if(option2 == "Contribution Per Tonne"){
            y = "(((SUM(AFIELD1)-NVL(SUM(QTY*GET_PG_PACK_SIZE(DC,IC,'EXP',VRDATE)),0)-NVL((SUM(GET_FRT_RATE(DC,IC,AREA_CODE,'P',vrdate,FB)*QTY)),0)-NVL(SUM(GET_SARL_SCHEME_RATE(ACC_CODE,IC,VRDATE)*QTY),0)-\n" +
                "SUM(NVL(FNC_SWG_SCHEME(EC,DC,ACC_CODE,VRDATE,VRNO,IC,QTY,'AMT',AC,FB),0))-\n" +
                "NVL(SUM(GET_FRT_RATE(DC,IC,AC,'S',vrdate,FB)*QTY),0)))-((SUM(GET_CRUDE_RATE(DC,IC,VRDATE,ITN,'NETRATE',VRNO)*GET_PG_PACK_SIZE(DC,IC,'SIZE',VRDATE)*QTY)/SUM(QTY))*SUM(QTY)))/(SUM(QTY*GET_PG_PACK_SIZE(DC,IC,'SIZE',VRDATE))/1000) ";
        }
        
        if(option1 == "State"){
            z = "";
            x = "STATE_CODE";
        }
        
        group = " Group By "+x+"";
        
        date1 = fr.format(Date.valueOf(d1.getValue())).toString();
        date2 = fr.format(Date.valueOf(d2.getValue())).toString();
        
        if(option2 != "Rate per Tonne" && option2 != "Contribution Per Tonne"){
        PieChart pc1 = new PieChart();
        pieData();
        pc1.setData(datapie);
        root1.setCenter(pc1);
        }
        
        if(option2 == "Rate per Tonne" || option2 == "Contribution Per Tonne"){
            JFrame frame = new JFrame();
            frame.setVisible(true);
            JOptionPane.showMessageDialog(null,"Cannot create pie Chart for the given selections.");
        }
        if(option1 == "Brand" && option2 != "Rate per Tonne" && option2 != "Contribution Per Tonne"){
            PieChart pc2 = new PieChart();
            pieData1();
            pc2.setData(datapie1);
            root1.setCenter(pc2);
        }
        
        btn.setOnAction(i->{
            datapie.clear(); datapie1.clear();
            test1 = ""; test2 = ""; test3 = ""; test4 = ""; test5 = ""; test6 = ""; test7 = "";
            primaryStage.setScene(scene);
            primaryStage.show();
        });
        
        root1.setBottom(btn);
        primaryStage.setScene(scene1);
        primaryStage.show();
        });
        
        CheckTreeView tv = new CheckTreeView(ch);
        ch.setExpanded(true);
        ch.getChildren().addAll(p1,p2,p3,p4,p5,p6,p7);
        
        root.setTop(t1);
        root.setCenter(bc);
        root.setRight(tv);
        root.setBottom(t2);
        
        btnbk.setOnAction(e->{
             try{
           Class.forName("sarl_graph_viewer.SARL_Graph_Viewer");
           primaryStage.close();
           new sarl_graph_viewer.SARL_Graph_Viewer().start(stage1);
           }
           catch(Exception i){
               JOptionPane.showMessageDialog(null, i);
           }
         });
        
        primaryStage.setTitle("SARL Graph Viewer");
        primaryStage.setScene(scene);
        primaryStage.getIcons().add(new Image("file:logo3.png"));
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
