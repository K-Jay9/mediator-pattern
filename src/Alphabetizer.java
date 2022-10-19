import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class Alphabetizer {

	List<String> alphabetizesLines;

	List<String> rawInput = new ArrayList<>();

	public void addToAlphabetizedSet(String inputString) {
		rawInput.add(inputString);
	}

	public List<String> getAlphabetizedLines() {
		TreeSet<String> tree_set = new TreeSet<>(String.CASE_INSENSITIVE_ORDER);
		for (String line : rawInput) {
			tree_set.add(line);
		}
		alphabetizesLines = new ArrayList<>(tree_set);
		return alphabetizesLines;
	}
}
