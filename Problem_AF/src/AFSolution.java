import java.util.Scanner;


public class AFSolution {
	
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		//Values
	//	int[] values = new int[1337];
		
		int t = Integer.parseInt(in.nextLine());
		
		
		
		for(int i = 0; i<t; i++){
			int n = Integer.parseInt(in.nextLine());
			
			int count = 1;
			int j = 1;
			boolean dir = true; //true clockwise, false counter clowise
			while(count < n){
				
				if(j == 0)
					j = 1337;
				if(j == 1338)
					j=1;
				
				if(isDivisible(count) || containsSeven(count)){
					dir = !dir;
				}
				
				count++;
				
				if(dir == true){
					j++;
				}
				else{
					j--;
				}
				
				
				
				
			}
			System.out.println(j);
			
			
		}
		
	}
	
	public static boolean isDivisible(int i){
		return i % 7 == 0;
	}
	
	public static boolean containsSeven(int i){
		return String.valueOf(i).contains("7");
	}
}
