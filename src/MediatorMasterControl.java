import java.util.ArrayList;
import java.util.List;

public class MediatorMasterControl implements Mediator {
	Input input = new Input(this);
	Output output = new Output();
	Alphabetizer alphabetizer = new Alphabetizer();
	CircularShifter circularShifter = new CircularShifter(this);

	List<String> alphabetizedOutput;
	List<String> readInput;
	List<String> circularOutput;

	MediatorMasterControl() {
		alphabetizedOutput = new ArrayList<>();
		readInput = new ArrayList<>();
		circularOutput = new ArrayList<>();
	}

	@Override
	public void shiftedLine(String string) {
		this.circularOutput.add(string);
		this.alphabetizer.addToAlphabetizedSet(string);
	}

	@Override
	public void inputProvidesNextLine(String string) {
		this.readInput.add(string);
		this.circularShifter.shiftLine(string);
	}

	@Override
	public void inputIsFinished() throws IllegalStateException {
	}

	public void start() {
		input.read();
		this.alphabetizedOutput = this.alphabetizer.getAlphabetizedLines();
		this.output.write(alphabetizedOutput);

	}
}