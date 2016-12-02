package Day2;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Day2 {

    public static void main(String[] args) {
        try {
            List<String> input = Files.readAllLines(Paths.get(Day2.class.getResource("Input.txt").toURI()));
            List<List<Instruction>> instructions = input.stream()
                    .map(Day2::parse).collect(Collectors.toList());
            ChallengeUn.challengeUn(instructions);
            ChallengeDeux.challengeDeux(instructions);

        } catch (IOException | URISyntaxException e) {
            System.err.println(e.getMessage());
        }

    }

    private static List<Instruction> parse(String s) {
        return Arrays.stream(s.split(""))
                .map(Day2::writeCharacter).collect(Collectors.toList());
    }

    private static Instruction writeCharacter(String s) {
        switch (s)
        {
            case "U":
                return Instruction.UP;
            case "L":
                return Instruction.LEFT;
            case "R":
                return Instruction.RIGHT;
            case "D":
                return Instruction.DOWN;
            default:
                return null;
        }
    }
}
