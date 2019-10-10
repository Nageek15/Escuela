package bash;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Scanner;

import bash.Io.IO;
import gameutil.text.Console;

public class App {
	
	private static Hashtable<Integer,TestCase> testCases;
	private static TestCase current=null;
	private static String[] args;
	
	public static void main(String[] unicornArgs) {
		Console.s.setVisible(true);
		Console.s.setTheme(Console.theme.shell2);
		boolean running=true;
		int noTestCases=0;
		int topIndex=0;
		testCases=new Hashtable<>();
		
		while (running) {
			Console.s.print("->>");
			args=getArgs(Console.s.readLine());
			switch (arg(0)) {
				case "q":
					running=false;
					//quitting is the same as exiting:
					System.exit(0);
				break;
				
				case "e":
					running=false;
					System.exit(0);
				break;
				
				case "?":
					Console.s.println("Commands: ");
					Console.s.println("  ? - print commands");
					Console.s.println("  q - quit");
					Console.s.println("  e - exit");
					Console.s.println("  t <index> <name> - create a new test case or set current test case to an old one. If a name is specified a new test case with that name is made and replaces any test case already existing at specified index; additionaly, if index is unspecifed (e.g. '-') the named test case will be appended.");
					Console.s.println("  i <data> <index> - add a new  input to current test case. Use double quotes to make multiple word data.");
					Console.s.println("  o <data> <index> - add a new output to current test case. Use double quotes to make multiple word data.");
					Console.s.println("  d <index> <io/t> - delete the last input/output or the input/output at specified index of current test case if type is 'io' or unspecified. If type is 't' then the testcase of specified index is deleted; additionaly if index is unspecified (e.g. '-' then the test case at the top index is deleted.");
					Console.s.println("  c - clear window");
					Console.s.println("  p <testcase #> - preview entire file or an individual testcase.");
					Console.s.println("  l - list the test case indexes.");
					Console.s.println("  s <name>- save testcase as a txt file");
				break;
				
				case "t":
				{
					
					int i=topIndex+1;//test case index
					if (!(arg(1).equals(""))) {
						if (!arg(2).equals("")){
							//add a test case at a specified index or edit an existing one with a name
							try {
								i=Integer.parseInt(arg(1));//set index to value of arg 1
							} catch (NumberFormatException e) {
								//if arg 1 is invalid then add the test case as normal (the index above top index)
							}
							
							//Increase no of test cases if testCases does not already contain index
							if (!(testCases.contains(i))) {
								noTestCases++;
							}
							
							//add the test case at specified index
							testCases.put(i,new TestCase(i,arg(2)));
							
						} else {
							//add a test case at a specified index or edit an existing one
							try {
								i=Integer.parseInt(arg(1));//set index to value of arg 1
							} catch (NumberFormatException e) {
								//if arg 1 is invalid then add the test case as normal (the index above top index)
							}
							if (testCases.containsKey(i)){
								//get existent test case later
								
							} else {
								//add the test case at specified index
								testCases.put(i,new TestCase(i));
								noTestCases++;
							}
						}
					} else {
						//add the test case at index above top index
						testCases.put(i,new TestCase(i));
						noTestCases++;
					}
					
					//set current test case and print no of current test case
					current=testCases.get(i);
					Console.s.println("Testcase "+i+":");
					
					
					//Update top index
					if (i>topIndex) {
						topIndex=i;
					}
					
				}
				break;
				
				case "c":
					Console.s.clr();
				break;
				
				case "i":
				{
					String data=arg(1);
					int argNo=1;
					if (data.startsWith("\"")) {
						//take off "
						data=data.substring(1);
						//setup for loop
						String stub=data;
						data="";
						while (!stub.endsWith("\"")) {
							data=data+" "+stub;
							argNo++;
							stub=arg(argNo);
						}
						//add last stub without "
						data=data+" "+stub.substring(0,stub.length()-1);
						//set arg no to next arg to get index
					}
					
					argNo++;
					try {
						//if arg 2 is a valid number add an Io at that index
						current.add(new Io(IO.i,data),Integer.parseInt(arg(argNo)));
					} catch (NumberFormatException e) {
						//otherwise append a new Io
						current.add(new Io(IO.i,data));
					}
				}
				break;
				
				case "o":
				{
					String data=arg(1);
					int argNo=1;
					if (data.startsWith("\"")) {
						//take off "
						data=data.substring(1);
						//setup for loop
						String stub=data;
						data="";
						while (!stub.endsWith("\"")) {
							data=data+" "+stub;
							argNo++;
							stub=arg(argNo);
						}
						//add last stub without "
						data=data+" "+stub.substring(0,stub.length()-1);
						//set arg no to next arg to get index
					}
					argNo++;
					
					try {
						
						//if arg 2 is a valid number add an Io at that index
						current.add(new Io(IO.o,data),Integer.parseInt(arg(argNo)));
					} catch (NumberFormatException e1) {
						//otherwise append a new Io
						current.add(new Io(IO.o,data));
					}
				}
				break;
				
				case "d":
					if (arg(2).equals("t")) { 
						int i=topIndex;
						try {
							//try to parse index from arg 1
							i=Integer.parseInt(arg(1));
						} catch (NumberFormatException e) {
							
						}
						//delete test case
						testCases.remove(i);
						//find top index
						topIndex=0;
						for (int no:testCases.keySet()) {
							if (no>topIndex) {
								topIndex=no;
							}
						}
						
					} else {
						//delete io
						int i=-1;
						try {
							//try to parse index from arg 1
							i=Integer.parseInt(arg(1));
						} catch (NumberFormatException e) {
							
						}
						
						if (i==-1) {
							//delete last io
							current.delete();
						} else {
							current.delete(i);
						}
						
					}
				break;
				
				case "p":
					try {
						int i=Integer.parseInt(arg(1));
						Console.s.println(testCases.get(i).toString());
					} catch (NumberFormatException e) {
						for (int no:testCases.keySet()) {
							Console.s.println(testCases.get(no).toString());
						}
					}
				break;
				
				case "l":
					for (int no:testCases.keySet()) {
						Console.s.println("["+no+"]");
					}
				break;
				
				case "s":
					String fileName="";
					if (arg(1).equals("")) {
						fileName="testcases/testCases.txt";
					} else {
						fileName="testcases/"+arg(1)+".txt";
					}
					
					try {
						BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
						
						String fileText="";
						for (int no:testCases.keySet()) {
							fileText=fileText+"\n"+testCases.get(no).toString();
						}
						
						writer.write(fileText);
						writer.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				     
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
