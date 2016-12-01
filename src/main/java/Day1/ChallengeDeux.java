package Day1;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ChallengeDeux {

    static Integer x = 0;
    static Integer y = 0;

    static void challengeDeux()
    {

        try {
            String input = Files.readAllLines(Paths.get(Day1.class.getResource("Input.txt").toURI())).get(0);
            List<String> splits = Arrays.asList(input.split(","));
            splits = splits.stream().map(s -> s.replace(" ", "")).collect(Collectors.toList());
            List<Instruction> instructions = splits.stream().map(s -> new Instruction(s)).collect(Collectors.toList());

            List<Point> passes = new ArrayList<>();

            Direction direction = Direction.NORD;

            for (Instruction instr : instructions) {
                if (instr.rotation.equals("R")) {
                    direction = Direction.values()[(direction.ordinal() + 1) % 4];
                } else {
                    direction = Direction.values()[(direction.ordinal() + 3) % 4];
                }

                boolean stop;
                switch (direction) {
                    case NORD:
                        stop = walk(false, instr.walk, passes);
                        break;
                    case EST:
                        stop = walk(true, instr.walk, passes);
                        break;
                    case SUD:
                        stop = walk(false, -instr.walk, passes);
                        break;
                    case OUEST:
                        stop = walk(true, -instr.walk, passes);
                        break;
                    default:
                        stop = false;
                }

                if(stop)
                    break;

            }

            System.out.println("Challenge Deux : "+(Math.abs(x) + Math.abs(y)));
        } catch (IOException | URISyntaxException e) {
            System.err.println(e.getMessage());
        }
    }

    private static boolean walk(boolean moveX, Integer walk, List<Point> passes) {

        for(int i = 0; i < Math.abs(walk); i++)
        {
            if(moveX)
            {
                x += walk < 0 ? -1 : 1;
            }
            else
            {
                y += walk < 0 ? -1 : 1;
            }

            if(passes.contains(new Point(x, y)))
            {
                return true;
            }

            passes.add(new Point(x,y));
        }

        return false;
    }
}
