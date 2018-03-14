/*=====================================================================
□ Infomation
  ○ Data : 12.03.2018
  ○ Mail : eun1310434@naver.com
  ○ Blog : https://blog.naver.com/eun1310434
  ○ Reference : 쉽게 배우는 소프트웨어 공학, Java Documentation, 헬로 자바 프로그래밍, programmers.co.kr, 

□ Function
  ○ Server
  ○ Client 접속 대기 - blocking
  ○ Client 접속 후
  ○ 한줄씩 입력 받음
  ○ BufferedReader 종료
  ○ 소켓 종료
  ○ 서버 종료

□ Study
  ○ Network
    - Protocol : 규약, 약속, 보내고 받기위한 약속
    - Port : 한대의 컴퓨터에 포트는 14만여개 있음, TCP 포트와 UDP 포트가 있음
    - TCP/IP(Transmission Control Protocol) : 부하가 높으나 안전성이 높음
    - UDP(User Datagram Protocol)
    - Multicast : UDP의 확장버젼
    - RMI(Remote Method Invocation) 
    
  ○ structure
                컴퓨터A[응용계층(FTP, 텔넷, HTTP) → 전송계층(TCP,UDP) → 네트워크 계층(IP) → 링크계층(이더넷 토큰링) → 물리계층(케이블)]
     → 컴퓨터B[물리계층(케이블) → 링크계층(이더넷 토큰링) → 네트워크 계층(IP) → 전송계층(TCP,UDP) → 응용계층(FTP, 텔넷, HTTP)]
=====================================================================*/
package com.eun1310434.network.tcp;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
public class TCP_BasicServer {
	public static void main(String[] ar) {
		ServerSocket serverSocket = null;
		try {
			serverSocket = new ServerSocket(54321);
			System.out.println("Server Ready...");
			
			//Client 접속 대기 - blocking
			Socket socket = serverSocket.accept();
			
			//Client 접속 후
			System.out.println("Conntion User Info : " + socket);
			
			BufferedReader in = 
					new BufferedReader( 
							new InputStreamReader(socket.getInputStream()));
			
			//한줄씩 입력 받음
			String data = in.readLine();
			System.out.println("Received Data : " + data);
			

			//BufferedReader 종료
			//in.close();
			socket.shutdownInput();

			//소켓 종료
			socket.close();
			
			//서버 종료
			serverSocket.close();
			
		}catch(IOException ex) {
			System.err.println("Port conflict");
			System.exit(-1);
		}
	}
}
