package Server;

import java.util.Random;

public class woonse {
	private static final String[] ws = { "¥���", "ĥ������", "��� �����ϼ���", "���ڴ� �ݹ�", "������ ������ ���� �Ǵ� �Ϸ��Դϴ�"

	};

	public String selWoonse() {
		return ws[new Random().nextInt(ws.length)];

	}

}
