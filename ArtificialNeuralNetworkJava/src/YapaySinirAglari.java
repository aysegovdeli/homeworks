
import java.util.Random;
import java.util.Scanner;


public class YapaySinirAglari {
    
    public static int katman;
    public static int giris;
    public static int cikis;
    public static double beklenenDeger;
    public static double biasGiris[];
    public static double biasAra[];
    public static double netAraCikti; 
    public static double araHataMiktari[];
    public static double girisHataMiktari[];
    public static double toplamHata;
    public static double hataDizisi[];
    public static double esikDegeri;
    public static double ogrenmeKatsayisi;
    public static double momentumKatsayisi;
    public static double araCiktiDizisi[];
    public static double sonucCiktiDizisi[];
    public static double girdiDizisi[];
    public static double girisAgirlik[][];
    public static double araAgirlik[][];
    public static double araNet[];
    public static double araAgirlikDegisimMiktari[][];
    public static double girisDegisim[];
    public static double girisAgirlikDegisimMiktari[][];
    public static double girisBiasDegisim[];
    public static double araBiasDegisim[];
    
    
    public static double net(double array[], double matris[][],  int j){
	double net=0.0;
	for(int i=0;i<giris;i++){
            net+=array[i]*matris[i][j];
	}
	return net+biasAra[j];
    }
    
    public static double fNet(double net){
	return 1.0/(1+(Math.pow((Math.E),(-net))));
    }
    
    public static double[][] agirlikHesaplama(double agirlik[][],int satir,int sutun ){
    	 
    	Random w=new Random();
   // 	agirlik=new double[satir][sutun];
    	System.out.println("\nAgirlik Tablosu ");
        for(int i=0; i<satir; i++){
            for(int j=0; j<sutun; j++){
                 agirlik[i][j]=w.nextDouble();
                 System.out.print("      "+agirlik[i][j]);
            }
            System.out.println("");
        }
		return agirlik;
	
    }
    public static void hataHesaplama(double dizi[]){
    	
    	for(int i=0;i<dizi.length;i++){
    		hataDizisi[i]=0-dizi[i];
    	}
    	for(int j=0;j<hataDizisi.length;j++){
    		toplamHata=hataDizisi[j]*hataDizisi[j];
    		
    	}
    	toplamHata=Math.sqrt(toplamHata);
    	
    	
    }
    public static void degerGirme(){
    	
    	Scanner keyboard=new Scanner(System.in);
        System.out.print("Girdi sayisini giriniz: ");
        giris=keyboard.nextInt();
        System.out.print("Ara katman sayisini giriniz: ");
        katman=keyboard.nextInt();
        System.out.print("Cikis sayisini giriniz: ");
        cikis=keyboard.nextInt();
        System.out.print("Beklenen Degeri Giriniz: ");
        beklenenDeger=keyboard.nextDouble();
        System.out.print("Eşik Degerini Giriniz: ");
        esikDegeri=keyboard.nextDouble();
        System.out.println("");
        System.out.print("Ögrenme katsayisini giriniz: ");
        ogrenmeKatsayisi=keyboard.nextDouble();
        System.out.println(" ");
        System.out.print("Momentum katsayisini giriniz: ");
        momentumKatsayisi=keyboard.nextDouble();
        System.out.println("");
   
        girdiDizisi=new double[giris];
        araCiktiDizisi=new double[katman];
        sonucCiktiDizisi=new double[cikis];
        girisAgirlik=new double[giris][katman];
        araAgirlik=new double[katman][cikis];
        biasGiris=new double[katman];
        girisBiasDegisim=new double[katman];
        biasAra=new double[cikis];
        araBiasDegisim=new double[cikis];
        araNet=new double[katman];
        hataDizisi=new double[cikis];
        araHataMiktari=new double[cikis];
        girisHataMiktari=new double[katman];
        girisAgirlikDegisimMiktari=new double[giris][katman];
        araAgirlikDegisimMiktari=new double[katman][cikis];
    	
        
        
        Random b=new Random();
        for(int i=0;i<katman;i++){
        	biasGiris[i]=b.nextDouble();        	
        }
        for(int i=0;i<katman;i++){
        	biasAra[i]=b.nextDouble();        	
        }
        for(int i=0; i<giris; i++){
            System.out.print(i+1+". girdi: ");
            girdiDizisi[i]=keyboard.nextInt();
        }
        agirlikHesaplama(girisAgirlik,giris,katman);
        agirlikHesaplama(araAgirlik,katman,cikis);
        System.out.println("");
        
    	ileriyeDogruHesaplama();
    	
    }   
    public static void ileriyeDogruHesaplama(){
 
        System.out.println("");
        for(int i=0; i<katman; i++){
        	araCiktiDizisi[i]=fNet(net(girdiDizisi,girisAgirlik,i));
            System.out.println("F(NET"+(i+1)+") = "+araCiktiDizisi[i]);
        }
        
        if(araCiktiDizisi.length==1)
            netAraCikti=1-araCiktiDizisi[0];
        else{
        	for(int i=0;i<cikis;i++){
        		sonucCiktiDizisi[i]=fNet(net(araCiktiDizisi,araAgirlik,i));
                System.out.println("F(NET"+(i+1)+") = "+sonucCiktiDizisi[i]);
        	}
        }
        
        hataHesaplama(sonucCiktiDizisi);
     
    }
    public static void geriyeDogruHesaplama(double cikanSonucD[] , double cikanHata){
    	    	 
         for(int i=0;i<cikanSonucD.length;i++){
        	 araHataMiktari[i]= cikanSonucD[i]*(1-cikanSonucD[i])*cikanHata;
         }
         
         cikisHataDegisimi();
         girisHataDegisimi();

    }   
    public static void cikisHataDegisimi(){
    	   	
    	for(int i=0;i<katman;i++){
    		for(int j=0;j<cikis;j++){
    			araAgirlikDegisimMiktari[j][i]=ogrenmeKatsayisi * araHataMiktari[j] * araCiktiDizisi[i] + momentumKatsayisi*araAgirlikDegisimMiktari[j][i]; 
    			
    		}
       
    	}    	
    	for(int i=0;i<katman;i++){
    		for(int j=0;j<cikis;j++){
    			
    		araAgirlik[i][j]=araAgirlik[i][j]+araAgirlikDegisimMiktari[i][j];
		
    		}   		
    	}
    	System.out.println("Ara Agirlik Tablosu Güncel Hali:");   	
    	for(int i=0; i<katman; i++){
            for(int j=0; j<cikis; j++){                 
                 System.out.print("      "+araAgirlik[i][j]);
            }
            System.out.println("");
        }
    	for(int i=0;i<biasAra.length;i++){
    		araBiasDegisim[i]=ogrenmeKatsayisi * araHataMiktari[i] + momentumKatsayisi* araBiasDegisim[i];
    		
    	}
    	for(int i=0;i<biasAra.length;i++){
    		biasAra[i]=biasAra[i]+araBiasDegisim[i];
 		
    	}
    	System.out.println("Ara Bias Degeri Tablosu Güncel Hali:");   	
    	for(int i=0; i<araBiasDegisim.length; i++){                        
                 System.out.print("      "+biasAra[i]);

        }
    	System.out.println(" ");
    	   	
    }
    public static double toplamHesapla(int i){
    	
    	double toplam = 0;   	
    		for(int j=0;j<cikis;j++){
    		toplam+=araHataMiktari[j] * araAgirlik[i][j];
    			
    		}   		
 
   	return toplam;
  	
    }    
    public static void girisHataDegisimi(){
    		
        for(int i=0;i<katman;i++){
             girisHataMiktari[i]=araCiktiDizisi[i] * (1-araCiktiDizisi[i]) * toplamHesapla(i);
 	
        }    
    	for(int i=0;i<giris;i++){
    		for(int j=0;j<katman;i++){
    			girisAgirlikDegisimMiktari[i][j] = ogrenmeKatsayisi * girisHataMiktari[j] * girdiDizisi[i] + momentumKatsayisi * girisAgirlikDegisimMiktari[i][j];
  			
    		}
    	}
    	for(int i=0;i<giris;i++){
    		for(int j=0;j<katman;i++){
    			girisAgirlik[i][j]=girisAgirlik[i][j]+girisAgirlikDegisimMiktari[i][j];
    		}
    	}
    	System.out.println("Giris Agirlik Tablosu Güncel Hali:");
        for(int i=0; i<giris; i++){
            for(int j=0; j<katman; j++){
                 
                 System.out.print("      "+girisAgirlik[i][j]);
            }
            System.out.println("");
        }
        for(int i=0;i<biasGiris.length;i++){
    		girisBiasDegisim[i]=ogrenmeKatsayisi * girisHataMiktari[i] + momentumKatsayisi* girisBiasDegisim[i];
    		
    	}
    	for(int i=0;i<biasGiris.length;i++){
    		biasGiris[i]=biasGiris[i]+girisBiasDegisim[i];
 		
    	}
    	System.out.println("Giris Bias Degeri Tablosu Güncel Hali:");   	
    	for(int i=0; i<girisBiasDegisim.length; i++){                        
                 System.out.print("      "+biasGiris[i]);

        }
    	System.out.println(" ");


    }

    public static void main(String[] args) {
    
    	degerGirme();
	    if(toplamHata>esikDegeri){
    		
	    	geriyeDogruHesaplama(sonucCiktiDizisi,toplamHata);
    		
    	}
    		
    	     
    }	
}
