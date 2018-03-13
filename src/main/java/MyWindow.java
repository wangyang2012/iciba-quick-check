import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class MyWindow extends JFrame {

    private JTextField word = new JTextField();
    private JButton button = new JButton();


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

    private JEditorPane  result = new JEditorPane("html/text", initialText);

    public MyWindow(String title) {
        super(title);
        WindowListener l = new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        };

        addWindowListener(l);
        setLayout(new BorderLayout());

        JPanel panneau = new JPanel();

        word.setPreferredSize(new Dimension(400, 100));
        button.setText("Search");
        button.setPreferredSize(new Dimension(100, 100));
        result.setEnabled(false);
        result.setPreferredSize(new Dimension(500, 400));

        JScrollPane scrollPane = new JScrollPane(result);

        panneau.add(word, BorderLayout.NORTH);
        panneau.add(button, BorderLayout.CENTER);
        panneau.add(scrollPane, BorderLayout.SOUTH);
        setContentPane(panneau);
        setSize(600, 500);
        setVisible(true);
    }

    public void setButtonListener(ActionListener buttonAction) {
        button.addActionListener(buttonAction);
    }

    public String getRequestWord() {
        return word.getText();
    }

    public void setResult(String resultContent) {
        result.setContentType("text/html");
        result.setText(resultContent);
    }
}
