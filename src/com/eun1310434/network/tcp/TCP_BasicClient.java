/*=====================================================================
□ Infomation
  ○ Data : 12.03.2018
  ○ Mail : eun1310434@naver.com
  ○ Blog : https://blog.naver.com/eun1310434
  ○ Reference : 쉽게 배우는 소프트웨어 공학, Java Documentation, 헬로 자바 프로그래밍, programmers.co.kr, 

□ Function
  ○ Client
  ○ IP 관리 - 목적지 주소 입력
  ○ Data 전송
  ○ Buffer 비우기 - PrintWriter에는 자체적으로 flush기능이 있음
  ○ PrintWriter 종료
  ○ 소켓 종료

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
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
public class TCP_BasicClient {
	public static void main(String[] ar) {
		InetAddress remote_addr = null;
		Socket socket = null;
		
		try {
			//IP 관리 - 목적지 주소 입력
			//IP address for the given host name
			//remote_addr = InetAddress.getByName("000.000.000.000");
			remote_addr = InetAddress.getLocalHost();//자신의 홈 IP 주소로 자체 통신

			//목적지 포트 - Port : 0 ~ 65535 : 2000
			int port = 54321;
			socket = new Socket(remote_addr, port);
			System.out.println("Connectoin Request");
			
			PrintWriter out = 
					new PrintWriter(
							new BufferedWriter(
									new OutputStreamWriter(socket.getOutputStream())));

			//Data 전송
			out.println("eun1310434\n");
			
			//Buffer 비우기 - PrintWriter에는 자체적으로 flush기능이 있음
			out.flush();
			System.out.println("Data Send Complete!");

			//PrintWriter 종료
			//out.close();
			socket.shutdownOutput();
			
			//소켓 종료
			socket.close();
			System.out.println("Connection Complete");
		}catch(IOException ex) {
			System.err.println("Connection ERROR : " + ex.getLocalizedMessage());
			System.exit(-1);
		}
	}
}
