import com.example.Animal;
import com.example.Feline;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class FelineTest {
    @Test
    public void testEatMeat() throws Exception {
        Feline feline = new Feline();
        List<String> result = feline.eatMeat();
        assertEquals(List.of("Животные", "Птицы", "Рыба"), result);
    }
    @Test
    public void testGetFamily(){
        Feline feline = new Feline();
        String result = feline.getFamily();
        assertEquals("Кошачьи", result);
    }
    @Test
    public void testGetFamilyAnimal() {
        Animal animal = new Animal();
        String result = animal.getFamily();
        assertEquals("Существует несколько семейств: заячьи, беличьи, мышиные, кошачьи, псовые, медвежьи, куньи", result);
    }
    @Test
    public void testGetKittens(){
        Feline feline = new Feline();
        int result = feline.getKittens();
        assertEquals(1, result);
    }
    @Test(expected = Exception.class)
    public void testUnknownAnimalKind() throws Exception {
        Feline feline = new Feline();
        feline.getFood("НеизвестныйВид");
    }

}
