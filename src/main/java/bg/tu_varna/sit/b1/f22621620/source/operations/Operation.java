package bg.tu_varna.sit.b1.f22621620.source.operations;

public enum Operation {
    OPEN("open", "Opens and read specified file."),
    CLOSE("close", "Closes current file."),
    SAVE("save", "Saves in the current file."),
    SAVE_AS("save as", "Saves in a specified location."),
    HELP("help", "Shows all available operations."),
    EXIT("exit", "Exits from the application.");

    private final String operation;
    private final String description;

    Operation(String operation, String description) {
        this.operation = operation;
        this.description = description;
    }

    public String getOperation() {
        return operation;
    }

    public String getDescription() {
        return description;
    }
}
