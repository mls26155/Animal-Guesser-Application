import java.io.*;
import java.util.*;

public class GuessAnimalsDemo {

	public static void main(String[] args) throws IOException {
		
		// Note: Program will run until user enters a name that does not begin with the required character or is not 	
		// in the collection, or they enter	a name they	used before
		
		Scanner keyboard = new Scanner(System.in);
		
		final int CAPACITY = 1000;   // capacity of collection
	    String file = "C:\\Users\\Mike\\Documents\\src\\Animals.txt";
	    String word;
		CollectionInterface<String> words = new ArrayCollection<String>(CAPACITY);
		FileReader fin = new FileReader(file);
	    Scanner wordsIn = new Scanner(fin);
	    
	    while (wordsIn.hasNext()) {
	      word = wordsIn.nextLine();          
	      word = word.toLowerCase();
	      words.add(word);
	    }
	    
	    CollectionInterface<String> previousGuesses = new ArrayCollection<String>(CAPACITY);
	    
	    boolean run = true;
	    int correctGuesses = 0;
	    String randomWord = words.getRandom();
	    
	    do {
	    	//System.out.println(randomWord);
	    	System.out.println("Enter an animal name that starts with the letter " + randomWord.charAt(0) + ":");
	    	String guess = keyboard.nextLine().toLowerCase();
	    	
	    	if(guess.charAt(0) != randomWord.charAt(0) || words.contains(guess) == false || previousGuesses.contains(guess)) {
	    		System.out.println("Game Over");
	    		System.out.println(randomWord + " was the correct word");	    		
	    		run = false;
	    	}
	    	
	    	else if(guess.equals(randomWord)) {
	    		System.out.println("Correct! You guess the right animal!");
	    		correctGuesses++;
	    		randomWord = words.getRandom();
	    	}
	    	else {
	    		System.out.println("Incorrect! Please try again.");
	    		previousGuesses.add(guess);
	    	}
	    	
	    }while(run);
	    
	    System.out.println("You guessed " + correctGuesses + " words correctly. Thanks for playing!");
	
	}

}
