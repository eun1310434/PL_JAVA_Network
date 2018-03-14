/*=====================================================================
�� Infomation
  �� Data : 12.03.2018
  �� Mail : eun1310434@naver.com
  �� Blog : https://blog.naver.com/eun1310434
  �� Reference : ���� ���� ����Ʈ���� ����, Java Documentation, ��� �ڹ� ���α׷���, programmers.co.kr, 

�� Function
  �� ��� �����ִ� ��Ʈ��ȣ Ȯ��

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
import java.io.IOException;
import java.net.ServerSocket;
public class PortScan {
	public static void main(String[] ar) {
		ServerSocket serverSocket = null;
		
		//��� �����ִ� ��Ʈ��ȣ Ȯ��
		for(int n = 1; n < 65536; ++n) {
			try {
				serverSocket = new ServerSocket(n);
				serverSocket.close();
			}catch(IOException ex) {
				System.out.println("OPEN TCP PORT : "+n);
			}
		}
	}
}
