import specialnumbers.MersenneNumbers;
import java.util.Scanner;

public class MersenneNumbersLister {
  public static void main(String args[]) {

    int lowerLimit, upperLimit;
    MersenneNumbers mersenneChecker = new MersenneNumbers();
    Scanner keyboard = new Scanner(System.in);

    System.out.println("Enter the range within which Mersenne numbers are to be found");

    System.out.print("      lower limit: ");
    lowerLimit = keyboard.nextInt();

    System.out.print("      upper limit: ");
    upperLimit = keyboard.nextInt();

    mersenneChecker.displayAllMersenneNumbers(lowerLimit, upperLimit);
  }
}
