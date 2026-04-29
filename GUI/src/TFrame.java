
import java.awt.*;

public class TFrame extends Frame {
    Label lbJudul, lbTugas, lbKuis, lbUTS, lbUAS, lbHasil;
    TextField txtTugas, txtKuis, txtUts, txtUas, txtHasil;
    Button btnHasil;

    public TFrame() {
        setLayout(null);

        lbJudul = new Label("Hitung nilai akhir");
        lbJudul.setFont(new Font("Arial", 1, 14));
        lbJudul.setBounds(100, 30, 170, 20);
        add(lbJudul);

        lbTugas = new Label("Nilai Tugas");
        lbTugas.setBounds(100, 60, 62, 20);
        add(lbTugas);

        lbKuis = new Label("Nilai Kuis");
        lbKuis.setBounds(100, 90, 70, 20);
        add(lbKuis);

        lbUTS = new Label("Nilai UTS");
        lbUTS.setBounds(100, 120, 70, 20);
        add(lbUTS);

        lbUAS = new Label("Nilai UAS");
        lbUAS.setBounds(100, 150, 70, 20);
        add(lbUAS);

        lbHasil = new Label("Nilai Akhir");
        lbHasil.setBounds(100, 180, 70, 20);
        add(lbHasil);

        txtTugas = new TextField("0");
        txtTugas.setBounds(200, 60, 60, 20);
        add(txtTugas);

        txtKuis = new TextField("0");
        txtKuis.setBounds(200, 90, 60, 20);
        add(txtKuis);

        txtUts = new TextField("0");
        txtUts.setBounds(200, 120, 60, 20);
        add(txtUts);

        txtUas = new TextField("0");
        txtUas.setBounds(200, 150, 60, 20);
        add(txtUas);

        txtHasil = new TextField("0");
        txtHasil.setBounds(200, 180, 60, 20);
        add(txtHasil);

        btnHasil = new Button("Hitung");
        btnHasil.setBounds(120, 200, 100, 20);

        add(btnHasil);
    }

    void hitungNilaiAkhir() {
        double tugas = Double.parseDouble(txtTugas.getText());
        double kuis = Double.parseDouble(txtKuis.getText());
        double uts = Double.parseDouble(txtUts.getText());
        double uas = Double.parseDouble(txtUas.getText());

        double nilaiAkhir = (tugas * 0.2) + (kuis * 0.1) + (uts * 0.3) + (uas * 0.4);
        txtHasil.setText(String.valueOf(nilaiAkhir));
    }
}

class MainTFrame {
    public static void main(String[] args) {
        TFrame frame = new TFrame();
        frame.setTitle("Nilai Akhir");
        frame.setSize(400, 300);
        frame.setVisible(true);

        frame.btnHasil.addActionListener(e -> frame.hitungNilaiAkhir());
    }
}

