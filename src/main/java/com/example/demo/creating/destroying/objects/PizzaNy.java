package com.example.demo.creating.destroying.objects;

import java.util.Objects;

//		Note that the build method in each subclass’s builder is declared to return the
//		correct subclass: the build method of NyPizza.Builder returns NyPizza , while
//		the one in Calzone.Builder returns Calzone . This technique, wherein a subclass
//		method is declared to return a subtype of the return type declared in the superclass,
//		is known as covariant return typing. It allows clients to use these builders
//		without the need for casting.
public class PizzaNy extends Pizza {
	public enum Size {SMALL, MEDIUM, LARGE}

	private final Size size;

	public static class Builder extends Pizza.Builder<Builder> {
		private final Size size;

		public Builder(Size size) {
			this.size = Objects.requireNonNull(size);
		}

		@Override
		public PizzaNy build() {
			return new PizzaNy(this);
		}

		@Override
		protected Builder self() {
			return this;
		}
	}

	public PizzaNy(Builder builder) {
		super(builder);
		this.size = builder.size;
	}
}
