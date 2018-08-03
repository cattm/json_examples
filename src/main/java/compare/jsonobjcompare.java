package compare;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

// compare two json objects by object content
// this works - you can shift the elements around
// but the items in the array have to be in order - which is fair!

public class jsonobjcompare {
	public static boolean areEqual(Object ob1, Object ob2) throws JSONException {
        Object obj1Converted = convertJsonElement(ob1);
        Object obj2Converted = convertJsonElement(ob2);
        return obj1Converted.equals(obj2Converted);
    }

    private static Object convertJsonElement(Object elem) throws JSONException {
    	
        if (elem instanceof JSONObject) {
            JSONObject obj = (JSONObject) elem;
            Iterator<String> keys = obj.keys();
            Map<String, Object> jsonMap = new HashMap<>();
            while (keys.hasNext()) {
                String key = keys.next();
                jsonMap.put(key, convertJsonElement(obj.get(key)));
            }
            return jsonMap;
        } else if (elem instanceof JSONArray) {
            JSONArray arr = (JSONArray) elem;
            Set<Object> jsonSet = new HashSet<>();
            for (int i = 0; i < arr.length(); i++) {
                jsonSet.add(convertJsonElement(arr.get(i)));
            }
            return jsonSet;
        } else {
            return elem;
        }
    }	
	
	
	
	// method currently assume the object is at least a JSON Object
	private static boolean isJsonObject(Object jsonVal){
        boolean h = false;
        try {
            JSONObject j1=(JSONObject)jsonVal;
            h=true;
        } catch (Exception e) {
            e.printStackTrace();

            if(e.toString().contains("org.json.simple.JSONArray cannot be cast tomorg.json.simple.JSONObject")){
                h=false;
            }
        }
        return h;

    }
}
