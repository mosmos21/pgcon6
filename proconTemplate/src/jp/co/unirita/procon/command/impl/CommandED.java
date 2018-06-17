package jp.co.unirita.procon.command.impl;

import jp.co.unirita.procon.command.AbstractCommand;
import jp.co.unirita.procon.result.Result;

public class CommandED extends AbstractCommand {
	
	public CommandED(int line, String[] args) {
		super(line, args);
	}

	@Override
	public String getCommandName() {
		return "ED";
	}

	@Override
	public void check(String[] args){
		// 引数0なので特にチェックなし
	}

	@Override
	public Result eval(String[] args){
		return super.success("EDコマンドを実行しました");
	}

}
