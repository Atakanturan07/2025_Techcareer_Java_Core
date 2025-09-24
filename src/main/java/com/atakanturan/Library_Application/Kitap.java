package com.atakanturan.Library_Application;

//2- Kitap Class

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Getter
@Setter


public class Kitap {
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