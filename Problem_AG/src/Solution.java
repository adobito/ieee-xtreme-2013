import java.util.Scanner;


public class Solution {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while(in.hasNext()) {
			String[] str = in.nextLine().split(" ");
			if(str[0].equals("0") && str[0].equals("0")) {
				break;
			}
			
		}
	}
	
	public static Thing recursive(int currX, int currY,boolean isDown, int turnCount, int numOfTurns, int n, Thing thing) {
		
		if(isDown) {
			recursive(currX, currY + 1)
		}
		
	}
	static class Thing {
		int count;
		
		public Thing() {
			count = 0;
		}
		
	}
}
