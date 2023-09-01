package MyThread;

public class Mother extends Thread {
	
	Bank bank;
	
	public Mother(Bank bank) {
		this.bank = bank;
	}
	
	@Override
	public void run() {
		bank.widthdraw(5_000);
		
	}

}
