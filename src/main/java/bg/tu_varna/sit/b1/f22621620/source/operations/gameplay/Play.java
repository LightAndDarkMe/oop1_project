package bg.tu_varna.sit.b1.f22621620.source.operations.gameplay;

import bg.tu_varna.sit.b1.f22621620.source.characters.playercharacter.PlayerCharacter;
import bg.tu_varna.sit.b1.f22621620.source.characters.playercharacter.enums.CharacterClass;
import bg.tu_varna.sit.b1.f22621620.source.exceptions.gameplay.GameHasStartedException;
import bg.tu_varna.sit.b1.f22621620.source.field.generator.Generator;
import bg.tu_varna.sit.b1.f22621620.source.operations.data.GameData;
import bg.tu_varna.sit.b1.f22621620.source.operations.interfaces.ExecutableOperation;

import java.util.Objects;
import java.util.Scanner;

public class Play implements ExecutableOperation {
    @Override
    public void execute() {
        if (!GameData.getInstance().isStarted()) {
            GameData.getInstance().setStarted(true);
            System.out.println("Game started successfully!");

            boolean flag;
            PlayerCharacter player = null;
            Scanner scanner = new Scanner(System.in);
            do {
                System.out.println("Choose your class: (Fighter/Sorcerer/Barbarian)");
                System.out.print("$ ");
                String input = scanner.nextLine().toUpperCase();
                System.out.println();

                switch (input) {
                    case "FIGHTER" -> {
                        player = new PlayerCharacter(CharacterClass.FIGHTER);
                        flag = true;
                    }
                    case "SORCERER" -> {
                        player = new PlayerCharacter(CharacterClass.SORCERER);
                        flag = true;
                    }
                    case "BARBARIAN" -> {
                        player = new PlayerCharacter(CharacterClass.BARBARIAN);
                        flag = true;
                    }
                    default -> flag = false;
                }
            } while (!flag);
            GameData.getInstance().setPlayer(player);

            if (Objects.isNull(GameData.getInstance().getCurrentField())) {
                Generator generator = new Generator();
                generator.generate_level(1);
            }

            System.out.println(GameData.getInstance().getCurrentField());
        } else {
            throw new GameHasStartedException("The game has already been started!");
        }
    }
}
