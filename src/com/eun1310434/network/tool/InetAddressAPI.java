/*=====================================================================
□ Infomation
  ○ Data : 12.03.2018
  ○ Mail : eun1310434@naver.com
  ○ Blog : https://blog.naver.com/eun1310434
  ○ Reference : 쉽게 배우는 소프트웨어 공학, Java Documentation, 헬로 자바 프로그래밍, programmers.co.kr, 

□ Function
  ○ 자신의 IP 주소 확인
  ○ DNS를 통한 IP 주소 확인
  ○ DNS를 통한 IP 주소들 확인

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
package com.eun1310434.network.tool;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressAPI {
	public static void main(String[] ar) {
		InetAddress local_addr = null;
		InetAddress remote_addr = null;
		InetAddress[] remote_addrs = null;
		
		try {
			// 자신의 IP 주소 확인
			local_addr = InetAddress.getLocalHost(); 
			
			//DNS를 통한 IP 주소 확인
			remote_addr = InetAddress.getByName("java.sun.com");
			
			//DNS를 통한 IP 주소들 확인
			remote_addrs = InetAddress.getAllByName("www.google.com");
		}catch(UnknownHostException ex) {
			System.err.println("ERROR");
			System.exit(-1);
		}
		
		System.out.println("local_addr = " + local_addr.getHostAddress());
		System.out.println("remote_addr = " + remote_addr.getHostAddress());
		for(int n = 0; n < remote_addrs.length; ++n) {
			System.out.println("Google Site[" + n + "] : "+ remote_addrs[n].getHostAddress());
		}
	}
}
