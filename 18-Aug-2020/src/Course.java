
public abstract class Course {
	
	public String title;
	public String section;
	
	
	public Course(String title, String section) {
		this.title = title;
		this.section = section;
	}
	
	public Course(Course course) {
		this.title = course.title;
		this.section = course.section;
	}
	
	public abstract Course clone();
	
	
}
