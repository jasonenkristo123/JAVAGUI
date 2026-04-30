
import javax.swing.*;

public class FormSwing extends JFrame {
    JTextField nama, ttl, noDaftar, noTelp, email, alamat;

    public FormSwing() {
        setTitle("Form Pendaftaran Mahasiswa");
        setSize(400, 400);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        addLabel("Nama Lengkap", 30, 30);
        nama = addTextField(150, 30);

        addLabel("Tanggal Lahir", 30, 70);
        ttl = addTextField(150, 70);

        addLabel("No Pendaftaran", 30, 110);
        noDaftar = addTextField(150, 110);

        addLabel("No Telp", 30, 150);
        noTelp = addTextField(150, 150);

        addLabel("Alamat", 30, 190);
        alamat = addTextField(400, 400);
        alamat.setBounds(150, 190, 180, 50);
        add(alamat);

        addLabel("Email", 30, 260);
        email = addTextField(150, 260);

        JButton submit = new JButton("Submit");
        submit.setBounds(150, 310, 100, 30);
        add(submit);

        submit.addActionListener(e -> {
            if (isEmpty()) {
                JOptionPane.showMessageDialog(null, "Semua field harus diisi!");
                return;
            }

            int confirm = JOptionPane.showConfirmDialog(
                    null,
                    "Apakah data sudah benar?",
                    "Konfirmasi",
                    JOptionPane.YES_NO_OPTION);

            if (confirm == JOptionPane.YES_OPTION) {
                tampilData();
            }
        });

        setVisible(true);
    }

    private void addLabel(String text, int x, int y) {
        JLabel label = new JLabel(text);
        label.setBounds(x, y, 120, 25);
        add(label);
    }

    private JTextField addTextField(int x, int y) {
        JTextField tf = new JTextField();
        tf.setBounds(x, y, 180, 25);
        add(tf);
        return tf;
    }

    private boolean isEmpty() {
        return nama.getText().isEmpty() ||
                ttl.getText().isEmpty() ||
                noDaftar.getText().isEmpty() ||
                noTelp.getText().isEmpty() ||
                alamat.getText().isEmpty() ||
                email.getText().isEmpty();
    }

    private void tampilData() {
        JFrame hasil = new JFrame("Data Mahasiswa");
        hasil.setSize(400, 300);

        JTextArea area = new JTextArea();
        area.setEditable(false);

        area.setText(
                "Nama : " + nama.getText() + "\n" +
                        "Tanggal Lahir : " + ttl.getText() + "\n" +
                        "No Pendaftaran : " + noDaftar.getText() + "\n" +
                        "No Telp : " + noTelp.getText() + "\n" +
                        "Alamat : " + alamat.getText() + "\n" +
                        "E-mail : " + email.getText());

        hasil.add(new JScrollPane(area));
        hasil.setVisible(true);
    }
}

class FormMain {
    public static void main(String[] args) {
        FormSwing form = new FormSwing();
        form.setVisible(true);
    }
}
