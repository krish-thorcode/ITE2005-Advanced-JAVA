package specialnumbers;
import primespackage.Primes;
import primespackage.mersennepackage.Mersenne;

public class MersenneNumbers {
  public void displayAllMersenneNumbers(int lowerLimit, int upperLimit) {

    if(lowerLimit == 1)
      lowerLimit = 2;
    Mersenne mersenneChecker = new Mersenne();

    System.out.println("Mersenne numbers: ");
    for(int i = lowerLimit; i <= upperLimit; i++) {
      if(mersenneChecker.mersenneOrNot(i))
        System.out.println(i);
    }
  }
}
