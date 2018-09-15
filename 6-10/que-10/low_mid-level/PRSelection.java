import java.util.Random;
import java.util.Collections;
import java.util.Map;
import java.util.HashMap;
import java.util.Arrays;

class Counter implements Runnable {

  private int[] votes;
  Thread counterThread1, counterThread2, counterThread3, counterThread4;
  private int counter1, counter2, counter3;
  private int voteCountList[] = new int[3];

  public Counter(int[] votes) {
    this.votes = votes;
    this.counter1 = this.counter2 = this.counter3 = 0;
    counterThread1 = new Thread(this);
    counterThread1.setName("counter1");
    counterThread2 = new Thread(this);
    counterThread2.setName("counter2");
    counterThread3 = new Thread(this);
    counterThread3.setName("counter3");
    counterThread4 = new Thread(this);
    counterThread4.setName("counter4");
  }

  public int[] countVotes() throws InterruptedException {
    // System.out.println("Counter k andr..start kar rahe hain threads");
    counterThread1.start();
    counterThread2.start();
    counterThread3.start();
    counterThread4.start();
    counterThread1.join();
    counterThread2.join();
    counterThread3.join();
    counterThread4.join();

    voteCountList[0] = counter1;
    voteCountList[1] = counter2;
    voteCountList[2] = counter3;

    return voteCountList;
  }

  public void run() {

    // System.out.println("run k andr");
    int startIndex = 0, endIndex = 0;
    // System.out.println("thread ka naam: " + Thread.currentThread().getName());
    synchronized(votes) {
      if(Thread.currentThread().getName() == "counter1") {
        startIndex = 0;
        endIndex = 60;
      }
      if(Thread.currentThread().getName() == "counter2") {
        startIndex = 60;
        endIndex = 120;
      }
      if(Thread.currentThread().getName() == "counter3") {
        startIndex = 120;
        endIndex = 180;
      }
      if(Thread.currentThread().getName() == "counter4") {
        startIndex = 180;
        endIndex = 240;
      }


      for(int i = startIndex; i < endIndex; i++) {
        // System.out.println("Inside the loop to count votes.");
        if(votes[i] == 1) {
          counter1++;
          // System.out.println("counter1= " + counter1);
        }
        if(votes[i] == 2) {
          counter2++;
          // System.out.println("counter1= " + counter2);
        }
        if(votes[i] == 3) {
          counter3++;
          // System.out.println("counter1= " + counter3);
        }
      }
    }
  }
}

public class PRSelection {
  public static void main(String args[]) throws InterruptedException {

    int numofStudents = 240;
    int votes[] = new int[240];
    Random randomVoteGenerator = new Random();

    for(int i = 0; i < numofStudents; i++)
      votes[i] = randomVoteGenerator.nextInt(3) + 1;

    // for(int i = 0; i < numofStudents; i++)
    //   System.out.print("Votes:\n" + votes[i]);

    Counter voteCounter = new Counter(votes);
    int voteCountList[] = voteCounter.countVotes();

    int totalVotes = 0;
    for(int i = 0; i < 3; i++)
      totalVotes += voteCountList[i];

    int maxVotes, indexOfMaxVotes = 0;

    maxVotes = voteCountList[indexOfMaxVotes];
    for(int i = 1; i < 3; i++) {
      if (voteCountList[i] > maxVotes) {
        indexOfMaxVotes = i;
        maxVotes = voteCountList[indexOfMaxVotes];
      }
    }

    System.out.println("Total votes: " + totalVotes);
    System.out.println("Highest votes: " + maxVotes);
    // System.out.println("Candidate " + indexOfMaxVotes);
    if(indexOfMaxVotes == 0)
      System.out.println("Candidate A won.");

    if(indexOfMaxVotes == 1)
      System.out.println("Candidate B won.");

    if(indexOfMaxVotes == 2)
      System.out.println("Candidate C won.");


  }
}
