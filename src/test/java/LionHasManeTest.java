import com.example.Feline;
import com.example.Lion;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class LionParamTest {

    Feline feline;

    private final String sex;
    private final boolean hasMane;

    public LionParamTest(String sex, boolean hasMane) {
        this.sex = sex;
        this.hasMane = hasMane;
    }

    @Parameterized.Parameters
    public static Object[] getTestData() {
        return new Object[][]{
                {"Самец", true},
                {"Самка", false},
        };
    }

    @Test
    public void presenceOfManeTest() throws Exception {
        Lion testLion = new Lion(feline, sex);
        Assert.assertEquals(hasMane, testLion.doesHaveMane());
    }
}
