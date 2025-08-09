import java.io.*;
import java.util.*;

public class FileIOExample{
    public static void main(String[] args) {
        String fileName = "names.txt";
	
	try(BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))){
	    writer.write("Vivek\n");
	    writer.write("John\n");
	    writer.write("Alice\n");
	    System.out.println("Names saved to file.");
	} catch (IOException e){
	    System.out.println("Error writing to file : " + e);
	}

	System.out.println("\nReading from file.");
	try(BufferedReader reader = new BufferedReader(new FileReader(fileName))){
	     String line;
	     while ((line = reader.readLine()) != null){
	        System.out.println(line);
	     }
	}catch(IOException e){
	    System.out.println("Error reading from file : " + e);
	}

    }
}
