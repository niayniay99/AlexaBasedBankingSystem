package com.amazon.ask.helloworldservlet.model;

public class LoantypeinfoVO {

	private int loantypeinfoid;
	
	private String loanRate;
	
	private String maximumloanAmount;
	
	private String timeDuration;
	
	private String numberofEmi;
	
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

}
