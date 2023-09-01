package MyThread;

public class Bank {
	
	int money = 100_000;
	
	//get,set 
	public int getMoney() {
		return money;
	}
	
	public void setMoney(int money) {
		this.money = money;
	}
	
	public synchronized void saveMoney(int money) {
		int currentMoney = getMoney();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		
		setMoney(currentMoney + money);
		System.out.println("입금후 현재 잔액:" + getMoney());
	}
	
	public synchronized void widthdraw(int money) {
		int currentMoney = getMoney();
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {		
			e.printStackTrace();
		}
		
		
		//잔액보다 많은 금액을 출금하면 이상하다 - 마이너스 통장이 아닐경우
		if(currentMoney >= money) {
			setMoney(currentMoney - money);					//방어 코드 
			//정상 출금가능
		}else {
			System.out.println("잔액이 부족하다");
		}
		
		//System.out.println("현재잔액: bank.getMoney);
	}
}
