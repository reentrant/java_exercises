package startingOOP;

public class ExamplePassByReference {
	int value1;
	int value2;

	ExamplePassByReference() {
	}

	public static void main(String[] args) {
		ExamplePassByReference obj = new ExamplePassByReference();
		obj.setValue1(3);
		obj.setValue2(7);
		System.out.println(obj.toString());
		System.out.println("Current values: " + obj.getValue1() + ", " + obj.getValue2());
		passByReference(obj);
		System.out.println("Current values: " + obj.getValue1() + ", " + obj.getValue2());
	}

	static void passByReference(ExamplePassByReference ref) {
		System.out.println(ref.toString());
		int temp = ref.getValue1();
		ref.setValue1(ref.getValue2());
		ref.setValue2(temp);
	}
	
	void setValue1(int value) {
		this.value1 = value;
	}
	
	void setValue2(int value) {
		this.value2 = value;
	}

	int getValue1() {
		return this.value1;
	}
	
	int getValue2() {
		return this.value2;
	}
}
