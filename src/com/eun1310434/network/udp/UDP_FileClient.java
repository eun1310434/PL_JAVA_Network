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
package com.eun1310434.network.udp;
import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
public class UDP_FileClient {
	public static void main(String[] ar) throws IOException {
		
		DataInputStream in = null;
		
		String ip = InetAddress.getLocalHost().getHostAddress();
		int port = 12345;
		String filePath = "D:\\PJM\\ECLIPSE\\Examples\\PL_JAVA_Network\\src\\com\\eun1310434\\network\\udp\\";
		String fileName = "UDP_FileClient.java";
		
		File file = new File(filePath, fileName);
		if(!file.exists()) {
			System.err.println("������ �������� �ʽ��ϴ�.");
			System.exit(-1);
		}
		
		in = new DataInputStream(
				new BufferedInputStream(
						new FileInputStream(file)));
		
		DatagramSocket datagramSocket = new DatagramSocket();
		InetAddress remote_addr = InetAddress.getByName(ip);
		
		byte[] start = "start".getBytes();
		byte[] end = "end".getBytes();
		
		
		//���� ���� �˸�
		System.out.println("Send Start!!!");
		DatagramPacket datagramPacket = 
				new DatagramPacket(
						start, 
						start.length, 
						remote_addr, 
						port);
		datagramSocket.send(datagramPacket);
		
		//���� �̸� ����
		datagramPacket = 
				new DatagramPacket(
						fileName.getBytes(), 
						fileName.getBytes().length, 
						remote_addr, 
						port);
		datagramSocket.send(datagramPacket);
		
		//���� ����
		byte[] data = null;
		while(true) {
			data = new byte[1024];
			int n = in.read(data, 0, data.length);
			
			if(n < 0){break;}
			
			datagramPacket = 
					new DatagramPacket(
							data, 
							n, 
							remote_addr, 
							port);
			datagramSocket.send(datagramPacket);
		}
		

		//���� ���� �˸�
		datagramPacket = 
				new DatagramPacket(
						end, 
						end.length, 
						remote_addr, 
						port);
		datagramSocket.send(datagramPacket);
		
		
		
		//����
		in.close();
		datagramSocket.close();
		System.out.println("Complete");
	}
}
