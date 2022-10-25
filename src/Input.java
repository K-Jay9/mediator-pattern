import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Input extends Colleague {
	Mediator mediatorInput;

	Input(Mediator mediator) {
		super(mediator);
		this.mediatorInput = mediator;

	}

	public void read() {

		try {
			File myObj = new File("kwic.txt");
			Scanner myReader = new Scanner(myObj);
			while (myReader.hasNext()) {
				String data = myReader.nextLine();
				this.mediatorInput.inputProvidesNextLine(data);

			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();

		}
		this.mediatorInput.inputIsFinished();
	}
}
