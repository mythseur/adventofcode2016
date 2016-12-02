package Day2;

import java.util.Arrays;
import java.util.List;

public class ChallengeDeux {

    static void challengeDeux(List<List<Instruction>> instructions)
    {
        Clavier clavier = new Clavier();
        String code = "";
        for (List<Instruction> line : instructions)
        {
            for(Instruction instruction : line)
            {
                switch (instruction)
                {
                    case UP:
                        clavier.toUp();
                        break;
                    case DOWN:
                        clavier.toDown();
                        break;
                    case LEFT:
                        clavier.toLeft();
                        break;
                    case RIGHT:
                        clavier.toRight();
                        break;
                }
            }
            code+=clavier.getPosition();
        }
        System.out.println(code);
    }
    static class Clavier{
        List<List<String>> keypad = Arrays.asList(
                Arrays.asList(null,null,"1",null,null),
                Arrays.asList(null,"2","3","4", null),
                Arrays.asList("5","6","7","8","9"),
                Arrays.asList(null,"A","B","C",null),
                Arrays.asList(null,null,"D",null,null)
        );

        private int posx = 0;
        private int posy = 2;

        String getPosition() {
            return keypad.get(posy).get(posx);
        }

        void toLeft()
        {
            if(posx != 0 && keypad.get(posy).get(posx-1)!=null)
            {
                posx--;
            }
        }
        void toRight()
        {
            if(posx !=4 && keypad.get(posy).get(posx+1) != null)
            {
                posx++;
            }
        }
        void toUp()
        {
            if(posy != 0 && keypad.get(posy-1).get(posx) != null)
            {
                posy--;
            }
        }
        void toDown()
        {
            if(posy != 4 && keypad.get(posy+1).get(posx) != null)
            {
                posy++;
            }
        }

    }
}
