import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AlphabetizerTest {

	Alphabetizer alphabetizer;

	@BeforeEach
	void setUp() {
		alphabetizer = new Alphabetizer();
	}

	@Test
	void alpha_2_lines() {
		alphabetizer.addToAlphabetizedSet("hi bye foo");
		alphabetizer.addToAlphabetizedSet("bye hi");

		List<String> actual = alphabetizer.getAlphabetizedLines();
		assertSame(2, actual.size());
		assertEquals("bye hi", actual.get(0));
		assertEquals("hi bye foo", actual.get(1));
	}

}
