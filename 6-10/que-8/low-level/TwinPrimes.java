import primespackage.Primes;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
public class TwinPrimes {

  public static void main(String args[]) {

    int lowerLimit, upperLimit;
    int firstPrimeInTheRange;
    boolean isPrime;

    Primes primeChecker = new Primes();
    Scanner keyboard = new Scanner(System.in);

    System.out.println("Enter the range within which twin primes are to be found");

    System.out.print("      lower limit: ");
    lowerLimit = keyboard.nextInt();

    System.out.print("      upper limit: ");
    upperLimit = keyboard.nextInt();

    ArrayList<ArrayList<Integer>> pairList = new ArrayList<ArrayList<Integer>>();

// niche wala ka logic ye soch rhe ki lowerlimit se shuru karo prime number dhundhna..
// mile toh check karo ki iske 2 aage wala (maan lo iss num ko Damru bolte hain) prime hai ki ni..
// agr hai toh dono ko sath me rkh lena..
// phr proceed krna Damru se.. same chz krna hai uske liye b jo abi kiye...
    int nextLowerLimit = 0; // nextLowerLimit may have any value (not just 0) at this point
    boolean isSecondNumPrime;
    for(int i = lowerLimit; i <= upperLimit; i = nextLowerLimit ) {
        if( i == 1) {
          nextLowerLimit = 3;
          continue;
        }
        isPrime = primeChecker.checkForPrime(i);

        if(isPrime == true) {
          isSecondNumPrime = primeChecker.checkForPrime(i+2);
          if(isSecondNumPrime == true) {
            pairList.add(new ArrayList<Integer>(Arrays.asList(i, i+2)));
            nextLowerLimit = i+2;
          }
          else
            nextLowerLimit = ++i; // since i+2 is not prime, we can start the next iteration from i+3
        }
        else {
          nextLowerLimit = ++i;
          // System.out.println("sanity check");
          continue;
        }
    }

    ArrayList<Integer> pair = new ArrayList<Integer>(2);
    for(int i = 0; i < pairList.size(); i++) {
      pair = pairList.get(i);
      System.out.println(pair.get(0) + ", " + pair.get(1));

    }
  }
}
