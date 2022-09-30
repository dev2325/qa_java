import com.example.Animal;
import org.junit.Assert;
import org.junit.Test;

public class AnimalTest {

    // проверка что вызов getFood() у неизвестного животного выкинет нужное исключение
    @Test
    public void getFoodUnknownAnimalThrowsException() throws Exception {
        Animal unknownAnimal = new Animal();
        try {
            unknownAnimal.getFood("UnknownAnimal");
            Assert.fail("Expected Exception");
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
