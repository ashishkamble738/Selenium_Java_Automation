package ProgramingJavaCoding;

import java.util.Scanner;

public class stringPalindrome {
	
	public static void main(String[] args) {
	
	String Original, Reverse="";
	Scanner in = new Scanner(System.in);
	
	Original =  in.nextLine();
	
	int length = Original.length();
	
	for (int i=length-1;i>=0;i--) {
		Reverse =  Reverse + Original.charAt(i);
	}
	
	if(Original.equals(Reverse)) {
		System.out.println("String is Palindrome");
	}else {
		System.out.println("String is not Palindrome");
	}	

}
	
}
