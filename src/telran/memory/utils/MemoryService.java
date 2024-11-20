package telran.memory.utils;

public class MemoryService {
    public static int getMaxAvailableMemory() {
        int size = Integer.MAX_VALUE;
        int div = 2;
        boolean success = false;

        int prevSize = 0;
        int j = 0;
        int diff = size;

        while (true) {

            try {
                int[] arr = new int[size];
                success = true;
                if (size < prevSize) {
                    diff = (prevSize - size) / div;
                }
            } catch (Throwable e) {
                success = false;
                if (size > prevSize) {
                    diff = (prevSize - size) / div;
                }
            } finally {

                if (size == prevSize) {
                    size = success? size: size - 1;
                    break;
                }

                prevSize = size;
                size += diff;

                j++;
            }
        }

        return size;
    }


}
