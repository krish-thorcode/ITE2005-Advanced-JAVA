import java.util.Scanner;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;
import java.io.*;
import java.text.SimpleDateFormat;

class Donor {
  private String name;
  private int age;
  private String address;
  private int contactNumber;
  private String bloodGroup;
  private Date dateOfLastDonation;

  public Donor() {
    name = "";
    age = 0;
    address = "";
    contactNumber = 0;
    bloodGroup = "";
    dateOfLastDonation = new Date();
  }

  public void createDonor(String name, int age, String address, int contactNumber, String bloodGroup, Date dateOfLastDonation) {
    this.name = name;
    this.age = age;
    this. address = address;
    this.contactNumber = contactNumber;
    this.bloodGroup = bloodGroup;
    this.dateOfLastDonation = dateOfLastDonation;
  }
}

public class LowLevel {
  public static void main(String args[]) throws Exception{

    String name;
    int age;
    String address;
    int contactNumber;
    String bloodGroup;
    Date dateOfLastDonation;

    Donor donor = new Donor();
    // String dateInput;

    SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

    BufferedReader keyboardBufferedReader = new BufferedReader(new InputStreamReader(System.in));
    int n;

    Scanner keyboardScanner = new Scanner(System.in);

    System.out.println("Enter the number of regular donors in Vellore: ");
    n = keyboardScanner.nextInt();

    List<Donor> donorList = new ArrayList<Donor>();

    for(int i = 0; i < n; i++) {
      System.out.println("Donor " + i + ": ");
      System.out.print("Name: ");
      name = keyboardBufferedReader.readLine();
      System.out.print("Age: ");
      age = keyboardScanner.nextInt();
      System.out.print("Address: ");
      address = keyboardBufferedReader.readLine();
      System.out.print("Contact number: ");
      contactNumber = keyboardScanner.nextInt();
      System.out.print("Blood group: ");
      bloodGroup = keyboardBufferedReader.readLine();
      System.out.print("Date (dd-MM-yyyy): ");
      dateOfLastDonation = sdf.parse(keyboardBufferedReader.readLine());
      // sdf.parse(dateOfLastDonation);

      donor.createDonor(name, age, address, contactNumber, bloodGroup, dateOfLastDonation);
      donorList.add(donor);

      System.out.println();
    }
  }
}
