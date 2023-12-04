package Esercizio2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;

public class Esercizio2 {
    private static final Logger logger = LoggerFactory.getLogger(Esercizio2.class);

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        try {
            System.out.println("Inserisci il numero di km percorsi: ");
            double kmPercorsi = Double.parseDouble(input.nextLine());

            System.out.println("Inserisci i litri di carburante consumati: ");
            double litriConsumati = Double.parseDouble(input.nextLine());

            if (litriConsumati == 0) {
                throw new ArithmeticException("Errore: Divisione per zero. Inserisci un valore diverso da zero per i litri consumati.");
            }

            double consumoMedio = calcolaConsumoMedio(kmPercorsi, litriConsumati);

            System.out.println("Il consumo medio dell'auto è di " + consumoMedio + " km/litro.");
        } catch (Exception e) {
            logger.error("Errore: " + e.getMessage());
        } finally {
            input.close();
        }
    }

    private static double calcolaConsumoMedio(double kmPercorsi, double litriConsumati) {
        return kmPercorsi / litriConsumati;
    }
}
