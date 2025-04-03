package TT_file;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class XuLyDongThoi {
    public static void docTapTinDongThoi(String[] danhSachTapTin) {
        ExecutorService executor = Executors.newFixedThreadPool(danhSachTapTin.length);
        for (String tapTin : danhSachTapTin) {
            executor.execute(() -> QuanLyTapTin.docTapTin(tapTin));
        }
        executor.shutdown();
    }
}
