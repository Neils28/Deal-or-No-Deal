package demo.fileio;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileReading {

	public static void main(String[] args) {
		try {
			Scanner input = new Scanner(new File("superbowl.txt"));
			String team1 = input.next();
			String team2 = input.next();
			int team1Score = 0;
			int team2Score = 0;
			while (input.hasNext()) {
				String temp = input.next();
				if(team1.equals(temp)) {
					team1Score += input.nextInt();
				}else if(team2.equals(temp)) {
					team2Score += input.nextInt();
				}else {
					throw new RuntimeException("Team name doesn't mantch this game");
				}
				System.out.println(team1 + ": " + team1Score + " " + team2 + ": " + team2Score);
			}
			//if we're here, the file is done
			System.out.println("Game over!");
			if(team1Score > team2Score) {
				System.out.println(team1 + " win!");
			}else if(team2Score > team1Score) {
				System.out.println(team2 + " win!");
			}else {
				System.out.println("Tie game?!?");
			}
		}catch(FileNotFoundException ex) {
			System.out.println("Couldn't find that file");
		}catch(RuntimeException ex) {
			System.out.println("Bad File, I quit:");
			System.out.println(ex.getMessage());
		}

	}

}
