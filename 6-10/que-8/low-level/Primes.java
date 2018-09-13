package primespackage;

public class Primes {

  public boolean checkForPrime(int number)  {

    for(int i = 2; i <= Math.sqrt(number); i++) {
      if(number % i == 0)
        return false;
    }

    return true;
  }
}
