import com.example.Feline;
import com.example.Lion;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.List;

// тесты с использованием заглушки Feline
@RunWith(Parameterized.class)
public class LionMockTest {

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Mock
    Feline mockFeline;

    private final String sex;

    public LionMockTest(String sex) throws Exception {
        this.sex = sex;
    }

    @Parameterized.Parameters
    public static Object[] getTestData() {
        return new Object[][]{
                {"Самец"},
                {"Самка"},
        };
    }

    @Test
    public void getKittensTest() throws Exception {
        Lion testLion = new Lion(mockFeline, sex);
        Mockito.when(testLion.getKittens(5)).thenReturn(5);
        Assert.assertEquals("Ожидаемый результат не совпадает с фактическим", 5, testLion.getKittens(5));
    }

    @Test
    public void getFoodTest() throws Exception {
        Lion testLion = new Lion(mockFeline, sex);
        Mockito.when(testLion.getFood()).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        Assert.assertEquals("Ожидаемый результат не совпадает с фактическим", expectedFood, testLion.getFood());
    }
}
