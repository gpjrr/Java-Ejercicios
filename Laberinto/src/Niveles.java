import javax.swing.JRadioButton;

public class Niveles extends JRadioButton {
	
	public Niveles(int pi){
		String t1;
		t1="nivel ";
		t1+=(pi);
		setText(t1);
		setBounds(150 +pi*101, 200, 100, 50);
	}
}
