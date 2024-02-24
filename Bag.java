public class Bag {
     private String kodeBarang, jenisBarang, namaBarang;
     private int stokBarang;

    public String getKodeBarang() {
        return kodeBarang;
    }

    public void setKodeBarang(String kodeBarang) {
        this.kodeBarang = kodeBarang;
    }

    public String getJenisBarang() {
        return jenisBarang;
    }

    public void setJenisBarang(String jenisBarang) {
        this.jenisBarang = jenisBarang;
    }

    public String getNamaBarang() {
        return namaBarang;
    }

    public void setNamaBarang(String namaBarang) {
        this.namaBarang = namaBarang;
    }

    public int getStokBarang() {
        return stokBarang;
    }

    public void setStokBarang(int stokBarang) {
        this.stokBarang = stokBarang;
    }

    public Bag(String kodeBarang, String jenisBarang, String namaBarang, int stokBarang) {
        this.kodeBarang = kodeBarang;
        this.jenisBarang = jenisBarang;
        this.namaBarang = namaBarang;
        this.stokBarang = stokBarang;
    }

    @Override
    public String toString() {
        return "Nama Barang : "+namaBarang+ ", Kode Barang : "+kodeBarang+", Jenis Barang : "+jenisBarang+", Stok Barang : "+stokBarang;
    }
}
