/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loanappclient;

import bean.LoanBeanRemote;
import javax.ejb.EJB;
import javafx.application.Application; 
import static javafx.application.Application.launch;
import javafx.geometry.Insets; 
import javafx.geometry.Pos; 
import javafx.scene.Scene; 
import javafx.scene.control.Button; 
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane; 
import javafx.scene.text.Text; 
import javafx.scene.control.TextField; 
import javafx.stage.Stage; 
/**
 *
 * @author nasif
 */
public class Main extends Application { 
    
   @EJB
   private static LoanBeanRemote loanBean;
        
   @Override 
   public void start(Stage stage) {      
      //creating label Annual Interest Rate
      Text text1 = new Text("Annual Interest Rate: ");       
      
      //creating label Number of Years
      Text text2 = new Text("Number of Years: ");       
      
      //creating label Loan Ammount
      Text text3 = new Text("Loan Ammount: ");       
      
      //creating label for Monthly Payment
      Label lbl1 = new Label();
      
      //creating label for Total Payment
      Label lbl2 = new Label();
      
      //creating label for Loan Date
      Label lbl3 = new Label();
      
      //Creating Text Field for Annual Interest Rate        
      TextField textField1 = new TextField();       
      
      //Creating Text Filed for Number of Years        
      TextField textField2 = new TextField();  
       
      //Creating Text Filed for Loan Amount        
      TextField textField3 = new TextField();  
      
      //Creating Button
      Button button1 = new Button("Calculate"); 
      
      button1.setOnAction(new javafx.event.EventHandler<javafx.event.ActionEvent>() {
            
            @Override
            public void handle(javafx.event.ActionEvent event) {
                double annualRate = Double.parseDouble(textField1.getText());
                int numYears = Integer.parseInt(textField2.getText());
                double loanAmmount = Double.parseDouble(textField3.getText());
                
                loanBean.setAnnualInterestRate(annualRate);
                loanBean.setNumberOfYears(numYears);
                loanBean.setLoanAmount(loanAmmount);
                
                lbl1.setText("Monthly Payment: $" + String.format("%.2f", loanBean.getMonthlyPayment()));
                lbl2.setText("Total Payment: $" + String.format("%.2f", loanBean.getTotalPayment()));
                lbl3.setText("Loan Date: " + loanBean.getLoanDate());
            }
        });
      
      //Creating a Grid Pane 
      GridPane gridPane = new GridPane();    
      
      //Setting size for the pane  
      gridPane.setMinSize(400, 200); 
       
      //Setting the padding  
      gridPane.setPadding(new Insets(10, 10, 10, 10)); 
      
      //Setting the vertical and horizontal gaps between the columns 
      gridPane.setVgap(5); 
      gridPane.setHgap(5);       
      
      //Setting the Grid alignment 
      gridPane.setAlignment(Pos.CENTER); 
       
      //Arranging all the nodes in the grid 
      gridPane.add(text1, 0, 0); 
      gridPane.add(textField1, 1, 0); 
      gridPane.add(text2, 0, 1);       
      gridPane.add(textField2, 1, 1); 
      gridPane.add(text3, 0, 2);       
      gridPane.add(textField3, 1, 2); 
      gridPane.add(button1, 2, 2); 
      gridPane.add(lbl1, 0, 3);
      gridPane.add(lbl2, 0, 4);
      gridPane.add(lbl3, 0, 5);
      
      
      //Creating a scene object 
      Scene scene = new Scene(gridPane);  
      
      //Setting title to the Stage 
      stage.setTitle("Loan Calculator"); 
         
      //Adding scene to the stage 
      stage.setScene(scene); 
         
      //Displaying the contents of the stage 
      stage.show(); 
   } 
   public static void main(String args[]){ 
      launch(args); 
   } 
} 
