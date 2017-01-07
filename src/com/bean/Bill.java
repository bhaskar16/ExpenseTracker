package com.bean;
import java.util.Comparator;

import com.util.*;

public class Bill implements Expense,Comparable<Bill> {
	
	private BillEnum billName;
	private double billAmount;
	private int billMonth;
	private int billYear;
	private boolean billPaid;
	public BillEnum getBillName() {
		return billName;
	}
	public void setBillName(BillEnum billName) {
		this.billName = billName;
	}
	public double getBillAmount() {
		return billAmount;
	}
	public void setBillAmount(double billAmount) {
		this.billAmount = billAmount;
	}
	public int getBillMonth() {
		return billMonth;
	}
	public void setBillMonth(int billMonth) {
		this.billMonth = billMonth;
	}
	public int getBillYear() {
		return billYear;
	}
	public void setBillYear(int billYear) {
		this.billYear = billYear;
	}
	public boolean isBillPaid() {
		return billPaid;
	}
	public void setBillPaid(boolean billPaid) {
		this.billPaid = billPaid;
	}
	
	
	@Override
	public String toString() {
		return "Bill [billName=" + billName + ", billAmount=" + billAmount
				+ ", billMonth=" + billMonth + ", billYear=" + billYear
				+ ", billPaid=" + billPaid + "]";
	}
	@Override
	public int compareTo(Bill b) {
		return (int) ((getBillAmount()-b.getBillAmount()));
	}
	
	/*@Override
	 * public int compareTo(Object o) {
		Bill b = (Bill) o;
		return (int) ((getBillAmount()-b.getBillAmount()));
	}*/
	
	public static Comparator<Bill> BillNameComparator = new Comparator<Bill>(){

		@Override
		public int compare(Bill o1, Bill o2) {
			String a = o1.getBillName().name();
			String b = o2.getBillName().name();
			return (int)(a.charAt(0)-b.charAt(0));
		}
		
	};
	
	public static Comparator<Bill> BillDateComparator = new Comparator<Bill>(){

		@Override
		public int compare(Bill o1, Bill o2) {
			return (int) ((o1.getBillMonth()-o2.getBillMonth()));
		}
		
	};
	
}
	

