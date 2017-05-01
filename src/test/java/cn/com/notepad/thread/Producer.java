package cn.com.notepad.thread;
/**
 * 生产者
 * @author admin
 *
 */
public class Producer implements Runnable{

	BreadStack breadStack = null;
	
	public Producer(BreadStack breadStack) {
		this.breadStack = breadStack;
	}
	
	@Override
	public void run() {
		for (int i = 0; i < 20; i++) {
			Bread bread = new Bread(i);
			this.breadStack.push(bread);
			System.out.println("生产"+Thread.currentThread().getName()+":"+bread.toString());
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
