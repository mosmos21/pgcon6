package jp.co.unirita.procon.list;

import java.util.List;

public abstract class AbstractVirtualList<T> implements VirtualList<T> {

	private long size;
	
	public AbstractVirtualList (long size) {
		this.size = size;
	}

	@Override
	public long size() {
		return size;
	}

	@Override
	public abstract long count(); 

	@Override
	public abstract T get(long idx);

	@Override
	public abstract List<T> get(long startIdx, long endIdx);

	@Override
	public abstract void add(long idx, T value);

	@Override
	public abstract void add(long startIdx, long endIdx, T value);

	@Override
	public abstract void remove(long idx);

	@Override
	public abstract void remove(long startIdx, long endIdx);
}
