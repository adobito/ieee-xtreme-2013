import java.util.Scanner;


public class Solution {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int amount = Integer.parseInt(in.nextLine());
		String[] str = in.nextLine().trim().split(" ");
		int[] speeds = new int[amount];
		for(int i = 0; i < speeds.length; i++) {
			speeds[i] = Integer.parseInt(str[i]);
			
		}
		System.out.println(dp(0,speeds.length - 1, speeds));

	}

	private static int dp(int count, int index, int[] array) { {
		if(index < 0) {
			return count;
		}
		count = count + array[index];
		return Math.max(count,dp(count,--index,array));
	}
		
	}
}
