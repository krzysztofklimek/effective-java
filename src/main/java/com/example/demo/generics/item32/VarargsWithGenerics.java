package com.example.demo.generics.item32;

import java.util.concurrent.ThreadLocalRandom;

public class VarargsWithGenerics {

	// UNSAFE - Exposes a reference to its generic parameter array! It is worth noting that you can violate type safety
	// without ever storing anything in the varargs parameter array. Consider the following generic varargs method,
	// which returns an array containing its parameters. At first glance, it may look like a handy little utility. This
	// method simply returns its varargs parameter array. The method may not look dangerous, but it is! The type of this
	// array is determined by the compile-time types of the arguments passed in to the method, and the compiler may not
	// have enough information to make an accurate determination. Because this method returns its varargs parameter
	// array, it can propagate heap pollution up the call stack.
	static <T> T[] toArray(T... args) {
		return args;
	}

	// Consider the following generic method, which takes three arguments of type T and returns an array containing two
	// of the arguments, chosen at random. This method is not, in and of itself, dangerous and would not generate a
	// warning except that it invokes the toArray method, which has a generic varargs parameter. When compiling this
	// method, the compiler generates code to create a varargs parameter array in which to pass two T instances to
	// toArray . This code allocates an array of type Object[] , which is the most specific type that is guaranteed to
	// hold these instances, no matter what types of objects are passed to pickTwo at the call site. The toArray method
	// simply returns this array to pickTwo , which in turn returns it to its caller, so pickTwo will always return an
	// array of type Object[] .
	static <T> T[] pickTwo(T a, T b, T c) {
		switch(ThreadLocalRandom.current().nextInt(3)) {
			case 0: return toArray(a, b);
			case 1: return toArray(a, c);
			case 2: return toArray(b, c);
		}
		throw new AssertionError(); // Can't get here
	}

	// There is nothing at all wrong with this method, so it compiles without generating any warnings. But when you run
	// it, it throws a ClassCastException , though it contains no visible casts. What you don’t see is that the compiler
	// has generated a hidden cast to String[] on the value returned by pickTwo so that it can be stored in attributes.
	// The cast fails, because Object[] is not a subtype of String[] .
	public static void main(String[] args) {
		String[] attributes = pickTwo("Good", "Fast", "Cheap");
	}
}
