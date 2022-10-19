import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CircularShifterTest implements Mediator {

	List<String> actual = new ArrayList<>();
	CircularShifter circularShifter;

	@BeforeEach
	void setUp() {
		circularShifter = new CircularShifter(this);
	}

	@Test
	void shift_2_lines_completely() {
		circularShifter.shiftLine("hi bye foo");
		circularShifter.shiftLine("hi bye");

		assertSame(5, actual.size());
		assertTrue(actual.contains("bye hi"));
		assertTrue(actual.contains("hi bye"));
		assertTrue(actual.contains("foo hi bye"));
		assertTrue(actual.contains("bye foo hi"));
		assertTrue(actual.contains("hi bye foo"));
	}

	@Override
	public void shiftedLine(String string) {
		actual.add(string);
	}

	@Override
	public void inputProvidesNextLine(String string) {
		fail("CircularShifter should not call this method");
	}

	@Override
	public void inputIsFinished() {
		fail("CircularShifter should not call this method");
	}
}
