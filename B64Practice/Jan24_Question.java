package B64Practice;

import java.io.*;
import java.text.Collator;
import java.util.*;
import java.util.ArrayList;
import java.util.List;

public class Jan24_Question {
	
	public static void main(String args[])
	{
	    int arr[]={111, 13, 25, 9, 34, 1};
	    sor(arr);
	    swap_simp(1000,3444);
	    even(4);
	    top(1,2,3);
	    vowel('a');
	    vowel('b');
	}
	
	//DS1.3. Find Bigger number among two 
	public static Object bigger(int a, int b){
		if (a>b) {
			return a;
		}else if (a < b){
			return b;
		}else {
			return null;
		}
		}	  
			
	//DS1.4. Swap two number 
	public static void swap(int a, int b){
		int c = a;
		System.out.println("a is equal to " + a);
		System.out.println("b is equal to " + b);
		System.out.println("Sawping");
		a = b;
		b = c;
		System.out.println("a is equal to " + a);
		System.out.println("b is equal to " + b);
		}
		//DS1.5. Swap two numbers without using extra variable 
	public static void swap_simp(int x, int y){
		System.out.println("Before swapping:"
                + " x = " + x + ", y = " + y);
        x = x * y; 
        y = x / y; //assign y = x(x*y/y)
        x = x / y; //x = y(x*y/x) bc y = x has achieved
 
        System.out.println("After swapping:"
                           + " x = " + x + ", y = " + y);
         
		}
		//DS1.6. Check number is even or odd using ternary operatsor
	public static String even(int a){
		String Result = (a % 2 == 0) ? "even" :  "Odd";
		System.out.println(Result);
		return Result;
		}
		//DS1.7. Find Bigger number among three numbes
	public static int top(int a, int b, int c){
		ArrayList lis = new ArrayList();
		lis.add(a);
		lis.add(b);
		lis.add(c);
		Collections.sort(lis); 
		System.out.println("top among three is " + lis.get(2));
		return (int) lis.get(2);
		}
		//DS1.8. Find a character is vowel or consonant
	public static String vowel(char a){
		ArrayList<Character> arr = new ArrayList<>(); 
		arr.add('a');
		arr.add('e');
		arr.add('i');
		arr.add('o');
		arr.add('u');
		String result = (arr.contains(a))? "vowel" : "consonant";
		System.out.println(a + " is " + result);
 		return result;
		}
		
	public static void sor(int [] arr) {
		int n=arr.length;
		 
	    Arrays.sort(arr);
	   
	    System.out.println("Second smallest element is "+arr[1]);
	    System.out.println("second Largest element is "+arr[n-2]);
		
	}
	
	
	public static boolean anagram(String s1, String s2)  {
		char[] arr1 = s1.toCharArray();
		char[] arr2 = s1.toCharArray();
		List<Character> lis1 = new ArrayList<>();
		List<Character> lis2 = new ArrayList<>();
		for (char i: arr1)
		{
			lis1.add(i);
		}
		for (char i: arr2)
		{
			lis2.add(i);
		}
		
		Collections.sort(lis1); 
		Collections.sort(lis2);
		if (lis1 == lis2){
			System.out.println("anagram");
			return true;
					
		}else {
			System.out.println("not anagram");
			return false;
		}

	}
	
}
