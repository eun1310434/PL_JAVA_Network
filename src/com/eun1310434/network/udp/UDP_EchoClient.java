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
public class UDP_EchoClient {
	public static void main(String[] ar){
		
		Scanner cin = new Scanner(System.in);
		DatagramSocket datagramSocket = null;
		InetAddress remote_addr = null;
		
		
		try {
			//������ Port ���� : 0 ~ 65535 : 2000
			//EchoServer�� ��Ʈ��ȣ�� �ٸ��� ����
			int port = 12345;

			datagramSocket = new DatagramSocket(port);

			while(true) {				
				System.out.print("Send Data = ");
				String message = cin.nextLine();
				
				//quit�� �Է��ϸ� ����
				if(message.equals("quit")) {
					datagramSocket.close();
					cin.close();
					break;
				}

				try {
					//remote_addr = InetAddress.getByName("000.000.000.000");
					remote_addr = InetAddress.getLocalHost();//�ڽ��� Ȩ IP �ּҷ� ��ü ���
					
					DatagramPacket datagramPacket = 
							new DatagramPacket(
									message.getBytes(), 
									message.getBytes().length, 
									remote_addr, 
									port);
					

					// ����
					datagramSocket.send(datagramPacket);
					
					
					//����
					//��������� �������� ���� �ִ�ũ���� byte ����
					byte[] data = new byte[65508];
					datagramPacket = 
							new DatagramPacket(
									data, 
									data.length);
					datagramSocket.receive(datagramPacket);
					
					System.out.println("Echo>>"+new String(datagramPacket.getData()).trim());
					
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
