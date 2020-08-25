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
			instance = new Rooms(5);
			return instance;
		}
		return instance;
	}

	public void showCurrentRoomLeft(){
		System.out.print("Current room left : [");
		for (Room room : rooms){
			System.out.print(' ' + room.name + ' ');
		}
		System.out.println("]");
	}
	
	public Room acquire() {
		showCurrentRoomLeft();
		Room takeRoom = rooms.get(0);
		rooms.remove(0);
		System.out.printf("take [ %s ]\n", takeRoom.name);
		showCurrentRoomLeft();
		System.out.println();
		return takeRoom;
	}
	
	public void release(Room relRoom) {
		showCurrentRoomLeft();
		System.out.printf("Release [ %s ]\n", relRoom.name);
		rooms.add(relRoom);
		showCurrentRoomLeft();
		System.out.println();
	}
	
	

}
