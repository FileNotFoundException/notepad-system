package cn.com.notepad.thread;

/**
 * 面包框
 * @author yugy
 *
 */
public class BreadStack {
	
	int index = 0;
	
	Bread[] breads = new Bread[10];
	
	//生产面包方法
	public synchronized void push(Bread bread){
		while (index == breads.length){
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		this.notify();
		breads[index] = bread;
		index++;
	}
	
	//消费面包方法
	public synchronized Bread pop(){
		while(index == 0){
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		this.notify();
		index--;
		return breads[index];
	}

	public static void main(String[] args) {
		BreadStack breadStack = new BreadStack();
		Producer p1 = new Producer(breadStack);
		Producer p2 = new Producer(breadStack);
		Consumer c1 = new Consumer(breadStack);
		new Thread(p1).start();
		new Thread(p2).start();
		new Thread(c1).start();
	}
	
}
