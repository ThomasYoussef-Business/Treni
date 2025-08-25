package com.generation.library;

import java.util.Scanner;

/**
 * Questa classe offre i metodi di base per comunicare con l'utente.
 *
 * @author Stefano Rubinetti, 2024
 */
public class ConsoleV2 {
    private static final Scanner keyboard = new Scanner(System.in);

    /**
     * Il metodo print riceve qualunque cosa e la stampa. <br />
     * print("Ferdinando") stamperà Ferdinando <br />
     * print(3) stamperà 3 <br />
     * print(4+5) stamperà 9 <br />
     *
     * @param obj (la cosa da stampare)
     * @author Ferdinando Primerano, 2023
     */
    public static void print(Object obj) {
        System.out.println(obj.toString());
    }

    /**
     * Il programma si ferma e chiede all'utente di inserire del testo. <br />
     * Il testo viene memorizzato in una variabile di tipo String o usato in un qualche altro modo. <br />
     * Esempio: String name = readString();, l'utente inserisce Ferdinando e ora name "contiene" Ferdinando <br />
     *
     * @return il valore inserito dall'utente <br />
     */
    public static String readString() {
        return keyboard.nextLine();
    }

    /**
     * Il programma si ferma e chiede all'utente di inserire un numero intero. <br />
     * Il testo viene memorizzato in una variabile di tipo int o double o usato in un qualche altro modo. <br />
     * Esempio: int age = readInt();, l'utente inserisce 43 e ora age contiene 43. <br />
     * Attenzione: se l'utente non dovesse inserire un valore numerico il programma andrebbe in crash. <br />
     *
     * @return il valore inserito dall'utente
     */
    public static int readInt() {
        int readResult;
        do {
            try {
                readResult = Integer.parseInt(keyboard.nextLine());
                return readResult;
            } catch (Exception e) {
                System.out.println("Il valore inserito non è un numero intero valido. Riprovare:");
            }
        } while (true);
    }

    /**
     * Il programma si ferma e chiede all'utente di inserire un numero POTENZIALMENTE con la virgola. <br />
     * Il testo viene memorizzato in una variabile di tipo double o usato in un qualche altro modo. <br />
     * Esempio: int age = readInt();, l'utente inserisce 43 e ora age contiene 43. <br />
     * Attenzione: se l'utente non dovesse inserire un valore numerico il programma andrebbe in crash. <br />
     *
     * @return il valore inserito dall'utente
     */
    public static double readDouble() {
        double readResult;
        do {
            try {
                readResult = Double.parseDouble(keyboard.nextLine());
                return readResult;
            } catch (Exception e) {
                System.out.println("Il valore inserito non è un numero valido. Riprovare:");
            }
        } while (true);
    }


    /**
     * Stampa la stringa passata come argomento <br />
     * E ritorna la stringa letta dall'input dell'utente.
     *
     * @param question La domanda da porre all'utente
     * @return Il valore inserito dall'utente
     */
    public static String askAndReadString(String question) {
        System.out.println(question);
        return readString();
    }

    /**
     * Stampa la stringa passata come argomento <br />
     * E ritorna il numero intero letto dall'input dell'utente.
     * @param question La domanda da porre all'utente
     * @return Il valore inserito dall'utente
     */
    public static int askAndReadInt(String question) {
        System.out.println(question);
        return readInt();
    }

    /**
     * Stampa la stringa passata come argomento <br />
     * E ritorna il numero intero positivo letto dall'input dell'utente.
     * @param question La domanda da porre all'utente
     * @return Il valore inserito dall'utente, solo se un integer positivo
     */
    public static int askAndReadUInt(String question) {
        int answer = askAndReadInt(question);
        while (answer < 0)
            answer = askAndReadInt("Il numero inserito non è positivo. Riprovare:");

        return answer;
    }

    /**
     * Stampa la stringa passata come argomento <br />
     * E ritorna il numero frazionale letto dall'input dell'utente.
     * @param question La domanda da porre all'utente
     * @return Il valore inserito dall'utente
     */
    public static double askAndReadDouble(String question) {
        System.out.println(question);
        return readDouble();
    }

    /**
     * Stampa la stringa passata come argomento <br />
     * E ritorna il numero decimale positivo letto dall'input dell'utente.
     * @param question La domanda da porre all'utente
     * @return Il valore inserito dall'utente, solo se un double positivo
     */
    public static double askAndReadUDouble(String question) {
        double answer = askAndReadDouble(question);

		while (answer < 0)
			answer = askAndReadDouble("Il numero inserito non è positivo. Riprovare:");

        return answer;
    }
}