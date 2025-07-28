package activities;

interface BicycleParts{

    public int tyres=2; // public static final
    public int maxSpeed=46; 
}

interface BicycleOperations{

	 void applyBrake(int decrement); //by default the code is abstract & public
	 void speedUp(int increment);
}

public class Bicycle implements BicycleParts, BicycleOperations{
	
	int gears;
	int currentSpeed;
	
	
	
	public Bicycle(int gears, int CurrentSpeed) {
		this.gears= gears;
		this.currentSpeed= CurrentSpeed;
			}

	  public void applyBrake(int decrement) {
	        currentSpeed -= decrement;
	        System.out.println("Current speed: " + currentSpeed);
	    }

	    public void speedUp(int increment) {
	        currentSpeed += increment;
	        System.out.println("Current speed: " + currentSpeed);
	    }

	   
	    public String bicycleDesc() {
	        return("No of gears are "+ gears + "\nSpeed of bicycle is " + maxSpeed + "\nNo of tyres" + tyres);
	    }
	}
