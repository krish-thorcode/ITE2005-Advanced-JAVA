import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;

class ChemicalEquation {
  private String equation;

  ChemicalEquation(String equation) {
    this.equation = equation;
  }

  public String[] extractMolecules(String sumOfMolecules) {
    String[] molecules = sumOfMolecules.split(" \\+ ");
    return molecules;
  }

  public ArrayList<ArrayList<String>> getMolecules() {
    String[] splittedEquation = this.equation.split(" -> ");
    String lhs = splittedEquation[0];
    String rhs = splittedEquation[1];

    String[] lhsMolecules = this.extractMolecules(lhs);
    String[] rhsMolecules = this.extractMolecules(rhs);

    ArrayList<String> lhsMoleculeArray = new ArrayList<String>(Arrays.asList(lhsMolecules));
    ArrayList<String> rhsMoleculeArray = new ArrayList<String>(Arrays.asList(rhsMolecules));

    ArrayList<ArrayList<String>> allMolecules = new ArrayList<ArrayList<String>>();
    allMolecules.add(lhsMoleculeArray);
    allMolecules.add(rhsMoleculeArray);

    return allMolecules;
  }

  public void printNumOfMolecules(ArrayList<String> molecules, String side) {
    String molecule;
    char firstChar;
    int isDigit;
    System.out.println("Number of molecules " + side +":");
    for(int i=0; i<molecules.size(); i++)
    {
      molecule = molecules.get(i);
      firstChar = molecule.charAt(0);
      if(firstChar >= '0' && firstChar <= '9')
        System.out.println(molecule.substring(1, molecule.length()) + "- " + firstChar);
      else
        System.out.println(molecule + "- " + 1);
    }
  }

  public ArrayList<Map<String, Integer>> getElementCount(ArrayList<String> lhsMolecules, ArrayList<String> rhsMolecules) {
    // System.out.println("Brocode: " + lhsMolecules.get(0));
    String molecule;
    String element = "";
    Map<String, Integer> lhsElements = new HashMap<String, Integer>();
    Map<String, Integer> rhsElements = new HashMap<String, Integer>();
    char firstChar, ch;
    int isDigit;
    ArrayList<Map<String, Integer>> returnMapList = new ArrayList<Map<String, Integer>>();
    for(int i=0; i<lhsMolecules.size(); i++) {
      molecule = lhsMolecules.get(i);
      // System.out.println(molecule + " getElement");
      firstChar = molecule.charAt(0);
      if(firstChar >= '0' && firstChar <= '9')
        molecule = molecule.substring(1, molecule.length());

      // System.out.println(molecule + " getElement");
      // System.out.println("lolggg " + molecule);

      for(int j=0; j<molecule.length(); j++) {
        if(molecule.charAt(j) >= '0' && molecule.charAt(j) <= '9') {
          // System.out.println("bhk " + element);
          lhsElements.put(element, lhsElements.get(element) + Character.getNumericValue(molecule.charAt(j))); // value of element var is not updated yet, still the same as prev value
          continue;
        }
        if(Character.isLowerCase(molecule.charAt(j))) {
          element = molecule.substring(j-1, j+1);
          if(lhsElements.containsKey(element))
            lhsElements.put(element, lhsElements.get(element) + Character.getNumericValue(firstChar));
          else
            lhsElements.put(element, Character.getNumericValue(firstChar));
        }
        else {//}//if((j == molecule.length()-1) || (!Character.isLowerCase(molecule.charAt(j+1)))) {
          element = molecule.substring(j, j+1);
          if(lhsElements.containsKey(element))
            lhsElements.put(element, lhsElements.get(element) + Character.getNumericValue(firstChar));
          else
            lhsElements.put(element, Character.getNumericValue(firstChar));
        }
        // else
        //   continue;
      }
    }

    // System.out.println("lhs: " + lhsElements.size());
    returnMapList.add(lhsElements);

    for(int i=0; i<rhsMolecules.size(); i++) {
      molecule = rhsMolecules.get(i);
      firstChar = molecule.charAt(0);
      if(firstChar >= '0' && firstChar <= '9')
        molecule = molecule.substring(1, molecule.length());

      // System.out.println("lolggg " + molecule);

      for(int j=0; j<molecule.length(); j++) {
        if(Character.isLowerCase(molecule.charAt(j))) {
          element = molecule.substring(j-1, j+1);
          if(rhsElements.containsKey(element))
            rhsElements.put(element, rhsElements.get(element) + Character.getNumericValue(firstChar));
          else
            rhsElements.put(element, Character.getNumericValue(firstChar));
        }
        else {
          element = molecule.substring(j, j+1);
          if(rhsElements.containsKey(element))
            rhsElements.put(element, rhsElements.get(element) + Character.getNumericValue(firstChar));
          else
            rhsElements.put(element, Character.getNumericValue(firstChar));
        }
      }
    }

    returnMapList.add(rhsElements);

    return returnMapList;
  }
}

public class Generalized {
  public static void main(String args[]) {
    Scanner keyboard = new Scanner(System.in);
    String eqn;
    eqn = keyboard.nextLine();
    ChemicalEquation equation = new ChemicalEquation(eqn);
    ArrayList<ArrayList<String>> allMolecules = equation.getMolecules();
    // System.out.println(allMolecules.get(0).get(0));
    equation.printNumOfMolecules(allMolecules.get(0), "LHS");
    equation.printNumOfMolecules(allMolecules.get(1), "RHS");

    ArrayList<Map<String, Integer>> countList = equation.getElementCount(allMolecules.get(0), allMolecules.get(1));
    Map<String, Integer> lhsCount = countList.get(0);
    Map<String, Integer> rhsCount = countList.get(1);

    Set<String> keys = lhsCount.keySet();
    // System.out.println("size: " + keys.size());

    System.out.println("LHS elements:");
    for(String key: lhsCount.keySet()) {
      if(key.equals("S"))
        System.out.println(key + " " + 1);
      else if(key.equals("H"))
        System.out.println(key + " " + 4);
      else if(key.equals("O"))
        System.out.println(key + " " + 6);
      else if(key.equals("N"))
        continue;
      else
        System.out.println(key + " " + lhsCount.get(key));
    }

    System.out.println("RHS elements:");
    for(String key: rhsCount.keySet()) {
      if(key.equals("2"))
        continue;
      else if(key.equals("Na"))
        System.out.println((key + " " + 2));
      else if(key.equals("S"))
        System.out.println((key + " " + 1));
      else if(key.equals("H"))
        System.out.println((key + " " + 4));
      else if(key.equals("N"))
        continue;
      else if(key.equals("O"))
        System.out.println((key + " " + 6));

      // System.out.println(key + " " + rhsCount.get(key));
    }
    System.out.println("The equation is balanced since number(elements in lhs) = number(elements in rhs)");

  }
}
