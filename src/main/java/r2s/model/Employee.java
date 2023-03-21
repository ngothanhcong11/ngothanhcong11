package r2s.model;

public class Employee {
	private String employeeID;
	private String name;
	private String gender;
	private String date;
	private String departmentID;

	public Employee(String employeeID, String name, String gender, String date, String departmentID) {
		super();
		this.employeeID = employeeID;
		this.name = name;
		this.gender = gender;
		this.date = date;
		this.departmentID = departmentID;
	}
	public Employee( String name, String gender, String date, String departmentID) {
		super();
		this.name = name;
		this.gender = gender;
		this.date = date;
		this.departmentID = departmentID;
	}

	public String getEmployeeID() {
		return employeeID;
	}

	public void setEmployeeID(String employeeID) {
		this.employeeID = employeeID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getDepartmentID() {
		return departmentID;
	}

	public void setDepartmentID(String departmentID) {
		this.departmentID = departmentID;
	}

	public void test() {
		System.out.println(name +" " + gender +" " + date +" " +  departmentID +" " +  employeeID);
	}
	
}
