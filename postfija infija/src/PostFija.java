import java.util.*;
public class PostFija 	{
	String ora;
	String exp="";
	Pila<Integer> pil=new Pila<>();
	Cola<Integer> col=new Cola<>();
	Map<String,Integer> prio=new HashMap<String,Integer>();
	Map<String,Integer> opera=new HashMap<String,Integer>();
	
	int ans=0;
	
	public PostFija() {
		prio.put("=",new Integer(1) );///0
		prio.put("+",new Integer(2) );///1
		prio.put("-",new Integer(2) );///2
		prio.put("*",new Integer(3) );///3
		prio.put("/",new Integer(3) );///4
		prio.put("^",new Integer(4) );///5

		opera.put("=",new Integer(1) );///0
		opera.put("+",new Integer(2) );///1
		opera.put("-",new Integer(3) );///2
		opera.put("*",new Integer(4) );///3
		opera.put("/",new Integer(5) );///4
		opera.put("^",new Integer(6) );///5
	}
	public void  leer(String h) {
		ora=h;
	}
	
	public void Convertir() {
		int ban=0;
		int sum=0;
		String ltr;
		int yo;
		String comp;
		
		for(int i=0;i<ora.length();i++) {
			ltr= Character.toString( ora.charAt(i) ); 
//System.out.println( ltr+" "+prio.containsValue(ltr) + "\n" );
			
			if( prio.containsKey( ltr ) ) {
				yo=prio.get( ltr  );
				/// reiniciar lo de valor
				if( ban>0 ) {
					col.Insertar(1, Integer.toString(sum) );
					ban=0;
					sum=0;
				}
				while(pil.tot >=1 ) {
					comp=pil.Eliminar();
					if( yo<=prio.get( comp ) )
						col.Insertar(2, comp );
					else {
						pil.Insertar(2,comp);
						break;
					}
				}
				pil.Insertar(2,  ltr );
			}
			else {
				if( ltr.charAt(0)=='y' ) {
					col.Insertar(1,"y" );
					continue;
				}
				
				if( ban>0 )
					sum*=10;
				ban++;
				sum+=(ltr.charAt(0)-'0');
				//System.out.println("->"+sum+"\n");
				}
			
		}
		if( sum>0 )
			col.Insertar(1, Integer.toString( sum )  );
		while( pil.tot>=1 ) {
			col.Insertar(2, pil.Eliminar() );
		}
		
	}
	
	public int Resultado() {
		Nodo  pos=col.ini;
		while( pos!=null ) {
			if( (Integer)pos.tipo==1 )
				pil.Insertar(1,  pos.dato );
			else {
				int izq=0,der=0;
				//System.out.println(pos.dato+"..\n");
				if( prio.get( pos.dato )!=1 ) {					
					izq=Integer.parseInt( pil.Eliminar() );
					der=Integer.parseInt( pil.Eliminar() );
				}
				else {
					System.out.println("y="+pil.Eliminar()+"\n");
					System.exit(0);					
				}
				int res=0;
				switch (pos.dato) {
					case "+":
						res=der+izq;
				System.out.println(der+ "+" +izq+"="+res+"\n");
						break;
					case "-":
						res=der-izq;
				System.out.println(der+ "-" +izq+"="+res+"\n");
						break;
					case "*":
						res=der*izq;
				System.out.println(der+ "*" +izq+"="+res+"\n");
						break;
					case "/":
						res=der/izq;
				System.out.println(der+ "/" +izq+"="+res+"\n");						
						break;	
					case "^":
						res=(int) Math.pow(der, izq);
				System.out.println(der+ "^" +izq+"="+res+"\n");
						break;
					
					default:
				}	
				pil.Insertar(1,  Integer.toString(res)  );
			}
			pos=pos.nxt;
		}
		return ans;
	}
	public String Expresion() {
		exp=col.toString();
		return exp;
	}
}
/// y=5+8/2^3+1-7
/// res=0
/// y=32*25+90/3+2^2*2
/// 867+30+8
