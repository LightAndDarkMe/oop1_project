package bg.tu_varna.sit.b1.f22621620.source.operations;

import bg.tu_varna.sit.b1.f22621620.source.operations.factory.OperationFactory;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OperationController {
    private static final Map<Operation, OperationFactory> operations = new HashMap<>();

    static {
        operations.put(Operation.OPEN, OperationFactory.getInstance());
        operations.put(Operation.EXIT, OperationFactory.getInstance());
        operations.put(Operation.CLOSE, OperationFactory.getInstance());
        operations.put(Operation.SAVE, OperationFactory.getInstance());
        operations.put(Operation.SAVE_AS, OperationFactory.getInstance());
        operations.put(Operation.HELP, OperationFactory.getInstance());
    }

    public static void execute(String operation) {
        List<String> args = Arrays.stream(operation.split(" ")).toList();

        try {
            operation = parser(operation);

            if (operation == null) {
                return;
            }

            if (!check(operation)) {
                throw new Exception("Operation doesn't exist! Type \"help\" for all operations.");
            }

            int index = (operation.startsWith("SAVE_AS") ? 2 : 1);

            args = args.subList(index, args.size());
            Operation executable = Operation.valueOf(operation);
            operations.get(executable).getOperation(executable, args).execute();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static String parser(String input) {
        if (input.isBlank()) {
            return null;
        }

        String[] args = input.split(" ");
        String arg = args[0].toLowerCase();

        switch (arg) {
            case "save" -> {
                if (args.length == 1) {
                    break;
                }
                if (args[1].equals("as")) {
                    arg += "_" + args[1].toLowerCase();
                }
            }
        }

        return arg.toUpperCase();
    }

    private static Boolean check(String input) {
        for (Operation operation : Operation.values()) {
            String operationTest = operation.getOperation();
            if (input.contains("_")) {
                operationTest = operationTest.replace(" ", "_");
            }
            if (operationTest.equalsIgnoreCase(input)) {
                return true;
            }
        }
        return false;
    }
}
