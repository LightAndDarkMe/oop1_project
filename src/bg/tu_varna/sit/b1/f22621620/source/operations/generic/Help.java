package bg.tu_varna.sit.b1.f22621620.source.operations.generic;

import bg.tu_varna.sit.b1.f22621620.source.operations.Operation;
import bg.tu_varna.sit.b1.f22621620.source.operations.interfaces.ExecutableOperation;

import javax.xml.parsers.ParserConfigurationException;
import java.io.FileNotFoundException;

public class Help implements ExecutableOperation {
    @Override
    public void execute() throws ParserConfigurationException, FileNotFoundException {
        for (Operation operation : Operation.values()) {
            System.out.printf("%-20s%s\n", operation.getOperation().toUpperCase(), operation.getDescription());
        }
    }
}
