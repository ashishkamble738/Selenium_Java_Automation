package ProgramingJavaCoding;

public class highteslowestValue {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int arr[] = {23,56,874,23,34,136};
		int val1 = arr[0];
		int val2 = arr[0];
		
		
		for (int i=1; i<arr.length; i++) {
			
			if(arr[i]>val1) {
				val1 = arr[i];
			}
		}
		
		System.out.println("Highest number from array is: "+val1);
		
		for (int i=1; i<arr.length; i++) {
			
			if(arr[i]<val2) {
				val2 = arr[i];
			}
		}
		
		System.out.println("Lowest number from array is: "+val2);


	}

}
