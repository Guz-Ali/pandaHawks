public class Profile {
	
	private int securityHash;
	private String name;
	private int points;
	private int freePasses;
	private int ridePointValue;
	private boolean rodeToday;
	private boolean newFreePass;
	
	public Profile(int sh, String n) {
		securityHash = sh;
		name = n;
		points = 0;
		freePasses = 0;
		ridePointValue = 0;
		rodeToday = false;
		newFreePass = false;
	}
	
	public int getSecurityHash() {
		return securityHash;
	}
	
	public String getName() {
		return name;
	}
	
	public int getPoints() {
		return points;
	}
	
	public int getFreePasses() {
		return freePasses;
	}
	
	public int getRidePointValue() {
		return ridePointValue;
	}
	
	public boolean hasRiddenToday() {
		return rodeToday;
	}
	
	public boolean hasNewFreePass() {
		return newFreePass;
	}
	
	public void seenNewFreePass() {
		newFreePass = false;
	}
	
	public void ride(double pointMultiplier, int freeRidePoints) {
		points += (ridePointValue * pointMultiplier);
		rodeToday = true;
		if (points >= freeRidePoints) {
			points = points - freeRidePoints;
			freePasses++;
			newFreePass = true;
		}
	}
	
}
