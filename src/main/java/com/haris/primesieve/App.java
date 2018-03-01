package com.haris.primesieve;

import com.haris.primesieve.PrimeSieveBuilder.PrimeSieve;

public class App {

	/*
	 * https://en.wikipedia.org/wiki/Wheel_factorization
	 * 
	 * I tried wheel factorization first. It breaks at 121 and others. So
	 * eventually went to bitwise prime sieve with subtraction of multiples of 2
	 * only.
	 * 
	 */

	public static void main(String[] args) {
		System.out.println("Welcome to Binary Prime Sieve!");
		PrimeSieve primeSieve = new PrimeSieveBuilder(15485865).build();
		primeSieve.printAll(System.out);
	}
}
