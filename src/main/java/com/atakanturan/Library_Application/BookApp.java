package com.atakanturan.Library_Application;

import lombok.Getter;
import lombok.Setter;

import javax.xml.transform.Source;
import java.awt.print.Book;
import java.sql.SQLOutput;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import java.util.Scanner;

/*
//3- Customise Exception : Kitap bulunmazsa
class KitapBulunamadiException extends Exception{
    //Parametresiz Constructor
    public KitapBulunamadiException(String message) {
        super(message);
    }
}
*/


public class BookApp {
    //Scanner
    private static Scanner scanner = new Scanner(System.in);

    //Login
    public boolean girisYap() {
        //Kullanıcan kullanıadı,şifre
        String kullaniciAdi, sifre, dbKullaniciAdi = "root", dbSifre = "root";

        System.out.println("Kullanıcı adını yazınız");
        kullaniciAdi = scanner.nextLine();

        System.out.println("Şifre adını yazınız");
        sifre = scanner.nextLine();

        //karar mercisi
        if (kullaniciAdi.equals(dbKullaniciAdi) && sifre.equals(dbSifre)) {
            System.out.println("bilgiler doğru admin sayfasına yönlendiriliyorsunuz");
            return true;
        } else{
            System.out.println("Kullanıcı adı veya şifre yanlış girdiniz");
          girisYap();
        }
        return true;
    }

    //logout
    public void  cikis(){
        System.out.println("Htalı seçim");
    }
    //Method
    public void allBookMethod() {
        Scanner scanner = new Scanner(System.in);

        //Dizi(array)
        Kitap[] kutuphane = new Kitap[5];
        int kitapSayisi = 0;

        //login oldu mu ?

        boolean devam = girisYap();
        System.out.println(devam);
        try {
            while (devam) {
                System.out.println("\n KİTAP YÖNETİM UYGULAMASI");
                System.out.println("1-Kitap ekle");
                System.out.println("2-Kitap listele");
                System.out.println("3-Kitap ara");
                System.out.println("4-Çıkış");
                System.out.println("Seçiminiz");

                int secim = scanner.nextInt();
                scanner.nextLine();//dumppy enter

                //switch
                switch (secim){
                    //Kitap ekle
                    case 1 -> {
                        System.out.println("Kitap ekle");
                        if (kitapSayisi == kutuphane.length){
                            System.out.println("Dizi dolu, yeni kitap ekleyemezsiniz");
                        }else{
                            System.out.print("Kitap adı: ");
                            String yazar = scanner.nextLine();

                            System.out.print("Kitap yazarı: ");
                            String ad = scanner.nextLine();

                            System.out.print("Kitap Türü Seçin 0-Roman, 1-Bilim 2-Tarih, 3-Teknoloji, 4-Diğer : ");
                            int turIndex = scanner.nextInt();
                            KitapTuru kitapTuru=KitapTuru.values()[turIndex];

                            //ıd otamatik artsın
                            kutuphane[kitapSayisi] = new Kitap(kitapSayisi+1, ad, yazar , kitapTuru, LocalDate.now());
                            kitapSayisi++;
                            System.out.println("Kitap eklendi");
                        }
                    }
                    //Kitap Listesi
                    case 2 -> {
                        //Interative for
                        for (int i = 0; i < kitapSayisi; i++) {
                            kutuphane[i].bilgileriYazdir();
                            
                        }
                    }
                    //Kitap Ara
                    case 3 -> {
                        System.out.println("Aranıcak kitap");
                        String aranan = scanner.nextLine();
                        boolean kitapVarmi=false;
                        for (int i = 0; i < kitapSayisi; i++) {
                            if (kutuphane[i].getAd().equalsIgnoreCase(aranan)){
                                kutuphane[i].bilgileriYazdir();
                                kitapVarmi = true;
                                break;
                            }
                        }//end for
                        try {
                            if (!kitapVarmi)
                                throw new KitapBulunamadiException("Kitap bulunamadı "+ aranan);

                        }catch (KitapBulunamadiException kitapBulunamadiException){
                            System.out.println(kitapBulunamadiException.getMessage());
                        }
                    }

                    //Çıkış
                    case 4 -> {
                        System.out.println("Çıkıl yaılıyor");
                        System.exit(0);
                    }

                    default -> cikis();
                }//end switch

                //Wrappeer/Math/Random örneği
                Integer toplamKitap = kitapSayisi;//Wrapper
                System.out.println("Toplram kitap sayısı " + toplamKitap);
                System.out.println("Random index(0-"+(kitapSayisi-1)+"):" + new Random().nextInt(Math.max(1,kitapSayisi)));
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

}
