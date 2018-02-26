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
	
	static int count = 0;
	static String arr[];
	
	public static void readIn() throws IOException{
		
		String fileName = "EmailList.txt";
		
/*
		//read file into stream, try-with-resources
		try (Stream<String> stream = Files.lines(Paths.get(fileName))) {

			
			stream.forEach(System.out::println);
			System.out.println(stream);

		} catch (IOException e) {
			e.printStackTrace();
		}
	
*/
		
		Scanner sc = new Scanner(new File(fileName));
		List<String> lines = new ArrayList<String>();
		while (sc.hasNextLine()) {
			count++;
		  lines.add(sc.nextLine());
		arr = lines.toArray(new String[0]);



		}

		System.out.println(count + "I AM COUNT"); // Counts twice
		System.out.println(Arrays.toString(arr)); // print to screen, the email list
		
	       
	/*	try (BufferedReader br = new BufferedReader(new FileReader(fileName)))
     {

         String currentEmailAddress;

         while ((currentEmailAddress = br.readLine()) != null) 
         {
             mailingList.add(currentEmailAddress);
             System.out.println("I am list on the mailing list " + mailingList);
         }

     } catch (IOException e) {
         e.printStackTrace();
     } */


		 
	
		 
	}
}
