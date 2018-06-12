package jp.co.unirita.procon.result;

public class ResultCode {
	// SUCCESS
	public static final int PCON_I_000  = 0; // 処理が正常に終了しました
	
	// ERROR
	public static final int PCON_E_000 = 100; // コマンドが存在しません
	public static final int PCON_E_001 = 101; // 構文エラーが存在します
	public static final int PCON_E_002 = 102; // 第一引数がエラーです
	public static final int PCON_E_003 = 103; // 第2引数がエラーです
}
