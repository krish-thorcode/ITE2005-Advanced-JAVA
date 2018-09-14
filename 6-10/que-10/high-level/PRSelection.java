import java.util.Random;
import java.util.Collections;
import java.util.Map;
import java.util.HashMap;
import java.util.Arrays;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

class Counter implements Runnable {

  private int[] votes;
  List<Thread> counterThreads;
  int numOfCounterThreads;
  private int counter1, counter2, counter3;
  private int voteCountList[] = new int[3];
  private int startIndex, endIndex;
  private int equalPartitionSize, remainingVotesToBeCounted;
  private int numOfThreadsWhichAreDone;

  public Counter(int[] votes, int numOfCounterThreads) {
    this.votes = votes;
    this.numOfCounterThreads = numOfCounterThreads;
    counterThreads = new ArrayList<Thread>(this.numOfCounterThreads);
    counter1 = counter2 = counter3 = 0;

    this.equalPartitionSize = 240/numOfCounterThreads;
    this.remainingVotesToBeCounted = 240 - equalPartitionSize * numOfCounterThreads;
    // set the initial startIndex and endIndex based on the equal partitions and number of votes remaining to be counted after \
    // making the partitions out.
    this.startIndex = 0;
    this.endIndex = this.equalPartitionSize;

    this.numOfThreadsWhichAreDone = 0; // initially no threads would have finished

    for(int i = 0; i < this.numOfCounterThreads; i++)
      counterThreads.add(new Thread(this));
  }

  public int[] countVotes() throws InterruptedException {
    // System.out.println("Counter k andr..start kar rahe hain threads");
    for(int i = 0; i < this.numOfCounterThreads; i++)
      counterThreads.get(i).start();

    for(int i = 0; i < this.numOfCounterThreads; i++)
      counterThreads.get(i).join();

    voteCountList[0] = counter1;
    voteCountList[1] = counter2;
    voteCountList[2] = counter3;

    return voteCountList;
  }

  public void run() {

    // System.out.println("run k andr")
    // System.out.println("thread ka naam: " + Thread.currentThread().getName());
    synchronized(votes) {
      for(int i = this.startIndex; i < this.endIndex; i++) {
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
      numOfThreadsWhichAreDone++;
      if((240 - equalPartitionSize * numOfThreadsWhichAreDone) >= equalPartitionSize) {
        this.startIndex = equalPartitionSize * numOfThreadsWhichAreDone;
        this.endIndex = this.startIndex + equalPartitionSize;
      }
      else {
        this.startIndex = equalPartitionSize * numOfThreadsWhichAreDone;
        this.endIndex = this.startIndex + remainingVotesToBeCounted;
      }
    }
  }
}

public class PRSelection {
  public static void main(String args[]) throws InterruptedException {

    int numofStudents = 240;
    int votes[] = new int[240];
    int numOfCounterThreads;
    Random randomVoteGenerator = new Random();
    Scanner keyboard = new Scanner(System.in);

    System.out.print("Enter the number of threads needed: ");
    numOfCounterThreads = keyboard.nextInt();

    for(int i = 0; i < numofStudents; i++)
      votes[i] = randomVoteGenerator.nextInt(3) + 1;

    for(int i = 0; i < numofStudents; i++)
      System.out.println("Votes:\n" + votes[i]);

    Counter voteCounter = new Counter(votes, numOfCounterThreads);
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
