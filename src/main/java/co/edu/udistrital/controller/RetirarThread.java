package co.edu.udistrital.controller;

import co.edu.udistrital.model.CuentaBancaria;

public class RetirarThread extends Thread {
    private CuentaBancaria cuenta;
    private int cantidad;

    public RetirarThread(CuentaBancaria cuenta, int cantidad) {
        this.cuenta = cuenta;
        this.cantidad = cantidad;
    }

    @Override
    public void run() {
        cuenta.retirar(cantidad);
        
    }
}
