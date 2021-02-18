package swea.d0210;

import java.util.Scanner;
public class swea상호의배틀필드 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int T = scanner.nextInt();

        for(int tc = 1; tc <= T; tc++) {

            int h = scanner.nextInt();  // 높이
            int w = scanner.nextInt();  // 너비

            String [][] map= new String[h][w];

            int m = 0, n = 0;   // 전차의 현재 x, y좌표
            int dIndex = 0;     // 전차의 현재 방향을 알릴 인덱스
            String[] dir = {"^", "v", "<", ">"};

            for(int i = 0; i < h; i++) {
                map[i] = scanner.next().split("");
                for(int j = 0; j < w; j++) {
                    for(int k = 0; k < dir.length; k++) {
                        if(map[i][j].equals(dir[k])) {
                            dIndex = k;
                            m = i;
                            n = j;
                            map[i][j] = ".";
                        }
                    }
                }
            }

            scanner.nextInt();
            String motion[] = scanner.next().split("");
            // 현재 위치 map[m][n];
            for(int i = 0; i < motion.length; i++) {
                switch (motion[i]) {
                    case "U":
                        dIndex = 0;
                        if(m - 1 >= 0 && map[m - 1][n].equals(".")) {   // 전차 위쪽이 평지일 때만 이동
                            m -= 1;
                        }
                        break;
                    case "D":
                        dIndex = 1;
                        if(m + 1 < h && map[m + 1][n].equals(".")) {   // 전차 아래쪽이 평지일 때만 이동
                            m += 1;
                        }
                        break;
                    case "L":
                        dIndex = 2;
                        if(n - 1 >= 0 && map[m][n - 1].equals(".")) {   // 전차 왼쪽이 평지일 때만 이동
                            n -= 1;
                        }
                        break;
                    case "R":
                        dIndex = 3;
                        if(n + 1 < w && map[m][n + 1].equals(".")) {   // 전차 오른쪽이 평지일 시
                            n += 1;
                        }
                        break;
                    case "S":
                        // 0 1 2 3 = 상 하 좌 우 현재위치 [m][n]
                        int k = m;
                        int j = n;
                        if(dIndex == 0) {
                            while(k > 0) {
                                k--;
                                if(map[k][n].equals("*")) {
                                    map[k][n] = ".";
                                    break;
                                } else if (map[k][n].equals("#")) {
                                    break;
                                }
                            }
                        } else if (dIndex == 1) {
                            while(k < h - 1) {
                                k++;
                                if(map[k][n].equals("*")) {
                                    map[k][n] = ".";
                                    break;
                                } else if (map[k][n].equals("#")) {
                                    break;
                                }
                            }
                        } else if (dIndex == 2) {
                            while(j > 0) {
                                j--;
                                if(map[m][j].equals("*")) {
                                    map[m][j] = ".";
                                    break;
                                } else if (map[m][j].equals("#")) {
                                    break;
                                }
                            }
                        } else if (dIndex == 3) {
                            while(j < w - 1) {
                                j++;
                                if(map[m][j].equals("*")) {
                                    map[m][j] = ".";
                                    break;
                                } else if (map[m][j].equals("#")) {
                                    break;
                                }
                            }
                        }
                        break;
                }
            }

            map[m][n] = dir[dIndex];

            System.out.print("#" + tc + " ");
            for(String t[] : map) {
                for(String s : t) {
                    System.out.print(s);
                }
                System.out.println();
            }
        }
    }
}
