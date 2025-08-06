package com.atakanturan;

import java.util.Date;
import java.util.Scanner;

//Variable
public class _02_Variables {


    public static void getDateTutorials() {
        // Date Instance(Örnekleme)
        Date dateTime = new Date();

        System.out.println("Şu andaki zaman: " + dateTime);
        System.out.println("1 ocak 1970: " + dateTime.  getTime());
        System.out.println("Year: " + dateTime.getYear()); // +1900, -1900
        System.out.println("Year: " + (1900 + dateTime.getYear()));
        System.out.println("Month: " + dateTime.getMonth());     // ay: Sıfırdan başlar
        System.out.println("Day: " + dateTime.getDay());        //
        System.out.println("Ayın Date: " + dateTime.getDate()); //
        System.out.println("Hours: " + dateTime.getHours());    //
        System.out.println("Minute: " + dateTime.getMinutes()); //
        System.out.println("Second: " + dateTime.getSeconds()); //
    }
    public static void setDateTutorials() {
        // Date Instance(Örnekleme)
        Date dateTime = new Date();
        System.out.println("Hours: " + dateTime.getHours());    //
        dateTime.setHours(15);
        System.out.println("Hours: " + dateTime.getHours());    //
    }

//    public static int userData() {
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Lütfen bir sayı giriniz");
//        int user = scanner.nextInt();
//        return user;
//    }

    public static void main(String[] args) {
       // int gelenDeger = userData();
       // System.out.println("Kullanıcıdan gelen sayı: " + gelenDeger);
        getDateTutorials();
        setDateTutorials();
        System.out.println("Deneme");
        int number = 6;

        System.out.println("Binary: " + Integer.toBinaryString(number));
        int fromBinary= Integer.parseInt("1010",2);
        System.out.println(fromBinary);
        Scanner();

    }
    public enum _16_1_Enum {
        PAZARTESI,SALI,CARSAMBA,PERSEMBE,CUMA,CUMARTESI,PAZAR
    }
    public static void Scanner(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Lütfen adınızı giriniz");
        String name = scanner.nextLine();
        System.out.println("Adınız: "+name);

        System.out.println("\nLütfen bir sayı giriniz");
        int numberData = scanner.nextInt();
        System.out.println("Girdiğiniz Sayı: "+numberData);

        // Scanner close
        scanner.close();
    }
    // PSVM
    class MainEnum {
        public static void main(String[] args) {
            _16_1_Enum days = _16_1_Enum.PAZARTESI;
            System.out.println(days);
            String data = days.toString();
            System.out.println(data);
            System.out.println(days.ordinal());
        }
    }
}
