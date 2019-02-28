package gradebook;

public class Assignment {
	private int pointsPossible;
	private int pointsObtained;
	private String name;
	
	
	Assignment(String name, int pointsPossible) {
		this.name=name;
		if (pointsPossible>0) {
			this.pointsPossible=pointsPossible;
		} else {
			pointsPossible=0;
		}
		this.pointsPossible=pointsPossible;
		this.pointsObtained=0;
	}
	public String getName() {
		return name;
	}
	public boolean setPointsObtained(int p) {
		if (p<pointsPossible&&p>-1) {
			pointsObtained=p;
			return true;
		}
		return false;
	}
	public int getPointsObtained() {
		return pointsObtained;
	}
	public int getPointsPossible() {
		return pointsPossible;
	}
	public double getPercentScore() {
		return pointsObtained/pointsPossible;
	}
}
