import java.util.Scanner;

interface ThemePark {
	int entranceFeeAdults = 500, entranceFeeChildren =300;

	int totalCost();
	boolean playGame();
}

class QueensLand implements ThemePark {
	private int numGames = 30, gameCode;
	private boolean games[] = new boolean[numGames];
  private int numAdults, numChildren;
	Scanner keyboard = new Scanner(System.in);

	public QueensLand() {
    this.numAdults = 0;
    this.numChildren = 0;
  	for(int i=0; i<numGames; i++)
  		games[i] = false;
	}

	public QueensLand(int numAdults, int numChildren) {
		this.numAdults = numAdults;
    this.numChildren = numChildren;
    for(int i=0; i<numGames; i++)
      games[i] = false;
	}

	public boolean playGame() { // returns true if the game initiated successfully
		System.out.print("Enter the game code: ");
		this.gameCode = keyboard.nextInt();

		if(this.games[this.gameCode] == true) {
			System.out.println("Already played! Try a different code!");
			return false;
		}

		this.games[this.gameCode] = true;
		return true;
	}

  public int totalCost() {
    int totalCost = entranceFeeAdults * numAdults + entranceFeeChildren * numChildren;
    return totalCost;
  }
}

class VeegaLand implements ThemePark {
	private int numGames = 40, gameCode;
	private int games[] = new int[numGames], replay;
  private int numAdults, numChildren;
	Scanner keyboard = new Scanner(System.in);

  private static int entranceFeeAdults = 500, entranceFeeChildren =300;

	public VeegaLand() {
    this.numAdults = 0;
    this.numChildren = 0;
		for(int i=0; i<numGames; i++)
			games[i] = 0;
	}

	public VeegaLand(int numAdults, int numChildren) {
		this.numAdults = numAdults;
    this.numChildren = numChildren;
    for(int i=0; i<numGames; i++)
      games[i] = 0;
	}

	public boolean playGame() { // returns true if the game initiated successfully
		System.out.print("Enter the game code: ");
		this.gameCode = keyboard.nextInt();

		if(this.games[gameCode] > 0) {
			System.out.print("Replay? Enter 1 for 'Yes' and 2 for 'No'");
			this.replay = keyboard.nextInt();

			if(this.replay == 1) {
				this.games[this.gameCode]++;
				return true;
			}

			else
				return false;
		}

		else {
			this.games[this.gameCode] = 1;
			return true;
		}
	}

  public int totalCost() {
    int totalCost = entranceFeeAdults * numAdults + entranceFeeChildren * numChildren;
    return totalCost;
  }
}

public class FamilyPlayer {
	public static void main(String args[]) {

		int numAdults, numChildren;
		int endGame = 0, ageGroup;
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Queensland!");

		// QueensLand ql = new QueensLand();

		// boolean played = q1.playGame();

    System.out.println("-------Queensland---------");
		// System.out.println("Are you a grown up or still a baby (no offence!)? 1 - Baby, 0 - Grown up");
    System.out.print("Enter the number of adults: ");
		numAdults = keyboard.nextInt();

    System.out.print("Enter the number of children: ");
		numChildren = keyboard.nextInt();

    for(int i = 0; i < (numAdults + numChildren); i++) {
      System.out.println("---Welcome Player " + i + "---");
      endGame = 0;
      QueensLand ql = new QueensLand();
  		while(endGame != 1) {
  			boolean played = ql.playGame();
  			if(played == true)
  				System.out.println("Played successfully!");
  			else {
  				System.out.println("You seem to have already played the game, please enter a different game code.");
  				System.out.println("Do you want to quit playing? 1 - Yes, 0 - No ");
  				endGame = keyboard.nextInt();
  			}
  		}
    }

		System.out.println("Total cost: " + new QueensLand(numAdults, numChildren).totalCost());


    // VeegaLand vl;
    System.out.println("------Veegaland-------");
    System.out.print("Enter the number of adults: ");
		numAdults = keyboard.nextInt();

    System.out.print("Enter the number of children: ");
		numChildren = keyboard.nextInt();

		endGame = 0;

    for(int i = 0; i < (numAdults + numChildren); i++) {
      System.out.println("---Welcome Player " + i + "---");
      endGame = 0;
      VeegaLand vl = new VeegaLand();
      while(endGame != 1) {
  			boolean played = vl.playGame();
  			if(played == true)
  				System.out.println("Played successfully!");
  			else {
  				// System.out.println("You seem to have already played the game, want to ?");
  				System.out.println("Do you want to quit playing? 1 - Yes, 0 - No ");
  				endGame = keyboard.nextInt();
  			}
  		}
    }
		System.out.println("Total cost: " + new VeegaLand(numAdults, numChildren).totalCost());
	}
}
