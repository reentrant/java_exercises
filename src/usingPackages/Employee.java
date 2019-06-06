package usingPackages;

public class Employee implements Cloneable {
	  
    private String name;
  
    public Employee(String name) {
        this.name = name;
    }
     
    public static void main(String[] args) {
        Employee emp = new Employee("Marisa");
        try {
            Employee emp2 = (Employee) emp.clone();
            System.out.println("Object 1:" + emp.toString());
            System.out.println("Cloned Object 2:" + emp2.toString());            
            if (emp == emp2) {
            	System.out.println(emp.equals(emp2));
            }
            	
            Employee emp3 = emp;
            if (emp == emp3) {
            	System.out.println("Aliased Object 3:" + emp3.toString());
            	System.out.println(emp.equals(emp3));
            }
            swap(emp, emp2);
            System.out.println("after swap Object 1:" + emp.toString());
            System.out.println("after swap Object 2:" + emp2.toString());    
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }
    
    public String getName() {
        return name;
    }
  
    public Object clone() throws CloneNotSupportedException{  
        return (Employee) super.clone();  
    }
    
    public static void swap(Employee one, Employee two) {
    	System.out.println("emp 1:" + one.toString());
    	System.out.println("emp 2:" + two.toString());
    	Employee aux = one;
    	one = two;
    	two = aux;
    	System.out.println("emp 1:" + one.toString());
    	System.out.println("emp 2:" + two.toString());
    }
}