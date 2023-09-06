package com.example.demo.creating.destroying.objects.item2;

import java.util.EnumSet;
import java.util.Objects;
import java.util.Set;

// Builder pattern for class hierarchies
//		Note that the build method in each subclass’s builder is declared to return the
//		correct subclass: the build method of NyPizza.Builder returns NyPizza , while
//		the one in Calzone.Builder returns Calzone . This technique, wherein a subclass
//		method is declared to return a subtype of the return type declared in the superclass,
//		is known as covariant return typing. It allows clients to use these builders
//		without the need for casting.
public class Pizza {
	public enum Topping {HAM, MUSHROOM, ONION, PEPPER, SAUSAGE}
	final Set<Topping> toppings;

	abstract static class Builder<T extends Builder<T>> {
		EnumSet<Topping> toppings = EnumSet.noneOf(Topping.class);

		public T addTopping(Topping topping) {
			toppings.add(Objects.requireNonNull(topping));
			return self();
		}

		abstract Pizza build();

		// Subclasses must override this method to return "this"
		protected abstract T self();
	}

	Pizza(Builder<?> builder) {
		toppings = builder.toppings.clone();
	}
}
