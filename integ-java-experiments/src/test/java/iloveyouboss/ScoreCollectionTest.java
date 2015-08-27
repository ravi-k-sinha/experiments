package iloveyouboss;

import org.hamcrest.CoreMatchers;
import org.junit.Test;
import static org.junit.Assert.*;

public class ScoreCollectionTest {

    @Test
    public void answersArithmeticMeanOfTwoNumbers() {
        //Arrange
        ScoreCollection collection = new ScoreCollection();
        collection.addScoreable(() -> 5);
        collection.addScoreable(() -> 7);
        
        // Act
        int actualResult = collection.arithmeticMean();
        
        // Assert
        assertThat(actualResult, CoreMatchers.equalTo(6));
    }
    
}
