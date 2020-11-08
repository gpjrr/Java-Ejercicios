
public class Cola {
	Arista arr[]=new Arista[1010];
	int tot;
	
	public void Cambiar(int p1,int p2) {
		Arista tem=arr[p1];
		arr[p1]=arr[p2];
		arr[p2]=tem;
	}
	
	public Cola(int er) {
		tot=0;
		for(int i=1;i<=er;i++)
			arr[i]=new Arista(0,0,0);
	}
	
	public void Insertar( Arista nuevo  ) {
		arr[ ++tot ]=nuevo;
		int pos=tot/2;
		int ant=tot;
		while( pos>=1 ) {
			if( arr[ant].Dis<arr[pos].Dis ) {
				Cambiar( ant,pos );
				ant/=2;
				pos/=2;
			}
			else
				break;
		}
		
	}

	public Arista Ver() {
		return arr[1];
	}
	
	public void Eliminar(  ) {
		arr[1]=arr[ tot ];
		arr[tot--]=new Arista(0,0,0);
		int pos=1;
		while( pos*2<=tot ){
			int v1=arr[pos*2].Dis;
			if( pos*2+1<=tot )
				v1=Math.min( v1 , arr[pos*2+1].Dis );
			
			if( arr[pos].Dis>v1 ) {
				if( v1==arr[pos*2].Dis ) {
					Cambiar( pos*2,pos );
					pos*=2;
				}
				else {
					Cambiar( pos*2+1,pos );
					pos=pos*2+1;
				}
			}
			else
				break;
		}
		
	}
	
	public String tostring() {
		String Wrd="";
		for(int i=1;i<=tot;i++)
			Wrd+=arr[i].Dis+" ";
		return Wrd;
	}
}
