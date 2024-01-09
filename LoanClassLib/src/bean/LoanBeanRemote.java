/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import java.util.Date;
import javax.ejb.Remote;

/**
 *
 * @author nasif
 */
@Remote
public interface LoanBeanRemote {

    public double getAnnualInterestRate();

    public void setAnnualInterestRate(double annualInterestRate);

    public int getNumberOfYears();

    public void setNumberOfYears(int numberOfYears);

    public double getLoanAmount();

    public void setLoanAmount(double loanAmount);

    public double getMonthlyPayment();

    public double getTotalPayment();

    public Date getLoanDate();
    
}
