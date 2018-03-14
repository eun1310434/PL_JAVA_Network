/*=====================================================================
�� Infomation
  �� Data : 12.03.2018
  �� Mail : eun1310434@naver.com
  �� Blog : https://blog.naver.com/eun1310434
  �� Reference : ���� ���� ����Ʈ���� ����, Java Documentation, ��� �ڹ� ���α׷���, programmers.co.kr, 

�� Function
  �� Client
  �� IP ���� - ������ �ּ� �Է�
  �� Data ����
  �� Buffer ���� - PrintWriter���� ��ü������ flush����� ����
  �� PrintWriter ����
  �� ���� ����

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
package com.eun1310434.network.tcp;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
public class TCP_BasicClient {
	public static void main(String[] ar) {
		InetAddress remote_addr = null;
		Socket socket = null;
		
		try {
			//IP ���� - ������ �ּ� �Է�
			//IP address for the given host name
			//remote_addr = InetAddress.getByName("000.000.000.000");
			remote_addr = InetAddress.getLocalHost();//�ڽ��� Ȩ IP �ּҷ� ��ü ���

			//������ ��Ʈ - Port : 0 ~ 65535 : 2000
			int port = 54321;
			socket = new Socket(remote_addr, port);
			System.out.println("Connectoin Request");
			
			PrintWriter out = 
					new PrintWriter(
							new BufferedWriter(
									new OutputStreamWriter(socket.getOutputStream())));

			//Data ����
			out.println("eun1310434\n");
			
			//Buffer ���� - PrintWriter���� ��ü������ flush����� ����
			out.flush();
			System.out.println("Data Send Complete!");

			//PrintWriter ����
			//out.close();
			socket.shutdownOutput();
			
			//���� ����
			socket.close();
			System.out.println("Connection Complete");
		}catch(IOException ex) {
			System.err.println("Connection ERROR : " + ex.getLocalizedMessage());
			System.exit(-1);
		}
	}
}
