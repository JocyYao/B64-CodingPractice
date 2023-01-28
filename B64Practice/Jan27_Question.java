package B64Practice;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.w3c.dom.Node;

import com.mysql.cj.util.StringUtils;

public class Jan27_Question {

	// Remove All occurrences of given character 
	//from String?(Assume Accordingly)
	public static String removeOccur(String s, Character c) {
		String strNew = s.replaceAll(c.toString(), "");
		return strNew;
	}
	
	
	//How to swap 2 numbers without using 3rd variable?
	public static void swap(int a, int b) {
		System.out.println("Before Swapping a and b are: " + a + " " + b);
		a = a - b; //a = a - b
		b = a + b; //b = a
		a = b - a; //
		System.out.println("After Swapping a and b are: " + a + " " + b);
	}
	
	
	//How to remove whitespaces from a string?
	public static String removeWhiteSpace(String s) {
		String strNew = s.replaceAll(" ", "");
		return strNew;
	}
	
	//Check if two arrays contains same elements?
	public static boolean checkSameElmt(Object[]  a, Object[] b) {
		for (int i = 0; i < a.length ; i++) {
			if (Arrays.asList(b).contains(a[i])) {
				return true;
			}
		}
		return false;
	}
	
	//Find 3rd largest element in an integer array?
	public static Integer thirdLarge(Integer[] arr) {
		Arrays.sort(arr);
		return arr[arr.length-3];
	}
	
	//6. How to sort HashMap by using values?
	public static HashMap sortMap(HashMap<Integer, String> m) {
		// Stream result = m.entrySet().stream();
				 //.sorted(Map.Entry.<String, Integer>comparingByValue());
		
		// System.out.println(m.entrySet()[0].getValue());
		HashMap<Integer, String> map = m.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, 
                		(oldValue, newValue) -> oldValue, LinkedHashMap::new));
        //(oldValue, newValue) -> oldValue, LinkedHashMap::new
        //System.out.println(map);
		return map;
	}
	
	
	public static Boolean checkParen(String s) {
	//‘{‘,’}’,'(‘,’)’,'[‘,’]’.
		List<String> left = Arrays.asList("{", "(","[");
		List<String> right = Arrays.asList("}", ")","]");
		int l = 0;
		int r = 0;
		for (String i : s.split("")) {
			if (left.contains(i)) {
				l++;
			}
			else if(right.contains(i)) {
				r++;
			}
		}
		System.out.println(l + " " + r);
		if (l == r) {
			return true;
		}
		return false;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Q1
		System.out.println("Q1");
		String removeOccur = removeOccur("I am human being, and I want to eat pizza", 'a');
		System.out.println(removeOccur);
		//Q2
		System.out.println("Q2");
		swap(3,5);
		//Q3
		System.out.println("Q3");
		String nonWhite = removeWhiteSpace("I am human being, and I want to eat pizza");
		System.out.println(nonWhite);
		//Q4
		System.out.println("Q4");
		Integer arr1[] = { 1,2,3,4,5,6,7 };
		Integer arr2[] = {8,9,10};
		boolean hasSame = checkSameElmt(arr1, arr2);
		System.out.println(hasSame ? "has same" : "no same");
	
		
		//Q5
		System.out.println("Q5");
		Integer arr3[] = { 1,2,3,2,4,5,6,23,4,5,6,7 };
		thirdLarge(arr3);
		
		
		
		// Creating an empty HashMap
		System.out.println("Q6");
        HashMap<Integer, String> hash_map = new HashMap<Integer, String>();

        hash_map.put(10, "1");
        hash_map.put(15, "4");
        hash_map.put(20, "6");
        hash_map.put(25, "4");
        hash_map.put(30, "0");
        System.out.println("Initial Mappings are: " + hash_map);
        System.out.println("After Sorting Values: " + sortMap(hash_map));
        
        System.out.println("Q7");
        String s = "]sdva{dva[adfv]adfv}adfv)";
        String s2 = "{()}[]";
        System.out.println(checkParen(s)?"Valid":"Invalid");
        System.out.println(checkParen(s2)?"Valid":"Invalid");
	}
	}


