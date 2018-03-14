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
                window.setResult(result);
            }
        });
        window.setVisible(true);
    }
}
