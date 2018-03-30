package in.geektrust.lengaburu.traffic.utils;

import java.io.PrintStream;

/**
 * Useful for testing and changing output stream
 * 
 * @author arka
 *
 */
public class OutputMessageGenerator {

	private PrintStream printStream;
	private Object[] args;
	private String format;

	public OutputMessageGenerator(PrintStream outputStream) {
		printStream = outputStream;
	}

	public void setFormatter(String format, Object args[]) {
		this.args = args;
		this.format = format;
	}

	public void print(){
		printStream.format(format, args);
	}
	
	public String getFormattedOutputString(){
		return String.format(format, args);
	}
	
	public Object[] getArgs() {
		return args;
	}

	public String getFormat() {
		return format;
	}
}
