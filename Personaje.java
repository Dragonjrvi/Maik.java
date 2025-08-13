public class Personaje {
    String nombre;
    String raza;
    Integer ki;
    Integer ataque;
    String planeta;
    Integer Pelea;
    Integer curarse;

    public Personaje(String nombre, String raza, Integer ki, Integer ataque, String planeta,Integer Pelea) {
        this.nombre = nombre;
        this.raza = raza;
        this.ki = ki;
        this.ataque = ataque;
        this.planeta = planeta;
        this.Pelea = Pelea;
        this.curarse=curarse;
    }

    public void mostrarPersonaje(){
        System.out.println("El nombre es: " + nombre);
        System.out.println("La raza es: " + raza);
        System.out.println("El ki es: " + ki);
        System.out.println("El ataque es: " + ataque);
        System.out.println("El planeta es: " + planeta);
        System.out.println("Pelea es"+Pelea);
        System.out.println("Curarse es"+curarse);

    }
    public void atacar(Personaje enemigo) {
        System.out.println(nombre + " ataca a " + enemigo.nombre + " causando " + ataque + " de daño.");
        enemigo.ki -= ataque;
        if (enemigo.ki < 0) {
            enemigo.ki = 0;
        }
        System.out.println(enemigo.nombre + " ahora tiene " + enemigo.ki + " de ki.");
    }
    public void curarse(){
        System.out.println(nombre+"Se cura "+curarse);
        System.ki +=curarse
    }
    public static void main(String[] args) {
        Personaje goku = new Personaje("Goku", "Saiyajin", 1000, 1000, "Vegita",50);
        Personaje vegetta = new Personaje("Vegetta", "Saiyajin", 999, 999, "Vegita",50);
        System.out.println("Estado inicial:");
        goku.mostrarPersonaje();
        System.out.println();
        vegetta.mostrarPersonaje();
         System.out.println("\n--- COMIENZA LA BATALLA ---\n");

       
        goku.atacar(vegetta);

        
        vegetta.atacar(goku);

        System.out.println("\n--- ESTADO FINAL ---\n");
        goku.mostrarPersonaje();
        System.out.println();
        vegetta.mostrarPersonaje();
    }
}