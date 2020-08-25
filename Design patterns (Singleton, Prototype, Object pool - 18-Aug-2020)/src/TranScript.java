
public class TranScript {
	
	private static TranScript instance;
	
	private TranScript() {
		//
	}
	
	public static TranScript getInstance() {
		if (instance == null) {
			TranScript transcript = new TranScript();
			instance = transcript;
			System.out.println("Create TranScript instance : " + instance);
			return instance;
		}
		System.out.println("Return existing TranScript instance : " + instance);
		return instance;
	}
	
}
