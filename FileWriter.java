package demo.fileio;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

public class FileWriter {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		try {
			PrintWriter outFile = new PrintWriter("logfile.txt");
			int keepGoing = 1;
			while(keepGoing == 1) {
				System.out.println("Please enter your first name");
				String fname = input.next();
				System.out.println("Please enter your last name");
				String lname = input.next();
				int rating = -1;
				while(rating < 1 || rating > 5) {
					System.out.println("Pllease enter a rating between 1 and 5");
					try {
						rating = input.nextInt();
					}catch(InputMismatchException e) {
						input.next(); //clear out bad dataSystem.out.println("Enter your rating as an integer
					}
				}
				//user entered good data
				Date rightNow = new Date(System.currentTimeMillis());
				outFile.println(rightNow + " " + fname + " " + lname + " " + rating);
				System.out.println("Do you have another rating");
			}
		}catch(FileNotFoundException ex) {
			System.out.println("Couldn's open file, quitting");
		}

	}

}
