import java.util.EmptyStackException;

public class MyStack<T extends Number & Comparable<? super T>> {

		
		private StackNode<T> top;
		
		public T pop() {
			if (top == null)
				throw new EmptyStackException();
			T item = top.getValue();
			top = top.getNext();
			return item;
		}
		
		public void push(T item) {
			StackNode<T> newTop = new StackNode<T>(item);
			newTop.setNext(top);
			top = newTop;
		}
		
		public T peek() {
			if (top == null)
				throw new EmptyStackException();
			return top.getValue();
		}
		
		public boolean isEmpty() {
			return top == null;
		}
		
		public StackNode<T> min() {
			MyStack<T> tempStack = new MyStack<T>();
			StackNode<T> min = new StackNode<T>(this.peek());
			// Pop everything off looking for min, saving values
			while (!this.isEmpty()) {
				if (peek().compareTo(min.getValue()) < 0)
					min = new StackNode<T>(this.peek());
				tempStack.push(this.pop());
			}
			// Push everything back on
			while (!tempStack.isEmpty()) {
				System.out.print(tempStack.peek() + " ");
				this.push(tempStack.pop());
			}
			return min;
		}
		
}