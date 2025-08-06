package ProgramingJavaCoding;

public class reverseString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String str = "automation";
		
//		char[] ch = str.toCharArray();
//		
//		for (int i=ch.length -1 ; i>=0 ;i--) {
//			
//			System.out.print(ch[i]);
//			
//		}
		
//		StringBuffer str1 = new StringBuffer(str);
//		
//		str1.reverse();
//		
//		System.out.println(str1);
		
		StringBuilder str2 = new StringBuilder();
		str2.append(str);		
		str2 = str2.reverse();		
		System.out.println(str2);
		

	}

}
