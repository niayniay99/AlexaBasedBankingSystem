package com.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "loantype_table")

public class LoantypeVO {
	
	@Id
	@Column(name = "loantype_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int loantypeid;

	@Column(name = "loan_type")
	private String loanType;

	@Column(name = "loan_description")
	private String loanDescription;

	@Column(name = "status")
	private boolean status = true;

	public int getLoantypeid() {
		return loantypeid;
	}

	public void setLoantypeid(int loantypeid) {
		this.loantypeid = loantypeid;
	}

	public String getLoanType() {
		return loanType;
	}

	public void setLoanType(String loanType) {
		this.loanType = loanType;
	}

	public String getLoanDescription() {
		return loanDescription;
	}

	public void setLoanDescription(String loanDescription) {
		this.loanDescription = loanDescription;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

}
