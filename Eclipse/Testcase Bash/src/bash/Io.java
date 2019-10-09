package bash;

import java.util.Hashtable;

public class Io {
	
	//Static properties
	
	public static enum IO {i,o};
	private static final Hashtable<IO,String> TYPE=new Hashtable<>();
	private static final init INIT=new init();
	
	//Local properties
	public final IO type;
	private String value;
	
	public Io(IO type,String value) {
		this.type=type;
		this.value=value;
	}
	
	@Override
	public String toString() {
		return TYPE.get(type)+value+"\n";
	}
	
	private static class init {
		/**Called when class initializes
		 * 
		 */
		public init() {
			TYPE.put(IO.i, "i:");
			TYPE.put(IO.o,"o:");
		}
	}
	
}
