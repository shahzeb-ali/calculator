package calculator.hbrs;

import calculator.hbrs.operations.Addition;
import calculator.hbrs.operations.Division;
import calculator.hbrs.exception.CalculatorException;
import calculator.hbrs.exception.UnknownOperationException;

import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Calculator calculator = new Calculator(Map.ofEntries(
                Map.entry('+', new Addition()),
                Map.entry('/', new Division())
        ));

        double x, y;
        char op;
        while (true) {
            // this code doesn't check for input errors.
            System.out.print("Bitte geben sie die erste Fließkommazahl ein: ");
            x = sc.nextDouble();

            System.out.print("Bitte geben sie die Operation ein: ");
            op = sc.next().charAt(0);

            System.out.print("Bitte geben sie die zweite Fließkommazahl ein: ");
            y = sc.nextDouble();

            try {
                System.out.println(calculator.calculate(x, y, op));
            } catch (UnknownOperationException e) {
                System.out.println(e.getMessage());
            } catch (CalculatorException e) {
                System.out.println("Ein Fehler ist während der Berechnung aufgetreten.");
            }
        }
    }
}
