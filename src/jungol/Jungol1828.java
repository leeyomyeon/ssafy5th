package jungol;

import java.util.Arrays;
import java.util.Scanner;

public class Jungol1828 {
    public static class material implements Comparable<material>{
        int minTemp;
        int maxTemp;

        material(int minTemp, int maxTemp) {
            this.minTemp = minTemp;
            this.maxTemp = maxTemp;
        }

        @Override
        public int compareTo(material o) {
            if(maxTemp == o.maxTemp) {
                return minTemp - o.minTemp;
            }
            return maxTemp - o.maxTemp;
        }   // 최소 온도로 정렬
    }

    static int n;
    static material[] materials;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        n = scanner.nextInt();
        materials = new material[n];

        for(int i = 0; i < n; i++) {
            materials[i] = new material(scanner.nextInt(), scanner.nextInt());
        }

        Arrays.sort(materials);

        int count = 1;
        material maxMaterial = materials[0];

        for(int i = 0; i < n; i++) {
            if(maxMaterial.maxTemp < materials[i].minTemp) {
                maxMaterial = materials[i];
                count++;
            }
        }

        System.out.println(count);
    }
}
