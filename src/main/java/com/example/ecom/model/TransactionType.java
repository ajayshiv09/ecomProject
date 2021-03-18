package com.example.ecom.model;

public enum TransactionType {
	INTERNET_BANKING("IB"), Cash_On_Delivery("COD"), CREDIT_CARD("CC"), DEBIT_CARD("DC");

	private String txnType;

	// getter method
	public String getTxnType() {
		return this.txnType;
	}

	// enum constructor - cannot be public or protected
	private TransactionType(String txnType) {
		this.txnType = txnType;
	}

}
