package _01_File_Recorder;

import java.io.FileWriter;
import java.io.IOException;

public class FileRecorder {
	// Create a program that takes a message from the user and saves it to a file.
	
	public FileRecorder() {
		// TODO Auto-generated constructor stub
		writeToFile("Hello", "Test.txt");
	}
	
	public void writeToFile(String str, String name) {
		try {
			FileWriter fw = new FileWriter("src/_01_File_Recorder/" + name, true);
			fw.write(str);
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public static void main(String[] args) {
		new FileRecorder();
		
	}
}
/***  Copyright © 2020 Kevin Jillissen  ***/