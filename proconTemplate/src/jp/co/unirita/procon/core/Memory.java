package jp.co.unirita.procon.core;

import java.util.Arrays;

public class Memory {
	
	private static Memory memory = null;
	
	public final static int UNDEFINED = -1;
	
	private int maxDigit = 0;
	private int maxSize;
	private int[] arr;
	
	
	public static Memory getInstance() {
		if(memory == null) {
			memory = new Memory();
		}
		return memory;
	}
	
	private Memory() {
	}
	
	public int getMaxDigit() {
		return this.maxDigit;
	}
	
	public int getMaxSize() {
		return this.maxSize;
	}
	
	public void init(int max) {
		this.maxDigit = max;
		this.maxSize = (int)Math.pow(10, max);
		this.arr = new int[maxSize];
		Arrays.fill(arr, UNDEFINED);
	}
	
	
	public void setValue(int idx, int value) {
		this.arr[idx] = value;
	}
	
	public void resetValue(int idx) {
		this.arr[idx] = UNDEFINED;
	}
	
	public void resetValue(int start, int end) {
		this.resetValue(start, end, UNDEFINED);
	}
	
	public void resetValue(int start, int end, int value) {
		for(int i = start; i <= end; i++) {
			this.arr[i] = value; 
		}
	}
	
	public String getValue(int idx) {
		return this.arr[idx] == UNDEFINED ? "--" : String.format("%02d", this.arr[idx]);
	}
	
	public int[] getValues(int start, int end) {
		end = Math.min(start + 19, end);
		return Arrays.copyOfRange(this.arr, start, end + 1);
	}
	
	public int countValueIsNotUndefined() {
		int sum = 0;
		for(int i : this.arr) {
			if(i != UNDEFINED) {
				sum ++;
			}
		}
		return sum;
	}
}
