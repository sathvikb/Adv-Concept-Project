package org.thinlay.search;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Data {

	public static ArrayList<String> rec() throws FileNotFoundException {
		// TODO Auto-generated method stub
		//String[] a = new String[1438245363];
		ArrayList<String> a = new ArrayList<String>();
		Scanner s;
		s = new Scanner( new File("/Users/Ten-Thinlay/Desktop/wordbank.txt"));
		
		int count = 0;
		while(s.hasNext()) {
			
			//a[count++] = s.next();
			a.add(s.next());
		}
		s.close();
		return a;
	}
	
	public static String[] main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		String[] a = new String[14382];
		Scanner s;
		s = new Scanner( new File("/Users/Ten-Thinlay/Desktop/wordbank.txt"));
		int count = 0;
		while(s.hasNext()) {
			
			a[count++] = s.next();
		}
		
		return a;
	}

}
