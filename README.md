# Loan Calculator

This program calculates the costs of monthly and total payments of a given loan and interest rate

## Build info
-	LoanAppClient - Contains the Main class which is used to run the program by calling the session bean and setup the GUI used to send information to the bean and display information about the loan payments.
-	LoanClassLib - Contains the Java EE 8 API Library for using EJB in the program and the remote interface for the session bean.
-	LoanEntApp - Contains the stateless session bean that connects with the glassfish server to calculate the loans in the LoanBean class with the information received from the client.
- Enterprise JavaBeans Architecture 
- JavaFX
