/*=====================================================================
�� Infomation
  �� Data : 09.03.2018
  �� Mail : eun1310434@naver.com
  �� Blog : https://blog.naver.com/eun1310434
  �� Reference : ���� ���� ����Ʈ���� ����, Java Documentation, ��� �ڹ� ���α׷���, programmers.co.kr, 

�� Function
  �� Multicast 
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
public class Multicast_BasicServer {
	
	public static void main(String[] ar) throws IOException {
		
		MulticastSocket socket = new MulticastSocket(12345);
		
		//Multicast�� DŬ����[224.0.0.0 ~ 239.255.255.255]
		socket.joinGroup(InetAddress.getByName("224.0.0.1"));
		
		while(true) {
			DatagramPacket packet = new DatagramPacket(new byte[65508], 65508);
			socket.receive(packet);
			
			InetAddress client_addr = packet.getAddress();
			String message = new String(packet.getData()).trim();
			System.out.println(client_addr.getHostAddress() + " >> " + message);
		}
		
		//socket.leaveGroup(InetAddress.getByName("224.0.0.1"));
		//socket.close();
	}
}
