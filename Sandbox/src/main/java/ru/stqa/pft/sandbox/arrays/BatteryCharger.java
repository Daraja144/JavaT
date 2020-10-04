package ru.stqa.pft.sandbox.arrays;

public class BatteryCharger {

    /** rateTable has 24 entries representing the charging costs for hours 0 through 23. */
    private int[] rateTable;



	public BatteryCharger()
    {
      //you must complete this constructor
      //size the array
      //set the values for the cost of each hour
      //0   1  2   3  4  5
      //50 60 160 60 80 100 100 120 150 150 150 200 40 240 220 220 200 200 180 180 140 100 80 60

    }



	public BatteryCharger( String vals )
    {
      //you must complete this constructor
      //size the array
      //get the values from the string and put them in the array

    }



    /** Determines the total cost to charge the battery starting at the beginning of startHour.
     *	@param startHour the hour at which the charge period begins
     *	Precondition: 0 ??startHour ??23
     *	@param chargeTime the number of hours the battery needs to be charged
     *	Precondition: chargeTime > 0
     *	@return the total cost to charge the battery
     */
    public int getChargingCost(int startHour, int chargeTime)
    {
      /* to be implemented in part (a)  */
      return 0;
    }



    /** Determines start time to charge the battery at the lowest cost for the given charge time.
     *	@param chargeTime the number of hours the battery needs to be charged
     *	Precondition: chargeTime > 0
     *	@return an optimal start time, with 0 ??returned value ??23
     */
    public int getChargeStartTime(int chargeTime)
    {
      /* to be implemented in part (b)  */
      return 0;
    }

    public String toString()
    {
      //this method should return the rateTable as a String
      return "write your toString";
    }

  public static void main(String[] args) {

    BatteryCharger bob = new BatteryCharger();
    System.out.println( bob );

    System.out.println( bob.getChargingCost( 12, 1 ) );   //outs 40
    System.out.println( bob.getChargingCost( 0, 2 ) );   //outs 110
    System.out.println( bob.getChargingCost( 22, 7 ) );   //outs 550
    System.out.println( bob.getChargingCost( 22, 30 ) );   //outs 3710

    System.out.println( bob.getChargeStartTime( 1 ) );   //outs 12
    System.out.println( bob.getChargeStartTime( 2 ) );   //outs 0 or 23
    System.out.println( bob.getChargeStartTime( 7 ) );   //outs 22
    System.out.println( bob.getChargeStartTime( 30 ) );   //outs 22




    String s = "50 60 160 60 80 100 100 120 150 150 150 200 40 240 220 220 200 200 180 180 140 100 80 60";
    BatteryCharger ann = new BatteryCharger( s );
    System.out.println( ann );

    System.out.println( ann.getChargingCost( 12, 1 ) );   //outs 40
    System.out.println( ann.getChargingCost( 0, 2 ) );   //outs 110
    System.out.println( ann.getChargingCost( 22, 7 ) );   //outs 550
    System.out.println( ann.getChargingCost( 22, 30 ) );   //outs 3710


    System.out.println( ann.getChargeStartTime( 1 ) );   //outs 12
    System.out.println( ann.getChargeStartTime( 2 ) );   //outs 0 or 23
    System.out.println( ann.getChargeStartTime( 7 ) );   //outs 22
    System.out.println( ann.getChargeStartTime( 30 ) );   //outs 22
  }
}

/*
public class BatteryCharger {

	private int[] rateTable = {50,60,160,60,80,100,100,120,150,150,150,200,40,240,220,220,200,200,180,180,140,100,80,60};

	// Really, nothing to do here...
	public BatteryCharger() {
	}

	// Solution to part (a).
	private int getChargingCost(int startHour, int chargeTime) {

		int sum = 0;

		// Add up the charge for each hour. Note the use of the mod operator
		// in the index to the rateTable array.
		for (int i=startHour; i<startHour+chargeTime; i++)
			sum += rateTable[i%24];

		return sum;
	}

	public int getChargeStartTime(int chargeTime) {

		// Set up the initial best start time and cost.
		int bestTime = 0;
		int bestCost = getChargingCost(0, chargeTime);

		// Let's see if any other time beats it.
		for (int i=1; i<24; i++) {

			int newCost = getChargingCost(i, chargeTime);

			// Update our best time and cost, if necessary.
			if (newCost < bestCost) {
				bestCost = newCost;
				bestTime = i;
			}
		}

		return bestTime;
	}

	public static void main(String[] args) {

		// Mostly a dummy object; gives us access to the table...
		BatteryCharger b = new BatteryCharger();

		// Print out the best start time for each distinct duration.
		for (int i=1; i<24; i++)
			System.out.println("The best start time for charging "+i+" hours is "+b.getChargeStartTime(i));

	}
}
 */
