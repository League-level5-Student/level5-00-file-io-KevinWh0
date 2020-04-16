package _02_File_Encrypt_Decrypt;

import java.io.FileWriter;
import java.io.IOException;

public class FileEncryptor {
	/*
	 * Encryption is the process of encoding a message or information
	 * in such a way that only authorized parties can access it and
	 * those who are not authorized cannot.
	 *
	 * A simple shift cipher works by shifting the letters of a message
	 * down based on a key. If our key is 4 then:
	 * 
	 * a b c d e f g h i j k l m n o p q r s t u v w x y z
	 * 
	 * becomes:
	 *
	 * e f g h i j k l m n o p q r s t u v w x y z a b c d
	 * 
	 * "Hello World" changes to "Lipps Asvph"
	 *
	 * Create a program that takes a message and a key from the user.
	 * Use the key to shift each letter in the users input and save the final result to a file.
	 */
	String chars = "abcdefghijklmnopqrstuvwxyz,./;'[]<>?:{};|!@#$%^&*()1234567890 ";
	int key = 1;
	String input = "Hello";
	String output = "";
	
	
	FileEncryptor(){
		encrypt();
	}
	
	
	void encrypt() {
		output = "";
		//input = input.toLowerCase();
		//for (int i = 0; i < input.length(); i++) {
			for (int j = 0; j < chars.length(); j++) {
				
				//if(input.charAt(i) == chars.charAt(j)) {
					//output = output + chars.charAt((j+key) % chars.length());
					try {
						output = output + (char)(int)(input.charAt(j) + key);
					}catch(Exception e) {
						
					}
					key++;
				//}
			}
		//}
		try {
			FileWriter w = new FileWriter("src/_02_File_Encrypt_Decrypt/encoded.txt",false);
			w.write(output);
			w.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(output);
		//System.out.println((int) output.charAt(0)+key);
		
	}
	
	
	public static void main(String[] args) {
		new FileEncryptor();
	}
	
}
/***  Copyright © 2020 Kevin Jillissen  ***/