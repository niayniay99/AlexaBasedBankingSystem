package com.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "form_table")

public class FormVO {

	@Id
	@Column(name = "form_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int formid;

	@Column(name = "file_name")
	private String fileName;

	@Column(name = "doc_name")
	private String docName;

	@Column(name = "doc_path")
	private String docPath;

	@Column(name = "status")
	private boolean status = true;

	public int getFormid() {
		return formid;
	}

	public void setFormid(int formid) {
		this.formid = formid;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public String getDocName() {
		return docName;
	}

	public void setDocName(String docName) {
		this.docName = docName;
	}

	public String getDocPath() {
		return docPath;
	}

	public void setDocPath(String docPath) {
		this.docPath = docPath;
	}

}
