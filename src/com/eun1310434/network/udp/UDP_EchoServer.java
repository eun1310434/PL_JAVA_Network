/*=====================================================================
□ Infomation
  ○ Data : 13.03.2018
  ○ Mail : eun1310434@naver.com
  ○ Blog : https://blog.naver.com/eun1310434
  ○ Reference : 쉽게 배우는 소프트웨어 공학, Java Documentation, 헬로 자바 프로그래밍, programmers.co.kr, 

□ Function
  ○ UDP 통신
       - UDP 통신 = 우편통신
       - 소포 = 패킷
       - IP주소 = 우편주소
       - 포트 = 우편번호

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
package com.eun1310434.network.udp;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
public class UDP_EchoServer {
	public static void main(String[] ar){
		DatagramSocket datagramSocket = null;		
		
		try {
			//가능한 Port 범위 : 0 ~ 65535 : 2000
			//EchoClient의 포트번호와 다르게 구성
			int port = 54321;
			
			//Client 접속대기
			datagramSocket = new DatagramSocket(port);
			System.out.println("Server Ready...");
			
			while(true) {
				
				//수신
				//헤더정보를 포함하지 않은 최대크기의 byte 설정
				byte[] data = new byte[65508];
				DatagramPacket datagramPacket = 
						new DatagramPacket(
								data, 
								data.length);
				datagramSocket.receive(datagramPacket);
				
				//IP Address
				String ipAddress = datagramPacket.getAddress().getHostAddress();
				
				//Receive Data
				//String data_str = new String(data);
				String data_str = new String(datagramPacket.getData()).trim();
				
				//Print
				System.out.printf("%s >> %s\n", ipAddress, data_str);
				
				
				//재전송
				datagramPacket = 
						new DatagramPacket(
								new String(datagramPacket.getData()).trim().getBytes(), 
								new String(datagramPacket.getData()).trim().getBytes().length,
								datagramPacket.getAddress(), 
								port);
				datagramSocket.send(datagramPacket);	
			}
			
		}catch(IOException ex) {
			System.err.println("ERROR : " + ex.getMessage());
			System.exit(-1);
		}
	}
}
