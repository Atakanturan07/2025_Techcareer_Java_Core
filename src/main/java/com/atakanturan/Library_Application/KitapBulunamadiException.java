package com.atakanturan.Library_Application;

//3- Customise Exception : Kitap bulunmazsa

public class KitapBulunamadiException extends RuntimeException {
    public KitapBulunamadiException(String message) {
        super(message);
    }
}
