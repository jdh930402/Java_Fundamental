package java_20190806;

public class CrawlingThreadDemo {
	public static void main(String[] args) {
		Thread t1 = new CrawlingThread("bitcoin", "Bitcoin.xls");
		t1.start();
		Thread t2 = new CrawlingThread("ethereum", "Ethereum.xls");
		t2.start();
		Thread t3 = new CrawlingThread("ripple", "XRP.xls");
		t3.start();
		Thread t4 = new CrawlingThread("bitcoin-cash", "Bitcoin Cash.xls");
		t4.start();
		Thread t5 = new CrawlingThread("litecoin", "Litecoin.xls");
		t5.start();
		Thread t6 = new CrawlingThread("binance-coin", "Binance Coin.xls");
		t6.start();
		Thread t7 = new CrawlingThread("eos", "EOS.xls");
		t7.start();
	}
}
