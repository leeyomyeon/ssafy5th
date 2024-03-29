import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
/* 출처 : https://www.geeksforgeeks.org/fast-io-in-java-in-competitive-programming/ */
public class FastIO {
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out), 1024 * 64);

    public static void main(String[] args) throws Exception {
        FastReader fr = new FastReader();
        bw.write("");
        bw.flush();
        bw.close();
    }

    public static class FastReader {
        private final DataInputStream din;
        private final int BUFFER_SIZE = 1 << 16;
        private final byte[] buffer;
        private int bufferPointer, bytesRead;

        public FastReader() {
            din = new DataInputStream(System.in);
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public String readLine() throws IOException {
            byte[] buf = new byte[BUFFER_SIZE]; // input line length
            int cnt = 0, c;
            while ((c = read()) != -1) {
                if (c == '\n') {
                    break;
                }
                buf[cnt++] = (byte) c;
            }
            return new String(buf, 0, cnt);
        }

        public int nextInt() throws IOException {
            int ret = 0;
            byte c = read();
            while (c <= ' ') {
                c = read();
            }
            boolean neg = (c == '-');
            if (neg) {
                c = read();
            }
            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');

            if (neg) {
                return -ret;
            }
            return ret;
        }

        public long nextLong() throws IOException {
            long ret = 0;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do {
                ret = ret * 10 + c - '0';
            }
            while ((c = read()) >= '0' && c <= '9');
            if (neg)
                return -ret;
            return ret;
        }

        public double nextDouble() throws IOException {
            double ret = 0, div = 1;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();

            do {
                ret = ret * 10 + c - '0';
            }
            while ((c = read()) >= '0' && c <= '9');

            if (c == '.') {
                while ((c = read()) >= '0' && c <= '9') {
                    ret += (c - '0') / (div *= 10);
                }
            }

            if (neg)
                return -ret;
            return ret;
        }

        private void fillBuffer() throws IOException {
            bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
            if (bytesRead == -1) {
                buffer[0] = -1;
            }
        }

        private byte read() throws IOException {
            if (bufferPointer == bytesRead) {
                fillBuffer();
            }
            return buffer[bufferPointer++];
        }
        
        public static void fastNumberWrite(int current) throws Exception {
            boolean abs = current < 0;
            if (abs) {
                current *= -1;
                bw.write(45);
            }
            int size = current == 0 ? 0 : (int) Math.log10(current);
            while (size >= 0) {
                int nextSize = current == 0 ? 0 : (int) Math.log10(current);
                int div = (int) Math.pow(10, nextSize);
                while (size > nextSize) {
                    bw.write(48);
                    size--;
                }
                bw.write((current / div) + 48);
                current %= div;
                size--;
            }
        }

        public static void fastNumberWrite(long current) throws Exception {
            boolean abs = current < 0;
            if (abs) {
                current *= -1;
                bw.write(45);
            }
            int size = current == 0 ? 0 : (int) Math.log10(current);
            while (size >= 0) {
                int nextSize = current == 0 ? 0 : (int) Math.log10(current);
                long div = (int) Math.pow(10, nextSize);
                while (size > nextSize) {
                    bw.write(48);
                    size--;
                }
                bw.write((int) ((current / div) + 48));
                current %= div;
                size--;
            }
        }
        
        public int nextCharToInt() throws IOException {
            byte c = read();
            if(c == '\n') {
                c = read();
            }
            return c - 'A';
        }
    }
}
