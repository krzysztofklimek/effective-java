package com.example.demo.common.to.all.objects.item13;

import java.util.Arrays;
import java.util.EmptyStackException;

public class Stack {
	private Object[] elements;
	private int size = 0;
	private static final int DEFAULT_INITIAL_CAPACITY = 16;

	public Stack() {
		elements = new Object[DEFAULT_INITIAL_CAPACITY];
	}

	public void push(Object e) {
		ensureCapacity();
		elements[size++] = e;
	}

	public Object pop() {
		if (size == 0)
			throw new EmptyStackException();
		Object result = elements[--size];
		elements[size] = null; // Eliminate obsolete reference
		return result;
	}

	/**
	 * Ensure space for at least one more element, roughly
	 * doubling the capacity each time the array needs to grow.
	 */
	private void ensureCapacity() {
		if (elements.length == size)
			elements = Arrays.copyOf(elements, 2 * size + 1);
	}

// 	Clone method for class with references to mutable state. If the clone method merely  returns super.clone(), the
// 	resulting Stack instance will have the correct value in its size field, but its elements field will refer to the
// 	same array as the original Stack instance. Modifying the original will destroy the invariants in the clone and
//	vice versa. You will quickly find that your program produces nonsensical results or throws a NullPointerException.
//	Note that we do not have to cast the result of elements.clone to Object[]. Calling clone on an array returns an
//	array whose runtime and compile-time types are identical to those of the array being cloned. This is the preferred
//	idiom to duplicate an array. In fact, arrays are the sole compelling use of the clone facility. Note also that the
//	earlier solution would not work if the elements field were final because clone would be prohibited from assigning
//	a new value to the field. This is a fundamental problem: like serialization, the Cloneable architecture is
//	incompatible with normal use of final fields referring to mutable objects, except in cases where the mutable objects
//	may be safely shared between an object and its clone. In order to make a class cloneable, it may be necessary to
//	remove final modifiers from some fields.
	@Override
	public Stack clone() {
		try {
			Stack result = (Stack) super.clone();
			result.elements = elements.clone();
			return result;
		} catch (CloneNotSupportedException e) {
			throw new AssertionError();
		}
	}
}
