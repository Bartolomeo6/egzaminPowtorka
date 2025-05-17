// Online Java Compiler
// Use this editor to write, compile and run your Java code online
import java.util.Scanner;

class Main {
    
    private static String zaszyfrujTekstG(String tekst){
        String zaszyfrowany = "";
        for(int i = 0; i<tekst.length(); i++){
            char litera = tekst.charAt(i);
            char zaszyfrowanaLitera = algoGaderypoluki(litera);
            zaszyfrowany += zaszyfrowanaLitera;
        }
        return zaszyfrowany;
    }
    
    private static char algoGaderypoluki(char litera){
        switch(litera){
            case 'g': return 'a';
            case 'a': return 'g';
            case 'd': return 'e';
            case 'e': return 'd';
            case 'r': return 'y';
            case 'y': return 'r';
            case 'p': return 'o';
            case 'o': return 'p';
            case 'l': return 'u';
            case 'u': return 'l';
            case 'k': return 'i';
            case 'i': return 'k';
            
            default: return litera;

        }
    }
    
    public static void main(String[] args) {
        
        Scanner klawiatura = new Scanner(System.in);
        
        System.out.println("Szyfrowanie algorytmem GADERYPOLUKI ");
        System.out.println("Podaj tekst do zaszyfrowania: ");
        
        String tekstDoZaszyfrowania = klawiatura.nextLine();
        
        if(tekstDoZaszyfrowania.length() > 20){
            tekstDoZaszyfrowania = tekstDoZaszyfrowania.substring(0,20);
        }
        
        String zaszyfrowanyString = zaszyfrujTekstG(tekstDoZaszyfrowania);
        System.out.println("Zaszyfrowany tekst: "+zaszyfrowanyString);
        
    }
}
