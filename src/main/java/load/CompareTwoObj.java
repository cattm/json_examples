package load;

import java.io.FileReader;

import org.json.simple.parser.JSONParser;

import compare.jsonobjcompare;

public class CompareTwoObj {
	public static JSONParser parser = new JSONParser();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	       try {     
	            Object obj1 = parser.parse(new FileReader("src/main/resources/json_eg1.json"));
	            Object obj2 = parser.parse(new FileReader("src/main/resources/json_eg2.json"));
	            Object obj3 = parser.parse(new FileReader("src/main/resources/json_eg3.json"));
	            Object obj4 = parser.parse(new FileReader("src/main/resources/json_eg1.json"));
	            Object obj5 = parser.parse(new FileReader("src/main/resources/json_eg4.json"));
	            
	            
	            if (jsonobjcompare.areEqual(obj1, obj2)) {
	            	System.out.println("Compare is Equal");
	            } else {
	            	System.out.println("Compare is Not Equal");
	            }
	            if (jsonobjcompare.areEqual(obj1, obj3)) {
	            	System.out.println("Compare is Equal");
	            } else {
	            	System.out.println("Compare is Not Equal");
	            }
	            if (jsonobjcompare.areEqual(obj1, obj4)) {
	            	System.out.println("Compare is Equal");
	            } else {
	            	System.out.println("Compare is Not Equal");
	            }
	            if (jsonobjcompare.areEqual(obj1, obj5)) {
	            	System.out.println("Compare is Equal");
	            } else {
	            	System.out.println("Compare is Not Equal");
	            }
	            
	       }  catch (Exception e) {
	    	   e.printStackTrace();
	       }   

	}

}
