package swea.d0210;

import java.util.Scanner;
public class 배필2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int T = scanner.nextInt();

        for(int tc = 1; tc <= T; tc++) {

            int h = scanner.nextInt();
            int w = scanner.nextInt();

            char [][] map= new char[h][w];

            int m = 0, n = 0;
            int dIndex = 0;
            char[] dir = {'^', 'v', '<', '>'};

            for(int i = 0; i < h; i++) {
                String str = scanner.next();
                map[i] = str.toCharArray();
                for(int j = 0; j < w; j++) {
                    for(int k = 0; k < dir.length; k++) {
                        if(map[i][j] == (dir[k])) {
                            dIndex = k;
                            m = i;
                            n = j;
                            map[i][j] = '.';
                        }
                    }
                }
            }

            scanner.nextInt();
            String mot = scanner.next();
            char[] motion = mot.toCharArray();

            for(int i = 0; i < motion.length; i++) {
                if(motion[i] == 'U') {
                    dIndex = 0;
                    if(m - 1 >= 0 && map[m - 1][n] == '.') {
                        m -= 1;
                    }
                } else if (motion[i] == 'D') {
                    dIndex = 1;
                    if(m + 1 < h && map[m + 1][n] == '.') {
                        m += 1;
                    }
                } else if (motion[i] == 'L') {
                    dIndex = 2;
                    if(n - 1 >= 0 && map[m][n - 1] == '.') {
                        n -= 1;
                    }
                } else if (motion[i] == 'R') {
                    dIndex = 3;
                    if(n + 1 < w && map[m][n + 1] == '.') {
                        n += 1;
                    }
                } else if (motion[i] == 'S') {
                    int k = m;
                    int j = n;
                    if (dIndex == 0) {
                        while (k > 0) {
                            k--;
                            if (map[k][n] == '*') {
                                map[k][n] = '.';
                                break;
                            } else if (map[k][n] == '#') {
                                break;
                            }
                        }
                    } else if (dIndex == 1) {
                        while (k < h - 1) {
                            k++;
                            if (map[k][n] == '*') {
                                map[k][n] = '.';
                                break;
                            } else if (map[k][n] == '#') {
                                break;
                            }
                        }
                    } else if (dIndex == 2) {
                        while (j > 0) {
                            j--;
                            if (map[m][j] == '*') {
                                map[m][j] = '.';
                                break;
                            } else if (map[m][j] == '#') {
                                break;
                            }
                        }
                    } else if (dIndex == 3) {
                        while (j < w - 1) {
                            j++;
                            if (map[m][j] == '*') {
                                map[m][j] = '.';
                                break;
                            } else if (map[m][j] == '#') {
                                break;
                            }
                        }
                    }
                }
            }

            map[m][n] = dir[dIndex];

            System.out.print("#" + tc + " ");
            for(int i = 0; i < h; i++) {
                for(int j = 0; j < w; j++) {
                    System.out.print(map[i][j]);
                }
                System.out.println();
            }
        }
    }
}
