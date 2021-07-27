package day1;
//Q4. Write a boolean method called copyOf(), which an int Array and returns a copy of the given
//array. The method's signature is as follows:
//public static int[] copyOf(int[] array)

public class q4 {
	public static void main(String args[]) {
		int [] arr= {7,9,23,12,98};
		int [] arr1= copyOf(arr);
		for(int i=0;i<arr.length;i++)
			arr[i] = 0;
		for(int i=0;i<arr.length;i++) {
			System.out.println(arr[i]+"  "+arr1[i]);
		}
	}
	public static int[] copyOf(int[] array) {
		int n = array.length;
		int [] newArr = new int[n];
		for(int i=0;i<n;i++) {
			newArr[i] = array[i];
		}
		return newArr;
	}
}
