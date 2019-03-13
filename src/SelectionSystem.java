import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

import Exceptions.numberOutOfRangeException;
import Exceptions.portNumberRepeatException;
import Exceptions.studentNumberRepeatException;

public class SelectionSystem {
	public ArrayList<Student> studentGroup;

	public SelectionSystem() {
		this.studentGroup = new ArrayList<Student>();

	}

	public void add(String studentNumber, int portNumber1, int portNumber2) throws Exception {
		if (portNumber1 > 61999 || portNumber1 < 61000) {
			if (portNumber2 > 61999 || portNumber2 < 61000) {
				throw new numberOutOfRangeException("The two port numbers are both out of range.(61000-61999)");
			} else {
				throw new numberOutOfRangeException("The first port number is out of range.(61000-61999)");
			}
		} else if (portNumber2 > 61999 || portNumber2 < 61000) {
			throw new numberOutOfRangeException("The second port number is out of range.(61000-61999)");
		} else if (portNumber1 == portNumber2) {
			throw new portNumberRepeatException("The two port numbers are same.");
		}
		for (Student student : studentGroup) {
			if (studentNumber.equals(student.getStudentNumber())) {
				throw new studentNumberRepeatException("The student number is repeated.");
			} else if (portNumber1 == student.getPortNumber1() || portNumber1 == student.getPortNumber2()) {
				if (portNumber2 == student.getPortNumber1() || portNumber2 == student.getPortNumber2()) {
					throw new portNumberRepeatException("The two port numbers are both occupied");
				} else {
					throw new portNumberRepeatException("The first port number is occupied");
				}
			} else if (portNumber2 == student.getPortNumber1() || portNumber2 == student.getPortNumber2()) {
				throw new portNumberRepeatException("The second port number is occupied");
			}
		}
		Student newStudent = new Student(studentNumber, portNumber1, portNumber2);
		studentGroup.add(newStudent);
	}
	public void displayAllInformation() {
		for(Student newStudent:studentGroup) {
			System.out.println(newStudent);
		}
	}
	public String toString() {
		String message="";
		for(Student newStudent:studentGroup) {
			message+=newStudent.toString()+"\n";
		}
		return message;
	}

	public void readFromFile() {
		try {
			String s = System.getProperty("user.dir");
			String path=s+"/Data.txt";
			BufferedReader Input = new BufferedReader(new FileReader(path));
			String next = Input.readLine();
			while (next != null) {
				String[] details = next.split(":");
				String studentID = details[0];
				int portNumber1 = Integer.parseInt(details[1]);
				int portNumber2 = Integer.parseInt(details[2]);
				Student newStudent = new Student(studentID, portNumber1, portNumber2);
				this.studentGroup.add(newStudent);
				next=Input.readLine();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	public void writeToFile() {
		try {
			String s = System.getProperty("user.dir");
			String path=s+"/Data.txt";
			FileWriter writer=new FileWriter(path);
			writer.write(this.toString());
			writer.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
