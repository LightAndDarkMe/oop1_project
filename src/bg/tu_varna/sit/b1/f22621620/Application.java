package bg.tu_varna.sit.b1.f22621620;

import bg.tu_varna.sit.b1.f22621620.source.operations.OperationController;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Application {
    public static void main(String[] args) throws IOException {
        do {
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(System.in)
            );
            System.out.print(">");
            OperationController.execute(reader.readLine());
            System.out.print("\n");
        } while(true);
    }
}
