import com.example.Feline;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class ParametrizedFelineTest {

    @Parameterized.Parameter(0)
    public String animalKind;
    @Parameterized.Parameter(1)
    public List<String> expectedFood;

    @Parameterized.Parameters(name = "{index}: Feline's food for {0} is {1}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                { "Травоядное", Arrays.asList("Трава", "Различные растения") },
                { "Хищник", Arrays.asList("Животные", "Птицы", "Рыба") },
        });
    }
    @Test
    public void testGetFood() throws Exception {
        Feline feline = new Feline();
        List<String> result = feline.getFood(animalKind);
        assertEquals(expectedFood, result);
    }
}



