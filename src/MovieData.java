import java.util.HashMap;
import java.util.Set;
import java.io.PrintWriter;

class MovieData {
    // Constructor
    public MovieData() {
	map = new HashMap<String, Integer>();
    }

    // Behaviors
    public void read(String key) {     // read key into map
	// check if key exists
	if (map.containsKey(key)) {     // key exists
	    int curValue = map.get(key);    // get current value
	    map.replace(key, ++curValue);   // add one to current value and update key 
	}	
	else {       // key does not exist
	    map.put(key, 1);       // add key to map 
	}
    }
    public void print(PrintWriter out) {
	Set<String> keySet = map.keySet();       // return a set of keys
	String[] keyArray = keySet.toArray(new String[0]);       // convert set to array 
	for (int i=0; i<keyArray.length; i++) {
	    String key = keyArray[i];
	    out.println("Genre: " + key + " appears " + map.get(keyArray[i]) + " times");           // loop through the array 
	} 
    }
    // Instance variables
    HashMap<String, Integer> map;
}
