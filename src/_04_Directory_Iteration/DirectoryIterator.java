package _04_Directory_Iteration;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFileChooser;

public class DirectoryIterator {
	static String cr = "/***  Copyright © 2020 Kevin Jillissen  ***/";

	public static void main(String[] args) {
		/* 
		 * The following is an example of how to list all of the files in a directory.
		 * Once the program is running, the directory is chosen using the JFileChooser.
		 */
		
		JFileChooser jfc = new JFileChooser();
		jfc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
		int returnVal = jfc.showOpenDialog(null);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			System.out.println();
			writeCRToFile(jfc.getSelectedFile());
		}
		
		/*
		 * Your task is to write a program that iterates through the src folder of this current Java Project. 
		 * For every .java file it finds, the program will add a (non-legally binding) copyright statement at the bottom.
		 * Be aware of possible directories inside of directories.
		 * (e.g //Copyright © 2019 FirstName LastName)
		 */
	}
	
	static int updatedFiles = 0;
	static void writeCRToFile(File path) {
		File directory = path;
		File[] files = directory.listFiles();
		if(files != null) {
			for(File f : files) {
				if(!f.isDirectory()) {
					//System.out.println(f.getAbsolutePath());
					if(f.getName().contains(".java")) {
						updatedFiles ++;
						System.out.println("Updated file # " + updatedFiles + " @ the directorty " + f.getPath());
						//System.out.println(f.getName());
						try {
							
							
							BufferedReader r = new BufferedReader(new FileReader(f.getAbsolutePath()));
							
							String dataToWrite = "";

							String s = r.readLine();
							while(s != null) {
								//System.out.println(s);
								//w.write(s);
								//w.write("\n");
								dataToWrite = dataToWrite + s + "\n";
								s = r.readLine();
							}
							if(s == null) {
								//w.write("\n");

								
								dataToWrite = dataToWrite + cr;

								//System.out.println(cr);
							}
							FileWriter w = new FileWriter(f.getAbsolutePath(),false);

							w.write(dataToWrite);
							w.close();
							
							
						} catch (FileNotFoundException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

					}
				}
			  //System.out.println(f.isDirectory());
			  
			  
			  if(f.isDirectory()) {
				  writeCRToFile(new File( f.getAbsolutePath()));
			  }
			}
		}
		
		
	}
}
/***  Copyright © 2020 Kevin Jillissen  ***/