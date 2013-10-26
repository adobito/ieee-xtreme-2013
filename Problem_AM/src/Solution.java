import java.util.ArrayList;
import java.util.Scanner;


public class Solution {
	public static ArrayList<Pair> gList;
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int first = in.nextInt();
		int second = in.nextInt();
		in.nextLine();
		int[][] arr = new int[first][second];
		for(int i = 0; i < first; i++) {
			for(int j = 0; j < second; j++) {
				arr[i][j] = in.nextInt();
			}
		}
		Thingy thingy = new Thingy(Integer.MAX_VALUE,null);
		for(int i = 0; i < second; i++) {
			Thingy currThingy = recursiveThingy(0, i, 0,arr,new ArrayList<Pair>());
			if(thingy.value > currThingy.value) {
				thingy = currThingy;
			}
		}
		System.out.print("Minimum risk path = ");
		for(Pair p: thingy.list) {
			System.out.print(p);
		}
		System.out.println();
		System.out.println("Risks along the path = " + thingy.value);
		


	}
	
	@SuppressWarnings("unchecked")
	private static int recursive(int x, int y, int count, int[][] arr,ArrayList<Pair> list) { 
		int value = Integer.MAX_VALUE;
		
		if( y < 0 || y >= arr[0].length) {
			return Integer.MAX_VALUE;
		}
		if(x == arr.length)
			return count;
		list.add(new Pair(x,y));
		value = Math.min(value, recursive(x + 1, y - 1, count + arr[x][y],arr,(ArrayList<Pair>) list.clone()));
		value = Math.min(value, recursive(x + 1, y, count + arr[x][y],arr,(ArrayList<Pair>) list.clone()));
		value = Math.min(value, recursive(x + 1, y + 1, count + arr[x][y],arr,(ArrayList<Pair>) list.clone()));
		return value;
	}
	
	@SuppressWarnings("unchecked")
	private static Thingy recursiveThingy(int x, int y, int count, int[][] arr,ArrayList<Pair> list) { 
		Thingy thingy = new Thingy(Integer.MAX_VALUE,null);//int value = Integer.MAX_VALUE;
		
		if( y < 0 || y >= arr[0].length) {
			return thingy;
		}
		if(x == arr.length)
			return new Thingy(count,list);
		list.add(new Pair(x,y));
		Thingy currThingy = recursiveThingy(x + 1, y - 1, count + arr[x][y],arr,(ArrayList<Pair>) list.clone());
		if(thingy.value > currThingy.value) {
			thingy = currThingy;
		}
		currThingy = recursiveThingy(x + 1, y, count + arr[x][y],arr,(ArrayList<Pair>) list.clone());
		if(thingy.value > currThingy.value) {
			thingy = currThingy;
		}
		currThingy = recursiveThingy(x + 1, y + 1, count + arr[x][y],arr,(ArrayList<Pair>) list.clone());
		if(thingy.value > currThingy.value) {
			thingy = currThingy;
		}
		
		//value = Math.min(value, recursive(x + 1, y - 1, count + arr[x][y],arr,(ArrayList<Pair>) list.clone()));
		//value = Math.min(value, recursive(x + 1, y, count + arr[x][y],arr,(ArrayList<Pair>) list.clone()));
		//value = Math.min(value, recursive(x + 1, y + 1, count + arr[x][y],arr,(ArrayList<Pair>) list.clone()));
		return thingy;
	}

	static class Thingy {
		int value;
		ArrayList<Pair> list;
		
		public Thingy(int value, ArrayList<Pair> list) {
			this.value = value;
			this.list = list;
		}
	}
	static class Pair {
		int x;
		int y;
		public Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
		@Override
		public String toString() {
			return "[" + x + "," + y + "]";
		}
	}
}
