import java.util.Scanner;
//(Justin Fadly Laiya, 244107060142, 10)
public class UAS1C10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        
        String[] namaTim10 = new String[4];
        int[][] skor10 = new int[4][2];
        int[] totalSkor10 = new int[4];
        int bonusBuff10 = 10; 
        
        boolean dataInputted = false;

        int pilihan;
        do {
            System.out.println("\n=== MENU UTAMA ===");
            System.out.println("1. Input Data Skor Tim,");
            System.out.println("2. Tampilkan Tabel Skor dan Total Skor");
            System.out.println("3. Tentukan Juara Turnamen");
            System.out.println("4. Keluar");
            System.out.print("Pilih menu (1-4): ");
            pilihan = sc.nextInt();
            sc.nextLine(); 

            switch (pilihan) {
                case 1:
                    for (int i = 0; i < 4; i++) {
                        System.out.print("Masukkan nama tim ke-" + (i + 1) + ": ");
                        namaTim10[i] = sc.nextLine();
                        System.out.print("Masukkan skor " + namaTim10[i] + " untuk Level 1: ");
                        skor10[i][0] = sc.nextInt();
                        System.out.print("Masukkan skor " + namaTim10[i] + " untuk Level 2: ");
                        skor10[i][1] = sc.nextInt();
                        sc.nextLine(); 
                        totalSkor10[i] = skor10[i][0] + skor10[i][1];

                        if (skor10[i][0] > 50 && skor10[i][1] > 50) {
                            totalSkor10[i] += bonusBuff10;
                        }

                        if (totalSkor10[i] % 2 == 0) {
                            totalSkor10[i] -= 15;
                        }
                    }
                    dataInputted = true;
                    System.out.println("Data skor berhasil dimasukkan!");
                    break;

                case 2:

                    if (!dataInputted) {
                        System.out.println("Data belum dimasukkan. Pilih menu 1 terlebih dahulu.");
                    } else {
                        System.out.println("\nNama Tim\tLevel 1\tLevel 2\tTotal Skor");
                        for (int i = 0; i < 4; i++) {
                            System.out.println(namaTim10[i] + "\t\t" + skor10[i][0] + "\t" + skor10[i][1] + "\t" + totalSkor10[i]);
                        }
                    }
                    break;

                case 3:
                    if (!dataInputted) {
                        System.out.println("Data belum dimasukkan. Pilih menu 1 terlebih dahulu.");
                    } else {
                        int maxSkor10 = totalSkor10[0];
                        int indexJuara10 = 0;
                        boolean seri10 = false;

                        for (int i = 1; i < 4; i++) {
                            if (totalSkor10[i] > maxSkor10) {
                                maxSkor10 = totalSkor10[i];
                                indexJuara10 = i;
                                seri10 = false; 
                            } else if (totalSkor10[i] == maxSkor10) {
                                seri10 = true;
                            }
                        }

                        if (seri10) {
                            int maxLevel210 = skor10[0][1];
                            int indexLevel210 = 0;

                            for (int i = 1; i < 4; i++) {
                                if (totalSkor10[i] == maxSkor10 && skor10[i][1] > maxLevel210) {
                                    maxLevel210 = skor10[i][1];
                                    indexLevel210 = i;
                                }
                            }

                            System.out.println("Selamat kepada Tim " + namaTim10[indexLevel210] + " yang telah memenangkan kompetisi!");
                        } else {
                            System.out.println("Selamat kepada Tim " + namaTim10[indexJuara10] + " yang telah memenangkan kompetisi!");
                        }
                    }
                    break;

                case 4:
                    System.out.println("Terima kasih! Program selesai.");
                    break;

                default:
                    System.out.println("Pilihan tidak valid! Silakan pilih menu 1-4.");
            }
        } while (pilihan != 4);

        sc.close();
    }
}