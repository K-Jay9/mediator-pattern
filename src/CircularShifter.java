public class CircularShifter extends Colleague {

	Mediator mediatorCircular;
	Alphabetizer alphabetizer = new Alphabetizer();

	CircularShifter(Mediator mediator) {
		super(mediator);
		this.mediatorCircular = mediator;

	}

	public void shiftLine(String string) {
		String res = "";
		String[] arr = new String[string.length()];
		arr = string.split(" ");
		int k = arr.length;
		while (k-- > 0) {
			String tmp = arr[0];
			for (int i = 1; i < arr.length; i++) {
				arr[i - 1] = arr[i];
			}
			arr[arr.length - 1] = tmp;
			for (String st : arr) {
				res += st + " ";
			}

			this.mediatorCircular.shiftedLine(res.trim());
			this.alphabetizer.addToAlphabetizedSet(res.trim());
			res = "";
		}

	}

}
