package bg.tu_varna.sit.b1.f22621620.source.operations;

public class OperationController {
    public static void execute(String operation) {
        if (operation.isBlank()) {
            return;
        }

        String[] args = operation.split(" ");
        String arg = args[0].toLowerCase();
//        Will be extended later
        switch (arg) {
            case "save":
                if (args.length == 1) {
                    break;
                }
                if (args[1].equals("as")) {
                    arg += "_" + args[1].toLowerCase();
                }
                break;
        }

        try {
            switch (Operation.valueOf(arg.toUpperCase())) {
                case OPEN -> System.out.println("OPEN.\n" + Operation.OPEN.getDescription());
                case CLOSE -> System.out.println("CLOSE.\n" + Operation.CLOSE.getDescription());
                case SAVE -> System.out.println("SAVE.\n" + Operation.SAVE.getDescription());
                case SAVE_AS -> System.out.println("SAVE_AS.\n" + Operation.SAVE_AS.getDescription());
                case HELP -> {
                    for (Operation commandValue : Operation.values()) {
                        System.out.printf("%-20s%s\n", commandValue.getOperation().toUpperCase(), commandValue.getDescription());
                    }
                }
                case EXIT -> {
                    System.out.println("EXIT.\n" + Operation.EXIT.getDescription());
                    System.exit(0);
                }
            }


        } catch (IllegalArgumentException ex) {
            System.out.println("INVALID OPERATION! Try again.");
        }
    }
}
