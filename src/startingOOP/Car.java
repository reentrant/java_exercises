package startingOOP;

/**
 * Constructors
 */

public class Car {

	String color;
	boolean lights;
	
	/**
     * Creates a new car
     *
     * @param c  the car color
     * @param l  the state of the car lights
     */
	public Car(String c, boolean l){
            this.color = c;
            this.lights = l;
    	}
	
	public void printCarInformation(){
	    String state = "";
	    if(lights){
	        state = "on";
	    }else{
	        state = "off";
	    }
	    System.out.println("This car is " + color + " and lights are " + state);
	}
	
	public static void main(String[] args) {
		Car c = new Car("green",true);
		System.out.println("We have created a car!");
		c.printCarInformation();
	}
}