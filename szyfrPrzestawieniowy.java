import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
    /* ------------ SZYFROWANIE ------------------- */
      
        Scanner scanner = new Scanner(System.in);

        System.out.print("Podaj tekst do zaszyfrowania (bez polskich znakow): ");
        String tekst = scanner.nextLine().replace(" ", "_"); 
        
        int dlugoscTekstu = tekst.length();
        int n = (int) Math.ceil(Math.sqrt(dlugoscTekstu));

        char[][] tablicaZnakow = new char[n][n];
        int indeks = 0;
        for (int kolumna = 0; kolumna < n; kolumna++) {
            for (int wiersz = 0; wiersz < n; wiersz++) {
                if (indeks < dlugoscTekstu) {
                    tablicaZnakow[kolumna][wiersz] = tekst.charAt(indeks);
                } else {
                    tablicaZnakow[kolumna][wiersz] = '_';
                }
                indeks++;
            }
        }

        String zaszyfrowany = "";
        for (int wiersz = 0; wiersz < n; wiersz++) {
            for (int kolumna = 0; kolumna < n; kolumna++) {
                zaszyfrowany += tablicaZnakow[kolumna][wiersz];
            }
        }

        System.out.println("Zaszyfrowany tekst: " + zaszyfrowany);
        
        /* ------------------ ODSZYFROWANIE ------------------------- */
        String odszyfrowany = "";
        
        Scanner klawiatura = new Scanner(System.in);
        System.out.println("\nPodaj tekst do odszyfrowania:");
        String doOdszyfrowania = klawiatura.nextLine().replace("_"," ");
        
        int dlugoscZaszyfr = doOdszyfrowania.length();
        int x = (int) Math.ceil(Math.sqrt(dlugoscZaszyfr));
        
        char znaki[][] = new char[x][x];
        int klucz = 0;
        
        for(int kolumna = 0; kolumna<x; kolumna++){
            for(int wiersz = 0; wiersz<x; wiersz++){
                if(klucz < doOdszyfrowania.length()){
                    znaki[wiersz][kolumna] += doOdszyfrowania.charAt(klucz);
                }
                else{
                    znaki[wiersz][kolumna] += ' ';
                }
                klucz++;
            }
        }
        for(int kolumna = 0; kolumna<x; kolumna++){
            for(int wiersz = 0; wiersz<x; wiersz++){
                odszyfrowany += znaki[kolumna][wiersz];
            }
        }
        
        System.out.println("Odszyfrowany tekst: "+odszyfrowany);
        
    }
}
