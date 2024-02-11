import com.example.Feline;
import com.example.Lion;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(Parameterized.class)
public class ParametrizedLionTest {
    @Parameterized.Parameter(0)
    public String sex;

    @Parameterized.Parameter(1)
    public int expectedKittens;

    @Parameterized.Parameter(2)
    public boolean expectedHasMane;

    @Parameterized.Parameters(name = "{index}: Lion's sex is {0}, expected kittens count is {1}, and expected hasMane is {2}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                { "Самка", 3, false },
                { "Самец", 1, true },
        });
    }

    @Test
    public void testGetKittens() throws Exception {
        Feline felineMock = Mockito.mock(Feline.class);
        Lion lion = new Lion(sex, felineMock);
        when (felineMock.getKittens()).thenReturn(expectedKittens);
        int result = lion.getKittens();
        assertEquals(expectedKittens, result);
    }

    @Test
    public void testDoesHaveMane() throws Exception {
        Feline felineMock = new Feline();
        Lion lion = new Lion(sex, felineMock);
        boolean result = lion.doesHaveMane();
        assertEquals(expectedHasMane, result);
    }

    @Test
    public void testGetFood() throws Exception {
        Feline felineMock = Mockito.mock(Feline.class);
        Lion lion = new Lion(sex, felineMock);
        List<String> expectedFood = Arrays.asList("Животные", "Птицы", "Рыба");
        when(felineMock.getFood("Хищник")).thenReturn(expectedFood);
        List<String> result = lion.getFood();
        assertEquals(expectedFood, result);
    }
}
