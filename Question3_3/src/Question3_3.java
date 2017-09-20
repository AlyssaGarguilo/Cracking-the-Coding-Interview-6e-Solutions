import java.util.Random;

class Question3_3 {

	public static void main(String[] args) {
		int threshold = 9;
		SetOfStacks<Integer> setOfStacks = new SetOfStacks<Integer>(threshold);
		Random randomizer = new Random(System.currentTimeMillis());
		for (int i = 0; i < 33; i++) {
			int value = randomizer.nextInt(100);
			System.out.println("Adding value " + value +
					" to stack " + setOfStacks.getStackIndex() +
					" at position " + setOfStacks.getElementsInCurrentStack());
			setOfStacks.push(value);
		}	
	}

}
