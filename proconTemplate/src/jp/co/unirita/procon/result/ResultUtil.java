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
			put(ResultCode.PCON_E_001, "�\���G���[�����݂��܂�");
			put(ResultCode.PCON_E_002, "ST�R�}���h�����s����Ă��܂���");
			put(ResultCode.PCON_E_003, "ED�R�}���h�����s����Ă��܂���");
			put(ResultCode.PCON_E_004, "ST�R�}���h���O�ɃR�}���h�����s����Ă��܂�");
			put(ResultCode.PCON_E_005, "ED�R�}���h����ɃR�}���h�����s����Ă��܂�");
			put(ResultCode.PCON_E_006, "��1�p�����[�^������܂���");
			put(ResultCode.PCON_E_007, "��2�p�����[�^������܂���");
			put(ResultCode.PCON_E_008, "�p�����[�^��0�܂���1�ł���K�v������܂�");
			put(ResultCode.PCON_E_009, "�p�����[�^��2�܂���3�ł���K�v������܂�");

			put(ResultCode.PCON_E_999, "Result�R�[�h���ݒ肳��Ă��܂���B�ݒ肵�Ă��������B");
		}
	};

	public static String getResultMessage(int resultCode) {
		return map.getOrDefault(resultCode, "resultCode��������܂���ł���");
	}
}
