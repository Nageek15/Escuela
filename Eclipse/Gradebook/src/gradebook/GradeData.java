package gradebook;

import java.util.ArrayList;

public class GradeData {
	
	static ArrayList<Section> sections=new ArrayList<>();
	static Section currentSection=null;
	
	
	private GradeData() {}
	
	public static boolean addStudent(String firstName, String lastName, String username,long phoneNo) {
		return currentSection.addStudent(new Student(firstName, lastName, username, phoneNo));
	}
	
	
	public static double getOveralScore(String username) {
		return currentSection.getOveralScore(username);
	}
	public static double getOveralScoreAvg() {
		return currentSection.getOveralScoreAvg();
	}
	public static  double getAssignmentScore(String username,String assignmentName) {
		return currentSection.getAssignmentScore(username, assignmentName);
	}
	public static double getAssignmentScoreAvg(String assignmentName) {
		return currentSection.getAssignmentScoreAvg(assignmentName);
	}
	public static int getAbsenceCount(String username) {
		return currentSection.getAbsenceCount(username);
	}
	public static int getTardyCount(String username) {
		return currentSection.getTardyCount(username);
	}
	
	
	
	public static boolean addSection(String name) {
		for (Section s:sections) {
			if (s.getName()==name) {
				System.err.println("Section with specified name already exists");
				return false;
			}
		}
		return sections.add(new Section(name));
	}
	public static boolean setCurrentSection(String name) {
		for (Section s:sections) {
			if (s.getName()==name) {
				currentSection=s;
				return true;
			}
		}
		System.err.println("Section with specified name not found");
		return false;
	}
	boolean AddStudent(String firstName, String lastName, String username, long phoneNumber) {
		return currentSection.addStudent(new Student(firstName,lastName,username,phoneNumber));
	}
	boolean addAssignmentToStudent(String username, String assignmentName, int totalPointsPossible) {
		return currentSection.addAssignmentToStudent(username, assignmentName, totalPointsPossible);
	}
	boolean addAssignmentToSection(String assignmentName, int totalPointsPossible) {
		return currentSection.addAssignmentToSection(assignmentName, totalPointsPossible);
	}
	boolean setScoreOfAssignment(String username, String assignmentName, int score) {
		return currentSection.setScoreOfAssignment(username, assignmentName, score);
	}
}
