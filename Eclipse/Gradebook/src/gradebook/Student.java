package gradebook;

import java.util.ArrayList;

public class Student {
	private String[] info=new String[3];//0 is first name 1 is last name 2 is username
	private long phoneNo;
	private ArrayList<Assignment> assignments;
	private int tardyCount;
	private int absCount;
	
	
	Student() {
		info[0]="Unnamed";
		info[1]="Student";
		info[2]="Unt:itledUser";
		phoneNo=0000000000;
		tardyCount=0;
		absCount=0;
		assignments=new ArrayList<>();
	}
	Student(String firstName, String lastName, String username, long phoneNo) {
		info[0]=firstName;
		info[1]=lastName;
		info[2]=username;
		if (phoneNo>9999999999l) {
			String no=String.valueOf(phoneNo);
			no=no.substring(no.length()-10);
			phoneNo=Long.parseLong(no);
			System.err.println("WARNING :  Entered phone number too long, parsed to last ten digits");
		}
		tardyCount=0;
		absCount=0;
		this.phoneNo=phoneNo;
		assignments=new ArrayList<>();
	}
	public long getPhoneNumber() {
		return phoneNo;
	}
	public String getFirstName() {
		return info[0];
	}
	public String getLastName() {
		return info[1];
	}
	public String getUsername() {
		return info[2];
	}
	public double getPercentScore(String assignmentName) {
		for (Assignment a:assignments) {
			if (assignmentName.equals(a.getName())) {
				return a.getPercentScore();
			}
		}
		System.err.println("Asignment with specified name not found");
		return 0;
	}
	public double getOveralScore(){
		double d=0;
		for (Assignment a:assignments) {
			d+=a.getPointsObtained()/a.getPointsPossible();
		}
		d/=assignments.size();
		return d;
	}
	public int getTardyCount() {
		return tardyCount;
	}
	public int getAbsenceCount() {
		return absCount;
	}
	
	
	public boolean addAssignment(Assignment A) {
		for (Assignment a:assignments) {
			if (a.getName().equalsIgnoreCase(A.getName())) {
				System.err.println("Asignment with specified name already exists for this student ("+info[2]+")");
				return false;
			}
		}
		return assignments.add(A);
	}
	public boolean setScore(String assignmentName,int score) {
		for (Assignment a:assignments) {
			if (assignmentName.equals(a.getName())) {
				a.setPointsObtained(score);
			}
		}
		System.err.println("Asignment with specified name not found");
		return false;
	}
	public boolean hasAssignment(String assignmentName) {
		for (Assignment a:assignments) {
			if (assignmentName.equals(a.getName())) {
				return true;
			}
		}
		return false;
	}
	public boolean markTardy() {
		tardyCount++;
		return true;
	}
	public boolean markAbsent() {
		absCount++;
		return true;
	}
}
