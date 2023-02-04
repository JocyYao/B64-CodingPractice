
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
//import java.util.Random;

class Feb3_Question_override extends Feb3_Question{
	@Override
	public void displayInfo() {
		System.out.println("I am the child");
	}
}

class Feb3_Question {

	//Q1.Find All substring of string in java Program
	public List<String> subStr(String s) {
		List<String> lis = new ArrayList();;
		//String a = "";
		for(int i = 0; i <= s.length(); i++) {
			for (int j = i+1; j <= s.length(); j++) {
				lis.add(s.substring(i,j));
				//System.out.println(x);
			}
		}
		System.out.println(lis);
		return lis;
	} 
	//Q2
	public String revStr(String s) {
		String a = "";
		for(int i = s.length()-1; i>=0 ; i--) {
			a = a+ s.charAt(i);
			
			
		}
		return a;
	}
		
	public boolean palindrome(int i) {
		int size = Integer.toString(i).length();
		int size1 = (size-1)/2;
		if(size % 2 ==1) {
			System.out.println(Integer.toString(i).substring(0, size1));
			System.out.println(revStr(Integer.toString(i).substring(size1+1, size)));
			if (Integer.toString(i).substring(0, size1).equals(revStr(Integer.toString(i).substring(size1+1, size)))) {
				System.out.println("palindrome!");
				return true;
			}
			
		}		
		System.out.println("Not palindrome!");
		return false;
	}
	
	
	public int[][] addMatrix(int a[][], int b[][]) {
		//size
		int rows = a.length;
		int cols = a[0].length;
		int result[][]=new int[rows][cols];
		
		
		//adding and printing addition of 2 matrices    
		for(int i=0;i<rows;i++){    
			for(int j=0;j<cols;j++){    
				result[i][j]=a[i][j]+b[i][j];    //use - for subtraction  
				System.out.print(result[i][j]+" ");    
		}    
		System.out.println();
		}    
		//System.out.println(result);   
		return result;
		}
	
	public int[][] multiMatrix(int a[][], int b[][]) {
		//size 2*3 3*2
		System.out.println("Q5");
		int rows1 = a.length; //2
		int cols1 = a[0].length; //3
		int rows2 = b.length; //3
		int cols2 = b[0].length; //2
		int result[][]=new int[rows1][cols2]; //2*2
		
		
		//adding and printing addition of 2 matrices    
		for (int i = 0; i < rows1; i++) {
            for (int j = 0; j < cols2; j++) {
                for (int k = 0; k < rows2; k++) {
                    result[i][j] += a[i][k] * b[k][j];}
                System.out.print(result[i][j]+" "); 
            }
            System.out.println(); 
            
        }
 
		return result;
		}    
		//System.out.println(result);   
		public String replaceStr(String s, String oldStr, String newStr) {
			System.out.println( s.replace(oldStr, newStr));
			return s.replace(oldStr, newStr);
		}

		public void randomNum() {
			int max = 100;
			int min = -10;
			Random dice = new Random();    
			int r = dice.nextInt(max + 1 - min) + min;
			System.out.println("random number: "  +  r);
		}
        
		public int binarySearch(int arr[], int first, int last, int key) {
			 Arrays.sort(arr);
			if(last > first) {
				int mid = first + (last - first)/2;
				//when we find the key value in the set, return the index
				if (arr[mid] == key) {
					System.out.println("key value at: " + mid);
					return mid;
				}
				//if the middle number larger than what we need....focus on the left side
				if(arr[mid] > key) {
					return binarySearch(arr, first, mid - 1, key);
				}
				//if the middle number smaller than what we need....focus on the right side
				else {
					return binarySearch(arr, mid+1, last, key);
				}
			}
			System.out.println("Key Not Found!");
			return -1;
		}
		
		public void connectJDBC(String name, int age, String address, float GPA) {
			Connection conn = null;
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
			}catch(ClassNotFoundException e) {
				
				System.out.println(e.getMessage());
			}
			
			try {
				conn = DriverManager.getConnection(
						"jdbc:mysql://localhost:3306/batch64?useSSL = false &allowPublicKeyRetrieval = true", 
						"root", "Gd919yds922");
			}catch(SQLException e) {
				System.out.println(e.getMessage());
			}
			
			try {
				PreparedStatement ps = conn.prepareStatement("Insert into student values(?,?,?,?)");
				ps.setString(1, name);
				ps.setInt(2, age);
				ps.setString(3, address);
				ps.setFloat(4, GPA);
				int x = ps.executeUpdate();
				
				if (x > 0) {
					System.out.println("Data Inserted");
				}else {
					System.out.println("Nothing Inserted");
				}
				
			}catch(SQLException e) {
				e.printStackTrace();
			}catch(Exception e1) {
				e1.printStackTrace();
			}	
			
		}
		
		public void displayInfo() {
		      System.out.println("I am the parent.");
		   } 

	public static void main(String[] args) {
		Feb3_Question myClass = new Feb3_Question();
		String s = "abcdefg";
		int i = 1234321;
		//Q1
		myClass.subStr(s);
		//Q2
		myClass.revStr(s);
		//Q3
		myClass.palindrome(i);
		
		
		//Q4
		int[][] first = { {2, 3, 4}, {5, 2, 3} }; //2*3
        int[][] second = { {-4, 5}, {5, 6}, {5, 6} }; // 3*2
        int[][] third = { {2, 3, 4}, {5, 2, 3} }; //2*3
        int[][] forth = { {2, 3, 4}, {5, 2, 3}  }; // 3*2
        myClass.addMatrix(third, forth); 
        //Q5
        myClass.multiMatrix(first, second);
        
        //Q6
        myClass.replaceStr(s, "b", "<new string in>");
        
        //Q7
        myClass.randomNum();
        
        //Q8
        int[] arr = {10, 20, 40, 50, 60 ,200, 109};
        myClass.binarySearch(arr, 0, arr.length, 32);
        
        //Q9
        
        //myClass.connectJDBC("Bella", 10, "CA", 4.0f);
        
        //Q10
        Feb3_Question myClass2 = new Feb3_Question_override();
        Feb3_Question_override myClass3 = new Feb3_Question_override();
        Feb3_Question myClass4 = new Feb3_Question();
        myClass2.displayInfo();
        myClass3.displayInfo();
        myClass4.displayInfo();
	}
   
	}


	




