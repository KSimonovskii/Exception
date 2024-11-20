package telran.memory.utils;

public class MemoryService {
    public static int getMaxAvailableMemory() {
        int size = Integer.MAX_VALUE;
        int maxSize = size;
        int minSize = 0;

        int div = 2;
        int factor = 1;
        int j = 0;

        int[] arr = new int[0];

        while (true) {
            try {
                arr = new int[size];
                minSize = size;
                factor = 1;
            } catch (Throwable e) {
                maxSize = size;
                factor = -1;
            } finally {
                if (maxSize - minSize <= 1) {
                    break;
                }
                size = size + ((maxSize - minSize) / div * factor);
                j++;
            }
        }

        return arr.length;
    }


}
