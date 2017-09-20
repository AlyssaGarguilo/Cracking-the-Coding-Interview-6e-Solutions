import java.util.ArrayList;

class SetOfStacks<T extends Number & Comparable<? super T>> {

	private int threshold;
	private ArrayList<MyStack<T>> stacks;
	private int stackIndex;
	private int elementsInCurrentStack;

	public SetOfStacks(int threshold) {
		this.threshold = threshold;
		stacks = new ArrayList<MyStack<T>>();
		stacks.add(new MyStack<T>());
		stackIndex = 0;
		elementsInCurrentStack = 0;
	}

	public int getStackIndex() {
		return stackIndex;
	}

	public int getElementsInCurrentStack() {
		return elementsInCurrentStack;
	}

	public void push(T item) {
		if (elementsInCurrentStack < threshold) {
			stacks.get(stackIndex).push(item);
			elementsInCurrentStack++;
		} else if (elementsInCurrentStack == threshold) {
			stacks.get(stackIndex).push(item);
			stacks.add(new MyStack<T>());
			stackIndex++;
			stacks.get(stackIndex).push(item);
			elementsInCurrentStack = 1;
		}
	}

	public T pop() {
		T popped = stacks.get(stackIndex).pop();
		elementsInCurrentStack--;
		if (elementsInCurrentStack == 0 && stackIndex > 0) {
			stacks.remove(stackIndex);
			elementsInCurrentStack = threshold;
			stackIndex--;
		}
		return popped;
	}
}
