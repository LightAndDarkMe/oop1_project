package bg.tu_varna.sit.b1.f22621620.source.files.write;

import bg.tu_varna.sit.b1.f22621620.source.field.Field;
import bg.tu_varna.sit.b1.f22621620.source.files.FieldFile;
import bg.tu_varna.sit.b1.f22621620.source.files.interfaces.Writable;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Writer extends FieldFile implements Writable {

    public Writer(String file) {
        super(file);
    }

    @Override
    public void write(Field field) {
        try {
            PrintWriter printWriter = new PrintWriter(new FileWriter(file));
            printWriter.print("level=");
            printWriter.println(field.getLevel());
            printWriter.print("x=");
            printWriter.println(field.getX());
            printWriter.print("y=");
            printWriter.println(field.getY());
            printWriter.print("grid=");
            printWriter.println(String.join("/", field.getGrid()));
            printWriter.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
