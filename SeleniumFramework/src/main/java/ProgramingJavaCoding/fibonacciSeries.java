package ProgramingJavaCoding;

public class fibonacciSeries {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int a = 0;
		int b = 1;
		int num;
		
		System.out.print(a+" "+b);
		
		for(int i = 1;i<=10;i++) {
			
			num=a+b;
			
			System.out.print(" "+num);
			
			a=b;
			b=num;
			
		}

	}

}
