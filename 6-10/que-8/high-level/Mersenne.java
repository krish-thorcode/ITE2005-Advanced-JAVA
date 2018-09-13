package primespackage.mersennepackage;

import primespackage.Primes;

public class Mersenne {
  public boolean mersenneOrNot(int number) {
    Primes primeChecker = new Primes();

    boolean isPrime = primeChecker.checkForPrime(number);

    if(isPrime && isPowerOfTwo(number + 1))
      return true;
    else
      return false;
  }

  boolean isPowerOfTwo(int number) {
    if(Math.ceil(Math.log(number)/Math.log(2)) == Math.floor(Math.log(number)/Math.log(2)))
      return true;
    else
      return false;
  }
}
