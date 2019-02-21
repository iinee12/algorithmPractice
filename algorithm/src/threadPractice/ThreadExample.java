package threadPractice;

public class ThreadExample {

	public static void main(String[] args) throws InterruptedException {
		
		ThreadClass tc1 = new ThreadClass("thread1");
		ThreadClass tc2 = new ThreadClass("thread2");
		
		tc1.start();
		tc2.start();
		
		for(int i=0; i<10; i++) {
			System.out.println("Main-------------"+i);
			Thread.sleep(10);
		}
		
		//tc1과 tc2의 쓰레드가 다 돌때까지 main을 끝내지 않겠다.
		tc1.join();
		tc2.join();
		
	}
	
}

class ThreadClass extends Thread{
	String thread_name = "";
	public ThreadClass(String name) {
		this.thread_name = name;
	}
	//thread class를 만들때는 run 메소드를 재정의 해줘야한다.
	public void run() {
		//0~9까지 숫자 찍기 3개의 쓰레드로 돌리기
		for(int i=0; i<10; i++) {
			System.out.println(thread_name+"-------------"+i);
			try {
				sleep(10);
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
}
