import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Main {
	public static void main(String[] args) throws InterruptedException {
		Scanner in = new Scanner(System.in);

		System.out.println("Welcome to the FCS Academic Integrity game – Get ready to learn in the most interactive way!\n" +
						"Press Enter to continue");
		in.nextLine();

		System.out.println("Please Enter your Name and B00 Number");
		Student student = new Student(in.nextLine(), Integer.parseInt(in.nextLine()));

		while (true) {
			System.out.println("\nWelcome " + student.getUserName() + " Press Enter to view the modules you'd like to complete");
			in.nextLine();

			System.out.print("""
                    Press 1, for Module 1 - Inappropriate collaboration
                    Press 2, for Module 2 – Plagiarism
                    Press 3, for Module 3 – Contributing to the commission of plagiarism
                    Press 4, for Module 4 – Cheating
                    Press 0, to exit
                    """);

			int moduleChoice = in.nextInt();
			int points = 0;

			if (moduleChoice == 0) {
				System.out.println("Goodbye!");
				break;
			} else if (moduleChoice == 1) {
				System.out.println("Module 1 Starting\nPlease wait" );
				printWithDelays( ". . . . . . . . . . . . . . . . . . . .", TimeUnit.MILLISECONDS, 100 );
				points += playModule1( student.getUserName() );
			} else if (moduleChoice == 2) {
				System.out.println("Module 2 Starting\nPlease wait" );
				points += playModule2();
				printWithDelays( ". . . . . . . . . . . . . . . . . . . .", TimeUnit.MILLISECONDS, 100 );
			} else if (moduleChoice == 3) {
				System.out.println("Module 3 Starting\nPlease wait" );
				points += playModule3();
			} else if (moduleChoice == 4) {
				System.out.println("Module 4 Starting\nPlease wait" );
				points += playModule4();
				printWithDelays( ". . . . . . . . . . . . . . . . . . . .", TimeUnit.MILLISECONDS, 100 );
			}

			System.out.println("\nYou earned " + points + " points for this module.");

			System.out.println("Do you want to play another module? (yes/no)");
			String playAgain = in.next();
			if (!playAgain.equalsIgnoreCase("yes")) {
				System.out.println("Goodbye!");
				System.out.println("Your total points are: " + points);
				break;
			}
		}
	}

	// Implement playModule1(), playModule2(), playModule3(), and playModule4() methods
	// to handle the gameplay and return the points earned.

	public static int playModule1(String userName){
		
		int points = 0;

		System.out.println("\nWelcome to Module 1 – Inappropriate collaboration." );
		System.out.println("You will be asked to make a choice in this module by entering a single integer to select your dialogue choice.\nYour choices will influence your final score at the end of the game.\n" );
		System.out.println("{Hint} Did you know? You are allowed to discuss your assignment with others and take notes as long as you do not copy them and submit your original work!\nKeep in mind, use just the general approach, not the specific details or code.");

		System.out.println("(Scenario opens with " + userName + " bumping into a friend(Alice) from the same course – CSCI 1110 while on their way to another class)" );
		
		System.out.println("Alice: Hey " + userName + " How’s your assignment preparation going?" );
		System.out.println(userName + ": I’m actually really stuck on the fifth problem, I have been trying hard!" );
		
		System.out.println("Alice: Oh! I am actually done with that, in fact I’m kind of struggling with the third problem.");
		System.out.println(userName+ ": The one which talked about using the while condition? I found that quite easy. . ." );
		
		System.out.println("Alice: That’s great! I was thinking, would you want to maybe sit down and help each other? I could show you how I did the fifth problem, and you could help me out with the third one? What do you say?\n" );
		System.out.println(userName + " Do not forget, you have class in the next 15 minutes!");

		System.out.println( );

		return 0;

	}

	public static int playModule2(){
		return 0;
	}

	public static int playModule3(){
		return 0;
	}

	public static int playModule4(){
		return 0;
	}




	public static void printWithDelays(String data, TimeUnit unit, long delay)
					throws InterruptedException {
		for (char ch : data.toCharArray()) {
			System.out.print(ch);
			unit.sleep(delay);
		}
	}
}
