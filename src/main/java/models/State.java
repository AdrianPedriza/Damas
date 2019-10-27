package models;

public class State {
		
	private StateValue stateValue;
	
	public State() {
		this.stateValue = StateValue.INITIAL;
	}

	public State(StateValue stateValue) {
		this.stateValue = stateValue;
	}
	
	public void next() {
		this.stateValue = StateValue.values()[this.stateValue.ordinal()+1];
	}
	
	public void reset() {
		this.stateValue = StateValue.INITIAL;
	}

	public void setStateValue(StateValue stateValue) {
		this.stateValue = stateValue;
	}

	public StateValue getValue() {
		return this.stateValue;
	}
	
}