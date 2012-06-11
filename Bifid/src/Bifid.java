

import java.util.Random;
import java.util.Scanner;

public class Bifid {
	public static String[] Alfabe={"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","Y","Z","X"};
	public static String[] duzMetin = {"A","Y","S","E"};
	public static String[] sifreliMetin = new String[duzMetin.length];
	public static String[][] anahtar = new String[5][5];
	public static Random random = new Random();
	public static int  index;
	public static int satir;
	public static int sutun;
	public static int Satir[]= new int[duzMetin.length];
	public static int Sutun[]= new int[duzMetin.length];
	public static int toplam[]= new int[duzMetin.length*2];


	
	public static void anahtarUret(){
		System.out.println("anahtar");
		for(int i=0;i<5;i++){
			for(int j=0;j<5;j++){
				int rand=randomUret();
					anahtar[i][j] = Alfabe[rand];
					Alfabe[rand] = "*";							
				System.out.print("      "+anahtar[i][j]);
			}
			System.out.println("");
		}				
	}
	public static int randomUret(){
		index=random.nextInt(25);
		if(Alfabe[index]=="*"){
			randomUret();
		}
		return index;
		
	}
	public static void sifrele(){
		int sayac = 0;
		for(int k=0;k<duzMetin.length;k++){	
		  for(int i=0;i<5;i++){
			for(int j=0;j<5;j++){				
					if(anahtar[i][j]==duzMetin[k]){
						Satir[sayac]=i;
						Sutun[sayac]=j;
						sayac++;						
						
					}
					
				}
			
			}
		}
		System.out.println("Satir");
		for(int i=0;i<Satir.length;i++){
			System.out.println(Satir[i]);		
		}
		System.out.println("Sutun");
		for(int i=0;i<Sutun.length;i++){
			System.out.println(Sutun[i]);		
		}
		
		for(int i=0;i<Satir.length;i++){
			toplam[i]=Satir[i];			
		}
		int k=0;
		for(int j=Satir.length;j<toplam.length;j++){
				toplam[j]=Sutun[k];	
				k++;
				
		}
		System.out.println("Toplam dizi");
		for(int i=0;i<toplam.length;i++){
			System.out.println(toplam[i]);		
		}
		
		System.out.println("sifreli metin");
		int m=0;
		for(int i=0;i<toplam.length;i=i+2){
			int x=toplam[i];
			int y=toplam[i+1];
			sifreliMetin[m]=anahtar[x][y];
			m++;
			System.out.println(anahtar[x][y]);
			
		}
		
	}
	public static void desifreleme(String[] sifreliMetin1){
		int sayac = 0;
		for(int k=0;k<sifreliMetin1.length;k++){	
		  for(int i=0;i<5;i++){
			for(int j=0;j<5;j++){				
					if(anahtar[i][j]==sifreliMetin1[k]){
						toplam[sayac]=i;
						sayac++;
						toplam[sayac]=j;
						sayac++;
					}
					
				}
		    }
		}
		
		System.out.println("Desifreleme");
		for(int i=0;i<Satir.length;i++){
			Satir[i]=toplam[i];			
		}
		System.out.println("Satir");
		for(int i=0;i<Satir.length;i++){
			System.out.println(Satir[i]);		
		}
		
        int k=0; 
		for(int j=Satir.length;j<toplam.length;j++){
			Sutun[k]=toplam[j];	
				k++;				
		}
		System.out.println("Sutun");
		for(int i=0;i<Sutun.length;i++){
			System.out.println(Sutun[i]);		
		}
		int index=0;
		System.out.println("Duz metin");
		int a=0;
		for(int i=0;i<Satir.length;i++){
				int x=Satir[a];
				int y=Sutun[a];
				System.out.println(anahtar[x][y]);
				a++;
					
			
		}
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub      
		anahtarUret();
		sifrele();
		desifreleme(sifreliMetin);

	}

}
