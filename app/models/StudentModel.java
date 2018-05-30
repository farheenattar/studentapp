package models;

public class StudentModel {
	private String studentName;
	private String studentCity;

	private int sid;
	
	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getStudentCity() {
		return studentCity;
	}

	public void setStudentCity(String studentCity) {
		this.studentCity = studentCity;
	}

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public StudentModel(String studentName, String studentCity, int sid) {
		super();
		this.studentName = studentName;
		this.studentCity = studentCity;
		this.sid = sid;
	}
	

	@Override
	public String toString() {
		return "StudentModel [studentName=" + studentName + ", studentCity=" + studentCity + ", sid=" + sid + "]";
	}

	public StudentModel() {
		super();
		// TODO Auto-generated constructor stub
	}
}
