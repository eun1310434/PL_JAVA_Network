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
import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
public class UDP_FileServer {
	public static void main(String[] ar) throws IOException {

		DataOutputStream out = null;
		File file = null;
		
		int port = 12345;
		DatagramSocket datagramSocket = new DatagramSocket(port);
		System.out.println("Server Ready...");
		
		while(true) {

			byte[] data = new byte[65508];//��������� �������� ���� �ִ�ũ��
			DatagramPacket datagramPacket = 
					new DatagramPacket(
							data, 
							data.length);
			datagramSocket.receive(datagramPacket);
			String str = new String(datagramPacket.getData()).trim();
			

			//���� ���� �˸� Ȯ��
			if(str.equalsIgnoreCase("start")) {
				//���� ���� �˸� Ȯ��
				
				System.out.println("File Send Start");
				datagramSocket.receive(datagramPacket);
				str = new String(datagramPacket.getData()).trim();
				
				File dir = new File("D:\\PJM\\ECLIPSE\\Examples\\PL_JAVA_Network\\data\\");
				if(!dir.exists()) dir.mkdirs();
				
				file = new File(dir.getPath(), str);
				out = new DataOutputStream(
						new BufferedOutputStream(
								new FileOutputStream(file)));
				
			} else if(str.equalsIgnoreCase("end")) {
				datagramSocket.close();
				out.close();
				System.out.println("File Send End");
				break;
			} else if(file != null) {
				//out.write(str.getBytes(), 0, str.getBytes().length);
				out.write(data, 0, data.length);
			}
		}
	}
}
