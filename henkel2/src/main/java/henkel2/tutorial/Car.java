package henkel2.tutorial;

public class Car {
	
	private Engine engine;
	
	private String warningMessage;
	
	public Car(Engine engine){
		this.engine = engine;
	}
	
	
	public String getWarningMessage() {
		
		return warningMessage;
	}

	public void setWarningMessage(String warningMessage) {
		this.warningMessage = warningMessage;
	}
	
	public void accelerate(){
		engine.increaseRpm();
		if(engine.getRpm() > 5000){
			this.warningMessage = "Slow Down!!!";
		}
		
	}

	
	

}
