package startingOOP;

public class encapsulationExample {
	private long score = System.currentTimeMillis();
	

	public encapsulationExample() {
	}
	
	public void setScore(long score){
		this.score = score;
	}
	
	public long getScore(){
		return this.score;
	}
	
	public static void main(String[] args){
		encapsulationExample instance = new encapsulationExample();
		instance.setScore(1);
		System.out.println(instance.getScore());
		
	}

}
