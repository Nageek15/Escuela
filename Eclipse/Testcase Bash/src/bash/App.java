package bash;

import gameutil.text.Console;

public class App {
	public static void main(String[] args) {
		Console.s.setVisible(true);
		Console.s.setTheme(Console.theme.shell2);
		boolean running=true;
		
		while (running) {
			Console.s.print("->>");
			String cmd=Console.s.readLine();
			switch (cmd) {
				case "q":
					running=false;
					System.exit(0);
				break;
				
				case "?":
					Console.s.println("Commands: ");
					Console.s.println("  q - quit");
					Console.s.println("  t - new testcase*");
					Console.s.println("  e - end testcase*");
					Console.s.println("  ");
				break;
			}
		}
	}
}
