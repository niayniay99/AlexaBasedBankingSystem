package com.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "accounttype_table")

public class AccounttypeVO {

	@Id
	@Column(name = "accounttype_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int accounttypeid;

	public int getAccounttypeid() {
		return accounttypeid;
	}

	@Column(name = "account_type")
	private String accountType;

	@Column(name = "account_description")
	private String accountDescription;

	@Column(name = "status")
	private boolean status = true;

	public void setAccounttypeid(int accounttypeid) {
		this.accounttypeid = accounttypeid;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public String getAccountDescription() {
		return accountDescription;
	}

	public void setAccountDescription(String accountDescription) {
		this.accountDescription = accountDescription;
	}

	public boolean isStatus() {
		return status = true;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

}
