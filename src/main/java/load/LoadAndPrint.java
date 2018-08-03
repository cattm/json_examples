package load;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class LoadAndPrint {
	public static void main(String[] args) {

        JSONParser parser = new JSONParser();

        try {     
            Object obj = parser.parse(new FileReader("src/main/resources/json_eg1.json"));

            JSONObject jsonObject =  (JSONObject) obj;
            
            JSONArray bigArray = (JSONArray) jsonObject.get("BigValues");
            
            for (Object o : bigArray) {
            
            	System.out.println("New Record..........");
            	
            	JSONObject bv = (JSONObject) o;
                // get element inside big array
            	String strID = (String) bv.get("some_id_1");
                System.out.println("\tID::::" + strID);
            	
                String strDes = (String) bv.get("Description");
                System.out.println("\tDescription::::" + strDes);
            	
                JSONArray littleArray = (JSONArray) bv.get("small array");
                
                for (Object x : littleArray) {
                	System.out.println("Inner Record..........");
                	JSONObject lv = (JSONObject) x;
                	
                	String field1 = (String) lv.get("sm_rec_f1");
                    System.out.println("\t\tID::::" + field1);
                    String field2 = (String) lv.get("sm_rec_f2");
                    System.out.println("\t\tID::::" + field2);
                }
          
            }
        
		} catch (FileNotFoundException e) {
        e.printStackTrace();
		} catch (IOException e) {
        e.printStackTrace();
		} catch (ParseException e) {
        e.printStackTrace();
		}
	}
}
