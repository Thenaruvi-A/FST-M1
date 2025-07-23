package activities;

public class Car {
	String color;
    String transmission;
    int make;
    int tyres;
    int doors;
    
   public Car(String color, String transmission, int make) {
	   this.color=color;
	   this.transmission=transmission;
	   this.make=make;
       this.tyres=4;
       this.doors=4;
}

   public void displayCharacteristics()
   {
	    System.out.println("Color of the Car: " + color);
	    System.out.println("Make of the Car: " + make);
		System.out.println("Transmission of the Car: " + transmission);
		System.out.println("Number of doors on the car: " + doors);
	    System.out.println("Number of tyres on the car: " + tyres);
	   
   }
   public void accelarate()
   {
	   System.out.println("MOVE");   
	   
   }
   public void brake()
   {
	System.out.println("STOP");
	   
   }
}
