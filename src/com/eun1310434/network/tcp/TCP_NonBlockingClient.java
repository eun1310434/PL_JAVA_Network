/*=====================================================================
�� Infomation
  �� Data : 09.03.2018
  �� Mail : eun1310434@naver.com
  �� Blog : https://blog.naver.com/eun1310434
  �� Reference : ���� ���� ����Ʈ���� ����, Java Documentation, ��� �ڹ� ���α׷���, programmers.co.kr

�� Function
  �� NonBlocking IO�� Ȱ���� ��Ʈ��ũ Ŭ���̾�Ʈ

�� Study
  �� IO
    - IO  �� Byte �� InputStream(:abstract class)
                 �� OutputStream(:abstract class)
          �� Char �� Reader(:abstract class)
                 �� Writer(:abstract class)
    - byte���� �����Ŭ���� 
      : InputStream, OutputStream �߻�Ŭ���� ���
    - char(����)���� �����Ŭ����
      : Reader, Writer��� �߻�Ŭ���� ���      
    - 4���� �߻�Ŭ������ �޾Ƶ��̴� ������ -> �پ��� ����� ����� �����ϴ� Ŭ����
    - 4���� �߻�Ŭ������ �޾Ƶ��̴� ������ ���� -> ���κ��� �Է¹��� ������, ��� ���������� ��Ÿ���� Ŭ����
    - FileIO(���� �����) 
      : FileInputStream, OutputStream, FileReader, FileWriter
    - ByteIO(�迭 �����)
      : ByteArrayInputStream, ByteArrayOutputStream, CharReader, CharWriter
    - �پ��� ��� �����(FileIO,ByteIO�� ���μ� ��� ȿ���� Ȱ��)
      : DataInputStream, DatOutputStream, BufferedReader, PrintWriter
    - �ڹ�IO�� Decorator Pattern�� Ȱ���Ͽ� ����
      : �ϳ��� Ŭ������ ��� �ϴ� ��ó�� �����ڿ��� ���μ� ���ο� ����� ��� �߰� �� �� �ֵ��� Ŭ������ ����� ���
      
  �� NIO 
    - BIO(���ŷ, ����Ʈ ��Ʈ�� ���) �� NIO(�ͺ��ŷ, ���۸� ����ϴ� ä�� ���)
    - BIO(�������� �޸𸮸� ��� �ý��� �޸� ����) �� NIO(ByteBuffer�� ��� �ٷ� �ý��ۿ� �����Ͽ� �޸𸮸� �Ҵ�)
    - �����ڿ� ���� ����, ����ӵ��� �ſ� ����, ���ϵ� ����
    - Blocking? : ��� ���α׷����� ������ ����ϰ� ������, �ٸ� ����ڴ� �ش������� �������� ���� �ǹ�
    
  �� ����
    - Buffer �� ByteBuffer �� MappedByteBuffer
             �� CharBuffer
             �� SherBuffer
             �� intBuffer
             �� LongBuffer
             �� DoubleBuffer
             
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
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class TCP_NonBlockingClient {
	public static void main(String[] ar) throws Exception {
		SocketChannel client = SocketChannel.open(
				new InetSocketAddress("localhost", 54321));
		
		byte[] data = "Hello There!!!".getBytes();
		byte[] data2 = "over".getBytes();
		ByteBuffer byteData = ByteBuffer.wrap(data);
		client.write(byteData);
		byteData.clear();
		Thread.sleep(100);
		client.write(ByteBuffer.wrap(data2));
		byteData.clear();
		
		client.close();
		
		System.out.println("Send Data!!!");
	}
}
