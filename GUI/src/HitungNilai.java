
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;



public class HitungNilai {
    static ArrayList<MataKuliah> listNilaiMatkul = new ArrayList<>();

    public static void main(String[] args) {
        Frame frame = new Frame("Hitung Nilai Akhir");

        Label judul = new Label("Hitung Nilai Akhir");
        judul.setBounds(140, 50, 200, 20);
        Font font = new Font("Arial", Font.BOLD, 14);
        judul.setFont(font);
        frame.add(judul);

        CheckboxGroup group = new CheckboxGroup();
        Checkbox asd = new Checkbox("ASD", group, true);
        asd.setBounds(40, 80, 40, 20);
        frame.add(asd);

        Checkbox pemlan = new Checkbox("Pemlan", group, false);
        pemlan.setBounds(110, 80, 80, 20);
        frame.add(pemlan);

        Checkbox matkomlan = new Checkbox("Matkomlan", group, false);
        matkomlan.setBounds(200, 80, 80, 20);
        frame.add(matkomlan);

        Checkbox probstat = new Checkbox("Probstat", group, false);
        probstat.setBounds(300, 80, 80, 20);
        frame.add(probstat);

        Label tugas = new Label("Tugas : ");
        tugas.setBounds(120, 120, 70, 20);
        frame.add(tugas);

        TextField txtTugas = new TextField();
        txtTugas.setBounds(200, 120, 60, 20);
        frame.add(txtTugas);

        Label kuis = new Label("Kuis : ");
        kuis.setBounds(120, 150, 70, 20);
        frame.add(kuis);

        TextField txtKuis = new TextField();
        txtKuis.setBounds(200, 150, 60, 20);
        frame.add(txtKuis);

        Label uts = new Label("UTS : ");
        uts.setBounds(120, 180, 70, 20);
        frame.add(uts);

        TextField txtUts = new TextField();
        txtUts.setBounds(200, 180, 60, 20);
        frame.add(txtUts);

        Label uas = new Label("UAS : ");
        uas.setBounds(120, 210, 70, 20);
        frame.add(uas);

        TextField txtUas = new TextField();
        txtUas.setBounds(200, 210, 60, 20);
        frame.add(txtUas);

        Label hasil = new Label("Nilai : ");
        hasil.setBounds(120, 240, 70, 20);
        frame.add(hasil);

        TextField txtHasil = new TextField();
        txtHasil.setBounds(200, 240, 60, 20);
        frame.add(txtHasil);

        Button btnHitung = new Button("Hitung");
        btnHitung.setBounds(150, 280, 80, 20);
        frame.add(btnHitung);

        TextArea area = new TextArea();
        area.setBounds(20, 320, 360, 200);
        frame.add(area);

        Button tampil = new Button("Tampilkan nilai semua matkul");
        tampil.setBounds(100, 540, 200, 20);
        frame.add(tampil);

        btnHitung.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    double tugas = Double.parseDouble(txtTugas.getText());
                    double kuis = Double.parseDouble(txtKuis.getText());
                    double uts = Double.parseDouble(txtUts.getText());
                    double uas = Double.parseDouble(txtUas.getText());

                    String namaMatkul = group.getSelectedCheckbox().getLabel();

                    MataKuliah mk = new MataKuliah(namaMatkul, tugas, kuis, uts, uas);
                    double nilaiAkhir = mk.hitungNilaiAkhir();

                    txtHasil.setText(String.valueOf(nilaiAkhir));

                    listNilaiMatkul.add(mk);
                } catch (Exception ex) {
                    txtHasil.setText("Input tidak valid");
                }
            }
        }); 

        tampil.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                area.setText("");

                for (MataKuliah mk : listNilaiMatkul) {
                    area.append(mk.nama + " : " + mk.hitungNilaiAkhir() + "\n");
                }
            }
        });

        frame.setSize(400, 700);
        frame.setLayout(null);
        frame.setVisible(true);

        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });
    }

}

class MataKuliah {
    String nama;
    double tugas, kuis, uts, uas;

    public MataKuliah(String nama, double tugas, double kuis, double uts, double uas) {
        this.nama = nama;
        this.tugas = tugas;
        this.kuis = kuis;
        this.uts = uts;
        this.uas = uas;

    }

    public double hitungNilaiAkhir() {
        return (tugas * 0.2) + (kuis * 0.1) + (uts * 0.3) + (uas * 0.4);
    }
}
