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
			put(ResultCode.PCON_E_001, "構文エラーが存在します");
			put(ResultCode.PCON_E_002, "STコマンドが実行されていません");
			put(ResultCode.PCON_E_003, "EDコマンドが実行されていません");
			put(ResultCode.PCON_E_004, "STコマンドより前にコマンドが実行されています");
			put(ResultCode.PCON_E_005, "EDコマンドより後にコマンドが実行されています");
			put(ResultCode.PCON_E_006, "第1パラメータがありません");
			put(ResultCode.PCON_E_007, "第2パラメータがありません");
			put(ResultCode.PCON_E_008, "パラメータは0または1である必要があります");
			put(ResultCode.PCON_E_009, "パラメータは2または3である必要があります");

			put(ResultCode.PCON_E_999, "Resultコードが設定されていません。設定してください。");
		}
	};

	public static String getResultMessage(int resultCode) {
		return map.getOrDefault(resultCode, "resultCodeが見つかりませんでした");
	}
}
