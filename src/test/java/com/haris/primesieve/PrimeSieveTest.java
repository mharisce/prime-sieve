package com.haris.primesieve;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.Collection;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import com.haris.primesieve.PrimeSieveBuilder.PrimeSieve;

/*
 * 
 * 
 * Prime Number List downloaded from http://www.primos.mat.br/indexen.html
 * 
 */
@RunWith(Parameterized.class)
public class PrimeSieveTest {
	@Parameters(name = "{index}: isPrime({0})={1}")
	public static Collection<Object[]> data() {
		return Arrays.asList(new Object[][] {

				{ 0, false }, { 1, false }, { 2, true }, { 3, true }, { 4, false }, { 5, true }, { 6, false },

				{ 15464591, true }, { 15464597, true }, { 15464609, true }, { 15464621, true }, { 15464639, true },

				{ 15464641, true }, { 15464677, true }, { 15464693, true }, { 15464707, true }, { 15464719, true },

				{ 15464643, false }, { 15464679, false }, { 15464697, false }, { 15464711, false }, { 15464721, false },

				{ 15485865, false }

		});
	}

	private int testInputNumber;
	private boolean testExpectedOutput;

	private static PrimeSieve primeSieve;

	public PrimeSieveTest(int testInputNumber, boolean testExpectedOutput) {
		this.testInputNumber = testInputNumber;
		this.testExpectedOutput = testExpectedOutput;
	}

	@BeforeClass
	public static void setup() {
		primeSieve = new PrimeSieveBuilder(15485865).build();
	}

	@Test
	public void test() {
		boolean prime = primeSieve.isPrime(testInputNumber);
		assertTrue(testInputNumber + " expected result=" + testExpectedOutput + " actual result=" + prime,
				prime == testExpectedOutput);
	}

}