package jp.co.unirita.procon.core;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import jp.co.unirita.procon.command.Command;
import jp.co.unirita.procon.command.impl.CommandST;
import jp.co.unirita.procon.exception.CommandExecException;

public class Assembler {

	private static Assembler assembler = null;

	public static long run(InputStream is) {
		long start = System.currentTimeMillis();
		long end = start - 1;
		if (assembler == null) {
			assembler = new Assembler();
		}
		try {
			end = assembler.evalAll(assembler.load(is));
		} catch (CommandExecException e) {
			Display.printResult(e.getResult());
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return end - start;
	}

	private Assembler() {
	}

	private List<CmdRow> load(InputStream is) throws CommandExecException, IOException, Exception {
		List<CmdRow> list = new ArrayList<>();

		BufferedReader br = new BufferedReader(new InputStreamReader(is));
		String line = null;
		String[] cmdArr = null;
		int row = 0;
		while ((line = br.readLine()) != null) {
			++row;
			line = line.trim();
			if (isBrankOrComment(line)) {
				cmdArr = new String[] { line };
			} else {
				cmdArr = line.split("[\\s]+");
				cmdArr[0] = cmdArr[0].toUpperCase();
			}
			if (cmdArr[0].equals("ST")) {
				eval(row, cmdArr);
			} else {
				list.add(new CmdRow(row, cmdArr));
			}
		}
		br.close();
		return list;
	}

	private long evalAll(List<CmdRow> cmdRowList) {
		for (CmdRow cmdRow : cmdRowList) {
			String[] cmdArr = cmdRow.getCmdArr();
			if (isBrankOrComment(cmdArr[0])) {
				continue;
			}
			try {
				Result result = eval(cmdRow.getRow(), cmdArr);
				Display.printResult(result);
			} catch (CommandExecException e) {
				Display.printResult(e.getResult());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return System.currentTimeMillis();
	}

	private Result eval(int row, String[] cmdArr) throws ClassNotFoundException, CommandExecException, Exception {
		String cmd = cmdArr[0];
		String[] args = Arrays.copyOfRange(cmdArr, 1, cmdArr.length);

		Class<?> clazz = Class.forName("jp.co.unirita.procon.command.impl.Command" + cmd);
		Command command = (Command) clazz.getConstructor(int.class).newInstance(row + 1);
		return command.execute(args);
	}

	private boolean isBrankOrComment(String line) {
		return line.equals("") || line.startsWith("#");
	}

	public static class CmdRow {
		int row;
		String[] cmdArr;

		public CmdRow(int row, String[] cmdArr) {
			this.row = row;
			this.cmdArr = cmdArr;
		}

		public int getRow() {
			return this.row;
		}

		public String[] getCmdArr() {
			return this.cmdArr;
		}
	}
}
