
package juegoAhorcado;

import java.util.Scanner;


public class Ahorcado {
    private String palabraSecreta;
    private StringBuilder palabraGuiones;
    private int intentosRestantes;
    private boolean juegoTerminado;

    public Ahorcado(String palabraSecreta, int intentos) {
        this.palabraSecreta = palabraSecreta.toLowerCase();
        this.intentosRestantes = intentos;
        this.palabraGuiones = new StringBuilder();
        for (int i = 0; i < palabraSecreta.length(); i++) {
            if (palabraSecreta.charAt(i) != ' ') {
                palabraGuiones.append('_');
            } else {
                palabraGuiones.append(' ');
            }
        }
        this.juegoTerminado = false;
    }

    public void jugar() {
        Scanner scanner = new Scanner(System.in);
        while (!juegoTerminado) {
            System.out.println("Palabra: " + palabraGuiones.toString());
            System.out.println("Intentos restantes: " + intentosRestantes);
            System.out.println("Ingresa una letra: ");
            String letra = scanner.nextLine().toLowerCase();
            if (letra.length() != 1 || !Character.isLetter(letra.charAt(0))) {
                System.out.println("Ingresa una sola letra válida.");
                continue;
            }
            if (!actualizarPalabra(letra.charAt(0))) {
                intentosRestantes--;
            }
            if (intentosRestantes == 0) {
                System.out.println("¡Perdiste! La palabra correcta era: " + palabraSecreta);
                juegoTerminado = true;
            } else if (palabraGuiones.indexOf("_") == -1) {
                System.out.println("¡Felicidades! ¡Has adivinado la palabra: " + palabraSecreta);
                juegoTerminado = true;
            }
        }
        scanner.close();
    }

    private boolean actualizarPalabra(char letra) {
        boolean letraEncontrada = false;
        for (int i = 0; i < palabraSecreta.length(); i++) {
            if (palabraSecreta.charAt(i) == letra) {
                palabraGuiones.setCharAt(i, letra);
                letraEncontrada = true;
            }
        }
        return letraEncontrada;
    }

    public static void main(String[] args) {
        String palabraSecreta = "programacion"; // Cambia esta palabra por la que desees
        int intentos = 6; // Cambia el número de intentos según prefieras
        Ahorcado juego = new Ahorcado(palabraSecreta, intentos);
        juego.jugar();
    }
}

