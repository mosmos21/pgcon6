package jp.co.unirita.procon.list.impl;

import java.util.Arrays;
import java.util.stream.Stream;

import jp.co.unirita.procon.list.AbstractVirtualList;

public class SmallList<T> extends AbstractVirtualList<T> {
	
	private Object[] arr;
	
	public SmallList () {
		this(10000000);
	}

	public SmallList(long size) {
		super(size);
		this.arr = new Object[(int)size];
	}

	@Override
	public long count() {
		return Stream.of(arr).filter(obj -> obj != null).count();
	}

	@SuppressWarnings("unchecked")
	@Override
	public T get(long idx) {
		return (T)arr[(int)idx];
	}

	@SuppressWarnings("unchecked")
	@Override
	public T[] get(long startIdx, long endIdx) {
		return (T[])Arrays.copyOfRange(this.arr, (int)startIdx, (int)endIdx);
	}

	@Override
	public void set(long idx, T value) {
		this.arr[(int)idx] = value;
		
	}

	@Override
	public void set(long startIdx, long endIdx, T value) {
		Arrays.fill(this.arr, (int)startIdx, (int)endIdx, value);
	}

	@Override
	public void remove(long idx) {
		this.set(idx, null);
	}

	@Override
	public void remove(long startIdx, long endIdx) {
		this.set(startIdx, endIdx, null);
	}
}
