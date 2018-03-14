/*=====================================================================
□ Infomation
  ○ Data : 13.03.2018
  ○ Mail : eun1310434@naver.com
  ○ Blog : https://blog.naver.com/eun1310434
  ○ Reference 
      - 쉽게 배우는 소프트웨어 공학
      - Java Documentation
      - 헬로 자바 프로그래밍
      - programmers.co.kr

□ Function
  ○ Client
  ○ 보안정책 파일 생성 : rmisystem.policy
  ○ 보안정책 파일 등록 
    - Run → Run Configurations → Arguments → VM arguments → 입력"Djava.security.policy=rmisystem.policy"
  
     
□ Study
  ○ Network
    - Protocol : 규약, 약속, 보내고 받기위한 약속
    - Port : 한대의 컴퓨터에 포트는 14만여개 있음, TCP 포트와 UDP 포트가 있음
    - TCP/IP(Transmission Control Protocol) : 부하가 높으나 안전성이 높음
    - UDP(User Datagram Protocol)
    - Multicast : UDP의 확장버젼
    - RMI(Remote Method Invocation) 

    - structure
       : 컴퓨터A[응용계층(FTP, 텔넷, HTTP) → 전송계층(TCP,UDP) → 네트워크 계층(IP) → 링크계층(이더넷 토큰링) → 물리계층(케이블)]
         → 컴퓨터B[물리계층(케이블) → 링크계층(이더넷 토큰링) → 네트워크 계층(IP) → 전송계층(TCP,UDP) → 응용계층(FTP, 텔넷, HTTP)]

  ○ RMI
    - Remote Method Invocatoin
    - 원격지에 바인딩되어 있는 객체의 메서드를 호출 할 수 있도록 지원하는 API
    - RMI 통신 프로그램 작성순서
      01) 원격 인터페이스 작성(extends Remote, throws RemoteException)
      02) 서버에 바인딩되는 클래스의 메서드를 오버라이딩
      03) Server는 RMI 서버에 객체 바인딩
      04) Client는 RMI 서버에 바인딩된 객체를 가져와 원하는 메서드를 실행
    - 주의사항
      01) Remote 인터페이스를 상속 받아야 한다.(extends Remote)
      02) public 클래스여야 한다.
      03) RemoteException 예외를 처리해야 한다.(throws RemoteException)
    - 실행방법
      01) 보안설정을 위해 정책 파일 작성
      02) java.security에 정책 파일 위치 등록
      03) 서버 클래스와 클라이언트 크래스의 VM 매개변수로 정책 파일 등록
           (-Djava.security.policy=정책파일.policy)
      04)) rmiregistry를 통해 RMI 데몬 서버 실행
      05)) 서버 클래스와 클라이언트 클래스를 통해 실행 테스트

=====================================================================*/
package com.eun1310434.network.rmi;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
public class RMI_Client {
	public static void main(String[] ar) {
		
		//원격지에 있는 객체를 갖고옴
		try {
			//서버에서 Obj 갖고오기
			RMI_Interface rmi_interface = (RMI_Interface) Naming.lookup("rmi://192.168.43.40:1099/system");
			
			//실행
			boolean result = rmi_interface.turnOnSystem("Client01");
			
			//결과 반환 확인
			if(result){
				System.out.println("서버의 system이 켜짐");
			}else{
				System.out.println("서버의 system이 꺼짐");
			}
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
