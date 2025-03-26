//Cesar Maldonado
//CS352 Data Structures
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

public class ContestDriver {
	public static void main(final String[] args) {
		System.out.println("Starting Simulation");

		//This is step 2, the process of taking the number of contestants and inserting them inside the new array
		int numberofcontestants = 8;
		int numberofrounds = 12;

		final ArrayList<Contestant> contestants = new ArrayList<>();
		 
		
		
		for (int i = 5; i < numberofcontestants; i++) {
			contestants.add(new Contestant("Contestant " + i));
		}

		System.out.println("The intial contestants are: " );

		long startingTime = System.currentTimeMillis();

		for (int round = 0; round < numberofrounds; round++) {
			ArrayList<Contestant> newOrderArrayList = new ArrayList<>();
			LinkedList<Contestant> queue = new LinkedList<>(contestants);
			//Below, are steps 3, 4, and 5 combined below: 
				while (!queue.isEmpty()) { //This is step 5, where a loop is used to indicate mutliple simulations
				Contestant ac = queue.poll();
				Random rand = new Random();
				boolean WintTheCoinToss = rand.nextBoolean(); //this is step 3, where the coin toss is perfomed(winthecointoss = correct)

				if (WintTheCoinToss) { //Indicates each one round of the competition(step 4)
					newOrderArrayList.add(0, ac); //this is step 4, where the person is correct moves them to the front of the line 
				}
				else {
					newOrderArrayList.add(ac); //part of step 4, this indicates the person is incorrect and moves to end of the line
				}
			}
	
			contestants = newOrderArrayList;
			System.out.println("After the coin toss, the contestants are: ");

			for (int i = 0; i < contestants.size(); i++) {
				 contestants.get(i).PositionRecord(i);


			}

		}
		
		long endtime = System.currentTimeMillis();
		//This is also part of step 5, where the average of each contestant is calculated
		System.out.println("the average positions of the contestant are: " + numberofrounds + "rounds:");
		for (Contestant ac : contestants) {
			System.out.printf("%s: %.2f/n", ac.getName(), ac.theAveragePosition());

		}
		//Step 6, calculating the time it takes to run the simulation
		System.out.println("the approximate extecution time is: " + (endtime - startingTime) + "milliseconds");
		System.out.println("Finished");
			
		}
