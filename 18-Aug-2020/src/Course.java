
public abstract class Course {
	
	public String title;
	public String courseId;
	
	
	public Course(String title, String courseId) {
		this.title = title;
		this.courseId = courseId;
	}
	
	public Course(Course course) {
		this.title = course.title;
		this.courseId = course.courseId;
	}
	
	public abstract Course clone();
	
	
}
