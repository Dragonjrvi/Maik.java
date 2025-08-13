public class Operadores {
    public static void main(String[] args) {
 int a = 10;
 int b = 5;
 // Aritméticos
 System.out.println("Suma: " + (a + b)); // ➕ 15
 System.out.println("Resta: " + (a - b)); // ➖ 5
 System.out.println("Multiplicación: " + (a * b)); // ✖️ 50
 System.out.println("División: " + (a / b)); // ➗ 2
 System.out.println("Módulo: " + (a % b)); // 📏 0
 // Comparación
 System.out.println("¿Es a mayor que b? " + (a > b)); 
 System.out.println("¿Es a igual a b? " + (a == b)); 
 boolean esMayorEdad = true;
 boolean tienePermiso = false;
 System.out.println("¿Puede entrar? " + (esMayorEdad && tienePermiso)); 
 a += 2; 
 a++; 
 System.out.println("Nuevo valor de a: " + a);
 }
}
