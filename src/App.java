import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class App {

	public static void main(String[] args) {
		//to make apps more robust use a seprate thread to run the app
		SwingUtilities.invokeLater(new Runnable () {
			public void run() {
				MainFrame obj = new MainFrame();
			}
		});	
	}

}
