import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Main {
	public static void main(String[] args) throws InterruptedException {
		Scanner in = new Scanner(System.in);

		System.out.println("Welcome to the FCS Academic Integrity game – Get ready to learn in the most interactive way!\n" +
						"Press Enter to continue");
		in.nextLine();

		System.out.println("Please Enter your Name and B00 Number");
		Student student = new Student(in.next(), Integer.parseInt(in.next()));

		while (true) {
			System.out.println("\nWelcome " + student.getUserName() + " Press Enter to view the modules you'd like to complete");
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
				points += playModule2(student.getUserName());
				printWithDelays( ". . . . . . . . . . . . . . . . . . . .", TimeUnit.MILLISECONDS, 100 );
			} else if (moduleChoice == 3) {
				System.out.println("Module 3 Starting\nPlease wait" );
				points += playModule3(student.getUserName());
			} else if (moduleChoice == 4) {
				System.out.println("Module 4 Starting\nPlease wait" );
				points += playModule4(student.getUserName());
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

	public static int playModule1(String userName) throws InterruptedException {
		Scanner in = new Scanner(System.in);
		int points = 0;

		System.out.println("\nWelcome to Module 1 – scenario 1" );
		System.out.println("You will be asked to make a choice in this module by entering a single integer to select your dialogue choice.\nYour choices will influence your final score at the end of the game.\n" );
		System.out.println("{Hint} Did you know? You are allowed to discuss your assignment with others and take notes as long as you do not copy them and submit your original work!\nKeep in mind, use just the general approach, not the specific details or code.");
		System.out.println("Press Enter to continue" );
		in.nextLine();

		System.out.println("(Scenario opens with " + userName + " bumping into a friend(Alice) from the same course – CSCI 1110 while on their way to another class)" );

		Main.printWithDelays( "\nAlice: Hey " + userName + " How’s your assignment preparation going?", TimeUnit.MILLISECONDS, 60 );
		Main.printWithDelays("\n"+userName + ": I’m actually really stuck on the fifth problem, I have been trying hard!", TimeUnit.MILLISECONDS, 60   );

		Main.printWithDelays("\nAlice: Oh! I am actually done with that, in fact I’m kind of struggling with the third problem." , TimeUnit.MILLISECONDS, 60 );
		Main.printWithDelays("\n"+userName + ": The one which talked about using the while condition? I found that quite easy. . ." , TimeUnit.MILLISECONDS, 60);

		Main.printWithDelays( "\nAlice: That’s great! I was thinking, would you want to maybe sit down and help each other? I could show you how I did the fifth problem, and you could help me out with the third one? What do you say?" , TimeUnit.MILLISECONDS, 50);

		Main.printWithDelays("\nPlease choose one of the options", TimeUnit.MILLISECONDS, 50);
		Main.printWithDelays("""
                    \nPress 1, for: Sure! I’d love that…
                    Press 2, for: Instead, we could head over to Tim, take something to drink, and discuss the questions quickly.
                    Press 3, for: So I have a class right now, how about you send me the answer on my dal email, and I’ll send you mine and in the case that we still have a doubt, we can meet up again. Let’s make sure not to copy, just look through it!
                    """, TimeUnit.MILLISECONDS, 50 );
		int choice = in.nextInt();
		if(choice == 1){
			Main.printWithDelays( """
               \nAlice: Great! Let’s go.
               You both sit down, discuss the assignment and the specific problem, look at each other’s code, make notes and later work on it individually.
               (Time lapse…)
               Few days later…you receive a letter from the AIO and after a meet up you get to know that the assignment you worked on with Alice was facing charges of inappropriate collaboration. You now got a 0 on that assignment along with a minor grade decrement, and a 6-month notation on your transcript.
               You’re explained that discussing an assignment with another student or TA id absolutely alright as long as all the discussion notes are destroyed and you work on the problems discussed, all by yourself after a brief break.
               """, TimeUnit.MILLISECONDS, 100);
			points--;
		} else if( choice == 2 ) {
			Main.printWithDelays(userName + " Instead, we could head over to Tim, take something to drink, and discuss the questions quickly.",TimeUnit.MILLISECONDS, 100);
			Main.printWithDelays( """
								\nAlice: Sure!
								(As you and Alice are headed towards Tim Hortons, you are approached by another friend of Alice who looks very stressed…)
								Alice: Hey Betty! How are you? Is everything alright?
								Betty: I just got to know that I was facing Academic Integrity charges for my last assignment. They gave me a 0 on that assignment along with a minor grade decrement, and a 6-month notation on my transcript!
								It was not my intention to copy from my team members, it just so happened that we all discussed the code on the white board, took pictures as notes, and used that pseudo code in our material and unfortunately it made all of work very similar!
								Alice: Oh no! Weren’t you repeating the course? What will happen now?
								Betty: I don’t know…this might lead to a dismissal… I’m very worried! We should have erased the notes from everywhere!
								(While Alice and Betty discuss the issue, you realize the importance of taking integrity offence seriously. A small slip up, can lead to very adverse situations. 
								You feel relieved that you decided to discuss the assignment with Alice in a proper manner without the breach of any academic rules.)
								 """, TimeUnit.MILLISECONDS, 100);
			points++;
		} else {
			Main.printWithDelays(userName+" User: So, I have a class right now, how about you send me the answer on my dal email, and I’ll send you mine and in the case that we still have a doubt, we can meet up again. Let’s make sure not to copy, just look through it!" ,TimeUnit.MILLISECONDS, 100);
			Main.printWithDelays( """
               \nAlice: Sure! I’ll keep that in mind.
               Once you rush to class, you sit down and send Alice your assignment. While waiting for her to email you back, you start working on the problem once again with the help of Alice’s assignment. 
               You make sure that you do not copy anything, you look through her answer, understand that and then write it by yourself.
               (Time lapse…)
               Few days later, you receive a letter from the AIO and after a meet up you get to know that the assignment you worked on was facing charges of inappropriate collaboration. 
               You now get a 0 on that assignment along with a minor grade decrement, and a 6-month notation on your transcript. 
               Worried, you contact the AIO who explains that discussing or sharing an assignment, looking through each other’s code, keeping a copy of the other’s assignment, none of it is not allowed. 
               Instead having a short discussion without any hard note or copy, is something that can be done in case you do need help.
               """, TimeUnit.MILLISECONDS, 100);
			points--;
		}
		return points;
	}

	public static int playModule2(String userName) throws InterruptedException {
		Scanner in = new Scanner(System.in);
		int points = 0;
		return points;
	}

		public static int playModule3(String userName) throws InterruptedException {
			Scanner in = new Scanner(System.in);
			int points = 0;

			return points;	}

	public static int playModule4(String userName) throws InterruptedException {
		Scanner in = new Scanner(System.in);
		int points = 0;
		return points;
	}




	public static void printWithDelays(String data, TimeUnit unit, long delay)
					throws InterruptedException {
		for (char ch : data.toCharArray()) {
			System.out.print(ch);
			unit.sleep(delay);
		}
	}
}
