package MyThread;

public class MainTest1 {
		//코드의 시작점
	public static void main(String[] args) {
		
		for (int i = 0; i < 10; i++) {
			
			System.out.print("_");
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
		}
		
	}//end of Main
}
