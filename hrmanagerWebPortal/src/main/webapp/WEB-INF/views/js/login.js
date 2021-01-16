function validateForm() {
		var userName=document.login_form.username.value;
		var password=document.login_form.password.value;
		if(userName.length==0 || password.length==0){
			return false
		}else{
			if (userName.length <5 || userName.length > 50  ) {
				alert("User Name should be min 5 and max 50 character long..");
				document.login_form.username.focus();
				return false;
			} else if (password.length <5 || password.length > 50 ) {
				alert("Password should be min 5 and max 50 character long..");
				document.login_form.password.focus();
				return false;
			}
		}
	}