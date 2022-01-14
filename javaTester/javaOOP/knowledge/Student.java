package javaOOP;

public class Student {
	private int idStudent;
	private String nameStudent;
	private double principleScore;
	private double examineScore;

	protected Student(int idStudent, String nameStudent, double principleScore, double examineScore) {
		this.idStudent = idStudent;
		this.nameStudent = nameStudent;
		this.principleScore = principleScore;
		this.examineScore = examineScore;
	}

	protected void setIdStudent(int idStudent) {
		this.idStudent = idStudent;
	}

	protected int getIdStudent() {
		return idStudent;
	}

	protected void setNameStudent(String nameStudent) {
		this.nameStudent = nameStudent;
	}

	protected String getNameStudent() {
		return nameStudent;
	}

	protected double getPrincipleScore() {
		return principleScore;
	}

	protected void setPrincipleScore(double principleScore) {
		this.principleScore = principleScore;
	}

	protected double getExamineScore() {
		return examineScore;
	}

	protected void setExamineScore(double examineScore) {
		this.examineScore = examineScore;
	}
	
	protected double getAverageScore() {
		return (principleScore + examineScore * 2) / 3;
	}
	
	public String getRatingStudent() {
		String ratingStudent = null;
		if (getAverageScore() >= 0 && getAverageScore() < 5) {
			ratingStudent = "F";
		} else if (getAverageScore() >= 5 && getAverageScore() <= 6.5) {
			ratingStudent = "C";
		} else if (getAverageScore() > 6.5 && getAverageScore() <= 8) {
			ratingStudent = "B";
		} else if (getAverageScore() > 8 && getAverageScore() < 10) {
			ratingStudent = "A";
		} else {
			System.out.println("Input invalid");
		}
		return ratingStudent;
	}
}
