import java.util.Scanner;


public class Solution {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		String[] str = in.nextLine().trim().split(" ");
		int x = Integer.parseInt(str[1]);
		int y = Integer.parseInt(str[0]);
		char[][] map = new char[y][x];
		Pair[][] visited = new Pair[y][x];
		int sx = 0;
		int sy = 0;
		for(int i = 0; i < y; i++) {
			String curr = in.nextLine();
			for(int j = 0; j < x; j++) {
				if(curr.charAt(j) == 'S'){
					sx = j;
					sy = i;
				}
				visited[i][j] = new Pair(Float.MAX_VALUE,Float.MAX_VALUE);;
				map[i][j] = curr.charAt(j);
			}
		}
		visited[sy][sx].days = 0;
		float val = traverseOasis(sx, sy, 0,0, visited, map);
		if(val > 0 && val < Float.MAX_VALUE - 1)
			System.out.println(val);
		else System.out.println("IMPOSSIBLE");
	}
	public static float traverseOasis(int x, int y, float count, float daysWoutWater, Pair[][] visited, char[][] map) {
		if(x >= map[0].length || y >= map.length || x < 0 || y < 0) {
			return -1;
		}
		if(visited[y][x].days < count && visited[y][x].thirst < daysWoutWater) {
			return -1;
		}if(daysWoutWater > 5)
			return -1;
		if(map[y][x] == 'E') {
//			for(int i = 0; i < visited.length; i++) {
//				for(int j = 0; j < visited[0].length;j++) {
//					visited[i][j] = 0;
//				}
//			}
			return count;
		}
		if(map[y][x] == '+') {
			daysWoutWater = 0;
			//count++;
		}
		//float old = visited[y][x];
		visited[y][x].thirst = daysWoutWater;
		visited[y][x].days = count;
		float value = Float.MAX_VALUE;
		float currValue = 0;
		for(int i = -1; i < 2; i++) {
			for(int j = -1; j < 2; j++) {
				float extraCount = 1;
				if(Math.abs(i) == Math.abs(j)) {
					if( i != 0) {
						extraCount = 1.5f;
					}

				}
				currValue = traverseOasis(x + j, y + i, extraCount + count, daysWoutWater + extraCount, visited, map);
				if(currValue > 0) {
					value = Math.min(value, currValue);
				}

			}
		}
		//visited[y][x] = old;
		return value;
	}
	public static float[][] copyOf(float[][] arr) {
		float[][] newArr = new float[arr.length][arr[0].length];
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr[0].length; j++) {
				newArr[i][j] = arr[i][j];
			}
		}
		return newArr;
		
	}
	public static String floatToOneDecimal(float num) {
		num *= 10;
		num = Math.round(num);
		String fltNum = (num/10 + "") + (num%10 + "");
		for(int i = 0; i < fltNum.length(); i++) {
			if(fltNum.charAt(i) == '.') {
				return fltNum.substring(0, i + 2);
			}
		}
		return fltNum;
	}
	static class Pair {
		float days;
		float thirst;
		
		public Pair(float days, float thirst) {
			this.days = days;
			this.thirst = thirst;
		}
	}
	
}
