/*=====================================================================
□ Infomation
  ○ Data : 09.03.2018
  ○ Mail : eun1310434@naver.com
  ○ Blog : https://blog.naver.com/eun1310434
  ○ Reference : 쉽게 배우는 소프트웨어 공학, Java Documentation, 헬로 자바 프로그래밍, programmers.co.kr, 

□ Function
  ○ Multicast 
    - 특정 다수와 통신
    - Client가 다중 접속을 하여도 1:n 통신이기에 문제 없음
    - D 클래스[224.0.0.0 ~ 239.255.255.255]
    - joinGroup
    - leaveGroup
    - 채널 통신
    

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
package com.eun1310434.network.multicast;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.util.Scanner;
public class Multicast_BasicClient {
	public static void main(String[] ar) throws IOException {
		
		Scanner cin = new Scanner(System.in);
		MulticastSocket socket = new MulticastSocket();
		
		while(true) {
			System.out.print("Message = ");
			
			String message = cin.nextLine();

			//Multicast의 D클래스[224.0.0.0 ~ 239.255.255.255]
			InetAddress remote_addr = InetAddress.getByName("224.0.0.1");
			
			DatagramPacket packet = 
					new DatagramPacket(
							message.getBytes(), 
							message.getBytes().length, 
							remote_addr, 
							12345);
			
			socket.send(packet);
		}	
		//cin.close();
		//socket.close();
	}
}
