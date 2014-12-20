import  javax.swing.JOptionPane;
public class Multipli {
	
	   int grado,ban=-1,gradoa;
	   String sal="";
	   double solucion[];
	   double vector[];

	Multipli(double v []){
	vector=v;
	grado = vector.length+1;
	gradoa=grado-1;
	solucion=new double [grado];
	double tem[]=new double [grado];
	
	    solucion[0]=1.0;
	   for(int i=1;i<=(gradoa);i++){
	for(int o=0;o<solucion.length;o++){
	   	tem[o]=solucion[o];}
	   ban++;
	   	for(int j=1;j<=(gradoa);j++){	   	
	   	solucion[j]+=(tem[j-1]*vector[ban]);		   
	   	} }
	
	}

    public void funcion(){
     
     	sal="";
   		  for(int i=0;i<solucion.length;i++){
   		  		if(i>0){
				sal+="+ ";	
				}
   		  	    if(gradoa==1){
   		  	    sal+=solucion[i]+" x " ;	
   		  	    }
   		  	    
   		  	    if(gradoa==0){
   		  	    sal+=solucion[i]+"" ;	
   		  	    }
   		  	    if(gradoa>=2){
   		  	    sal+=solucion[i]+" x^"+gradoa+" " ;	
   		  	    }
				
				
				gradoa--;
			}
  		System.out.print(sal);	
     
    
     }
     
     public void funciong(){
     
     	sal="";
   		  for(int i=0;i<solucion.length;i++){
   		  		if(i>0){
				sal+="+ ";	
				}
   		  	    if(gradoa==1){
   		  	    sal+=solucion[i]+" x " ;	
   		  	    }
   		  	    
   		  	    if(gradoa==0){
   		  	    sal+=solucion[i]+"" ;	
   		  	    }
   		  	    if(gradoa>=2){
   		  	    sal+=solucion[i]+" x^"+gradoa+" " ;	
   		  	    }
				
				
				gradoa--;
			}
  		//System.out.print(s);	
     	JOptionPane.showMessageDialog(null,sal, "FUNCION",JOptionPane.ERROR_MESSAGE);
    
     }
     
      public double [] fvector(){
      return  solucion;
      }
        
}