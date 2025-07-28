package activities;

public class Activity7 {
	public static void main(String args[]) {
        Mountainbike mb = new Mountainbike(4, 0, 25);
        System.out.println(mb.bicycleDesc());
        mb.speedUp(19);
        mb.applyBrake(5);
    }
	
}
