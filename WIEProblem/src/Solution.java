import java.util.ArrayList;
import java.util.Scanner;


public class Solution {

	public static void main(String[] args) {
		double accKm = 2.7;
		double deaccKm = 3.8;
		double acc = accKm/3.6;
		double deacc = deaccKm/3.6;

		double accRatio = deaccKm / (accKm + deaccKm);
		double deaccRatio = 1 - accRatio;

		Scanner in = new Scanner(System.in);
		try {
			String[] str = in.nextLine().split(" ");
			int trains = Integer.parseInt(str[0]);
			if(trains < 1 || trains > 5) {
				throw new Exception();
			}
			int count = 0;
			for(int i = 1; i < str.length; i++) {
				int curr = Integer.parseInt(str[i]);
				if(curr< 500)
					throw new Exception();
				count += curr;
			}

			if(count != 100000) {
				throw new Exception();
			}



		}
		catch(Exception e) {
			System.out.println("ERROR");
		}

	}

}
