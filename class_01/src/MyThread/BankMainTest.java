package MyThread;

public class BankMainTest {
	public static void main(String[] args) {
		Bank bank = new Bank();
			
		Father father = new Father(bank);			//기본금액 10_000
		Mother mother = new Mother(bank);
		
		father.start();		//아버지가 10_000 입금 동작중
		mother.start();
		
		//System.out.println("현재 잔액:" + bank.getMoney());
	}
}
