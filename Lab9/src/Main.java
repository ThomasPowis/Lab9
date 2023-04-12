import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;
import java.util.TreeSet;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
	
	//Task 1 Reading the files 
	//by Anusha 
	public static TreeMap<String, TreeSet<String>> readStudentPreferences(String file) throws IOException {
        // create a new TreeMap to store the student names and their movie preferences
        TreeMap<String, TreeSet<String>> contents = new TreeMap<>();
        // create a new BufferedReader to read the file
        BufferedReader br = new BufferedReader(new FileReader(file));
        // read the file line by line
        String line = br.readLine();
        while (line != null) {
            // split each line into student name and their movie preferences
            String[] parts = line.split(":");
            // get the name of the student
            String name = parts[0];
            // get the list of movie preferences
            String[] movies = parts[1].split(", ");
            // create a new tree set to store the movie preferences
            TreeSet<String> movieSet = new TreeSet<>();
            // add each movie preference to the movieSet
            for (String movie : movies) {
                movieSet.add(movie);
            }
            // add the student and their movie preferences to the contents TreeMap
            contents.put(name, movieSet);
            // read the next line
            line = br.readLine();
        }
        // close the BufferedReader
        br.close();
        // return the contents TreeMap
        return contents;
    }


	//Helper method for Task 2
	public static TreeMap<String,Integer> rank(TreeMap<String,TreeSet<String>> s)
	{
		TreeMap<String,Integer> ranks=new TreeMap<String,Integer>();
		for(String student:s.keySet())
		{
			for(String movie:s.get(student))
			{
				if(!ranks.containsKey(movie))
				{
					ranks.put(movie, 1);
				}
				else 
				{
					ranks.put(movie, ranks.get(movie)+1);
				}
			}
		}
		return ranks;
	}
	
	//Helper method for Task 2
	public static boolean contains(String[] S,String target)
	{
		for(String s:S)
		{
			if(s==target)
			{

				return true;		
			}
				
		}
		return false;
	}
	
	//Task 2: Ranking the movies
	//Programmed by Nikki
	public static String MostPopular(TreeMap<String,TreeSet<String>> s,String[] students)
	{
		String max="";
		if(s.keySet().size()>0)
		{
		TreeMap<String,TreeSet<String>> currstudents=new TreeMap<String,TreeSet<String>>();
		for(String tempstudent:s.keySet())
		{
			if(contains(students,tempstudent))
			{
				currstudents.put(tempstudent, s.get(tempstudent));
			}
		}
		
		TreeMap<String,Integer> rankings=rank(currstudents);
		max=rankings.firstKey();
		for(String test:rankings.keySet())
		{
			if(rankings.get(test)>rankings.get(max))
			{
				max=test;
			}
		}
		}
		return max;
	}
	
	//Task 3: Testing Method
	//Programmed by Thomas Powis 
	public static void test() {
		
		//First create the ten test cases this is going to be 10 text files
		
		//Next create the correct answer for each of the ten test cases
		String[] answers = {"Joker", "Braveheart", "A Seperation", "Pulp Fiction", "The Godfather", "Shutter Isand", "Inception", 
		                    "M", "The Terminator", "The Shining"};
		
		//Finally print out each of the methods results compared against the correct answer
		for(int i = 0; i < 10; i++) {
			//Creating the variable to pass into the ReadIn method
			String read = "Test" + (i+1) + ".txt";
			
			//Passing the correct text file for each test case into the ReadIn method
			TreeMap<String, TreeSet<String>> temp = readStudentPreferences(read);
			
			//Create an array of student names using the TreeMap
			ArrayList<String> myKeys = new ArrayList<>(temp.keySet());
			String[] studentNames = new String[myKeys.size()];
			myKeys.toArray(studentNames);
			
			//Implementation method takes in array of student names and TreeMap
			
			//Next pass the TreeMap and Array into the implementation method to get the movie to watch
			String result = MostPopular(temp, studentNames);
			
			System.out.println("Methods Answer: " + result);
			System.out.println("Correct Answer: " + answers[i]);
		}
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		test();

	}

}
