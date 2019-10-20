import java.util.Scanner;
import java.io.*;

public class SimulatedClient {
	public static void main(String[] args) {

		String password="";
		String username="";
		String name="";
	//	String textUsername = "";
	//	String textPassword = "";
	//	String textName = "";
		int counter=1;
		SimulatedServer ss = new SimulatedServer();
	/*	
		try {
			Scanner sc = new Scanner("profiles.txt");
			
			while(sc.hasNextLine()) {
				textUsername = sc.nextLine();
				System.out.println(textUsername);
				textPassword = sc.nextLine();
				System.out.println(textPassword);
				textName = sc.nextLine();
				System.out.println(textName);
			}
			sc.close();
		}	
		catch(Exception e) {
			e.printStackTrace();		
		}
	*/	
		
		while(counter==1) {
		Scanner in = new Scanner(System.in);
		
		System.out.println("Username:");
		username = in.next();
		
		System.out.println("Password: ");
		password = in.next();
		
	//	ss.createProfile(textUsername,textPassword,textName);
		
		ss.createProfile("admin","password","HAHA");
		name =ss.getName(username, password);
		
		if(name==null) {
			System.out.println("Try again.");
			counter=1;
		}
		else 
			counter=-1;
		}
			
		System.out.println(name);
		
		
	
		Integer userStreak = ss.getStreak(true, username,password);
		System.out.println("Your streak time is: " + userStreak);
		Integer userPoints = ss.getPoints(username, password);
		System.out.println("You have " + userPoints+ " points.");
		Integer freePasses = ss.getFreePasses(username,password);
		System.out.println("You have " + freePasses + " free passes");
		
	}
}
