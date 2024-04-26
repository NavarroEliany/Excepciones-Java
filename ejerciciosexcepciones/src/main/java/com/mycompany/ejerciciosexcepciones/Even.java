
package com.mycompany.ejerciciosexcepciones;

public class Even {
    public boolean isEven  (int number) throws Exception{
        if (number % 2==0){
            throw new Exception ("No me gustan los numeros pares");
        }
        return false;
    }
}
