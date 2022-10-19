public abstract class Colleague {
	private Mediator mediator;

	public Colleague(Mediator newMediator) {
		mediator = newMediator;
	}

	public void shiftedLine(String string) {
		mediator.shiftedLine(string);
	}

	public void inputIsFinished() {
		mediator.inputIsFinished();
	}

	public void providesNextLine(String string) {
		mediator.inputProvidesNextLine(string);
	}
}
