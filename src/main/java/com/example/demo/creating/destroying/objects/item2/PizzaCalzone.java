package com.example.demo.creating.destroying.objects.item2;

//		Note that the build method in each subclass’s builder is declared to return the
//		correct subclass: the build method of NyPizza.Builder returns NyPizza , while
//		the one in Calzone.Builder returns Calzone . This technique, wherein a subclass
//		method is declared to return a subtype of the return type declared in the superclass,
//		is known as covariant return typing. It allows clients to use these builders
//		without the need for casting.
public class PizzaCalzone extends Pizza {
	private final boolean sauceInside;

	public static class Builder extends Pizza.Builder<Builder>{
		private boolean sauceInside = false; // Default

		public Builder sauceInside(){
			this.sauceInside = true;
			return this;
		}

		@Override
		public PizzaCalzone build(){
			return new PizzaCalzone(this);
		}

		@Override
		protected Builder self(){
			return this;
		}
	}

	public PizzaCalzone(Builder builder){
		super(builder);
		this.sauceInside = builder.sauceInside;
	}
}
