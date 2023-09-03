package guru.qa;

import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ArchiveTest {

    ClassLoader cl =ArchiveTest.class.getClassLoader();

    @Test
    void addToArchive() throws IOException {
        String
                file1="CSVFile.csv",
                file2="Excel.xls";

        List<String> srcFiles = Arrays.asList(file1,file2);

        FileOutputStream fos = new FileOutputStream("multiCompressed.zip");
        ZipOutputStream zipOut = new ZipOutputStream(fos);
        for (String srcFile : srcFiles) {
            File fileToZip = new File(srcFile);
           // FileInputStream fis = new FileInputStream(fileToZip);
            InputStream fis =cl.getResourceAsStream(srcFile);
            ZipEntry zipEntry = new ZipEntry(fileToZip.getName());
            zipOut.putNextEntry(zipEntry);

            byte[] bytes = new byte[1024];
            int length;
            while((length = fis.read(bytes)) >= 0) {
                zipOut.write(bytes, 0, length);
            }
            fis.close();
        }
        zipOut.close();
        fos.close();
    }

    @Test
    void addToArchiveWTR() throws IOException {
        String
                file1="CSVFile.csv",
                file2="Excel.xls";

        List<String> srcFiles = Arrays.asList(file1,file2);

        try( FileOutputStream fos = new FileOutputStream("multiCompressed.zip");
        ZipOutputStream zipOut = new ZipOutputStream(fos)){

        for (String srcFile : srcFiles) {
            File fileToZip = new File(srcFile);
            //FileInputStream fis = new FileInputStream(fileToZip);
           try(InputStream fis =cl.getResourceAsStream(srcFile)){
            ZipEntry zipEntry = new ZipEntry(fileToZip.getName());
            zipOut.putNextEntry(zipEntry);

            byte[] bytes = new byte[1024];
            int length;
            while((length = fis.read(bytes)) >= 0) {
                zipOut.write(bytes, 0, length);
            }}

        }}

    }



    }


