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
       - ��Ʈ = �����ȣ

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
import java.net.InetAddress;
import java.util.Scanner;
public class UDP_BasicClient {
	public static void main(String[] ar) {
		
		Scanner cin = new Scanner(System.in);
		DatagramSocket datagramSocket = null;
		InetAddress remote_addr = null;
		
		try {
			datagramSocket = new DatagramSocket();
			
			while(true) {
				
				System.out.print("Send Data = ");
				String data = cin.nextLine();
				
				//quit�� �Է��ϸ� ����
				if(data.equals("quit")) {
					datagramSocket.close();
					cin.close();
					break;
				}
				
				try {
					//remote_addr = InetAddress.getByName("000.000.000.000");
					remote_addr = InetAddress.getLocalHost();//�ڽ��� Ȩ IP �ּҷ� ��ü ���
					

					//������ ��Ʈ - Port : 0 ~ 65535 : 2000
					int port = 54321;
					
					DatagramPacket datagramPacket = 
							new DatagramPacket(
									data.getBytes(), 
									data.getBytes().length, 
									remote_addr, 
									port);
					
					
					datagramSocket.send(datagramPacket);
					
				}catch(IOException ex) {
					System.out.println("Send ERROR : " + ex.getMessage());
				}
			}
		}catch(IOException ex) {
			System.err.println("Socket ERROR : " + ex.getLocalizedMessage());
			System.exit(-1);
		}
	}
}
