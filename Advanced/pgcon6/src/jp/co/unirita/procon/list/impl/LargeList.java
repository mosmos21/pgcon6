package jp.co.unirita.procon.list.impl;

import java.util.TreeSet;

import jp.co.unirita.procon.list.AbstractVirtualList;

public class LargeList<T> extends AbstractVirtualList<T> {

	TreeSet<RangeCell<T>> rangeCellSet;

	public LargeList() {
		this(1_000_000_000_000L);
	}

	public LargeList(long size) {
		super(size);
		rangeCellSet = new TreeSet<>();
	}

	@Override
	public long count() {
		return rangeCellSet.stream()
				.mapToLong(rs -> rs.getEndIdx() - rs.getStartIdx() + 1L)
				.sum();
	}

	@Override
	public T get(long idx) {
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public T[] get(long startIdx, long endIdx) {
		Object[] arr = new Object[(int) (endIdx - startIdx) + 1];
		for (int i = 0; i <= endIdx - startIdx; i++) {
			arr[i] = this.get(startIdx + i);
		}
		return (T[]) arr;
	}

	@Override
	public void add(long idx, T value) {
		this.add(idx, idx, value);
	}

	@Override
	public void add(long startIdx, long endIdx, T value) {
		
	}

	@Override
	public void remove(long idx) {
		this.remove(idx, idx);
	}

	@Override
	public void remove(long startIdx, long endIdx) {
		
	}

	public static class RangeCell<T> implements Comparable<RangeCell<T>>{
		private long startIdx;
		private long endIdx;
		private T value;
		
		public RangeCell(long startIdx, long endIdx) {
			this(startIdx, endIdx, null);
		}

		public RangeCell(long startIdx, long endIdx, T value) {
			this.startIdx = startIdx;
			this.endIdx = endIdx;
			this.value = value;
		}

		@Override
		public int hashCode() {
			return 0;
		}

		@SuppressWarnings("unchecked")
		@Override
		public boolean equals(Object obj) {
			if (!(obj instanceof RangeCell)) {
				return false;
			}
			RangeCell<T> rs = (RangeCell<T>) obj;
			return rs.getStartIdx() == this.startIdx && rs.getEndIdx() == this.endIdx;
		}
		
		@Override
		public int compareTo(RangeCell<T> rs) {
			if(rs.getStartIdx() == this.startIdx) {
				return this.startIdx  < rs.getStartIdx() ? 1 : -1;
			}
			return this.endIdx < rs.getEndIdx() ? 1 : -1;
		}
		
		public long getStartIdx() {
			return this.startIdx;
		}

		public long getEndIdx() {
			return this.endIdx;
		}

		public T getValue() {
			return this.value;
		}
	}
}
