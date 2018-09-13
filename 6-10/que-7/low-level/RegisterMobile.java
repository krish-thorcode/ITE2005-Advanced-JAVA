import java.io.*;
import java.util.NoSuchElementException;

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
    catch(IllegalArgumentException ex) {
      System.out.println(ex.getMessage());
      System.exit(1);
    }
    catch(NoSuchElementException ex) {
      System.out.println(ex.getMessage());
      System.exit(1);
    }

    try {
      System.out.print("Enter mobile number: ");
      mobNum = keyboard.readLine();
      validateMobNum(mobNum);
      mobCheck = true;
    }
    catch(IllegalArgumentException ex) {
      System.out.println(ex.getMessage());
      System.exit(2);
    }
    catch(NoSuchElementException ex) {
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
      throw new IllegalArgumentException("Error: Invalid registration number.");

    if(!reg.matches("[A-Za-z0-9]+"))
      throw new NoSuchElementException("Error: Invalid registration number.");
  }

  static void validateMobNum(String mobNum) {
    if(mobNum.length() != 10)
      throw new IllegalArgumentException("Error: Invalid mobile number.");

    if(!mobNum.matches("[1-9]{1}[0-9]+"))
      throw new NumberFormatException("Error: Invalid mobile number.");
  }
}
