import java.util.Scanner;


public class Solution {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		String[] str = in.nextLine().trim().split(" ");
		int x = Integer.parseInt(str[1]);
		int y = Integer.parseInt(str[0]);
		char[][] map = new char[y][x];
		float[][] visited = new float[y][x];
		int sx = 0;
		int sy = 0;
		for(int i = 0; i < y; i++) {
			String curr = in.nextLine();
			for(int j = 0; j < x; j++) {
				if(curr.charAt(j) == 'S'){
					sx = j;
					sy = i;
				}

				map[i][j] = curr.charAt(j);
			}
		}
		visited[sy][sx] = 0;
		float val = traverseOasis(sx, sy, 0,0, visited, map);
		if(val > 0 && val < Float.MAX_VALUE)
		System.out.println(floatToOneDecimal(val));
		else System.out.println("IMPOSSIBLE");
	}
	public static float traverseOasis(int x, int y, float count, float daysWoutWater, float[][] visited, char[][] map) {
		if(x >= map[0].length || y >= map.length || x < 0 || y < 0) {
			return -1;
		}
		if(visited[y][x] != 0 && visited[y][x] < count) {
			return -1;
		}if(daysWoutWater > 5)
			return -1;
		if(map[y][x] == 'E') {
			return count;
		}
		if(map[y][x] == '+') {
			daysWoutWater = 0;
			//count++;
		}
		visited[y][x] = count;
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
		return value;
	}
	public static String floatToOneDecimal(float num) {
		String fltNum = num + "";
		for(int i = 0; i < fltNum.length(); i++) {
			if(fltNum.charAt(i) == '.') {
				return fltNum.substring(0, i + 2);
			}
		}
		return fltNum;
	}
}