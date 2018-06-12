package jp.co.unirita.procon.exception;

import java.util.List;

import jp.co.unirita.procon.result.Result;

public class AssebleException extends Exception {
	
	private static final long serialVersionUID = 1L;
	List<Result> resultList;
	
	public AssebleException(List<Result> list) {
		super();
		this.resultList = list;
	}
	
	public List<Result> getResultList() {
		return this.resultList;
	}
}
