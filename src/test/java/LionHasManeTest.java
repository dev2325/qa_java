import com.example.Feline;
import com.example.Lion;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

@RunWith(Parameterized.class)
public class LionHasManeTest {

    @Mock
    Feline feline;

    private final String sex;
    private final boolean hasMane;

    public LionHasManeTest(String sex, boolean hasMane) {
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

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void presenceOfManeTest() throws Exception {
        Lion testLion = new Lion(feline, sex);
        Assert.assertEquals("Ожидаемый результат не совпадает с фактическим", hasMane, testLion.doesHaveMane());
    }
}
