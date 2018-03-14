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
  ○ 파일 전송

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
import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
public class UDP_FileClient {
	public static void main(String[] ar) throws IOException {
		
		DataInputStream in = null;
		
		String ip = InetAddress.getLocalHost().getHostAddress();
		int port = 12345;
		String filePath = "D:\\PJM\\ECLIPSE\\Examples\\PL_JAVA_Network\\src\\com\\eun1310434\\network\\udp\\";
		String fileName = "UDP_FileClient.java";
		
		File file = new File(filePath, fileName);
		if(!file.exists()) {
			System.err.println("파일이 존재하지 않습니다.");
			System.exit(-1);
		}
		
		in = new DataInputStream(
				new BufferedInputStream(
						new FileInputStream(file)));
		
		DatagramSocket datagramSocket = new DatagramSocket();
		InetAddress remote_addr = InetAddress.getByName(ip);
		
		byte[] start = "start".getBytes();
		byte[] end = "end".getBytes();
		
		
		//전송 시작 알림
		System.out.println("Send Start!!!");
		DatagramPacket datagramPacket = 
				new DatagramPacket(
						start, 
						start.length, 
						remote_addr, 
						port);
		datagramSocket.send(datagramPacket);
		
		//파일 이름 전송
		datagramPacket = 
				new DatagramPacket(
						fileName.getBytes(), 
						fileName.getBytes().length, 
						remote_addr, 
						port);
		datagramSocket.send(datagramPacket);
		
		//파일 전송
		byte[] data = null;
		while(true) {
			data = new byte[1024];
			int n = in.read(data, 0, data.length);
			
			if(n < 0){break;}
			
			datagramPacket = 
					new DatagramPacket(
							data, 
							n, 
							remote_addr, 
							port);
			datagramSocket.send(datagramPacket);
		}
		

		//전송 종료 알림
		datagramPacket = 
				new DatagramPacket(
						end, 
						end.length, 
						remote_addr, 
						port);
		datagramSocket.send(datagramPacket);
		
		
		
		//종료
		in.close();
		datagramSocket.close();
		System.out.println("Complete");
	}
}
