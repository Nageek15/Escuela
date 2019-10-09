package bash;

import java.util.ArrayList;

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
		ios.remove(index);
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
		value=value+"<end of "+name+">\n";
		return value;
	}
	
	
	
	
}
