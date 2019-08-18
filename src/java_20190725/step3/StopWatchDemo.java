package java_20190725.step3;

public class StopWatchDemo {
	public static void main(String[] args) {
		StopMilliWatch s1 = new StopMilliWatch();
		
		s1.start();
		for (long i = 0; i < 30_000_000_000l; i++) {
			
		}
		s1.stop();
		double elapsedNanoTime = s1.getElapsedTime();
		System.out.printf("경과시간 : %.9f", elapsedNanoTime);
	}
}
