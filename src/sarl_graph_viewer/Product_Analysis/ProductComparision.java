/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sarl_graph_viewer.Product_Analysis;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.time.LocalDate;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBoxTreeItem;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ToolBar;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import org.controlsfx.control.CheckTreeView;
import sarl_graph_viewer.CONNECT;

/**
 *
 * @author madhav
 */
public class ProductComparision extends Application {
    
    Stage stage1 = new Stage();
    
    Connection conn;
    Date d;
    String x;
    String y;
    String z;
    String date1;
    String date2;
    String group;
    String option1;
    String option2;
    String option3;
    
    ObservableList<String> options1 = FXCollections.observableArrayList("Date","District","State","Year","Month","Week");
    ObservableList<String> options2 = FXCollections.observableArrayList("Quantity in Tonne","Rate","Cost Price","Cost Value","Contribution","Contribution Per Tonne");
    ObservableList<String> options3 = FXCollections.observableArrayList("All States","Telangana","Andhra Pradesh","Maharashtra","Karnataka","Tamil Nadu","Gujarat","Chattisgarh","Madhya Pradesh");
    
    ObservableList<XYChart.Series<String , Double>> data = FXCollections.observableArrayList();
    
    XYChart.Series<String, Double> s1 = new XYChart.Series<>();
    XYChart.Series<String, Double> s2 = new XYChart.Series<>();
    XYChart.Series<String, Double> s3 = new XYChart.Series<>();
    XYChart.Series<String, Double> s4 = new XYChart.Series<>();
    XYChart.Series<String, Double> s5 = new XYChart.Series<>();
    XYChart.Series<String, Double> s6 = new XYChart.Series<>();
    XYChart.Series<String, Double> s7 = new XYChart.Series<>();
    XYChart.Series<String, Double> s8 = new XYChart.Series<>();
    XYChart.Series<String, Double> s9 = new XYChart.Series<>();
    XYChart.Series<String, Double> s10 = new XYChart.Series<>();
    XYChart.Series<String, Double> s11 = new XYChart.Series<>();
    XYChart.Series<String, Double> s12 = new XYChart.Series<>();
    XYChart.Series<String, Double> s13 = new XYChart.Series<>();
    XYChart.Series<String, Double> s14 = new XYChart.Series<>();
    XYChart.Series<String, Double> s15 = new XYChart.Series<>();
    XYChart.Series<String, Double> s16 = new XYChart.Series<>();
    XYChart.Series<String, Double> s17 = new XYChart.Series<>();
    XYChart.Series<String, Double> s18 = new XYChart.Series<>();
    XYChart.Series<String, Double> s19 = new XYChart.Series<>();
    XYChart.Series<String, Double> s20 = new XYChart.Series<>();
    XYChart.Series<String, Double> s21 = new XYChart.Series<>();
    XYChart.Series<String, Double> s22 = new XYChart.Series<>();
    XYChart.Series<String, Double> s23 = new XYChart.Series<>();
    XYChart.Series<String, Double> s24 = new XYChart.Series<>();
    XYChart.Series<String, Double> s25 = new XYChart.Series<>();
    XYChart.Series<String, Double> s26 = new XYChart.Series<>();
    XYChart.Series<String, Double> s27 = new XYChart.Series<>();
    XYChart.Series<String, Double> s28 = new XYChart.Series<>();
    XYChart.Series<String, Double> s29 = new XYChart.Series<>();
    XYChart.Series<String, Double> s30 = new XYChart.Series<>();
    XYChart.Series<String, Double> s31 = new XYChart.Series<>();
    XYChart.Series<String, Double> s32 = new XYChart.Series<>();
    XYChart.Series<String, Double> s33 = new XYChart.Series<>();
    XYChart.Series<String, Double> s34 = new XYChart.Series<>();
    XYChart.Series<String, Double> s35 = new XYChart.Series<>();
    XYChart.Series<String, Double> s36 = new XYChart.Series<>();
    XYChart.Series<String, Double> s37 = new XYChart.Series<>();
    XYChart.Series<String, Double> s38 = new XYChart.Series<>();
    XYChart.Series<String, Double> s39 = new XYChart.Series<>();
    XYChart.Series<String, Double> s40 = new XYChart.Series<>();
    XYChart.Series<String, Double> s41 = new XYChart.Series<>();
    XYChart.Series<String, Double> s42 = new XYChart.Series<>();
    XYChart.Series<String, Double> s43 = new XYChart.Series<>();
    XYChart.Series<String, Double> s44 = new XYChart.Series<>();
    XYChart.Series<String, Double> s45 = new XYChart.Series<>();
    XYChart.Series<String, Double> s46 = new XYChart.Series<>();
    XYChart.Series<String, Double> s47 = new XYChart.Series<>();
    XYChart.Series<String, Double> s48 = new XYChart.Series<>();
    XYChart.Series<String, Double> s49 = new XYChart.Series<>();
    XYChart.Series<String, Double> s50 = new XYChart.Series<>();
    XYChart.Series<String, Double> s51 = new XYChart.Series<>();
    XYChart.Series<String, Double> s52 = new XYChart.Series<>();
    XYChart.Series<String, Double> s53 = new XYChart.Series<>();
    XYChart.Series<String, Double> s54 = new XYChart.Series<>();
    XYChart.Series<String, Double> s55 = new XYChart.Series<>();
    XYChart.Series<String, Double> s56 = new XYChart.Series<>();
    XYChart.Series<String, Double> s57 = new XYChart.Series<>();
    XYChart.Series<String, Double> s58 = new XYChart.Series<>();
    XYChart.Series<String, Double> s59 = new XYChart.Series<>();
    XYChart.Series<String, Double> s60 = new XYChart.Series<>();
    XYChart.Series<String, Double> s61 = new XYChart.Series<>();
    XYChart.Series<String, Double> s62 = new XYChart.Series<>();
    XYChart.Series<String, Double> s63 = new XYChart.Series<>();
    XYChart.Series<String, Double> s64 = new XYChart.Series<>();
    XYChart.Series<String, Double> s65 = new XYChart.Series<>();
    XYChart.Series<String, Double> s66 = new XYChart.Series<>();
    XYChart.Series<String, Double> s67 = new XYChart.Series<>();
    XYChart.Series<String, Double> s68 = new XYChart.Series<>();
    XYChart.Series<String, Double> s69 = new XYChart.Series<>();
    XYChart.Series<String, Double> s70 = new XYChart.Series<>();
    XYChart.Series<String, Double> s71 = new XYChart.Series<>();
    XYChart.Series<String, Double> s72 = new XYChart.Series<>();
    XYChart.Series<String, Double> s73 = new XYChart.Series<>();
    XYChart.Series<String, Double> s74 = new XYChart.Series<>();
    XYChart.Series<String, Double> s75 = new XYChart.Series<>();
    XYChart.Series<String, Double> s76 = new XYChart.Series<>();
    XYChart.Series<String, Double> s77 = new XYChart.Series<>();
    XYChart.Series<String, Double> s78 = new XYChart.Series<>();
    XYChart.Series<String, Double> s79 = new XYChart.Series<>();
    XYChart.Series<String, Double> s80 = new XYChart.Series<>();
    XYChart.Series<String, Double> s81 = new XYChart.Series<>();
    XYChart.Series<String, Double> s82 = new XYChart.Series<>();
    XYChart.Series<String, Double> s83 = new XYChart.Series<>();
    XYChart.Series<String, Double> s84 = new XYChart.Series<>();
    XYChart.Series<String, Double> s85 = new XYChart.Series<>();
    XYChart.Series<String, Double> s86 = new XYChart.Series<>();
    XYChart.Series<String, Double> s87 = new XYChart.Series<>();
    XYChart.Series<String, Double> s88 = new XYChart.Series<>();
    XYChart.Series<String, Double> s89 = new XYChart.Series<>();
    XYChart.Series<String, Double> s90 = new XYChart.Series<>();
    XYChart.Series<String, Double> s91 = new XYChart.Series<>();
    XYChart.Series<String, Double> s92 = new XYChart.Series<>();
    XYChart.Series<String, Double> s93 = new XYChart.Series<>();
    XYChart.Series<String, Double> s94 = new XYChart.Series<>();
    XYChart.Series<String, Double> s95 = new XYChart.Series<>();
    XYChart.Series<String, Double> s96 = new XYChart.Series<>();
    XYChart.Series<String, Double> s97 = new XYChart.Series<>();
    XYChart.Series<String, Double> s98 = new XYChart.Series<>();
    XYChart.Series<String, Double> s99 = new XYChart.Series<>();
    XYChart.Series<String, Double> s100 = new XYChart.Series<>();
    XYChart.Series<String, Double> s101 = new XYChart.Series<>();
    XYChart.Series<String, Double> s102 = new XYChart.Series<>();
    XYChart.Series<String, Double> s103 = new XYChart.Series<>();
    XYChart.Series<String, Double> s104 = new XYChart.Series<>();
    XYChart.Series<String, Double> s105 = new XYChart.Series<>();
    XYChart.Series<String, Double> s106 = new XYChart.Series<>();
    XYChart.Series<String, Double> s107 = new XYChart.Series<>();
    XYChart.Series<String, Double> s108 = new XYChart.Series<>();
    XYChart.Series<String, Double> s109 = new XYChart.Series<>();
    XYChart.Series<String, Double> s110 = new XYChart.Series<>();
    XYChart.Series<String, Double> s111 = new XYChart.Series<>();
    XYChart.Series<String, Double> s112 = new XYChart.Series<>();
    XYChart.Series<String, Double> s113 = new XYChart.Series<>();
    XYChart.Series<String, Double> s114 = new XYChart.Series<>();
    XYChart.Series<String, Double> s115 = new XYChart.Series<>();
    XYChart.Series<String, Double> s116 = new XYChart.Series<>();
    XYChart.Series<String, Double> s117 = new XYChart.Series<>();
    XYChart.Series<String, Double> s118 = new XYChart.Series<>();
    XYChart.Series<String, Double> s119 = new XYChart.Series<>();
    XYChart.Series<String, Double> s120 = new XYChart.Series<>();
    
    CheckBoxTreeItem<String> ch = new CheckBoxTreeItem<>("Select All");
        
        CheckBoxTreeItem<String> ch40 = new CheckBoxTreeItem<>("Naturralle 1 Ltr - Gn (1x16)");
        CheckBoxTreeItem<String> ch42 = new CheckBoxTreeItem<>("NATURRALLE 1 LTR - SF (Y) (1X16)");
        CheckBoxTreeItem<String> ch43 = new CheckBoxTreeItem<>("NATURRALLE 1 LTR - SF (Y) (1X10)");
        CheckBoxTreeItem<String> ch44 = new CheckBoxTreeItem<>("NATURRALLE 1 LTR - SF (Y) (1X12)");
        CheckBoxTreeItem<String> ch45 = new CheckBoxTreeItem<>("NATURRALLE 500 ML - SF (Y) (1X20)");
        CheckBoxTreeItem<String> ch46 = new CheckBoxTreeItem<>("NATURRALLE 500 ML - SF (Y) (1X32)");
        CheckBoxTreeItem<String> ch47 = new CheckBoxTreeItem<>("NATURRALLE 1 LTR PET BOTTLE - SF (Y) (1X12)");
        CheckBoxTreeItem<String> ch48 = new CheckBoxTreeItem<>("NATURRALLE 1 LTR PET BOTTLE - SF (Y) (1X16)");
        CheckBoxTreeItem<String> ch49 = new CheckBoxTreeItem<>("NATURRALLE 1 LTR PET BOTTLE - SF (Y) (1X10)");
        CheckBoxTreeItem<String> ch50 = new CheckBoxTreeItem<>("NATURRALLE 1 LTR - SF (Y) (1X16) - OFFER");
        CheckBoxTreeItem<String> ch51 = new CheckBoxTreeItem<>("NATURRALLE 100 ML SF (Y) (1X100)");
        CheckBoxTreeItem<String> ch54 = new CheckBoxTreeItem<>("NATURRALLE 5 LTR CAN - SF (Y) (1X4) OFFER");
        CheckBoxTreeItem<String> ch55 = new CheckBoxTreeItem<>("NATURRALLE 15 LTR CAN- SF (Y)");
        CheckBoxTreeItem<String> ch56 = new CheckBoxTreeItem<>("NATURRALLE 5 LTR CAN - SF (Y) (1X4) W/O");
        CheckBoxTreeItem<String> ch58 = new CheckBoxTreeItem<>("NATURRALLE 5 LTR JAR - (P) (1X4) - W/O");
        CheckBoxTreeItem<String> ch59 = new CheckBoxTreeItem<>("NATURRALLE 5 LTR JAR - SF (Y) (1X4) OFFER");
        CheckBoxTreeItem<String> ch62 = new CheckBoxTreeItem<>("NATURRALLE 5 LTR JAR - SF (Y) (1X4) W/O");
        CheckBoxTreeItem<String> ch63 = new CheckBoxTreeItem<>("NATURRALLE 15 LTR JAR - SF (YELLOW CAP)");
        CheckBoxTreeItem<String> ch64 = new CheckBoxTreeItem<>("NATURRALLE SFR 15 KG ROUND BARNI - PINK");
        CheckBoxTreeItem<String> ch67 = new CheckBoxTreeItem<>("NATURRALLE 15 LTR TIN - SF (Y) BR BORDER");
        CheckBoxTreeItem<String> ch68 = new CheckBoxTreeItem<>("NATURRALLE 15 KG TIN - SF (Y) PK BORDER");
        CheckBoxTreeItem<String> ch82 = new CheckBoxTreeItem<>("NATURALLE HEALTH 1LTR RB (1X12)");
        CheckBoxTreeItem<String> ch83 = new CheckBoxTreeItem<>("NATURALLE HEALTH 200ML RB (1X50)");
        CheckBoxTreeItem<String> ch84 = new CheckBoxTreeItem<>("NATURALLE HEALTH 5LTR CAN RB (1X4) OFFER");
        CheckBoxTreeItem<String> ch85 = new CheckBoxTreeItem<>("NATURALLE HEALTH 5LTR CAN RB (1X4) W/O");
        CheckBoxTreeItem<String> ch86 = new CheckBoxTreeItem<>("NATURRALLE HEALTH 15 LTR CAN- RB");
        CheckBoxTreeItem<String> ch87 = new CheckBoxTreeItem<>("NATURALLE HEALTH 2LTR CAN RB (1X10) W/O");
        CheckBoxTreeItem<String> ch88 = new CheckBoxTreeItem<>("NATURRALLE KGMO 1 LTR PET BOTTLE (1X16)");
        CheckBoxTreeItem<String> ch89 = new CheckBoxTreeItem<>("NATURRALLE KGMO 500ML PET BOTTLE (1X32)");
        CheckBoxTreeItem<String> ch101 = new CheckBoxTreeItem<>("Naturralle 50 Ml - Vp (1x320)");
        CheckBoxTreeItem<String> ch102 = new CheckBoxTreeItem<>("Naturralle 100 Ml - Vp (1x160)");
        CheckBoxTreeItem<String> ch103 = new CheckBoxTreeItem<>("Naturralle 100 Ml - Vp (1x100)");
        CheckBoxTreeItem<String> ch104 = new CheckBoxTreeItem<>("Naturralle 200 Ml - Vp (1x80)");
        CheckBoxTreeItem<String> ch106 = new CheckBoxTreeItem<>("Naturralle 500 Ml - Vp (1x20)");
        CheckBoxTreeItem<String> ch107 = new CheckBoxTreeItem<>("Naturralle 500 Ml - Vp (1x32)");
        CheckBoxTreeItem<String> ch109 = new CheckBoxTreeItem<>("Naturralle 1 Ltr - Vp (1x16)");
        CheckBoxTreeItem<String> ch110 = new CheckBoxTreeItem<>("Naturralle 1 Ltr - Vp (1x10)");
        CheckBoxTreeItem<String> ch116 = new CheckBoxTreeItem<>("Naturralle 15 Ltr Tin - Vp");
        CheckBoxTreeItem<String> ch118 = new CheckBoxTreeItem<>("Naturralle 15 Kg Tin - Vp");
        
        CheckBoxTreeItem<String> ch13 = new CheckBoxTreeItem<>("SUNSURRE YELLOW 1 LTR  (1X16)");
        CheckBoxTreeItem<String> ch21 = new CheckBoxTreeItem<>("SUNSURRE YELLOW 5 LTR CAN  (1X4) W/O");
        CheckBoxTreeItem<String> ch28 = new CheckBoxTreeItem<>("SUNSURRE YELLOW 5 LTR PET (1X4) W/O");
        CheckBoxTreeItem<String> ch38 = new CheckBoxTreeItem<>("SUNSURRE YELLOW 15 LTR TIN");
        CheckBoxTreeItem<String> ch39 = new CheckBoxTreeItem<>("SUNSURRE YELLOW 15 KG TIN");
        CheckBoxTreeItem<String> ch70 = new CheckBoxTreeItem<>("SUNSURRE 1 LTR (1X16)");
        CheckBoxTreeItem<String> ch73 = new CheckBoxTreeItem<>("SUNSURRE 5 LTR CAN  (1X4) W/O");
        CheckBoxTreeItem<String> ch77 = new CheckBoxTreeItem<>("SUNSURRE 5 LTR JAR  (1X4) W/O");
        CheckBoxTreeItem<String> ch78 = new CheckBoxTreeItem<>("SUNSURRE 5 LTR PET JAR BUCKET OFFER 1*4");
        CheckBoxTreeItem<String> ch79 = new CheckBoxTreeItem<>("SUNSURRE YELLOW 5 LTR PET - BL W/O");
        CheckBoxTreeItem<String> ch80 = new CheckBoxTreeItem<>("SUNSURRE 15 LTR TIN");
        CheckBoxTreeItem<String> ch81 = new CheckBoxTreeItem<>("SUNSURRE 15 KG TIN");
        
        CheckBoxTreeItem<String> ch8 = new CheckBoxTreeItem<>("KRISHNA BRRAND-R 1 LTR (1X16)");
        CheckBoxTreeItem<String> ch9 = new CheckBoxTreeItem<>("KRISHNA BRRAND-R (TP) 1 KG  (1X16)");
        CheckBoxTreeItem<String> ch10 = new CheckBoxTreeItem<>("KRISHNA BRRAND-R (TP) 1/2 KG (500G) (1X32)");
        CheckBoxTreeItem<String> ch11 = new CheckBoxTreeItem<>("KRISHNA BRRAND-R 250G TP  (1X48)");
        CheckBoxTreeItem<String> ch12 = new CheckBoxTreeItem<>("KRISHNA BRRAND-R 500 ML  (1X32)");
        CheckBoxTreeItem<String> ch15 = new CheckBoxTreeItem<>("KRISHNA BRRAND-R 15 KG CAN");
        CheckBoxTreeItem<String> ch16 = new CheckBoxTreeItem<>("KRISHNA BRRAND-R 15 LTR CAN");
        CheckBoxTreeItem<String> ch33 = new CheckBoxTreeItem<>("KRISHNA BRRAND-R 15 KG TIN  (CARTON)");
        CheckBoxTreeItem<String> ch34 = new CheckBoxTreeItem<>("KRISHNA BRRAND-R 15 KG TIN");
        CheckBoxTreeItem<String> ch35 = new CheckBoxTreeItem<>("KRISHNA BRRAND-R 15 LTR TIN  (CARTON)");
        CheckBoxTreeItem<String> ch69 = new CheckBoxTreeItem<>("Krishna Brrand-R (Tp) 1 Kg (1x10)");
        CheckBoxTreeItem<String> ch72 = new CheckBoxTreeItem<>("Krishna Brrand-R 15 Ltr Can - Bl");
         
        CheckBoxTreeItem<String> ch17 = new CheckBoxTreeItem<>("SRE KRISHNA GOLD 15 LTR CAN");
        CheckBoxTreeItem<String> ch18 = new CheckBoxTreeItem<>("SRE KRISHNA GOLD 15 KG CAN");
        CheckBoxTreeItem<String> ch20 = new CheckBoxTreeItem<>("SRE KRISHNA GOLD 5 LTR CAN  (1X4)");
        CheckBoxTreeItem<String> ch25 = new CheckBoxTreeItem<>("SRE KRISHNA GOLD 2 LTR JAR  (1X9)");
        CheckBoxTreeItem<String> ch26 = new CheckBoxTreeItem<>("SRE KRISHNA GOLD 3 LTR JAR  (1X6)");
        CheckBoxTreeItem<String> ch27 = new CheckBoxTreeItem<>("SRE KRISHNA GOLD 5 LTR JAR  (1X4)");
        CheckBoxTreeItem<String> ch36 = new CheckBoxTreeItem<>("SRE KRISHNA GOLD 15 LTR TIN");
        CheckBoxTreeItem<String> ch37 = new CheckBoxTreeItem<>("SRE KRISHNA GOLD 15 KG TIN");
        CheckBoxTreeItem<String> ch71 = new CheckBoxTreeItem<>("Sre Krishna Gold 5 Ltr Can (1x4) W/O");
        CheckBoxTreeItem<String> ch74 = new CheckBoxTreeItem<>("Sre Krishna Gold 2 Ltr Jar  (1x9) W/O");
        CheckBoxTreeItem<String> ch75 = new CheckBoxTreeItem<>("Sri Krishna Gold 5 Ltr Jar  (1x4) W/O");
        CheckBoxTreeItem<String> ch76 = new CheckBoxTreeItem<>("Sri Krishna Gold 3 Ltr Jar  (1x6) W/O");
        
        CheckBoxTreeItem<String> ch4 = new CheckBoxTreeItem<>("MOTHER'S CHOICE (TP) 500 ML - (1X32)");
        CheckBoxTreeItem<String> ch5 = new CheckBoxTreeItem<>("MOTHER'S CHOICE (TP) 1 LTR - (1X16)");
        CheckBoxTreeItem<String> ch6 = new CheckBoxTreeItem<>("MOTHER'S CHOICE (TP) 1/2 KG (500G) (1X32)");
        CheckBoxTreeItem<String> ch7 = new CheckBoxTreeItem<>("MOTHER'S CHOICE (TP) 1 KG - (1X16)");
        CheckBoxTreeItem<String> ch14 = new CheckBoxTreeItem<>("MOTHER'S CHOICE 15 LTR CAN");
        CheckBoxTreeItem<String> ch19 = new CheckBoxTreeItem<>("MOTHER'S CHOICE 15 KG CAN");
        CheckBoxTreeItem<String> ch22 = new CheckBoxTreeItem<>("MOTHER'S CHOICE 2 LTR JAR - (1X9) - W/O");
        CheckBoxTreeItem<String> ch23 = new CheckBoxTreeItem<>("MOTHER'S CHOICE 3 LTR JAR - (1X6) W/O");
        CheckBoxTreeItem<String> ch24 = new CheckBoxTreeItem<>("MOTHER'S CHOICE 5 LTR JAR - (1X4) W/O");
        CheckBoxTreeItem<String> ch31 = new CheckBoxTreeItem<>("MOTHER'S CHOICE 15 LTR TIN");
        CheckBoxTreeItem<String> ch32 = new CheckBoxTreeItem<>("MOTHER'S CHOICE 15 KG TIN");
        
        CheckBoxTreeItem<String> ch1 = new CheckBoxTreeItem<>("Ruchirraa 1 Ltr - Pm (1x16)");
        CheckBoxTreeItem<String> ch2 = new CheckBoxTreeItem<>("Ruchirraa 1 Ltr - Pm (1x10)");
        CheckBoxTreeItem<String> ch3 = new CheckBoxTreeItem<>("RUCHIRRAA 500G+220G FREE - PM (1X16)");
        CheckBoxTreeItem<String> ch29 = new CheckBoxTreeItem<>("RUCHIRRAA 15 KG TIN - PM");
        CheckBoxTreeItem<String> ch30 = new CheckBoxTreeItem<>("RUCHIRRAA 15 LTR TIN - PM");
        CheckBoxTreeItem<String> ch105 = new CheckBoxTreeItem<>("Ruchirraa 500 Ml - Vp (1x20)");
        CheckBoxTreeItem<String> ch108 = new CheckBoxTreeItem<>("Ruchirraa 1 Ltr - Vp (1x10)");
        CheckBoxTreeItem<String> ch111 = new CheckBoxTreeItem<>("Ruchirraa 200 Ml - Vp (1x50)");
        CheckBoxTreeItem<String> ch112 = new CheckBoxTreeItem<>("RUCHIRRA 50 ML - VP (1X200)");
        CheckBoxTreeItem<String> ch113 = new CheckBoxTreeItem<>("RUCHIRRA 100 ML - VP (1X100)");
        CheckBoxTreeItem<String> ch114 = new CheckBoxTreeItem<>("Ruchirraa 15 Kg Can- Vp");
        CheckBoxTreeItem<String> ch115 = new CheckBoxTreeItem<>("Ruchirraa 15 Ltr Can- Vp");
        CheckBoxTreeItem<String> ch117 = new CheckBoxTreeItem<>("Ruchirraa 15 Kg Tin - Vp");
        CheckBoxTreeItem<String> ch119 = new CheckBoxTreeItem<>("Ruchirra Vp - 15 Ltr Tin");
        
        CheckBoxTreeItem<String> ch41 = new CheckBoxTreeItem<>("Skd 1 Ltr - Sf (1x16) - W/O");
        CheckBoxTreeItem<String> ch52 = new CheckBoxTreeItem<>("Skd 5 Ltr Can - Sf (1x4)");
        CheckBoxTreeItem<String> ch53 = new CheckBoxTreeItem<>("Skd 5 Ltr Can - Sf (1x4) - W/O");
        CheckBoxTreeItem<String> ch57 = new CheckBoxTreeItem<>("Skd 5 Ltr Jar - Sf (1x4) - W/O");
        CheckBoxTreeItem<String> ch60 = new CheckBoxTreeItem<>("SKD 2 LTR JAR - SF (1X9) W/O");
        CheckBoxTreeItem<String> ch61 = new CheckBoxTreeItem<>("SKD 3 LTR JAR - SF (1X6) W/O");
        CheckBoxTreeItem<String> ch65 = new CheckBoxTreeItem<>("Skd 15 Ltr Tin - Sf");
        CheckBoxTreeItem<String> ch66 = new CheckBoxTreeItem<>("Skd 15 Kg Tin - Sf");
        CheckBoxTreeItem<String> ch90 = new CheckBoxTreeItem<>("Super Star (O) 15 Kg - Vp");
        CheckBoxTreeItem<String> ch91 = new CheckBoxTreeItem<>("SUPER PUFF (P) 15 KG - VP - M");
        CheckBoxTreeItem<String> ch92 = new CheckBoxTreeItem<>("Super Puff (B) 15 Kg - Vp");
        CheckBoxTreeItem<String> ch93 = new CheckBoxTreeItem<>("Super Bake (V) 15 Kg - Vp");
        CheckBoxTreeItem<String> ch94 = new CheckBoxTreeItem<>("SUPER LYTE (Y) 15 KG - VP");
        CheckBoxTreeItem<String> ch95 = new CheckBoxTreeItem<>("SUPER PUFF (P) 15 KG - VP - H");
        CheckBoxTreeItem<String> ch96 = new CheckBoxTreeItem<>("Marvell Cukie 15 Kg - Vp");
        CheckBoxTreeItem<String> ch97 = new CheckBoxTreeItem<>("Marvell Puffe 15 Kg - Vp");
        CheckBoxTreeItem<String> ch98 = new CheckBoxTreeItem<>("SUPER BAKER 15 KG - VP");
        CheckBoxTreeItem<String> ch99 = new CheckBoxTreeItem<>("MARVELL EXCEL 15KG -VP");
        CheckBoxTreeItem<String> ch100 = new CheckBoxTreeItem<>("MARVELL EXCEL 15 LTR - VP");
        CheckBoxTreeItem<String> ch120 = new CheckBoxTreeItem<>("G-1 15 KG TIN - VP");
        
        public Date date(){
        try{
            conn = CONNECT.ConnecterDb();
            ResultSet rs = conn.createStatement().executeQuery("select CURDATE()- INTERVAL 1 MONTH");
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
        
        if(ch1.isSelected()){
        try{
            conn = CONNECT.ConnecterDb();
            ResultSet rs = conn.createStatement().executeQuery("Select"+x+","+y+" from trial where "+z+" ITEM_NAME like '%Ruchirraa 1 Ltr - Pm (1x16)%' AND VRDATE <= CAST('"+date2+"' AS DATE) AND VRDATE >= CAST('"+date1+"' AS DATE) AND ITEM_NATURE ='PG' AND DIV_CODE LIKE 'O%' "+group+"");
            while(rs.next()){
                s1.getData().add(new XYChart.Data(rs.getString(1), rs.getDouble(2)));
            }
            s1.setName("Ruchirraa 1 Ltr - Pm (1x16)");
            data.addAll(s1);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
            }
        }
        if(ch2.isSelected()){
        try{
            conn = CONNECT.ConnecterDb();
            ResultSet rs = conn.createStatement().executeQuery("Select"+x+","+y+" from trial where "+z+" ITEM_NAME like '%Ruchirraa 1 Ltr - Pm (1x10)%' AND VRDATE <= CAST('"+date2+"' AS DATE) AND VRDATE >= CAST('"+date1+"' AS DATE) AND ITEM_NATURE ='PG' AND DIV_CODE LIKE 'O%' "+group+"");
            while(rs.next()){
                s2.getData().add(new XYChart.Data(rs.getString(1), rs.getDouble(2)));
            }
            s2.setName("Ruchirraa 1 Ltr - Pm (1x10)");
            data.addAll(s2);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
            }
        }
        if(ch3.isSelected()){
        try{
            conn = CONNECT.ConnecterDb();
            ResultSet rs = conn.createStatement().executeQuery("Select"+x+","+y+" from trial where "+z+" ITEM_NAME like '%RUCHIRRAA 500G+220G FREE - PM (1X16)%' AND VRDATE <= CAST('"+date2+"' AS DATE) AND VRDATE >= CAST('"+date1+"' AS DATE) AND ITEM_NATURE ='PG' AND DIV_CODE LIKE 'O%' "+group+"");
            while(rs.next()){
                s3.getData().add(new XYChart.Data(rs.getString(1), rs.getDouble(2)));
            }
            s3.setName("RUCHIRRAA 500G+220G FREE - PM (1X16)");
            data.addAll(s3);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
            }
        }
        if(ch4.isSelected()){
        try{
            conn = CONNECT.ConnecterDb();
            ResultSet rs = conn.createStatement().executeQuery("Select"+x+","+y+" from trial where "+z+" ITEM_NAME like '%MOTHER\'S CHOICE (TP) 500 ML - (1X32)%' AND VRDATE <= CAST('"+date2+"' AS DATE) AND VRDATE >= CAST('"+date1+"' AS DATE) AND ITEM_NATURE ='PG' AND DIV_CODE LIKE 'O%' "+group+"");
            while(rs.next()){
                s4.getData().add(new XYChart.Data(rs.getString(1), rs.getDouble(2)));
            }
            s4.setName("MOTHER'S CHOICE (TP) 500 ML - (1X32)");
            data.addAll(s4);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
            }
        }
        if(ch5.isSelected()){
        try{
            conn = CONNECT.ConnecterDb();
            ResultSet rs = conn.createStatement().executeQuery("Select"+x+","+y+" from trial where "+z+" ITEM_NAME like '%MOTHER\'S CHOICE (TP) 1 LTR - (1X16)%' AND VRDATE <= CAST('"+date2+"' AS DATE) AND VRDATE >= CAST('"+date1+"' AS DATE) AND ITEM_NATURE ='PG' AND DIV_CODE LIKE 'O%' "+group+"");
            while(rs.next()){
                s5.getData().add(new XYChart.Data(rs.getString(1), rs.getDouble(2)));
            }
            s5.setName("MOTHER'S CHOICE (TP) 1 LTR - (1X16)");
            data.addAll(s5);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
            }
        }
        if(ch6.isSelected()){
        try{
            conn = CONNECT.ConnecterDb();
            ResultSet rs = conn.createStatement().executeQuery("Select"+x+","+y+" from trial where "+z+" ITEM_NAME like '%MOTHER\'S CHOICE (TP) 1/2 KG (500G) (1X32)%' AND VRDATE <= CAST('"+date2+"' AS DATE) AND VRDATE >= CAST('"+date1+"' AS DATE) AND ITEM_NATURE ='PG' AND DIV_CODE LIKE 'O%' "+group+"");
            while(rs.next()){
                s6.getData().add(new XYChart.Data(rs.getString(1), rs.getDouble(2)));
            }
            s6.setName("MOTHER'S CHOICE (TP) 1/2 KG (500G) (1X32)");
            data.addAll(s6);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
            }
        }
        if(ch7.isSelected()){
        try{
            conn = CONNECT.ConnecterDb();
            ResultSet rs = conn.createStatement().executeQuery("Select"+x+","+y+" from trial where "+z+" ITEM_NAME like '%MOTHER\'S CHOICE (TP) 1 KG - (1X16)%' AND VRDATE <= CAST('"+date2+"' AS DATE) AND VRDATE >= CAST('"+date1+"' AS DATE) AND ITEM_NATURE ='PG' AND DIV_CODE LIKE 'O%' "+group+"");
            while(rs.next()){
                s7.getData().add(new XYChart.Data(rs.getString(1), rs.getDouble(2)));
            }
            s7.setName("MOTHER'S CHOICE (TP) 1 KG - (1X16)");
            data.addAll(s7);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
            }
        }
        if(ch8.isSelected()){
        try{
            conn = CONNECT.ConnecterDb();
            ResultSet rs = conn.createStatement().executeQuery("Select"+x+","+y+" from trial where "+z+" ITEM_NAME like '%KRISHNA BRRAND-R 1 LTR (1X16)%' AND VRDATE <= CAST('"+date2+"' AS DATE) AND VRDATE >= CAST('"+date1+"' AS DATE) AND ITEM_NATURE ='PG' AND DIV_CODE LIKE 'O%' "+group+"");
            while(rs.next()){
                s8.getData().add(new XYChart.Data(rs.getString(1), rs.getDouble(2)));
            }
            s8.setName("KRISHNA BRRAND-R 1 LTR (1X16)");
            data.addAll(s8);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
            }
        }
        if(ch9.isSelected()){
        try{
            conn = CONNECT.ConnecterDb();
            ResultSet rs = conn.createStatement().executeQuery("Select"+x+","+y+" from trial where "+z+" ITEM_NAME like '%KRISHNA BRRAND-R (TP) 1 KG  (1X16)%' AND VRDATE <= CAST('"+date2+"' AS DATE) AND VRDATE >= CAST('"+date1+"' AS DATE) AND ITEM_NATURE ='PG' AND DIV_CODE LIKE 'O%' "+group+"");
            while(rs.next()){
                s9.getData().add(new XYChart.Data(rs.getString(1), rs.getDouble(2)));
            }
            s9.setName("KRISHNA BRRAND-R (TP) 1 KG  (1X16)");
            data.addAll(s9);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
            }
        }
        if(ch10.isSelected()){
        try{
            conn = CONNECT.ConnecterDb();
            ResultSet rs = conn.createStatement().executeQuery("Select"+x+","+y+" from trial where "+z+" ITEM_NAME like '%KRISHNA BRRAND-R (TP) 1/2 KG (500G) (1X32)%' AND VRDATE <= CAST('"+date2+"' AS DATE) AND VRDATE >= CAST('"+date1+"' AS DATE) AND ITEM_NATURE ='PG' AND DIV_CODE LIKE 'O%' "+group+"");
            while(rs.next()){
                s10.getData().add(new XYChart.Data(rs.getString(1), rs.getDouble(2)));
            }
            s10.setName("KRISHNA BRRAND-R (TP) 1/2 KG (500G) (1X32)");
            data.addAll(s10);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
            }
        }
        if(ch11.isSelected()){
        try{
            conn = CONNECT.ConnecterDb();
            ResultSet rs = conn.createStatement().executeQuery("Select"+x+","+y+" from trial where "+z+" ITEM_NAME like '%KRISHNA BRRAND-R 250G TP  (1X48)%' AND VRDATE <= CAST('"+date2+"' AS DATE) AND VRDATE >= CAST('"+date1+"' AS DATE) AND ITEM_NATURE ='PG' AND DIV_CODE LIKE 'O%' "+group+"");
            while(rs.next()){
                s11.getData().add(new XYChart.Data(rs.getString(1), rs.getDouble(2)));
            }
            s11.setName("KRISHNA BRRAND-R 250G TP  (1X48)");
            data.addAll(s11);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
            }
        }
        if(ch12.isSelected()){
        try{
            conn = CONNECT.ConnecterDb();
            ResultSet rs = conn.createStatement().executeQuery("Select"+x+","+y+" from trial where "+z+" ITEM_NAME like '%KRISHNA BRRAND-R 500 ML  (1X32)%' AND VRDATE <= CAST('"+date2+"' AS DATE) AND VRDATE >= CAST('"+date1+"' AS DATE) AND ITEM_NATURE ='PG' AND DIV_CODE LIKE 'O%' "+group+"");
            while(rs.next()){
                s12.getData().add(new XYChart.Data(rs.getString(1), rs.getDouble(2)));
            }
            s12.setName("KRISHNA BRRAND-R 500 ML  (1X32)");
            data.addAll(s12);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
            }
        }
        if(ch13.isSelected()){
        try{
            conn = CONNECT.ConnecterDb();
            ResultSet rs = conn.createStatement().executeQuery("Select"+x+","+y+" from trial where "+z+" ITEM_NAME like '%SUNSURRE YELLOW 1 LTR  (1X16)%' AND VRDATE <= CAST('"+date2+"' AS DATE) AND VRDATE >= CAST('"+date1+"' AS DATE) AND ITEM_NATURE ='PG' AND DIV_CODE LIKE 'O%' "+group+"");
            while(rs.next()){
                s13.getData().add(new XYChart.Data(rs.getString(1), rs.getDouble(2)));
            }
            s13.setName("SUNSURRE YELLOW 1 LTR  (1X16)");
            data.addAll(s13);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
            }
        }
        if(ch14.isSelected()){
        try{
            conn = CONNECT.ConnecterDb();
            ResultSet rs = conn.createStatement().executeQuery("Select"+x+","+y+" from trial where "+z+" ITEM_NAME like '%MOTHER\'S CHOICE 15 LTR CAN%' AND VRDATE <= CAST('"+date2+"' AS DATE) AND VRDATE >= CAST('"+date1+"' AS DATE) AND ITEM_NATURE ='PG' AND DIV_CODE LIKE 'O%' "+group+"");
            while(rs.next()){
                s14.getData().add(new XYChart.Data(rs.getString(1), rs.getDouble(2)));
            }
            s14.setName("MOTHER'S CHOICE 15 LTR CAN");
            data.addAll(s14);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
            }
        }
        if(ch15.isSelected()){
        try{
            conn = CONNECT.ConnecterDb();
            ResultSet rs = conn.createStatement().executeQuery("Select"+x+","+y+" from trial where "+z+" ITEM_NAME like '%KRISHNA BRRAND-R 15 KG CAN%' AND VRDATE <= CAST('"+date2+"' AS DATE) AND VRDATE >= CAST('"+date1+"' AS DATE) AND ITEM_NATURE ='PG' AND DIV_CODE LIKE 'O%' "+group+"");
            while(rs.next()){
                s15.getData().add(new XYChart.Data(rs.getString(1), rs.getDouble(2)));
            }
            s15.setName("KRISHNA BRRAND-R 15 KG CAN");
            data.addAll(s15);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
            }
        }
        if(ch16.isSelected()){
        try{
            conn = CONNECT.ConnecterDb();
            ResultSet rs = conn.createStatement().executeQuery("Select"+x+","+y+" from trial where "+z+" ITEM_NAME like '%KRISHNA BRRAND-R 15 LTR CAN%' AND VRDATE <= CAST('"+date2+"' AS DATE) AND VRDATE >= CAST('"+date1+"' AS DATE) AND ITEM_NATURE ='PG' AND DIV_CODE LIKE 'O%' "+group+"");
            while(rs.next()){
                s16.getData().add(new XYChart.Data(rs.getString(1), rs.getDouble(2)));
            }
            s16.setName("KRISHNA BRRAND-R 15 LTR CAN");
            data.addAll(s16);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
            }
        }
        if(ch17.isSelected()){
        try{
            conn = CONNECT.ConnecterDb();
            ResultSet rs = conn.createStatement().executeQuery("Select"+x+","+y+" from trial where "+z+" ITEM_NAME like '%SRE KRISHNA GOLD 15 LTR CAN%' AND VRDATE <= CAST('"+date2+"' AS DATE) AND VRDATE >= CAST('"+date1+"' AS DATE) AND ITEM_NATURE ='PG' AND DIV_CODE LIKE 'O%' "+group+"");
            while(rs.next()){
                s17.getData().add(new XYChart.Data(rs.getString(1), rs.getDouble(2)));
            }
            s17.setName("SRE KRISHNA GOLD 15 LTR CAN");
            data.addAll(s17);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
            }
        }
        if(ch18.isSelected()){
        try{
            conn = CONNECT.ConnecterDb();
            ResultSet rs = conn.createStatement().executeQuery("Select"+x+","+y+" from trial where "+z+" ITEM_NAME like '%SRE KRISHNA GOLD 15 KG CAN%' AND VRDATE <= CAST('"+date2+"' AS DATE) AND VRDATE >= CAST('"+date1+"' AS DATE) AND ITEM_NATURE ='PG' AND DIV_CODE LIKE 'O%' "+group+"");
            while(rs.next()){
                s18.getData().add(new XYChart.Data(rs.getString(1), rs.getDouble(2)));
            }
            s18.setName("SRE KRISHNA GOLD 15 KG CAN");
            data.addAll(s18);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
            }
        }
        if(ch19.isSelected()){
        try{
            conn = CONNECT.ConnecterDb();
            ResultSet rs = conn.createStatement().executeQuery("Select"+x+","+y+" from trial where "+z+" ITEM_NAME like '%MOTHER\'S CHOICE 15 KG CAN%' AND VRDATE <= CAST('"+date2+"' AS DATE) AND VRDATE >= CAST('"+date1+"' AS DATE) AND ITEM_NATURE ='PG' AND DIV_CODE LIKE 'O%' "+group+"");
            while(rs.next()){
                s19.getData().add(new XYChart.Data(rs.getString(1), rs.getDouble(2)));
            }
            s19.setName("MOTHER'S CHOICE 15 KG CAN");
            data.addAll(s19);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
            }
        }
        if(ch20.isSelected()){
        try{
            conn = CONNECT.ConnecterDb();
            ResultSet rs = conn.createStatement().executeQuery("Select"+x+","+y+" from trial where "+z+" ITEM_NAME like '%SRE KRISHNA GOLD 5 LTR CAN  (1X4)%' AND VRDATE <= CAST('"+date2+"' AS DATE) AND VRDATE >= CAST('"+date1+"' AS DATE) AND ITEM_NATURE ='PG' AND DIV_CODE LIKE 'O%' "+group+"");
            while(rs.next()){
                s20.getData().add(new XYChart.Data(rs.getString(1), rs.getDouble(2)));
            }
            s20.setName("SRE KRISHNA GOLD 5 LTR CAN  (1X4)");
            data.addAll(s20);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
            }
        }
        if(ch21.isSelected()){
        try{
            conn = CONNECT.ConnecterDb();
            ResultSet rs = conn.createStatement().executeQuery("Select"+x+","+y+" from trial where "+z+" ITEM_NAME like '%SUNSURRE YELLOW 5 LTR CAN  (1X4) W/O%' AND VRDATE <= CAST('"+date2+"' AS DATE) AND VRDATE >= CAST('"+date1+"' AS DATE) AND ITEM_NATURE ='PG' AND DIV_CODE LIKE 'O%' "+group+"");
            while(rs.next()){
                s21.getData().add(new XYChart.Data(rs.getString(1), rs.getDouble(2)));
            }
            s21.setName("SUNSURRE YELLOW 5 LTR CAN  (1X4) W/O");
            data.addAll(s21);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
            }
        }
        if(ch22.isSelected()){
        try{
            conn = CONNECT.ConnecterDb();
            ResultSet rs = conn.createStatement().executeQuery("Select"+x+","+y+" from trial where "+z+" ITEM_NAME like '%MOTHER\'S CHOICE 2 LTR JAR - (1X9) - W/O%' AND VRDATE <= CAST('"+date2+"' AS DATE) AND VRDATE >= CAST('"+date1+"' AS DATE) AND ITEM_NATURE ='PG' AND DIV_CODE LIKE 'O%' "+group+"");
            while(rs.next()){
                s22.getData().add(new XYChart.Data(rs.getString(1), rs.getDouble(2)));
            }
            s22.setName("MOTHER\'S CHOICE 2 LTR JAR - (1X9) - W/O");
            data.addAll(s22);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
            }
        }
        if(ch23.isSelected()){
        try{
            conn = CONNECT.ConnecterDb();
            ResultSet rs = conn.createStatement().executeQuery("Select"+x+","+y+" from trial where "+z+" ITEM_NAME like '%MOTHER\'S CHOICE 3 LTR JAR - (1X6) W/O%' AND VRDATE <= CAST('"+date2+"' AS DATE) AND VRDATE >= CAST('"+date1+"' AS DATE) AND ITEM_NATURE ='PG' AND DIV_CODE LIKE 'O%' "+group+"");
            while(rs.next()){
                s23.getData().add(new XYChart.Data(rs.getString(1), rs.getDouble(2)));
            }
            s23.setName("MOTHER'S CHOICE 3 LTR JAR - (1X6) W/O");
            data.addAll(s23);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
            }
        }
        if(ch24.isSelected()){
        try{
            conn = CONNECT.ConnecterDb();
            ResultSet rs = conn.createStatement().executeQuery("Select"+x+","+y+" from trial where "+z+" ITEM_NAME like '%MOTHER\'S CHOICE 5 LTR JAR - (1X4) W/O%' AND VRDATE <= CAST('"+date2+"' AS DATE) AND VRDATE >= CAST('"+date1+"' AS DATE) AND ITEM_NATURE ='PG' AND DIV_CODE LIKE 'O%' "+group+"");
            while(rs.next()){
                s24.getData().add(new XYChart.Data(rs.getString(1), rs.getDouble(2)));
            }
            s24.setName("MOTHER'S CHOICE 5 LTR JAR - (1X4) W/O");
            data.addAll(s24);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
            }
        }
        if(ch25.isSelected()){
        try{
            conn = CONNECT.ConnecterDb();
            ResultSet rs = conn.createStatement().executeQuery("Select"+x+","+y+" from trial where "+z+" ITEM_NAME like '%SRE KRISHNA GOLD 2 LTR JAR  (1X9)%' AND VRDATE <= CAST('"+date2+"' AS DATE) AND VRDATE >= CAST('"+date1+"' AS DATE) AND ITEM_NATURE ='PG' AND DIV_CODE LIKE 'O%' "+group+"");
            while(rs.next()){
                s25.getData().add(new XYChart.Data(rs.getString(1), rs.getDouble(2)));
            }
            s25.setName("SRE KRISHNA GOLD 2 LTR JAR  (1X9)");
            data.addAll(s25);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
            }
        }
        if(ch26.isSelected()){
        try{
            conn = CONNECT.ConnecterDb();
            ResultSet rs = conn.createStatement().executeQuery("Select"+x+","+y+" from trial where "+z+" ITEM_NAME like '%SRE KRISHNA GOLD 3 LTR JAR  (1X6)%' AND VRDATE <= CAST('"+date2+"' AS DATE) AND VRDATE >= CAST('"+date1+"' AS DATE) AND ITEM_NATURE ='PG' AND DIV_CODE LIKE 'O%' "+group+"");
            while(rs.next()){
                s26.getData().add(new XYChart.Data(rs.getString(1), rs.getDouble(2)));
            }
            s26.setName("SRE KRISHNA GOLD 3 LTR JAR  (1X6)");
            data.addAll(s26);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
            }
        }
        if(ch27.isSelected()){
        try{
            conn = CONNECT.ConnecterDb();
            ResultSet rs = conn.createStatement().executeQuery("Select"+x+","+y+" from trial where "+z+" ITEM_NAME like '%SRE KRISHNA GOLD 5 LTR JAR  (1X4)%' AND VRDATE <= CAST('"+date2+"' AS DATE) AND VRDATE >= CAST('"+date1+"' AS DATE) AND ITEM_NATURE ='PG' AND DIV_CODE LIKE 'O%' "+group+"");
            while(rs.next()){
                s27.getData().add(new XYChart.Data(rs.getString(1), rs.getDouble(2)));
            }
            s27.setName("SRE KRISHNA GOLD 5 LTR JAR  (1X4)");
            data.addAll(s27);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
            }
        }
        if(ch28.isSelected()){
        try{
            conn = CONNECT.ConnecterDb();
            ResultSet rs = conn.createStatement().executeQuery("Select"+x+","+y+" from trial where "+z+" ITEM_NAME like '%SUNSURRE YELLOW 5 LTR PET (1X4) W/O%' AND VRDATE <= CAST('"+date2+"' AS DATE) AND VRDATE >= CAST('"+date1+"' AS DATE) AND ITEM_NATURE ='PG' AND DIV_CODE LIKE 'O%' "+group+"");
            while(rs.next()){
                s28.getData().add(new XYChart.Data(rs.getString(1), rs.getDouble(2)));
            }
            s28.setName("SUNSURRE YELLOW 5 LTR PET (1X4) W/O");
            data.addAll(s28);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
            }
        }
        if(ch29.isSelected()){
        try{
            conn = CONNECT.ConnecterDb();
            ResultSet rs = conn.createStatement().executeQuery("Select"+x+","+y+" from trial where "+z+" ITEM_NAME like '%RUCHIRRAA 15 KG TIN - PM%' AND VRDATE <= CAST('"+date2+"' AS DATE) AND VRDATE >= CAST('"+date1+"' AS DATE) AND ITEM_NATURE ='PG' AND DIV_CODE LIKE 'O%' "+group+"");
            while(rs.next()){
                s29.getData().add(new XYChart.Data(rs.getString(1), rs.getDouble(2)));
            }
            s29.setName("RUCHIRRAA 15 KG TIN - PM");
            data.addAll(s29);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
            }
        }
        if(ch30.isSelected()){
        try{
            conn = CONNECT.ConnecterDb();
            ResultSet rs = conn.createStatement().executeQuery("Select"+x+","+y+" from trial where "+z+" ITEM_NAME like '%RUCHIRRAA 15 LTR TIN - PM%' AND VRDATE <= CAST('"+date2+"' AS DATE) AND VRDATE >= CAST('"+date1+"' AS DATE) AND ITEM_NATURE ='PG' AND DIV_CODE LIKE 'O%' "+group+"");
            while(rs.next()){
                s30.getData().add(new XYChart.Data(rs.getString(1), rs.getDouble(2)));
            }
            s30.setName("RUCHIRRAA 15 LTR TIN - PM");
            data.addAll(s30);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
            }
        }
        if(ch31.isSelected()){
        try{
            conn = CONNECT.ConnecterDb();
            ResultSet rs = conn.createStatement().executeQuery("Select"+x+","+y+" from trial where "+z+" ITEM_NAME like '%MOTHER\'S CHOICE 15 LTR TIN%' AND VRDATE <= CAST('"+date2+"' AS DATE) AND VRDATE >= CAST('"+date1+"' AS DATE) AND ITEM_NATURE ='PG' AND DIV_CODE LIKE 'O%' "+group+"");
            while(rs.next()){
                s31.getData().add(new XYChart.Data(rs.getString(1), rs.getDouble(2)));
            }
            s31.setName("MOTHER'S CHOICE 15 LTR TIN");
            data.addAll(s31);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
            }
        }
        if(ch32.isSelected()){
        try{
            conn = CONNECT.ConnecterDb();
            ResultSet rs = conn.createStatement().executeQuery("Select"+x+","+y+" from trial where "+z+" ITEM_NAME like '%MOTHER\'S CHOICE 15 KG TIN%' AND VRDATE <= CAST('"+date2+"' AS DATE) AND VRDATE >= CAST('"+date1+"' AS DATE) AND ITEM_NATURE ='PG' AND DIV_CODE LIKE 'O%' "+group+"");
            while(rs.next()){
                s32.getData().add(new XYChart.Data(rs.getString(1), rs.getDouble(2)));
            }
            s32.setName("MOTHER'S CHOICE 15 KG TIN");
            data.addAll(s32);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
            }
        }
        if(ch33.isSelected()){
        try{
            conn = CONNECT.ConnecterDb();
            ResultSet rs = conn.createStatement().executeQuery("Select"+x+","+y+" from trial where "+z+" ITEM_NAME like '%KRISHNA BRRAND-R 15 KG TIN  (CARTON)%' AND VRDATE <= CAST('"+date2+"' AS DATE) AND VRDATE >= CAST('"+date1+"' AS DATE) AND ITEM_NATURE ='PG' AND DIV_CODE LIKE 'O%' "+group+"");
            while(rs.next()){
                s33.getData().add(new XYChart.Data(rs.getString(1), rs.getDouble(2)));
            }
            s33.setName("KRISHNA BRRAND-R 15 KG TIN  (CARTON)");
            data.addAll(s33);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
            }
        }
        if(ch34.isSelected()){
        try{
            conn = CONNECT.ConnecterDb();
            ResultSet rs = conn.createStatement().executeQuery("Select"+x+","+y+" from trial where "+z+" ITEM_NAME like '%KRISHNA BRRAND-R 15 KG TIN%' AND VRDATE <= CAST('"+date2+"' AS DATE) AND VRDATE >= CAST('"+date1+"' AS DATE) AND ITEM_NATURE ='PG' AND DIV_CODE LIKE 'O%' "+group+"");
            while(rs.next()){
                s34.getData().add(new XYChart.Data(rs.getString(1), rs.getDouble(2)));
            }
            s34.setName("KRISHNA BRRAND-R 15 KG TIN");
            data.addAll(s34);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
            }
        }
        if(ch35.isSelected()){
        try{
            conn = CONNECT.ConnecterDb();
            ResultSet rs = conn.createStatement().executeQuery("Select"+x+","+y+" from trial where "+z+" ITEM_NAME like '%KRISHNA BRRAND-R 15 LTR TIN  (CARTON)%' AND VRDATE <= CAST('"+date2+"' AS DATE) AND VRDATE >= CAST('"+date1+"' AS DATE) AND ITEM_NATURE ='PG' AND DIV_CODE LIKE 'O%' "+group+"");
            while(rs.next()){
                s35.getData().add(new XYChart.Data(rs.getString(1), rs.getDouble(2)));
            }
            s35.setName("KRISHNA BRRAND-R 15 LTR TIN  (CARTON)");
            data.addAll(s35);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
            }
        }
        if(ch36.isSelected()){
        try{
            conn = CONNECT.ConnecterDb();
            ResultSet rs = conn.createStatement().executeQuery("Select"+x+","+y+" from trial where "+z+" ITEM_NAME like '%SRE KRISHNA GOLD 15 LTR TIN%' AND VRDATE <= CAST('"+date2+"' AS DATE) AND VRDATE >= CAST('"+date1+"' AS DATE) AND ITEM_NATURE ='PG' AND DIV_CODE LIKE 'O%' "+group+"");
            while(rs.next()){
                s36.getData().add(new XYChart.Data(rs.getString(1), rs.getDouble(2)));
            }
            s36.setName("SRE KRISHNA GOLD 15 LTR TIN");
            data.addAll(s36);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
            }
        }
        if(ch37.isSelected()){
        try{
            conn = CONNECT.ConnecterDb();
            ResultSet rs = conn.createStatement().executeQuery("Select"+x+","+y+" from trial where "+z+" ITEM_NAME like '%SRE KRISHNA GOLD 15 KG TIN%' AND VRDATE <= CAST('"+date2+"' AS DATE) AND VRDATE >= CAST('"+date1+"' AS DATE) AND ITEM_NATURE ='PG' AND DIV_CODE LIKE 'O%' "+group+"");
            while(rs.next()){
                s37.getData().add(new XYChart.Data(rs.getString(1), rs.getDouble(2)));
            }
            s37.setName("SRE KRISHNA GOLD 15 KG TIN");
            data.addAll(s37);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
            }
        }
        if(ch38.isSelected()){
        try{
            conn = CONNECT.ConnecterDb();
            ResultSet rs = conn.createStatement().executeQuery("Select"+x+","+y+" from trial where "+z+" ITEM_NAME like '%SUNSURRE YELLOW 15 LTR TIN%' AND VRDATE <= CAST('"+date2+"' AS DATE) AND VRDATE >= CAST('"+date1+"' AS DATE) AND ITEM_NATURE ='PG' AND DIV_CODE LIKE 'O%' "+group+"");
            while(rs.next()){
                s38.getData().add(new XYChart.Data(rs.getString(1), rs.getDouble(2)));
            }
            s38.setName("SUNSURRE YELLOW 15 LTR TIN");
            data.addAll(s38);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
            }
        }
        if(ch39.isSelected()){
        try{
            conn = CONNECT.ConnecterDb();
            ResultSet rs = conn.createStatement().executeQuery("Select"+x+","+y+" from trial where "+z+" ITEM_NAME like '%SUNSURRE YELLOW 15 KG TIN%' AND VRDATE <= CAST('"+date2+"' AS DATE) AND VRDATE >= CAST('"+date1+"' AS DATE) AND ITEM_NATURE ='PG' AND DIV_CODE LIKE 'O%' "+group+"");
            while(rs.next()){
                s39.getData().add(new XYChart.Data(rs.getString(1), rs.getDouble(2)));
            }
            s39.setName("SUNSURRE YELLOW 15 KG TIN");
            data.addAll(s39);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
            }
        }
        if(ch40.isSelected()){
        try{
            conn = CONNECT.ConnecterDb();
            ResultSet rs = conn.createStatement().executeQuery("Select"+x+","+y+" from trial where "+z+" ITEM_NAME like '%Naturralle 1 Ltr - Gn (1x16)%' AND VRDATE <= CAST('"+date2+"' AS DATE) AND VRDATE >= CAST('"+date1+"' AS DATE) AND ITEM_NATURE ='PG' AND DIV_CODE LIKE 'O%' "+group+"");
            while(rs.next()){
                s40.getData().add(new XYChart.Data(rs.getString(1), rs.getDouble(2)));
            }
            s40.setName("Naturralle 1 Ltr - Gn (1x16)");
            data.addAll(s40);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
            }
        }
        if(ch41.isSelected()){
        try{
            conn = CONNECT.ConnecterDb();
            ResultSet rs = conn.createStatement().executeQuery("Select"+x+","+y+" from trial where "+z+" ITEM_NAME like '%Skd 1 Ltr - Sf (1x16) - W/O%' AND VRDATE <= CAST('"+date2+"' AS DATE) AND VRDATE >= CAST('"+date1+"' AS DATE) AND ITEM_NATURE ='PG' AND DIV_CODE LIKE 'O%' "+group+"");
            while(rs.next()){
                s41.getData().add(new XYChart.Data(rs.getString(1), rs.getDouble(2)));
            }
            s41.setName("Skd 1 Ltr - Sf (1x16) - W/O");
            data.addAll(s41);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
            }
        }
        if(ch42.isSelected()){
        try{
            conn = CONNECT.ConnecterDb();
            ResultSet rs = conn.createStatement().executeQuery("Select"+x+","+y+" from trial where "+z+" ITEM_NAME like '%NATURRALLE 1 LTR - SF (Y) (1X16)%' AND VRDATE <= CAST('"+date2+"' AS DATE) AND VRDATE >= CAST('"+date1+"' AS DATE) AND ITEM_NATURE ='PG' AND DIV_CODE LIKE 'O%' "+group+"");
            while(rs.next()){
                s42.getData().add(new XYChart.Data(rs.getString(1), rs.getDouble(2)));
            }
            s42.setName("NATURRALLE 1 LTR - SF (Y) (1X16)");
            data.addAll(s42);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
            }
        }
        if(ch43.isSelected()){
        try{
            conn = CONNECT.ConnecterDb();
            ResultSet rs = conn.createStatement().executeQuery("Select"+x+","+y+" from trial where "+z+" ITEM_NAME like '%NATURRALLE 1 LTR - SF (Y) (1X10)%' AND VRDATE <= CAST('"+date2+"' AS DATE) AND VRDATE >= CAST('"+date1+"' AS DATE) AND ITEM_NATURE ='PG' AND DIV_CODE LIKE 'O%' "+group+"");
            while(rs.next()){
                s43.getData().add(new XYChart.Data(rs.getString(1), rs.getDouble(2)));
            }
            s43.setName("NATURRALLE 1 LTR - SF (Y) (1X10)");
            data.addAll(s43);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
            }
        }
        if(ch44.isSelected()){
        try{
            conn = CONNECT.ConnecterDb();
            ResultSet rs = conn.createStatement().executeQuery("Select"+x+","+y+" from trial where "+z+" ITEM_NAME like '%NATURRALLE 1 LTR - SF (Y) (1X12)%' AND VRDATE <= CAST('"+date2+"' AS DATE) AND VRDATE >= CAST('"+date1+"' AS DATE) AND ITEM_NATURE ='PG' AND DIV_CODE LIKE 'O%' "+group+"");
            while(rs.next()){
                s44.getData().add(new XYChart.Data(rs.getString(1), rs.getDouble(2)));
            }
            s44.setName("NATURRALLE 1 LTR - SF (Y) (1X12)");
            data.addAll(s44);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
            }
        }
        if(ch45.isSelected()){
        try{
            conn = CONNECT.ConnecterDb();
            ResultSet rs = conn.createStatement().executeQuery("Select"+x+","+y+" from trial where "+z+" ITEM_NAME like '%NATURRALLE 500 ML - SF (Y) (1X20)%' AND VRDATE <= CAST('"+date2+"' AS DATE) AND VRDATE >= CAST('"+date1+"' AS DATE) AND ITEM_NATURE ='PG' AND DIV_CODE LIKE 'O%' "+group+"");
            while(rs.next()){
                s45.getData().add(new XYChart.Data(rs.getString(1), rs.getDouble(2)));
            }
            s45.setName("NATURRALLE 500 ML - SF (Y) (1X20)");
            data.addAll(s45);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
            }
        }
        if(ch46.isSelected()){
        try{
            conn = CONNECT.ConnecterDb();
            ResultSet rs = conn.createStatement().executeQuery("Select"+x+","+y+" from trial where "+z+" ITEM_NAME like '%NATURRALLE 500 ML - SF (Y) (1X32)%' AND VRDATE <= CAST('"+date2+"' AS DATE) AND VRDATE >= CAST('"+date1+"' AS DATE) AND ITEM_NATURE ='PG' AND DIV_CODE LIKE 'O%' "+group+"");
            while(rs.next()){
                s46.getData().add(new XYChart.Data(rs.getString(1), rs.getDouble(2)));
            }
            s46.setName("NATURRALLE 500 ML - SF (Y) (1X32)");
            data.addAll(s46);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
            }
        }
        if(ch47.isSelected()){
        try{
            conn = CONNECT.ConnecterDb();
            ResultSet rs = conn.createStatement().executeQuery("Select"+x+","+y+" from trial where "+z+" ITEM_NAME like '%NATURRALLE 1 LTR PET BOTTLE - SF (Y) (1X12)%' AND VRDATE <= CAST('"+date2+"' AS DATE) AND VRDATE >= CAST('"+date1+"' AS DATE) AND ITEM_NATURE ='PG' AND DIV_CODE LIKE 'O%' "+group+"");
            while(rs.next()){
                s47.getData().add(new XYChart.Data(rs.getString(1), rs.getDouble(2)));
            }
            s47.setName("NATURRALLE 1 LTR PET BOTTLE - SF (Y) (1X12)");
            data.addAll(s47);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
            }
        }
        if(ch48.isSelected()){
        try{
            conn = CONNECT.ConnecterDb();
            ResultSet rs = conn.createStatement().executeQuery("Select"+x+","+y+" from trial where "+z+" ITEM_NAME like '%NATURRALLE 1 LTR PET BOTTLE - SF (Y) (1X16)%' AND VRDATE <= CAST('"+date2+"' AS DATE) AND VRDATE >= CAST('"+date1+"' AS DATE) AND ITEM_NATURE ='PG' AND DIV_CODE LIKE 'O%' "+group+"");
            while(rs.next()){
                s48.getData().add(new XYChart.Data(rs.getString(1), rs.getDouble(2)));
            }
            s48.setName("NATURRALLE 1 LTR PET BOTTLE - SF (Y) (1X16)");
            data.addAll(s48);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
            }
        }
        if(ch49.isSelected()){
        try{
            conn = CONNECT.ConnecterDb();
            ResultSet rs = conn.createStatement().executeQuery("Select"+x+","+y+" from trial where "+z+" ITEM_NAME like '%NATURRALLE 1 LTR PET BOTTLE - SF (Y) (1X10)%' AND VRDATE <= CAST('"+date2+"' AS DATE) AND VRDATE >= CAST('"+date1+"' AS DATE) AND ITEM_NATURE ='PG' AND DIV_CODE LIKE 'O%' "+group+"");
            while(rs.next()){
                s49.getData().add(new XYChart.Data(rs.getString(1), rs.getDouble(2)));
            }
            s49.setName("NATURRALLE 1 LTR PET BOTTLE - SF (Y) (1X10)");
            data.addAll(s49);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
            }
        }
        if(ch50.isSelected()){
        try{
            conn = CONNECT.ConnecterDb();
            ResultSet rs = conn.createStatement().executeQuery("Select"+x+","+y+" from trial where "+z+" ITEM_NAME like '%NATURRALLE 1 LTR - SF (Y) (1X16) - OFFER%' AND VRDATE <= CAST('"+date2+"' AS DATE) AND VRDATE >= CAST('"+date1+"' AS DATE) AND ITEM_NATURE ='PG' AND DIV_CODE LIKE 'O%' "+group+"");
            while(rs.next()){
                s50.getData().add(new XYChart.Data(rs.getString(1), rs.getDouble(2)));
            }
            s50.setName("NATURRALLE 1 LTR - SF (Y) (1X16) - OFFER");
            data.addAll(s50);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
            }
        }
        if(ch51.isSelected()){
        try{
            conn = CONNECT.ConnecterDb();
            ResultSet rs = conn.createStatement().executeQuery("Select"+x+","+y+" from trial where "+z+" ITEM_NAME like '%NATURRALLE 100 ML SF (Y) (1X100)%' AND VRDATE <= CAST('"+date2+"' AS DATE) AND VRDATE >= CAST('"+date1+"' AS DATE) AND ITEM_NATURE ='PG' AND DIV_CODE LIKE 'O%' "+group+"");
            while(rs.next()){
                s51.getData().add(new XYChart.Data(rs.getString(1), rs.getDouble(2)));
            }
            s51.setName("NATURRALLE 100 ML SF (Y) (1X100)");
            data.addAll(s51);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
            }
        }
        if(ch52.isSelected()){
        try{
            conn = CONNECT.ConnecterDb();
            ResultSet rs = conn.createStatement().executeQuery("Select"+x+","+y+" from trial where "+z+" ITEM_NAME like '%Skd 5 Ltr Can - Sf (1x4)%' AND VRDATE <= CAST('"+date2+"' AS DATE) AND VRDATE >= CAST('"+date1+"' AS DATE) AND ITEM_NATURE ='PG' AND DIV_CODE LIKE 'O%' "+group+"");
            while(rs.next()){
                s52.getData().add(new XYChart.Data(rs.getString(1), rs.getDouble(2)));
            }
            s52.setName("Skd 5 Ltr Can - Sf (1x4)");
            data.addAll(s52);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
            }
        }
        if(ch53.isSelected()){
        try{
            conn = CONNECT.ConnecterDb();
            ResultSet rs = conn.createStatement().executeQuery("Select"+x+","+y+" from trial where "+z+" ITEM_NAME like '%Skd 5 Ltr Can - Sf (1x4) - W/O%' AND VRDATE <= CAST('"+date2+"' AS DATE) AND VRDATE >= CAST('"+date1+"' AS DATE) AND ITEM_NATURE ='PG' AND DIV_CODE LIKE 'O%' "+group+"");
            while(rs.next()){
                s53.getData().add(new XYChart.Data(rs.getString(1), rs.getDouble(2)));
            }
            s53.setName("Skd 5 Ltr Can - Sf (1x4) - W/O");
            data.addAll(s53);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
            }
        }
        if(ch54.isSelected()){
        try{
            conn = CONNECT.ConnecterDb();
            ResultSet rs = conn.createStatement().executeQuery("Select"+x+","+y+" from trial where "+z+" ITEM_NAME like '%NATURRALLE 5 LTR CAN - SF (Y) (1X4) OFFER%' AND VRDATE <= CAST('"+date2+"' AS DATE) AND VRDATE >= CAST('"+date1+"' AS DATE) AND ITEM_NATURE ='PG' AND DIV_CODE LIKE 'O%' "+group+"");
            while(rs.next()){
                s54.getData().add(new XYChart.Data(rs.getString(1), rs.getDouble(2)));
            }
            s54.setName("NATURRALLE 5 LTR CAN - SF (Y) (1X4) OFFER");
            data.addAll(s54);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
            }
        }
        if(ch55.isSelected()){
        try{
            conn = CONNECT.ConnecterDb();
            ResultSet rs = conn.createStatement().executeQuery("Select"+x+","+y+" from trial where "+z+" ITEM_NAME like '%NATURRALLE 15 LTR CAN- SF (Y)%' AND VRDATE <= CAST('"+date2+"' AS DATE) AND VRDATE >= CAST('"+date1+"' AS DATE) AND ITEM_NATURE ='PG' AND DIV_CODE LIKE 'O%' "+group+"");
            while(rs.next()){
                s55.getData().add(new XYChart.Data(rs.getString(1), rs.getDouble(2)));
            }
            s55.setName("NATURRALLE 15 LTR CAN- SF (Y)");
            data.addAll(s55);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
            }
        }
        if(ch56.isSelected()){
        try{
            conn = CONNECT.ConnecterDb();
            ResultSet rs = conn.createStatement().executeQuery("Select"+x+","+y+" from trial where "+z+" ITEM_NAME like '%NATURRALLE 5 LTR CAN - SF (Y) (1X4) W/O%' AND VRDATE <= CAST('"+date2+"' AS DATE) AND VRDATE >= CAST('"+date1+"' AS DATE) AND ITEM_NATURE ='PG' AND DIV_CODE LIKE 'O%' "+group+"");
            while(rs.next()){
                s56.getData().add(new XYChart.Data(rs.getString(1), rs.getDouble(2)));
            }
            s56.setName("NATURRALLE 5 LTR CAN - SF (Y) (1X4) W/O");
            data.addAll(s56);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
            }
        }
        if(ch57.isSelected()){
        try{
            conn = CONNECT.ConnecterDb();
            ResultSet rs = conn.createStatement().executeQuery("Select"+x+","+y+" from trial where "+z+" ITEM_NAME like '%Skd 5 Ltr Jar - Sf (1x4) - W/O%' AND VRDATE <= CAST('"+date2+"' AS DATE) AND VRDATE >= CAST('"+date1+"' AS DATE) AND ITEM_NATURE ='PG' AND DIV_CODE LIKE 'O%' "+group+"");
            while(rs.next()){
                s57.getData().add(new XYChart.Data(rs.getString(1), rs.getDouble(2)));
            }
            s57.setName("Skd 5 Ltr Jar - Sf (1x4) - W/O");
            data.addAll(s57);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
            }
        }
        if(ch58.isSelected()){
        try{
            conn = CONNECT.ConnecterDb();
            ResultSet rs = conn.createStatement().executeQuery("Select"+x+","+y+" from trial where "+z+" ITEM_NAME like '%NATURRALLE 5 LTR JAR - (P) (1X4) - W/O%' AND VRDATE <= CAST('"+date2+"' AS DATE) AND VRDATE >= CAST('"+date1+"' AS DATE) AND ITEM_NATURE ='PG' AND DIV_CODE LIKE 'O%' "+group+"");
            while(rs.next()){
                s58.getData().add(new XYChart.Data(rs.getString(1), rs.getDouble(2)));
            }
            s58.setName("NATURRALLE 5 LTR JAR - (P) (1X4) - W/O");
            data.addAll(s58);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
            }
        }
        if(ch59.isSelected()){
        try{
            conn = CONNECT.ConnecterDb();
            ResultSet rs = conn.createStatement().executeQuery("Select"+x+","+y+" from trial where "+z+" ITEM_NAME like '%NATURRALLE 5 LTR JAR - SF (Y) (1X4) OFFER%' AND VRDATE <= CAST('"+date2+"' AS DATE) AND VRDATE >= CAST('"+date1+"' AS DATE) AND ITEM_NATURE ='PG' AND DIV_CODE LIKE 'O%' "+group+"");
            while(rs.next()){
                s59.getData().add(new XYChart.Data(rs.getString(1), rs.getDouble(2)));
            }
            s59.setName("NATURRALLE 5 LTR JAR - SF (Y) (1X4) OFFER");
            data.addAll(s59);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
            }
        }
        if(ch60.isSelected()){
        try{
            conn = CONNECT.ConnecterDb();
            ResultSet rs = conn.createStatement().executeQuery("Select"+x+","+y+" from trial where "+z+" ITEM_NAME like '%SKD 2 LTR JAR - SF (1X9) W/O%' AND VRDATE <= CAST('"+date2+"' AS DATE) AND VRDATE >= CAST('"+date1+"' AS DATE) AND ITEM_NATURE ='PG' AND DIV_CODE LIKE 'O%' "+group+"");
            while(rs.next()){
                s60.getData().add(new XYChart.Data(rs.getString(1), rs.getDouble(2)));
            }
            s60.setName("SKD 2 LTR JAR - SF (1X9) W/O");
            data.addAll(s60);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
            }
        }
        if(ch61.isSelected()){
        try{
            conn = CONNECT.ConnecterDb();
            ResultSet rs = conn.createStatement().executeQuery("Select"+x+","+y+" from trial where "+z+" ITEM_NAME like '%SKD 3 LTR JAR - SF (1X6) W/O%' AND VRDATE <= CAST('"+date2+"' AS DATE) AND VRDATE >= CAST('"+date1+"' AS DATE) AND ITEM_NATURE ='PG' AND DIV_CODE LIKE 'O%' "+group+"");
            while(rs.next()){
                s61.getData().add(new XYChart.Data(rs.getString(1), rs.getDouble(2)));
            }
            s61.setName("SKD 3 LTR JAR - SF (1X6) W/O");
            data.addAll(s61);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
            }
        }
        if(ch62.isSelected()){
        try{
            conn = CONNECT.ConnecterDb();
            ResultSet rs = conn.createStatement().executeQuery("Select"+x+","+y+" from trial where "+z+" ITEM_NAME like '%NATURRALLE 5 LTR JAR - SF (Y) (1X4) W/O%' AND VRDATE <= CAST('"+date2+"' AS DATE) AND VRDATE >= CAST('"+date1+"' AS DATE) AND ITEM_NATURE ='PG' AND DIV_CODE LIKE 'O%' "+group+"");
            while(rs.next()){
                s62.getData().add(new XYChart.Data(rs.getString(1), rs.getDouble(2)));
            }
            s62.setName("NATURRALLE 5 LTR JAR - SF (Y) (1X4) W/O");
            data.addAll(s62);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
            }
        }
        if(ch63.isSelected()){
        try{
            conn = CONNECT.ConnecterDb();
            ResultSet rs = conn.createStatement().executeQuery("Select"+x+","+y+" from trial where "+z+" ITEM_NAME like '%NATURRALLE 15 LTR JAR - SF (YELLOW CAP)%' AND VRDATE <= CAST('"+date2+"' AS DATE) AND VRDATE >= CAST('"+date1+"' AS DATE) AND ITEM_NATURE ='PG' AND DIV_CODE LIKE 'O%' "+group+"");
            while(rs.next()){
                s63.getData().add(new XYChart.Data(rs.getString(1), rs.getDouble(2)));
            }
            s63.setName("NATURRALLE 15 LTR JAR - SF (YELLOW CAP)");
            data.addAll(s63);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
            }
        }
        if(ch64.isSelected()){
        try{
            conn = CONNECT.ConnecterDb();
            ResultSet rs = conn.createStatement().executeQuery("Select"+x+","+y+" from trial where "+z+" ITEM_NAME like '%NATURRALLE SFR 15 KG ROUND BARNI - PINK%' AND VRDATE <= CAST('"+date2+"' AS DATE) AND VRDATE >= CAST('"+date1+"' AS DATE) AND ITEM_NATURE ='PG' AND DIV_CODE LIKE 'O%' "+group+"");
            while(rs.next()){
                s64.getData().add(new XYChart.Data(rs.getString(1), rs.getDouble(2)));
            }
            s64.setName("NATURRALLE SFR 15 KG ROUND BARNI - PINK");
            data.addAll(s64);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
            }
        }
        if(ch65.isSelected()){
        try{
            conn = CONNECT.ConnecterDb();
            ResultSet rs = conn.createStatement().executeQuery("Select"+x+","+y+" from trial where "+z+" ITEM_NAME like '%Skd 15 Ltr Tin - Sf%' AND VRDATE <= CAST('"+date2+"' AS DATE) AND VRDATE >= CAST('"+date1+"' AS DATE) AND ITEM_NATURE ='PG' AND DIV_CODE LIKE 'O%' "+group+"");
            while(rs.next()){
                s65.getData().add(new XYChart.Data(rs.getString(1), rs.getDouble(2)));
            }
            s65.setName("Skd 15 Ltr Tin - Sf");
            data.addAll(s65);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
            }
        }
        if(ch66.isSelected()){
        try{
            conn = CONNECT.ConnecterDb();
            ResultSet rs = conn.createStatement().executeQuery("Select"+x+","+y+" from trial where "+z+" ITEM_NAME like '%Skd 15 Kg Tin - Sf%' AND VRDATE <= CAST('"+date2+"' AS DATE) AND VRDATE >= CAST('"+date1+"' AS DATE) AND ITEM_NATURE ='PG' AND DIV_CODE LIKE 'O%' "+group+"");
            while(rs.next()){
                s66.getData().add(new XYChart.Data(rs.getString(1), rs.getDouble(2)));
            }
            s66.setName("Skd 15 Kg Tin - Sf");
            data.addAll(s66);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
            }
        }
        if(ch67.isSelected()){
        try{
            conn = CONNECT.ConnecterDb();
            ResultSet rs = conn.createStatement().executeQuery("Select"+x+","+y+" from trial where "+z+" ITEM_NAME like '%NATURRALLE 15 LTR TIN - SF (Y) BR BORDER%' AND VRDATE <= CAST('"+date2+"' AS DATE) AND VRDATE >= CAST('"+date1+"' AS DATE) AND ITEM_NATURE ='PG' AND DIV_CODE LIKE 'O%' "+group+"");
            while(rs.next()){
                s67.getData().add(new XYChart.Data(rs.getString(1), rs.getDouble(2)));
            }
            s67.setName("NATURRALLE 15 LTR TIN - SF (Y) BR BORDER");
            data.addAll(s67);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
            }
        }
        if(ch68.isSelected()){
        try{
            conn = CONNECT.ConnecterDb();
            ResultSet rs = conn.createStatement().executeQuery("Select"+x+","+y+" from trial where "+z+" ITEM_NAME like '%NATURRALLE 15 KG TIN - SF (Y) PK BORDER%' AND VRDATE <= CAST('"+date2+"' AS DATE) AND VRDATE >= CAST('"+date1+"' AS DATE) AND ITEM_NATURE ='PG' AND DIV_CODE LIKE 'O%' "+group+"");
            while(rs.next()){
                s68.getData().add(new XYChart.Data(rs.getString(1), rs.getDouble(2)));
            }
            s68.setName("NATURRALLE 15 KG TIN - SF (Y) PK BORDER");
            data.addAll(s68);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
            }
        }
        if(ch69.isSelected()){
        try{
            conn = CONNECT.ConnecterDb();
            ResultSet rs = conn.createStatement().executeQuery("Select"+x+","+y+" from trial where "+z+" ITEM_NAME like '%Krishna Brrand-R (Tp) 1 Kg (1x10)%' AND VRDATE <= CAST('"+date2+"' AS DATE) AND VRDATE >= CAST('"+date1+"' AS DATE) AND ITEM_NATURE ='PG' AND DIV_CODE LIKE 'O%' "+group+"");
            while(rs.next()){
                s69.getData().add(new XYChart.Data(rs.getString(1), rs.getDouble(2)));
            }
            s69.setName("Krishna Brrand-R (Tp) 1 Kg (1x10)");
            data.addAll(s69);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
            }
        }
        if(ch70.isSelected()){
        try{
            conn = CONNECT.ConnecterDb();
            ResultSet rs = conn.createStatement().executeQuery("Select"+x+","+y+" from trial where "+z+" ITEM_NAME like '%SUNSURRE 1 LTR (1X16)%' AND VRDATE <= CAST('"+date2+"' AS DATE) AND VRDATE >= CAST('"+date1+"' AS DATE) AND ITEM_NATURE ='PG' AND DIV_CODE LIKE 'O%' "+group+"");
            while(rs.next()){
                s70.getData().add(new XYChart.Data(rs.getString(1), rs.getDouble(2)));
            }
            s70.setName("SUNSURRE 1 LTR (1X16)");
            data.addAll(s70);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
            }
        }
        if(ch71.isSelected()){
        try{
            conn = CONNECT.ConnecterDb();
            ResultSet rs = conn.createStatement().executeQuery("Select"+x+","+y+" from trial where "+z+" ITEM_NAME = 'Sre Krishna Gold 5 Ltr Can (1x4) W/O' AND VRDATE <= CAST('"+date2+"' AS DATE) AND VRDATE >= CAST('"+date1+"' AS DATE) AND ITEM_NATURE ='PG' AND DIV_CODE LIKE 'O%' "+group+"");
            while(rs.next()){
                s71.getData().add(new XYChart.Data(rs.getString(1), rs.getDouble(2)));
            }
            s71.setName("Sre Krishna Gold 5 Ltr Can (1x4) W/O");
            data.addAll(s71);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
            }
        }
        if(ch72.isSelected()){
        try{
            conn = CONNECT.ConnecterDb();
            ResultSet rs = conn.createStatement().executeQuery("Select"+x+","+y+" from trial where "+z+" ITEM_NAME = 'Krishna Brrand-R 15 Ltr Can - Bl' AND VRDATE <= CAST('"+date2+"' AS DATE) AND VRDATE >= CAST('"+date1+"' AS DATE) AND ITEM_NATURE ='PG' AND DIV_CODE LIKE 'O%' "+group+"");
            while(rs.next()){
                s72.getData().add(new XYChart.Data(rs.getString(1), rs.getDouble(2)));
            }
            s72.setName("Krishna Brrand-R 15 Ltr Can - Bl");
            data.addAll(s72);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
            }
        }
        if(ch73.isSelected()){
        try{
            conn = CONNECT.ConnecterDb();
            ResultSet rs = conn.createStatement().executeQuery("Select"+x+","+y+" from trial where "+z+" ITEM_NAME = 'SUNSURRE 5 LTR CAN  (1X4) W/O' AND VRDATE <= CAST('"+date2+"' AS DATE) AND VRDATE >= CAST('"+date1+"' AS DATE) AND ITEM_NATURE ='PG' AND DIV_CODE LIKE 'O%' "+group+"");
            while(rs.next()){
                s73.getData().add(new XYChart.Data(rs.getString(1), rs.getDouble(2)));
            }
            s73.setName("SUNSURRE 5 LTR CAN  (1X4) W/O");
            data.addAll(s73);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
            }
        }
        if(ch74.isSelected()){
        try{
            conn = CONNECT.ConnecterDb();
            ResultSet rs = conn.createStatement().executeQuery("Select"+x+","+y+" from trial where "+z+" ITEM_NAME = 'Sre Krishna Gold 2 Ltr Jar  (1x9) W/O' AND VRDATE <= CAST('"+date2+"' AS DATE) AND VRDATE >= CAST('"+date1+"' AS DATE) AND ITEM_NATURE ='PG' AND DIV_CODE LIKE 'O%' "+group+"");
            while(rs.next()){
                s74.getData().add(new XYChart.Data(rs.getString(1), rs.getDouble(2)));
            }
            s74.setName("Sre Krishna Gold 2 Ltr Jar  (1x9) W/O");
            data.addAll(s74);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
            }
        }
        if(ch75.isSelected()){
        try{
            conn = CONNECT.ConnecterDb();
            ResultSet rs = conn.createStatement().executeQuery("Select"+x+","+y+" from trial where "+z+" ITEM_NAME = 'Sri Krishna Gold 5 Ltr Jar  (1x4) W/O' AND VRDATE <= CAST('"+date2+"' AS DATE) AND VRDATE >= CAST('"+date1+"' AS DATE) AND ITEM_NATURE ='PG' AND DIV_CODE LIKE 'O%' "+group+"");
            while(rs.next()){
                s75.getData().add(new XYChart.Data(rs.getString(1), rs.getDouble(2)));
            }
            s75.setName("Sri Krishna Gold 5 Ltr Jar  (1x4) W/O");
            data.addAll(s75);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
            }
        }
        if(ch76.isSelected()){
        try{
            conn = CONNECT.ConnecterDb();
            ResultSet rs = conn.createStatement().executeQuery("Select"+x+","+y+" from trial where "+z+" ITEM_NAME = 'Sri Krishna Gold 3 Ltr Jar  (1x6) W/O' AND VRDATE <= CAST('"+date2+"' AS DATE) AND VRDATE >= CAST('"+date1+"' AS DATE) AND ITEM_NATURE ='PG' AND DIV_CODE LIKE 'O%' "+group+"");
            while(rs.next()){
                s76.getData().add(new XYChart.Data(rs.getString(1), rs.getDouble(2)));
            }
            s76.setName("Sri Krishna Gold 3 Ltr Jar  (1x6) W/O");
            data.addAll(s76);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
            }
        }
        if(ch77.isSelected()){
        try{
            conn = CONNECT.ConnecterDb();
            ResultSet rs = conn.createStatement().executeQuery("Select"+x+","+y+" from trial where "+z+" ITEM_NAME = 'SUNSURRE 5 LTR JAR  (1X4) W/O' AND VRDATE <= CAST('"+date2+"' AS DATE) AND VRDATE >= CAST('"+date1+"' AS DATE) AND ITEM_NATURE ='PG' AND DIV_CODE LIKE 'O%' "+group+"");
            while(rs.next()){
                s77.getData().add(new XYChart.Data(rs.getString(1), rs.getDouble(2)));
            }
            s77.setName("SUNSURRE 5 LTR JAR  (1X4) W/O");
            data.addAll(s77);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
            }
        }
        if(ch78.isSelected()){
        try{
            conn = CONNECT.ConnecterDb();
            ResultSet rs = conn.createStatement().executeQuery("Select"+x+","+y+" from trial where "+z+" ITEM_NAME = 'SUNSURRE 5 LTR PET JAR BUCKET OFFER 1*4' AND VRDATE <= CAST('"+date2+"' AS DATE) AND VRDATE >= CAST('"+date1+"' AS DATE) AND ITEM_NATURE ='PG' AND DIV_CODE LIKE 'O%' "+group+"");
            while(rs.next()){
                s78.getData().add(new XYChart.Data(rs.getString(1), rs.getDouble(2)));
            }
            s78.setName("SUNSURRE 5 LTR PET JAR BUCKET OFFER 1*4");
            data.addAll(s78);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
            }
        }
        if(ch79.isSelected()){
        try{
            conn = CONNECT.ConnecterDb();
            ResultSet rs = conn.createStatement().executeQuery("Select"+x+","+y+" from trial where "+z+" ITEM_NAME = 'SUNSURRE YELLOW 5 LTR PET - BL W/O' AND VRDATE <= CAST('"+date2+"' AS DATE) AND VRDATE >= CAST('"+date1+"' AS DATE) AND ITEM_NATURE ='PG' AND DIV_CODE LIKE 'O%' "+group+"");
            while(rs.next()){
                s79.getData().add(new XYChart.Data(rs.getString(1), rs.getDouble(2)));
            }
            s79.setName("SUNSURRE YELLOW 5 LTR PET - BL W/O");
            data.addAll(s79);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
            }
        }
        if(ch80.isSelected()){
        try{
            conn = CONNECT.ConnecterDb();
            ResultSet rs = conn.createStatement().executeQuery("Select"+x+","+y+" from trial where "+z+" ITEM_NAME = 'SUNSURRE 15 LTR TIN' AND VRDATE <= CAST('"+date2+"' AS DATE) AND VRDATE >= CAST('"+date1+"' AS DATE) AND ITEM_NATURE ='PG' AND DIV_CODE LIKE 'O%' "+group+"");
            while(rs.next()){
                s80.getData().add(new XYChart.Data(rs.getString(1), rs.getDouble(2)));
            }
            s80.setName("SUNSURRE 15 LTR TIN");
            data.addAll(s80);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
            }
        }
        if(ch81.isSelected()){
        try{
            conn = CONNECT.ConnecterDb();
            ResultSet rs = conn.createStatement().executeQuery("Select"+x+","+y+" from trial where "+z+" ITEM_NAME = 'SUNSURRE 15 KG TIN' AND VRDATE <= CAST('"+date2+"' AS DATE) AND VRDATE >= CAST('"+date1+"' AS DATE) AND ITEM_NATURE ='PG' AND DIV_CODE LIKE 'O%' "+group+"");
            while(rs.next()){
                s81.getData().add(new XYChart.Data(rs.getString(1), rs.getDouble(2)));
            }
            s81.setName("SUNSURRE 15 KG TIN");
            data.addAll(s81);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
            }
        }
        if(ch82.isSelected()){
        try{
            conn = CONNECT.ConnecterDb();
            ResultSet rs = conn.createStatement().executeQuery("Select"+x+","+y+" from trial where "+z+" ITEM_NAME = 'NATURALLE HEALTH 1LTR RB (1X12)' AND VRDATE <= CAST('"+date2+"' AS DATE) AND VRDATE >= CAST('"+date1+"' AS DATE) AND ITEM_NATURE ='PG' AND DIV_CODE LIKE 'O%' "+group+"");
            while(rs.next()){
                s82.getData().add(new XYChart.Data(rs.getString(1), rs.getDouble(2)));
            }
            s82.setName("NATURALLE HEALTH 1LTR RB (1X12)");
            data.addAll(s82);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
            }
        }
        if(ch83.isSelected()){
        try{
            conn = CONNECT.ConnecterDb();
            ResultSet rs = conn.createStatement().executeQuery("Select"+x+","+y+" from trial where "+z+" ITEM_NAME = 'NATURALLE HEALTH 200ML RB (1X50)' AND VRDATE <= CAST('"+date2+"' AS DATE) AND VRDATE >= CAST('"+date1+"' AS DATE) AND ITEM_NATURE ='PG' AND DIV_CODE LIKE 'O%' "+group+"");
            while(rs.next()){
                s83.getData().add(new XYChart.Data(rs.getString(1), rs.getDouble(2)));
            }
            s83.setName("NATURALLE HEALTH 200ML RB (1X50)");
            data.addAll(s83);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
            }
        }
        if(ch84.isSelected()){
        try{
            conn = CONNECT.ConnecterDb();
            ResultSet rs = conn.createStatement().executeQuery("Select"+x+","+y+" from trial where "+z+" ITEM_NAME = 'NATURALLE HEALTH 5LTR CAN RB (1X4) OFFER' AND VRDATE <= CAST('"+date2+"' AS DATE) AND VRDATE >= CAST('"+date1+"' AS DATE) AND ITEM_NATURE ='PG' AND DIV_CODE LIKE 'O%' "+group+"");
            while(rs.next()){
                s84.getData().add(new XYChart.Data(rs.getString(1), rs.getDouble(2)));
            }
            s84.setName("NATURALLE HEALTH 5LTR CAN RB (1X4) OFFER");
            data.addAll(s84);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
            }
        }
        if(ch85.isSelected()){
        try{
            conn = CONNECT.ConnecterDb();
            ResultSet rs = conn.createStatement().executeQuery("Select"+x+","+y+" from trial where "+z+" ITEM_NAME = 'NATURALLE HEALTH 5LTR CAN RB (1X4) W/O' AND VRDATE <= CAST('"+date2+"' AS DATE) AND VRDATE >= CAST('"+date1+"' AS DATE) AND ITEM_NATURE ='PG' AND DIV_CODE LIKE 'O%' "+group+"");
            while(rs.next()){
                s85.getData().add(new XYChart.Data(rs.getString(1), rs.getDouble(2)));
            }
            s85.setName("NATURALLE HEALTH 5LTR CAN RB (1X4) W/O");
            data.addAll(s85);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
            }
        }
        if(ch86.isSelected()){
        try{
            conn = CONNECT.ConnecterDb();
            ResultSet rs = conn.createStatement().executeQuery("Select"+x+","+y+" from trial where "+z+" ITEM_NAME = 'NATURRALLE HEALTH 15 LTR CAN- RB' AND VRDATE <= CAST('"+date2+"' AS DATE) AND VRDATE >= CAST('"+date1+"' AS DATE) AND ITEM_NATURE ='PG' AND DIV_CODE LIKE 'O%' "+group+"");
            while(rs.next()){
                s86.getData().add(new XYChart.Data(rs.getString(1), rs.getDouble(2)));
            }
            s86.setName("NATURRALLE HEALTH 15 LTR CAN- RB");
            data.addAll(s86);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
            }
        }
        if(ch87.isSelected()){
        try{
            conn = CONNECT.ConnecterDb();
            ResultSet rs = conn.createStatement().executeQuery("Select"+x+","+y+" from trial where "+z+" ITEM_NAME = 'NATURALLE HEALTH 2LTR CAN RB (1X10) W/O' AND VRDATE <= CAST('"+date2+"' AS DATE) AND VRDATE >= CAST('"+date1+"' AS DATE) AND ITEM_NATURE ='PG' AND DIV_CODE LIKE 'O%' "+group+"");
            while(rs.next()){
                s87.getData().add(new XYChart.Data(rs.getString(1), rs.getDouble(2)));
            }
            s87.setName("NATURALLE HEALTH 2LTR CAN RB (1X10) W/O");
            data.addAll(s87);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
            }
        }
        if(ch88.isSelected()){
        try{
            conn = CONNECT.ConnecterDb();
            ResultSet rs = conn.createStatement().executeQuery("Select"+x+","+y+" from trial where "+z+" ITEM_NAME = 'NATURRALLE KGMO 1 LTR PET BOTTLE (1X16)' AND VRDATE <= CAST('"+date2+"' AS DATE) AND VRDATE >= CAST('"+date1+"' AS DATE) AND ITEM_NATURE ='PG' AND DIV_CODE LIKE 'O%' "+group+"");
            while(rs.next()){
                s88.getData().add(new XYChart.Data(rs.getString(1), rs.getDouble(2)));
            }
            s88.setName("NATURRALLE KGMO 1 LTR PET BOTTLE (1X16)");
            data.addAll(s88);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
            }
        }
        if(ch89.isSelected()){
        try{
            conn = CONNECT.ConnecterDb();
            ResultSet rs = conn.createStatement().executeQuery("Select"+x+","+y+" from trial where "+z+" ITEM_NAME = 'NATURRALLE KGMO 500ML PET BOTTLE (1X32)' AND VRDATE <= CAST('"+date2+"' AS DATE) AND VRDATE >= CAST('"+date1+"' AS DATE) AND ITEM_NATURE ='PG' AND DIV_CODE LIKE 'O%' "+group+"");
            while(rs.next()){
                s89.getData().add(new XYChart.Data(rs.getString(1), rs.getDouble(2)));
            }
            s89.setName("NATURRALLE KGMO 500ML PET BOTTLE (1X32)");
            data.addAll(s89);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
            }
        }
        if(ch90.isSelected()){
        try{
            conn = CONNECT.ConnecterDb();
            ResultSet rs = conn.createStatement().executeQuery("Select"+x+","+y+" from trial where "+z+" ITEM_NAME = 'Super Star (O) 15 Kg - Vp' AND VRDATE <= CAST('"+date2+"' AS DATE) AND VRDATE >= CAST('"+date1+"' AS DATE) AND ITEM_NATURE ='PG' AND DIV_CODE LIKE 'O%' "+group+"");
            while(rs.next()){
                s90.getData().add(new XYChart.Data(rs.getString(1), rs.getDouble(2)));
            }
            s90.setName("Super Star (O) 15 Kg - Vp");
            data.addAll(s90);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
            }
        }
        if(ch91.isSelected()){
        try{
            conn = CONNECT.ConnecterDb();
            ResultSet rs = conn.createStatement().executeQuery("Select"+x+","+y+" from trial where "+z+" ITEM_NAME = 'SUPER PUFF (P) 15 KG - VP - M' AND VRDATE <= CAST('"+date2+"' AS DATE) AND VRDATE >= CAST('"+date1+"' AS DATE) AND ITEM_NATURE ='PG' AND DIV_CODE LIKE 'O%' "+group+"");
            while(rs.next()){
                s91.getData().add(new XYChart.Data(rs.getString(1), rs.getDouble(2)));
            }
            s91.setName("SUPER PUFF (P) 15 KG - VP - M");
            data.addAll(s91);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
            }
        }
        if(ch92.isSelected()){
        try{
            conn = CONNECT.ConnecterDb();
            ResultSet rs = conn.createStatement().executeQuery("Select"+x+","+y+" from trial where "+z+" ITEM_NAME = 'Super Puff (B) 15 Kg - Vp' AND VRDATE <= CAST('"+date2+"' AS DATE) AND VRDATE >= CAST('"+date1+"' AS DATE) AND ITEM_NATURE ='PG' AND DIV_CODE LIKE 'O%' "+group+"");
            while(rs.next()){
                s92.getData().add(new XYChart.Data(rs.getString(1), rs.getDouble(2)));
            }
            s92.setName("Super Puff (B) 15 Kg - Vp");
            data.addAll(s92);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
            }
        }
        if(ch93.isSelected()){
        try{
            conn = CONNECT.ConnecterDb();
            ResultSet rs = conn.createStatement().executeQuery("Select"+x+","+y+" from trial where "+z+" ITEM_NAME = 'Super Bake (V) 15 Kg - Vp' AND VRDATE <= CAST('"+date2+"' AS DATE) AND VRDATE >= CAST('"+date1+"' AS DATE) AND ITEM_NATURE ='PG' AND DIV_CODE LIKE 'O%' "+group+"");
            while(rs.next()){
                s93.getData().add(new XYChart.Data(rs.getString(1), rs.getDouble(2)));
            }
            s93.setName("Super Bake (V) 15 Kg - Vp");
            data.addAll(s93);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
            }
        }
        if(ch94.isSelected()){
        try{
            conn = CONNECT.ConnecterDb();
            ResultSet rs = conn.createStatement().executeQuery("Select"+x+","+y+" from trial where "+z+" ITEM_NAME = 'SUPER LYTE (Y) 15 KG - VP' AND VRDATE <= CAST('"+date2+"' AS DATE) AND VRDATE >= CAST('"+date1+"' AS DATE) AND ITEM_NATURE ='PG' AND DIV_CODE LIKE 'O%' "+group+"");
            while(rs.next()){
                s94.getData().add(new XYChart.Data(rs.getString(1), rs.getDouble(2)));
            }
            s94.setName("SUPER LYTE (Y) 15 KG - VP");
            data.addAll(s94);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
            }
        }
        if(ch95.isSelected()){
        try{
            conn = CONNECT.ConnecterDb();
            ResultSet rs = conn.createStatement().executeQuery("Select"+x+","+y+" from trial where "+z+" ITEM_NAME = 'SUPER PUFF (P) 15 KG - VP - H' AND VRDATE <= CAST('"+date2+"' AS DATE) AND VRDATE >= CAST('"+date1+"' AS DATE) AND ITEM_NATURE ='PG' AND DIV_CODE LIKE 'O%' "+group+"");
            while(rs.next()){
                s95.getData().add(new XYChart.Data(rs.getString(1), rs.getDouble(2)));
            }
            s95.setName("SUPER PUFF (P) 15 KG - VP - H");
            data.addAll(s95);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
            }
        }
        if(ch96.isSelected()){
        try{
            conn = CONNECT.ConnecterDb();
            ResultSet rs = conn.createStatement().executeQuery("Select"+x+","+y+" from trial where "+z+" ITEM_NAME = 'Marvell Cukie 15 Kg - Vp' AND VRDATE <= CAST('"+date2+"' AS DATE) AND VRDATE >= CAST('"+date1+"' AS DATE) AND ITEM_NATURE ='PG' AND DIV_CODE LIKE 'O%' "+group+"");
            while(rs.next()){
                s96.getData().add(new XYChart.Data(rs.getString(1), rs.getDouble(2)));
            }
            s96.setName("Marvell Cukie 15 Kg - Vp");
            data.addAll(s96);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
            }
        }
        if(ch97.isSelected()){
        try{
            conn = CONNECT.ConnecterDb();
            ResultSet rs = conn.createStatement().executeQuery("Select"+x+","+y+" from trial where "+z+" ITEM_NAME = 'Marvell Puffe 15 Kg - Vp' AND VRDATE <= CAST('"+date2+"' AS DATE) AND VRDATE >= CAST('"+date1+"' AS DATE) AND ITEM_NATURE ='PG' AND DIV_CODE LIKE 'O%' "+group+"");
            while(rs.next()){
                s97.getData().add(new XYChart.Data(rs.getString(1), rs.getDouble(2)));
            }
            s97.setName("Marvell Puffe 15 Kg - Vp");
            data.addAll(s97);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
            }
        }
        if(ch98.isSelected()){
        try{
            conn = CONNECT.ConnecterDb();
            ResultSet rs = conn.createStatement().executeQuery("Select"+x+","+y+" from trial where "+z+" ITEM_NAME = 'SUPER BAKER 15 KG - VP' AND VRDATE <= CAST('"+date2+"' AS DATE) AND VRDATE >= CAST('"+date1+"' AS DATE) AND ITEM_NATURE ='PG' AND DIV_CODE LIKE 'O%' "+group+"");
            while(rs.next()){
                s98.getData().add(new XYChart.Data(rs.getString(1), rs.getDouble(2)));
            }
            s98.setName("SUPER BAKER 15 KG - VP");
            data.addAll(s98);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
            }
        }
        if(ch99.isSelected()){
        try{
            conn = CONNECT.ConnecterDb();
            ResultSet rs = conn.createStatement().executeQuery("Select"+x+","+y+" from trial where "+z+" ITEM_NAME = 'MARVELL EXCEL 15KG -VP' AND VRDATE <= CAST('"+date2+"' AS DATE) AND VRDATE >= CAST('"+date1+"' AS DATE) AND ITEM_NATURE ='PG' AND DIV_CODE LIKE 'O%' "+group+"");
            while(rs.next()){
                s99.getData().add(new XYChart.Data(rs.getString(1), rs.getDouble(2)));
            }
            s99.setName("MARVELL EXCEL 15KG -VP");
            data.addAll(s99);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
            }
        }
        if(ch100.isSelected()){
        try{
            conn = CONNECT.ConnecterDb();
            ResultSet rs = conn.createStatement().executeQuery("Select"+x+","+y+" from trial where "+z+" ITEM_NAME = 'MARVELL EXCEL 15 LTR - VP' AND VRDATE <= CAST('"+date2+"' AS DATE) AND VRDATE >= CAST('"+date1+"' AS DATE) AND ITEM_NATURE ='PG' AND DIV_CODE LIKE 'O%' "+group+"");
            while(rs.next()){
                s100.getData().add(new XYChart.Data(rs.getString(1), rs.getDouble(2)));
            }
            s100.setName("MARVELL EXCEL 15 LTR - VP");
            data.addAll(s100);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
            }
        }
        if(ch101.isSelected()){
        try{
            conn = CONNECT.ConnecterDb();
            ResultSet rs = conn.createStatement().executeQuery("Select"+x+","+y+" from trial where "+z+" ITEM_NAME = 'Naturralle 50 Ml - Vp (1x320)' AND VRDATE <= CAST('"+date2+"' AS DATE) AND VRDATE >= CAST('"+date1+"' AS DATE) AND ITEM_NATURE ='PG' AND DIV_CODE LIKE 'O%' "+group+"");
            while(rs.next()){
                s101.getData().add(new XYChart.Data(rs.getString(1), rs.getDouble(2)));
            }
            s101.setName("Naturralle 50 Ml - Vp (1x320)");
            data.addAll(s101);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
            }
        }
        if(ch102.isSelected()){
        try{
            conn = CONNECT.ConnecterDb();
            ResultSet rs = conn.createStatement().executeQuery("Select"+x+","+y+" from trial where "+z+" ITEM_NAME = 'Naturralle 100 Ml - Vp (1x160)' AND VRDATE <= CAST('"+date2+"' AS DATE) AND VRDATE >= CAST('"+date1+"' AS DATE) AND ITEM_NATURE ='PG' AND DIV_CODE LIKE 'O%' "+group+"");
            while(rs.next()){
                s102.getData().add(new XYChart.Data(rs.getString(1), rs.getDouble(2)));
            }
            s102.setName("Naturralle 100 Ml - Vp (1x160)");
            data.addAll(s102);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
            }
        }
        if(ch103.isSelected()){
        try{
            conn = CONNECT.ConnecterDb();
            ResultSet rs = conn.createStatement().executeQuery("Select"+x+","+y+" from trial where "+z+" ITEM_NAME = 'Naturralle 100 Ml - Vp (1x100)' AND VRDATE <= CAST('"+date2+"' AS DATE) AND VRDATE >= CAST('"+date1+"' AS DATE) AND ITEM_NATURE ='PG' AND DIV_CODE LIKE 'O%' "+group+"");
            while(rs.next()){
                s103.getData().add(new XYChart.Data(rs.getString(1), rs.getDouble(2)));
            }
            s103.setName("Naturralle 100 Ml - Vp (1x100)");
            data.addAll(s103);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
            }
        }
        if(ch104.isSelected()){
        try{
            conn = CONNECT.ConnecterDb();
            ResultSet rs = conn.createStatement().executeQuery("Select"+x+","+y+" from trial where "+z+" ITEM_NAME = 'Naturralle 200 Ml - Vp (1x80)' AND VRDATE <= CAST('"+date2+"' AS DATE) AND VRDATE >= CAST('"+date1+"' AS DATE) AND ITEM_NATURE ='PG' AND DIV_CODE LIKE 'O%' "+group+"");
            while(rs.next()){
                s104.getData().add(new XYChart.Data(rs.getString(1), rs.getDouble(2)));
            }
            s104.setName("Naturralle 200 Ml - Vp (1x80)");
            data.addAll(s104);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
            }
        }
        if(ch105.isSelected()){
        try{
            conn = CONNECT.ConnecterDb();
            ResultSet rs = conn.createStatement().executeQuery("Select"+x+","+y+" from trial where "+z+" ITEM_NAME = 'Ruchirraa 500 Ml - Vp (1x20)' AND VRDATE <= CAST('"+date2+"' AS DATE) AND VRDATE >= CAST('"+date1+"' AS DATE) AND ITEM_NATURE ='PG' AND DIV_CODE LIKE 'O%' "+group+"");
            while(rs.next()){
                s105.getData().add(new XYChart.Data(rs.getString(1), rs.getDouble(2)));
            }
            s105.setName("Ruchirraa 500 Ml - Vp (1x20)");
            data.addAll(s105);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
            }
        }
        if(ch106.isSelected()){
        try{
            conn = CONNECT.ConnecterDb();
            ResultSet rs = conn.createStatement().executeQuery("Select"+x+","+y+" from trial where "+z+" ITEM_NAME = 'Naturralle 500 Ml - Vp (1x20)' AND VRDATE <= CAST('"+date2+"' AS DATE) AND VRDATE >= CAST('"+date1+"' AS DATE) AND ITEM_NATURE ='PG' AND DIV_CODE LIKE 'O%' "+group+"");
            while(rs.next()){
                s106.getData().add(new XYChart.Data(rs.getString(1), rs.getDouble(2)));
            }
            s106.setName("Naturralle 500 Ml - Vp (1x20)");
            data.addAll(s106);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
            }
        }
        if(ch107.isSelected()){
        try{
            conn = CONNECT.ConnecterDb();
            ResultSet rs = conn.createStatement().executeQuery("Select"+x+","+y+" from trial where "+z+" ITEM_NAME = 'Naturralle 500 Ml - Vp (1x32)' AND VRDATE <= CAST('"+date2+"' AS DATE) AND VRDATE >= CAST('"+date1+"' AS DATE) AND ITEM_NATURE ='PG' AND DIV_CODE LIKE 'O%' "+group+"");
            while(rs.next()){
                s107.getData().add(new XYChart.Data(rs.getString(1), rs.getDouble(2)));
            }
            s107.setName("Naturralle 500 Ml - Vp (1x32)");
            data.addAll(s107);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
            }
        }
        if(ch108.isSelected()){
        try{
            conn = CONNECT.ConnecterDb();
            ResultSet rs = conn.createStatement().executeQuery("Select"+x+","+y+" from trial where "+z+" ITEM_NAME = 'Ruchirraa 1 Ltr - Vp (1x10)' AND VRDATE <= CAST('"+date2+"' AS DATE) AND VRDATE >= CAST('"+date1+"' AS DATE) AND ITEM_NATURE ='PG' AND DIV_CODE LIKE 'O%' "+group+"");
            while(rs.next()){
                s108.getData().add(new XYChart.Data(rs.getString(1), rs.getDouble(2)));
            }
            s108.setName("Ruchirraa 1 Ltr - Vp (1x10)");
            data.addAll(s108);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
            }
        }
        if(ch109.isSelected()){
        try{
            conn = CONNECT.ConnecterDb();
            ResultSet rs = conn.createStatement().executeQuery("Select"+x+","+y+" from trial where "+z+" ITEM_NAME = 'Naturralle 1 Ltr - Vp (1x16)' AND VRDATE <= CAST('"+date2+"' AS DATE) AND VRDATE >= CAST('"+date1+"' AS DATE) AND ITEM_NATURE ='PG' AND DIV_CODE LIKE 'O%' "+group+"");
            while(rs.next()){
                s109.getData().add(new XYChart.Data(rs.getString(1), rs.getDouble(2)));
            }
            s109.setName("Naturralle 1 Ltr - Vp (1x16)");
            data.addAll(s109);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
            }
        }
        if(ch110.isSelected()){
        try{
            conn = CONNECT.ConnecterDb();
            ResultSet rs = conn.createStatement().executeQuery("Select"+x+","+y+" from trial where "+z+" ITEM_NAME = 'Naturralle 1 Ltr - Vp (1x10)' AND VRDATE <= CAST('"+date2+"' AS DATE) AND VRDATE >= CAST('"+date1+"' AS DATE) AND ITEM_NATURE ='PG' AND DIV_CODE LIKE 'O%' "+group+"");
            while(rs.next()){
                s110.getData().add(new XYChart.Data(rs.getString(1), rs.getDouble(2)));
            }
            s110.setName("Naturralle 1 Ltr - Vp (1x10)");
            data.addAll(s110);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
            }
        }
        if(ch111.isSelected()){
        try{
            conn = CONNECT.ConnecterDb();
            ResultSet rs = conn.createStatement().executeQuery("Select"+x+","+y+" from trial where "+z+" ITEM_NAME = 'Ruchirraa 200 Ml - Vp (1x50)' AND VRDATE <= CAST('"+date2+"' AS DATE) AND VRDATE >= CAST('"+date1+"' AS DATE) AND ITEM_NATURE ='PG' AND DIV_CODE LIKE 'O%' "+group+"");
            while(rs.next()){
                s111.getData().add(new XYChart.Data(rs.getString(1), rs.getDouble(2)));
            }
            s111.setName("Ruchirraa 200 Ml - Vp (1x50)");
            data.addAll(s111);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
            }
        }
        if(ch112.isSelected()){
        try{
            conn = CONNECT.ConnecterDb();
            ResultSet rs = conn.createStatement().executeQuery("Select"+x+","+y+" from trial where "+z+" ITEM_NAME = 'RUCHIRRA 50 ML - VP (1X200)' AND VRDATE <= CAST('"+date2+"' AS DATE) AND VRDATE >= CAST('"+date1+"' AS DATE) AND ITEM_NATURE ='PG' AND DIV_CODE LIKE 'O%' "+group+"");
            while(rs.next()){
                s112.getData().add(new XYChart.Data(rs.getString(1), rs.getDouble(2)));
            }
            s112.setName("RUCHIRRA 50 ML - VP (1X200)");
            data.addAll(s112);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
            }
        }
        if(ch113.isSelected()){
        try{
            conn = CONNECT.ConnecterDb();
            ResultSet rs = conn.createStatement().executeQuery("Select"+x+","+y+" from trial where "+z+" ITEM_NAME = 'RUCHIRRA 100 ML - VP (1X100)' AND VRDATE <= CAST('"+date2+"' AS DATE) AND VRDATE >= CAST('"+date1+"' AS DATE) AND ITEM_NATURE ='PG' AND DIV_CODE LIKE 'O%' "+group+"");
            while(rs.next()){
                s113.getData().add(new XYChart.Data(rs.getString(1), rs.getDouble(2)));
            }
            s113.setName("RUCHIRRA 100 ML - VP (1X100)");
            data.addAll(s113);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
            }
        }
        if(ch114.isSelected()){
        try{
            conn = CONNECT.ConnecterDb();
            ResultSet rs = conn.createStatement().executeQuery("Select"+x+","+y+" from trial where "+z+" ITEM_NAME = 'Ruchirraa 15 Kg Can- Vp' AND VRDATE <= CAST('"+date2+"' AS DATE) AND VRDATE >= CAST('"+date1+"' AS DATE) AND ITEM_NATURE ='PG' AND DIV_CODE LIKE 'O%' "+group+"");
            while(rs.next()){
                s114.getData().add(new XYChart.Data(rs.getString(1), rs.getDouble(2)));
            }
            s114.setName("Ruchirraa 15 Kg Can- Vp");
            data.addAll(s114);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
            }
        }
        if(ch115.isSelected()){
        try{
            conn = CONNECT.ConnecterDb();
            ResultSet rs = conn.createStatement().executeQuery("Select"+x+","+y+" from trial where "+z+" ITEM_NAME = 'Ruchirraa 15 Ltr Can- Vp' AND VRDATE <= CAST('"+date2+"' AS DATE) AND VRDATE >= CAST('"+date1+"' AS DATE) AND ITEM_NATURE ='PG' AND DIV_CODE LIKE 'O%' "+group+"");
            while(rs.next()){
                s115.getData().add(new XYChart.Data(rs.getString(1), rs.getDouble(2)));
            }
            s115.setName("Ruchirraa 15 Ltr Can- Vp");
            data.addAll(s115);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
            }
        }
        if(ch116.isSelected()){
        try{
            conn = CONNECT.ConnecterDb();
            ResultSet rs = conn.createStatement().executeQuery("Select"+x+","+y+" from trial where "+z+" ITEM_NAME = 'Naturralle 15 Ltr Tin - Vp' AND VRDATE <= CAST('"+date2+"' AS DATE) AND VRDATE >= CAST('"+date1+"' AS DATE) AND ITEM_NATURE ='PG' AND DIV_CODE LIKE 'O%' "+group+"");
            while(rs.next()){
                s116.getData().add(new XYChart.Data(rs.getString(1), rs.getDouble(2)));
            }
            s116.setName("Naturralle 15 Ltr Tin - Vp");
            data.addAll(s116);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
            }
        }
        if(ch117.isSelected()){
        try{
            conn = CONNECT.ConnecterDb();
            ResultSet rs = conn.createStatement().executeQuery("Select"+x+","+y+" from trial where "+z+" ITEM_NAME = 'Ruchirraa 15 Kg Tin - Vp' AND VRDATE <= CAST('"+date2+"' AS DATE) AND VRDATE >= CAST('"+date1+"' AS DATE) AND ITEM_NATURE ='PG' AND DIV_CODE LIKE 'O%' "+group+"");
            while(rs.next()){
                s117.getData().add(new XYChart.Data(rs.getString(1), rs.getDouble(2)));
            }
            s117.setName("Ruchirraa 15 Kg Tin - Vp");
            data.addAll(s117);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
            }
        }
        if(ch118.isSelected()){
        try{
            conn = CONNECT.ConnecterDb();
            ResultSet rs = conn.createStatement().executeQuery("Select"+x+","+y+" from trial where "+z+" ITEM_NAME = 'Naturralle 15 Kg Tin - Vp' AND VRDATE <= CAST('"+date2+"' AS DATE) AND VRDATE >= CAST('"+date1+"' AS DATE) AND ITEM_NATURE ='PG' AND DIV_CODE LIKE 'O%' "+group+"");
            while(rs.next()){
                s118.getData().add(new XYChart.Data(rs.getString(1), rs.getDouble(2)));
            }
            s118.setName("Naturralle 15 Kg Tin - Vp");
            data.addAll(s118);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
            }
        }
        if(ch119.isSelected()){
        try{
            conn = CONNECT.ConnecterDb();
            ResultSet rs = conn.createStatement().executeQuery("Select"+x+","+y+" from trial where "+z+" ITEM_NAME = 'Ruchirra Vp - 15 Ltr Tin' AND VRDATE <= CAST('"+date2+"' AS DATE) AND VRDATE >= CAST('"+date1+"' AS DATE) AND ITEM_NATURE ='PG' AND DIV_CODE LIKE 'O%' "+group+"");
            while(rs.next()){
                s119.getData().add(new XYChart.Data(rs.getString(1), rs.getDouble(2)));
            }
            s119.setName("Ruchirra Vp - 15 Ltr Tin");
            data.addAll(s119);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
            }
        }
        if(ch120.isSelected()){
        try{
            conn = CONNECT.ConnecterDb();
            ResultSet rs = conn.createStatement().executeQuery("Select"+x+","+y+" from trial where "+z+" ITEM_NAME = 'G-1 15 KG TIN - VP' AND VRDATE <= CAST('"+date2+"' AS DATE) AND VRDATE >= CAST('"+date1+"' AS DATE) AND ITEM_NATURE ='PG' AND DIV_CODE LIKE 'O%' "+group+"");
            while(rs.next()){
                s120.getData().add(new XYChart.Data(rs.getString(1), rs.getDouble(2)));
            }
            s120.setName("G-1 15 KG TIN - VP");
            data.addAll(s120);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
            }
        }
        return data;
    }
    
    @Override
    public void start(Stage primaryStage) {
        
        BorderPane root = new BorderPane();
        BorderPane root1 = new BorderPane();
        Scene scene = new Scene(root, 1280, 720);
        Scene scene1 = new Scene(root1, 1280, 720);
        
        DatePicker d1 = new DatePicker(date().toLocalDate());
        DatePicker d2 = new DatePicker(LocalDate.now()) ;
        
        Label l1 = new Label("From");
        Label l2 = new Label ("To");
        
        ComboBox cb1 = new ComboBox(options1);
        ComboBox cb2 = new ComboBox(options2);
        ComboBox cb3 = new ComboBox(options3);
        
        cb1.setPromptText("Coulmn 1");
        cb2.setPromptText("Coulmn 2");
        
        cb3.getSelectionModel().selectFirst();
        
        ToolBar t = new ToolBar();
        
        Button btn = new Button("Back");
        Button btnbk = new Button("Back");
        Button btn1 = new Button("Prepare Chart");
        
        t.getItems().addAll(l1,d1,l2,d2,cb1,cb2,cb3,btn1);
        
        CategoryAxis xAxis = new CategoryAxis();
        NumberAxis yAxis = new NumberAxis();
        
        btn1.setOnAction(e->{
            option3 = cb3.getValue().toString();
        if(option3 == "Telangana"){
            z = " STATE_CODE = 'TS' AND ";
        }
        if(option3 == "Andhra Pradesh"){
            z = " STATE_CODE = 'AP' AND ";
        }
        if(option3 == "Maharashtra"){
            z = " STATE_CODE = 'MH' AND ";
        }
        if(option3 == "Karnataka"){
            z = " STATE_CODE = 'KA' AND ";
        }
        if(option3 == "Tamil Nadu"){
            z = " STATE_CODE = 'TN' AND ";
        }
        if(option3 == "Gujarat"){
            z = " STATE_CODE = 'GJ' AND ";
        }
        if(option3 == "Chattisgarh"){
            z = " STATE_CODE = 'CG' AND ";
        }
        if(option3 == "Madhya Pradesh"){
            z = " STATE_CODE = 'MP' AND ";
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
            x = " YEAR(VRDATE) ";
        }
        if(option1 == "Month"){
            x = " MONTH(VRDATE) ";
        }
        if(option1 == "Week"){
            x = " WEEK(VRDATE) ";
        }
        option2 = cb2.getValue().toString();
        if(option2 == "Quantity in Tonne"){
            y = "SUM((QTYORDER-QTYCANCELLED)*PROD_SIZE/1000)";
        }
        if(option2 == "Rate"){
            y = "RATE";
        }
        if(option2 == "Cost Price"){
            y = "COST_PRICE";
        }
        if(option2 == "Cost Value"){
            y = "COST_VALUE";
        }
        if(option2 == "Contribution"){
            y = "CONTRIBUTION";
        }
        if(option2 == "Contribution Per Tonne"){
            y = "AVG(CONT_PER_TON)";
        }
        
        if(option1 == "State"){
            z = "";
            x = " STATE_CODE";
        }
        
        group = " Group By "+x+"";
        
        date1 = d1.getValue().toString();
        date2 = d2.getValue().toString();
        
        LineChart lc1 = new LineChart(xAxis,yAxis,barData());
        xAxis.setLabel(option1);
        yAxis.setLabel(option2);
        
        btn.setOnAction(i->{
            data.clear();
            s1.getData().clear(); s2.getData().clear(); s3.getData().clear(); s4.getData().clear(); s5.getData().clear(); s6.getData().clear(); s7.getData().clear(); s8.getData().clear(); s9.getData().clear(); s10.getData().clear(); s11.getData().clear(); s12.getData().clear(); s13.getData().clear(); s14.getData().clear(); s15.getData().clear();
            s16.getData().clear(); s17.getData().clear(); s18.getData().clear(); s19.getData().clear(); s20.getData().clear(); s21.getData().clear(); s22.getData().clear(); s23.getData().clear(); s24.getData().clear(); s25.getData().clear(); s26.getData().clear(); s27.getData().clear(); s28.getData().clear(); s29.getData().clear(); s30.getData().clear();
            s31.getData().clear(); s32.getData().clear(); s33.getData().clear(); s34.getData().clear(); s35.getData().clear(); s36.getData().clear(); s37.getData().clear(); s38.getData().clear(); s39.getData().clear(); s40.getData().clear(); s41.getData().clear(); s42.getData().clear(); s43.getData().clear(); s44.getData().clear(); s45.getData().clear();
            s46.getData().clear(); s47.getData().clear(); s48.getData().clear(); s49.getData().clear(); s50.getData().clear(); s51.getData().clear(); s52.getData().clear(); s53.getData().clear(); s54.getData().clear(); s55.getData().clear(); s56.getData().clear(); s57.getData().clear(); s58.getData().clear(); s59.getData().clear(); s60.getData().clear();
            s61.getData().clear(); s62.getData().clear(); s63.getData().clear(); s64.getData().clear(); s65.getData().clear(); s66.getData().clear(); s67.getData().clear(); s68.getData().clear(); s69.getData().clear(); s70.getData().clear(); s71.getData().clear(); s72.getData().clear(); s73.getData().clear(); s74.getData().clear(); s75.getData().clear();
            s76.getData().clear(); s77.getData().clear(); s78.getData().clear(); s79.getData().clear(); s80.getData().clear(); s81.getData().clear(); s82.getData().clear(); s83.getData().clear(); s84.getData().clear(); s85.getData().clear(); s86.getData().clear(); s87.getData().clear(); s88.getData().clear(); s89.getData().clear(); s90.getData().clear();
            s91.getData().clear(); s92.getData().clear(); s93.getData().clear(); s94.getData().clear(); s95.getData().clear(); s96.getData().clear(); s97.getData().clear(); s98.getData().clear(); s99.getData().clear(); s100.getData().clear(); s101.getData().clear(); s102.getData().clear(); s103.getData().clear(); s104.getData().clear(); s105.getData().clear(); 
            s106.getData().clear(); s107.getData().clear(); s108.getData().clear(); s109.getData().clear(); s110.getData().clear(); s111.getData().clear(); s112.getData().clear(); s113.getData().clear(); s114.getData().clear(); s115.getData().clear(); s116.getData().clear(); s117.getData().clear(); s118.getData().clear(); s119.getData().clear(); s120.getData().clear();
            primaryStage.setScene(scene);
            primaryStage.show();
        });
        
        root1.setCenter(lc1);
        root1.setBottom(btn);
        primaryStage.setScene(scene1);
        primaryStage.show();
        });
                
        CheckBoxTreeItem<String> p1 = new CheckBoxTreeItem<>("NATURRALLE");
        CheckBoxTreeItem<String> p2 = new CheckBoxTreeItem<>("SUNSURRE");
        CheckBoxTreeItem<String> p3 = new CheckBoxTreeItem<>("KRISHNA BRAND");
        CheckBoxTreeItem<String> p4 = new CheckBoxTreeItem<>("SRE KRISHNA");
        CheckBoxTreeItem<String> p5 = new CheckBoxTreeItem<>("MOTHER'S CHOICE");
        CheckBoxTreeItem<String> p6 = new CheckBoxTreeItem<>("RUCHIRRA");
        CheckBoxTreeItem<String> p7 = new CheckBoxTreeItem<>("OTHERS");
        
        p1.getChildren().addAll(ch40,ch42,ch43,ch44,ch45,ch46,ch47,ch48,ch49,ch50,ch51,ch54,ch55,ch56,ch58,ch59,ch62,ch63,ch64,ch67,ch68,ch82,ch83,ch84,ch85,ch86,ch87,ch88,ch89,ch101,ch102,ch103,ch104,ch106,ch107,ch109,ch110,ch116,ch118);
        p2.getChildren().addAll(ch13,ch21,ch28,ch38,ch39,ch73,ch77,ch78,ch79,ch80,ch81);
        p3.getChildren().addAll(ch8,ch9,ch10,ch11,ch12,ch15,ch16,ch33,ch34,ch35,ch69,ch72);
        p4.getChildren().addAll(ch17,ch18,ch20,ch25,ch26,ch27,ch36,ch37,ch71,ch74,ch75,ch76);
        p5.getChildren().addAll(ch4,ch5,ch6,ch7,ch14,ch19,ch22,ch23,ch24,ch31,ch32);
        p6.getChildren().addAll(ch1,ch2,ch3,ch29,ch30,ch105,ch108,ch111,ch112,ch113,ch114,ch115,ch117,ch119);
        p7.getChildren().addAll(ch41,ch52,ch53,ch57,ch60,ch61,ch65,ch66,ch90,ch91,ch92,ch93,ch94,ch95,ch96,ch97,ch98,ch99,ch100,ch120);
        
        CheckTreeView tv = new CheckTreeView(ch);
        ch.setExpanded(true);
        ch.getChildren().addAll(p1,p2,p3,p4,p5,p6,p7);
        
        root.setTop(t);
        root.setRight(tv);
        root.setBottom(btnbk);
        
        btnbk.setOnAction(e->{
             try{
           Class.forName("sarl_graph_viewer.Product_Analysis.ProductMain");
           primaryStage.close();
           new sarl_graph_viewer.Product_Analysis.ProductMain().start(stage1);
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
