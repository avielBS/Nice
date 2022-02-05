import DAUManagment.DAUHolder;
import Data.Dau;
import DataProvider.FileDataProvider;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.HashSet;

public class Tests {

    FileDataProvider fileDataProvider;
    DAUHolder dauHolder;

    @Before
    public void setUp(){ }

    @After
    public void tearDown(){
        dauHolder.reset();
    }

    @Test
    @DisplayName("Check when file not exist")
    public void TestCaseWhenFileNotFound(){

        fileDataProvider = new FileDataProvider("src/main/resources/DAU1.txt");
        dauHolder = DAUHolder.getInstance();
        dauHolder.addDau(fileDataProvider.provideDau());

        HashSet<Dau> actual = this.dauHolder.getDauByDate("01/01/2020");
        Assert.assertEquals(0, actual.size());

    }

    @Test
    @DisplayName("Check when date not exist")
    public void TestCaseWhenDateNotExist(){

        fileDataProvider = new FileDataProvider("src/main/resources/DAU.txt");
        dauHolder = DAUHolder.getInstance();
        dauHolder.addDau(fileDataProvider.provideDau());

        HashSet<Dau> actual = this.dauHolder.getDauByDate("01/01/2022");
        Assert.assertEquals(0, actual.size());

    }

    @ParameterizedTest
    @CsvSource({"01/01/2020,3", "02/01/2020,2","03/01/2020,2"})
    public void TestCaseParamtizedMainFlow(String date, int expectedSize){

        fileDataProvider = new FileDataProvider("src/main/resources/DAU.txt");
        dauHolder = DAUHolder.getInstance();
        dauHolder.addDau(fileDataProvider.provideDau());

        HashSet<Dau> actual = this.dauHolder.getDauByDate(date);
        Assert.assertEquals(expectedSize, actual.size());

    }


}
