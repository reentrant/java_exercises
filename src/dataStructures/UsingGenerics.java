package dataStructures;

public class UsingGenerics<E> {
private E attribute;
	public UsingGenerics(E value){
		this.set(value);
	}
    
    public void set (E value){
        this.attribute = value;
    }
    
    public E get(){
        return attribute;
    }
    
	public static void main(String[] args) {
		UsingGenerics<Integer> intObj = new UsingGenerics<Integer>(3);
		UsingGenerics<String> strObj = new UsingGenerics<String>("June");

	    System.out.println(intObj.get());
	    System.out.println(strObj.get());
	}

}
