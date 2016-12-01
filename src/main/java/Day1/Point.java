package Day1;

import java.util.Objects;

public class Point {

    public Integer x;

    public Integer y;

    Point(Integer x , Integer y)
    {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Point)
        {
            Point pt = (Point) obj;
            return Objects.equals(pt.x, x) && Objects.equals(pt.y, y);
        }
        return false;
    }
}
