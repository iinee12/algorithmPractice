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
		
		//tc1�� tc2�� �����尡 �� �������� main�� ������ �ʰڴ�.
		tc1.join();
		tc2.join();
		
	}
	
}

class ThreadClass extends Thread{
	String thread_name = "";
	public ThreadClass(String name) {
		this.thread_name = name;
	}
	//thread class�� ���鶧�� run �޼ҵ带 ������ ������Ѵ�.
	public void run() {
		//0~9���� ���� ��� 3���� ������� ������
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
