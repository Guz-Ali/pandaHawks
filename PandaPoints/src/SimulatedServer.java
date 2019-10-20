import java.util.*;

public class SimulatedServer {
		
	private Hashtable profileHT;
	private int freeRidePoints;
	private int timeLeftInDay;
	private int pointsMultiplier;
	private boolean rodeToday;
	int streak;
		
	public SimulatedServer() {
		profileHT = new Hashtable();
		freeRidePoints = 500;
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
			return 0;
		}
	}
	
	public Integer getPoints(String username, String password) {
		Profile p = getProfile(username, password);
		if (p != null) {
			return p.getPoints();
		} else {
			return 0;
		}
	}
	
	public void ride(String username, String password) {
		Profile p = getProfile(username, password);
		p.ride(pointsMultiplier, freeRidePoints);
	}
	
	public void createProfile(String username, String password, String name) {
		profileHT.createProfile(username + password, name);
	}
	
	public int getStreak(boolean checkDate, String username, String password){
		Profile p = getProfile(username, password);
		if (p != null) {
			Date date1 = new Date();
		String myDate1 = date1.toString();
		String str1 = myDate1.substring(0,3);

		while(checkDate == true){				// So we can only run this when necessary
												// Server can utilize this at end of a day





			long a = System.currentTimeMillis();	
    		long b = System.currentTimeMillis();		// Wait 10 seconds between checks to reduce spam
    		while ((b - a) <= 10000)			//
    		{
        		b = System.currentTimeMillis();		//
    		}

		Date date2 = new Date();
		String myDate2 = date2.toString();
		String str2 = myDate2.substring(0,3);

		System.out.println("Today is: "+str2);

		if(!(str1.equals(str2))){ 			// If the day changes, either reset streak or increment streak!
			if(rodeToday){
				streak++;
				rodeToday = false;
			}
			else{
				streak = 0;
			}

			
			str1 = str2; 			// Set str 1 to str2 so that you can compare it to a new date
						 	// (STR 2 will be reprinted from the computer's clock)
			

		}
	//	System.out.println(streak); 		// Print out the streak
		
		//if(str1 != str2)
		checkDate = false;
		}
		return streak;	
				}

		else {
			return 0;
		}
	}
}
