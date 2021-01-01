
import java.io.File;
import java.util.Scanner;


public class Main {
    private static Kart[][] kartlar = new Kart[4][4];
    public static void kayıttanAl(){
        File file = new File("kayıt.bin");
        Scanner scn = new Scanner(System.in);
        
        if(file.exists()){
            System.out.print("Kaydedilmiş bir oyun var bu noktadan devam etmek ister misin ? (yes ya ada no)");
            String cevap = scn.nextLine();
            if(cevap.equals("yes")){
                kartlar = OyunKaydet.kayıttanAl();
                return;
            }
        }
        kartlar[0][0] = new Kart('E');
        kartlar[0][1] = new Kart('A');
        kartlar[0][2] = new Kart('B');
        kartlar[0][3] = new Kart('F');
        kartlar[1][0] = new Kart('G');
        kartlar[1][1] = new Kart('A');
        kartlar[1][2] = new Kart('D');
        kartlar[1][3] = new Kart('H');
        kartlar[2][0] = new Kart('F');
        kartlar[2][1] = new Kart('C');
        kartlar[2][2] = new Kart('D');
        kartlar[2][3] = new Kart('H');
        kartlar[3][0] = new Kart('E');
        kartlar[3][1] = new Kart('G');
        kartlar[3][2] = new Kart('B');
        kartlar[3][3] = new Kart('C');
    }
    public static void main(String [] args){
      Scanner scn = new Scanner(System.in);
        
       /* kartlar[0][0] = new Kart('E');
        kartlar[0][1] = new Kart('A');
        kartlar[0][2] = new Kart('B');
        kartlar[0][3] = new Kart('F');
        kartlar[1][0] = new Kart('G');
        kartlar[1][1] = new Kart('A');
        kartlar[1][2] = new Kart('D');
        kartlar[1][3] = new Kart('H');
        kartlar[2][0] = new Kart('F');
        kartlar[2][1] = new Kart('C');
        kartlar[2][2] = new Kart('D');
        kartlar[2][3] = new Kart('H');
        kartlar[3][0] = new Kart('E');
        kartlar[3][1] = new Kart('G');
        kartlar[3][2] = new Kart('B');
        kartlar[3][3] = new Kart('C');*/
        //oyunTahtası();
        kayıttanAl();
        while(oyunBittiMi()== false){
            oyunTahtası();
            System.out.println("cıkıs isin q'ya basınız :");
            String cıkıs = scn.nextLine();
            if(cıkıs.equals("q")){
                System.out.println("Oyunu kaydetmek istiyor musunuz (yes ya da no) : ");
                String kayıt ;
                kayıt=scn.nextLine();
                if(kayıt.equals("yes")){
                    OyunKaydet.oyunKaydet(kartlar);
                    
                }else{
                    System.out.println("Oyun Kaydedilmedi");
                }
                System.out.println("Programdan Çıkılıyor.");
                break;
            }
            tahminEt();
        }
    }
    public static void tahminEt(){
         Scanner scn = new Scanner(System.in);
         System.out.print("birinci tahmin :(i ve j değerlerini bir boşluklu giriniz) ");
         int i1 = scn.nextInt();
         int j1 = scn.nextInt();
         kartlar[i1][j1].setTahmin(true);
         oyunTahtası();
         System.out.print("ikinci tahmin :(i ve j değerlerini bir boşluklu giriniz) ");
         int i2 = scn.nextInt();
         int j2 = scn.nextInt();
         if(kartlar[i1][j1].getDeger() == kartlar[i2][j2].getDeger()){
             System.out.println("Doğru tahmin ");
             kartlar[i2][j2].setTahmin(true);
             
         }else{
             System.out.println("yanlış tahmin ");
             kartlar[i1][j1].setTahmin(false);
         }
        
    }
    public static boolean oyunBittiMi() {
        for(int i = 0;i<4;i++){
            for(int j = 0;j<4;j++){
                if(kartlar[i][j].isTahmin() == false){
                    return false;
                }
            }
        }
        return true;
    }
    public static void oyunTahtası(){
        System.out.println("-------------------");
        for(int i = 0;i<4 ;i++){
            for(int j = 0;j<4;j++){
                if(kartlar[i][j].isTahmin()){
                    System.out.print(" |"+ kartlar[i][j].getDeger()+"| ");
                }else{
                    System.out.print(" | | ");
                }
            }
            System.out.println("");
        }
        System.out.println("-------------------");

    }
    
}
