public class Profile {
	
	private int securityHash;
	private String name;
	private int points;
	private int freePasses;
	private int ridePointValue;
	private boolean riddenToday;
	private boolean newFreePass;
	private int streak;
	
	public Profile(int sh, String n) {
		securityHash = sh;
		name = n;
		points = 0;
		freePasses = 0;
		ridePointValue = 0;
		riddenToday = false;
		newFreePass = false;
		streak = 0;
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
		return riddenToday;
	}
	
	public boolean hasNewFreePass() {
		return newFreePass;
	}
	
	public void seenNewFreePass() {
		newFreePass = false;
	}
	
	public int getStreak() {
		return streak;
	}
	
	public void resetStreak() {
		streak = 0;
	}
	
	public void ride(double pointMultiplier, int freeRidePoints) {
		points += (ridePointValue * pointMultiplier);
		riddenToday = true;
		streak++;
		if (points >= freeRidePoints) {
			points = points - freeRidePoints;
			freePasses++;
			newFreePass = true;
		}
	}
	
}
