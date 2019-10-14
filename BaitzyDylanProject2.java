/* Dylan Batizy
 * CS 2300 002
 * Project 2
 * 11 October 2019
 */

import java.io.*;
import java.util.*;

public class BaitzyDylanProject2 {

	public static void main(String[] args) {
		
		try {
			
			System.out.println("Dylan Batizy, Assignment #2");
			
			File line1 = new File("line1.txt");
			File line2 = new File("line2.txt");
			File line3 = new File("line3.txt");			//here I load the files
			File line4 = new File("line4.txt");
			File line5 = new File("line5.txt");
			
			Scanner reader = new Scanner(line1);		// here I open the file for reading
			
			int llx = reader.nextInt();					// here I read data from the files
			int lly = reader.nextInt();
			int d = reader.nextInt();
			int p1 = reader.nextInt();
			int p2 = reader.nextInt();
			int v1 = reader.nextInt();
			int v2 = reader.nextInt();
			
			printImplicit(p1, p2, v1, v2);				// here I use a method to display the implicit equation of the line
														// where x is [a1] and y is [a2] and c is the constant
			graph(llx, lly, d, p1, p2, v1, v2);			// here I display the target box and line using a method
			
			System.out.println();
			
			reader = new Scanner(line2);				// here I begin to repeat previous steps for each file
			
			llx = reader.nextInt();
			lly = reader.nextInt();
			d = reader.nextInt();
			p1 = reader.nextInt();
			p2 = reader.nextInt();
			v1 = reader.nextInt();
			v2 = reader.nextInt();
			
			printImplicit(p1, p2, v1, v2);
			
			graph(llx, lly, d, p1, p2, v1, v2);
			
			System.out.println();
			
			reader = new Scanner(line3);
			
			llx = reader.nextInt();
			lly = reader.nextInt();
			d = reader.nextInt();
			p1 = reader.nextInt();
			p2 = reader.nextInt();
			v1 = reader.nextInt();
			v2 = reader.nextInt();
			
			printImplicit(p1, p2, v1, v2);
			
			graph(llx, lly, d, p1, p2, v1, v2);
			
			System.out.println();
			
			reader = new Scanner(line4);
			
			llx = reader.nextInt();
			lly = reader.nextInt();
			d = reader.nextInt();
			p1 = reader.nextInt();
			p2 = reader.nextInt();
			v1 = reader.nextInt();
			v2 = reader.nextInt();
			
			printImplicit(p1, p2, v1, v2);
			
			graph(llx, lly, d, p1, p2, v1, v2);
			
			System.out.println();
			
			reader = new Scanner(line5);
			
			llx = reader.nextInt();
			lly = reader.nextInt();
			d = reader.nextInt();
			p1 = reader.nextInt();
			p2 = reader.nextInt();
			v1 = reader.nextInt();
			v2 = reader.nextInt();
			
			printImplicit(p1, p2, v1, v2);
			
			graph(llx, lly, d, p1, p2, v1, v2);
			
			reader.close();
			
			
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
			
		}

	}
	
	// this is the method I use to make the line itself
	static boolean isOnLine(int p1, int p2, int v1, int v2, int x, int y) {
		
		if (v1 == 0) {				// this will make the line of the slope is 0
			
			if (p1 == x) {
				
				return true;
				
			} else {
				
				return false;
				
			}
			
		} else {
			
			double m = ((double) v2)/v1;
			int b = (int) (p2 - (m * p1));
			
			//this is where we use the implicit equation of a line to determine which points in the target box are on the line.
			if(0 == m*x-y+b || (-.5 < m*x-y+b && .55 > m*x-y+b)) { //I have created a margin of error which best displays each line.
				
				return true;
				
			} else {
				
				return false;
				
			}
			
		}
		
	}
	
	// this is the method I use to draw the line and target box
	// it uses 2 loops to check every single integer point within a specified target box using a method
	static void graph(int llx, int lly, int d, int p1, int p2, int v1, int v2) {
		
		for(int y = lly + d; y > lly - 1; y--) {
			
			for(int x = llx; x < llx+d; x++) {
				
				if(isOnLine(p1, p2, v1, v2, x, y)) {		// if the point is on the line, print *, determined by using said method
					
					System.out.print("*");
					
				}else if (x == llx || x == llx+d-1) {
					
					System.out.print("|");					// if the point is on a Y border of the box, print |
					
				}else if (y == lly || y == lly+d) {			// if the point is on a X border of the box, print -
					
					System.out.print("-");
					
				}else {										// if the point is not a border or on the line, print empty space
					
					System.out.print(" ");
					
				}
				
			}
			
			System.out.println();
			
		}
		
	}
	
	
	// this is the method I use to print the implicit equation of the line
	static void printImplicit(int p1, int p2, int v1, int v2) {
		
		if (v1 == 0) {
			
			System.out.println("Implicit form: 0 = -y + " + p1);
			
		} else {
			
			double m = ((double) v2)/v1;			// here I use the vector to find the slope
			
			int b = (int) (p2 - (m * p1));			// here I find the intercept
			
			System.out.println("Implicit form: 0 = " + m + " x - y + " + b);
			
		}
		
	}

}
