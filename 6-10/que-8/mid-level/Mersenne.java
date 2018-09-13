package primespackage.mersennepackage;

import primespackage.Primes;

public class Mersenne {
  public boolean mersenneOrNot(int number) {
    boolean isPrime = new Primes().checkForPrime(number);

    if(isPrime && isPowerOfTwo(number))
      return true;
    else
      return false;
  }

  public boolean isPowerOfTwo(int number) {
    if(Math.ceil(Math.log(number)/Math.log(2)) == Math.floor(Math.log(number)/Math.log(2)))
      return true;
    else
      return false;
  }
}
