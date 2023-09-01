package MyThread;

//쓰레드를 만드는 방법
public class Worker extends Thread {
	
	String name;
	
	public Worker(String name) {
		this.name = name;
	}
	
	//다른 작업을 지정해줄 예정
	
	@Override
	public void run() {
		for (int i = 0; i < 30; i++) {
			System.out.println("------------");
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
			
				e.printStackTrace();
			}
		}
	}
}
