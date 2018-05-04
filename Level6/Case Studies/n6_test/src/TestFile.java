import javax.swing.*;
import java.io.File;
public class TestFile extends JFrame {
	
	public  void loadInfo() {
		JFileChooser fc = new JFileChooser("./data");
		fc.setDialogTitle("Open file");
		File testFile = null;
		int result = fc.showOpenDialog(this);
		if (result == JFileChooser.APPROVE_OPTION)
			testFile = fc.getSelectedFile();
		
	}
	
	public static void main(String[] args) {
		//File data = new File ("./data/test.properties");
		JFileChooser fc = new JFileChooser("./data");
		fc.setDialogTitle("Open file");
		File testFile = null;
		int result = fc.showOpenDialog();
		if (result == JFileChooser.APPROVE_OPTION)
			testFile = fc.getSelectedFile();
		
	}
	
}
