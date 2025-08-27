abstract class Personaje {
    private final String id;        
    private String nombre;
    private String raza;
    private int nivel;              
    private int salud;              

    public Personaje(String id, String nombre, String raza, int nivel, int salud) {
        this.id = id;
        setNombre(nombre);
        setRaza(raza);
        setNivel(nivel);
        this.salud = clamp(salud, 0, 100);
    }

    public String Id() { return id; }
    public String Nombre() { return nombre; }
    public String Raza() { return raza; }
    public int Nivel() { return nivel; }
    public int Salud() { return salud; }

    public final void setNombre(String nombre) {
        if (nombre == null || nombre.isBlank()) throw new IllegalArgumentException("Nombre inválido");
        this.nombre = nombre.trim();
    }

    public final void setRaza(String raza) {
        if (raza == null || raza.isBlank()) throw new IllegalArgumentException("Raza inválida");
        this.raza = raza.trim();
    }

    public final void setNivel(int nivel) {
        if (nivel < 1) throw new IllegalArgumentException("El nivel debe ser >= 1");
        this.nivel = nivel;
    }

    protected final void recibirDanio(int puntos) {
        this.salud = clamp(this.salud - Math.max(0, puntos), 0, 100);
    }

    protected final void curar(int puntos) {
        this.salud = clamp(this.salud + Math.max(0, puntos), 0, 100);
    }

    private static int clamp(int v, int min, int max) { return Math.max(min, Math.min(max, v)); }

    public void mostrarInfo() {
        System.out.println("[" + getTipo() + "] " + nombre + " (" + raza + ") — Nivel " + nivel + ", Salud " + salud);
    }

    public abstract String getTipo();
    public abstract void actuar();   

    public void celebrar() {
        System.out.println(nombre + ": ¡Victoria!");
    }
}

class Guerrero extends Personaje {
    public Guerrero(String id, String nombre, String raza, int nivel, int salud) {
        super(id, nombre, raza, nivel, salud);
    }

    @Override public String getTipo() { return "Guerrero"; }

    @Override public void actuar() {
        System.out.println(getTipo() + " ataca con espada pesada.");
        recibirDanio(5);   
        curar(2);          
    }

    @Override public void celebrar() {
        System.out.println("¡Por el honor!");
    }
}

class Mago extends Personaje {
    private int mana;  

    public Mago(String id, String nombre, String raza, int nivel, int salud, int mana) {
        super(id, nombre, raza, nivel, salud);
        this.mana = Math.max(0, Math.min(100, mana));
    }

    public int getMana() { return mana; }

    @Override public String getTipo() { return "Mago"; }

    @Override public void actuar() {
        if (mana >= 20) {
            System.out.println("Mago lanza Bola de Fuego.");
            mana -= 20;   
        } else {
            System.out.println("Mago descansa para recuperar maná.");
            mana += 10;
            curar(3);  
        }
    }
}

class Arquero extends Personaje {
    private int flechas;

    public Arquero(String id, String nombre, String raza, int nivel, int salud, int flechas) {
        super(id, nombre, raza, nivel, salud);
        this.flechas = Math.max(0, flechas);
    }

    public int getFlechas() { return flechas; }

    @Override public String getTipo() { return "Arquero"; }

    @Override public void actuar() {
        if (flechas > 0) {
            System.out.println("Arquero dispara una flecha precisa.");
            flechas--;   
        } else {
            System.out.println("Arquero recoge flechas perdidas.");
            flechas += 2;   
        }
    }
}

public class MundoPersonajes {
    public static void main(String[] args) {
        
        Personaje p1 = new Guerrero("G-01", "Deimos", "Humano", 7, 90);
        Personaje p2 = new Mago("M-01", "Santiago", "Elfo", 7, 70, 30);
        Personaje p3 = new Arquero("A-01", "Atreus", "Humano", 4, 80, 3);

        Personaje[] grupo = { p1, p2, p3 };


        for (Personaje p : grupo) {
            p.mostrarInfo();    
            p.actuar();         
            p.celebrar();       
            System.out.println("---------------------");
        }

        ((Guerrero)p1).actuar();         
        ((Mago)p2).actuar();             
        ((Arquero)p3).actuar();          

        System.out.println("== Estado final ==");
        for (Personaje p : grupo) p.mostrarInfo();
    }
}
