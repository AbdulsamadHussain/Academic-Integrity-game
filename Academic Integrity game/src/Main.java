import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Main {
	public static void main(String[] args) throws InterruptedException {
		Scanner in = new Scanner(System.in);

		System.out.println("Welcome to the FCS Academic Integrity game – Get ready to learn in the most interactive " +
				"way!\n" + "Press Enter to continue");
		in.nextLine();

		System.out.println("Please Enter your Name and B00 Number (without the B00)");
		Student student = new Student(in.next(), Integer.parseInt(in.next()));

		while (true) {
			System.out.println("\nWelcome " + student.getUserName() + "! \nPress Enter to view the modules you'd like " +
					"to " + "complete");
			System.out.print("""
                    Press 1, for Module 1 - Inappropriate collaboration
                    Press 2, for Module 2 – Plagiarism
                    Press 3, for Module 3 – Contributing to the commission of plagiarism
                    Press 4, for Module 4 – Cheating
                    Press 0, to exit.
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
//				printWithDelays( ". . . . . . . . . . . . . . . . . . . .", TimeUnit.MILLISECONDS, 100 );
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
		System.out.println("You will be asked to make a choice in this module by entering a single integer to select " +
				"your dialogue choice.\nYour choices will influence your final score at the end of the game.\n" );
		System.out.println("{Hint} Did you know? You are allowed to discuss your assignment with others and take " +
				"notes as long as you do not copy them and submit your original work!\nKeep in mind, use just the " +
				"general approach, not the specific details or code.");
		System.out.println("Press Enter to continue" );
		in.nextLine();

		System.out.println("(Scenario opens with " + userName + " bumping into a friend (Alice) from the same " +
				"course – CSCI 1110 while on their way to another class)" );

		Main.printWithDelays( "\nAlice: Hey " + userName + " How’s your assignment preparation going?",
				TimeUnit.MILLISECONDS, 60 );
		Main.printWithDelays("\n"+userName + ": I’m actually really stuck on the fifth problem, I have been " +
				"trying hard!", TimeUnit.MILLISECONDS, 60   );

		Main.printWithDelays("\nAlice: Oh! I am actually done with that, in fact I’m kind of struggling with " +
				"the third problem." , TimeUnit.MILLISECONDS, 60 );
		Main.printWithDelays("\n"+userName + ": The one which talked about using the while condition? I found " +
				"that quite easy. . ." , TimeUnit.MILLISECONDS, 60);

		Main.printWithDelays( "\nAlice: That’s great! I was thinking, would you want to maybe sit down and help " +
				"each other?\n\t\tI could show you how I did the fifth problem, and you could help me out with the third one?" +
				"\n\t\tWhat do you say?" , TimeUnit.MILLISECONDS, 50);

		Main.printWithDelays("\nPlease choose one of the options", TimeUnit.MILLISECONDS, 50);
		Main.printWithDelays("""
                    \nPress 1, for: Sure! I’d love that…
                    Press 2, for: Instead, we could head over to Tim, take something to drink, and discuss the questions quickly.
                    Press 3, for: So I have a class right now, how about you send me the answer on my dal email, and I’ll send you mine and in the case that we still have a doubt, 
                    \t\t\twe can meet up again. Let’s make sure not to copy, just look through it!
                    """, TimeUnit.MILLISECONDS, 50 );
		int choice = in.nextInt();
		if(choice == 1){
			Main.printWithDelays( """
               \nAlice: Great! Let’s go.
               You both sit down, discuss the assignment and the specific problem, look at each other’s code, make
               notes and later work on it individually.
               (Time lapse…)
               Few days later…you receive a letter from the AIO and after a meet up you get to know that the
               assignment you worked on with Alice was facing charges of inappropriate collaboration. You now got a
               0 on that assignment along with a minor grade decrement, and a 6-month notation on your transcript.
               You’re explained that discussing an assignment with another student or TA id absolutely alright as
               long as all the discussion notes are destroyed and you work on the problems discussed, all by yourself
               after a brief break.
               """, TimeUnit.MILLISECONDS, 100);
			points--;
		} else if( choice == 2 ) {
			Main.printWithDelays(userName + ": Instead, we could head over to Tim, take something to drink, and " +
					"discuss the questions quickly.",TimeUnit.MILLISECONDS, 100);
			Main.printWithDelays( """
								\nAlice: Sure!
								(As you and Alice are headed towards Tim Hortons, you are approached by another friend
								of Alice who looks very stressed…)
								Alice: Hey Betty! How are you? Is everything alright?
								Betty: I just got to know that I was facing Academic Integrity charges for my last
								assignment. They gave me a 0 on that assignment along with a minor grade decrement,
								and a 6-month notation on my transcript!
								It was not my intention to copy from my team members, it just so happened that we all
								discussed the code on the white board, took pictures as notes, and used that pseudo code
								 in our material and unfortunately it made all of work very similar!
								Alice: Oh no! Weren’t you repeating the course? What will happen now?
								Betty: I don’t know…this might lead to a dismissal… I’m very worried! We should have
								erased the notes from everywhere!
								(While Alice and Betty discuss the issue, you realize the importance of taking integrity
								 offence seriously. A small slip up, can lead to very adverse situations.
								You feel relieved that you decided to discuss the assignment with Alice in a proper
								manner without the breach of any academic rules.)
								 """, TimeUnit.MILLISECONDS, 100);
			points++;
		} else if(choice == 3) {
			Main.printWithDelays(userName+": So, I have a class right now, how about you send me the answer" +
					" on my dal email, and I’ll send you mine and in the case that we still have a doubt, we can meet " +
					"up again. Let’s make sure not to copy, just look through it!" ,TimeUnit.MILLISECONDS, 100);
			Main.printWithDelays( """
               \nAlice: Sure! I’ll keep that in mind.
               Once you rush to class, you sit down and send Alice your assignment. While waiting for her to email you
               back, you start working on the problem once again with the help of Alice’s assignment.
               You make sure that you do not copy anything, you look through her answer, understand that and
               then write it by yourself.
               (Time lapse…)
               Few days later, you receive a letter from the AIO and after a meet up you get to know that the
               assignment you worked on was facing charges of inappropriate collaboration.
               You now get a 0 on that assignment along with a minor grade decrement, and a 6-month notation
               on your transcript.
               Worried, you contact the AIO who explains that discussing or sharing an assignment, looking through
               each other’s code, keeping a copy of the other’s assignment, none of it is not allowed.
               Instead having a short discussion without any hard note or copy, is something that can be done in case
               you do need help.
               """, TimeUnit.MILLISECONDS, 100);
			points--;
		}
		return points;
	}

	public static int playModule2(String userName) throws InterruptedException {
		Scanner in = new Scanner(System.in);
		int points = 0;
		System.out.println("\nWelcome to Module 2 – scenario 1" );
		System.out.println("You will be asked to make a choice in this module by entering a single integer to select " +
				"your dialogue choice.\nYour choices will influence your final score at the end of the game.\n" );
		System.out.println("{Hint} Did you know? Students have been caught for plagiarism when Moss detected code that was " +
				"used from Chegg, by students who did not know each other!\nIt's highly possible that the code you " +
				"use from homework sites is used by another student in the same class.\n");
		System.out.println("Press Enter to continue:" );
		in.nextLine();

		System.out.println("(Scenario opens with " + userName + " sitting in the library feeling overwhelmed when " +
				"someone they have known since the first year approaches them." );

		Main.printWithDelays( "\nBrandon: Hey " + userName + " How are you? It’s been so long since we’ve met! " +
				"There’s a party tonight, want to join me?", TimeUnit.MILLISECONDS, 60 );
		Main.printWithDelays("\n"+userName + ": I want to, I really do but I’m just very caught up with this " +
				"course. \nI have an assignment due tomorrow, but I also need to finish up more work from before, " +
				"I just do not know how I’ll manage it all…", TimeUnit.MILLISECONDS, 60   );

		Main.printWithDelays("\nBrandon: Oh! Don’t worry about it! I’ll figure it out for you. I have got this " +
				"friend of mine who can finish up any assignment for you within twelve hours. He does take a fee for " +
				"that, around 50-70 dollars depending on how big the assignment is. I could talk to him for you, and " +
				"you could just hand over the work to him, and come hang out with me tonight. What do you say?",
				TimeUnit.MILLISECONDS, 60);

		Main.printWithDelays("\nPlease choose one of the options:", TimeUnit.MILLISECONDS, 50);
		Main.printWithDelays("""
                    \nPress 1, for: Oh no! That wouldn’t be fair… Anyway don’t worry about it, I’ll figure something
                    out on my own, and hopefully meet you tonight!
                    Press 2, for: Is that possible? That would be great, I could use any help right now. Thanks!
                    Press 3, for: That’s alright! I’ll try to do this by myself and in case I am not able to finish
                    it, I’ll contact you for any help.
                    """, TimeUnit.MILLISECONDS, 100);
		int scenario1choice = in.nextInt();
		if(scenario1choice == 1){
			Main.printWithDelays("\n Brandon: Are you sure? He's done it for a lot of people\n",
					TimeUnit.MILLISECONDS, 100);
			Main.printWithDelays(userName + ": Yes, yes, don’t worry about it! I need to learn it regardless for " +
					"my final exam, there’s no use getting away with just one assignment…",
					TimeUnit.MILLISECONDS, 100);
			Main.printWithDelays("\n Brandon: Okay, whatever suits you! Text me when you are finished with your" +
							" work, and we’ll hang out sometime later!\n",
					TimeUnit.MILLISECONDS, 100);
			Main.printWithDelays(userName + ": Sure! See you\n", TimeUnit.MILLISECONDS, 100);
			Main.printWithDelays("(" + userName + " sighs… rethinking his decision but assures himself that he made the " +
					"right one.)", TimeUnit.MILLISECONDS, 100 );
			Main.printWithDelays("\nYou start rethinking your decision when the girl sitting opposite you suddenly" +
					" speaks up.", TimeUnit.MILLISECONDS, 100);
			Main.printWithDelays("""
					\nLacy: Hey! Sorry, I just unintentionally overheard the entire conversation and just wanted to let\s
					you know that you did the right thing there. I have had a couple of friends who used the same\s
					method to get done with their assignments and recently some of them were suspended for a year while\s
					some failed the course…So, you saved yourself big time!""", TimeUnit.MILLISECONDS, 100);
			Main.printWithDelays("\n" + userName + ": Thank God! Given that it would be my second offense, I would have " +
					"faced a very high penalty. Thank you for letting me know!", TimeUnit.MILLISECONDS, 100);
			Main.printWithDelays("\n Lacy: No worries!", TimeUnit.MILLISECONDS, 100);
			Main.printWithDelays("\n Don’t worry! It was a tough decision, but the right one!", TimeUnit.MILLISECONDS, 50);
			points++;
		}
		else if( scenario1choice == 2 ) {
			Main.printWithDelays(userName + ": Is that possible? That would be great, I could use any help right " +
					"now. Thanks!",TimeUnit.MILLISECONDS, 100);
			Main.printWithDelays("\n Brandon: Great! I’ll send you, his number. See you tonight, yeah?\n",
					TimeUnit.MILLISECONDS, 100);
			Main.printWithDelays(userName + ": Yep, see you!",TimeUnit.MILLISECONDS, 100);
			Main.printWithDelays( """
					\nYou contact the guy who charges you 70$ for the entire assignment and promises you a good grade.\s
					You feel relieved that the burden has been taken off your shoulders and happily go home to get\s
					ready for the party.
					(Time lapse…)
					After a few weeks, you receive a letter from AIO with an allegation of plagiarism. You deny all\s
					charges against you, claiming that your work was your own. The AIO reaches the conclusion that\s
					given this is your second offense, you are suspended for 1 year, receive an F in the course, and\s
					a 24-month notation on your transcript. With the decision made, you immediately regret your decision
					""", TimeUnit.MILLISECONDS, 100);
			points--;
		}
		else if(scenario1choice == 3) {
			Main.printWithDelays(userName+": That’s alright! I’ll try to do this by myself and in case I am not " +
					"able to finish it, I’ll contact you for any help." ,TimeUnit.MILLISECONDS, 100);
			Main.printWithDelays("\nBrandon: Alright! Here’s my number, let me know if you need help. And " +
							"hopefully, I’ll see you tonight!\n",
					TimeUnit.MILLISECONDS, 100);
			Main.printWithDelays(userName + ": Thank you!\n",TimeUnit.MILLISECONDS, 100);
			Main.printWithDelays("(You sit in the library for a few more hours, trying to get through your " +
					"assignment. You feel very tired and exhausted. You start reconsidering Brandon’s suggestion…\n)",
					TimeUnit.MILLISECONDS, 100);
			Main.printWithDelays("\nPlease choose one of the options", TimeUnit.MILLISECONDS, 50);
			Main.printWithDelays("""
                    \nPress 1, for: You email the professor, explaining your situation, and ask for an extension.
                    Press 2, for: You message Brandon for help.
                    """, TimeUnit.MILLISECONDS, 100);
			int innerChoice = in.nextInt();
			if(innerChoice == 1){
				Main.printWithDelays("""
                    \nYou email the professor, explaining your situation, and ask for an extension. He understands your\s
                    situation and has decided to give you an extension till the end of the weekend. You happily decide\s
                    to take a break from your assignment, catch up with your friends, and start working on the\s
                    assignment the next day.
                    (Time lapse...)
                    A few days later…you get to know the severe penalty for acts such as making someone else do your\s
                    work. You learn that for second offenders, like yourself, such cases lead to suspension for 1 year,
                     an F in the course, and a 24-month notation on your transcript. You feel thankful for the choice\s
                    you made.""", TimeUnit.MILLISECONDS, 100);
				points++;
			}else if(innerChoice == 2){
				Main.printWithDelays("""
                    \nYou message Brandon for help. He connects you with the guy, who charges you 70$ for the entire 
                    assignment and promises you a good grade. You feel relieved that the burden has been taken off your 
                    shoulders and happily go home to get ready for the party.
                    (Time lapse...)
                    After a few weeks, you receive a letter from AIO with an allegation of plagiarism. You deny all 
                    charges against you, claiming that your work was your own. The AIO reaches the conclusion that 
                    given this is your second offense, you are suspended for 1 year, receive an F in the course, 
                    and a 24-month notation on your transcript. With the decision made, you immediately regret 
                    your decision.""", TimeUnit.MILLISECONDS, 100);
				points--;
			}
		}
		Main.printWithDelays("\nPlease wait while we shift to next scenario", TimeUnit.MILLISECONDS, 50);
		System.out.println("\nWelcome to Module 2 - scenario 2");
		System.out.println("\n{Hint} Did you know? It is always better to take a 0 than to be caught since the penalty " +
				"is higher. The chances of being caught are high!\n");
		Main.printWithDelays("""
				\nYou have been working on your coding assignment for days. You have already written 200 lines of
				code, but you’ve been stuck with two lines of code for hours now. Feeling confused, you search the
				internet for some help and luckily you find a code exactly like the one you need. You’re a little
				confused if you should cite it or not, and if so, then how, given that it’s just two lines of code.
				""", TimeUnit.MILLISECONDS, 100);
		Main.printWithDelays("\nPlease choose one of the options", TimeUnit.MILLISECONDS, 50);
		Main.printWithDelays("""
				\nPress 1, for: You decide to go ahead with submitting the assignment as it is just two lines out of 300
				lines of code that you used. You do not think that would be a problem…                            
				Press 2, for: You decide to go ahead with submitting regardless of the consequences.
				You think it would not be caught…
				Press 3, for: You decide to talk to the TA or ask a friend if those two lines need citation.
				""", TimeUnit.MILLISECONDS, 100);
		int scenario2choice = in.nextInt();
		if(scenario2choice == 1){
			Main.printWithDelays("""
					\nYou decide to go ahead with submitting the assignment as it is just two lines out of 300 lines 
					of code that you used. You do not think that would be a problem…
					(Time lapse...)
					A few days later you’re surprised to receive a letter from AIO informing him of an allegation of 
					plagiarism. You explain that you wrote your own code except for two lines and weren’t sure if and 
					how to cite it. Given your situation, the AIO finds you guilty of improper citation and explains 
					that you should use comments to indicate which code is from a third party and to provide the source 
					of the code. The AIO concludes that the improper citation was due to ignorance rather than an intent
					to deceive. You receive a formal warning and a requirement to attend an academic integrity workshop.                                                             
					""", TimeUnit.MILLISECONDS, 100);
			points--;
		}
		else if(scenario2choice == 2){
			Main.printWithDelays("""
					\nYou decide to go ahead with submitting regardless of the consequences. You think it would not 
					be caught…
					(Time lapse...)
					A few days later you’re surprised to receive a letter from AIO informing him of an allegation of 
					plagiarism. You accept that you knew this might have been a problem, but you did not think it 
					through properly. Given your situation, the AIO finds you guilty of improper citation and explains 
					that you should use comments to indicate which code is from a third party and to provide the source 
					of the code. You get a 0 on that assignment along with a minor grade decrement, and a 6-month 
					notation on your transcript. """, TimeUnit.MILLISECONDS, 100);
			points--;
		}
		else if(scenario2choice == 3){
			Main.printWithDelays("\nYou decide to talk to the TA or ask a friend if those two lines need citation. " +
					"You soon meet up with your TA explaining your situation.\n", TimeUnit.MILLISECONDS, 100);
			Main.printWithDelays(userName + ": Good morning, I was wondering if I had to cite these two lines of " +
					"code that I got from the internet. Other than this, the rest of my code is all my work.",
					TimeUnit.MILLISECONDS, 100);
			Main.printWithDelays("\nTA:Oh yes! It’s a good thing you asked or else you could have gotten into " +
					"trouble! All you should do is use comments to indicate which code is from a third party, and to " +
					"provide the source of the code. That would be good enough!\n", TimeUnit.MILLISECONDS, 100);
			Main.printWithDelays(userName + ": Okay, Thank you so much!", TimeUnit.MILLISECONDS, 100);
			Main.printWithDelays("\n You feel relieved that you decided to ask for more information instead of " +
					"getting into trouble for negligence…\n", TimeUnit.MILLISECONDS, 100);
			points++;
		}
		return points;
	}

	public static int playModule3(String userName) throws InterruptedException {
		Scanner in = new Scanner(System.in);
		int points = 0;
		System.out.println("Coming soon...");
		return points;
	}

	public static int playModule4(String userName) throws InterruptedException {
		Scanner in = new Scanner(System.in);
		int points = 0;
		System.out.println("Coming soon...");
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
