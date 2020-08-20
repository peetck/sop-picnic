import java.util.*;
public class Main {
	public static void main(String[] args) {
		
		// Singleton
		DBConnector database = DBConnector.getInstance();
		
		// Prototype
		
		EnglishCourse eng1 = new EnglishCourse("English 101", "01");
		eng1.printCourseDetail();
		EnglishCourse eng2 = eng1.clone();
		eng2.printCourseDetail();
		
		// Object pool
		Rooms rooms = Rooms.getInstance();
		
		// get 1 room
		Room room1 = rooms.acquire();
		Room room2 = rooms.acquire();
		
		// release 1 room
		rooms.release(room1);
	}
}
