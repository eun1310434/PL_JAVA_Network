/*=====================================================================
�� Infomation
  �� Data : 13.03.2018
  �� Mail : eun1310434@naver.com
  �� Blog : https://blog.naver.com/eun1310434
  �� Reference : ���� ���� ����Ʈ���� ����, Java Documentation, ��� �ڹ� ���α׷���, programmers.co.kr, 

�� Function
  �� UDP ���
       - UDP ��� = �������
       - ���� = ��Ŷ
       - IP�ּ� = �����ּ�
       - ��Ʈ = ������ȣ

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
package com.eun1310434.network.udp;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
public class UDP_BasicServer {
	
	public static void main(String[] ar) {
		DatagramSocket datagramSocket = null;		
		try {
			//������ ��Ʈ - Port : 0 ~ 65535 : 2000
			int port = 54321;
			
			datagramSocket = new DatagramSocket(port);
			System.out.println("Server Ready...");
			
			while(true) {
				byte[] data = new byte[65508];//��������� �������� ���� �ִ�ũ��
				DatagramPacket datagramPacket = new DatagramPacket(data, data.length);
				datagramSocket.receive(datagramPacket);

				//IP Address
				String ipAddress = datagramPacket.getAddress().getHostAddress();
				
				//Receive Data
				//String data_str = new String(data);
				String data_str = new String(datagramPacket.getData()).trim();
				
				//Print
				System.out.printf("%s >> %s\n", ipAddress, data_str);
			}
			
		}catch(IOException ex) {
			System.err.println("ERROR : " + ex.getMessage());
			System.exit(-1);
		}
	}
}