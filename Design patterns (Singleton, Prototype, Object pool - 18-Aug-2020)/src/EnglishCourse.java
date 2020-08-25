
public class EnglishCourse extends Course {
	
	public EnglishCourse(String title, String section ) {
		super(title, section);
	}
	
	
	public EnglishCourse(EnglishCourse engCourse) {
		super(engCourse);
	}
	
	
	public EnglishCourse clone() {
		return new EnglishCourse(this);
	}
	
	public void printCourseDetail() {
		System.out.println(this);
		System.out.printf("Title: %s, Section: %s\n\n", title, section);
	}

}
