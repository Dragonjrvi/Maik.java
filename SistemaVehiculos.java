class Vehiculo {
 
    private String marca;
    private String modelo;
    private int velocidad;


    public Vehiculo(String marca, String modelo) {
        this.marca = marca;
        this.modelo = modelo;
        this.velocidad = 0;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public int getVelocidad() {
        return velocidad;
    }

    public void mostrarInfo() {
        System.out.println("Marca: " + marca + ", Modelo: " + modelo + ", Velocidad: " + velocidad + " km/h");
    }

    public void acelerar() {
        velocidad += 10;
        System.out.println(marca + " " + modelo + " acelera a " + velocidad + " km/h.");
    }
}


class Coche extends Vehiculo {
    public Coche(String marca, String modelo) {
        super(marca, modelo);
    }

    @Override
    public void acelerar() {
        System.out.println(getMarca() + " " + getModelo() + " acelera rápidamente.");
    }
}


class Moto extends Vehiculo {
    public Moto(String marca, String modelo) {
        super(marca, modelo);
    }

    @Override
    public void acelerar() {
        System.out.println(getMarca() + " " + getModelo() + " acelera con fuerza, haciendo rugir el motor.");
    }
}


public class SistemaVehiculos {
    public static void main(String[] args) {
  
        Vehiculo v1 = new Vehiculo("Genérico", "ModeloX");

        Vehiculo coche = new Coche("Toyota", "Corolla");
        Vehiculo moto = new Moto("Yamaha", "R1");

        Vehiculo[] vehiculos = {v1, coche, moto};

        for (Vehiculo v : vehiculos) {
            v.mostrarInfo();
            v.acelerar();
            System.out.println("---------------------");
        }
    }
}
