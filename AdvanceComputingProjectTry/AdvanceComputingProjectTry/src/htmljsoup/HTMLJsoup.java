package htmljsoup;


import java.io.*;

import org.jsoup.*;
import org.jsoup.nodes.Document;

public class HTMLJsoup {

	public static void Convert (String s) throws IOException {
		//File file=new File("C:/Users/ashok/Downloads/GoSearchYourself/SearchAlgo/src/webpages"+s);	
		File file = new File("/Users/Ten-Thinlay/Desktop/webpages/"+s);
		Document doc = Jsoup.parse(file,"UTF-8");
		String text = doc.text();
		 //System.out.println(text);
		PrintWriter out = new PrintWriter("/Users/Ten-Thinlay/Desktop/webpages/" + s.replace(".htm", ".txt"));
		out.println(text);
		out.close();
	}
	public static void main(String[] args) throws IOException
	{
		
		File f = new File("/Users/Ten-Thinlay/Desktop/webpages");
		File[] nf = f.listFiles();
		
		for(File file: nf)
		{
			if(file.isFile())
			{
				//System.out.println("fdsd:  "+file.getName());
				Convert(file.getName());
			}
		}
	}
}
