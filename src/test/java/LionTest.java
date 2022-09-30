import com.example.Feline;
import com.example.Lion;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

// тесты реального объекта Lion
public class LionTest {

    Feline objFeline = new Feline();
    Lion objLion = new Lion(objFeline, "Самец");

    public LionTest() throws Exception {
    }

    // проверка что создание льва с неизвестным полом выкинет исключение
    @Test
    public void createNewLionUnknownGenderThrowsException() throws Exception {
        try {
            Lion unknownLion = new Lion(objFeline, "UnknownGender");
            Assert.fail("Expected Exception");
        } catch (Exception thrown) {
            Assert.assertEquals("Используйте допустимые значения пола животного - самец или самка", thrown.getMessage());
        }
    }

    @Test
    public void getKittensTest() {
        Assert.assertEquals("Ожидаемый результат не совпадает с фактическим", 1, objLion.getKittens());
    }

    @Test
    public void getFoodTest() throws Exception {
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        Assert.assertEquals("Ожидаемый результат не совпадает с фактическим", expectedFood, objLion.getFood());
    }
}
