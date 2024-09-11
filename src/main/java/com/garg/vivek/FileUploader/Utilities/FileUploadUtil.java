package com.garg.vivek.FileUploader.Utilities;

import org.springframework.stereotype.Service;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

@Service
public class FileUploadUtil {
    public static void uploadFile(String preSignedUrl, String filePath) throws IOException {
        FileInputStream fileInputStream = null;
        HttpURLConnection connection = null;

        try {
            URL url = new URL(preSignedUrl);
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("PUT");
            connection.setDoOutput(true);

            fileInputStream = new FileInputStream(filePath);
            OutputStream outputStream = connection.getOutputStream();

            byte[] buffer = new byte[4096];
            int bytesRead;
            while ((bytesRead = fileInputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }

            outputStream.flush();
            int responseCode = connection.getResponseCode();
            if (responseCode != HttpURLConnection.HTTP_OK) {
                throw new IOException("Upload failed. Response Code: " + responseCode);
            }
        } finally {
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            if (connection != null) {
                connection.disconnect();
            }
        }
    }
}
