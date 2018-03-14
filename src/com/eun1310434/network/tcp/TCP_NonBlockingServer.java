/*=====================================================================
�� Infomation
  �� Data : 09.03.2018
  �� Mail : eun1310434@naver.com
  �� Blog : https://blog.naver.com/eun1310434
  �� Reference : ���� ���� ����Ʈ���� ����, Java Documentation, ��� �ڹ� ���α׷���, programmers.co.kr

�� Function
  �� ByteBuffer�� Ȱ���� ��Ʈ��ũ ����
    - NonBlocking IO
	- Blocking IO


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
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

public class TCP_NonBlockingServer {
	public static void main(String[] ar) throws Exception {
		Selector selector = Selector.open();
		
		ServerSocketChannel serverSocket = ServerSocketChannel.open();
		serverSocket.bind(new InetSocketAddress("localhost", 54321));
		serverSocket.configureBlocking(false);
		serverSocket.register(selector, serverSocket.validOps());
		
		System.out.println("Server Ready...");
		
		while(true) {
			selector.select();
			
			Iterator<SelectionKey> selectedKeys = selector.selectedKeys().iterator();
			
			while(selectedKeys.hasNext()) {
				SelectionKey selectedKey = selectedKeys.next();
				
				if(selectedKey.isAcceptable()) {
					SocketChannel client = serverSocket.accept();
					client.configureBlocking(false);
					client.register(selector, SelectionKey.OP_READ);
					System.out.println("Connection : " + client.getLocalAddress());
				
				} else if(selectedKey.isReadable()) {
					
					//ü���� ȹ��
					SocketChannel client = (SocketChannel)selectedKey.channel();
					
					//�ý���
					ByteBuffer byteData = ByteBuffer.allocateDirect(256);//�ý��� �޸� ����
					//ByteBuffer byteData = ByteBuffer.allocate(256);//�� �޸� ����
					client.read(byteData);

					String receiveData ="";
					if(byteData.hasArray()){
						//�� �޸� ����
						receiveData = new String(byteData.array()).trim();
					}else{
						//�ý��� �޸� ����
						byteData.flip();//�������� ���� ó������ ��ġ
						while(byteData.hasRemaining()){
							receiveData = receiveData  + (char) byteData.get();//buffer�� ũ�⸸ŭ ����� �ֱ⿡ ���ڰ� �ȳ���
						}
						byteData.clear();//�����ϰ� ����
					}

					if(receiveData.equalsIgnoreCase("over")) {
						client.close();
					} else {
						System.out.println("Message : " + receiveData);
					}
				
				}
				selectedKeys.remove();
			}
		}
	}
}
