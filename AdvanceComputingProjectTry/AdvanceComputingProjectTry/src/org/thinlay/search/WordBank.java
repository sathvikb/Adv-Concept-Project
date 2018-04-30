package org.thinlay.search;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Formatter;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class WordBank {
	
	static Scanner s;
	static Formatter x;
	public static String read( String a) throws FileNotFoundException {

		//ArrayList al = new ArrayList<String>();
		String sau = "";
		s = new Scanner( new File("/Users/Ten-Thinlay/Desktop/webpages/"+a));
		
		while (s.hasNext()) {
			sau+= s.next();
			sau+= " ";
		}
		
		s.close();
		return sau;
	}

	
	public static void write() throws FileNotFoundException
	{
		
			try {
				x = new Formatter("/Users/Ten-Thinlay/Desktop/DataDictionary.txt");
				//x = new Formatter(a);
				
			}
			catch (Exception e) {
				System.out.println(" Error ");
			}
			
		
	}
	
	public static void close(){
		x.close();
	}
	
	public static void main(String[] args) throws FileNotFoundException {

		write();
		/*
		StringTokenizer st = new StringTokenizer(alpha, " (./;:,*){!@#$%^&}[_+-=|']");
		while ( st.hasMoreTokens()) {
			full[count++]  = st.nextToken();
			
		}		*/
		String[] a = new String[101];
		File dir = new File("/Users/Ten-Thinlay/Desktop/webpages");
		File[] f = dir.listFiles();
		int count = 0;
		for ( File file : f) {
			System.out.println(file.getName());
			a[count++] = read(file.getName());
			
		}
		
		Data d = new Data();
		
		ArrayList<String> recv = d.rec();
		
		//for ( int i = 0; i < recv.length; i++) {
		for (String string : recv) {
			
		
		System.out.println(string);
			
			x.format("%s", string);			//change according to formatting preferences
			x.format("%s", "#");
			
			
			for ( int j = 0; j < a.length; j++) {
				
				List <String> l = new ArrayList <String>();
				
				StringTokenizer st = new StringTokenizer(a[j], " (./;:,*){!@#$%^&}[_+-=|']");
				while ( st.hasMoreTokens()) {
					l.add(st.nextToken());
					
				}
				
				if(l.contains(string)) {
					x.format("%s", j);
					x.format("%s", ",");
				}
			}
			x.format("%s", "\n");

		}
		close();
	}

}
