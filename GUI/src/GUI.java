import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class GUI {
   
}

class Main {
    public static void main(String[] args) {
        Label angka1, angka2, hasil;
        Frame frame = new Frame("GUI Java");

        frame.setSize(400, 300);
        frame.setVisible(true);
        frame.setLayout(null);

        angka1 = new Label("Angka 1");
        angka1.setBounds(50, 50, 100, 30);
        frame.add(angka1);

        angka2 = new Label("Angka 2");
        angka2.setBounds(50, 100, 100, 30);
        frame.add(angka2);

        hasil = new Label("Hasil");
        hasil.setBounds(50, 150, 100, 30);
        frame.add(hasil);

        Button tambah = new Button("Tambah");
        tambah.setBounds(50, 180, 100, 30);
        frame.add(tambah);

        frame.addWindowListener(new WindowAdapter() {
            public void WindowClosing(WindowEvent e) {
                frame.dispose();
            }
        });

    }
}