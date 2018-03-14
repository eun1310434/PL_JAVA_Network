/*=====================================================================
�� Infomation
  �� Data : 13.03.2018
  �� Mail : eun1310434@naver.com
  �� Blog : https://blog.naver.com/eun1310434
  �� Reference 
      - ���� ���� ����Ʈ���� ����
      - Java Documentation
      - ��� �ڹ� ���α׷���
      - programmers.co.kr

�� Function
  �� RMI Server ����
    - ���� ������ ���� ���� ����
    - turnOnSystem/turnOffSystem 
     
�� Study
  �� Network
    - Protocol : �Ծ�, ���, ������ �ޱ����� ���
    - Port : �Ѵ��� ��ǻ�Ϳ� ��Ʈ�� 14������ ����, TCP ��Ʈ�� UDP ��Ʈ�� ����
    - TCP/IP(Transmission Control Protocol) : ���ϰ� ������ �������� ����
    - UDP(User Datagram Protocol)
    - Multicast : UDP�� Ȯ�����
    - RMI(Remote Method Invocation) 

    - structure
       : ��ǻ��A[�������(FTP, �ڳ�, HTTP) �� ���۰���(TCP,UDP) �� ��Ʈ��ũ ����(IP) �� ��ũ����(�̴��� ��ū��) �� ��������(���̺�)]
         �� ��ǻ��B[��������(���̺�) �� ��ũ����(�̴��� ��ū��) �� ��Ʈ��ũ ����(IP) �� ���۰���(TCP,UDP) �� �������(FTP, �ڳ�, HTTP)]

  �� RMI
    - Remote Method Invocatoin
    - �������� ���ε��Ǿ� �ִ� ��ü�� �޼��带 ȣ�� �� �� �ֵ��� �����ϴ� API
    - RMI ��� ���α׷� �ۼ�����
      01) ���� �������̽� �ۼ�(extends Remote, throws RemoteException)
      02) ������ ���ε��Ǵ� Ŭ������ �޼��带 �������̵�
      03) Server�� RMI ������ ��ü ���ε�
      04) Client�� RMI ������ ���ε��� ��ü�� ������ ���ϴ� �޼��带 ����
    - ���ǻ���
      01) Remote �������̽��� ��� �޾ƾ� �Ѵ�.(extends Remote)
      02) public Ŭ�������� �Ѵ�.
      03) RemoteException ���ܸ� ó���ؾ� �Ѵ�.(throws RemoteException)
    - ������
      01) ���ȼ����� ���� ��å ���� �ۼ�
      02) java.security�� ��å ���� ��ġ ���
      03) ���� Ŭ������ Ŭ���̾�Ʈ ũ������ VM �Ű������� ��å ���� ���
           (-Djava.security.policy=��å����.policy)
      04)) rmiregistry�� ���� RMI ���� ���� ����
      05)) ���� Ŭ������ Ŭ���̾�Ʈ Ŭ������ ���� ���� �׽�Ʈ

=====================================================================*/
package com.eun1310434.network.rmi;

public class RMI_Server implements RMI_Interface {
	public RMI_Server() {
		super();
	}
	@Override
	public boolean turnOnSystem(String id) {
		System.out.println(" turnOnSysteme = " + id.toString());
		return true;
	}
	@Override
	public boolean turnOffSystem(String id) {
		System.out.println(" turnOffSystem = " + id.toString());
		return true;
	}
}