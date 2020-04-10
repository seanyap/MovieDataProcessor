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
	    String line  = file.nextLine();         // each line is an individual  movie with its info
	    String[] lineContents = line.split(",");        
   	    String genre = lineContents[lineContents.length-1];    // genre is in the last cell of the array
	    String[] genres = null;
	    if (genre.indexOf('|') != -1) {
	        genres = genre.split("\\|");
	    }
	    if (genres != null) {
	        for (int i=0; i<genres.length; i++) {      // loop through all the genres 
		    String name = genres[i];
		    if (name.equals("(no genres listed)"))      // this is not a genre and should not be included in map
			continue;
		    else 
		        map.read(genres[i]);                  // pass each key into map data structure 	     
		}
	    }
	    else {
		if (genre.equals("(no genres listed)"))
		    continue;
		else   
		    map.read(genre);
	    }
	}
	return map;
    }
}
