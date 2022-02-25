import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CircleTest {
    private Circle circle;

//    @Before
//    public void setUp() throws Exception{
//        circle = new Circle(2.1, "Red");
//    }

    @Test
    public void TestGetArea(){
        Circle circle = new Circle(2.1, "red");
        assertEquals((3.1415 * 2.1 * 2.1), circle.getArea(), 0.001);
    }
}
