package bash;

import java.util.ArrayList;

import gameutil.text.Console;

public class TestCase {
	
	public final int no;
	private ArrayList<Io> ios;
	private String name;
	
	
	public TestCase(int no) {
		this.no=no;
		ios=new ArrayList<>();
		name="//Test Case "+no+":";
	}
	
	public TestCase(int no,String name) {
		this.no=no;
		ios=new ArrayList<>();
		this.name="//Test Case "+no+" - "+name+":";
	}
	
	public void add(Io io) {
		ios.add(io);
	}
	
	public void add(Io io,int index) {
		ios.add(index, io);;
	}
	
	public void delete(int index) {
		try {
			ios.remove(index);
		} catch (Exception e) {
			Console.s.println("No io to delete.");
		}
	}
	
	public void delete() {
		delete(ios.size()-1);
	}
	
	public String editingString() {
		String value=name+"\n";
		int i=0;
		for (Io io:ios) {
			value=value+i+"|"+io.toString();
		}
		value=value+"<end of "+name+">\n";
		return value;
	}
	
	@Override
	public String toString() {
		String value=name+"\n";
		for (Io io:ios) {
			value=value+io.toString();
		}
		value=value+"<--end-->\n";
		return value;
	}
	
	
	
	
}
