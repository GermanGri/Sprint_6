import com.example.Cat;
import com.example.Feline;
import com.example.Predator;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CatTest {
    @Test
    public void testGetSound(){
        Feline felineMock = mock(Feline.class);
        Cat cat = new Cat(felineMock);
        String result = cat.getSound();
        assertEquals("Мяу", result);
    }

    @Test
    public  void testGetFood() throws Exception {
        Predator predatorMock = mock(Predator.class);
        Cat cat = new Cat(predatorMock);
        when(predatorMock.eatMeat()).thenReturn(List.of("Мясо"));
        List<String> result = cat.getFood();
        assertEquals(List.of("Мясо"),result);

    }

}
