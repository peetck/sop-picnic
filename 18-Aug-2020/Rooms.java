import java.util.*;
public class Rooms {
	
	private static Rooms instance;
	
	private List<Room> rooms;
	
	private Rooms(int size) {
		rooms = new ArrayList<Room>();
		for (int i = 0; i < size; i++) {
			rooms.add(new Room((i + 1) + ""));
		}
	}
	
	public static Rooms getInstance() {
		if (instance == null) {
			return new Rooms(5);
		}
		return instance;
	}
	
	public Room acquire() {
		System.out.println();
		System.out.printf("room left : %d\n", rooms.size());
		Room takeRoom = rooms.get(0);
		rooms.remove(0);
		System.out.printf("take %s\n", takeRoom.name);
		System.out.printf("room left : %d\n", rooms.size());
		System.out.println();
		return takeRoom;
	}
	
	public void release(Room relRoom) {
		System.out.println();
		System.out.printf("Release %s\n", relRoom.name);
		rooms.add(relRoom);
		System.out.printf("room left : %d\n", rooms.size());
		System.out.println();
	}
	
	

}
