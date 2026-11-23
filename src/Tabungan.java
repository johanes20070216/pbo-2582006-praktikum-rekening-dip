public class Tabungan extends Rekening implements BerBunga, BisaDitarik {
    private final double bungaPersen;

    public Tabungan(String nomor, String pemilik, int saldo, double bungaPersen) {
        super(nomor, pemilik, saldo);
        this.bungaPersen = bungaPersen;
    }

    @Override
    public int biayaAdminBulanan() {
        return saldo >= 1_000_000 ? 0 : 5_000;
    }

    @Override
    public int tambahBunga() {
        int bunga = (int) (saldo * bungaPersen / 100);
        setor(bunga);
        return bunga;
    }

    @Override
    public boolean tarik(int jumlah) {
        if (jumlah <= 0 || jumlah > saldo) {
            return false;
        }
        saldo -= jumlah;
        return true;
    }

    @Override
    public String keterangan() {
        return "Tabungan, bunga " + bungaPersen + "% per bulan";
    }
}
