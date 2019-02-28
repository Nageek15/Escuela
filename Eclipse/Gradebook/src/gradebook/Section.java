package gradebook;

import java.util.ArrayList;

public class Section {
	ArrayList<Student> students=new ArrayList();
	private String name;
	
	
	Section(String name) {
		this.name=name;
		
	}
	public String getName() {
		return name;
	}
	public double getOveralScore(String username) {
		for (Student s:students) {
			if (s.getUsername()==username) {
				return s.getOveralScore();
			}
		}
		System.err.println("Student with specified username not found");
		return 0;
	}
	public double getOveralScoreAvg() {
		double d=0;
		for (Student s:students) {
			d+=s.getOveralScore();
		}
		return d/students.size();
	}
	public double getAssignmentScore(String username,String assignmentName) {
		for (Student s:students) {
			if (s.getUsername()==username) {
				return s.getPercentScore(assignmentName);
			}
		}
		System.err.println("Student with specified username not found");
		return 0;
	}
	public double getAssignmentScoreAvg(String assignmentName) {
		double d=0;
		int no=0;
		for (Student s:students) {
			if (s.hasAssignment(assignmentName)) {
				d+=s.getPercentScore(assignmentName);
				no++;
			}
		}
		return d/no;
	}
	public int getTardyCount(String username) {
		for (Student s:students) {
			if (s.getUsername()==username) {
				return s.getTardyCount();
			}
		}
		System.err.println("Student with specified username not found");
		return 0;
	}
	public int getAbsenceCount(String username) {
		for (Student s:students) {
			if (s.getUsername()==username) {
				return s.getAbsenceCount();
			}
		}
		System.err.println("Student with specified username not found");
		return 0;
	}
	
	
	public boolean addStudent(Student student) {
		return students.add(student);
	}
	public boolean addAssignmentToStudent(String username,String assignmentName, int totalPointsPossible) {
		for (Student s:students) {
			if (s.getUsername()==username) {
				return s.addAssignment(new Assignment(assignmentName,totalPointsPossible));
			}
		}
		System.err.println("Student with specified username not found");
		return false;
	}
	public boolean addAssignmentToSection(String assignmentName,int totalPointsPossible) {
		for (Student s:students) {
			if (!s.addAssignment(new Assignment(assignmentName,totalPointsPossible))) {
				return false;
			}
		}
		return true;
	}
	public boolean setScoreOfAssignment(String username,String assignmentName,int score) {
		for (Student s:students) {
			if (s.getUsername()==username) {
				return s.setScore(assignmentName, score);
			}
		}
		System.err.println("Student with specified username not found");
		return false;
	}
	public boolean markTardy(String username) {
		for (Student s:students) {
			if (s.getUsername()==username) {
				return s.markTardy();
			}
		}
		System.err.println("Student with specified username not found");
		return false;
	}
	public boolean markAbsent(String username) {
		for (Student s:students) {
			if (s.getUsername()==username) {
				return s.markAbsent();
			}
		}
		System.err.println("Student with specified username not found");
		return false;
	}
}
