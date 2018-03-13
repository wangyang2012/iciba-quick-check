import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class QuickCheckApp {
    public static void main(String[] args) {
        NetworkUtil networkUtil = NetworkUtil.getInstance();
        initSettings(networkUtil);

    }

    private static void initSettings(final NetworkUtil networkUtil) {
        networkUtil.setRequestUrl("http://www.iciba.com/");
        networkUtil.setProxy("firewall.ina.fr", 81);

        final MyWindow window = new MyWindow("Quick check");
        window.setButtonListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String requestWord = window.getRequestWord();
                String result = networkUtil.requestWord(requestWord);



                String initialText = "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">\n" +
                        "<html>\n" +
                        "  <head>\n" +
                        "    <title></title>\n" +
                        "    <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n" +
                        "  </head>\n" +
                        "  <body>\n" +
                        "    TODO write content你是我的爱人！\n" +
                        "  </body>\n" +
                        "</html>";
                window.setResult(initialText);
            }
        });
        window.setVisible(true);
    }
}
