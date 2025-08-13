public class CuentaBancaria {
   
    String titular;
    String numeroCuenta;
    double saldo;

    
    public CuentaBancaria(String titular, String numeroCuenta, double saldo) {
        this.titular = titular;
        this.numeroCuenta = numeroCuenta;
        this.saldo = saldo;
    }

    
    public void mostrarDatos() {
        System.out.println("Titular: " + titular);
        System.out.println("Número de cuenta: " + numeroCuenta);
        System.out.println("Saldo: $" + saldo);
    }

    
    public void depositar(double cantidad) {
        if (cantidad > 0) {
            saldo += cantidad;
            System.out.println("Depósito exitoso. Nuevo saldo: $" + saldo);
        } else {
            System.out.println("La cantidad a depositar debe ser mayor a cero.");
        }
    }

    
    public void retirar(double cantidad) {
        if (cantidad > 0 && cantidad <= saldo) {
            saldo -= cantidad;
            System.out.println("Retiro exitoso. Nuevo saldo: $" + saldo);
        } else {
            System.out.println("Fondos insuficientes o cantidad inválida.");
        }
    }

   
    public void transferir(CuentaBancaria destino, double cantidad) {
        if (cantidad > 0 && cantidad <= saldo) {
            saldo -= cantidad;
            destino.depositar(cantidad); 
            System.out.println("Transferencia exitosa. Nuevo saldo: $" + saldo);
        } else {
            System.out.println("No se pudo realizar la transferencia. Verifica el monto.");
        }
    }

    public static void main(String[] args) {
        CuentaBancaria cuenta1 = new CuentaBancaria("Duvan Jaramillo", "9139", 1000.0);
        CuentaBancaria cuenta2 = new CuentaBancaria("Ruben Dario", "2228", 500.0);

        System.out.println("=== Cuenta 1 ===");
        cuenta1.mostrarDatos();
        System.out.println();

        System.out.println("=== Cuenta 2 ===");
        cuenta2.mostrarDatos();
        System.out.println();

        
        cuenta1.depositar(200);
        cuenta1.retirar(150);
        cuenta1.transferir(cuenta2, 300);

        System.out.println();
        System.out.println("=== Estado Final de las Cuentas ===");
        cuenta1.mostrarDatos();
        System.out.println();
        cuenta2.mostrarDatos();
    }
}