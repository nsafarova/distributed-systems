package ada;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class Download2 implements Runnable{

    String file2;
    File output2;

    public Download2(String file2, File output2) {
        this.file2 = file2;
        this.output2 = output2;
    }

    @Override
    public void run() {

        try {
            URL url = new URL(file2);
            HttpURLConnection http = (HttpURLConnection)url.openConnection();
            http.addRequestProperty("User-Agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_6) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/86.0.4240.111 Safari/537.36");
            BufferedInputStream in = new BufferedInputStream(http.getInputStream());
            FileOutputStream fos =  new FileOutputStream(this.output2);
            BufferedOutputStream out = new BufferedOutputStream(fos, 1024);
            byte[] buffer = new byte[1024];
            int read = 0;
            while((read = in.read(buffer, 0, 1024)) >= 0) {
                out.write(buffer, 0, read);
            }

            out.close();
            in.close();
            System.out.print("file2 -> done, ");
        }

        catch (IOException e) {
            e.printStackTrace();
        }

    }
}
