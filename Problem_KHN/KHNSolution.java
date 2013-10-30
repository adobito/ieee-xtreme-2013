import java.util.ArrayList;
import java.util.Scanner;


public class KHNSolution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		
		String line = in.nextLine();
		String[] params = line.split(",");
		
		int lbound = Integer.parseInt(params[0]);
		int ubound = Integer.parseInt(params[1]);
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		for(int i = lbound; i < ubound+1; i++){
			list.add(i);
		}
		
		int count = 0;
		for(Integer e: list){
			
			if(isPalindrome(e)){
				count++;
			}
			
		}
		System.out.println(count);
		
		
	}

	private static boolean isPalindrome(Integer e) {
	
		
		String str = Integer.toBinaryString(e);
		for(int i=0,j=str.length()-1; i<str.length(); i++, j--){
			if(str.charAt(i) != str.charAt(j)){
				return false;
			}
		}
		return true;
	}

}
