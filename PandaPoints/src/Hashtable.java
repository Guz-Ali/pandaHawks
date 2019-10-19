import java.util.ArrayList;

public class Hashtable {
	
	private Node[] indices;
	private ArrayList<Profile> profiles;
	private int count;
	
	public Hashtable(int buckets) {
		indices = new Node[buckets];
		profiles = new ArrayList<Profile>();
		count = 0;
		for (int i = 0; i < buckets; i++) {
			indices[i] = null;
		}
	}
	
	public int getLength() {
		return count;
	}
	
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
			}
			last_n = n;
			n = n.getNext();
			count--;
		}
		return false;
	}
	
}