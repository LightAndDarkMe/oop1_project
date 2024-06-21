package bg.tu_varna.sit.b1.f22621620;

import bg.tu_varna.sit.b1.f22621620.source.field.Field;
import bg.tu_varna.sit.b1.f22621620.source.operations.OperationController;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        System.out.println("\033[0;95mDamadjani and Dragons [Public Beta]\n\u001B[0m");
        OperationController operationController = new OperationController();
//        List<String> grid;
//        grid = Arrays.stream("P#.#.####./...#M...T./T....M..##/##...T...#/..###..###/....#...../M...####../T#...##.../##...####./..........".split("/")).toList();
//        Field field = new Field(grid, 10, 10, 1);
//        System.out.println(field);

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
