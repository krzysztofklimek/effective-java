package com.example.demo.creating.destroying.objects;

import java.util.regex.Pattern;

// If the class containing the improved version of the isRomanNumeral method is initialized but
// the method is never invoked, the field ROMAN will be initialized needlessly. It would be possible
// to eliminate the initialization by lazily initializing the field (Item 83) the first time the
// isRomanNumeral method is invoked, but this is not recommended. As is often the case with lazy
// initialization, it would complicate the implementation with no measurable performance improvement
// (Item 67).
public class RomanNumerals {
	private static final Pattern ROMAN = Pattern.compile("^(?=.)M*(C[MD]|D?C{0,3})(X[CL]|L?X{0,3})(I[XV]|V?I{0,3})$");

	static boolean isRomanNumeral(String s) {
		return ROMAN.matcher(s).matches();
	}
}
