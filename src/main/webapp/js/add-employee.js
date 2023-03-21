function validateDate(){
	var DOBElement = document.getElementById("DOB");
	var DOB = new Date(DOBElement.value);
	var dateCurrent = new Date();
	if(DOB>dateCurrent){
		swal({
			title: "Warning!",
			text: "Your date is grater than current date, please try again!",
			icon: "warning",
		});
		return false;
	}
	return true;
}