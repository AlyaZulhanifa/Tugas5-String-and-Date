import java.text.SimpleDateFormat; // Import untuk format tanggal dan waktu
import java.util.Date; // Import untuk mendapatkan tanggal saat ini
import java.util.Scanner; // Import untuk menerima input dari pengguna

public class SupermarketSystem {
    public static void main(String[] args) {
        // Menggunakan try-with-resources agar Scanner otomatis ditutup
        try (Scanner scanner = new Scanner(System.in)) {
            // Deklarasi variabel untuk login
            String username, password, captchaInput;
            // Username dan password yang benar
            String expectedUsername = "Treasure";
            String expectedPassword = "070820";
            // Generate captcha awal
            String captcha = generateCaptcha();
            boolean loginSuccess = false; // Status login berhasil atau tidak

            // Proses login
            while (!loginSuccess) { // Looping hingga login berhasil
                System.out.println("+---------------------------------------------+");
                System.out.println("Log in");
                System.out.println("+---------------------------------------------+");
                System.out.print("Username : ");
                username = scanner.nextLine(); // Input username dari pengguna
                System.out.print("Password : ");
                password = scanner.nextLine(); // Input password dari pengguna
                System.out.print("Captcha  : " + captcha + "\nMasukkan Captcha: ");
                captchaInput = scanner.nextLine(); // Input captcha dari pengguna

                // Validasi login
                if (username.equals(expectedUsername) && password.equals(expectedPassword) && captchaInput.equals(captcha)) {
                    System.out.println("Login berhasil!");
                    loginSuccess = true; // Mengubah status login menjadi berhasil
                } else {
                    System.out.println("Login gagal, silakan coba lagi.\n");
                    captcha = generateCaptcha(); // Generate captcha baru jika gagal
                }
            }

            // Proses transaksi
            System.out.println("\n+---------------------------------------------+");
            System.out.println("Selamat Datang di Supermarket Treasure Mart");
            System.out.println("Tanggal dan Waktu : " + getCurrentDateTime()); // Menampilkan tanggal dan waktu saat ini
            System.out.println("+---------------------------------------------+");

            // Input detail transaksi dari pengguna
            System.out.print("No. Faktur   : ");
            String noFaktur = scanner.nextLine(); // Input nomor faktur
            System.out.print("Kode Barang  : ");
            String kodeBarang = scanner.nextLine(); // Input kode barang
            System.out.print("Nama Barang  : ");
            String namaBarang = scanner.nextLine(); // Input nama barang
            System.out.print("Harga Barang : ");
            double hargaBarang = scanner.nextDouble(); // Input harga barang
            System.out.print("Jumlah Beli  : ");
            int jumlahBeli = scanner.nextInt(); // Input jumlah barang yang dibeli
            scanner.nextLine(); // Membersihkan newline di buffer Scanner

            // Menghitung total harga
            double total = hargaBarang * jumlahBeli;

            // Menampilkan detail transaksi
            System.out.println("+---------------------------------------------+");
            System.out.println("No. Faktur   : " + noFaktur);
            System.out.println("Kode Barang  : " + kodeBarang);
            System.out.println("Nama Barang  : " + namaBarang);
            System.out.println("Harga Barang : Rp" + String.format("%.2f", hargaBarang));
            System.out.println("Jumlah Beli  : " + jumlahBeli);
            System.out.println("TOTAL        : Rp" + String.format("%.2f", total));
            System.out.println("+---------------------------------------------+");
            System.out.print("Kasir        : ");
            String namaKasir = scanner.nextLine(); // Input nama kasir
            System.out.println("Kasir        : " + namaKasir); // Menampilkan nama kasir
            System.out.println("+---------------------------------------------+");
            System.out.println("Terima kasih telah berbelanja di Supermarket Treasure Mart!");
        }
    }

    // Method untuk generate captcha acak
    private static String generateCaptcha() {
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789"; // Karakter yang digunakan
        StringBuilder captcha = new StringBuilder(); // Untuk menyimpan captcha yang di-generate
        for (int i = 0; i < 6; i++) { // Generate 6 karakter acak
            int randomIndex = (int) (Math.random() * chars.length()); // Mendapatkan index karakter secara acak
            captcha.append(chars.charAt(randomIndex)); // Menambahkan karakter ke captcha
        }
        return captcha.toString(); // Mengembalikan hasil captcha
    }

    // Method untuk mendapatkan tanggal dan waktu saat ini
    private static String getCurrentDateTime() {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss"); // Format tanggal dan waktu
        Date date = new Date(); // Mendapatkan waktu saat ini
        return formatter.format(date); // Mengembalikan waktu dalam format yang diinginkan
    }
}
