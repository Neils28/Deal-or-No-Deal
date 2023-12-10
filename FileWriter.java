package demofilereader;

import java.util.Scanner;
import java.io.PrintWriter;
import java.util.Date;
import java.util.InputMismatchException;
import java.io.FileNotFoundException;

public class FileWriter {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		try {
			PrintWriter outFile = new PrintWriter("logfile.txt");
			int keepGoing = 1;
			while (keepGoing == 1) {
				System.out.println("Please enter your first name");
				String fname = input.next();
				System.out.println("Please enter your last name");
				String lname = input.next();
				int rating = -1;
				while (rating < 1 || rating > 5) {
					System.out.println("Please enter a rating between 1 and 5");
					try {
						rating = input.nextInt();
						
					}catch(InputMismatchException ex) {
						input.next(); // clear out bad data
						System.out.println("Enter your rating as an integer");
					}
				}
				Date rightNow = new Date(System.currentTimeMillis());
				outFile.println(rightNow + " " + fname + " " + lname + " " + rating);
				System.out.println("Do you have another rating? Enter 1 for yes, 2 for no");
				keepGoing = input.nextInt();
				
			}
			outFile.close();
		}catch (FileNotFoundException ex) {
			System.out.println("Couldn't open file, quitting");
		}
	}
}
