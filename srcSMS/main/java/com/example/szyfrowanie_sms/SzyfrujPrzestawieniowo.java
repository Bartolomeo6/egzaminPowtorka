package com.example.szyfrowanie_sms;

public class SzyfrujPrzestawieniowo {
    SzyfrujPrzestawieniowo(){

    }

    public static String zaszyfrujTekst(String tekst){
        String zaszyfrowany = "";

        int dlugoscTekstu = tekst.length();
        int n = (int) Math.ceil(Math.sqrt(dlugoscTekstu));

        char[][] znaki = new char[n][n];
        int indeks = 0;

        for(int i = 0; i<n; i++){
            for(int j = 0; j<n; j++){
                if(indeks < dlugoscTekstu){
                    znaki[i][j] += tekst.charAt(indeks);
                }
                else{
                    znaki[i][j] += '_';
                }
                indeks++;
            }
        }

        for(int j = 0; j<n; j++){
            for(int i = 0; i<n; i++){
                zaszyfrowany += znaki[i][j];
            }
        }

        return zaszyfrowany;
    }
}
