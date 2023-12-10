package demofilereader;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileReading {

	public static void main(String[] args) {
		try {
			Scanner input = new Scanner(new File("superbowl.txt"));
			String team1 = input.next();
			String team2 = input.next();
			int team1score = 0;
			int team2score = 0;
			while (input.hasNext()) {
				String temp = input.next();
				if (team1.equals(temp)) {
					team1score += input.nextInt();
				} else if (team2.equals(temp)) {
					team2score += input.nextInt();
				} else {
					throw new RuntimeException("Team name doesn't match this game");
				}System.out.println(team1 + ": " + team1score + " " + team2 + ": " + team2score);
			}
		// If we have made it this far
		System.out.println("Game Over!");
		if(team1score > team2score) {
			System.out.println(team1 + " win!");
		}else if(team2score > team1score){
			System.out.println(team2 + " win!");
		}else {
			System.out.println("Tie game!?");
		}
			
		} catch (FileNotFoundException ex) {
			System.out.println("Couldn't find that file");
		} catch (RuntimeException ex) { // Badly formatted file in some way
			System.out.println("Bad file, I quit:");
			System.out.println(ex.getMessage());

		}
	}
}
