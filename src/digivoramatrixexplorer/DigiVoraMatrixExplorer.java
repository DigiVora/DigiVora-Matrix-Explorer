/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package digivoramatrixexplorer;
import javax.swing.JOptionPane;

/**
 *
 * @author achmad_khusnul_yakin
 */
public class DigiVoraMatrixExplorer {

    public static void main(String[] args) {
        // Inisialisasi Data Array 2D
        int data[][] = {
            {4, 6, 4, 2, 8, 4, 2, 10},
            {4, 6, 4, 2, 8, 4, 2, 10}
        };

        // --- HEADER PROGRAM ---
        System.out.println("==================================================");
        System.out.println("            DIGIVORA MATRIX EXPLORER    ");
        System.out.println("==================================================");

        // 1. Output data array lama
        System.out.println("\n[1] DATA ARRAY LAMA");
        System.out.println("--------------------------------------------------");
        tampilkanArray(data);
        System.out.println("--------------------------------------------------");

        // 2. Hitung nilai rata-rata
        double total = 0;
        int jumlahItem = 0;
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                total += data[i][j];
                jumlahItem++;
            }
        }
        double rataRata = total / jumlahItem;

        // 3. Menjumlahkan elemen indeks kolom ganjil (1, 3, 5, 7)
        int sumGanjil = 0;
        for (int i = 0; i < data.length; i++) {
            for (int j = 1; j < data[i].length; j += 2) {
                sumGanjil += data[i][j];
            }
        }

        // Menampilkan hasil perhitungan statistik di console
        System.out.println("\n[2] STATISTIK DATA");
        System.out.printf("> Nilai Rata-rata          : %.2f\n", rataRata);
        System.out.printf("> Total Kolom Indeks Ganjil : %d\n", sumGanjil);
        System.out.println("--------------------------------------------------");

        // --- PROSES INTERAKSI JOPTIONPANE ---
        try {
            String cariStr = JOptionPane.showInputDialog(null, "Masukkan angka yang ingin dicari:", "Cari Data", JOptionPane.QUESTION_MESSAGE);
            
            // Cek jika user menekan tombol 'Cancel'
            if (cariStr == null) return;
            
            int cari = Integer.parseInt(cariStr);
            StringBuilder posisi = new StringBuilder();
            boolean ditemukan = false;

            // Pencarian posisi indeks
            for (int i = 0; i < data.length; i++) {
                for (int j = 0; j < data[i].length; j++) {
                    if (data[i][j] == cari) {
                        posisi.append("[").append(i).append(",").append(j).append("] ");
                        ditemukan = true;
                    }
                }
            }

            if (ditemukan) {
                JOptionPane.showMessageDialog(null, "Angka " + cari + " ditemukan di indeks:\n" + posisi.toString());

                String gantiStr = JOptionPane.showInputDialog(null, "Masukkan angka baru untuk mengganti angka " + cari + ":", 
                        "Update Data", JOptionPane.QUESTION_MESSAGE);
                if (gantiStr == null) return;
                
                int ganti = Integer.parseInt(gantiStr);

                // Proses Update Data
                for (int i = 0; i < data.length; i++) {
                    for (int j = 0; j < data[i].length; j++) {
                        if (data[i][j] == cari) {
                            data[i][j] = ganti;
                        }
                    }
                }

                // Output data array baru di console
                System.out.println("\n[3] DATA ARRAY BARU (Setelah Update)");
                System.out.println("--------------------------------------------------");
                tampilkanArray(data);
                System.out.println("--------------------------------------------------");
                System.out.println(">>> STATUS: Data Berhasil Diperbarui.\n");
                
                JOptionPane.showMessageDialog(null, "Data Array Berhasil Diperbarui!\nSilahkan cek Output Console.");

            } else {
                JOptionPane.showMessageDialog(null, "Angka " + cari + " tidak ditemukan dalam array.", "Info", JOptionPane.INFORMATION_MESSAGE);
            }

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Error: Input harus berupa angka bulat!", "Input Salah", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Helper method agar kode lebih bersih (DRY - Don't Repeat Yourself)
    public static void tampilkanArray(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print("Baris " + i + " :  ");
            for (int j = 0; j < array[i].length; j++) {
                System.out.printf("%-4d", array[i][j]);
            }
            System.out.println();
        }
    }
}