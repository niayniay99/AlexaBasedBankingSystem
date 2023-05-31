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
@Table(name = "branch_table")
public class BranchVO {
	@Id
	@Column(name = "branch_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int branchid;

	@Column(name = "branch_name")
	private String branchName;

	@Column(name = "branch_address")
	private String branchAddress;

	@Column(name = "status")
	private boolean status = true;

	@ManyToOne
	@JoinColumn(name = "area_id")
	private AreaVO areaVO;

	public int getBranchid() {
		return branchid;
	}

	public void setBranchid(int branchid) {
		this.branchid = branchid;
	}

	public String getBranchName() {
		return branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	public String getBranchAddress() {
		return branchAddress;
	}

	public void setBranchAddress(String branchAddress) {
		this.branchAddress = branchAddress;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public AreaVO getAreaVO() {
		return areaVO;
	}

	public void setAreaVO(AreaVO areaVO) {
		this.areaVO = areaVO;
	}

}
