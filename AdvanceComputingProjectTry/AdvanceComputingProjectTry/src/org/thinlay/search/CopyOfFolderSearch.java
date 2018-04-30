package org.thinlay.search;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class CopyOfFolderSearch {
	static HashMap<String, List<String>> fileContentByLines ;
	
	public CopyOfFolderSearch(String folderPath){
		if(fileContentByLines == null){
			fileContentByLines = new HashMap<String, List<String>>();
			File[] files = new File(folderPath).listFiles();
			try {
				loadFilesContent(files);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public List<Entry<String, Integer>> search(String searchContent,int topNRecords) throws IOException {
		Map<String, Integer> fileContentCount = new HashMap<String, Integer>();
		if(fileContentByLines!=null){
			List<String> contentList = null;
			int count = 0;
			for(String fileName : fileContentByLines.keySet()){
				contentList = fileContentByLines.get(fileName);
				count = 0;
				if(contentList!=null){
					for(String line : contentList){
						if(line.contains(searchContent)){
							count++;
						}
					}
					if(count>0)
						fileContentCount.put(fileName, count);
				}
			}
		}
		
		System.out.println("fileContentCount: " + fileContentCount);

		List<Entry<String, Integer>> sortedFileContentCount = entriesSortedByValues(fileContentCount);
		System.out.println("sortedFileContentCount: " + sortedFileContentCount);
		
		
		System.out.println("topNRecords: " + topNRecords);
		System.out.println("sortedFileContentCount.size(): " + sortedFileContentCount.size());
		if(topNRecords > sortedFileContentCount.size()){
			topNRecords = sortedFileContentCount.size();
		}
		
		System.out.println("\n\n");
		
		List<Entry<String, Integer>> topNSortedFileContentCount = sortedFileContentCount.subList(0, topNRecords);
		System.out.println("topNSortedFileContentCount: " + topNSortedFileContentCount);
		
		return topNSortedFileContentCount;
	}
	
	public static void loadFilesContent(File[] files) throws IOException{
	    for (File file : files) {
	        if (file.isDirectory()) {
//	            System.out.println("Directory: " + file.getName());
	            loadFilesContent(file.listFiles()); // Calls same method again.
	        } else {
//	            System.out.println("File: " + file.getName());
	            fileContentByLines.put(file.getName(), FilesUtil.readTextFileByLines(file.getPath()));
	        }
	    }
	}
	
	static <K,V extends Comparable<? super V>> List<Entry<K, V>> entriesSortedByValues(Map<K,V> map) {

		List<Entry<K,V>> sortedEntries = new ArrayList<Entry<K,V>>(map.entrySet());

		Collections.sort(sortedEntries, 
	            new Comparator<Entry<K,V>>() {
	                @Override
	                public int compare(Entry<K,V> e1, Entry<K,V> e2) {
	                    return e2.getValue().compareTo(e1.getValue());
	                }
	            }
	    );

		return sortedEntries;
	}
}
