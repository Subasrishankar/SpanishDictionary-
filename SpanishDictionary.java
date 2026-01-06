import java.util.Scanner;
import java.util.HashMap;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
public class Main{
	public static void main(String[] args)
	{
		HashMap<String, String> dict = new HashMap<>();
		File file = new File("spanish_dictionary.txt");
		try{
			Scanner fileScanner = new Scanner(file);            
			while(fileScanner.hasNextLine())
			{
				String line = fileScanner.nextLine();
				String[] parts = line.split(",", 2);
				if(parts.length == 2)
				{
					String spanish = parts[0];
					String english = parts[1];
					dict.put(spanish, english);
			}
			}
				fileScanner.close();
		}
			catch(FileNotFoundException e)
			{
				System.out.println("File not found!!!.");
				return;
			}
			Scanner sc = new Scanner(System.in);
			System.out.print("Enter a word or pharse : ");
			String word = sc.nextLine().trim();
			if (word.isEmpty()) {
    System.out.println("Please enter a valid word.");
    return;
}
			if(dict.containsKey(word.toLowerCase()))
			{
				System.out.println(word.substring(0,1).toUpperCase()+word.substring(1).toLowerCase()+" - "+dict.get(word));
			}
			else{
				System.out.println("Word not found.");
				System.out.print("Do you want to add this new word to the file? Yes/No ");
				String input = sc.nextLine().trim();
				if(input.toLowerCase().equals("yes"))
				{
					System.out.print("Great. Please provide the English meaning of the word : ");
					String meaning = sc.nextLine().trim();
					try{
						FileWriter writer = new FileWriter(file, true);
						writer.write(word.toLowerCase()+","+meaning+"\n");
						writer.close();
						dict.put(word.toLowerCase(), meaning);
					}
					catch (IOException e) {
    System.out.println("Error while saving the word.");
}
					System.out.println("Thank you for your contribution.");
				}
				else
				{
					System.out.println("Ok. Thank You!");
				}	
			}
			sc.close();
	}
}
			
		
