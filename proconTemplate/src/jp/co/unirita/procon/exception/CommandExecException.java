package jp.co.unirita.procon.exception;

import java.util.Arrays;
import java.util.List;

import jp.co.unirita.procon.result.Result;

public class CommandExecException extends Exception {

	private static final long serialVersionUID = 1L;
	List<Result> resultList;

	public CommandExecException(List<Result> list) {
		super();
		this.resultList = list;
	}

	public CommandExecException(Result result) {
		this(Arrays.asList(result));
	}

	public List<Result> getResultList() {
		return this.resultList;
	}
}
