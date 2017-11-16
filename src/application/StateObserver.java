package application;

public abstract class StateObserver {
	protected MovieFactory movie;
	abstract void update();
}
