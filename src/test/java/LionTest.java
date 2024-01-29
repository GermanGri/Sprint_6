import com.example.Feline;
import com.example.Lion;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {
    @Mock
    private Feline felineMock;

    @Test
    public void testGetKittens() throws Exception {
        Lion lion = new Lion("Самка", felineMock);
        when (felineMock.getKittens()).thenReturn(3);
        int result = lion.getKittens();
        assertEquals(3, result);
    }

    @Test
    public void testDoesHaveMane() throws Exception {
        Lion lion = new Lion ("Самец", felineMock);
        boolean result = lion.doesHaveMane();
        assertEquals(true, result);
    }

    @Test(expected = Exception.class)
    public void testInvalidSex() throws Exception{
        Lion lion = new Lion("Пол?", felineMock);
    }

    @Test
    public void testGetFood() throws Exception {
        Lion lion = new Lion("Самка", felineMock);
        List<String> expectedFood = Arrays.asList("Животные", "Птицы", "Рыба");
        when(felineMock.getFood("Хищник")).thenReturn(expectedFood);
        List<String> result = lion.getFood();
        assertEquals(expectedFood, result);

    }



}
