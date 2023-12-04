package Esercizio1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Esercizio1 {
    private static final Logger logger = LoggerFactory.getLogger(Esercizio1.class);

    public static void main(String[] args) {
        int[] array = randomArray(5);

        Scanner input = new Scanner(System.in);

        int value;

        do {
            stampaArray(array);

            System.out.println("Inserisci un numero (0 per uscire): ");
            value = Integer.parseInt(input.nextLine());

            if (value != 0) {
                System.out.println("Inserisci la posizione (0 - " + (array.length - 1) + "): ");
                int position = Integer.parseInt(input.nextLine());

                try {
                    aggiornaArray(array, position, value);
                } catch (ArrayIndexOutOfBoundsException e) {
                    logger.error("Errore: Posizione non valida. Riprova.");
                }
            }
        } while (value != 0);
    }

    private static int[] randomArray(int size) {
        int[] array = new int[size];
        Random random = new Random();

        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(10) + 1;
        }

        return array;
    }

    private static void stampaArray(int[] array) {
        System.out.println("Array attuale: " + Arrays.toString(array));
    }

    private static void aggiornaArray(int[] array, int position, int value) {
        if (position < 0 || position >= array.length) {
            throw new ArrayIndexOutOfBoundsException();
        }

        array[position] = value;
    }
}
