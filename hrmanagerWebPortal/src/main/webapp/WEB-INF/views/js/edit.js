function validateEdit() {
		var empName=document.edit_form.empName.value;
		var loc=document.edit_form.loc.value;
		var email=document.edit_form.email.value;
		var date=document.edit_form.date.value;
		var mailFormat = /^([A-Za-z0-9_\-\.])+\@([A-Za-z0-9_\-\.])+\.([A-Za-z]{2,4})$/;
		if(empName.length==0 ){
			return false
		}else{
			if (empName.length >100  ) {
				alert("Employee Name should be <100 character long..");
				document.edit_form.empName.focus();
				return false;
			} else if (loc.length >500  ) {
				alert("location should be max 500 character long..");
				document.edit_form.loc.focus();
				return false;
			}else if (email.length >100  ) {
				alert("email should be max 100 character long..");
				document.edit_form.email.focus();
				return false;
			} else if(mailFormat.test(email)==false){
				alert("Enter a valid Email");
				document.edit_form.email.focus();
				return false;
			}
		}
	}