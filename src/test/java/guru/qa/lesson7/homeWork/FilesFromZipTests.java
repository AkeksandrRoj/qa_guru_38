package guru.qa.lesson7.homeWork;

import com.codeborne.pdftest.PDF;
import com.codeborne.xlstest.XLS;
import com.opencsv.CSVReader;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class FilesFromZipTests {
    private ClassLoader cl = FilesFromZipTests.class.getClassLoader();

    @Test
    void pdfFromZipTest() throws Exception {
        boolean found = false;
        try (InputStream is = cl.getResourceAsStream("data.zip");
             ZipInputStream zis = new ZipInputStream(is)) {
            ZipEntry entry;
            while ((entry = zis.getNextEntry()) != null) {
                found = true;
                if (entry.getName().endsWith("pdf")) {
                    PDF pdf = new PDF(zis);
                    Assertions.assertTrue(pdf.text.contains("Не изнуряй себя, чтобы разбогатеть"),
                            "Не нашел фразу в PDF"
                    );
                }
            }
        }
        Assertions.assertTrue(found, "PDF файла нет в архиве");
    }


    @Test
    void xlsFromZipTest() throws Exception {
        boolean found = false;
        try (InputStream is = cl.getResourceAsStream("data.zip");
             ZipInputStream zis = new ZipInputStream(is)) {
            ZipEntry entry;
            while ((entry = zis.getNextEntry()) != null) {
                if (entry.getName().endsWith("xls") || entry.getName().endsWith("xlsx")) {
                    found = true;
                    XLS xls = new XLS(zis);
                    String actualValue = xls.excel.getSheetAt(0).getRow(34).getCell(2).getStringCellValue();
                    Assertions.assertTrue(actualValue.contains("Ashish"),
                            "Не нашел значение"
                    );
                }
            }
        }
        Assertions.assertTrue(found, "XLS-файл не найден в архиве");
    }

    @Test
    void csvFromZipTest() throws Exception {
        boolean found = false;
        try (InputStream is = cl.getResourceAsStream("data.zip");
             ZipInputStream zis = new ZipInputStream(is)) {
            ZipEntry entry;
            while ((entry = zis.getNextEntry()) != null) {
                if (entry.getName().endsWith("csv")) {
                    found = true;
                    CSVReader csvReader = new CSVReader(new InputStreamReader(zis));
                    List<String[]> data = csvReader.readAll();

                    Assertions.assertEquals(3, data.size(),
                            "Количество строк не совпадает");
                    Assertions.assertArrayEquals(
                            new String[]{"МегаМаркет", "https://megamarket.ru/landing/oplata-chastyami/"},
                            data.get(0)
                    );
                    Assertions.assertArrayEquals(
                            new String[]{"Купер", "https://kuper.ru/landings/bnpl"},
                            data.get(1)
                    );
                    Assertions.assertArrayEquals(
                            new String[]{"Отелло", "https://platichastyami.otello.ru/"},
                            data.get(2)
                    );
                }
            }
        }
        Assertions.assertTrue(found, "CSV файла нет в архиве");
    }
}





