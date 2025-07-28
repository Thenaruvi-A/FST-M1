package activities;
public class Mountainbike extends Bicycle {
	public int seatHeight;
	
    public Mountainbike(int gears, int currentSpeed, int startHeight) {
        super(gears, currentSpeed);
        seatHeight = startHeight;
    }

    
    public void setHeight(int newValue) {
        seatHeight = newValue;
    }


    public String bicycleDesc() {
    return (super.bicycleDesc()+ "\nSeat height is " + seatHeight);
}  
}

