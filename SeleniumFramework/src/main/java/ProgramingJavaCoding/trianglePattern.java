package ProgramingJavaCoding;

import java.util.Scanner;

public class trianglePattern {

	public static void main(String[] args) {
		// TODO Auto-generated method stub		
		int num;	
		Scanner in = new Scanner(System.in);
		num = in.nextInt();
		
		for(int i=1;i<=num;i++) {
			
			for(int j=num;j>i;j--) {
				System.out.print(" ");			
			}
			
			for(int k=1;k<=i;k++) {
				System.out.print(k +" ");
			}
			
			System.out.println("");
		}
		

	}

}
