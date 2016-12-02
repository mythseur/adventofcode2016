package Day2;

import java.util.List;

class ChallengeUn {
    static void challengeUn(List<List<Instruction>> instructions) {
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

    static class Clavier {
        private int[][] keypad = {{1,2,3},{4,5,6},{7,8,9}};
        private int posx = 1;
        private int posy = 1;

        int getPosition() {
            return keypad[posy][posx];
        }

        void toLeft()
        {
            if(posx != 0)
            {
                posx--;
            }
        }
        void toRight()
        {
            if(posx !=2)
            {
                posx++;
            }
        }
        void toUp()
        {
            if(posy != 0)
            {
                posy--;
            }
        }
        void toDown()
        {
            if(posy != 2)
            {
                posy++;
            }
        }
    }
}
