package com.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "loantypeinfo_table")

public class LoantypeinfoVO {


	@Id
	@Column(name = "loantypeinfo_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int loantypeinfoid;
	
	@ManyToOne
	@JoinColumn(name = "loantype_id")
	private LoantypeVO loantypeVO;
	
	@Column(name = "loan_rate")
	private String loanRate;
	
	@Column(name = "maximumloan_Amount")
	private String maximumloanAmount;
	
	@Column(name = "time_Duration")
	private String timeDuration;
	
	@Column(name = "numberof_Emi")
	private String numberofEmi;
	
	@Column(name = "status")
	private boolean status = true;

	public LoantypeVO getLoantypeVO() {
		return loantypeVO;
	}

	public void setLoantypeVO(LoantypeVO loantypeVO) {
		this.loantypeVO = loantypeVO;
	}

	public int getLoantypeinfoid() {
		return loantypeinfoid;
	}

	public void setLoantypeinfoid(int loantypeinfoid) {
		this.loantypeinfoid = loantypeinfoid;
	}

	
	public String getTimeDuration() {
		return timeDuration;
	}

	public void setTimeDuration(String timeDuration) {
		this.timeDuration = timeDuration;
	}

	
	public String getLoanRate() {
		return loanRate;
	}

	public void setLoanRate(String loanRate) {
		this.loanRate = loanRate;
	}

	public String getMaximumloanAmount() {
		return maximumloanAmount;
	}

	public void setMaximumloanAmount(String maximumloanAmount) {
		this.maximumloanAmount = maximumloanAmount;
	}

	public String getNumberofEmi() {
		return numberofEmi;
	}

	public void setNumberofEmi(String numberofEmi) {
		this.numberofEmi = numberofEmi;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	
}
