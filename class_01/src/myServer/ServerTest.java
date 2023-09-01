package myServer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerTest {
	//소켓 서버 구성하기
	
	//1. 클라이언트로 연결 받는 소켓	
	//2. 실제 통신을 담당할 소켓 필요
	
	ServerSocket serverSocket;
	Socket socket;
	
	//스트림에 대한 공부 :I/O 부분
	//문자열 단위로 데이터를 읽어 들이는 녀석 
	BufferedReader reader;
	
	public ServerTest() {
		System.out.println("***소켓 서버 생성***");
		initData();
	}
	
	//TODO 메모리 정리해보기 
	//메모리 구조  - 스택영역 , 힙 영역 , static 영역, 데이터영역(상수)
	private void initData() {		
		try {			
			//나의 ip주소 :192.168.0.119:10000
			//1. 서버 소켓 생성
			serverSocket  = new ServerSocket(10_000);
			//2. 서버 소켓 연결 대기
			socket = serverSocket.accept();	//while		
			System.out.println("클라이언트 연결 완료");
			
			
			//스트림 필요함 
			//기반 스트림 +보조 스트림
			//대상, 키보드, 소켓
			//입력 스트림을 소켓에 연결하다.
			reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			
			//스트림에서 넘어온 데이터 읽어보기
			System.out.println("입력 스트림을 통해서 데이터를 받는 작업을 기다리고 있다");
			while(true){
				String msg = "클라이언트 측에서 온 메세지:" + reader.readLine()+ "\n";
				System.out.println("메세지 :"  + msg);

			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}