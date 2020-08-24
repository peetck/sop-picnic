import java.util.*;
public class Main {
	public static void main(String[] args) {


		System.out.println("\n======== Singleton Pattern ========\n");
		SchoolRecord record1 = SchoolRecord.getInstance();
		SchoolRecord record2 = SchoolRecord.getInstance();

		System.out.println("\n======== Prototype Pattern ========\n");
		EnglishCourse eng1 = new EnglishCourse("English 101", "01");
		eng1.printCourseDetail();
		EnglishCourse eng2 = eng1.clone();
		eng2.printCourseDetail();

		System.out.println("\n======== Object Pool Pattern ========\n");
		Rooms rooms = Rooms.getInstance();
		Room room1 = rooms.acquire();
		Room room2 = rooms.acquire();
		rooms.release(room1);
	}
}
