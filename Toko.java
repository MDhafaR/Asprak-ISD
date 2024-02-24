import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Toko<T> {

    private ArrayList<T> listData;

    public Toko() {
        listData = new ArrayList<>();
    }

    public void tambahData(T barang) {
        listData.add(barang);
    }

    public void removeData(T barang) {
        listData.remove(barang);
    }

    public void editData(int index, T barangBaru) {
        listData.set(index, barangBaru);
    }

    public void tampilkanData(Comparator<T> comparator) {
        ArrayList<T> dataTerurut = new ArrayList<>(listData);
        Collections.sort(dataTerurut, comparator);

        if (dataTerurut.isEmpty()) {
            System.out.println("Tidak ada barang");
        } else {
            for (T item : dataTerurut) {
                System.out.println(item.toString());
            }
        }
    }

    public ArrayList<T> getData() {
        return listData;
    }

    public static void main(String[] args) {
        @SuppressWarnings("resource")
        Scanner input = new Scanner(System.in);
        Toko<Object> inventory = new Toko<>();

        while (true) {
            System.out.println("Pilihan Menu");
            System.out.println("1. Tambah Data Barang");
            System.out.println("2. Hapus Data");
            System.out.println("3. Edit Data");
            System.out.println("4. Tampilkan Seluruh Data");
            System.out.println("5. Keluar");
            System.out.print("Pilihan Anda: ");
            int pilihan = input.nextInt();
            input.nextLine();

            switch (pilihan) {
                case 1:
                    System.out.print("Masukkan Kode Barang: ");
                    String kodeBarang = input.nextLine();
                    System.out.print("Masukkan Jenis Barang: ");
                    String jenisBarang = input.nextLine();
                    System.out.print("Masukkan Nama Barang: ");
                    String namaBarang = input.nextLine();
                    System.out.print("Masukkan Stok: ");
                    int stok = input.nextInt();
                    input.nextLine();

                    if (kodeBarang.startsWith("A") || kodeBarang.startsWith("B")) {
                        Atk barangAtk = new Atk(kodeBarang, jenisBarang, namaBarang, stok);
                        inventory.tambahData(barangAtk);
                        System.out.println("Data barang berhasil ditambahkan");
                    } else if (kodeBarang.startsWith("C")) {
                        Bag barangBag = new Bag(kodeBarang, jenisBarang, namaBarang, stok);
                        inventory.tambahData(barangBag);
                        System.out.println("Data barang berhasil ditambahkan");
                    } else {
                        System.out.println("Kode barang tidak valid");
                        break;
                    }
                    break;

                case 2:
                    System.out.print("Masukkan kode barang yang akan dihapus: ");
                    String hapusDenganKode = input.nextLine();

                    boolean removed = false;
                    ArrayList<Object> data = inventory.getData();
                    for (int i = 0; i < data.size(); i++) {
                        Object item = data.get(i);
                        if (item instanceof Atk) {
                            Atk barangAtk = (Atk) item;
                            if (barangAtk.getKodeBarang().startsWith("A")
                                    || barangAtk.getKodeBarang().startsWith("B")) {
                                if (barangAtk.getKodeBarang().equals(hapusDenganKode)) {
                                    data.remove(i);
                                    removed = true;
                                    System.out.println("Data ATK berhasil dihapus: " + barangAtk.toString());
                                    break;
                                }
                            }
                        } else if (item instanceof Bag) {
                            Bag barangBag = (Bag) item;
                            if (barangBag.getKodeBarang().startsWith("C")) {
                                if (barangBag.getKodeBarang().equals(hapusDenganKode)) {
                                    data.remove(i);
                                    removed = true;
                                    System.out.println("Data Bag berhasil dihapus: " + barangBag.toString());
                                    break;
                                }
                            }
                        }
                    }

                    if (!removed) {
                        System.out.println("Data dengan kode barang " + hapusDenganKode + " tidak ditemukan.");
                    }
                    break;
                case 3:
                    System.out.print("Masukkan kode barang yang akan diedit: ");
                    String editKodeBarang = input.nextLine();

                    ArrayList<Object> editData = inventory.getData();
                    boolean edited = false;

                    for (int i = 0; i < editData.size(); i++) {
                        Object currentItem = editData.get(i);
                        if (currentItem instanceof Atk) {
                            Atk atk = (Atk) currentItem;
                            if (atk.getKodeBarang().equals(editKodeBarang)) {
                                System.out.print("Masukkan Kode Barang Baru: ");
                                String atkKodeBarangBaru = input.nextLine();
                                System.out.print("Masukkan Jenis Barang Baru: ");
                                String atkJenisBarangBaru = input.nextLine();
                                System.out.print("Masukkan Nama Barang Baru: ");
                                String atkNamaBarangBaru = input.nextLine();
                                System.out.print("Masukkan Stok Baru: ");
                                int atkStokBaru = input.nextInt();
                                input.nextLine();

                                Atk atkBaru = new Atk(atkKodeBarangBaru, atkJenisBarangBaru, atkNamaBarangBaru, atkStokBaru);
                                inventory.editData(i, atkBaru);
                                System.out.println("Data ATK berhasil diubah");
                                edited = true;
                                break;
                            }
                        } else if (currentItem instanceof Bag) {
                            Bag bag = (Bag) currentItem;
                            if (bag.getKodeBarang().equals(editKodeBarang)) {
                                System.out.print("Masukkan Kode Barang Baru: ");
                                String bagKodeBarangBaru = input.nextLine();
                                System.out.print("Masukkan Jenis Barang Baru: ");
                                String bagJenisBarangBaru = input.nextLine();
                                System.out.print("Masukkan Nama Barang Baru: ");
                                String bagNamaBarangBaru = input.nextLine();
                                System.out.print("Masukkan Stok Baru: ");
                                int bagStokBaru = input.nextInt();
                                input.nextLine();

                                Bag bagBaru = new Bag(bagKodeBarangBaru, bagJenisBarangBaru, bagNamaBarangBaru, bagStokBaru);
                                inventory.editData(i, bagBaru);
                                System.out.println("Data Bag berhasil diubah");
                                edited = true;
                                break;
                            }
                        }
                    }

                    if (!edited) {
                        System.out.println("Data dengan kode barang " + editKodeBarang + " tidak ditemukan.");
                    }
                    break;

                case 4:
                    Comparator<Object> comparator = null;
                    comparator = Comparator.comparing(o -> {
                        if (o instanceof Atk) {
                            return ((Atk) o).getNamaBarang();
                        }
                        return "";
                    });
                    inventory.tampilkanData(comparator);
                    break;

                case 5:
                    System.out.println("Terima kasih telah menggunakan program ini");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Pilihan tidak valid");
                    break;
            }
        }
    }

}
