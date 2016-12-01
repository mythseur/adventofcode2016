package Day1;

public class Instruction {

    public String rotation;

    public Integer walk;

    public Instruction(String text)
    {
        rotation = text.substring(0,1);
        walk = Integer.parseInt(text.substring(1, text.length()));
    }

}
