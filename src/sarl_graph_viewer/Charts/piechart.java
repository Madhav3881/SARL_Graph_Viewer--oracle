/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sarl_graph_viewer.Charts;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.PieChart;
import javax.swing.JOptionPane;
import sarl_graph_viewer.CONNECT;

/**
 *
 * @author madhav
 */
public class piechart {
    
     ObservableList<javafx.scene.chart.PieChart.Data> data = FXCollections.observableArrayList();
    
    Connection conn;
    
    public PieChart pieData(String sql){
        
        try{
            
            conn = CONNECT.ConnecterDb();
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(sql);
        
        while(rs.next()){
            data.addAll(new javafx.scene.chart.PieChart.Data(rs.getString(1),rs.getDouble(2)));
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        PieChart p = new PieChart();
        p.setData(data);
    return p;
    
    }
      
   
}
