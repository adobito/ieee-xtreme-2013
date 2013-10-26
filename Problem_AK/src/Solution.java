import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.TreeSet;


public class Solution {

	public static void main(String[] args) {
		HashMap<String,Node>  map = new HashMap<String,Node>(); 
		Scanner in = new Scanner(System.in);
		int num = Integer.parseInt(in.nextLine());
		for(int i = 1; i < num; i++) {
			String[] str = in.nextLine().split(" ");
			Node currNode = map.get(str[0]);
			if(currNode == null) {
				currNode = new Node(str[0]);
				map.put(str[0], currNode);
			}
			Node nextNode = map.get(str[1]);
			if(nextNode == null) {
				nextNode = new Node(str[1]);
				map.put(str[1], nextNode);
			}
			currNode.childList.add(nextNode);
			nextNode.parentList.add(currNode);
		}
		

	}
	static class Node{
		int timesReached;
		String name;
		ArrayList<Node> childList;
		ArrayList<Node> parentList;
		int value;
		TreeSet<String> set;

		public Node(String name) {
			timesReached = 0;
			this.name = name;
			childList = new ArrayList<Node>();
			parentList = new ArrayList<Node>();
			set = new TreeSet<String>();
			value = Integer.MAX_VALUE;
		}
		public int getValue() {
			return value;
		}
		public void setValue(int value) {
			this.value = value;
		}

		public ArrayList<Node> getChildList() {
			return childList;
		}


		public ArrayList<Node> getParentList() {
			return parentList;
		}

		public TreeSet<String> getSet() {
			return set;
		}
	}
}
