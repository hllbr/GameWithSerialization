
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;


public class OyunKaydet {
    //bu alanda ya kaydedicez yada dosyadan okuyacağız
    public static void oyunKaydet(Kart[][] kartlar){
        try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("Kayıt.bin"))){
            
            System.out.println("Oyun Kayedediliyor");
          
            out.writeObject(kartlar);
            System.out.println("KAyıt.bin dosyasını kontrol ediniz");
        } catch (IOException ex) {
            System.out.println("Dosya açılırken hata meydana geldi");
        } 
    }
    public static Kart[][] kayıttanAl(){
        try(ObjectInputStream in = new ObjectInputStream(new FileInputStream("Kayıt.bin"))){
            Kart[][] cıktı = (Kart[][]) in.readObject();
            return cıktı;
    
        } catch (IOException ex) {
            System.out.println("Dosya açılırken hata meydana geldi");
        } catch (ClassNotFoundException ex) {
            System.out.println("Class Bulunamadı");
        } 
        return null;
    }
}
