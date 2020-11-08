import javax.swing.JRadioButton;

public class BotonGrupo extends JRadioButton {
	
	public BotonGrupo(int pi,String name){
		setText(name);
		pi--;
		setBounds(10+pi*101,150, 100, 50);
	}
}
