package swing.bank.components.Labels;

import javax.swing.JFrame;
import java.awt.Font;

public class SubTitleLabel extends TitleLabel {
    Font font = new Font("Raleway", Font.BOLD, 22);
    int x, y, width = 400, height = 30;
    public SubTitleLabel(String text, int x, int y, JFrame frame) {
        super(text, x, y, frame);
        this.x = x;
        this.y = y;
        setProperties();
    }

    @Override
    void setProperties() {
        super.setProperties();
        setFont(font);
        setBounds(x, y, width, height);
    }
}
