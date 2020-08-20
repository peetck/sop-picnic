
public class DBConnector {
	
	private static DBConnector instance;
	
	private DBConnector() {
		//
	}
	
	public static DBConnector getInstance() {
		if (instance == null) {
			return new DBConnector();
		}
		return instance;
	}
	
}
