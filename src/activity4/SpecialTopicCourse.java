package activity4;

public class SpecialTopicCourse extends Course {
	
	private String topic;
	
	
	public String getTopic() {
		return topic;
	}
	
	public void setTopic(String newTopic) {
		topic = newTopic;
	}
	
	public SpecialTopicCourse(String courseNo, String title, String topic) {
		super(courseNo, title);
		this.topic = topic;
	}
	
	public SpecialTopicCourse(String courseNo, String title, String topic, int credit) {
		super(courseNo, title, credit);
		this.topic = topic;
	}
	
	@Override
	public String toString() {
		return getCourseNo() + " - " + getTitle() + " (" + getCredit() + ") " + "(Topic: " + topic + ")";
	}
	
	@Override
	public void printInfo() {
		System.out.println(getCourseNo() + " - " + getTitle() + " (Topic: " + topic + ")");
	}
	
	public boolean equals(Object A) {
		if(A == null) {
			return false;
		}
		if(A instanceof SpecialTopicCourse){ 
			SpecialTopicCourse temp = (SpecialTopicCourse)A;
			return ((temp.getCourseNo().equals(getCourseNo())) && (this.topic.equals(temp.topic)));
		}
		else {
			return false;
		}
	}	

}
