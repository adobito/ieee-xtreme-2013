import java.util.ArrayList;
import java.util.Scanner;


public class Solution {

	public static void main(String[] args) {
		double accKm = 2.7;
		double deaccKm = 3.8;
		double topSpeedKm = 90;
		double acc = accKm/3.6;
		double deacc = deaccKm/3.6;
		double topSpeed = 90/3.6;

		double maxAccTime = topSpeedKm/accKm;
		double maxDeaccTime = topSpeedKm/deaccKm;

		double maxAccDistance = (acc * maxAccTime * maxAccTime)/2;
		double maxDeaccDistance = (deacc * maxDeaccTime * maxDeaccTime)/2;

		double accRatio = deaccKm / (accKm + deaccKm);
		double deaccRatio = 1 - accRatio;

		Scanner in = new Scanner(System.in);
		try {
			String[] str = in.nextLine().split(" ");
			int trains = Integer.parseInt(str[0]);
			if(trains < 1 || trains > 5) {
				throw new Exception();
			}
			int[] dist = new int[str.length - 1];

			for(int i = 1; i < str.length; i++) {
				dist[i-1] = Integer.parseInt(str[i]);
			}
			int count = 0;
			for(int i = 0; i < dist.length; i++) {
				int curr = dist[i];
				if(curr< 500)
					throw new Exception();
				count += curr;
			}


			if(count != 100000) {
				throw new Exception();
			}

			count = 0;

			//start seq
			int[][] times = new int[trains][dist.length * 2];
			for(int j = 0; j < trains; j++) {
				for(int i = 0; i < dist.length; i++) {
					count++;
					//System.out.println(count);
					times[j][i*2] = count;
					double time = count;
					if(dist[i] > maxAccDistance + maxDeaccDistance) {

						time += maxAccTime + maxDeaccTime;
						time += (dist[i] - maxAccDistance - maxDeaccDistance)/topSpeed;
						times[j][i*2 + 1] = (int) Math.round(time);
						//System.out.println(times[j][i*2 + 1]);

					}
					else {
						time += getTimeFromDistAcc(dist[i] * accRatio, acc);
						time += getTimeFromDistAcc(dist[i] * deaccRatio, deacc);
						times[j][i*2 + 1] = (int) Math.round(time);
						//System.out.println(times[j][i*2 + 1]);
					}
					count = times[j][i*2 + 1] + 120;
				}
			}
			for(int j = 0; j < trains; j++) {
				System.out.print((j+1) + " : *****");
				for(int i = 0; i < times[0].length; i+=2) {

					System.out.print(" - " +times[j][i]+  "  " +times[j][i+1]);	
				}
				System.out.println(" *****");
			}


		}
		catch(Exception e) {
			System.out.println("ERROR");
		}
	}
	private static double getTimeFromDistAcc(double dist, double acc) {
		return Math.sqrt(2*dist/acc);
	}
	static class Trip {
		int arrival;
		int departure;

		public Trip(int arrival, int departure) {
			this.arrival = arrival;
			this.departure = departure;
		}
	}
}
