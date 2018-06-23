package jp.co.unirita.procon.list.impl;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import jp.co.unirita.procon.list.AbstractVirtualList;

public class SmallList<T> extends AbstractVirtualList<T> {

	private Object[] arr;

	public SmallList() {
		this(10000000);
	}

	public SmallList(long size) {
		super(size);
		this.arr = new Object[(int) size];
	}

	@Override
	public long count() {
		return Stream.of(arr).filter(obj -> obj != null).count();
	}

	@SuppressWarnings("unchecked")
	@Override
	public T get(long idx) {
		return (T) arr[(int) idx];
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> get(long startIdx, long endIdx) {
		endIdx = Math.min(startIdx + 19, endIdx);
		Object[] objArr = Arrays.copyOfRange(this.arr, (int) startIdx, (int) endIdx + 1);
		return Stream.of(objArr).map(obj -> (T)obj).collect(Collectors.toList());
	}

	@Override
	public void add(long idx, T value) {
		this.arr[(int) idx] = value;
	}

	@Override
	public void add(long startIdx, long endIdx, T value) {
		Arrays.fill(this.arr, (int) startIdx, (int) endIdx, value);
	}

	@Override
	public void remove(long idx) {
		this.add(idx, null);
	}

	@Override
	public void remove(long startIdx, long endIdx) {
		this.add(startIdx, endIdx, null);
	}
}
