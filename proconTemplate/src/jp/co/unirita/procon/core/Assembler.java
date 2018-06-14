package jp.co.unirita.procon.core;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import jp.co.unirita.procon.command.Command;
import jp.co.unirita.procon.exception.CommandExecException;
import jp.co.unirita.procon.result.Result;
import jp.co.unirita.procon.result.ResultCode;

public class Assembler {

	private static Assembler assembler = null;

	public static long run(InputStream is) {
		long start = System.currentTimeMillis();
		long end = start;
		if (assembler == null) {
			assembler = new Assembler();
		}
		try {
			end = assembler.eval(assembler.load(is));
		} catch (CommandExecException e) {
			for (Result result : e.getResultList()) {
				Display.printErrorMessage(result.getResultCode(), result.getLine());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return end - start;
	}

	private List<String[]> load(InputStream is) throws CommandExecException, IOException {		
		List<String[]> list = new ArrayList<>();
		State state = State.NONE;

		BufferedReader br = new BufferedReader(new InputStreamReader(is));
		String line = null;
		String[] cmdArr = null;
		int idx = 0;
		while ((line = br.readLine()) != null) {
			idx++;
			line = line.trim();
			if (isBrankOrComment(line)) {
				cmdArr = new String[] { line };
			} else {
				cmdArr = line.split("[\\s]+");
				cmdArr[0] = cmdArr[0].toUpperCase();
				state = getNextState(idx, state, cmdArr[0]);
			}
			list.add(cmdArr);
		}
		br.close();
		
		if (state != State.ED) {
			// TODO EDコマンドが記述されていない
			throw new CommandExecException(new Result(idx, "", ResultCode.PCON_E_999));
		}
		return list;
	}

	private long eval(List<String[]> cmdList) {
		for (int line = 1; line <= cmdList.size(); ++line) {
			String[] cmdArr = cmdList.get(line - 1);
			if (isBrankOrComment(cmdArr[0])) {
				continue;
			}
			String cmd = cmdArr[0];
			String[] args = Arrays.copyOfRange(cmdArr, 1, cmdArr.length);
			try {
				Class<?> clazz = Class.forName("jp.co.unirita.procon.command.impl.Command" + cmd);
				Command command = (Command) clazz.getConstructor(int.class).newInstance(line);
				Result success = command.execute(args);
				Display.printSuccessMessage(success.getLine(), success.getMessage());
			} catch (ClassNotFoundException e) {
				Display.printErrorMessage(ResultCode.PCON_E_999, line);
			} catch (CommandExecException e) {
				for (Result result : e.getResultList()) {
					Display.printErrorMessage(result.getResultCode(), result.getLine(), result.getMessage());
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return System.currentTimeMillis();
	}

	private boolean isBrankOrComment(String line) {
		return line.equals("") || line.startsWith("#");
	}

	private State getNextState(int idx, State state, String command) throws CommandExecException {
		if (state == State.NONE) {
			if (command.equals("ST")) {
				state = State.ST;
			} else {
				// TODO STコマンドより前にコマンドが実行されている
				throw new CommandExecException(new Result(idx, command, ResultCode.PCON_E_999));
			}
		} else if (state == State.ST) {
			state = command.equals("ED") ? State.ED : State.COMMAND;
		} else if (state == State.COMMAND) {
			if (command.equals("ED")) {
				state = State.ED;
			}
		} else if (state == State.ED) {
			// TODO EDコマンドより後にコマンドが実行されている
			throw new CommandExecException(new Result(idx, command, ResultCode.PCON_E_999));
		}
		return state;
	}
}
