function addArea() {

	if ($('#areaName').val().trim() === '') {
		$('#areaName').focus()
		showErrorToast('Please Enter Area Name')
		return false;
	} else if ($('#areaName').val().length < 3) {
		$('#areaName').focus()
		showErrorToast('Please Enter Valid Area Name')		
		return false;
	} else if ($('#areaDescription').val().trim() === '') {
		$('#areaDescription').focus()
		showErrorToast('Please Enter Area Description')		
		return false;
	}else {
		return true;
	}
}

function addBranch() {

	if ($('#selectArea').val() == "none") {
		$('#selectArea').focus()
		showErrorToast('Please Select Area Name')
		return false;
	} else if ($('#branchName').val().length < 3) {
		$('#branchName').focus()
		showErrorToast('Please Enter Valid Branch Name')		
		return false;
	} else if ($('#branchAddress').val().trim() === '') {
		$('#branchAddress').focus()
		showErrorToast('Please Enter Branch Address')		
		return false;
	  
	}else if ($('#branchAddress').val().length < 15) {
		$('#branchAddress').focus()
		showErrorToast('Please Enter Valid Branch Address')		
		return false;
	}
		else {
		return true;
	}
}

function addForm() {
	if ($('#file').val().trim() === '') {
		$('#file').focus()
		showErrorToast('Please Upload File')
		return false;
	}else if ($('#fileName').val().trim() === '') {
		$('#fileName').focus()
		showErrorToast('Please Enter File Name')
		return false;
	} else if ($('#fileName').val().length < 2) {
		$('#fileName').focus()
		showErrorToast('Please Enter Valid File Name')		
		return false;
	}
	else {
		return true;
	}

}

function addAccounttype() {

	if ($('#accountType').val().trim() === '') {
		$('#accountType').focus()
		showErrorToast('Please Enter Account Type')
		return false;
	} else if ($('#accountType').val().length < 4) {
		$('#accountType').focus()
		showErrorToast('Please Enter Valid Account Type')		
		return false;
	} else if ($('#accountDescription').val().trim() === '') {
		$('#accountDescription').focus()
		showErrorToast('Please Enter Account Description')		
		return false;
	}else {
		return true;
	}
}

function addLoantype() {

	if ($('#loanType').val().trim() === '') {
		$('#loanType').focus()
		showErrorToast('Please Enter Loan Type')
		return false;
	} else if ($('#loanType').val().length < 4) {
		$('#loanType').focus()
		showErrorToast('Please Enter Valid loan Type')		
		return false;
	} else if ($('#loanDescription').val().trim() === '') {
		$('#loanDescription').focus()
		showErrorToast('Please Enter Loan Description')		
		return false;
	}else {
		return true;
	}
}

function addLoantypeinfo() {

	if ($('#selectLoantype').val() == "none") {
		$('#selectLoantype').focus()
		showErrorToast('Please Select Loan Type')
		return false;
	}
	else if ($('#loanRate').val().trim() === 0) {
		$('#loanRate').focus()
		showErrorToast('Please Enter Loan Rate')		
		return false;
	}
	else if ($('#loanRate').val().length < 1) {
		$('#loanRate').focus()
		showErrorToast('Please Enter Valid Loan Rate')		
		return false;
	}
	else if ($('#maximumloanAmount').val().trim() === '') {
		$('#maximumloanAmount').focus()
		showErrorToast('Please Enter Maximum Loan Amount')		
		return false;  
	}
	else if ($('#maximumloanAmount').val().length < 5 ) {
		$('#maximumloanAmount').focus()
		showErrorToast('Please Enter Valid Max. Loan Amount')		
		return false;
	}
	else if ($('#timeDuration').val().trim() === '') {
		$('#timeDuration').focus()
		showErrorToast('Please Enter Time Duration')		
		return false;
	}
	else if ($('#timeDuration').val().length < 1) {
		$('#timeDuration').focus()
		showErrorToast('Please Enter Valid Time Duration')		
		return false;
	}
		else {
		return true;
	}
}
