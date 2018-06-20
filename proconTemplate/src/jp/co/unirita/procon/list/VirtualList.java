package jp.co.unirita.procon.list;

public interface VirtualList<T> {
	
	// リスト全体のサイズを返す
	public long size();
	
	// リストの中で値が含まれている数を返す
	public long count();
	
	// 指定された添え字でアクセスされる値を返す
	public T get(long idx);
	
	// 指定された範囲の値を配列で返す
	public T[] get(long startIdx, long endIdx);
	
	// 指定された位置に値をセットする
	public void set(long idx, T value);
	
	// 指定された範囲に値をセットする
	public void set(long startIdx, long endIdx, T value);
	
	// 指定された添え字でアクセスされる値を削除する
	public void remove(long idx);
	
	// 指定された範囲の添え字でアクセスされる値を削除する
	public void remove(long startIdx, long endIdx);
}
