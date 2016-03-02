/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package birimfiyat;

import java.io.IOException;
import java.net.URL;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

/**
 *
 * @author oguzhan.turan
 */
public class BirimFiyat {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        
        //System.setProperty("http.proxySet","true");
        System.setProperty("http.proxyHost","btsproxy");
        System.setProperty("http.proxyPort","8080");
        
		
		
        String url = "http://www.csb.gov.tr/birimfiyat/uyeislemleri.php?id=1";
        String urlParameters = "&KullaniciAdi=bayiller8&Sifre=11111111&gonder=Giri%FE";
        URL obj = new URL(url);
        
        Document doc = Jsoup.connect(url)
                        .data("KullaniciAdi","bayiller8")
                        .data("Sifre","11111111")
                        .data("gonder","Giri%FE")
  // and other hidden fields which are being passed in post request.
                        .post();
            
        System.out.println(doc); // will print html source of homepage of facebook.
        
        
        //<li><a href="index.php?Sayfa=ana"><span class="glyphicon glyphicon-user"></span> bayiller8</a></li>
        // yukaridaki yerde kullanıcı adı varsa orda 
    }
    
}
