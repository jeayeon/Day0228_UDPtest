package Server;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class Server {

	public static void main(String[] args) throws Exception {
		Scanner in = new Scanner(System.in);
		// ���۹�� UDP TCP >> UDP�� ����ؼ� �ڵ�
		// UDP���� ������ Ŭ���̾�Ʈ�� �����Ͽ� �ڵ�
		// ���ε� �μ����� ������ �̹� ����Ʈ�� ���������� ���� ����
		// UDP��Ŀ��� ����ϱ����� �ʿ��� ���� : DatagramSocket & DatagramPacket
		// ����ϱ����� �Ϸ������� �����͸� �Ǿ� ������ �ڽ�
		// OSI7���̾� :��������������� ��Ģ�� �����س�����

		// ���� ip 10.0.0.115 ��Ʈ 4567�� ���� ���� �̴�.
		DatagramSocket ds = new DatagramSocket(4567);
		byte[] buffer = new byte[256];
		DatagramPacket dp = new DatagramPacket(buffer, buffer.length); // ������

		while (true) {
			System.out.println("Ŭ���̾�Ʈ�� ���� ������ �����");
			ds.receive(dp);
			byte[] dpmsg = dp.getData();
			String msg = new String(dpmsg, 0, dp.getLength());

			System.out.println("������� ����");
			System.out.println("ip : " + dp.getAddress() + " / port : " + dp.getPort());
			System.out.println("�޽��� ���� : " + msg);
			if (msg != null) {
				msg = null;
				System.out.println("�޽����� ������ ������ ��������");
//				woonse ws = new woonse(); �ٸ�Ŭ������ ��ü�� ������ ��Ʈ�����Ϲ޾Ƽ����� ������Ÿ�������ְ�׷�
//				ws.selWoonse();
				String call = in.nextLine();
//				byte[] buffer2 = null;
				buffer = call.getBytes();
				DatagramPacket dp2 = new DatagramPacket(buffer, buffer.length, dp.getAddress(), dp.getPort());
				ds.send(dp2);

			}

		}

	}

}
