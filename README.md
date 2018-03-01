# Binary Prime Sieve

Sample Use:

	public static void main(String[] args) {
		System.out.println("Welcome to Binary Prime Sieve!");
		PrimeSieve primeSieve = new PrimeSieveBuilder(15485865).build();
		primeSieve.printAll(System.out);
	}
	
More usage can be observed in tests.