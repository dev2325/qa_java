import com.example.Cat;
import com.example.Feline;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class CatTest {

    Feline objFeline = new Feline();
    Cat objCat = new Cat(objFeline);

    @Test
    public void getSoundResultTest() {
        Assert.assertEquals("Ожидаемый результат не совпадает с фактическим", "Мяу", objCat.getSound());
    }

    @Test
    public void getFoodReturnTest() throws Exception {
        List<String> expected = List.of("Животные", "Птицы", "Рыба");
        List<String> actual = objCat.getFood();
        Assert.assertEquals("Ожидаемый результат не совпадает с фактическим", expected, actual);
    }
}
