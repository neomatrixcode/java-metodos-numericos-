import java.util.ArrayList; 
import javax.swing.JOptionPane;
import java.math.*;

public class bisposnew { 
	public static void main(String args[]){ 
  
    // falsa();
    // bis();
    newton();
    
} 

public static void falsa(){
	double  a = Float.parseFloat(JOptionPane.showInputDialog("Introduzca el limite inferior"));
    double  c = Float.parseFloat(JOptionPane.showInputDialog("Introduzca el limite superior"));
    int il = Integer.parseInt(JOptionPane.showInputDialog("Introduzca el limite de iteraciones"));
   	double ep = Float.parseFloat(JOptionPane.showInputDialog("Introduzca el limite de error"));
    	int it=0;
    	int kr=0;
    	int kl=0;
    	
    double b=a+10;	
    double ya = f(a);
    double yc = f(c);

     
    if((ya*yc)<=0){
    	
    	while((it<il)||((b-a)>ep)){
    	b= a-(((c-a)/((f(c))-(f(a))))*(f(a)));	
    		
    	double yb= f(b);
    	if(((ya)*(yb))<=0){
    	a=a;
    	c=b;
    	ya=ya;
    	yc=yb;
    	kr=0;
    	kl=kl+1;
    
    	if (kl>1){
    		ya=(ya/2);
    	}
    	}
    	if(((ya)*(yb))>0){
    	a=b;
    	c=c;
    	ya=yb;
    	yc=yc;
    	kr++;
    	kl=0;
    	if (kr>1){
    		yc=(yc/2);
    	}
    	}
    	
    	it++;
    	
    	}
    
    	JOptionPane.showMessageDialog(null,"la raiz esta en: "+b,"FUNCION",JOptionPane.ERROR_MESSAGE);	
    	
    	
    }
    if((ya*yc)>0){
    		JOptionPane.showMessageDialog(null,"en el intervalo de: "+a+"a "+b+"no existen raices o existe un par de raices","FUNCION",JOptionPane.ERROR_MESSAGE);
    }
    
}


public static void bis(){
	double  a = Float.parseFloat(JOptionPane.showInputDialog("Introduzca el limite inferior"));
    double  c = Float.parseFloat(JOptionPane.showInputDialog("Introduzca el limite superior"));
   
   	double er = Float.parseFloat(JOptionPane.showInputDialog("Introduzca el limite de error"));
   	a=a+0.000000000000001;
   	double ya= f(a);
   	double yc= f(c);
   	double xm=0.0;
   	//int nt = Integer.parseInt(JOptionPane.showInputDialog("Introduzca el limite de iteraciones"));
   	int nt;
   	int n=0;
   	

   	 nt=(int)((Math.log((((c-a)/er))))/(Math.log(2)))+1;
   	// nt=20;
 
   	
   		//JOptionPane.showMessageDialog(null,nt,"FUNCION",JOptionPane.ERROR_MESSAGE);
   	
   	
   	
   	if((ya*yc)<=0){
	while (n<nt){
   	 xm=((a+c)/2);
   	if(((f(a))*(f(xm)))<=0){
    c=xm;
    yc=f(c);
   	}
  	if(((f(a))*(f(xm)))>0){
    a=xm;
    ya=f(a);
   	}	
   	
   	n++;
	
   	}
    	JOptionPane.showMessageDialog(null,"la raiz esta en: "+xm,"FUNCION",JOptionPane.ERROR_MESSAGE);
   
}
	if((ya*yc)>0){
		if(n>1){
		JOptionPane.showMessageDialog(null,"la raiz esta en: "+xm,"FUNCION",JOptionPane.ERROR_MESSAGE);
		}
	JOptionPane.showMessageDialog(null,"no existe una raiz en este intervalo","FUNCION",JOptionPane.ERROR_MESSAGE);	
	}



}


public static void newton(){
	
	double  x = Float.parseFloat(JOptionPane.showInputDialog("Introduzca el valor de x a evaluar"));
    double  tol = Float.parseFloat(JOptionPane.showInputDialog("Introduzca la tolerancia"));
    double e=1;
    
    while (e>= tol){
    	
    	double tm=x;
    	x=x-((f(x))/(fd(x)));
    	
    	e= Math.abs((x-tm)/x);
    }
	
	JOptionPane.showMessageDialog(null,"la raiz esta en: "+x,"FUNCION",JOptionPane.ERROR_MESSAGE);
	
}

public static double fd(double x){
	 double s=3*(Math.exp(3*x));
	 //double s=((85*(((75*x)/(Math.pow((x+1),76)))+(Math.pow((x+1),-75))-1))/(x*x));
	 	 return s;
}



public static double  f(double x){
	//double s=((108*((1-(Math.pow((1+x),(-48))))/x))-3799);
	//double s=((85*((1-(Math.pow((1+x),(-75))))/x))-3939);
	 double s=(Math.exp(3*x))-10;
	// double s=((216*((1-(Math.pow((1+x),(-24))))/x))-3799);
	//double s=(Math.sin(x/2))-(Math.sin(2*x));	
	 return s;
    
}



}

