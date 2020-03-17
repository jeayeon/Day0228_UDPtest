package Server;

import java.util.Random;

public class woonse {
	private static final String[] ws = { "짜장면", "칠리새우", "사람 조심하세요", "부자는 금물", "무모한 집착이 주의 되는 하루입니다"

	};

	public String selWoonse() {
		return ws[new Random().nextInt(ws.length)];

	}

}
