package bash;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Scanner;

import gameutil.text.Console;

public class App {
	
	private static Hashtable<Integer,TestCase> testCases;
	private static String[] args;
	
	public static void main(String[] unicornArgs) {
		Console.s.setVisible(true);
		Console.s.setTheme(Console.theme.shell2);
		boolean running=true;
		int noTestCases=0;
		testCases=new Hashtable<>();
		
		while (running) {
			Console.s.print("->>");
			args=getArgs(Console.s.readLine());
			switch (arg(0)) {
				case "q":
					running=false;
					System.exit(0);
				break;
				
				case "?":
					Console.s.println("Commands: ");
					Console.s.println("  q - quit");
					Console.s.println("  t <name> <index> - create a new test case or set current test case to an old one*");
					Console.s.println("  i <data> <index> - add a new  index to current test case*");
					Console.s.println("  o <data> <index> - add a new output to current test case*");
					Console.s.println("  d <index> - deletes the last input/output or the input/output at specified index of current test case*");
					Console.s.println("  c - clear window");
					Console.s.println("  p <testcase #> - preview entire file or an individual testcase*");
					Console.s.println("  ");
				break;
				
				case "t":
					noTestCases++;
					Console.s.println("Tescase "+noTestCases+":");
					if (!(arg(1).equals(""))) {
						
					} else {
						
					}
				break;
				
				case "c":
					Console.s.clr();
				break;
				
			}
			
		}
		
		for (String s:args) {
			Console.s.println(s);
		}
	}
	
	private static void addTestCase(int no) {
		testCases.put(no,new TestCase(no));
	}
	
	/**Arg 0 is command
	 * 
	 * The rest are the other args
	 * 
	 * @param cmd
	 * @return args
	 */
	private static String[] getArgs(String cmd) {
		//initialize variables
		String[] args;
		ArrayList<String> argList=new ArrayList<>();
		//this stub represents the unscanned part of the string.
		String cmdStub=cmd;
		
		//Scan the cmd string for args
		while (cmdStub.contains(" ")) {
			//get index of next space
			int spaceIndex=cmdStub.indexOf(" ");
			//parse arg
			argList.add(cmdStub.substring(0, spaceIndex));
			//skip spaceIndex
			cmdStub=cmdStub.substring(spaceIndex+1);
		}
		
		//add last arg
		argList.add(cmdStub);
		
		//initialize args array to be size of list
		args=new String[argList.size()];
		
		//put args from list into array
		int i=0;
		for (String s:argList) {
			args[i]=s;
			i++;
		}
		
		return args;
		
	}
	
	private static String arg(int index) {
		try {
			return args[index];
		} catch (NullPointerException e) {
			System.out.println("Nothing isn't where it's supposed to be...");
		} catch (IndexOutOfBoundsException e) {
			
		}
		
		return "";
	}
	
}
