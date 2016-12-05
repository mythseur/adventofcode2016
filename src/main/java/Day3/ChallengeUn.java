package Day3;

import java.util.List;
import java.util.stream.Collectors;

class ChallengeUn {

    static void challengeUn(List<Triangle> triangles) {
        System.out.println(triangles.stream()
        .filter(Triangle::isValid).collect(Collectors.toList()).size());
    }
}
