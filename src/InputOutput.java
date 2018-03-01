import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InputOutput {
	
	static String arr[];
	final static String fileName = "emails.txt";
	
	public static void readIn() throws IOException{
		
	Scanner sc = new Scanner(new File(fileName));
	List<String> lines = new ArrayList<String>();
	while (sc.hasNextLine()) {

	  lines.add(sc.nextLine());
	arr = lines.toArray(new String[0]);



		}
	

	}

	
}
