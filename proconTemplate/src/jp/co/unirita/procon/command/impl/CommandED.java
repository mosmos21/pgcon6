package jp.co.unirita.procon.command.impl;

import jp.co.unirita.procon.command.AbstractCommand;
import jp.co.unirita.procon.result.Result;

public class CommandED extends AbstractCommand {
	
	public CommandED(int line, String[] args) {
		super(line, args);
	}

	@Override
	protected String getCommandName() {
		return "ED";
	}

	@Override
	protected void check(String[] args){
		// 引数0なので特にチェックなし
	}

	@Override
	protected Result eval(String[] args){
		return super.success("EDコマンドを実行しました");
	}

}
