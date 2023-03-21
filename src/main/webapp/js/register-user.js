/*
    This function called when "Register" button clicked.
*/
function validateRegister() {
	// Get the value that user enters at the form
	var firstNameElement = document.getElementById("firstName");
	var lastNameElement = document.getElementById("lastName");
	var emailElement = document.getElementById("email");
	var userNameElement = document.getElementById("userName");
	var passwordElement = document.getElementById("password");
	var confirmPasswordElement =  document.getElementById("confirmPassword");
	
	// variable to check valid input
	var status = false;
	
	var message = "Please fill all mandatory fields";
	
	setBorderColor(firstNameElement);
	setBorderColor(lastNameElement);
	setBorderColor(emailElement);
	setBorderColor(userNameElement);
	setBorderColor(passwordElement);
	setBorderColor(confirmPasswordElement);
	
	var email = emailElement.value;
	
	if (email != "" && !validateEmail(email)) {
		message = "Email is incorrect format";
		emailElement.style.borderColor = "red";
	} else if (passwordElement.value != "" && passwordElement.value.length < 6) {
		message = "Password must be greater than or equals 6 characters";
		passwordElement.style.borderColor = "red";
	} else if (passwordElement.value != confirmPasswordElement.value) {
		message = "Confirm password is not match with password";
		confirmPasswordElement.style.borderColor = "red";
	} 
	
	// count number of input tags
	var numberOfInput = document.getElementsByTagName("input").length;
	var countNumberValidInput = 0;
	
	for (var j = 0; j < numberOfInput; j++) {
		// check all input are valid
		if (document.getElementsByTagName("input")[j].style.borderColor == "green") {
			countNumberValidInput++;
		}
	}
	
	// if all input are valid, set ok = true
	if (countNumberValidInput == numberOfInput) {
		message = "";
		status = true;
	}
    
	
	document.getElementById("error").innerHTML = message;
	
	if(status) {
		return true;
	}
	
	return false;
}


/*
 * Check valid email.
 */
function validateEmail(email) {
  var re = /^(([^<>()[\]\\.,;:\s@\"]+(\.[^<>()[\]\\.,;:\s@\"]+)*)|(\".+\"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
  return re.test(email);
}

/*
 * Change border to an element.
 */
function setBorderColor(element) {
	if (element.value == "") {
		element.style.borderColor = "red";
	} else {
		element.style.borderColor = "green";
	}
}


		
	

	