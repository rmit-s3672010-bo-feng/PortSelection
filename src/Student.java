
public class Student {
	private String studentNumber;
	private int portNumber1;
	private int portNumber2;

	public Student(String studentNumber, int portNumber1, int portNumber2) {
		this.studentNumber = studentNumber;
		this.portNumber1 = portNumber1;
		this.portNumber2 = portNumber2;
	}

	public String getStudentNumber() {
		return this.studentNumber;
	}

	public int getPortNumber1() {
		return this.portNumber1;
	}

	public int getPortNumber2() {
		return this.portNumber2;
	}

	public String toString() {
		String message = this.studentNumber + ":" + this.portNumber1 + ":" + this.portNumber2;
		return message;
	}

}
