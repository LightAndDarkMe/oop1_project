package bg.tu_varna.sit.b1.f22621620.source.operations;

import java.io.File;
import java.io.FileNotFoundException;

public class OperationController {
    private static File filePath = null;
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
                case OPEN -> {
                    String fileName = args[1];
                    //Fix implementation when you make the xml files
                    if (!(fileName.equals(".xml"))) {
                        throw new FileNotFoundException("File does not exist!");
                    }
                    filePath = new File(fileName);
                    System.out.println("File " + fileName + " opened successfully!");
                }
                case CLOSE -> {
                    filePath = null;
                }
                case SAVE -> {
                    if (filePath == null) {
                        throw new FileNotFoundException("File does not exist!");
                    }
                    switch (filePath.getName()) {
                        //Fix implementation when you make the xml files
                        case ".xml" -> {}
                        default -> {
                            System.out.println("File not found!");
                        }
                    }
                }
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


        } catch (IllegalArgumentException e) {
            System.out.println("INVALID OPERATION! Try again.");
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}
