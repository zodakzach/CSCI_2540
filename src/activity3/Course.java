package activity3;

public class Course {
	
	private String courseNo, title;
	private int credit;
	
	public Course(String courseNo, String title) {
		this.courseNo = courseNo;
		this.title = title;
		credit = 3;
	}
	
	public Course(String courseNo, String title, int credit) {
		this.courseNo = courseNo;
		this.title = title;
		this.credit = credit;
	}
	
	public String getCourseNo() {
		return courseNo;
	}
	
	public String getTitle() {
		return title;
	}
	
	public int getCredit() {
		return credit;
	}
	
	public void setTitle(String newTitle) {
		title = newTitle;
	}
	
	public void setCredit(int newCredit) {
		credit = newCredit;
	}
	
	public String toString(){
		return courseNo + " - " + title + "(" + credit + ")";
	}
	
	public void printInfo() {
		System.out.println(courseNo + " - " + title);
	}
	
	
}
