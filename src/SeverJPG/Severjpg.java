package SeverJPG;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class Severjpg {

	public static void main(String[] args) throws Exception {
		//서버와 클라이언트 구분하여 클아이언트에서 서버로 그림파일 하나 전송하기.
		DatagramSocket db = new DatagramSocket(5512);
		byte[] getData = new byte[256];
		DatagramPacket dp = new DatagramPacket(getData,getData.length);
		
		while(true) {
			db.receive(dp);
			
		}

	}

}
