package com.example.demo.clases.interfaces.item17;

// Immutable complex number class
public final class Complex {
	private final double re;
	private final double im;

	public Complex(double re, double im) {
		this.re = re;
		this.im = im;
	}

//	Notice how the arithmetic operations create and return a new Complex instance rather than modifying this
//	instance. This pattern is known as the functional approach because methods return the result of applying
//	a function to their operand, without modifying it. Contrast it to the procedural or imperative approach
//	in which methods apply a procedure to their operand, causing its state to change. Note that the method
//	names are prepositions (such as plus ) rather than verbs (such as add ). This emphasizes the fact that
//	methods don’t change the values of the objects. The BigInteger and BigDecimal classes did not obey this
//	naming convention, and it led to many usage errors.
	public Complex plus(Complex c) {
		return new Complex(re + c.re, im + c.im);
	}
}
