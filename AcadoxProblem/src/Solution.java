import java.util.Scanner;


public class Solution {

	public static void main(String[] args) {


		Scanner in = new Scanner(System.in);

		for(int i = 0; i < 20 && in.hasNext(); i++) {
			try {
				String[] str = in.nextLine().split("\\s");
				if(str.length == 0)
					continue;
				if(str.length == 1) {
					throw new Exception();
					//System.out.println(hexStringTo4Places(str[0]));
					//continue;
				}		
				String first;
				String second;
				String symbol;


				if(str.length == 2) {
					first = str[0];
					symbol = str[1];
					if(str[1].length() == 1 && str[1].charAt(0) == '~') {
						Long value = ~Long.parseLong(str[0]);

						System.out.println(hexStringTo4Places(Long.toHexString(value)).toUpperCase());
						continue;
					}
					else throw new Exception();
				}
				if(str.length > 3)
					throw new Exception();
				first = str[0];
				second = str[1];
				symbol = str[2];
				Long firstInt = Long.parseLong(first,16);
				Long secondInt = Long.parseLong(second,16);
				Long result = 0L;
				if(symbol.isEmpty() || symbol.length() > 1) {
					throw new Exception();				}
				switch(symbol.charAt(0)) {
				case '+':
					result = firstInt + secondInt;
					if(result < firstInt || result < secondInt)
						result = Long.MAX_VALUE;
					break;
				case '-':
					result = firstInt - secondInt;
					if (result < 0) 
						result = 0L;
					break;
				case '&':
					result = firstInt & secondInt;
					break;
				case '|':
					result = firstInt | secondInt;
					break;
				case 'X':
					result = firstInt ^ secondInt;
					break;
				default:
					throw new Exception();
				}
				if(str.length == 4) {
					if(str[3].length() == 1 && str[3].charAt(0) == '~')
						result = ~result;
				}
				System.out.println(hexStringTo4Places(Long.toHexString(result)).toUpperCase());
				continue;
			}
			catch(Exception e) {
				System.out.println("ERROR");
				continue;
			}
		}
	}
	private static String hexStringTo4Places(String hex) {
		if(hex.length() == 1) {
			return "000" + hex;
		}
		else if(hex.length() == 2) {
			return "00" + hex;
		}
		else if(hex.length() == 3) {
			return "0" + hex;
		}
		else return hex.substring(hex.length() - 4);
	}

}
