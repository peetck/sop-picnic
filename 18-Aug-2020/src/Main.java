import java.util.*;
public class Main {
	public static void main(String[] args) {


		System.out.println("\n======== Singleton Pattern ========\n");
		TranScript transcript = TranScript.getInstance();
		TranScript transcript01 = TranScript.getInstance();

		System.out.println("\n======== Prototype Pattern ========\n");
		EnglishCourse eng1 = new EnglishCourse("English 101", "01");
		eng1.printCourseDetail();
		EnglishCourse eng2 = eng1.clone();
		eng2.printCourseDetail();
		eng2.section = "02";
		eng2.printCourseDetail();

		System.out.println("\n======== Object Pool Pattern ========\n");
		Rooms rooms = Rooms.getInstance();
		Room room1 = rooms.acquire();
		Room room2 = rooms.acquire();
		rooms.release(room1);
	}
}
