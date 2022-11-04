/**
 * The read4 API is defined in the parent class Reader4.
 * int read4(char[] buf4);
 */

public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Number of characters to read
     * @return The number of actual characters read
     */
    int indexLastTime = 0;
    int sizeLastTime = 0;
    char[] buffLastTime = new char[4];

    public int read(char[] buf, int n) {
        int counter = 0;
        while (counter < n) {
            if (indexLastTime < sizeLastTime) {
                buf[counter] = buffLastTime[indexLastTime];
                counter++;
                indexLastTime++;
            } else {
                sizeLastTime = read4(buffLastTime);
                indexLastTime = 0;
                if (sizeLastTime == 0) {
                    break;
                }
            }
        }
        return counter;
    }
}
