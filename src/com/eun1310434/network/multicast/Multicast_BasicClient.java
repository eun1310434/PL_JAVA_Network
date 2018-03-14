/*=====================================================================
�� Infomation
  �� Data : 09.03.2018
  �� Mail : eun1310434@naver.com
  �� Blog : https://blog.naver.com/eun1310434
  �� Reference : ���� ���� ����Ʈ���� ����, Java Documentation, ��� �ڹ� ���α׷���, programmers.co.kr, 

�� Function
  �� Multicast 
    - Ư�� �ټ��� ���
    - Client�� ���� ������ �Ͽ��� 1:n ����̱⿡ ���� ����
    - D Ŭ����[224.0.0.0 ~ 239.255.255.255]
    - joinGroup
    - leaveGroup
    - ä�� ���
    

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
package com.eun1310434.network.multicast;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.util.Scanner;
public class Multicast_BasicClient {
	public static void main(String[] ar) throws IOException {
		
		Scanner cin = new Scanner(System.in);
		MulticastSocket socket = new MulticastSocket();
		
		while(true) {
			System.out.print("Message = ");
			
			String message = cin.nextLine();

			//Multicast�� DŬ����[224.0.0.0 ~ 239.255.255.255]
			InetAddress remote_addr = InetAddress.getByName("224.0.0.1");
			
			DatagramPacket packet = 
					new DatagramPacket(
							message.getBytes(), 
							message.getBytes().length, 
							remote_addr, 
							12345);
			
			socket.send(packet);
		}	
		//cin.close();
		//socket.close();
	}
}
