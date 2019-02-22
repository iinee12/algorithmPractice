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
		
		//tc1과 tc2의 쓰레드가 다 돌때까지 main을 끝내지 않겠다.
		
		
	}

}

class ThreadClass extends Thread{
	static ReentrantLock lock = new ReentrantLock();
	String thread_name = "";
	public ThreadClass(String name) {
		this.thread_name = name;
	}
	//thread class를 만들때는 run 메소드를 재정의 해줘야한다.
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
