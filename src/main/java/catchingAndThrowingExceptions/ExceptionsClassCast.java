package catchingAndThrowingExceptions;


public class ExceptionsClassCast {

	public static void main(String[] args){
		Vehicle[] vehiclesArray = {new Car("VW"), new Bike("green")};
		for (Vehicle v: vehiclesArray)
			System.out.println(v.toString());

		Vehicle car = new Car("Honda");
		System.out.println(car.wheels);
		try {
			Bike bicycle = (Bike) car;
			System.out.println(bicycle.wheels);	
		} catch (ClassCastException e){
			System.out.println(e);
			System.out.println(e.getStackTrace());
		}
		finally {
			System.out.println("Inside the finally block");
		}
	}
}

class Vehicle{
	int wheels;
	Vehicle(int wheels){
		this.wheels = wheels;
	}
}

class Car extends Vehicle{
	String maker;
	Car(String maker){
		super(4);
		this.maker = maker;
		
	}
}

class Bike extends Vehicle{
	String color;
	Bike(String color){
		super(2);
		this.color = color;
	}
}