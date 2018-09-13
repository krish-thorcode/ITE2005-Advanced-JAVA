import java.io.*;

class InsufficientCharacterLengthException extends Exception {

  InsufficientCharacterLengthException(String msg) {
    super(msg);
  }
}

class InvalidRegistrationNumberException extends Exception {

  InvalidRegistrationNumberException(String msg) {
    super(msg);
  }
}

class InvalidMobileNumberException extends Exception {

  InvalidMobileNumberException(String msg) {
    super(msg);
  }
}

public class RegisterMobile {
  public static void main(String args[]) throws IOException {
    String mobNum, regNum;
    boolean regCheck = false, mobCheck = false;

    BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));

    try {
      System.out.print("Enter registration number: ");
      regNum = keyboard.readLine();
      validateRegNum(regNum);
      regCheck = true;
    }
    catch(InsufficientCharacterLengthException ex) {
      System.out.println(ex.getMessage());
      System.exit(1);
    }
    catch(InvalidRegistrationNumberException ex) {
      System.out.println(ex.getMessage());
      System.exit(1);
    }

    try {
      System.out.print("Enter mobile number: ");
      mobNum = keyboard.readLine();
      validateMobNum(mobNum);
      mobCheck = true;
    }
    catch(InsufficientCharacterLengthException ex) {
      System.out.println(ex.getMessage());
      System.exit(2);
    }
    catch(InvalidRegistrationNumberException ex) {
      System.out.println(ex.getMessage());
      System.exit(2);
    }

    if(regCheck && mobCheck)
      System.out.println("Valid");
    else
      System.out.println("Invalid");
  }

  static void validateRegNum(String reg)  {
    if(reg.length() != 9)
      throw new InsufficientCharacterLengthException("Error: Invalid registration number.");

    if(!reg.matches("[A-Za-z0-9]+"))
      throw new InvalidRegistrationNumberException("Error: Invalid registration number.");
  }

  static void validateMobNum(String mobNum) {
    if(mobNum.length() != 10)
      throw new InsufficientCharacterLengthException("Error: Invalid mobile number.");

    if(!mobNum.matches("[1-9]{1}[0-9]+"))
      throw new InvalidMobileNumberException("Error: Invalid mobile number.");
  }
}
