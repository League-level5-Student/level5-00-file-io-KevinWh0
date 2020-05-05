package _03_To_Do_List;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class ToDoList implements ActionListener {
	/*
	 * Create a program with five buttons, add task, view tasks, remove task, save list, and load list. 
	 *
	 * When add task is clicked:
	 * 		Create a JOptionPane to ask the user for a task and add it to an ArrayList
	 * 
	 * When the view tasks button is clicked:
	 *		show all the tasks in the list
	 * 
	 * When the remove task button is clicked:
	 * 		Create a JOptionPane to prompt the user for which task to remove and take it off of the list.
	 * 
	 * When the save list button is clicked:
	 * 		Save the list to a file
	 * 
	 * When the load list button is clicked:
	 * 		Create a JOptionPane to Prompt the user for the location of the file and load the list from that file
	 * 
	 * When the program starts, it should automatically load the last saved file into the list. 
	 */
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JLabel tasks = new JLabel();
	ArrayList<String> Tasks = new ArrayList<String>();
	JButton[] buttons = new JButton[5];
	String[] buttonNames = {"View Tasks","Add Task","Remove Task(s)","Save List","Load List"};
	
	public ToDoList() {
		// TODO Auto-generated constructor stub
		setup();
	}
	
	void setup() {
		frame.add(panel);
		for (int i = 0; i < buttons.length; i++) {
			buttons[i] = new JButton(buttonNames[i]);
			buttons[i].addActionListener(this);
			panel.add(buttons[i]);
			
			
		}
		panel.add(tasks);
		
		
		
		
		frame.setPreferredSize(new Dimension(600,100));
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
		buttons[4].doClick();
	}
	
	
	public static void main(String[] args) {
		new ToDoList();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		//System.out.println(e.getSource().toString());
		if(e.getSource().toString().contains(buttonNames[0])) {
			String text = "";
			
			for (int i = 0; i < Tasks.size(); i++) {
				text = text + "<br/>" + "Task #" + i + "  "  + Tasks.get(i);
			}
			//tasks.setText("<html><h1 style='color:blue'>Hello</h1> <button>hello</button></html>");

			tasks.setText("<html>" + text + "</html>");
			frame.setSize(new Dimension(600,100 + 20 * (Tasks.size() + 1)));
		}else if(e.getSource().toString().contains(buttonNames[1])) {
			String task = JOptionPane.showInputDialog("Add Task");
			Tasks.add(task);
		}else if(e.getSource().toString().contains(buttonNames[2])) {
			String m = JOptionPane.showInputDialog("Enter the number of whitch Task you would like to remove");
			try {
				int s = (Integer.parseInt(m));
				Tasks.remove(s);
			}catch(Exception g) {
				
			}
		}else if(e.getSource().toString().contains(buttonNames[3])) {
			try {
				FileWriter w = new FileWriter("src/_03_To_Do_List/todoList.kev",false);
				String write = "";
				for (int i = 0; i < Tasks.size(); i++) {
					write = write + Tasks.get(i) + "~";
					
				}
				w.write(write);
				w.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			
		}else if(e.getSource().toString().contains(buttonNames[4])) {
			try {
				BufferedReader r = new BufferedReader(new FileReader("src/_03_To_Do_List/todoList.kev"));
				String loadedData;
				try {
					loadedData = r.readLine();
					String[] tasks = loadedData.split("~");
					Tasks.clear();
					for (int i = 0; i < tasks.length; i++) {
						Tasks.add(tasks[i]);
					}
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
}
/***  Copyright © 2020 Kevin Jillissen  ***/