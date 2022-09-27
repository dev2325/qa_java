import com.example.Feline;
import com.example.LionAlex;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

// тесты с использованием заглушки Feline
@RunWith(MockitoJUnitRunner.class)
public class LionAlexTest {

    @Mock
    Feline mockFeline;

    LionAlex objLionAlex;

    @Before
    public void init() throws Exception {
        objLionAlex = new LionAlex(mockFeline);
    }

    @Test
    public void getKittensTest() throws Exception {
        Assert.assertEquals("Ожидаемый результат не совпадает с фактическим", 0, objLionAlex.getKittens());
    }

    @Test
    public void getFoodTest() throws Exception {
        Mockito.when(objLionAlex.getFood()).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        Assert.assertEquals("Ожидаемый результат не совпадает с фактическим", expectedFood, objLionAlex.getFood());
    }

    @Test
    public void getFriendsTest() throws Exception {
        List<String> expectedFriends = List.of("Марти", "Глория", "Мелман");
        Assert.assertEquals("Ожидаемый результат не совпадает с фактическим", expectedFriends, objLionAlex.getFriends());
    }

    @Test
    public void getPlaceOfLivingTest() throws Exception {
        String expectedPlace = "Нью-Йоркский зоопарк";
        Assert.assertEquals("Ожидаемый результат не совпадает с фактическим", expectedPlace, objLionAlex.getPlaceOfLiving());
    }

    @Test
    public void doesHaveManeTest() throws Exception {
        Assert.assertTrue("У Алекса должна быть грива", objLionAlex.doesHaveMane());
    }
}
