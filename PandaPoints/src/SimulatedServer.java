public class SimulatedServer {
		
	private Hashtable profileHT;
	private int pointsForFreePass;
	private int timeLeftInDay;
	private int pointsMultiplier;
		
	public SimulatedServer() {
		profileHT = new Hashtable();
		pointsForFreePass = 150;
		pointsMultiplier = 1;
	}
	
	public int getTimeLeftInDay() {
		return timeLeftInDay;
	}
	
	private Profile getProfile(String username, String password) {
		String login = username + password;
		return profileHT.getProfile(login);
	}
	
	public String getName(String username, String password) {
		Profile p = getProfile(username, password);
		if (p != null) {
			return p.getName();
		} else {
			return null;
		}
	}
	
	public Integer getFreePasses(String username, String password) {
		Profile p = getProfile(username, password);
		if (p != null) {
			return p.getFreePasses();
		} else {
			return null;
		}
	}
	
	public Integer getPoints(String username, String password) {
		Profile p = getProfile(username, password);
		if (p != null) {
			return p.getPoints();
		} else {
			return null;
		}
	}
	
	public void ride(String username, String password) {
		Profile p = getProfile(username, password);
		p.ride(pointsMultiplier, pointsForFreePass);
	}
	
}