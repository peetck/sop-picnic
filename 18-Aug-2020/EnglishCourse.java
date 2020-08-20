
public class EnglishCourse extends Course {
	
	public EnglishCourse(String title, String courseId ) {
		super(title, courseId);
	}
	
	
	public EnglishCourse(EnglishCourse engCourse) {
		super(engCourse);
	}
	
	
	public EnglishCourse clone() {
		return new EnglishCourse(this);
	}
	
	public void printCourseDetail() {
		System.out.println();
		System.out.println(this);
		System.out.printf("Title: %s, CourseID: %s\n", title, courseId);
		System.out.println();
	}

}
