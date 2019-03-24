package helpers;

import com.google.common.io.Files;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class ZipReader {

    public static void unpackZip ( String path ) throws IOException {
        String date = new SimpleDateFormat("yyyy-MM-dd-hh-mm-ss-SS").format(new Date());



        try (ZipInputStream zin = new ZipInputStream(new FileInputStream(path))) {
            ZipEntry entry;
            String name;
            long size;

            while( (entry = zin.getNextEntry()) != null ) {

                name = entry.getName(); // получим название файла
                size = entry.getSize();  // получим его размер в байтах
                System.out.printf("File name: %s \t File size: %d \n", name, size);

                // распаковка
                FileOutputStream fout = new FileOutputStream("E:\\IE downloads\\" + name);
                for(int c = zin.read(); c != -1; c = zin.read()) {
                    fout.write(c);
                }
                fout.flush();
                zin.closeEntry();
                fout.close();
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

    }

    public static void readFileFromZip ( String path ) throws IOException {
        ZipInputStream zis = new ZipInputStream(new FileInputStream(path));
        ZipEntry entry;

        while( (entry = zis.getNextEntry()) != null ) {
            System.out.println("entry: " + entry.getName() + ", " + entry.getSize());
            Scanner sc = new Scanner(zis);

            while( sc.hasNextLine() ) { //проверяем на наличие следующей строки
                System.out.println(sc.nextLine()); //печатаем строку
            }
        }

    }

    public static void main ( String[] args ) throws IOException {
        unpackZip("E:\\IE downloads\\report.zip");
        readFileFromZip("E:\\IE downloads\\PAY.zip");
        readFileFromZip("E:\\IE downloads\\RET.zip");
        readFileFromZip("E:\\IE downloads\\REP.zip");
    }

}
