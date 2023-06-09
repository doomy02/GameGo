package app.view;

import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import com.intellij.uiDesigner.core.Spacer;
import lombok.Getter;

import javax.swing.*;
import javax.swing.plaf.FontUIResource;
import javax.swing.text.StyleContext;
import java.awt.*;
import java.util.Locale;

public class GameDetailsView {
    @Getter
    private JPanel detailsPanel;
    @Getter
    private JButton backButton;
    private JLabel nameLabel;
    @Getter
    private JLabel nameValue;
    private JLabel priceLabel;
    @Getter
    private JLabel priceValue;
    private JLabel noReviewsLabel;
    @Getter
    private JLabel noReviewsValue;
    private JLabel tagLabel;
    @Getter
    private JLabel tagValue;
    private JPanel gamePanel;

    {
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
        $$$setupUI$$$();
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        detailsPanel = new JPanel();
        detailsPanel.setLayout(new GridLayoutManager(4, 1, new Insets(0, 0, 0, 0), -1, -1));
        detailsPanel.setBackground(new Color(-13395457));
        final JPanel panel1 = new JPanel();
        panel1.setLayout(new GridLayoutManager(1, 2, new Insets(0, 0, 0, 0), -1, -1));
        panel1.setBackground(new Color(-15118977));
        detailsPanel.add(panel1, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        final JLabel label1 = new JLabel();
        Font label1Font = this.$$$getFont$$$("Times New Roman", Font.BOLD, 20, label1.getFont());
        if (label1Font != null) label1.setFont(label1Font);
        label1.setForeground(new Color(-1));
        label1.setText("Game Details");
        panel1.add(label1, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label2 = new JLabel();
        label2.setForeground(new Color(-1));
        label2.setIcon(new ImageIcon(getClass().getResource("/photos/GameGO_logo.png")));
        label2.setText("");
        panel1.add(label2, new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_EAST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        gamePanel = new JPanel();
        gamePanel.setLayout(new GridLayoutManager(5, 4, new Insets(0, 0, 0, 0), -1, -1));
        gamePanel.setBackground(new Color(-15118977));
        gamePanel.setForeground(new Color(-1));
        detailsPanel.add(gamePanel, new GridConstraints(2, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        nameLabel = new JLabel();
        nameLabel.setBackground(new Color(-1));
        Font nameLabelFont = this.$$$getFont$$$("Times New Roman", -1, 20, nameLabel.getFont());
        if (nameLabelFont != null) nameLabel.setFont(nameLabelFont);
        nameLabel.setForeground(new Color(-1));
        nameLabel.setText("Name:");
        gamePanel.add(nameLabel, new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        nameValue = new JLabel();
        nameValue.setBackground(new Color(-1));
        nameValue.setEnabled(true);
        Font nameValueFont = this.$$$getFont$$$("Times New Roman", -1, 20, nameValue.getFont());
        if (nameValueFont != null) nameValue.setFont(nameValueFont);
        nameValue.setForeground(new Color(-1));
        nameValue.setText("");
        gamePanel.add(nameValue, new GridConstraints(0, 2, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        priceLabel = new JLabel();
        priceLabel.setBackground(new Color(-1));
        Font priceLabelFont = this.$$$getFont$$$("Times New Roman", -1, 20, priceLabel.getFont());
        if (priceLabelFont != null) priceLabel.setFont(priceLabelFont);
        priceLabel.setForeground(new Color(-1));
        priceLabel.setText("Price:");
        gamePanel.add(priceLabel, new GridConstraints(1, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        priceValue = new JLabel();
        priceValue.setBackground(new Color(-1));
        Font priceValueFont = this.$$$getFont$$$("Times New Roman", -1, 20, priceValue.getFont());
        if (priceValueFont != null) priceValue.setFont(priceValueFont);
        priceValue.setForeground(new Color(-1));
        priceValue.setText("");
        gamePanel.add(priceValue, new GridConstraints(1, 2, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        noReviewsLabel = new JLabel();
        noReviewsLabel.setBackground(new Color(-1));
        Font noReviewsLabelFont = this.$$$getFont$$$("Times New Roman", -1, 20, noReviewsLabel.getFont());
        if (noReviewsLabelFont != null) noReviewsLabel.setFont(noReviewsLabelFont);
        noReviewsLabel.setForeground(new Color(-1));
        noReviewsLabel.setText("Number of Reviews:");
        gamePanel.add(noReviewsLabel, new GridConstraints(2, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        noReviewsValue = new JLabel();
        noReviewsValue.setBackground(new Color(-1));
        Font noReviewsValueFont = this.$$$getFont$$$("Times New Roman", -1, 20, noReviewsValue.getFont());
        if (noReviewsValueFont != null) noReviewsValue.setFont(noReviewsValueFont);
        noReviewsValue.setForeground(new Color(-1));
        noReviewsValue.setText("");
        gamePanel.add(noReviewsValue, new GridConstraints(2, 2, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        tagLabel = new JLabel();
        tagLabel.setBackground(new Color(-1));
        Font tagLabelFont = this.$$$getFont$$$("Times New Roman", -1, 20, tagLabel.getFont());
        if (tagLabelFont != null) tagLabel.setFont(tagLabelFont);
        tagLabel.setForeground(new Color(-1));
        tagLabel.setText("Tag:");
        gamePanel.add(tagLabel, new GridConstraints(3, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        tagValue = new JLabel();
        tagValue.setBackground(new Color(-1));
        Font tagValueFont = this.$$$getFont$$$("Times New Roman", -1, 20, tagValue.getFont());
        if (tagValueFont != null) tagValue.setFont(tagValueFont);
        tagValue.setForeground(new Color(-1));
        tagValue.setText("");
        gamePanel.add(tagValue, new GridConstraints(3, 2, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        backButton = new JButton();
        Font backButtonFont = this.$$$getFont$$$("Times New Roman", -1, 14, backButton.getFont());
        if (backButtonFont != null) backButton.setFont(backButtonFont);
        backButton.setText("Back");
        gamePanel.add(backButton, new GridConstraints(4, 1, 1, 2, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final Spacer spacer1 = new Spacer();
        gamePanel.add(spacer1, new GridConstraints(2, 3, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
        final Spacer spacer2 = new Spacer();
        gamePanel.add(spacer2, new GridConstraints(2, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
        final Spacer spacer3 = new Spacer();
        detailsPanel.add(spacer3, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_VERTICAL, 1, GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        final Spacer spacer4 = new Spacer();
        detailsPanel.add(spacer4, new GridConstraints(3, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_VERTICAL, 1, GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
    }

    /**
     * @noinspection ALL
     */
    private Font $$$getFont$$$(String fontName, int style, int size, Font currentFont) {
        if (currentFont == null) return null;
        String resultName;
        if (fontName == null) {
            resultName = currentFont.getName();
        } else {
            Font testFont = new Font(fontName, Font.PLAIN, 10);
            if (testFont.canDisplay('a') && testFont.canDisplay('1')) {
                resultName = fontName;
            } else {
                resultName = currentFont.getName();
            }
        }
        Font font = new Font(resultName, style >= 0 ? style : currentFont.getStyle(), size >= 0 ? size : currentFont.getSize());
        boolean isMac = System.getProperty("os.name", "").toLowerCase(Locale.ENGLISH).startsWith("mac");
        Font fontWithFallback = isMac ? new Font(font.getFamily(), font.getStyle(), font.getSize()) : new StyleContext().getFont(font.getFamily(), font.getStyle(), font.getSize());
        return fontWithFallback instanceof FontUIResource ? fontWithFallback : new FontUIResource(fontWithFallback);
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return detailsPanel;
    }

}
