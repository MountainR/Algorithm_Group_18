import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestPQSA {
    private static int[] dataset1, dataset2, dataset3;
    @BeforeEach
    public void prepare(){
        dataset1 = HelpMethods.generateDataset(1000000);
        dataset2 = HelpMethods.generateDataset(2000000);
        dataset3 = HelpMethods.generateDataset(5000000);
    }
    @Test
    public void testDataSet1(){
        PQSA.sort(dataset1,1);
        PQSA.sort(dataset1,2);
        PQSA.sort(dataset1,4);
        PQSA.sort(dataset1,8);
    }
    @Test
    public void testDataSet2(){
        PQSA.sort(dataset2,1);
        PQSA.sort(dataset2,2);
        PQSA.sort(dataset2,4);
        PQSA.sort(dataset2,8);
    }
    @Test
    public void testDataSet3(){
        PQSA.sort(dataset3,1);
        PQSA.sort(dataset3,2);
        PQSA.sort(dataset3,4);
        PQSA.sort(dataset3,8);
    }

}
