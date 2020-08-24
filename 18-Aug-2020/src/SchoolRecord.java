
public class SchoolRecord {
	
	private static SchoolRecord instance;
	
	private SchoolRecord() {
		//
	}
	
	public static SchoolRecord getInstance() {
		if (instance == null) {
			SchoolRecord record = new SchoolRecord();
			instance = record;
			System.out.println("Create SchoolRecord instance : " + instance);
			return record;
		}
		System.out.println("Return existing SchoolRecord instance : " + instance);
		return instance;
	}
	
}
