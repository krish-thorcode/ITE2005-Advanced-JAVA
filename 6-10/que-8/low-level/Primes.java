package primespackage;

public class Primes {

  public boolean checkForPrime(int number)  {

    if(number == 2)
      return true;

    for(int i = 2; i <= Math.sqrt(number); i++) {
      if(number % i == 0)
        return false;
    }

    return true;
  }
}
