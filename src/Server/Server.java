package Server;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class Server {

	public static void main(String[] args) throws Exception {
		Scanner in = new Scanner(System.in);
		// 전송방식 UDP TCP >> UDP를 사용해서 코딩
		// UDP에서 서버와 클라이언트에 구분하여 코딩
		// 바인딩 인셉션은 누군가 이미 이포트를 쓰고있을때 나는 에러
		// UDP방식에서 통신하기위해 필요한 것은 : DatagramSocket & DatagramPacket
		// 통신하기위한 일련의절차 데이터를 실어 나르는 박스
		// OSI7레이어 :데이터통신을위한 규칙을 정의해놓은것

		// 나는 ip 10.0.0.115 포트 4567을 가진 서버 이다.
		DatagramSocket ds = new DatagramSocket(4567);
		byte[] buffer = new byte[256];
		DatagramPacket dp = new DatagramPacket(buffer, buffer.length); // 데이터

		while (true) {
			System.out.println("클라이언트가 보낼 데이터 대기중");
			ds.receive(dp);
			byte[] dpmsg = dp.getData();
			String msg = new String(dpmsg, 0, dp.getLength());

			System.out.println("보낸사람 정보");
			System.out.println("ip : " + dp.getAddress() + " / port : " + dp.getPort());
			System.out.println("메시지 내용 : " + msg);
			if (msg != null) {
				msg = null;
				System.out.println("메시지가 왔으니 답장을 보내세요");
//				woonse ws = new woonse(); 다른클래스의 객체를 생성후 스트링리턴받아서쓰면 운세같은거만들수도있고그럼
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
