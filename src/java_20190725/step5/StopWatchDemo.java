package java_20190725.step5;

public class StopWatchDemo {
	public static void run(StopWatch sw) {
		sw.execute();
	}
	public static void main(String[] args) {
		StopWatch s1 = new StopNanoWatch();
		//run(s1);

		StopWatch s2 = new StopMilliWatch();
		//run(s2);
		
		StopWatch s3 = new StopMicroWatch();
		run(s3);
	}
}
