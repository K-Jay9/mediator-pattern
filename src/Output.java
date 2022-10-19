import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class Output {

	public void write(List<String> lines) {
		try {
			FileWriter myObj = new FileWriter("kwic_output.txt");
			for (String line : lines) {
				myObj.write(line);
				myObj.write("\n");
			}
			myObj.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
