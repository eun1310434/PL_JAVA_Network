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
import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
public class UDP_FileServer {
	public static void main(String[] ar) throws IOException {

		DataOutputStream out = null;
		File file = null;
		
		int port = 12345;
		DatagramSocket datagramSocket = new DatagramSocket(port);
		System.out.println("Server Ready...");
		
		while(true) {

			byte[] data = new byte[65508];//헤더정보를 포함하지 않은 최대크기
			DatagramPacket datagramPacket = 
					new DatagramPacket(
							data, 
							data.length);
			datagramSocket.receive(datagramPacket);
			String str = new String(datagramPacket.getData()).trim();
			

			//전송 시작 알림 확인
			if(str.equalsIgnoreCase("start")) {
				//전송 시작 알림 확인
				
				System.out.println("File Send Start");
				datagramSocket.receive(datagramPacket);
				str = new String(datagramPacket.getData()).trim();
				
				File dir = new File("D:\\PJM\\ECLIPSE\\Examples\\PL_JAVA_Network\\data\\");
				if(!dir.exists()) dir.mkdirs();
				
				file = new File(dir.getPath(), str);
				out = new DataOutputStream(
						new BufferedOutputStream(
								new FileOutputStream(file)));
				
			} else if(str.equalsIgnoreCase("end")) {
				datagramSocket.close();
				out.close();
				System.out.println("File Send End");
				break;
			} else if(file != null) {
				//out.write(str.getBytes(), 0, str.getBytes().length);
				out.write(data, 0, data.length);
			}
		}
	}
}
