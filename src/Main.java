import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
	
	public static void main (String[] args){
		
		Scanner inputScanner = new Scanner(System.in);
		System.out.println("Enter Oregon Counties file which contains number of counties, names, and edges: ");
		String fileName = inputScanner.nextLine();
		try {
			Graph countyGraph = new Graph(fileName);
		} catch (FileNotFoundException e) {
			System.out.println(e.getClass() + " Please enter a valid file of Oregon Counties");
		}
		
	}

}
