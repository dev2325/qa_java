import com.example.Feline;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

// тесты реального объекта Feline
public class FelineTest {

    Feline objFeline = new Feline();

    @Test
    public void eatMeatTest() throws Exception {
        List<String> expected = List.of("Животные", "Птицы", "Рыба");
        List<String> actual = objFeline.eatMeat();
        Assert.assertEquals("Ожидаемый результат не совпадает с фактическим", expected, actual);
    }

    @Test
    public void getFamilyTest() {
        Assert.assertEquals("Ожидаемый результат не совпадает с фактическим", "Кошачьи", objFeline.getFamily());
    }

    @Test
    public void getKittensTest() {
        Assert.assertEquals("Ожидаемый результат не совпадает с фактическим", 1, objFeline.getKittens());
    }

    @Test
    public void getKittensWithArgumentTest() {
        Assert.assertEquals("Ожидаемый результат не совпадает с фактическим", 10, objFeline.getKittens(10));
    }
}
