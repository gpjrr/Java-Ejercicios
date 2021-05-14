import java.util.Arrays; 
import java.util.Random;
import java.util.Scanner; 		
import java.io.*;
public class MapaNumeros{
	int n,m;
	int[][] a=new int[1010][1010];
	int ShortPath=10000000;
	int[][] vis=new int[101][101];
	public void construir(String titulo) throws IOException{
		File f=new File( titulo );
		
		FileReader rf=new FileReader(f);
 		
		BufferedReader br=new BufferedReader( rf );
 		
		//System.out.println(titulo);
		
		String tem=new String();
		
			
		n=Integer.parseInt( br.readLine() );
 		m=Integer.parseInt( br.readLine() );
 		
 		//System.out.println(n+" "+m);
 		
 		
 		for(int i=0;i<n;i++) {
 			tem=br.readLine();
 			
 			for(int j=0;j<m;j++) {
 				if( tem.charAt(j)=='#' )
 					a[i][j]=1;
 				if( tem.charAt(j)=='.' )
 					a[i][j]=2;
 				if( tem.charAt(j)=='B' )
 					a[i][j]=4;
 				if( tem.charAt(j)=='S' )
 					a[i][j]=5;
 				vis[i][j]=1000000;
 			}
 		}
 		/*
 		for(int i=0;i<n;i++) {
 			for(int j=0;j<m;j++) 
 				System.out.print(a[i][j]);
 			System.out.print("\n");
 		}
 		*/
	}
	
	public void CaminoCorto(int pi1,int pj1,int tp){
		if( a[pi1][pj1]==5 ) {

			ShortPath=Math.min(  tp,ShortPath);
			return;
		}
		if( a[pi1][pj1]==1 )
			return;
		if( vis[pi1][pj1]<=tp )
			return;
		vis[pi1][pj1]=tp;
		//System.out.println(pi1+"  "+pj1+" "+tp);
		tp++;
		CaminoCorto(pi1-1,pj1,tp);
		CaminoCorto(pi1+1,pj1,tp);
		CaminoCorto(pi1,pj1-1,tp);
		CaminoCorto(pi1,pj1+1,tp);
			
	}

}
