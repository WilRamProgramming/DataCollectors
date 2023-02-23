import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import org.apache.commons.io.FileUtils;
import java.io.File;
import java.io.IOException;
import java.net.URL;

public class ImageScraper {
  public static void main(String[] args) throws IOException, TesseractException {


//      // Set up Tesseract OCR you will need to download Tesseract to your local from sourceforge
//      Tesseract tesseract = new Tesseract();
//      tesseract.setDatapath("C:\\Users\\ATUM\\Desktop\\Tess4J\\tessdata");
//
//      // Read the image
//      File imageFile = new File("C:\\Users\\ATUM\\Desktop\\TBS_Images\\Test_Image"); //path to local image file
//      String imageText = tesseract.doOCR(imageFile);

    try {
      // Initialize Tesseract
      Tesseract tesseract = new Tesseract();
      tesseract.setDatapath("C:\\Users\\ATUM\\Desktop\\Tess4J\\tessdata");

      // Read the .jpg file from the website
      URL url = new URL("<img src=\"https://i0.wp.com/www.cssscript" +    //url of .jpg file
              ".com/wp-content/uploads/2021/02/Convert-Regular-HTML-Tables-Into-Datatables-js-datatable.png?fit=1018%2C621&amp;ssl=1\"");
      File imageFile = new File("C:\\Users\\ATUM\\Desktop\\TBS_Images");
      FileUtils.copyURLToFile(url, imageFile);

      // Perform OCR on the image file
      String result = tesseract.doOCR(imageFile);
      System.out.println(result);

    } catch (TesseractException e) {
      System.err.println(e.getMessage());
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
//  //   how to loop through an undetermined amount of rows  still working on this
//      String[] lines = imageText.split("\\r?\\n");
//      String columnName = lines[0];
//      List<String> rowValues = new ArrayList<String>();
//
//      for (int i = 1; i < lines.length; i++) {
//        rowValues.add(lines[i]);
//      }
//
//  //  Convert the rowValues list to an array if needed
//      String[] rowsArray = rowValues.toArray(new String[0]);


//      // Store the data in a CSV file
//      // You may need to download opencsv in order to make csvWriter and FileWriter work.
//      FileWriter writer = new FileWriter("C:\\Users\\ATUM\\Desktop\\CSV_Output_Folder\\Test_File.csv"); //path to
//      // local output .csv file
//
//      CSVWriter csvWriter = new CSVWriter(writer);
//      csvWriter.writeNext(new String[] { "columnName", "rowOne", "rowTwo", "rowThree" });
//      csvWriter.writeNext(new String[] {  columnName, rowOne, rowTwo, rowThree });
//      csvWriter.close();
//    }
//  }























// Extract the data
//      String[] lines = imageText.split("\\r?\\n");
//      String  columnName = lines[0];
//      String rowOne = lines[1];
//      String rowTwo = lines[2];
//      String rowThree = lines[3];

//  // looping through it
//      String[] lines = imageText.split("\\r?\\n");
//      String columnName = lines[0];
//      String[] rowValues = new String[3];
//
//      for (int i = 1; i < 4; i++) {
//        rowValues[i-1] = lines[i];
//      }
//
//      String rowOne = rowValues[0];
//      String rowTwo = rowValues[1];
//      String rowThree = rowValues[2];
//