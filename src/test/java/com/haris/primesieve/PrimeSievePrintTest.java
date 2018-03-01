package com.haris.primesieve;

import static org.junit.Assert.assertTrue;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.junit.BeforeClass;
import org.junit.Test;

import com.haris.primesieve.PrimeSieveBuilder.PrimeSieve;

/*
 * 
 * 
 * Prime Number List downloaded from http://www.primos.mat.br/indexen.html
 * 
 */
public class PrimeSievePrintTest {

	private static PrimeSieve primeSieve;

	@BeforeClass
	public static void setup() {
		primeSieve = new PrimeSieveBuilder(15485865).build();
	}

	@Test
	public void completeFileTest() throws IOException {

		try (FileOutputStream fos = new FileOutputStream("actual.txt");) {

			primeSieve.printAll(fos);
		}

		try (BufferedReader readerActual = Files.newBufferedReader(Paths.get("actual.txt"));
				BufferedReader readerExpected = Files.newBufferedReader(Paths.get("expected.txt"));) {

			String lineActual = readerActual.readLine();
			String lineExpected = readerExpected.readLine();

			while (lineActual != null && lineExpected != null) {
				assertTrue("Following Line Not Same", lineExpected.equals(lineActual));

				lineActual = readerActual.readLine();
				lineExpected = readerExpected.readLine();
			}

			assertTrue("One has more numbers than other", lineExpected == null && lineActual == null);

		}

	}

}