package _02_File_Encrypt_Decrypt;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileDecryptor {
	/*
	 * Decryption is the process of taking encoded or encrypted text or other data
	 * and converting it back into text that you or the computer can read and understand.
	 *
	 * The shift cipher is decrypted by using using the key and shifting back up,
	 * at the end of our encryption example we had our alphabet as:
	 *
	 * e f g h i j k l m n o p q r s t u v w x y z a b c d
	 *
	 * If we shift it back up by 4 based on the key we used the alphabet is decrypted:
	 *
	 * a b c d e f g h i j k l m n o p q r s t u v w x y z
	 *
	 * "Lipps Asvph" returns to "Hello World"
	 * 
	 * Create a program that opens the file created by FileEncryptor and decrypts
	 * the message, then display it to the user in a JOptionPane.
	 */
	
	public FileDecryptor() {
		// TODO Auto-generated constructor stub
		decrypt();
	}
	
	void decrypt() {
		try {
			BufferedReader r = new BufferedReader(new FileReader("src/_02_File_Encrypt_Decrypt/encoded.txt"));

			try {
				int key = 1;
				String input = r.readLine();
				String output = "";
				for (int j = 0; j < input.length(); j++) {
					output = output + (char)((int)input.charAt(j) - key);
					key++;
				}
				System.out.println(output);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new FileDecryptor();
	}
}
/***  Copyright © 2020 Kevin Jillissen  ***/