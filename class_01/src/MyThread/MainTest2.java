package MyThread;

public class MainTest2 {
	public static void main(String[] args) {
		System.out.println("------------- main thread start ----------------");
		System.out.println(Thread.currentThread());		//현재 스레드 확인 		

		Worker worker2 = new Worker("작업자2");
		worker2.start();
		//쓰레드를 시작하기 위해서는 start() 메서드를 호출해야 한다.
		
		Worker worker3 = new Worker("작업자3");
		worker3.start();

		
		System.out.println("-------- main thread end --------");
	}	//end of main
	
}
