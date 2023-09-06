package com.example.demo.generics.item31;

import java.util.Collection;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class UtilsWithGenerics {

	// Both parameters, s1 and s2 , are E producers. Note that the return type is still Set<E> . Do not use bounded
	// wildcard types as return types. Rather than providing additional flexibility for your users, it would force
	// them to use wildcard types in client code. Properly used, wildcard types are nearly invisible to the users of
	// a class. They cause methods to accept the parameters they should accept and reject those they should reject.
	// If the user of a class has to think about wildcard types, there is probably something wrong with its API.
	public static <E> Set<E> union(Set<? extends E> s1, Set<? extends E> s2) {
		Set<E> result = new HashSet<>(s1);
		result.addAll(s2);
		return result;
	}

	// Returns max value in a collection. To get the revised declaration from the original, we applied the PECS heuristic
	// twice. The straightforward application is to the parameter list . It produces T instances, so we change the type
	// from List<T> to List<? extends T> . The tricky application is to the type parameter T . This is the first time
	// we’ve seen a wildcard applied to a type parameter. Originally, T was specified to extend Comparable<T> , but a
	// comparable of T consumes T instances (and produces integers indicating order relations). Therefore, the
	// parameterized type Comparable<T> is replaced by the bounded wildcard type Comparable<? super T> . Comparables are
	// always consumers, so you should generally use Comparable<? super T> in preference to Comparable<T> . The same is
	// true of comparators; therefore, you should generally use Comparator<? super T> in preference to Comparator<T>.
	public static <T extends Comparable<? super T>> T max(Collection<? extends T> list) {
		if (list.isEmpty())
			throw new IllegalArgumentException("Empty collection");
		T result = null;
		for (T t : list)
			if (result == null || t.compareTo(result) > 0)
				result = Objects.requireNonNull(t);
		return result;
	}

}
