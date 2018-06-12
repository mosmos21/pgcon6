package jp.co.unirita.procon.result;

import java.util.HashMap;
import java.util.Map;

public class ResultUtil {
	
	private static Map<Integer, String> map = new HashMap<Integer, String>() {
		private static final long serialVersionUID = 1L;
		{
			// SUCCESS
			put(ResultCode.PCON_I_000, "正常に処理が完了しました");
			
			// ERROR
			put(ResultCode.PCON_E_000, "コマンドが存在しません");
			put(ResultCode.PCON_E_001, "コマンドに構文ミスがあります");
			put(ResultCode.PCON_E_002, "第1引数にエラーがあります");
			put(ResultCode.PCON_E_003, "第2引数にエラーがあります");
		}
	};

	public static String getResultMessage(int resultCode) {
		return map.getOrDefault(resultCode, "resultCodeが見つかりませんでした");
	}
}
