public class ProsesAkhirBulan {
    private final Notifikasi notifikasi;

    public ProsesAkhirBulan(Notifikasi notifikasi) {
        this.notifikasi = notifikasi;
    }

    public void potongBiayaAdmin(Rekening[] semua) {
        for (Rekening rekening : semua) {
            int biaya = rekening.potongBiayaAdmin();
            notifikasi.kirim(
                    rekening.getNomor(),
                    "biaya admin " + Rekening.formatRupiah(biaya)
            );
        }
    }

    public void tambahBunga(BerBunga[] berbunga) {
        for (BerBunga rekening : berbunga) {
            int bunga = rekening.tambahBunga();
            notifikasi.kirim(
                    rekening.getNomor(),
                    "bunga " + Rekening.formatRupiah(bunga)
            );
        }
    }

    public void autodebet(BisaDitarik[] bisaDitarik, int jumlah) {
        for (BisaDitarik rekening : bisaDitarik) {
            String hasil = rekening.tarik(jumlah) ? "berhasil" : "gagal";
            notifikasi.kirim(
                    rekening.getNomor(),
                    "autodebet " + Rekening.formatRupiah(jumlah) + " " + hasil
            );
        }
    }
}
