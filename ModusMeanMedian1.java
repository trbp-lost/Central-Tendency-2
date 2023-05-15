import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ModusMeanMedian1 {
    private static List<Integer> modusData = new ArrayList<>();
    private static int maxCount = 0;
    private static int[] dataArray;

    public static String getModus(int[] dataArray) {

        for (int i = 0; i < dataArray.length; i++) {
            int count = 0;

            for (int j = 0; j < dataArray.length; j++) {
                if (dataArray[i] == dataArray[j]) {
                    count++;
                    maxCount = count;
                }
            }
        }

        for (int i = 0; i < dataArray.length; i++) {
            int count = 0;

            for (int j = 0; j < dataArray.length; j++) {
                if (dataArray[i] == dataArray[j]) count++;
            }
            
            if (count > maxCount) {
                if (modusData.contains(dataArray[i])==false) modusData.add(dataArray[i]);
            }
        }

        modusData.sort(null);
        return modusData.toString();
    }

    public static float getMean(int[] dataArray) {
        int sum = 0;

        for (int i = 0; i < dataArray.length; i++) {
            sum += dataArray[i];
        }
        return (float)sum / dataArray.length;
    }

    public static int getMedian(int[] dataArray) {
        Arrays.sort(dataArray);

        if (dataArray.length % 2 == 0) {
            int middleIndex1 = dataArray.length / 2;
            int middleIndex2 = middleIndex1 - 1;
            return (int)dataArray[(dataArray[middleIndex1] + dataArray[middleIndex2]) / 2];
        } else {
            int middleIndex = dataArray.length / 2;
            return dataArray[middleIndex];
        }
    }

    public static void main(String[] args) {
        int pil, banyakData;
        do {
            Scanner input = new Scanner(System.in);
            System.out.println("\n=== Menu ===");
            System.out.println("1. Modus, Mean dan Median");
            System.out.println("2. Keluar");
            System.out.print("Pilhan : ");
            pil = input.nextInt();
            
            switch (pil) {
                case 1:
                    if (dataArray != null) {
                        dataArray = null;
                    }
                    System.out.print("\nBanyak data : ");
                    banyakData = input.nextInt();

                    dataArray = new int[banyakData];
                    for (int i = 0; i < banyakData; i++) {
                        System.out.printf("data ke-%d : ", i+1);
                        dataArray[i] = input.nextInt();
                    }

                    System.out.printf("\nModus: %s\n", getModus(dataArray));
                    System.out.printf("Mean: %.3f\n", getMean(dataArray));
                    System.out.printf("Median: %d\n", getMedian(dataArray));
                    break;
                
                case 2:
                    System.exit(0);
                    break;
            
                default:
                    System.out.println("Pilihan tidak sesuai\n");
                    main(args);
                    break;
            }

        } while (true);
        
    }
}
