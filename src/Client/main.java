package Client;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;


public class main {
	public static final int port =4567;

	public static void main(String[] args) throws Exception {
		Scanner in = new Scanner(System.in);
		DatagramSocket ds = new DatagramSocket();
		InetAddress ip = InetAddress.getByName("10.0.0.115");
		
		byte[] buffer = new byte[256]; 
		DatagramPacket dp =null;
		while(true) {
			System.out.println("������ ���� �޼����� �Է��ϼ���");
			String msg = in.nextLine();
			if(msg.equalsIgnoreCase("x")){
				break;
			}else {
				
				buffer = msg.getBytes();
				dp = new DatagramPacket(buffer,buffer.length,ip,port);
				ds.send(dp);
				
			}
			byte[] buffer2 = new byte[256];
			DatagramPacket dp2 = new DatagramPacket(buffer2,buffer2.length,ip,port);
			ds.receive(dp2);
			byte[]msg2 = dp2.getData();
			String call = new String(msg2,0,dp2.getLength());
			if(call!=null) {
			System.out.println("�������� ���� ����̴�");
			System.out.println("�������� ����");
			System.out.println("ip : "+dp2.getAddress()+" / port : "+dp2.getPort());
			System.out.println("�޼��� ���� : "+call);
			
			call=null;
			}
			
		}

	}

}
