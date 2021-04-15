package com.compassdev.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "customer_master")
public class CustomerMaster {

	@Id
	@Column(name = "customer_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long customerId;
	
	@Column(name = "company_name")
	private String customerName;
	
	@Column(name = "industry")
	private String industry;
	
	@Column(name = "country_hq")
	private String countryhq;
	
	@Column(name = "revenue")
	private double revenue;
	
	@Column(name = "no_of_employee")
	private long noOfEmployees;
	
	@Column(name = "annual_inventory")
	private long annualInventory;
	
	@Column(name = "cost_of_capital")
	private double cogsCapital;
	
	@Column(name = "cogs_as_revenue")
	private double cogsAsRevene;
	
	@Column(name = "days_fin_close")
	private int daysFinClose;
	
	@Column(name = "dso")
	private long dso;
	
	@Column(name = "hours_per_day")
	private int hoursWorkedPerDay;
	
	@Column(name = "it_budget")
	private double itBudget;
	
	@Column(name = "operating_expense")
	private double operatingExpenses;
	
	@Column(name = "operating_profit_margin")
	private double operatingProfitMargin;
	
	@Column(name = "rnd_expense")
	private double rndExpenses;
	
	@Column(name = "sga_expense")
	private double sgaExpenses;

	@Column(name = "remarks")
	private String remarks;
	
	/**
	 * @return the customerId
	 */
	public long getCustomerId() {
		return customerId;
	}
	/**
	 * @param customerId the customerId to set
	 */
	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}
	/**
	 * @return the customerName
	 */
	public String getCustomerName() {
		return customerName;
	}
	/**
	 * @param customerName the customerName to set
	 */
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	/**
	 * @return the industry
	 */
	public String getIndustry() {
		return industry;
	}
	/**
	 * @param industry the industry to set
	 */
	public void setIndustry(String industry) {
		this.industry = industry;
	}
	
	/**
	 * @return the revenue
	 */
	public double getRevenue() {
		return revenue;
	}
	/**
	 * @param revenue the revenue to set
	 */
	public void setRevenue(double revenue) {
		this.revenue = revenue;
	}
	/**
	 * @return the noOfEmployees
	 */
	public long getNoOfEmployees() {
		return noOfEmployees;
	}
	/**
	 * @param noOfEmployees the noOfEmployees to set
	 */
	public void setNoOfEmployees(long noOfEmployees) {
		this.noOfEmployees = noOfEmployees;
	}
	/**
	 * @return the annualInventory
	 */
	public long getAnnualInventory() {
		return annualInventory;
	}
	/**
	 * @param annualInventory the annualInventory to set
	 */
	public void setAnnualInventory(long annualInventory) {
		this.annualInventory = annualInventory;
	}
	/**
	 * @return the cogsCapital
	 */
	public double getCogsCapital() {
		return cogsCapital;
	}
	/**
	 * @param cogsCapital the cogsCapital to set
	 */
	public void setCogsCapital(double cogsCapital) {
		this.cogsCapital = cogsCapital;
	}
	/**
	 * @return the daysFinClose
	 */
	public int getDaysFinClose() {
		return daysFinClose;
	}
	/**
	 * @param daysFinClose the daysFinClose to set
	 */
	public void setDaysFinClose(int daysFinClose) {
		this.daysFinClose = daysFinClose;
	}
	/**
	 * @return the dso
	 */
	public long getDso() {
		return dso;
	}
	/**
	 * @param dso the dso to set
	 */
	public void setDso(long dso) {
		this.dso = dso;
	}
	/**
	 * @return the hoursWorkedPerDay
	 */
	public int getHoursWorkedPerDay() {
		return hoursWorkedPerDay;
	}
	/**
	 * @param hoursWorkedPerDay the hoursWorkedPerDay to set
	 */
	public void setHoursWorkedPerDay(int hoursWorkedPerDay) {
		this.hoursWorkedPerDay = hoursWorkedPerDay;
	}
	/**
	 * @return the itBudget
	 */
	public double getItBudget() {
		return itBudget;
	}
	/**
	 * @param itBudget the itBudget to set
	 */
	public void setItBudget(double itBudget) {
		this.itBudget = itBudget;
	}
	/**
	 * @return the operatingExpenses
	 */
	public double getOperatingExpenses() {
		return operatingExpenses;
	}
	/**
	 * @param operatingExpenses the operatingExpenses to set
	 */
	public void setOperatingExpenses(double operatingExpenses) {
		this.operatingExpenses = operatingExpenses;
	}
	/**
	 * @return the operatingProfitMargin
	 */
	public double getOperatingProfitMargin() {
		return operatingProfitMargin;
	}
	/**
	 * @param operatingProfitMargin the operatingProfitMargin to set
	 */
	public void setOperatingProfitMargin(double operatingProfitMargin) {
		this.operatingProfitMargin = operatingProfitMargin;
	}
	/**
	 * @return the rndExpenses
	 */
	public double getRndExpenses() {
		return rndExpenses;
	}
	/**
	 * @param rndExpenses the rndExpenses to set
	 */
	public void setRndExpenses(double rndExpenses) {
		this.rndExpenses = rndExpenses;
	}
	/**
	 * @return the sgaExpenses
	 */
	public double getSgaExpenses() {
		return sgaExpenses;
	}
	/**
	 * @param sgaExpenses the sgaExpenses to set
	 */
	public void setSgaExpenses(double sgaExpenses) {
		this.sgaExpenses = sgaExpenses;
	}
	/**
	 * @return the countryhq
	 */
	public String getCountryhq() {
		return countryhq;
	}
	/**
	 * @param countryhq the countryhq to set
	 */
	public void setCountryhq(String countryhq) {
		this.countryhq = countryhq;
	}
	/**
	 * @return the remarks
	 */
	public String getRemarks() {
		return remarks;
	}
	/**
	 * @param remarks the remarks to set
	 */
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	/**
	 * @return the cogsAsPercentage
	 */
	public double getCogsAsPercentage() {
		return cogsAsRevene;
	}
	/**
	 * @param cogsAsPercentage the cogsAsPercentage to set
	 */
	public void setCogsAsPercentage(double cogsAsPercentage) {
		this.cogsAsRevene = cogsAsPercentage;
	}
	

}
