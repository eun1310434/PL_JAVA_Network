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
import java.net.InetAddress;
import java.util.Scanner;
public class UDP_BasicClient {
	public static void main(String[] ar) {
		
		Scanner cin = new Scanner(System.in);
		DatagramSocket datagramSocket = null;
		InetAddress remote_addr = null;
		
		try {
			datagramSocket = new DatagramSocket();
			
			while(true) {
				
				System.out.print("Send Data = ");
				String data = cin.nextLine();
				
				//quit을 입력하면 종료
				if(data.equals("quit")) {
					datagramSocket.close();
					cin.close();
					break;
				}
				
				try {
					//remote_addr = InetAddress.getByName("000.000.000.000");
					remote_addr = InetAddress.getLocalHost();//자신의 홈 IP 주소로 자체 통신
					

					//목적지 포트 - Port : 0 ~ 65535 : 2000
					int port = 54321;
					
					DatagramPacket datagramPacket = 
							new DatagramPacket(
									data.getBytes(), 
									data.getBytes().length, 
									remote_addr, 
									port);
					
					
					datagramSocket.send(datagramPacket);
					
				}catch(IOException ex) {
					System.out.println("Send ERROR : " + ex.getMessage());
				}
			}
		}catch(IOException ex) {
			System.err.println("Socket ERROR : " + ex.getLocalizedMessage());
			System.exit(-1);
		}
	}
}
