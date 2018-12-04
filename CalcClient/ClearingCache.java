public class ClearingCache implements Runnable {
    private Caches caches = new Caches();
    @Override
    public void run() {
        try {
            int delay = 20000;
            Thread.sleep(delay);

            int cacheSecondLimit = 10;
            if (caches.getSizeCacheSecond()> cacheSecondLimit){
                int countRemove = caches.getSizeCacheSecond() - cacheSecondLimit;

                for (int i=0; i<countRemove; i++) {
                    caches.removeItemCashSecond(i);
                }
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
