import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeSet;


public class Solution {

	public static void main(String[] args) throws Exception {
		HashMap<String,Node> map  = new HashMap<String,Node>();
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String first = in.readLine();
		while(!in.ready());
		while(in.ready()) {
			String[] str = in.readLine().split(" ");
			if(str[0].equals("A") && str[1].equals("A")) {
				break;
			}
			Node currNode = map.get(str[0]);
			if(currNode == null) {
				currNode = new Node(str[0]);
				map.put(str[0], currNode);
			}
			Node secNode = map.get(str[1]);
			if(secNode == null) {
				secNode = new Node(str[1]);
				map.put(str[1], secNode);
			}
			secNode.list.add(currNode);
			currNode.getList().add(secNode);
		}
		traversal(map.get("F"),0,new TreeSet<String>(),first);
		Node endNode = map.get(first);
		if(endNode.timesReached > 0) {
			System.out.println("Total Routes: " + endNode.timesReached);
			System.out.println("Shortest Route Length: " + endNode.value);
			System.out.println("Shortest Route after Sorting of Routes of length "+endNode.value+": " + setPrint(endNode.set) + first);
		}
		else {
			System.out.println("No Route Available from F to " + first);
		}






	}
	private static void traversal(Node first,int count,TreeSet<String> set, String stop) {
		count++;			
		first.timesReached++;
		if(first.value >= count) {
			first.value = count;
			//System.out.println(setPrint(set) + " vs " + setPrint(first.set) + "=" + (setPrint(set)).compareTo(setPrint(first.set)));
			if(first.set.isEmpty() || set.size() < first.set.size() || (setPrint(set)).replace(" ", "").compareTo(setPrint(first.set).replace(" ", "")) < 0) {
				first.set = set;
			}

		}
		if(first.name.equals(stop) || set.contains(first.name))
			return;

		for(Node n: first.list) {
			TreeSet<String> newSet = (TreeSet<String>) set.clone();
			newSet.add(first.name);
			traversal(n,count,newSet, stop);
		}

	}

//	private static int strCompare(String one, String two)  {
//		for
//	}
	private static String setPrint(TreeSet<String> set) {
		String out = "";
		for(String s: set) {
			out += s + " ";
		}
		return out;
	}

	static class Node{
		int timesReached;
		String name;
		ArrayList<Node> list;
		int value;
		TreeSet<String> set;

		public Node(String name) {
			timesReached = 0;
			this.name = name;
			list = new ArrayList<Node>();
			set = new TreeSet<String>();
			value = Integer.MAX_VALUE;
		}
		public int getValue() {
			return value;
		}
		public void setValue(int value) {
			this.value = value;
		}

		public ArrayList<Node> getList() {
			return list;
		}

		public TreeSet<String> getSet() {
			return set;
		}
	}


}
