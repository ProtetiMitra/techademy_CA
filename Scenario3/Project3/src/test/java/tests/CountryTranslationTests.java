package tests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.ExcelUtils;

import java.io.File;
import java.io.IOException;

public class CountryTranslationTests {
    private static final String BASE_URL = "https://restcountries.com/v3.1/translation/";
    private static final String EXCEL_PATH = "C:\\Users\\91747\\OneDrive\\Desktop\\CountryTranslations.xlsx";
    private static final String SHEET_NAME = "Translations";
    private ExcelUtils excelUtils;

    @BeforeClass
    public void setup() throws IOException {
        String filePath = System.getProperty("user.dir") + "/src/main/resources/CountryTranslations.xlsx";

        System.out.println("Loading Excel File from: " + filePath);
        File file = new File(filePath);
        System.out.println("Excel File Path: " + file.getAbsolutePath());
        System.out.println("File Exists: " + file.exists());

        excelUtils = new ExcelUtils(filePath, "Translations");
    }

    @DataProvider(name = "countryTranslations")
    public Object[][] getCountryTranslations() {
        int rowCount = excelUtils.getRowCount();
        Object[][] data = new Object[rowCount - 1][1];
        for (int i = 1; i < rowCount; i++) {
            data[i - 1][0] = excelUtils.getCellData(i, 0);
        }
        return data;
    }

    @Test(dataProvider = "countryTranslations")
    public void testCountryTranslation(String translation) {
        String url = "https://restcountries.com/v3.1/translation/" + translation;
        Response response = RestAssured.get(url);

        System.out.println("Checking translation: " + translation);
        System.out.println("Response: " + response.getBody().asString());

        Assert.assertEquals(response.statusCode(), 200, "Translation not found: " + translation);
    }
}
