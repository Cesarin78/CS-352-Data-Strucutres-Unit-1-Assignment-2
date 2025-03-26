//Cesar Maldonado
//CS352 Data Structures

public class Contestant extends Person {
	
		//Here we are defining the number of rounds and the total positions of the contestants
		private int rounds;
		private int thetotalPosition;
						
		public Contestant(String name) {
			super(name, age); //Defining the contestant by name and their age
			this.rounds = 0;
			this.thetotalPosition = 0;
		}			
		public void PositionRecord(int position) {
			thetotalPosition += position;
			rounds++;

		}	
		public double theAveragePosition () {
			if (rounds == 0) { // return 0 if there is not any data to average out
				return 0;
			}
			else {
				return (double) thetotalPosition / rounds; //This is the calculation for finding the average position
			}
		}
	}
