

package com.mycompany.ejerciciosexcepciones;

import java.util.Scanner;

public class Ejerciciosexcepciones {

    public static void main(String[] args) throws Exception {
        Scanner scanner =new Scanner (System.in);
        System.out.println("Ingrese un numero  ");
        int number =scanner.nextInt();
        
        Even even = new Even();
        try{
             even.isEven (number);
        }catch (Exception e) {
            System.out.println("Ha ocurrido un error " + e.getMessage() );
        }
       
    }
}
