import java.io.DataOutputStream;
import java.net.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.nio.charset.StandardCharsets;
public class Main {
    static String allpostIds;
    static String[] separate;
    static int x=0;
    public static void main(String[] args) throws IOException, InterruptedException {
        String url2 = "https://api.byte.co/feed/global";
        URL obj2 = new URL(url2);
        HttpURLConnection con2 = (HttpURLConnection) obj2.openConnection();
        con2.setDoInput(true);
        con2.setRequestProperty("User-Agent", "byte/0.2 (co.byte.video; build:145; iOS 13.3.0) Alamofire/4.9.1");
        con2.setRequestProperty("Authorization", "");
        StringBuilder content2;
        try (BufferedReader in2 = new BufferedReader(new InputStreamReader(con2.getInputStream()))) {
            String line2;
            content2 = new StringBuilder();
            while ((line2 = in2.readLine()) != null) {
                content2.append(line2);
                content2.append(System.lineSeparator());
            }
        }
        System.out.println(content2.toString());
         allpostIds = content2.toString();
      separate = allpostIds.split("id\":\"");
        for ( x = 1; x < 100; x++) {
            try{
                String postId = separate[x].substring(0, separate[x].indexOf("\""));
            String url = "https://api.byte.co/post/id/" + postId + "/feedback/comment";
            String urlParameters2 = "{\"body\":\"Currently doing Follow 4 follow and like for like!"+"\",\"postID\":\"" + postId + "\"}";
            URL obj = new URL(url);
            byte[] postData3 = urlParameters2.getBytes(StandardCharsets.UTF_8);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            con.setDoOutput(true);
            con.setRequestProperty("Content-Type", "application/json");
            con.setRequestProperty("User-Agent", "byte/0.2 (co.byte.video; build:145; iOS 13.3.0) Alamofire/4.9.1");
            con.setRequestProperty("Authorization", "");
            try (DataOutputStream wr3 = new DataOutputStream(con.getOutputStream())) {
                wr3.write(postData3);
            }
            StringBuilder content3;
            try (BufferedReader in3 = new BufferedReader(new InputStreamReader(con.getInputStream()))) {
                String line3;
                content3 = new StringBuilder();
                while ((line3 = in3.readLine()) != null) {
                    content3.append(line3);
                    content3.append(System.lineSeparator());
                }
            }
            System.out.println(content3);
            if(content3.toString().contains("1500")){
             String url3 = "https://api.byte.co/feed/global";
                URL obj3 = new URL(url3);
                HttpURLConnection con3 = (HttpURLConnection) obj3.openConnection();
                con3.setDoInput(true);
                con3.setRequestProperty("User-Agent", "byte/0.2 (co.byte.video; build:145; iOS 13.3.0) Alamofire/4.9.1");
                con3.setRequestProperty("Authorization", "");
                StringBuilder content4=null;
                try (BufferedReader in4 = new BufferedReader(new InputStreamReader(con3.getInputStream()))) {
                    String line4;
                    content4 = new StringBuilder();
                    while ((line4 = in4.readLine()) != null) {
                        content4.append(line4);
                        content4.append(System.lineSeparator());
                    }
                }
                allpostIds = content4.toString();
                separate = allpostIds.split("id\":\"");
                x=1;
            }
            }catch (Exception fdsa){

              }
            Thread.sleep(13000);
        }
    }
}
