import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FirstTest {

    //tworzymy metodę testową z adnotacją test

    @Test //adnotacja test

    public void ex1() { //tworzymy metodę ale NIE statyczną, nie potrzbujemy statycznej bo nie odnosimy się to maina
        System.out.println("hello");
    }

    @Test

    public void ex2() {

        Assertions.assertEquals(123, 123); //asercja typu assertEquals która porównuje czy liczba oczekiwana jest taka jak aktualna
    }

    @Test

    public void ex3() {

        Assertions.assertEquals(true, 3 > 2, "To nie jest prawdą");
    }

    @Test

    public void ex4() {
        String text = "Kot";
        // Assertions.assertEquals(text, text);
        Assertions.assertEquals("Kot", "Kot", "Znaki nie są takie same");
    }

    @Test

    public void ex5() {
        String x = "kotek";
        String y = x.toUpperCase();

        Assertions.assertEquals(x, y);

        // Assertions.assertionEquals("ERYK123", "eryk123".toUpperCase());
    }

    @Test

    public void ex6() {
        int result = addNumbers(3, 6);
        Assertions.assertEquals(9, result, "Sum is not correct");
        //Assertions.assertTrue(9 == result, "Sum is not correct");

    }

    // metoda dodająca dwie liczby całkowite

    private int addNumbers(int a, int b) { // prywatna, wykorzystana tylko w obrębie tej klasy
        return a + b;
    }

    @Test

    public void ex7() {
        double result = poleKola(1);
        Assertions.assertEquals(Math.PI, result, "Pole niepoprawne.");

        //Assertions.assertEquals(Math.PI, poleKola(1)); --> alternatywnie
    }

    private double poleKola(int r) {
        return (Math.PI) * r * r;
    }

    @Test
    public void ex8() {
        String text = "   dowolny tekst    ";
        Assertions.assertEquals("DOWOLNY TEKST", removeSpaces(text));
    }
    private String removeSpaces(String text) {
        return text.trim().toUpperCase();
    }
}
