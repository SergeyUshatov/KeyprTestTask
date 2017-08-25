package utils;

import model.*;
import testData.TestData;

import javax.xml.bind.annotation.adapters.HexBinaryAdapter;
import java.io.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.CRC32;
import java.util.zip.Checksum;

import static com.sun.tools.javac.util.Constants.format;

public class Utils {

    public static byte[] createChecksum(String filename) throws
            Exception
    {
        InputStream fis =  new FileInputStream(filename);

        byte[] buffer = new byte[1024];
        MessageDigest complete = MessageDigest.getInstance("SHA1");
        int numRead;
        do {
            numRead = fis.read(buffer);
            if (numRead > 0) {
                complete.update(buffer, 0, numRead);
            }
        } while (numRead != -1);
        fis.close();
        return complete.digest();
    }

    // a byte array to a HEX string
    public static String getSHA1Checksum(String filename) throws Exception {
        byte[] b = createChecksum(filename);
        String result = "";
        for (int i=0; i < b.length; i++) {
            result +=
                    Integer.toString( ( b[i] & 0xff ) + 0x100, 16).substring( 1 );
        }
        return result;
    }

    public static String prepareFile() throws IOException {
        // For output to file
        String path = "./src/main/java/testData/fileForTestCommits";
        File file = new File(path);

        if (!file.exists()) {
            file.createNewFile();
        }
        FileWriter fw = new FileWriter(file.getAbsoluteFile(), true);
        BufferedWriter bw = new BufferedWriter(fw);
        String testData = localTime();
        bw.append(testData);
        bw.newLine();
        bw.close();
        return path;
    }

    public static String localTime() {
        return LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME);
    }


}

