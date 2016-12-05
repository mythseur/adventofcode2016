package Day3;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Day3 {
    public static void main(String[] args) {
        try {
            List<String> input = Files.readAllLines(Paths.get(Day3.class.getResource("Input.txt").toURI()));
            List<Triangle> triangles = input.stream().map(Day3::parseTriangle).collect(Collectors.toList());
            List<Triangle> trianglesDeux = parseTriangle(input);
            ChallengeUn.challengeUn(triangles);
            ChallengeUn.challengeUn(trianglesDeux);

        } catch (IOException | URISyntaxException e) {
            System.err.println(e.getMessage());
        }

    }

    private static Triangle parseTriangle(String s) {
        Triangle res_l = new Triangle();

         Arrays.stream(s.trim().split("( )+"))
                .map(Integer::parseInt).forEach(res_l::addCote);
         return res_l;
    }

    private static List<Triangle> parseTriangle (List<String> lines)
    {
        List<Triangle> res_l = new ArrayList<Triangle>();
        for (int i = 0; i < lines.size(); i = i+3)
        {
            List<Triangle> temp_l = new ArrayList<Triangle>();
            temp_l.add(new Triangle());
            temp_l.add(new Triangle());
            temp_l.add(new Triangle());
            for(int j = i; j < i+3; j++)
            {
                String[] a = lines.get(j).trim().split("( )+");
                temp_l.get(0).addCote(Integer.parseInt(a[0]));
                temp_l.get(1).addCote(Integer.parseInt(a[1]));
                temp_l.get(2).addCote(Integer.parseInt(a[2]));
            }

            temp_l.forEach(res_l::add);
        }

        return res_l;
    }
}
