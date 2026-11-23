public class LaporanBank {
    public void cetakDaftar(String judul, Rekening[] semua) {
        System.out.println(judul);
        for (Rekening rekening : semua) {
            System.out.printf(
                    "%s | %-6s | %12s%n",
                    rekening.getNomor(),
                    rekening.getPemilik(),
                    Rekening.formatRupiah(rekening.getSaldo())
            );
            System.out.println("     " + rekening.keterangan());
        }
    }

    public void cetakTotal(Rekening[] semua) {
        int total = 0;
        for (Rekening rekening : semua) {
            total += rekening.getSaldo();
        }
        System.out.println("------------------------------");
        System.out.println("Total dana bank : " + Rekening.formatRupiah(total));
    }
}
