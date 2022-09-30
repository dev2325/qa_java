import com.example.Animal;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.List;

@RunWith(Parameterized.class)
public class AnimalParamTest {

    private final String animalType;
    private final List<String> expectedListOfFood;

    public AnimalParamTest(String animalType, List<String> expectedListOfFood) {
        this.animalType = animalType;
        this.expectedListOfFood = expectedListOfFood;
    }

    @Parameterized.Parameters
    public static Object[] getTestData() {
        return new Object[][]{
                {"Травоядное", List.of("Трава", "Различные растения")},
                {"Хищник", List.of("Животные", "Птицы", "Рыба")},
        };
    }

    @Test
    public void getFoodTest() throws Exception {
        Animal objAnimal = new Animal();
        Assert.assertEquals("Ожидаемый результат не совпадает с фактическим", expectedListOfFood, objAnimal.getFood(animalType));
    }
}
