import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URL;

public class NetworkUtil {
    private static NetworkUtil instance = new NetworkUtil();

    private String proxyServer;
    private Integer proxyPort;
    private String requestUrl = "http://www.iciba.com/";

    private NetworkUtil(){}

    public static NetworkUtil getInstance() {
        if (NetworkUtil.instance == null) {
            instance = new NetworkUtil();
        }
        return instance;
    }

    public void setRequestUrl(String url) {
        this.requestUrl = url;
    }

    public void setProxy(String proxyServer, Integer proxyPort) {
        this.proxyServer = proxyServer;
        this.proxyPort = proxyPort;
    }

    public String requestWord(String word) {
        try {
            String result = sendGet(word);
            String translation = retrieveContent(result);
            return translation;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Nothing found";
    }

    // HTTP GET request
    private static String sendGet(String word) throws Exception {

        String url = "http://www.iciba.com/collision";

        Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("firewall.ina.fr", 81));

        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection(proxy);

        // optional default is GET
        con.setRequestMethod("GET");

        int responseCode = con.getResponseCode();
        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
        return response.toString();
    }

    // Retrieve content
    private String retrieveContent(String html) {

        Document doc = Jsoup.parse(html);
        Element usefulContent = doc.select(".container-left").first();
        System.out.println(usefulContent);
        return usefulContent.toString();
    }
}
