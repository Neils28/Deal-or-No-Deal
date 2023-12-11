package deal.Game;

import java.util.EmptyStackException;

public class ArrayStack<String> implements DSStack<String> {

	private String[] stack; // holding our data
	private int size;
	private int cap;

	public ArrayStack(int capacity) {
		size = 0;
		if (capacity < 1) {
			throw new IllegalArgumentException("Capacity must be positive");
		}
		cap = capacity;
		stack = (String[]) (new Object[capacity]);
	} // ArrayStack constructor

	@Override
	public boolean isEmpty() {
		return (size == 0);
	}
	
	@Override
	public void push(String element) {
		if (size == cap) {
			throw new RuntimeException("Stack Overfloe");
		}
		stack[size++] = element;
	} // Push
	
	@Override 
	public String pop() {
		if (isEmpty()) {
			throw new EmptyStackException();
		}
		return (stack[--size]);
	} //pop
	
	@Override
	public String top() {
		if (isEmpty()) {
			return null;
		}
		return (stack[size-1]);
	} // top
}
