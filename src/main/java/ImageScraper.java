import com.opencsv.CSVWriter;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

  public class ImageScraper {
    public static void main(String[] args) throws IOException, TesseractException {
      // Set up Tesseract OCR you will need to download Tesseract to your local from sourceforge
      Tesseract tesseract = new Tesseract();
      tesseract.setDatapath("C:\\Users\\ATUM\\Desktop\\Tess4J\\tessdata");

      // Read the image
      File imageFile = new File("C:\\Users\\ATUM\\Desktop\\TBS_Images\\Test_Image"); //path to local image file
      String imageText = tesseract.doOCR(imageFile);

      // Extract the data
      String[] lines = imageText.split("\\r?\\n");
      String  columnName = lines[0];
      String rowOne = lines[1];
      String rowTwo = lines[2];
      String rowThree = lines[3];

      // Store the data in a CSV file
      // You may need to download opencsv in order to make csvWriter and FileWriter to work
      FileWriter writer = new FileWriter("C:\\Users\\ATUM\\Desktop\\CSV_Output_Folder\\Test_File.csv"); //path to 
      // local output .csv file

      CSVWriter csvWriter = new CSVWriter(writer);
      csvWriter.writeNext(new String[] { "columnName", "rowOne", "rowTwo", "rowThree" });
      csvWriter.writeNext(new String[] {  columnName, rowOne, rowTwo, rowThree });
      csvWriter.close();
    }
  }

