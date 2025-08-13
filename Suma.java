import java.util.Scanner;
public class Suma {
    public static void main(String[] args) {
        Scanner scanner =new Scanner(System.in);

        System.out.print("ingrese su numero");
        String num1=scanner.nextLine();

        System.out.print("ingrese un segundo numero");
        int num2= scanner.nextInt();
        System.out.println("La suma de " + num1 + " y " + num2  );
    }
}
