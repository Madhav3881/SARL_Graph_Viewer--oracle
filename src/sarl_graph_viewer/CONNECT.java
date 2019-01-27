/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sarl_graph_viewer;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author madhav
 */
public class CONNECT {
    
     Connection conn = null;

    public static Connection ConnecterDb() {
        
        try{
            //Class.forName("com.mysql.jdbc.Driver");
            //Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/SARL","root","root");
            Class.forName("oracle.jdbc.OracleDriver");
            Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","sarltest","sarltest");
            return conn;
            
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
            System.exit(0);
        }
        return null;
        
    }
    
}
