import java.util.Random;

public class Question3_2 {

	public static void main(String[] args) {
		MyStack<Integer> testStack = populateStack();
		StackNode<Integer> min = testStack.min();
		System.out.println("\nMinimum value was " + min.getValue());
	}
	
	public static MyStack<Integer> populateStack() {
		MyStack<Integer> testStack = new MyStack<Integer>();
		Random randomizer = new Random(System.currentTimeMillis());
		for (int i = 0; i < 25; i++) {
			int value = randomizer.nextInt(100);
			System.out.print(value);
			if (i < 24)
				System.out.print(" ");
			else
				System.out.print(" <- Top of Stack\n");
			testStack.push(value);
		}
		return testStack;
	}
}
