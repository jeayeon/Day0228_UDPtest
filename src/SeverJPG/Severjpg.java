package SeverJPG;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class Severjpg {

	public static void main(String[] args) throws Exception {
		//������ Ŭ���̾�Ʈ �����Ͽ� Ŭ���̾�Ʈ���� ������ �׸����� �ϳ� �����ϱ�.
		DatagramSocket db = new DatagramSocket(5512);
		byte[] getData = new byte[256];
		DatagramPacket dp = new DatagramPacket(getData,getData.length);
		
		while(true) {
			db.receive(dp);
			
		}

	}

}
