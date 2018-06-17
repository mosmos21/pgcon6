package jp.co.unirita.procon.result;

public class ResultCode {
	// SUCCESS
	public static final int PCON_I_000 = 0; // 処理が正常に終了しました

	// ERROR
	public static final int PCON_E_000 = 100; // コマンドが存在しません
	public static final int PCON_E_001 = 101; // 構文エラーが存在します
	public static final int PCON_E_002 = 102; // STコマンドが実行されていません
	public static final int PCON_E_003 = 103; // EDコマンドが実行されていません
	public static final int PCON_E_004 = 104; // STコマンドより前にコマンドが実行されています
	public static final int PCON_E_005 = 105; // EDコマンドより後にコマンドが実行されています
	public static final int PCON_E_006 = 106; // 第1パラメータがありません
	public static final int PCON_E_007 = 107; // 第2パラメータがありません
	public static final int PCON_E_008 = 108; // パラメータは0または1である必要があります
	public static final int PCON_E_009 = 109; // パラメータは2または3である必要があります

	public static final int PCON_E_999 = 999; // 未定義用
}
