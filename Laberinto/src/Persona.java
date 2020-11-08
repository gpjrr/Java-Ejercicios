
public class Persona {
 int pi,pj;
 int si,sj;
 int Pasos=0;
 int[][] bloques=new int[101][101];
 
 	public Persona( MapaNumeros Mapita ) {
 		for(int i=0;i<Mapita.n;i++)
 			for(int j=0;j<Mapita.m;j++){
 				bloques[i][j]=Mapita.a[i][j];
 				if( Mapita.a[i][j]==4 ){
 					pi=i;	pj=j;
 				}
 				if( Mapita.a[i][j]==5 ){
 					si=i; sj=j;
 				}
 			}
 	}
 	public void mover() {
 		
 		//System.out.println(pi+"__"+pj);
 		if( EventoTeclado.Up==true && bloques[pi-1][pj]!=1 ) {
 			pi--;
 			Pasos++;
 		}
 		if( EventoTeclado.Down==true && bloques[pi+1][pj]!=1 ) {
 			pi++;
 			Pasos++;
 		}
 		if( EventoTeclado.left==true && bloques[pi][pj-1]!=1 ) {
 			pj--;
 			Pasos++;
 		}
 		if( EventoTeclado.Right==true && bloques[pi][pj+1]!=1 ) {
 			pj++;
 			Pasos++;
 		}
 		//System.out.println(pi+"--"+pj+"pasos "+ Pasos);
 	}
}
