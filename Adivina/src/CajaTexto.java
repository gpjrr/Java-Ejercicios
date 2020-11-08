import javax.swing.JTextField;

public class CajaTexto extends JTextField{
	String Palabra;
	public CajaTexto(int x1,int y1,String ans) {
		setText(ans);
		setBounds(x1,y1,200,30);
	}
	public String Check(){
		Palabra=this.getText();
		return Palabra;
	}
}
