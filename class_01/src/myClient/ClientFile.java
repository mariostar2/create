	package myClient;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientFile {
	//통신을 하기 위해서 소켓이 필요하다
	//네트워크를 통해서 접근하고자 하는 주소 + 포트번호 
	
	Socket socket;
	//192.168.0.48
	final String IP = "localhost";	//192.168.0.48
	final int PORT = 10_000;
	
	//필요한 부분 
	//- 키보드에서 입력 받기, 
	//- 소켓통신을 통해서 데이터 던지기	
	BufferedReader keyBoardReader;	//키보드
	BufferedWriter writer;			//소켓에 연결
	
	//연결된 소켓을 통해서 넘어온 데이터를 읽어 드려야한다. 
	BufferedReader bufferedReader;
	
	public ClientFile() {
		initData();
	}
	
	private void initData() {
		System.out.println("클라이언트에게 접속 요청");
		try {
			socket = new Socket(IP,PORT);							//서버에 접근 요청
			
			//키보드에서 데이터 입력 받기 실행
			keyBoardReader = new BufferedReader(new InputStreamReader(System.in));			
			
			//소켓과 write 스트림을 연결한다			
			writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			
			ReadThread readThread =  new ReadThread();
			Thread thread = new Thread(readThread);
			
			bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			
			while(true) 
			{
				System.out.println("키보드 입력 대기");
				String inputData =  keyBoardReader.readLine();		//입력 받을 수 있도록 대기
				writer.write(inputData);
				
				//write를 사용할 때 주의점 :문장의 끝을 알려주어야 한다.
				writer.newLine();												
				writer.flush();										//메모리를 비워라
			}
			
			
		} catch (UnknownHostException e) {			
			e.printStackTrace();
		} catch (IOException e) {		
			e.printStackTrace();
		}
		//내부 클래스 	
		
	} //end of initData
	
	private class ReadThread implements Runnable{
		
		@Override
		public void run() {
			while(true) {
				
				try {
					String taskMsg = bufferedReader.readLine();
					System.out.println("서버로부터 받은 메세지:"+ taskMsg);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
			}
			
		}//end of inner class
	}
	

	
	public static void main(String[] args) {				
		ClientFile clientTest = new ClientFile();
	}
}//end of class
