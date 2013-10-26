import java.util.Scanner;


public class Solution {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while(in.hasNext()) {
			String[] str = in.nextLine().trim().split(" ");
			if(str[0].equals("0") && str[1].equals("0")) {
				break;
			}
			int n = Integer.parseInt(str[0]);
			int turnsWanted = Integer.parseInt(str[1]);
			Thing thing = new Thing();
			recursive(1,2,true, 0, turnsWanted, n, thing );
			recursive(2,1,false, 0, turnsWanted, n, thing );

			System.out.println(thing.count);
			
		}
	}
	
	public static Thing recursive(int currX, int currY,boolean isDown, int turnCount,int turnsWanted, int n, Thing thing) {
		if(currX > n || currY > n) {
			return thing;
		}
		if(currX == n && currY == n) {
			if(turnCount == turnsWanted)
				thing.increment();
			return thing;
		}
		if(isDown) {
			recursive(currX, currY + 1, true, turnCount,turnsWanted, n, thing);
			recursive(currX + 1, currY, false, turnCount++,turnsWanted, n, thing);
		}
		else {
			recursive(currX, currY + 1, true, turnCount++,turnsWanted, n, thing);
			recursive(currX + 1, currY, false, turnCount,turnsWanted, n, thing);
		}
		return thing;
		
	}
	static class Thing {
		int count;
		
		public Thing() {
			count = 0;
		}
		
		public Thing increment() {
			count++;
			return this;
		}
		
	}
}
