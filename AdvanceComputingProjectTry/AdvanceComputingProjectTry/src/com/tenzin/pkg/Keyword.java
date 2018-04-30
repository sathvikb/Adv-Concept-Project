package com.tenzin.pkg;

import java.io.File;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.tenzin.*;;

public class Keyword {
	public ArrayList<String> findPhoneNumberAndEmailAddress(String parameter) {
		// TODO Auto-generated method stub
		   File folder = new File("/Users/Ten-Thinlay/Desktop/webpages");
		   File[] listOfFiles = folder.listFiles();
		   In in;
		   String[] allText = new String[listOfFiles.length];
		   String text = null;
		   ArrayList<String> list = new ArrayList<String>();
		   ArrayList<String> mainList = new ArrayList<String>();
		   String patternMain = "";
		   if(parameter.equals("phonenumber")) {
			   patternMain ="\\d{10}|(?:\\d{3}-){2}\\d{4}|\\(\\d{3}\\)\\d{3}-?\\d{4}";
		   }
		   else if(parameter.equals("email"))
		   {
			   patternMain = "\\b[\\w.%-]+@[-.\\w]+\\.[A-Za-z]{2,4}\\b";
		   }
			 //String pattern = "(.*)(\\d+)(.*)";
			// String pattern = "\\bthe\\b";
		//	String patternEmail = 
		   for (int i = 0; i < listOfFiles.length; i++) {
		         if (listOfFiles[i].isFile()) {
		        //   System.out.println("File " +
		        	 
		        	  in = new In("/Users/Ten-Thinlay/Desktop/webpages/"+listOfFiles[i].getName());
		           text = in.readAll();
		        		//System.out.println(i);
		        
		          list = getPhoneNumber(text, patternMain, "Phone Number: ");
		   		//getPhoneNumber(text, patternEmail, "Email: ");
		        		
		        	 
		         }
		         if(list.size() >0) {
		         for (String string : list) {
					mainList.add(string);
				  }
		         }
		   }
		  
		   return mainList;
			
		
	}

	private ArrayList<String> getPhoneNumber(String text, String pattern, String phoneOrEmail) {
		// TODO Auto-generated method stub
		Pattern patternClass = Pattern.compile(pattern);

	    // Now create matcher object.
	    Matcher m = patternClass.matcher(text);
	    //System.out.println("count"+m.groupCount());
	    ArrayList<String> list = new ArrayList<>();
	    if (m.find( )) {
	    	      list.add(m.group());

	    }
	    return list;
//	    for (String string : list) {
//			System.out.println(phoneOrEmail+ string);
//		}
	 
	}

}
