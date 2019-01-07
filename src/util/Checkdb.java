package util;

public class Checkdb {
	public static void check() {
		final long timeInterval = 1000;
		Runnable runnable = new Runnable() {
			
			@Override
			public void run() {
				while(true) {
					System.out.println("开始扫描");
					/**
					 * 实时扫描数据库
					 */
					try {
						Thread.sleep(timeInterval);
					} catch (Exception e) {
						
						e.printStackTrace();
					}
				}
				
			}
		};
		Thread thread = new Thread(runnable);
		thread.start();
	}
}
