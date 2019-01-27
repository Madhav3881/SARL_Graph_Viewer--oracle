/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sarl_graph_viewer.State_Analysis;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
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
public class StateMain extends Application {
    
    Connection conn;
    Date d;
    
    String a;
    String x;
    String y;
    String z;
    Stage stage1 = new Stage();
    
        ObservableList<XYChart.Series<String , Double>> data = FXCollections.observableArrayList();
        ObservableList<XYChart.Series<String , Double>> data1 = FXCollections.observableArrayList();
        ObservableList<XYChart.Series<String , Double>> data2 = FXCollections.observableArrayList();
        ObservableList<XYChart.Series<String , Double>> data3 = FXCollections.observableArrayList();
        ObservableList<XYChart.Series<String , Double>> data4 = FXCollections.observableArrayList();
        ObservableList<XYChart.Series<String , Double>> data5 = FXCollections.observableArrayList();

        XYChart.Series<String, Double> s = new XYChart.Series<>();
        XYChart.Series<String, Double> s1 = new XYChart.Series<>();
        XYChart.Series<String, Double> s2 = new XYChart.Series<>();
        XYChart.Series<String, Double> s3 = new XYChart.Series<>();
        XYChart.Series<String, Double> s4 = new XYChart.Series<>();
        XYChart.Series<String, Double> s5 = new XYChart.Series<>();
        
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
            ResultSet rs = conn.createStatement().executeQuery("select STATE_CODE,SUM(QTYORDER*PROD_SIZE/1000)-NVL(SUM(QTYCANCELLED*PROD_SIZE/1000),0) from view_sarl_contribution_sheet where VRDATE <= '"+y+"' AND VRDATE >= '"+x+"' AND ITEM_NATURE ='PG' AND DIV_CODE LIKE 'O%' group by STATE_CODE order by SUM(QTYORDER*PROD_SIZE/1000)-NVL(SUM(QTYCANCELLED*PROD_SIZE/1000),0) desc");
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
     
     public ObservableList<XYChart.Series<String, Double>> barData5(){
        
        try{
            conn = CONNECT.ConnecterDb();
            ResultSet rs = conn.createStatement().executeQuery("select STATE_CODE, SUM(QTYORDER*PROD_SIZE/1000)-NVL(SUM(QTYCANCELLED*PROD_SIZE/1000),0) from view_sarl_contribution_sheet where VRDATE <= '"+y+"' AND VRDATE >= '"+x+"' AND ITEM_NATURE ='PG' AND DIV_CODE LIKE 'O%' group by STATE_CODE order by SUM(QTYORDER*PROD_SIZE/1000)-NVL(SUM(QTYCANCELLED*PROD_SIZE/1000),0) desc");
            while(rs.next()){
                s5.getData().add(new XYChart.Data(rs.getString(1), rs.getDouble(2)));
            }
            data5.addAll(s5);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        return data5;
    }
     
     public ObservableList<XYChart.Series<String, Double>> LineData_Year(){
        
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
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select to_char(VRDATE , 'yyyy'),SUM(QTYORDER*PROD_SIZE/1000)-NVL(SUM(QTYCANCELLED*PROD_SIZE/1000),0) from view_sarl_contribution_sheet Where STATE_CODE = '"+z+"' AND VRDATE >= '"+a+"' AND ITEM_NATURE ='PG' AND DIV_CODE LIKE 'O%' Group By to_char(VRDATE , 'yyyy') order by to_char(VRDATE , 'yyyy')");
            while (rs.next()){
                s1.getData().add(new XYChart.Data(rs.getString(1),rs.getDouble(2)));
            }
            data1.addAll(s1);
            s1.setName("Year");
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        return data1;
     }
     
     public ObservableList<XYChart.Series<String, Double>> LineData_Month(){
        
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
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select to_char(VRDATE , 'mm') ,SUM(QTYORDER*PROD_SIZE/1000)-NVL(SUM(QTYCANCELLED*PROD_SIZE/1000),0) from view_sarl_contribution_sheet Where STATE_CODE = '"+z+"' AND VRDATE >= '"+a+"' AND ITEM_NATURE ='PG' AND DIV_CODE LIKE 'O%' Group By to_char(VRDATE , 'mm') order by to_char(VRDATE , 'mm')");
            while (rs.next()){
                s2.getData().add(new XYChart.Data(rs.getString(1),rs.getDouble(2)));
            }
            data2.addAll(s2);
            s2.setName("Month");
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        return data2;
     }
     
     public ObservableList<XYChart.Series<String, Double>> LineData_Week(){
        
         try{
            conn = CONNECT.ConnecterDb();
            ResultSet rs = conn.createStatement().executeQuery("select add_months(sysdate,-3) from dual");
            while(rs.next()){
            a = fr.format(rs.getDate(1)).toString();
            }
            }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        
        try{
            conn = CONNECT.ConnecterDb();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select to_char(VRDATE , 'ww') ,SUM(QTYORDER*PROD_SIZE/1000)-NVL(SUM(QTYCANCELLED*PROD_SIZE/1000),0) from view_sarl_contribution_sheet Where STATE_CODE = '"+z+"' AND VRDATE >= '"+a+"' AND ITEM_NATURE ='PG' AND DIV_CODE LIKE 'O%' Group By to_char(VRDATE , 'ww') order by to_char(VRDATE , 'ww')");
            while (rs.next()){
                s3.getData().add(new XYChart.Data(rs.getString(1),rs.getDouble(2)));
            }
            data3.addAll(s3);
            s3.setName("Week");
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        return data3;
     }
     
     public ObservableList<XYChart.Series<String, Double>> LineData_Day(){
        
         try{
            conn = CONNECT.ConnecterDb();
            ResultSet rs = conn.createStatement().executeQuery("select (sysdate-9) from dual");
            while(rs.next()){
            a = fr.format(rs.getDate(1)).toString();
            }
            }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        
        try{
            conn = CONNECT.ConnecterDb();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select to_char(VRDATE , 'dd') ,SUM(QTYORDER*PROD_SIZE/1000)-NVL(SUM(QTYCANCELLED*PROD_SIZE/1000),0) from view_sarl_contribution_sheet Where STATE_CODE = '"+z+"' AND VRDATE >= '"+a+"' AND ITEM_NATURE ='PG' AND DIV_CODE LIKE 'O%' Group By to_char(VRDATE , 'dd') order by to_char(VRDATE , 'dd')");
            while (rs.next()){
                s4.getData().add(new XYChart.Data(rs.getString(1),rs.getDouble(2)));
            }
            data4.addAll(s4);
            s4.setName("Day");
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        return data4;
     }
    
    @Override
    public void start(Stage primaryStage) {
        
        BorderPane sroot = new BorderPane();
        BorderPane sroot1 = new BorderPane();
        BorderPane sroot2 = new BorderPane();
        BorderPane sroot3 = new BorderPane();
        ToolBar t1 = new ToolBar();
        ToolBar t2 = new ToolBar();
        Scene scene = new Scene(sroot, 1280, 720);
        Scene scene1 = new Scene(sroot1, 1280, 720);
        Scene scene2 = new Scene(sroot2, 1280, 720);
        Scene scene3 = new Scene(sroot3, 1280, 720);
        
        Button btn = new Button("Back");
        Button btnbk = new Button("Back");
        Button pie = new Button("Pie Chart");
        Button chart = new Button("Chart");
        
        DatePicker d1 = new DatePicker(date().toLocalDate());
        DatePicker d2 = new DatePicker(LocalDate.now());
        
        Label l1 = new Label("From");
        Label l2 = new Label("To");
        
        x = fr.format(Date.valueOf(d1.getValue())).toString();
        y = fr.format(Date.valueOf(d2.getValue())).toString();
        
        MenuButton m = new MenuButton("Select");
        
        MenuItem btn1 = new MenuItem("Yearly");
        MenuItem btn2 = new MenuItem("Monthly");
        MenuItem btn3 = new MenuItem("Weekly");
        MenuItem btn4 = new MenuItem("Daily");
        
        m.getItems().addAll(btn1,btn2,btn3,btn4);
        t1.getItems().addAll(pie,l1,d1,l2,d2,chart);
        t2.getItems().add(m);
        
        CategoryAxis xAxis = new CategoryAxis();
        NumberAxis yAxis = new NumberAxis();
        BarChart bc = new BarChart(xAxis,yAxis,barData());
        bc.setTitle("Sales Summary");
        xAxis.setLabel("State");
        yAxis.setLabel("Sale Quantity in Tonne");
        
         pie.setOnAction(e->{
            x = fr.format(Date.valueOf(d1.getValue())).toString();
            y = fr.format(Date.valueOf(d2.getValue())).toString();
            PieChart pc1 = new piechart().pieData("select STATE_CODE, SUM(QTYORDER*PROD_SIZE/1000)-NVL(SUM(QTYCANCELLED*PROD_SIZE/1000),0) from view_sarl_contribution_sheet where VRDATE >= CAST('"+x+"' AS DATE) AND VRDATE <= CAST('"+y+"' AS DATE) AND ITEM_NATURE ='PG' AND DIV_CODE LIKE 'O%' group by STATE_CODE");
                sroot3.setCenter(pc1);
                sroot3.setBottom(btn);
                primaryStage.setScene(scene3);
                primaryStage.show();
                btn.setOnAction(i->{
                    primaryStage.setScene(scene);
                    primaryStage.show();
                });  
        });
         
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
        
        chart.setOnAction(e->{
            
            x = fr.format(Date.valueOf(d1.getValue())).toString();
            y = fr.format(Date.valueOf(d2.getValue())).toString();
            BarChart bc5 = new BarChart(xAxis5,yAxis5,barData5());
            bc5.setTitle("Sales Summary");
            xAxis5.setLabel("State");
            yAxis5.setLabel("Sale Quantity in Tonne");
            sroot2.setCenter(bc5);
            sroot2.setBottom(btn);
            primaryStage.setScene(scene2);
            primaryStage.show();
            
            btn.setOnAction(i->{
                data5.clear();
                s5.getData().clear();
                primaryStage.setScene(scene);
                primaryStage.show();
            });
        });
         
         for(XYChart.Data<String,Double> data : s.getData()){
            Node n1 = data.getNode();
            n1.setOnMouseClicked(e->{
                z = data.getXValue();
                
                LineChart lc = new LineChart(xAxis6,yAxis6,LineData_Month());
                xAxis6.setLabel("Month");
                yAxis6.setLabel("Sale Quantity in Tonne");
                
                sroot1.setTop(t2);
                sroot1.setCenter(lc);
                sroot1.setBottom(btn);
                primaryStage.setScene(scene1);
                primaryStage.show();
                
                btn1.setOnAction(b->{
                    
                    LineChart lc1 = new LineChart(xAxis1,yAxis1,LineData_Year());
                    xAxis1.setLabel("Year");
                    yAxis1.setLabel("Sale Quantity in Tonne");
                    sroot1.setCenter(lc1);
                    data2.clear();
                    data3.clear();
                    data4.clear();
                    s2.getData().clear();
                    s3.getData().clear();
                    s4.getData().clear();
                });
                btn2.setOnAction(b->{
                    
                    LineChart lc2 = new LineChart(xAxis2,yAxis2,LineData_Month());
                    xAxis2.setLabel("Month");
                    yAxis2.setLabel("Sale Quantity in Tonne");
                    sroot1.setCenter(lc2);
                    data1.clear();
                    data3.clear();
                    data4.clear();
                    s1.getData().clear();
                    s3.getData().clear();
                    s4.getData().clear();
                });
                btn3.setOnAction(b->{
                    
                    LineChart lc3 = new LineChart(xAxis3,yAxis3,LineData_Week());
                    xAxis3.setLabel("Week");
                    yAxis3.setLabel("Sale Quantity in Tonne");
                    sroot1.setCenter(lc3);
                    data1.clear();
                    data2.clear();
                    data4.clear();
                    s1.getData().clear();
                    s2.getData().clear();
                    s4.getData().clear();
                });
                btn4.setOnAction(b->{
                    
                    LineChart lc4 = new LineChart(xAxis4,yAxis4,LineData_Day());
                    xAxis4.setLabel("Day");
                    yAxis4.setLabel("Sale Quantity in Tonne");
                    sroot1.setCenter(lc4);
                    data1.clear();
                    data2.clear();
                    data3.clear();
                    s1.getData().clear();
                    s2.getData().clear();
                    s3.getData().clear();
                });
                
                btn.setOnAction(a->{
                    data1.clear();
                    data2.clear();
                    data3.clear();
                    data4.clear();
                    s1.getData().clear();
                    s2.getData().clear();
                    s3.getData().clear();
                    s4.getData().clear();
                    sroot1.getChildren().removeAll();
                    
                    primaryStage.setScene(scene);
                    primaryStage.show();
                });
            });
         }
         
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
         
        sroot.setBottom(btnbk);
        sroot.setTop(t1);
        sroot.setCenter(bc);
        
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
