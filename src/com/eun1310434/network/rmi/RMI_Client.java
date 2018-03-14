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
  �� Client
  �� ������å ���� ���� : rmisystem.policy
  �� ������å ���� ��� 
    - Run �� Run Configurations �� Arguments �� VM arguments �� �Է�"Djava.security.policy=rmisystem.policy"
  
     
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

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
public class RMI_Client {
	public static void main(String[] ar) {
		
		//�������� �ִ� ��ü�� �����
		try {
			//�������� Obj �������
			RMI_Interface rmi_interface = (RMI_Interface) Naming.lookup("rmi://192.168.43.40:1099/system");
			
			//����
			boolean result = rmi_interface.turnOnSystem("Client01");
			
			//��� ��ȯ Ȯ��
			if(result){
				System.out.println("������ system�� ����");
			}else{
				System.out.println("������ system�� ����");
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
