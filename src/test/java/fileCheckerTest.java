import java.io.File;
import java.io.FileInputStream;
import java.io.IOError;
import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.Scanner;
import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.extractor.WordExtractor;

public class fileCheckerTest {


    public static void fileChecker(File file1, File file2) {
        try {

            FileInputStream fis = new FileInputStream(file1.getAbsolutePath());

            HWPFDocument doc = new HWPFDocument(fis);

            WordExtractor we = new WordExtractor(doc);

            String[] paragraphs = we.getParagraphText();

            System.out.println("Total no of paragraph "+paragraphs.length);
            for (int i = 4; i < paragraphs.length; i ++) {

                System.out.println(paragraphs[i]);
            }


//
//            FileInputStream fis = new FileInputStream(file1);
//            HWPFDocument doc = new HWPFDocument(fis);
//            WordExtractor extractor = new WordExtractor(doc);
//            String text = extractor.getText();
//            System.out.println(text.substring(2000));
//            FileInputStream fis2 = new FileInputStream(file2);
//            HWPFDocument doc2 = new HWPFDocument(fis2);
//            WordExtractor extractor1 = new WordExtractor(doc2);
//            String text2 = extractor1.getText();
//            System.out.println(text2.substring(2000));
//            System.out.println(text.substring(2000).equals(text2.substring(2000)));
//            byte[] fileBuytes1 = Files.readAllBytes(file1.toPath());
//            byte[] fileBuytes2 = Files.readAllBytes(file2.toPath());
////            fileBuytes1 = reverse(fileBuytes1);
//            fileBuytes2 = reverse(fileBuytes2);
//            Scanner scanner = new Scanner(file1);
//            Scanner scanner1 = new Scanner(file2);
//            while (scanner.hasNextLine()){
//                System.out.println(scanner.nextLine());
//            }

//            byte[] subBytes1 = Arrays.copyOfRange(fileBuytes1, 0,100000);
//
//            byte[] subBytes2 = Arrays.copyOfRange(fileBuytes2, 0,100000);


//            System.out.println(fileBuytes1.length);
//            System.out.println(fileBuytes2.length);
//            System.out.println(Arrays.equals(fileBuytes1,fileBuytes2));
//            System.out.println(subBytes1.length);
//            System.out.println(subBytes2.length);
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }





    public static void main ( String[] args ) {
        File file1 = new File("D:\\Java\\Files\\file12.doc");
        File file2 = new File("D:\\Java\\Files\\file22.doc");
        fileChecker(file1, file2);

    }
}
