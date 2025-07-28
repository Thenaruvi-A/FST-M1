package javaactivities;

public class Activity6 {

	public static void main(String[] args) throws InterruptedException{
		Plane plane = new Plane(10);
		plane.onboard("Sai");
		plane.onboard("White");
		plane.onboard("Red");
		System.out.println("take-off time " + plane.takeOff());
		System.out.println("List of passengers " + plane.getPassengers());
		Thread.sleep(1000);//plane in flight
		plane.land();
		System.out.println("Landed @ " + plane.getLastTimeLanded());
		System.out.println("passengers after landing " + plane.getPassengers());
	}
}