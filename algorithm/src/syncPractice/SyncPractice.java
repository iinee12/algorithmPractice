package syncPractice;

import java.util.concurrent.locks.ReentrantLock;

public class SyncPractice {
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ThreadClass tc1 = new ThreadClass("thread1");
		ThreadClass tc2 = new ThreadClass("thread2");
		
		tc1.start();
		tc2.start();
		
		
		for(int i=0; i<10; i++) {
			ThreadClass.printNumber("Main");
		}
		
		//tc1�� tc2�� �����尡 �� �������� main�� ������ �ʰڴ�.
		
		
	}

}

class ThreadClass extends Thread{
	static ReentrantLock lock = new ReentrantLock();
	String thread_name = "";
	public ThreadClass(String name) {
		this.thread_name = name;
	}
	//thread class�� ���鶧�� run �޼ҵ带 ������ ������Ѵ�.
	public void run() {
		
		
		
		try {
			printNumber(thread_name);
		}catch( Exception e) {
			e.printStackTrace();
		}
		
	}
	static void printNumber( String str ) {
		lock.lock();
		
		try {
			System.out.println(str);
			for(int i=0; i<10; i++) {
				System.out.println(i);
				
			}
		}catch( Exception e ) {
			e.printStackTrace();
		}finally {
			lock.unlock();
		}
		
	}
	
}
