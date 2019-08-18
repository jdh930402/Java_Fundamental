package java_20190725.step2;

public class StopWatchDemo {
	public static void main(String[] args) {
		StopWatch s1 = new StopWatch();
		
		s1.start();
		for (long i = 0; i < 30_000_000_000l; i++) {
			
		}
		s1.stop();
		double elapsedNanoTime = s1.getElapsedTime();
		System.out.printf("경과시간 : %.3f", elapsedNanoTime);
	}

}
