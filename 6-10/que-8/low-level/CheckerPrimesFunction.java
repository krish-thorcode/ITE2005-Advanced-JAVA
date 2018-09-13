import primespackage.Primes;

public class CheckerPrimesFunction {
  public static void main(String args[]) {
    Primes primeChecker = new Primes();

    System.out.println("lol: " + primeChecker.checkForPrime(100));
    System.out.println("lol: " + primeChecker.checkForPrime(2));
    System.out.println("lol: " + primeChecker.checkForPrime(33));
    System.out.println("lol: " + primeChecker.checkForPrime(37));
  }
}
