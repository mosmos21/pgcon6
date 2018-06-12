package jp.co.unirita.procon.result;

import java.util.HashMap;
import java.util.Map;

public class ResultUtil {
	
	private static Map<Integer, String> map = new HashMap<Integer, String>() {
		private static final long serialVersionUID = 1L;
		{
			// SUCCESS
			put(ResultCode.PCON_I_000, "����ɏ������������܂���");
			
			// ERROR
			put(ResultCode.PCON_E_000, "�R�}���h�����݂��܂���");
			put(ResultCode.PCON_E_001, "�R�}���h�ɍ\���~�X������܂�");
			put(ResultCode.PCON_E_002, "��1�����ɃG���[������܂�");
			put(ResultCode.PCON_E_003, "��2�����ɃG���[������܂�");
		}
	};

	public static String getResultMessage(int resultCode) {
		return map.getOrDefault(resultCode, "resultCode��������܂���ł���");
	}
}
