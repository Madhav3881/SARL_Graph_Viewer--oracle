/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sarl_graph_viewer.District_Analysis;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ToolBar;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import sarl_graph_viewer.CONNECT;
import sarl_graph_viewer.Charts.piechart;

/**
 *
 * @author madhav
 */
public class DistrictMain extends Application {
    
    Connection conn;
    
    String a;
    String x;
    String y;
    String z;
    Stage stage1 = new Stage();
    
    Date d;
    
    ObservableList<XYChart.Series<String , Double>> data = FXCollections.observableArrayList();
    ObservableList<XYChart.Series<String , Double>> data1 = FXCollections.observableArrayList();
    ObservableList<XYChart.Series<String , Double>> data2 = FXCollections.observableArrayList();
    ObservableList<XYChart.Series<String , Double>> data3 = FXCollections.observableArrayList();
    
    XYChart.Series<String, Double> s = new XYChart.Series<>();
    XYChart.Series<String, Double> s1 = new XYChart.Series<>();
    XYChart.Series<String, Double> s2 = new XYChart.Series<>();
    XYChart.Series<String, Double> s3 = new XYChart.Series<>();
    
    SimpleDateFormat fr = new SimpleDateFormat("dd-MMM-yyyy");
    
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
    
     public ObservableList<XYChart.Series<String, Double>> barData(){
        
        try{
            conn = CONNECT.ConnecterDb();
            ResultSet rs = conn.createStatement().executeQuery("select DISTRICT, SUM(QTYORDER*PROD_SIZE/1000)-NVL(SUM(QTYCANCELLED*PROD_SIZE/1000),0) from view_sarl_contribution_sheet where STATE_CODE = 'TS' AND ITEM_NATURE ='PG' AND DIV_CODE LIKE 'O%' AND VRDATE <= '"+x+"' AND VRDATE >= '"+y+"' AND DISTRICT IS NOT NULL group by DISTRICT order by SUM(QTYORDER*PROD_SIZE/1000)-NVL(SUM(QTYCANCELLED*PROD_SIZE/1000),0) desc");
            while(rs.next()){
                s.getData().add(new XYChart.Data(rs.getString(1), rs.getDouble(2)));
            }
            data.addAll(s);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        return data;
    }
    
    public ObservableList<XYChart.Series<String, Double>> barData1(){
        
        try{
            conn = CONNECT.ConnecterDb();
            ResultSet rs = conn.createStatement().executeQuery("select DISTRICT, SUM(QTYORDER*PROD_SIZE/1000)-NVL(SUM(QTYCANCELLED*PROD_SIZE/1000),0) from view_sarl_contribution_sheet where STATE_CODE = 'TS' AND ITEM_NATURE ='PG' AND DIV_CODE LIKE 'O%' AND VRDATE <= '"+x+"' AND VRDATE >= '"+y+"' AND DISTRICT IS NOT NULL group by DISTRICT order by SUM(QTYORDER*PROD_SIZE/1000)-NVL(SUM(QTYCANCELLED*PROD_SIZE/1000),0) desc");
            while(rs.next()){
                s1.getData().add(new XYChart.Data(rs.getString(1), rs.getDouble(2)));
            }
            data1.addAll(s1);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        return data1;
    }
    
    public ObservableList<XYChart.Series<String, Double>> barData2(){
        
        try{
            conn = CONNECT.ConnecterDb();
            ResultSet rs = conn.createStatement().executeQuery("select DISTRICT, SUM(QTYORDER*PROD_SIZE/1000)-NVL(SUM(QTYCANCELLED*PROD_SIZE/1000),0) from view_sarl_contribution_sheet where STATE_CODE = 'AP' AND ITEM_NATURE ='PG' AND DIV_CODE LIKE 'O%' AND VRDATE <= '"+x+"' AND VRDATE >= '"+y+"' AND DISTRICT IS NOT NULL group by DISTRICT order by SUM(QTYORDER*PROD_SIZE/1000)-NVL(SUM(QTYCANCELLED*PROD_SIZE/1000),0) desc");
            while(rs.next()){
                s1.getData().add(new XYChart.Data(rs.getString(1), rs.getDouble(2)));
            }
            data1.addAll(s1);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        return data1;
    }
      public ObservableList<XYChart.Series<String, Double>> barData3(){
        
        try{
            conn = CONNECT.ConnecterDb();
            ResultSet rs = conn.createStatement().executeQuery("select DISTRICT, SUM(QTYORDER*PROD_SIZE/1000)-NVL(SUM(QTYCANCELLED*PROD_SIZE/1000),0) from view_sarl_contribution_sheet where STATE_CODE = 'MH' AND ITEM_NATURE ='PG' AND DIV_CODE LIKE 'O%' AND VRDATE <= '"+x+"' AND VRDATE >= '"+y+"' AND DISTRICT IS NOT NULL group by DISTRICT order by SUM(QTYORDER*PROD_SIZE/1000)-NVL(SUM(QTYCANCELLED*PROD_SIZE/1000),0) desc");
            while(rs.next()){
                s1.getData().add(new XYChart.Data(rs.getString(1), rs.getDouble(2)));
            }
            data1.addAll(s1);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        return data1;
    }
       public ObservableList<XYChart.Series<String, Double>> barData4(){
        
        try{
            conn = CONNECT.ConnecterDb();
            ResultSet rs = conn.createStatement().executeQuery("select DISTRICT, SUM(QTYORDER*PROD_SIZE/1000)-NVL(SUM(QTYCANCELLED*PROD_SIZE/1000),0) from view_sarl_contribution_sheet where STATE_CODE = 'KA' AND ITEM_NATURE ='PG' AND DIV_CODE LIKE 'O%' AND VRDATE <= '"+x+"' AND VRDATE >= '"+y+"' AND DISTRICT IS NOT NULL group by DISTRICT order by SUM(QTYORDER*PROD_SIZE/1000)-NVL(SUM(QTYCANCELLED*PROD_SIZE/1000),0) desc");
            while(rs.next()){
                s1.getData().add(new XYChart.Data(rs.getString(1), rs.getDouble(2)));
            }
            data1.addAll(s1);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        return data1;
    }
        public ObservableList<XYChart.Series<String, Double>> barData5(){
        
        try{
            conn = CONNECT.ConnecterDb();
            ResultSet rs = conn.createStatement().executeQuery("select DISTRICT, SUM(QTYORDER*PROD_SIZE/1000)-NVL(SUM(QTYCANCELLED*PROD_SIZE/1000),0) from view_sarl_contribution_sheet where STATE_CODE = 'TN' AND ITEM_NATURE ='PG' AND DIV_CODE LIKE 'O%' AND VRDATE <= '"+x+"' AND VRDATE >= '"+y+"' AND DISTRICT IS NOT NULL group by DISTRICT order by SUM(QTYORDER*PROD_SIZE/1000)-NVL(SUM(QTYCANCELLED*PROD_SIZE/1000),0) desc");
            while(rs.next()){
                s1.getData().add(new XYChart.Data(rs.getString(1), rs.getDouble(2)));
            }
            data1.addAll(s1);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        return data1;
    }
         public ObservableList<XYChart.Series<String, Double>> barData6(){
        
        try{
            conn = CONNECT.ConnecterDb();
            ResultSet rs = conn.createStatement().executeQuery("select DISTRICT, SUM(QTYORDER*PROD_SIZE/1000)-NVL(SUM(QTYCANCELLED*PROD_SIZE/1000),0) from view_sarl_contribution_sheet where STATE_CODE = 'GJ' AND ITEM_NATURE ='PG' AND DIV_CODE LIKE 'O%' AND VRDATE <= '"+x+"' AND VRDATE >= '"+y+"' AND DISTRICT IS NOT NULL group by DISTRICT order by SUM(QTYORDER*PROD_SIZE/1000)-NVL(SUM(QTYCANCELLED*PROD_SIZE/1000),0) desc");
            while(rs.next()){
                s1.getData().add(new XYChart.Data(rs.getString(1), rs.getDouble(2)));
            }
            data1.addAll(s1);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        return data1;
    }
          public ObservableList<XYChart.Series<String, Double>> barData7(){
        
        try{
            conn = CONNECT.ConnecterDb();
            ResultSet rs = conn.createStatement().executeQuery("select DISTRICT, SUM(QTYORDER*PROD_SIZE/1000)-NVL(SUM(QTYCANCELLED*PROD_SIZE/1000),0) from view_sarl_contribution_sheet where STATE_CODE = 'CG' AND ITEM_NATURE ='PG' AND DIV_CODE LIKE 'O%' AND VRDATE <= '"+x+"' AND VRDATE >= '"+y+"' AND DISTRICT IS NOT NULL group by DISTRICT order by SUM(QTYORDER*PROD_SIZE/1000)-NVL(SUM(QTYCANCELLED*PROD_SIZE/1000),0) desc");
            while(rs.next()){
                s1.getData().add(new XYChart.Data(rs.getString(1), rs.getDouble(2)));
            }
            data1.addAll(s1);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        return data1;
    }
           public ObservableList<XYChart.Series<String, Double>> barData8(){
        
        try{
            conn = CONNECT.ConnecterDb();
            ResultSet rs = conn.createStatement().executeQuery("select DISTRICT, SUM(QTYORDER*PROD_SIZE/1000)-NVL(SUM(QTYCANCELLED*PROD_SIZE/1000),0) from view_sarl_contribution_sheet where STATE_CODE = 'MP' AND ITEM_NATURE ='PG' AND DIV_CODE LIKE 'O%' AND VRDATE <= '"+x+"' AND VRDATE >= '"+y+"' AND DISTRICT IS NOT NULL group by DISTRICT order by SUM(QTYORDER*PROD_SIZE/1000)-NVL(SUM(QTYCANCELLED*PROD_SIZE/1000),0) desc");
            while(rs.next()){
                s1.getData().add(new XYChart.Data(rs.getString(1), rs.getDouble(2)));
            }
            data1.addAll(s1);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        return data1;
    }
           
    public ObservableList<XYChart.Series<String, Double>> LineData1(){
        
         try{
            conn = CONNECT.ConnecterDb();
            ResultSet rs = conn.createStatement().executeQuery("select add_months(sysdate,-60) from dual");
            while(rs.next()){
            a = fr.format(rs.getDate(1)).toString();
            }
            }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        
        try{
            conn = CONNECT.ConnecterDb();
            ResultSet rs = conn.createStatement().executeQuery("select to_char(VRDATE , 'yyyy'),SUM(QTYORDER*PROD_SIZE/1000)-NVL(SUM(QTYCANCELLED*PROD_SIZE/1000),0) from view_sarl_contribution_sheet Where DISTRICT = '"+z+"' AND ITEM_NATURE ='PG' AND DIV_CODE LIKE 'O%' AND VRDATE >= '"+a+"' Group By to_char(VRDATE , 'yyyy') order by to_char(VRDATE , 'yyyy')");
            while(rs.next()){
                s2.getData().add(new XYChart.Data(rs.getString(1),rs.getDouble(2)));
            }
            data2.addAll(s2);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        return data2;
    }       
    
    public ObservableList<XYChart.Series<String, Double>> LineData2(){
        
         try{
            conn = CONNECT.ConnecterDb();
            ResultSet rs = conn.createStatement().executeQuery("select add_months(sysdate,-9) from dual");
            while(rs.next()){
            a = fr.format(rs.getDate(1)).toString();
            }
            }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        
        try{
            conn = CONNECT.ConnecterDb();
            ResultSet rs = conn.createStatement().executeQuery("select to_char(VRDATE , 'mm'),SUM(QTYORDER*PROD_SIZE/1000)-NVL(SUM(QTYCANCELLED*PROD_SIZE/1000),0) from view_sarl_contribution_sheet Where DISTRICT = '"+z+"' AND ITEM_NATURE ='PG' AND DIV_CODE LIKE 'O%' AND VRDATE >= '"+a+"' Group By to_char(VRDATE , 'mm') order by to_char(VRDATE , 'mm')");
            while(rs.next()){
                s3.getData().add(new XYChart.Data(rs.getString(1),rs.getDouble(2)));
            }
            data3.addAll(s3);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        return data3;
    }       
    
    @Override
    public void start(Stage primaryStage) {
        BorderPane root = new BorderPane();
        BorderPane p = new BorderPane();
        BorderPane p1 = new BorderPane();
        
        Scene q = new Scene(p1,1280,720);
        Scene s = new Scene(p,1280,720);
        Scene scene = new Scene(root, 1280, 720);
        
        ToolBar t1 = new ToolBar();
        ToolBar t2 = new ToolBar();
        ToolBar t3 = new ToolBar();
        
        MenuButton m = new MenuButton("State");
        MenuButton m1 = new MenuButton("Select");
        
        MenuItem bt1 = new MenuItem("Yearly");
        MenuItem bt2 = new MenuItem("Monthly");
        
        m1.getItems().addAll(bt1,bt2);
        t3.getItems().add(m1);
        
        Label l1 = new Label("From");
        Label l2 = new Label("To");
        
        DatePicker d1 = new DatePicker(date().toLocalDate());
        DatePicker d2 = new DatePicker(LocalDate.now());
        
        x = fr.format(Date.valueOf(d2.getValue())).toString();
        y = fr.format(Date.valueOf(d1.getValue())).toString();
        
        Button b1 = new Button("Pie Chart");
        Button btn = new Button("Back");
        Button btnbk = new Button("Back");
       
        MenuItem btn1 = new MenuItem("Telangana");
        MenuItem btn2 = new MenuItem("Andhra Pradesh");
        MenuItem btn3 = new MenuItem("Maharashtra");
        MenuItem btn4 = new MenuItem("Karnataka");
        MenuItem btn5 = new MenuItem("Tamil Nadu");
        MenuItem btn6 = new MenuItem("Gujarat");
        MenuItem btn7 = new MenuItem("Chattisgarh");
        MenuItem btn8 = new MenuItem("Madhya Pradesh");
        
        root.setTop(t1);
        
        t1.getItems().addAll(l1,d1,l2,d2,m);
        t2.getItems().addAll(b1);
        
        m.getItems().addAll(btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8);
        
        CategoryAxis xAxis = new CategoryAxis();
        NumberAxis yAxis = new NumberAxis();
        BarChart bc = new BarChart(xAxis,yAxis,barData());
        bc.setTitle("Telangana");
        xAxis.setLabel("District");
        yAxis.setLabel("Sale Quantity in Tonne");
        
        root.setCenter(bc);

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
        
        CategoryAxis xAxis8 = new CategoryAxis();
        NumberAxis yAxis8 = new NumberAxis();
        
        CategoryAxis xAxis9 = new CategoryAxis();
        NumberAxis yAxis9 = new NumberAxis();
        
        CategoryAxis xAxis10 = new CategoryAxis();
        NumberAxis yAxis10 = new NumberAxis();
        
        
        btn1.setOnAction(e->{
            x = d2.getValue().toString();
            y = d1.getValue().toString();
        
            BarChart bc1 = new BarChart(xAxis1,yAxis1,barData1());
            bc1.setTitle("Telangana");
            xAxis1.setLabel("District");
            yAxis1.setLabel("Sale Quantity in Tonne");
            
            p.setTop(t2);
            p.setCenter(bc1);
            p.setBottom(btn);
            
            primaryStage.setScene(s);
            primaryStage.show();
            
            b1.setOnAction(a->{
                PieChart pc1 = new piechart().pieData("select DISTRICT, SUM(QTYORDER*PROD_SIZE/1000)-NVL(SUM(QTYCANCELLED*PROD_SIZE/1000),0) from view_sarl_contribution_sheet where STATE_CODE = 'TS' AND VRDATE <= to_date('"+x+"','yyyy/mm/dd') AND VRDATE >= to_date('"+y+"','yyyy/mm/dd') AND DISTRICT IS NOT NULL group by DISTRICT");
                p.setCenter(pc1);
            });
            
            for(XYChart.Data<String,Double> data : s1.getData()){
            Node n1 = data.getNode();
            n1.setOnMouseClicked(c->{
                z = data.getXValue();
                
                LineChart lc1 = new LineChart(xAxis9,yAxis9,LineData1());
                xAxis9.setLabel("Year");
                yAxis9.setLabel("Sale Quantity in KG");
                
                LineChart lc2 = new LineChart(xAxis10,yAxis10,LineData2());
                xAxis10.setLabel("Month");
                yAxis10.setLabel("Sale Quantity in KG");
                
                p1.setTop(t3);
                p1.setCenter(lc1);
                p1.setBottom(btn);
                bt1.setOnAction(r->{
                    p1.setCenter(lc1);
                    });
                bt2.setOnAction(r->{
                    p1.setCenter(lc2);
                    });
                
                primaryStage.setScene(q);
                primaryStage.show();
                
                });
            }
            btn.setOnAction(i->{
                data1.clear(); 
                s1.getData().clear();
                data2.clear(); 
                s2.getData().clear();
                data3.clear(); 
                s3.getData().clear();
                p.getChildren().clear();
                p1.getChildren().clear();
                
                primaryStage.setScene(scene);
                primaryStage.show();
            });  
        });
        
        btn2.setOnAction(e->{
            x = d2.getValue().toString();
            y = d1.getValue().toString();
            
            BarChart bc2 = new BarChart(xAxis3,yAxis3,barData3());
            bc2.setTitle("Andhra Pradesh");
            xAxis3.setLabel("District");
            yAxis3.setLabel("Sale Quantity in Tonne");
            
            p.setTop(t2);
            p.setCenter(bc2);
            p.setBottom(btn);
            
            primaryStage.setScene(s);
            primaryStage.show();
            
            b1.setOnAction(a->{
                PieChart pc1 = new piechart().pieData("select DISTRICT, SUM(QTYORDER*PROD_SIZE/1000)-NVL(SUM(QTYCANCELLED*PROD_SIZE/1000),0) from view_sarl_contribution_sheet where STATE_CODE = 'TS' AND VRDATE <= to_date('"+x+"','yyyy/mm/dd') AND VRDATE >= to_date('"+y+"','yyyy/mm/dd') AND DISTRICT IS NOT NULL group by DISTRICT");
                p.setCenter(pc1);
            });
            
            for(XYChart.Data<String,Double> data : s1.getData()){
            Node n1 = data.getNode();
            n1.setOnMouseClicked(c->{
                z = data.getXValue();
                
                LineChart lc1 = new LineChart(xAxis9,yAxis9,LineData1());
                xAxis9.setLabel("Year");
                yAxis9.setLabel("Sale Quantity in KG");
                
                LineChart lc2 = new LineChart(xAxis10,yAxis10,LineData2());
                xAxis10.setLabel("Month");
                yAxis10.setLabel("Sale Quantity in KG");
                
                p1.setTop(t3);
                p1.setCenter(lc1);
                p1.setBottom(btn);
                bt1.setOnAction(r->{
                    p1.setCenter(lc1);
                    });
                bt2.setOnAction(r->{
                    p1.setCenter(lc2);
                    });
                
                primaryStage.setScene(q);
                primaryStage.show();
                
                });
            }
            
            btn.setOnAction(i->{
                data1.clear(); 
                s1.getData().clear();
                data2.clear(); 
                s2.getData().clear();
                data3.clear(); 
                s3.getData().clear();
                p.getChildren().clear();
                
                primaryStage.setScene(scene);
                primaryStage.show();
            });
        });
        
        btn3.setOnAction(e->{
            x = d2.getValue().toString();
            y = d1.getValue().toString();
            
            BarChart bc3 = new BarChart(xAxis3,yAxis3,barData3());
            bc3.setTitle("Maharashtra");
            xAxis3.setLabel("District");
            yAxis3.setLabel("Sale Quantity in Tonne");
            
            p.setTop(t2);
            p.setCenter(bc3);
            p.setBottom(btn);
            
            primaryStage.setScene(s);
            primaryStage.show();
            
            b1.setOnAction(a->{
                PieChart pc1 = new piechart().pieData("select DISTRICT, SUM(QTYORDER*PROD_SIZE/1000)-NVL(SUM(QTYCANCELLED*PROD_SIZE/1000),0) from view_sarl_contribution_sheet where STATE_CODE = 'TS' AND VRDATE <= to_date('"+x+"','yyyy/mm/dd') AND VRDATE >= to_date('"+y+"','yyyy/mm/dd') AND DISTRICT IS NOT NULL group by DISTRICT");
                p.setCenter(pc1);
            });
            
            for(XYChart.Data<String,Double> data : s1.getData()){
            Node n1 = data.getNode();
            n1.setOnMouseClicked(c->{
                z = data.getXValue();
                
                LineChart lc1 = new LineChart(xAxis9,yAxis9,LineData1());
                xAxis9.setLabel("Year");
                yAxis9.setLabel("Sale Quantity in KG");
                
                LineChart lc2 = new LineChart(xAxis10,yAxis10,LineData2());
                xAxis10.setLabel("Month");
                yAxis10.setLabel("Sale Quantity in KG");
                
                p1.setTop(t3);
                p1.setCenter(lc1);
                p1.setBottom(btn);
                bt1.setOnAction(r->{
                    p1.setCenter(lc1);
                    });
                bt2.setOnAction(r->{
                    p1.setCenter(lc2);
                    });
                
                primaryStage.setScene(q);
                primaryStage.show();
                
                });
            }
            
            btn.setOnAction(i->{
                data1.clear(); 
                s1.getData().clear();
                data2.clear(); 
                s2.getData().clear();
                data3.clear(); 
                s3.getData().clear();
                p.getChildren().clear();
                
                primaryStage.setScene(scene);
                primaryStage.show();
            });
        });
        
        btn4.setOnAction(e->{
            x = d2.getValue().toString();
            y = d1.getValue().toString();
            
            BarChart bc4 = new BarChart(xAxis4,yAxis4,barData4());
            bc4.setTitle("Karnataka");
            xAxis4.setLabel("District");
            yAxis4.setLabel("Sale Quantity in Tonne");
            
            p.setTop(t2);
            p.setCenter(bc4);
            p.setBottom(btn);
            
            primaryStage.setScene(s);
            primaryStage.show();
            
            b1.setOnAction(a->{
                PieChart pc1 = new piechart().pieData("select DISTRICT, SUM(QTYORDER*PROD_SIZE/1000)-NVL(SUM(QTYCANCELLED*PROD_SIZE/1000),0) from view_sarl_contribution_sheet where STATE_CODE = 'TS' AND VRDATE <= to_date('"+x+"','yyyy/mm/dd') AND VRDATE >= to_date('"+y+"','yyyy/mm/dd') AND DISTRICT IS NOT NULL group by DISTRICT");
                p.setCenter(pc1);
            });
            
            for(XYChart.Data<String,Double> data : s1.getData()){
            Node n1 = data.getNode();
            n1.setOnMouseClicked(c->{
                z = data.getXValue();
                
                LineChart lc1 = new LineChart(xAxis9,yAxis9,LineData1());
                xAxis9.setLabel("Year");
                yAxis9.setLabel("Sale Quantity in KG");
                
                LineChart lc2 = new LineChart(xAxis10,yAxis10,LineData2());
                xAxis10.setLabel("Month");
                yAxis10.setLabel("Sale Quantity in KG");
                
                p1.setTop(t3);
                p1.setCenter(lc1);
                p1.setBottom(btn);
                bt1.setOnAction(r->{
                    p1.setCenter(lc1);
                    });
                bt2.setOnAction(r->{
                    p1.setCenter(lc2);
                    });
                
                primaryStage.setScene(q);
                primaryStage.show();
                
                });
            }
            
            btn.setOnAction(i->{
                data1.clear(); 
                s1.getData().clear();
                data2.clear(); 
                s2.getData().clear();
                data3.clear(); 
                s3.getData().clear();
                p.getChildren().clear();
                
                primaryStage.setScene(scene);
                primaryStage.show();
            });
        });
        
        btn5.setOnAction(e->{
            x = d2.getValue().toString();
            y = d1.getValue().toString();
            
            BarChart bc5 = new BarChart(xAxis5,yAxis5,barData5());
            bc5.setTitle("Tamil Nadu");
            xAxis5.setLabel("District");
            yAxis5.setLabel("Sale Quantity in Tonne");
            
            p.setTop(t2);
            p.setCenter(bc5);
            p.setBottom(btn);
            
            primaryStage.setScene(s);
            primaryStage.show();
            
            b1.setOnAction(a->{
                PieChart pc1 = new piechart().pieData("select DISTRICT, SUM(QTYORDER*PROD_SIZE/1000)-NVL(SUM(QTYCANCELLED*PROD_SIZE/1000),0) from view_sarl_contribution_sheet where STATE_CODE = 'TS' AND VRDATE <= to_date('"+x+"','yyyy/mm/dd') AND VRDATE >= to_date('"+y+"','yyyy/mm/dd') AND DISTRICT IS NOT NULL group by DISTRICT");
                p.setCenter(pc1);
            });
            
            for(XYChart.Data<String,Double> data : s1.getData()){
            Node n1 = data.getNode();
            n1.setOnMouseClicked(c->{
                z = data.getXValue();
                
                LineChart lc1 = new LineChart(xAxis9,yAxis9,LineData1());
                xAxis9.setLabel("Year");
                yAxis9.setLabel("Sale Quantity in KG");
                
                LineChart lc2 = new LineChart(xAxis10,yAxis10,LineData2());
                xAxis10.setLabel("Month");
                yAxis10.setLabel("Sale Quantity in KG");
                
                p1.setTop(t3);
                p1.setCenter(lc1);
                p1.setBottom(btn);
                bt1.setOnAction(r->{
                    p1.setCenter(lc1);
                    });
                bt2.setOnAction(r->{
                    p1.setCenter(lc2);
                    });
                
                primaryStage.setScene(q);
                primaryStage.show();
                
                });
            }
            
            btn.setOnAction(i->{
                data1.clear(); 
                s1.getData().clear();
                data2.clear(); 
                s2.getData().clear();
                data3.clear(); 
                s3.getData().clear();
                p.getChildren().clear();
                
                primaryStage.setScene(scene);
                primaryStage.show();
            });
        });
        
        btn6.setOnAction(e->{
            x = d2.getValue().toString();
            y = d1.getValue().toString();
            
            BarChart bc6 = new BarChart(xAxis6,yAxis6,barData6());
            bc6.setTitle("Gujarat");
            xAxis6.setLabel("District");
            yAxis6.setLabel("Sale Quantity in Tonne");
            
            p.setTop(t2);
            p.setCenter(bc6);
            p.setBottom(btn);
            
            primaryStage.setScene(s);
            primaryStage.show();
            
            b1.setOnAction(a->{
                PieChart pc1 = new piechart().pieData("select DISTRICT, SUM(QTYORDER*PROD_SIZE/1000)-NVL(SUM(QTYCANCELLED*PROD_SIZE/1000),0) from view_sarl_contribution_sheet where STATE_CODE = 'TS' AND VRDATE <= to_date('"+x+"','yyyy/mm/dd') AND VRDATE >= to_date('"+y+"','yyyy/mm/dd') AND DISTRICT IS NOT NULL group by DISTRICT");
                p.setCenter(pc1);
            });
            
            for(XYChart.Data<String,Double> data : s1.getData()){
            Node n1 = data.getNode();
            n1.setOnMouseClicked(c->{
                z = data.getXValue();
                
                LineChart lc1 = new LineChart(xAxis9,yAxis9,LineData1());
                xAxis9.setLabel("Year");
                yAxis9.setLabel("Sale Quantity in KG");
                
                LineChart lc2 = new LineChart(xAxis10,yAxis10,LineData2());
                xAxis10.setLabel("Month");
                yAxis10.setLabel("Sale Quantity in KG");
                
                p1.setTop(t3);
                p1.setCenter(lc1);
                p1.setBottom(btn);
                bt1.setOnAction(r->{
                    p1.setCenter(lc1);
                    });
                bt2.setOnAction(r->{
                    p1.setCenter(lc2);
                    });
                
                primaryStage.setScene(q);
                primaryStage.show();
                
                });
            }
            
            btn.setOnAction(i->{
                data1.clear(); 
                s1.getData().clear();
                data2.clear(); 
                s2.getData().clear();
                data3.clear(); 
                s3.getData().clear();
                p.getChildren().clear();
                
                primaryStage.setScene(scene);
                primaryStage.show();
            });
        });
        
        btn7.setOnAction(e->{
            x = d2.getValue().toString();
            y = d1.getValue().toString();
            
            BarChart bc7 = new BarChart(xAxis7,yAxis7,barData7());
            bc7.setTitle("Chattisgarh");
            xAxis7.setLabel("District");
            yAxis7.setLabel("Sale Quantity in Tonne");
            
            p.setTop(t2);
            p.setCenter(bc7);
            p.setBottom(btn);
            
            primaryStage.setScene(s);
            primaryStage.show();
            
            b1.setOnAction(a->{
                PieChart pc1 = new piechart().pieData("select DISTRICT, SUM(QTYORDER*PROD_SIZE/1000)-NVL(SUM(QTYCANCELLED*PROD_SIZE/1000),0) from view_sarl_contribution_sheet where STATE_CODE = 'TS' AND VRDATE <= to_date('"+x+"','yyyy/mm/dd') AND VRDATE >= to_date('"+y+"','yyyy/mm/dd') AND DISTRICT IS NOT NULL group by DISTRICT");
                p.setCenter(pc1);
            });
            
            for(XYChart.Data<String,Double> data : s1.getData()){
            Node n1 = data.getNode();
            n1.setOnMouseClicked(c->{
                z = data.getXValue();
                
                LineChart lc1 = new LineChart(xAxis9,yAxis9,LineData1());
                xAxis9.setLabel("Year");
                yAxis9.setLabel("Sale Quantity in KG");
                
                LineChart lc2 = new LineChart(xAxis10,yAxis10,LineData2());
                xAxis10.setLabel("Month");
                yAxis10.setLabel("Sale Quantity in KG");
                
                p1.setTop(t3);
                p1.setCenter(lc1);
                p1.setBottom(btn);
                bt1.setOnAction(r->{
                    p1.setCenter(lc1);
                    });
                bt2.setOnAction(r->{
                    p1.setCenter(lc2);
                    });
                
                primaryStage.setScene(q);
                primaryStage.show();
                
                });
            }
            
            btn.setOnAction(i->{
                data1.clear(); 
                s1.getData().clear();
                data2.clear(); 
                s2.getData().clear();
                data3.clear(); 
                s3.getData().clear();
                p.getChildren().clear();
                
                primaryStage.setScene(scene);
                primaryStage.show();
            });
        });
        
        btn8.setOnAction(e->{
            x = d2.getValue().toString();
            y = d1.getValue().toString();
            
            BarChart bc8 = new BarChart(xAxis8,yAxis8,barData8());
            bc8.setTitle("Madhya Pradesh");
            xAxis8.setLabel("District");
            yAxis8.setLabel("Sale Quantity in Tonne");
            
            p.setTop(t2);
            p.setCenter(bc8);
            p.setBottom(btn);
            
            primaryStage.setScene(s);
            primaryStage.show();
            
            b1.setOnAction(a->{
                PieChart pc1 = new piechart().pieData("select DISTRICT, SUM(QTYORDER*PROD_SIZE/1000)-NVL(SUM(QTYCANCELLED*PROD_SIZE/1000),0) from view_sarl_contribution_sheet where STATE_CODE = 'TS' AND VRDATE <= to_date('"+x+"','yyyy/mm/dd') AND VRDATE >= to_date('"+y+"','yyyy/mm/dd') AND VRDATE >= CAST('"+y+"' AS DATE) AND DISTRICT IS NOT NULL group by DISTRICT");
                p.setCenter(pc1);
            });
            
            for(XYChart.Data<String,Double> data : s1.getData()){
            Node n1 = data.getNode();
            n1.setOnMouseClicked(c->{
                z = data.getXValue();
                
                LineChart lc1 = new LineChart(xAxis9,yAxis9,LineData1());
                xAxis9.setLabel("Year");
                yAxis9.setLabel("Sale Quantity in KG");
                
                LineChart lc2 = new LineChart(xAxis10,yAxis10,LineData2());
                xAxis10.setLabel("Month");
                yAxis10.setLabel("Sale Quantity in KG");
                
                p1.setTop(t3);
                p1.setCenter(lc1);
                p1.setBottom(btn);
                bt1.setOnAction(r->{
                    p1.setCenter(lc1);
                    });
                bt2.setOnAction(r->{
                    p1.setCenter(lc2);
                    });
                
                primaryStage.setScene(q);
                primaryStage.show();
                
                });
            }
            
            btn.setOnAction(i->{
                data1.clear(); 
                s1.getData().clear();
                data2.clear(); 
                s2.getData().clear();
                data3.clear(); 
                s3.getData().clear();
                p.getChildren().clear();
                
                primaryStage.setScene(scene);
                primaryStage.show();
            });
        });
        
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
        
        root.setBottom(btnbk);
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
