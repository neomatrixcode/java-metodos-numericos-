
import java.util.ArrayList; 
import javax.swing.JOptionPane;
import java.math.*;


public class ediferenciate { 

static String sal="";

static double h,resultado=0,evalu=0;
static int pi=0,maxcolum=4;
static double recor=0.2;
static int maxd=7;
static int bt=0,be=0,bem=0;
static double [][]tab = new double [maxd][maxcolum];
static String []tmet = new String [maxcolum];

public static void main(String args[]){ 
  	
  	iniciartabla();
	dattabla1();
	
     
    // taylor();
    euler();
    eulerm();
    
    mostrartabla();
} 
   public static void dattabla1(){
		tab[0][0]=0.0;
		tab[1][0]=0.05;
		tab[2][0]=0.1;
		tab[3][0]=0.15;
		tab[4][0]=0.2;
		tab[5][0]=0.25;
		tab[6][0]=0.3;
	
	}
			public static void iniciartabla(){
		for(int i=0;i<maxd;i++){
			for(int j=0;j<maxcolum;j++){
			tab[i][j]=0.0;
			}
		}
		tmet[0]="     x    ";
	}
	
			public static void mostrartabla(){
				
	

		System.out.printf("            ");
		for(int j=0;j<(be+bem+bt+1);j++){
			System.out.printf("|%s|    ",(tmet[j]) );
		}
		
		System.out.printf("\n");
		
		System.out.printf("          ");
		for(int i=0;i<maxd;i++){
			for(int j=0;j<(be+bem+bt+1);j++){
			
				System.out.printf("  |%3.8f|  ",(tab[i][j]) );
			}
			System.out.print("\n          ");
		}
		
		System.out.print("\n");
	}


			public static void euler(){
			int col =1;
			be=1;
			
			if(bt==1){
		    	col++;
		    }
		    if(bem==1){
		    	col++;
		    }
			
			tmet[col]=" y (euler)";
			h = (tab[1][0])-(tab[0][0]);	
	
			tab[0][col]= 1;
		
			for(int i=1; i<maxd; i++){
			tab[i][col]= eulers(tab[i-1][0],tab[i-1][col]);
			
			}
			
			
			}
			
				public static void eulerm(){
			int col =1;
			bem=1;
			
			if(bt==1){
		    	col++;
		    }
		    if(be==1){
		    	col++;
		    }
			
			tmet[col]="y (eulerm)";
			h = (tab[1][0])-(tab[0][0]);	
	
			tab[0][col]= 1;
		
			for(int i=1; i<maxd; i++){
			tab[i][col]= eulerm(tab[i-1][0],tab[i-1][col]);
			

			}
			
			}
			
		
				
			public static double eulerm(double x,double y ){
				
				
			//	System.out.print("x: "+x+"\n"+"y: "+y+"\n\n"+y(y)+" +(((("+ypd(x,y)+")+("+(x+h)+" + "+(eulers(x,y))+"))/2)*"+h+")\n\n");
		
				return y(y)+((((ypd(x,y))+((x+h)+(eulers(x,y))))/2)*h);
				
			
			}
				
			public static double eulers(double x,double y ){
		
				return y(y)+(ypd(x,y)*h);
			
			}
			
		
		public static void taylor(){
			int col=1;
			bt=1;
			
		    if(be==1){
		    	col++;
		    }
		    if(bem==1){
		    	col++;
		    }
		    
		    tmet[col]="y (Taylor)";
		    
			h = (tab[1][0])-(tab[0][0]);	
	
			tab[0][col]= 1;
		
		for(int i=1; i<maxd; i++){
			tab[i][col]= yx(tab[i-1][0],tab[i-1][col]);
			}
			
		    
		
		}
		
		
		
			public static double yx(double x,double y ){
				
				
				return y(y)+(ypd(x,y)*h)+(((ysd(x,y))/2)*(Math.pow(h,2)))+(((ytd(x,y))/6)*(Math.pow(h,3)));
				
				
			}
	
			public static double y(double n){
				
				if(n==0.0){
					return 1;	
				}
				else{
					return n;	
				}
				
				
			}
			
				public static double ypd(double x,double y){
				
				return x+y(y);
			}
			
				public static double ysd(double x,double y){
				
				return 1+ypd(x,y);
			}
			
			public static double ytd(double x,double y){
				
				return ysd(x,y);
			}


	


}

