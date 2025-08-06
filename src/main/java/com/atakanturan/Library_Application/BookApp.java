package com.atakanturan.Library_Application;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import java.util.Scanner;


// Enum ile kitap türleri
enum KitapTuru {
    Roman, Bılım, Tarıh, Teknoloj,Other
}

//Kitap Class

@Getter
@Setter


class Kitap {
    //Field
    private int id;
    private String ad;
    private String yazar;
    private KitapTuru tur;
    private LocalDate eklenmeTarihi;


    // Constructor(parametresiz)
    public Kitap() {
    }

    // Constructor(parametreli)

    public Kitap(int id, String ad, String yazar, KitapTuru tur, LocalDate eklenmeTarihi) {
        this.id = id;
        this.ad = ad;
        this.yazar = yazar;
        this.tur = tur;
        this.eklenmeTarihi = LocalDate.now();
    }

    //Method
    public void bilgileriYazdir() {
        System.out.printf("ID: %d | %s - %s (%s) [%s]%n", id, ad, yazar, tur, eklenmeTarihi.format(DateTimeFormatter.ofPattern("dd/MMMM/yyyy")));

    }

}
//Customise Exception : Kitap bulunmazsa
class KitapBulunamadiException extends Exception{
    //Parametresiz Constructor
    public KitapBulunamadiException(String message) {
        super(message);
    }
}


public class BookApp {
    //Scanner
    private static Scanner scanner = new Scanner(System.in);

    //Login
    public boolean girisYap() {
        //Kullanıcan kullanıadı,şifre
        return true;

    }

    //Method
    public void allBookMethod() {
        Scanner scanner = new Scanner(System.in);

        //Dizi(array)
        Kitap[] kutuphane = new Kitap[5];
        int kitapSayisi = 0;

        //login oldu mu ?
        boolean devam = girisYap();
        try {
            while (devam) {
                System.out.println("\n KİTAP YÖNETİM UYGULAMASI");
                System.out.println("1-Kitap ekle");
                System.out.println("2-Kitap listele");
                System.out.println("3/Kitap ara");
                System.out.println("Çıkış");
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
                            System.out.println("Kitap adı");
                            String yazar = scanner.nextLine();

                            System.out.println("Kitap yazarı");
                            String ad = scanner.nextLine();

                            System.out.println("Kitap Türü Seçin 0-Roman, 1-Bilim 2-Tarih, 3-Teknoloji, 4-Diğer");
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
                        System.out.println();
                    }
                    //Kitap Ara
                    case 3 -> {}
                    //Çıkış
                    case 4 -> {}
                    default -> System.out.println("Hatalı seçim");
                }//end switch

                //Wrappeer/Math/Random örneği
                Integer toplamKitap = kitapSayisi;//Wrapper
                System.out.println("Toplram kitap sayısı" + toplamKitap);
                System.out.println("Random index(0-"+(kitapSayisi-1)+"):" + new Random().nextInt(Math.max(1,kitapSayisi)));
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}
