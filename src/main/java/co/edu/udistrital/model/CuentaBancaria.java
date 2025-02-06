package co.edu.udistrital.model;

public class CuentaBancaria {
    private int saldo;

    // Constructor para inicializar el saldo
    public CuentaBancaria(int saldoInicial) {
        this.saldo = saldoInicial;
    }

    // Método sincronizado para realizar un depósito
    public synchronized void depositar(int cantidad) {
        saldo += cantidad;  // Esto es la sección crítica
    }

    // Método sincronizado para realizar un retiro
    public synchronized boolean retirar(int cantidad) {
        if (cantidad <= saldo) {
            saldo -= cantidad;
            return true;
        } else {
            return false;  // No hay suficiente dinero
        }
    }

    // Método para obtener el saldo
    public int getSaldo() {
        return saldo;
    }
}
