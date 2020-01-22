package startingOOP;

import java.util.Arrays;
import java.util.Scanner;


class Day12Inheritance {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String firstName = scan.next();
		String lastName = scan.next();
		int id = scan.nextInt();
		int numScores = scan.nextInt();
		int[] testScores = new int[numScores];
		for(int i = 0; i < numScores; i++){
			testScores[i] = scan.nextInt();
		}
//		System.out.println(testScores);
		scan.close();
		
		Student s = new Student(firstName, lastName, id, testScores);
		s.printPerson();
		System.out.println("Grade: " + s.calculate() );
	}
}

class Human {
	protected String firstName;
	protected String lastName;
	protected int idNumber;
	
	public Human() {
		// TODO Auto-generated constructor stub
	}
	
	
	// Constructor
	Human(String firstName, String lastName, int identification){
		this.firstName = firstName;
		this.lastName = lastName;
		this.idNumber = identification;
	}
	
	// Print person data
	public void printPerson(){
		 System.out.println(
				"Name: " + lastName + ", " + firstName 
			+ 	"\nID: " + idNumber); 
	}
	 
}

class Student extends Human{
	

	private int[] testScores;

    /*	
    *   Class Constructor
    *   
    *   @param firstName - A string denoting the Person's first name.
    *   @param lastName - A string denoting the Person's last name.
    *   @param id - An integer denoting the Person's ID number.
    *   @param scores - An array of integers denoting the Person's test scores.
    */
    // Write your constructor here
	Student(String firstName, String lastName, int id, int[] scores) {
		super(firstName, lastName, id);
		this.testScores = scores;
		System.out.println("scores = " + Arrays.toString(scores));
	}
    /*	
    *   Method Name: calculate
    *   @return A character denoting the grade.
    */
    // Write your method here
	public char calculate(){
		float total = 0, average;
		char grade;
		for (int i = 0; i < this.testScores.length; i++){
			total += this.testScores[i];
		}
		average = total/this.testScores.length;
		if (average >= 90){
			grade = 'O';
		}else if (average >= 80 && average < 90){
			grade = 'E';
		}else if (average >= 70 && average < 80){
			grade = 'A';
		}else if (average >=55 && average < 70){
			grade = 'P';
		}else if (average >= 40 && average < 55){
			grade = 'D';
		}else{
			grade = 'T';
		}
		
		return grade;
	}
}
