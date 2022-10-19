import static org.junit.jupiter.api.Assertions.*;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class InputTest implements Mediator {

	List<String> actual = new ArrayList<>();
	boolean isFinished;
	Input input;

	@BeforeEach
	void setUp() {
		input = new Input(this);
		isFinished = false;
	}

	@Test
	void input_from_scanner() throws IOException {
		List<String> lines = new ArrayList<>();
		lines.add("Descent of Man");
		lines.add("The Ascent of Man");
		lines.add("The Old Man and The Sea");
		lines.add("A Portrait of The Artist As a Young Man");
		FileWriter fileWriter = new FileWriter("kwic.txt");
		for (String line : lines) {
			fileWriter.write(line);
			fileWriter.write("\n");
		}
		fileWriter.close();

		input.read();

		assertSame(4, actual.size());
		assertEquals("Descent of Man", actual.get(0));
		assertEquals("The Ascent of Man", actual.get(1));
		assertEquals("The Old Man and The Sea", actual.get(2));
		assertEquals("A Portrait of The Artist As a Young Man", actual.get(3));
		assertTrue(isFinished);
	}

	@Override
	public void shiftedLine(String string) {
		fail("Input should not call this method");
	}

	@Override
	public void inputProvidesNextLine(String string) {
		actual.add(string);
	}

	@Override
	public void inputIsFinished() {
		isFinished = true;
	}
}
