package MyThread;

public class Father extends Thread {
	 
	Bank bank;
	
	//생성자 주입
	public Father(Bank bank) {
		this.bank = bank;
	}
	
	@Override
	public void run() {
		bank.saveMoney(10_000);
		
	}
}
