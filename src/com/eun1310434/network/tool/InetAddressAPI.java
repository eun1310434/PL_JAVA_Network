/*=====================================================================
�� Infomation
  �� Data : 12.03.2018
  �� Mail : eun1310434@naver.com
  �� Blog : https://blog.naver.com/eun1310434
  �� Reference : ���� ���� ����Ʈ���� ����, Java Documentation, ��� �ڹ� ���α׷���, programmers.co.kr, 

�� Function
  �� �ڽ��� IP �ּ� Ȯ��
  �� DNS�� ���� IP �ּ� Ȯ��
  �� DNS�� ���� IP �ּҵ� Ȯ��

�� Study
  �� Network
    - Protocol : �Ծ�, ���, ������ �ޱ����� ���
    - Port : �Ѵ��� ��ǻ�Ϳ� ��Ʈ�� 14������ ����, TCP ��Ʈ�� UDP ��Ʈ�� ����
    - TCP/IP(Transmission Control Protocol) : ���ϰ� ������ �������� ����
    - UDP(User Datagram Protocol)
    - Multicast : UDP�� Ȯ�����
    - RMI(Remote Method Invocation) 
    
  �� structure
                ��ǻ��A[�������(FTP, �ڳ�, HTTP) �� ���۰���(TCP,UDP) �� ��Ʈ��ũ ����(IP) �� ��ũ����(�̴��� ��ū��) �� ��������(���̺�)]
     �� ��ǻ��B[��������(���̺�) �� ��ũ����(�̴��� ��ū��) �� ��Ʈ��ũ ����(IP) �� ���۰���(TCP,UDP) �� �������(FTP, �ڳ�, HTTP)]
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
			// �ڽ��� IP �ּ� Ȯ��
			local_addr = InetAddress.getLocalHost(); 
			
			//DNS�� ���� IP �ּ� Ȯ��
			remote_addr = InetAddress.getByName("java.sun.com");
			
			//DNS�� ���� IP �ּҵ� Ȯ��
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
