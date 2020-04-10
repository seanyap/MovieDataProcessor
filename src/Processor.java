import java.util.Scanner;
import java.io.*;

class Processor {
    // Constructor 
    public Processor() {
    }

    // Bahaviors
    public static MovieData read(String fileName) throws IOException {          // read file line by line
        MovieData map = new MovieData();
	Scanner file = new Scanner(new File(fileName));
	while (file.hasNext()) {             // check if there is next line
	    String line  = file.nextLine();         // each line is an individual movie with its info
	    if (line.contains("(no genres listed)"))     // check if there is genre
		continue;                                // no genre so skip this line    
	    String[] lineContents = line.split(",");        
   	    String genre = lineContents[lineContents.length-1];    // genre is in the last cell of the array	
	    String[] genres = null;

	    int yearIndex = line.lastIndexOf('(') + 1;         // add one because year is after parenthesis 
	    String year = line.substring(yearIndex, yearIndex+4);      // get year
	    System.out.println(year); 
	    if (genre.indexOf('|') != -1) {
	        genres = genre.split("\\|");
	    }
	    if (genres != null) {
	        for (int i=0; i<genres.length; i++) {      // loop through all the genres 
		    String name = genres[i];
	   	    map.read(genres[i]);                  // pass each key into map data structure 	     
		}
	    }
	    else {
		map.read(genre);
	    }
	}
	return map;
    }
}
