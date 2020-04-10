import java.io.IOException;
import java.io.PrintWriter;
import java.io.File;

public class ProcessorApp {
    public static void main(String[] args) throws IOException{
	String file = "../data/movies.csv";
	MovieData map = Processor.read(file);
	PrintWriter out = new PrintWriter(new File("../data/output.text"));
	map.print(out);
	out.flush();
    }
}
