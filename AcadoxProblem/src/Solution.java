import java.util.Scanner;
import java.util.Stack;


public class Solution {

	public static void main(String[] args) {


		Scanner in = new Scanner(System.in);



		for(int j = 0;in.hasNextLine(); j++) {
			String[] str = in.nextLine().split("\\s");
			Stack<Integer> st = new Stack<Integer>();

			try {
				//if(str.length > 20)
					//throw new Exception();
				for(int i = 0; i < str.length && i < 20; i++) {
					if(str[i].length() > 4) {
						if(!(str[i].charAt(0) == '-') || str[i].length() > 5)
							st.push(Integer.parseInt("0000"));
						st.push(Integer.parseInt("FFFF"));
							//throw new Exception();
					}
					if(isIntegerString(str[i])) {
						st.push(Integer.parseInt(str[i],16));
					}
					else if(str[i].length() == 1) {
						int first;
						int second;
						int result;
						switch(str[i].charAt(0)) {
						case '+':
							first = st.pop();
							second = st.pop();
							result = (short) (first + second);
							if(result < first || result < second) {
								result = Integer.MAX_VALUE;
							}
							st.push(result);
							break;
						case '-':
							first = st.pop();
							second = st.pop();
							result = (second - first);
							if(result < 0) {
								result = 0;
							}
							st.push(result);
							break;
						case '&':
							second = st.pop();
							first = st.pop();
							st.push((first & second));
							break;
						case '|':
							second = st.pop();
							first = st.pop();
							st.push((first | second));
							break;
						case 'X':
							second = st.pop();
							first = st.pop();
							st.push((first ^ second));
							break;
						case '~':
							first = st.pop();
							st.push( ~first);
							break;
						default:
							throw new Exception();
						}
					}
					else {
						throw new Exception();
					}
				}
				if(st.size() == 1) {
					System.out.println(hexStringTo4Places(Integer.toHexString(st.pop())).toUpperCase());
				}
				else {
					throw new Exception();
				}
			}
			catch(Exception e) {
				System.out.println("ERROR");
				continue;
			}
		}


	}

	private static boolean isIntegerString(String str) {
		try {
			Integer.parseInt(str,16);
			return true;
		}
		catch (Exception e ) {
			return false;
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
