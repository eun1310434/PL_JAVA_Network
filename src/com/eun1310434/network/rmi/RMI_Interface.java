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
  ○ RMI interface 구현
    - 필수-Remote를 상속받아야 RMI실행 가능
    - 필수-RemoteException을 갖고와서 예외 전가

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

import java.rmi.Remote;
import java.rmi.RemoteException;
public interface RMI_Interface extends Remote {//필수-Remote를 상속받아야 RMI실행 가능
	
	public boolean turnOnSystem(String id) throws RemoteException;//필수-RemoteException을 갖고와서 예외 전가
	public boolean turnOffSystem(String id) throws RemoteException;//필수-RemoteException을 갖고와서 예외 전가
}
