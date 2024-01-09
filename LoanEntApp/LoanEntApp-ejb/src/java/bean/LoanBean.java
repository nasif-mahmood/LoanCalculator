/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import javax.ejb.Stateless;

/**
 *
 * @author nasif
 */
@Stateless
public class LoanBean implements LoanBeanRemote {
  private double annualInterestRate;
  private int numberOfYears;
  private double loanAmount;
  private java.util.Date loanDate;

  /** Default constructor */
  public LoanBean() {
    this(2.5, 1, 1000);
  }

  /** Construct a loan with specified annual interest rate,
      number of years, and loan amount
     * @param annualInterestRate
     * @param numberOfYears
     * @param loanAmount
    */
  public LoanBean(double annualInterestRate, int numberOfYears,
      double loanAmount) {
    this.annualInterestRate = annualInterestRate;
    this.numberOfYears = numberOfYears;
    this.loanAmount = loanAmount;
    loanDate = new java.util.Date();
  }

  /** Return annualInterestRate
     * @return  */
  @Override
  public double getAnnualInterestRate() {
    return annualInterestRate;
  }

  /** Set a new annualInterestRate
     * @param annualInterestRate */
  @Override
  public void setAnnualInterestRate(double annualInterestRate) {
    this.annualInterestRate = annualInterestRate;
  }

  /** Return numberOfYears
     * @return  */
  @Override
  public int getNumberOfYears() {
    return numberOfYears;
  }

  /** Set a new numberOfYears
     * @param numberOfYears */
  @Override
  public void setNumberOfYears(int numberOfYears) {
    this.numberOfYears = numberOfYears;
  }

  /** Return loanAmount
     * @return  */
  @Override
  public double getLoanAmount() {
    return loanAmount;
  }

  /** Set a newloanAmount
     * @param loanAmount */
  @Override
  public void setLoanAmount(double loanAmount) {
    this.loanAmount = loanAmount;
  }

  /** Find monthly payment
     * @return  */
  @Override
  public double getMonthlyPayment() {
    double monthlyInterestRate = annualInterestRate / 1200;
    double monthlyPayment = loanAmount * monthlyInterestRate / (1 -
      (1 / Math.pow(1 + monthlyInterestRate, numberOfYears * 12)));
    return monthlyPayment;    
  }

  /** Find total payment
     * @return  */
  @Override
  public double getTotalPayment() {
    double totalPayment = getMonthlyPayment() * numberOfYears * 12;
    return totalPayment;    
  }

  /** Return loan date
     * @return  */
  @Override
  public java.util.Date getLoanDate() {
    return loanDate;
  }
}