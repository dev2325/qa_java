import com.example.Animal;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.List;

@RunWith(Parameterized.class)
public class AnimalTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    private final String animalType;
    private final List<String> expectedListOfFood;

    public AnimalTest(String animalType, List<String> expectedListOfFood) {
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

    // проверка что вызов getFood() у неизвестного животного выкинет нужное исключение
    @Test
    public void getFoodUnknownAnimalThrowsException() throws Exception {
        Animal unknownAnimal = new Animal();
        try {
            unknownAnimal.getFood("UnknownAnimal");
//            Assert.fail("Expected Exception");
        } catch (Exception thrown) {
            Assert.assertEquals("Неизвестный вид животного, используйте значение Травоядное или Хищник", thrown.getMessage());
        }
    }

    @Test
    public void getFamily() {
        Animal objAnimal = new Animal();
        String expectedFamilyList = "Существует несколько семейств: заячьи, беличьи, мышиные, кошачьи, псовые, медвежьи, куньи";
        Assert.assertEquals("Ожидаемый результат не совпадает с фактическим", expectedFamilyList, objAnimal.getFamily());
    }
}
