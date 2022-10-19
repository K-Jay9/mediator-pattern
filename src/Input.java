import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Input extends Colleague {

	Input(Mediator mediator) {
		super(mediator);

	}

	public void read() {

		try {
			File myObj = new File("kwic.txt");
			Scanner myReader = new Scanner(myObj);
			while (myReader.hasNext()) {
				String data = myReader.nextLine();
				this.providesNextLine(data);

			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();

		}
		this.inputIsFinished();
	}
}
