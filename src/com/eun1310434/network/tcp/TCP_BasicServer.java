/*=====================================================================
�� Infomation
  �� Data : 12.03.2018
  �� Mail : eun1310434@naver.com
  �� Blog : https://blog.naver.com/eun1310434
  �� Reference : ���� ���� ����Ʈ���� ����, Java Documentation, ��� �ڹ� ���α׷���, programmers.co.kr, 

�� Function
  �� Server
  �� Client ���� ��� - blocking
  �� Client ���� ��
  �� ���پ� �Է� ����
  �� BufferedReader ����
  �� ���� ����
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
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
public class TCP_BasicServer {
	public static void main(String[] ar) {
		ServerSocket serverSocket = null;
		try {
			serverSocket = new ServerSocket(54321);
			System.out.println("Server Ready...");
			
			//Client ���� ��� - blocking
			Socket socket = serverSocket.accept();
			
			//Client ���� ��
			System.out.println("Conntion User Info : " + socket);
			
			BufferedReader in = 
					new BufferedReader( 
							new InputStreamReader(socket.getInputStream()));
			
			//���پ� �Է� ����
			String data = in.readLine();
			System.out.println("Received Data : " + data);
			

			//BufferedReader ����
			//in.close();
			socket.shutdownInput();

			//���� ����
			socket.close();
			
			//���� ����
			serverSocket.close();
			
		}catch(IOException ex) {
			System.err.println("Port conflict");
			System.exit(-1);
		}
	}
}
