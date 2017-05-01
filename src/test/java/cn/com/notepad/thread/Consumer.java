package cn.com.notepad.thread;
/**
 * 消费者
 * @author admin
 *
 */
public class Consumer implements Runnable{
	
	BreadStack breadStack = null;
	
	public Consumer(BreadStack breadStack) {
		this.breadStack = breadStack;
	}

	@Override
	public void run() {
		for (int i = 0; i < 40; i++) {
			Bread bread = breadStack.pop();
			System.out.println("消费"+Thread.currentThread().getName()+":"+bread.toString());
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
}
