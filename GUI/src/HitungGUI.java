
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;



public class HitungGUI {
    
    public static double Tambah(double angka1, double angka2) {
        return angka1 + angka2;
    }

    public static void main(String[] args) {
        Frame frame = new Frame("Hitung GUI");

        TextField angka1 = new TextField();
        angka1.setBounds(100, 80, 100, 30);

        TextField angka2 = new TextField();
        angka2.setBounds(100, 120, 100, 30);

        Button tambah = new Button("Tambah");
        tambah.setBounds(100, 160, 100, 30);

        Label hasil = new Label("Hasil: ");
        hasil.setBounds(100, 200, 100, 30);

        tambah.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    double num1 = Double.parseDouble(angka1.getText());
                    double num2 = Double.parseDouble(angka2.getText());

                    double result = Tambah(num1, num2);
                    hasil.setText("Hasil: " + result);
                } catch (Exception ex) {
                    hasil.setText("Input tidak valid");
                }
            }
        });

        frame.add(angka1);
        frame.add(angka2);
        frame.add(tambah);
        frame.add(hasil);
        frame.setSize(300, 300);
        frame.setLayout(null);
        frame.setVisible(true);

        frame.addWindowListener(new WindowAdapter() {
            public void CloseWindow(WindowEvent e) {
                frame.dispose();
            }
        });
    }
}
