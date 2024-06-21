package bg.tu_varna.sit.b1.f22621620;

import bg.tu_varna.sit.b1.f22621620.source.operations.OperationController;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        System.out.println("Damadjani and Dragons [Public Beta]\n");
        OperationController operationController = new OperationController();

        do {
            Scanner scanner = new Scanner(System.in);
            System.out.print("$ ");
            String input = scanner.nextLine();
            System.out.println();
            operationController.execute(input);
            System.out.println();
        } while(true);
    }
}
