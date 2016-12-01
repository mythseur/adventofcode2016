package Day1;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class ChallengeUn {

    static void challengeUn() {
        try {
            List<String> input = Files.readAllLines(Paths.get(Day1.class.getResource("Input.txt").toURI()));
            Integer x = 0;
            Integer y = 0;

            Direction direction = Direction.NORD;

            List<String> splits = Arrays.asList(input.get(0).split(","));
            splits = splits.stream().map(s -> s.replace(" ", "")).collect(Collectors.toList());

            List<Instruction> instructions = splits.stream().map(s -> new Instruction(s)).collect(Collectors.toList());

            for (Instruction instr : instructions) {
                if (instr.rotation.equals("R")) {
                    direction = Direction.values()[(direction.ordinal() + 1) % 4];
                } else {
                    direction = Direction.values()[(direction.ordinal() + 3) % 4];
                }

                switch (direction) {
                    case NORD:
                        y += instr.walk;
                        break;
                    case EST:
                        x += instr.walk;
                        break;
                    case SUD:
                        y -= instr.walk;
                        break;
                    case OUEST:
                        x -= instr.walk;
                        break;
                }
            }

            System.out.println("Challenge Un : "+(Math.abs(x) + Math.abs(y)));

        } catch (IOException | URISyntaxException e) {
            System.err.println(e.getMessage());
        }
    }
}
