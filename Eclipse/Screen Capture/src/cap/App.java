package cap;

import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.jcodec.api.awt.AWTSequenceEncoder;

import gameutil.text.Console;

public class App {
	
	public static void main(String[] args) {
		
		Robot r=null;
		try {
			r=new Robot();
		} catch (AWTException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		Console.s.print("Record time (minutes):");
		int recordTime=Console.s.readLineInt();
		
		Console.s.print("Countdown time (seconds):");
		int countdown=Console.s.readLineInt();
		for (int i=0;i<countdown;i++) {
			int count=countdown-i;
			Console.s.println(count);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		Console.s.println("Recording...");
		
		ArrayList<BufferedImage> frames=new ArrayList<>();
		boolean recording=true;
		
		/*long framesPassed=0;
		long totalFps=0;
		*/
		long startTime=System.currentTimeMillis();
		//long lastFrameTime=startTime;
		
		Console.s.print("Video Name:");
		String name=Console.s.read();
		File vid=new File("vidOut/"+name+".mp4").getAbsoluteFile();
		AWTSequenceEncoder encoder=null;
		try {
			/*AWTSequenceEncoder*/ encoder = AWTSequenceEncoder.createSequenceEncoder(vid,30);
			/*for (BufferedImage i:frames) {
				// Encode the image
				encoder.encodeImage(i);
			}*/
			// Finalize the encoding, i.e. clear the buffers, write the header, etc.
			//encoder.finish(); //does't work...
		} catch (IOException e) {
			Console.s.println("ERROR > > IOException");
		}
		
		while(recording) {
			//frames.add(r.createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize())));
			BufferedImage i=r.createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
			try {
				Thread.sleep(30);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			try {
				// Encode the image
				encoder.encodeImage(i);
				// Finalize the encoding, i.e. clear the buffers, write the header, etc.
				//encoder.finish(); //does't work...
			} catch (IOException e) {
				Console.s.println("ERROR > > IOException");
			}
			
			if (System.currentTimeMillis()>startTime+recordTime*60000) {
				//record time is over
				recording=false;
			}
			
			/*framesPassed++;
			totalFps+=System.currentTimeMillis()-lastFrameTime;
			lastFrameTime=System.currentTimeMillis();*/
		}
		//int avgFPS=(int) (totalFps/framesPassed);
		
		
		
		
		
	}
}
