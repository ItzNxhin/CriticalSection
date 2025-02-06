package co.edu.udistrital.controller;

import co.edu.udistrital.model.CuentaBancaria;
import co.edu.udistrital.view.VistaConsola;

public class Controller {

    private VistaConsola vista;

    public Controller() {
        vista = new VistaConsola();
    }

    public void run() {
        boolean loop = true;
        while (loop) {
            int plata = vista.leerDatoEntero("Ingrese la cantidad base de su cuenta bancaria: ");
            CuentaBancaria cuenta = new CuentaBancaria(plata);

            vista.mostrarInformacion(
                    "Vas a hacer 3 transacciones para retirar tu dinero, ingresa el monto de cada una: ");
            int t1 = vista.leerDatoEntero("Ingrese la cantidad de la primera transacción: ");
            int t2 = vista.leerDatoEntero("Ingrese la cantidad de la segundo transacción: ");
            int t3 = vista.leerDatoEntero("Ingrese la cantidad de la tercera transacción: ");

            RetirarThread h1 = new RetirarThread(cuenta, t1);
            RetirarThread h2 = new RetirarThread(cuenta, t2);
            RetirarThread h3 = new RetirarThread(cuenta, t3);

            h1.start();
            h2.start();
            h3.start();

            try {
                h1.join();
                h2.join();
                h3.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("Este es el saldo final de su cuenta: " + cuenta.getSaldo());
            int volver = vista.leerDatoEntero(" Desea volver a intentar? (1. Si, Otro numero. No): ");
            if (volver != 1)
                loop = false;
        }

    }
}
