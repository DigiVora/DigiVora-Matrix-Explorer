/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package digivoramatrixexplorer;

/**
 *
 * @author achmad_khusnul_yakin
 */
public class DataKontak {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Definisi array 2D
        String[][] data = {
            {"ABDUL", "085646668991", "Kediri"},
            {"KUSNO", "085646668992", "Trenggalek"},
            {"PONIRAN", "085646668999", "Bojonegoro"}
        };

        // Menampilkan Header
        // %-12s artinya String rata kiri dengan lebar 12 karakter
        System.out.printf("%-12s %-15s %-15s\n", "NAMA", "ALAMAT", "TELEPON");
        System.out.println("------------------------------------------");

        // Looping untuk menampilkan data
        for (int i = 0; i < data.length; i++) {
            String nama = data[i][0];
            String telepon = data[i][1];
            String alamat = data[i][2];

            // Menampilkan dengan urutan NAMA - ALAMAT - TELEPON sesuai permintaan
            System.out.printf("%-12s %-15s %-15s\n", nama, alamat, telepon);
        }
    }
}