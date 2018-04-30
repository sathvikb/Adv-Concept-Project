<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="com.tenzin.pkg.Keyword"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.StringTokenizer"%>
<%@page import="sun.util.locale.StringTokenIterator"%>
<%@page import="org.thinlay.search.FolderSearch"%>
<%@page import="java.util.Map.Entry"%>
<%@page import="java.util.List"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Advance Computing Concept Project</title>
<style>
			.tableClass{
			    border-collapse: collapse;
			}
			
			.tableChildClass {
			    border: 1px solid black;
			}
		</style>
</head>
<body bgcolor = "green">
<center>
 <marquee behavior = "alternate"><h1>Advance Computing Concept Project</h1></marquee>
		<form action="Search.jsp" method="post">
			<table>
				<tr>
					<td>
						Keyword
					</td>
					<td>
						<input type="text" id="keyword" name="keyword" placeholder="Eg. word"/>
					</td>
				</tr>
				<tr>
					<td>
						Top N Files
					</td>
					<td>
						<select id="topNRecords" name="topNRecords">
							<option selected="selected" value="1">1</option>
							<option value="2">2</option>
							<option value="3">3</option>
							<option value="4">4</option>
							<option value="5">5</option>
							<option value="6">6</option>
							<option value="7">7</option>
							<option value="8">8</option>
							<option value="9">9</option>
							<option value="10">10</option>
							<option value="11">11</option>
							<option value="12">12</option>
							<option value="13">13</option>
							<option value="14">14</option>
							<option value="15">15</option>
							<option value="16">16</option>
							<option value="17">17</option>
							<option value="18">18</option>
							<option value="19">19</option>
							<option value="20">20</option>
							<option value="21">21</option>
							
						</select>
					</td>
				</tr>
				<tr>
					<td></td>
					<td>
						<input type="submit" value="Search" />
					</td>
				</tr>
			</table>
		</form>
		
		<div>
			<table>
			<%
				if(request.getParameter("keyword")!=null && !request.getParameter("keyword").equals("")
						&& request.getParameter("topNRecords")!=null && !request.getParameter("topNRecords").equals("")
						){
					String editText = request.getParameter("keyword");
					
					StringTokenizer stk = new StringTokenizer(editText, " :");
					
					 String firstWord = ""; 
						firstWord =	stk.nextToken();
					String secondWord = "";
				    if(stk.hasMoreTokens()){
					secondWord= stk.nextToken(); 
				    }
					
					//System.out.println(firstWord);
					//out.write(firstWord);
					//out.write(secondWord);
					 ArrayList<String> listOfEmailAndPhoneNumbers;
					if(firstWord.equals("keyword")){
						if(secondWord.equals("email")){
							
							 listOfEmailAndPhoneNumbers = new Keyword().findPhoneNumberAndEmailAddress(secondWord);
							 out.write("<hr>");
								out.write("<font color = 'white'>Output:</font><br>");
								out.write("<table class='tableClass'>");
								out.write("<tr>");
								out.write("<th class='tableChildClass'><font color = 'white'>E-mail Addresses</font></th>");
								
								out.write("</tr>");
							 for(int i = 0; i<listOfEmailAndPhoneNumbers.size(); i++){
								 out.write("<tr>");
									out.write("<td class='tableChildClass'><center><font color ='white'>" + listOfEmailAndPhoneNumbers.get(i) + "</font></center></td>");
									
									out.write("</tr>");
						    	   //out.write(listOfEmailAndPhoneNumbers.get(i));
						    }
							 out.write("</table>");
						    
						}
						else if(secondWord.equals("phonenumber")){
							
							 listOfEmailAndPhoneNumbers = new Keyword().findPhoneNumberAndEmailAddress(secondWord);
							 out.write("<hr>");
								out.write("<font color = 'white'>Output:</font><br>");
								out.write("<table class='tableClass'>");
								out.write("<tr>");
								out.write("<th class='tableChildClass'><font color = 'white'><center>Phone Numbers</center></font></th>");
								
								out.write("</tr>");  
							 for(int i = 0; i<listOfEmailAndPhoneNumbers.size(); i++){
								 out.write("<tr>");
									out.write("<td class='tableChildClass'><center><font color ='white'>" + listOfEmailAndPhoneNumbers.get(i) + "</font></center></td>");
									
									out.write("</tr>"); 
								// out.write(listOfEmailAndPhoneNumbers.get(i));
							    } 
							 out.write("</table>");
						}
						else{
							List<Entry<String, Integer>> topNSortedFileContentCount = new FolderSearch("/Users/Ten-Thinlay/Desktop/webpages").search(request.getParameter("keyword"), Integer.parseInt(request.getParameter("topNRecords")));
							//out.write("fdsfd:"+topNSortedFileContentCount.size());
							 if(topNSortedFileContentCount.size() > 0){
								
								out.write("<hr>");
								out.write("<font color = 'white'>Output:</font><br>");
								out.write("<table class='tableClass'>");
								out.write("<tr>");
								out.write("<th class='tableChildClass'><font color = 'white'>File Name</font></th>");
								out.write("<th class='tableChildClass' width ='100'><font color = 'white'>Count</font></th>");
								out.write("</tr>");
								
								for(Entry<String, Integer> entry : topNSortedFileContentCount){
									out.write("<tr>");
									out.write("<td class='tableChildClass'><font color ='white'>" + entry.getKey() + "</font></td>");
									out.write("<td class='tableChildClass'><center><font color ='white><a href=''>" + entry.getValue() + "</a></font></center></td>");
									out.write("</tr>");
								
								}
								out.write("</table>");
							} 
							else
							{
								out.write("<h3>No such key words in any of the file</h3>");
							} 
						}
					}
					else
					{
					List<Entry<String, Integer>> topNSortedFileContentCount = new FolderSearch("/Users/Ten-Thinlay/Desktop/webpages").search(request.getParameter("keyword"), Integer.parseInt(request.getParameter("topNRecords")));
					//out.write("fdsfd:"+topNSortedFileContentCount.size());
					 if(topNSortedFileContentCount.size() > 0){
						
						out.write("<hr>");
						out.write("<font color = 'white'>Output:</font><br>");
						out.write("<table class='tableClass'>");
						out.write("<tr>");
						out.write("<th class='tableChildClass'><font color = 'white'>File Name</font></th>");
						out.write("<th class='tableChildClass' width ='100'><font color = 'white'>Count</font></th>");
						out.write("</tr>");
						
						for(Entry<String, Integer> entry : topNSortedFileContentCount){
							out.write("<tr>");
							out.write("<td class='tableChildClass'><font color ='white'>" + entry.getKey() + "</font></td>");
							out.write("<td class='tableChildClass'><center><font color ='white><a href=''>" + entry.getValue() + "</a></font></center></td>");
							out.write("</tr>");
						
						}
						out.write("</table>");
					} 
					else
					{
						out.write("<h3>No such key words in any of the file</h3>");
					} 
				}
				}
			%>
			</table>
		</div>
		</center>
</body>
</html>