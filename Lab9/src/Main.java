import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;
import java.util.TreeSet;

import student.Song;

public class Main {

	//Task 3: Testing Method
	//Programmed by Thomas Powis
	public static void test() {
		
		//First create the ten test cases this is going to be 10 text files
		
		//Next create the correct answer for each of the ten test cases
		String[] answers = {"Joker", "Inception", "Braveheart", "", "", "", "", 
		                    "", "", ""};
		
		//Finally print out each of the methods results compared against the correct answer
		for(int i = 0; i < 10; i++) {
			//Creating the variable to pass into the ReadIn method
			String read = "Test" + (i+1) + ".txt";
			
			//Passing the correct text file for each test case into the ReadIn method
			TreeMap<String, TreeSet<String>> temp = ReadIn(read);
			
			//Create an array of student names using the TreeMap
			ArrayList<String> myKeys = new ArrayList<>(temp.keySet());
			String[] studentNames = new String[myKeys.size()];
			myKeys.toArray(studentNames);
			
			//Implementation method takes in array of student names and TreeMap
			
			//Next pass the TreeMap and Array into the implementation method to get the movie to watch
			String result = rank(studentNames, temp);
			
			System.out.println("Methods answer: " + result);
			System.out.println("Correct Answer: " + answers[i]);
		}
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		test();

	}

}
