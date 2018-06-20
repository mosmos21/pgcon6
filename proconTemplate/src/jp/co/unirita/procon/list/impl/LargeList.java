package jp.co.unirita.procon.list.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jp.co.unirita.procon.list.AbstractVirtualList;

public class LargeList<T> extends AbstractVirtualList<T> {
	
	Map<Long, T> cellMap;
	List<RangeCell<T>> rangeCellList;

	public LargeList () {
		this(1000000000000L);
	}
	
	public LargeList(long size) {
		super(size);
		cellMap = new HashMap<>();
		rangeCellList = new ArrayList<>();
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public T get(long idx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T[] get(long startIdx, long endIdx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void set(long idx, T value) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void set(long startIdx, long endIdx, T value) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remove(long idx) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remove(long startIdx, long endIdx) {
		// TODO Auto-generated method stub
		
	}
	
	public static class RangeCell<T> {
		long startIdx;
		long endIdx;
		T value;
		
		public RangeCell(long startIdx, long endIdx, T value) {
			this.startIdx = startIdx;
			this.endIdx = endIdx;
			this.value = value;
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
