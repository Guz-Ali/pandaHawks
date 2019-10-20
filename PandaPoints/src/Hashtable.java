/**
 * @author Kramek
 * @version 10.19.2019
 */

import java.util.ArrayList;

public class Hashtable {
	
	private Node[] indices;
	private ArrayList<Profile> profiles;
	private int count;
	
	/**
	 * Initializes the Hashtable Class
	 * @param buckets The amount of buckets in / the length of the indices array.
	 */
	public Hashtable(int buckets) {
		indices = new Node[buckets];
		profiles = new ArrayList<Profile>();
		count = 0;
		for (int i = 0; i < buckets; i++) {
			indices[i] = null;
		}
	}
	
	public Hashtable() {
		indices = new Node[1000];
		profiles = new ArrayList<Profile>();
		count = 0;
		for (int i = 0; i < 1000; i++) {
			indices[i] = null;
		}
	}
	
	/**
	 * Returns the length of the profiles ArrayList.
	 * @return The length of the profiles ArrayList.
	 */
	public int getLength() {
		return count;
	}
	
	/**
	 * Returns a profile, if found, given the login parameter.
	 * @param login The username and password of the profile, both in one string.
	 * @return The profile associated with the username and password that comprises the login string, or null if none is found.
	 */
	public Profile getProfile(String login) {
		System.out.println("get hash: " + (login.hashCode() & 0xfffffff));
		int bidx = (login.hashCode() & 0xfffffff) % indices.length;
		System.out.println("get bidx: " + bidx);
		Node n = indices[bidx];
		while (n != null) {
			Profile p = profiles.get(n.getIndex());
			if ((login.hashCode() & 0xfffffff) == p.getSecurityHash()) {
				return p;
			}
			n = n.getNext();
		}
		return null;
	}
	
	/**
	 * Creates a profile with a specified login and name.
	 * @param login The username and password of the profile, both in one string.
	 * @param name The name of the person who owns the profile.
	 * @return True if the profile is created successfully, false if the profile already exists.
	 */
	public boolean createProfile(String login, String name) {
		System.out.println("create hash: " + (login.hashCode() & 0xfffffff));
		int bidx = (login.hashCode() & 0xfffffff) % indices.length;
		System.out.println("create bidx: " + bidx);
		Node n = indices[bidx];
		while (n != null) {
			Profile p = profiles.get(n.getIndex());
			if (login.hashCode() == p.getSecurityHash()) {
				return false;
			}
			n = n.getNext();
		}
		indices[bidx] = new Node(profiles.size(), indices[bidx]);
		profiles.add(new Profile(login.hashCode() & 0xfffffff, name));
		System.out.println(profiles.size());
		count++;
		return true;
	}
	
	/**
	 * Deleted the profile associated with the given login parameter, if any.
	 * @param login The username and password of the profile, both in one string.
	 * @return True if the profile is deleted successfully, false if the profile does not exist.
	 */
	public boolean deleteProfile(String login) {
		int bidx = (login.hashCode() & 0xfffffff) & indices.length;
		Node last_n = null;
		Node n = indices[bidx];
		while (n != null) {
			Profile p = profiles.get(n.getIndex());
			if (login.hashCode() == p.getSecurityHash()) {
				profiles.set(n.getIndex(), null);
				if (last_n != null) {
					last_n.setNext(n.getNext());
				} else {
					indices[bidx] = n.getNext();
				}
				return true;
			}
			last_n = n;
			n = n.getNext();
			count--;
		}
		return false;
	}
	
}