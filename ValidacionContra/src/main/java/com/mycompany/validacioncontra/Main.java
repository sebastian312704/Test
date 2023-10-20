
package com.mycompany.validacioncontra;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Ingrese una contraseña: ");
        String password = scanner.nextLine();

        System.out.println("Confirme la contraseña: ");
        String confirmPassword = scanner.nextLine();

        try {
            if (ValidatePas.validatepassword(password, confirmPassword)) {
                System.out.println("La contraseña es válida.");
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}