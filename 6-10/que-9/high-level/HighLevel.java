import java.util.Scanner;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;
import java.io.*;
import java.text.SimpleDateFormat;

class Donor implements Serializable {
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

  public void displayDonorDetails() {
    System.out.println("Name: " + name);
    System.out.println("Age: " + age);
    System.out.println("Address: " + address);
    System.out.println("Contact: " + contactNumber);
    System.out.println("Blood group: " + bloodGroup);
    System.out.println("Date of Last Donation: " + dateOfLastDonation);
  }

  public String getBloodGroup() {
    return this.bloodGroup;
  }

  public Date getDateOfLastDonation() {
    return this.dateOfLastDonation;
  }

  public void updateDateofLastDonation(Date dateOfLastDonation) {
    this.dateOfLastDonation = dateOfLastDonation;
  }

  public boolean isSameAs(Donor donor) {
    // System.out.println("in isSameAs()");
    // if(!this.dateOfLastDonation.after( donor.dateOfLastDonation) && !this.dateOfLastDonation.before(donor.dateOfLastDonation))
    //   System.out.println("checking if date comparision works");
    if(this.name.equals(donor.name) && this.age == donor.age && this.address.equals(donor.address) && this.contactNumber == donor.contactNumber && this.bloodGroup.equals(donor.bloodGroup) && (!this.dateOfLastDonation.after( donor.dateOfLastDonation) && !this.dateOfLastDonation.before(donor.dateOfLastDonation))) {
      // System.out.println("checking if condition was true");
      return true;
    }
    else
      return false;
  }
}

class FileHandlingForDonorList {

  private String fileName;

  public FileHandlingForDonorList(String fileName) {
    this.fileName = fileName;
  }

  public void writer(List<Donor> donorList) throws Exception {

    ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName));

    oos.writeObject(donorList);
    oos.flush();
    oos.close();
  }

  public List<Donor> reader() throws Exception {

    ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName));

    List<Donor> donorList = new ArrayList<Donor>();

    donorList = (List<Donor>) ois.readObject();

    ois.close();

    return donorList;
  }

  public List<Donor> createRepository(List<Donor> donorList_1, List<Donor> donorList_2) throws Exception {

    List<Donor> donorListOfUniqueElements = new ArrayList<Donor> (donorList_1);

    boolean duplicateFound;

    for(Donor donor: donorList_2) {
      duplicateFound = false;
      for(Donor uniqueDonorElement: donorListOfUniqueElements) {
        if(donor.isSameAs(uniqueDonorElement)) {
          duplicateFound = true;
          break;
        }
        else
          continue;
      }
      if(duplicateFound == false)
        donorListOfUniqueElements.add(donor);
    }

    ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName));
    oos.writeObject(donorListOfUniqueElements);
    oos.flush();
    oos.close();
    // System.out.println("set size: " + donorSet.size());
    // for(Donor donor: donorSet){
    //   dono
    // }
    return donorListOfUniqueElements;
  }

  // public Set<Donor> readRepository() throws Exception {
  //
  //   ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName));
  //
  //   Set<Donor> donorSet = new HashSet<Donor>();
  //
  //   donorSet = (Set<Donor>) ois.readObject();
  //
  //   ois.close();
  //
  //   return donorSet;
  // }
}

public class HighLevel {
  public static void main(String args[]) throws Exception {

    String name;
    int age;
    String address;
    int contactNumber;
    String bloodGroup;
    Date dateOfLastDonation;

    // Donor donor = new Donor();

    SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

    BufferedReader keyboardBufferedReader = new BufferedReader(new InputStreamReader(System.in));
    int n;

    Scanner keyboardScanner = new Scanner(System.in);

    System.out.println("Bloood Bank 1:");
    System.out.println("Enter the number of regular donors in Vellore under Bank-1: ");
    n = keyboardScanner.nextInt();

    List<Donor> donorList_1 = new ArrayList<Donor>();

    for(int i = 0; i < n; i++) {
      Donor donor = new Donor();
      System.out.println("-Donor " + i + "- ");
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

      donor.createDonor(name, age, address, contactNumber, bloodGroup, dateOfLastDonation);
      donorList_1.add(donor);
      System.out.println();
    }
// -----------------------------------------------------------------
    System.out.println();
    System.out.println("Bloood Bank 2:");
    System.out.println("Enter the number of regular donors in Vellore under Bank-1: ");
    n = keyboardScanner.nextInt();

    List<Donor> donorList_2 = new ArrayList<Donor>();

    for(int i = 0; i < n; i++) {
      Donor donor = new Donor();
      System.out.println("-Donor " + i + "-");
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

      donor.createDonor(name, age, address, contactNumber, bloodGroup, dateOfLastDonation);
      donorList_2.add(donor);
      System.out.println();
    }

    FileHandlingForDonorList fileHandler_1 = new FileHandlingForDonorList("./donors_1");
    fileHandler_1.writer(donorList_1);

    FileHandlingForDonorList fileHandler_2 = new FileHandlingForDonorList("./donors_2");
    fileHandler_2.writer(donorList_2);

    List<Donor> donorListReadFromFile_1 = fileHandler_1.reader();
    List<Donor> donorListReadFromFile_2 = fileHandler_2.reader();

    System.out.println();

    FileHandlingForDonorList fileHandler_repo = new FileHandlingForDonorList("./repo");
    fileHandler_repo.createRepository(donorListReadFromFile_1, donorListReadFromFile_2);

    List<Donor> donorListReadFromRepo = fileHandler_repo.reader();

    System.out.println();
    System.out.println("-Repository-");

    for(Donor donor: donorListReadFromRepo) {
      donor.displayDonorDetails();
      System.out.println();
    }
    // for(int i = 0; i < donorSetFromRepo.size(); i++) {
    //   donorSetFromRepo.get(i).displayDonorDetails();
    //   System.out.println(); // for new line
    // }
  }
}
