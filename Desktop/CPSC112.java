package edu.yale.cpsc112_lesson2;

//you have to import the Random class in order to use it
import java.util.Random;


public class CPSC112 {
		
	  //make numberImThinkingOf a global variable, visible to the whole class
	  public static int numberImThinkingOf;
	  
	  public static void main(String[] args)
	  {
		  System.out.println("Hello world.");
	  }	  
	  
	  public static void initNum()
	  {

		  //define r as a variable of type Random
		  //r is thus a random number generator
		  Random r = new Random();
		  
		  //use our random number generator, r, to generate a random number between 1 and 10
		  numberImThinkingOf = r.nextInt(10) + 1;
		  System.out.println("numberImThinkingOf: " + numberImThinkingOf);
	  }
	  
	  //this method returns the distance between closestGuess and numberImThinkingOf
	  public static int currentBestDistance (int closestGuess)
	  {
	     int distance = 0;
	     distance = closestGuess - numberImThinkingOf;
	     if (distance  < 0)
	     {
	          distance*=-1;
	     }
	     return distance;
	  }
	  
	  //returns true if the String thingToCheck is convertable to an integer, and false otherwise
	  public static boolean isConvertableToInt(String thingToCheck)
	  {
	     try {
   	        Integer.parseInt(thingToCheck);
	        return true;
	     }
	     catch (Exception e)
	     {
	        return false;
	     }
	  }
	  
	  //processGuess is called by MainActivty.java when the user clicks on 'Done' in the input textbox.
	  public static void processGuess(String guess)
	  {
		  
	     //if we want to have four integer variables to store the guesses we could do the following
	     //int guess1;
	     //int guess2;
	     //int guess3;
	     //int guess4;
	     
	     //or we could store them in an array
	     int[] guesses;
	     guesses = new int[4];
	     
		  int intGuess = 0;
		  int closestGuess = -1;
		  
		  //declare userTypedInAnInteger and userGuessedSpecialNumber to be of type boolean --- see Section 5.3 of your textbook
		  boolean userTypedInAnInteger = false;
		  boolean userGuessedSpecialNumber = false;
		  int i = 0;
		  
		  //use the try-catch statement to catch errors thrown by Integer.parseInt if the user didn't type an integer
		  try {
			  
			  //a while loop is a short-hand way of declaring a for loop with just the test condition. See section 5.1 of your textbook.
		     // the and && and || operators are described in Section 5.3 of your textbook
			  while ((guess.indexOf(' ') != -1 && closestGuess != numberImThinkingOf) || (isConvertableToInt(guess)))
			  {
			     String currentGuess = guess;
			     if (guess.indexOf(' ') != -1)
			     {
			        currentGuess = guess.substring(0, guess.indexOf(' '));
			     }
			     if (isConvertableToInt(currentGuess))
			     {
				  intGuess = Integer.parseInt(currentGuess);
				  guesses[i] = intGuess; //store intGuess in the ith element of the guesses array
	              if (intGuess == 123712) 
	              {
	                  userGuessedSpecialNumber = true;
	              }
				  if (closestGuess == -1)
				  {
				     closestGuess = intGuess;
				  }
			     }
			     else
			     {
			        System.out.println(currentGuess + " is not an integer");
			     }
				  int differenceFromNum = intGuess - numberImThinkingOf;
				  if (differenceFromNum < 0)
				  {
				     differenceFromNum *= -1;
				  }
				  if (differenceFromNum < currentBestDistance(closestGuess))
				  {
				     closestGuess = intGuess;
				  }
				  if (guess.indexOf(' ') != -1)
				  {
				     guess = guess.substring(guess.indexOf(' ')+1, guess.length());
				  }
				  else
				  {
				     guess = "asdf";
				  }
				  i++;
			  }
			  
			  
			  userTypedInAnInteger = true;
		  }
		  catch (Exception e)
		  {
			  System.out.println("Please type an integer");
		  }
		  if (userTypedInAnInteger) //note that variables of type boolean are sufficient conditions for if statements by themselves
		  {
			  if (numberImThinkingOf == closestGuess)
			  {
				  System.out.println("You got it correct.");
				  initNum();
			  }
			  else if (intGuess != numberImThinkingOf)
			  {
				  if (userGuessedSpecialNumber)
				  {
					  	System.out.println("You win 1,000,000 dollars!");
				  }
				  else
				  {
					  System.out.println("I am amazed at your ineptitude!");
					  System.out.println("But, BTW, your closest guess was: " + closestGuess);
					  System.out.print("Your non-closest guesses were: ");
					  for (int j = 0; j < i; j++)
					  {
					     if (guesses[j] != closestGuess)
					     {
					        System.out.print(guesses[j] + " ");
					     }
					  }
                      System.out.println();
					     
				  }
			  }
		  }
	  }
	}