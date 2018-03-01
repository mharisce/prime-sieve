package com.haris.primesieve;

import java.io.OutputStream;
import java.io.PrintWriter;

public class PrimeSieveBuilder {
	private int upperRange;

	public PrimeSieveBuilder(int upperRange) {
		this.upperRange = upperRange;
	}

	public PrimeSieve build() {
		return new PrimeSieve(upperRange).generate();
	}

	public static class PrimeSieve {
		private static final int REMAINDER_MASK_OF_2 = 1;
		private static final int REMAINDER_MASK_OF_32 = 0x1F;
		private static final int NUMBERS_PER_INT = 64;

		// Bit value = 0 then mapped number is Prime. Not prime otherwise.
		private int[] prime;
		private int upperRange;

		private PrimeSieve(int upperRange) {
			this.upperRange = upperRange;

			// +1 is to avoid Math.ceil
			this.prime = new int[upperRange / NUMBERS_PER_INT + 1];
		}

		public void printAll(OutputStream out) {
			try (PrintWriter w = new PrintWriter(out)) {

				// primecount is for print beautification
				int primecount = 0;

				for (int i = 0; i <= upperRange; i++) {

					if (this.isPrime(i)) {
						w.print(i);
						primecount++;
						if (primecount % 10 == 0 && primecount > 0) {
							w.println();
						} else {
							w.print("\t");
						}
					}

				}
			}

		}

		private PrimeSieve generate() {
			for (int i = 3; i * i <= upperRange; i += 2) {
				if (!isNotPrime(i)) {
					for (int j = i * i, k = i << 1; j <= upperRange; j += k) {
						markComposite(j);
					}
				}
			}
			return this;
		}

		public boolean isPrime(int x) {
			if (x < 2) {
				return false;
			} else if (x == 2) {
				return true;
			} else if ((x & REMAINDER_MASK_OF_2) == 0) {// x % 2 == 0
				return false;
			}
			return !isNotPrime(x);
		}

		private boolean isNotPrime(int x) {
			return 0 != (prime[getArrayIndex(x)] & getBitMask(x));
		}

		private void markComposite(int x) {
			prime[getArrayIndex(x)] |= getBitMask(x);
		}

		private int getArrayIndex(int x) {
			return x / NUMBERS_PER_INT;
		}

		private int getBitMask(int x) {
			return 1 << ((x >> 1) & REMAINDER_MASK_OF_32);
		}

	}
}