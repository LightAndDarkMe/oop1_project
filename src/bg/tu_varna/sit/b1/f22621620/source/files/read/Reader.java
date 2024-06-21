package bg.tu_varna.sit.b1.f22621620.source.files.read;

import bg.tu_varna.sit.b1.f22621620.source.field.Field;
import bg.tu_varna.sit.b1.f22621620.source.files.FieldFile;
import bg.tu_varna.sit.b1.f22621620.source.files.interfaces.Readable;
import bg.tu_varna.sit.b1.f22621620.source.operations.data.GameData;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Reader extends FieldFile implements Readable {

    public Reader(String file) {
        super(file);
    }

    @Override
    public void read() {
        List<String> grid = new ArrayList<>();
        int x = 10;
        int y = 10;
        int level = 1;

        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                List<String> lineArgs = Arrays.stream(line.split("=")).toList();
                switch (lineArgs.get(0)) {
                    case "level" -> {
                        level = Integer.parseInt(lineArgs.get(1));
                    }
                    case "x" -> {
                        x = Integer.parseInt(lineArgs.get(1));
                    }
                    case "y" -> {
                        y = Integer.parseInt(lineArgs.get(1));
                    }
                    case "grid" -> {
                        grid = Arrays.stream(lineArgs.get(1).split("/")).toList();
                    }
                }
            }

            GameData.getInstance().setCurrentField(new Field(grid, x, y, level));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
