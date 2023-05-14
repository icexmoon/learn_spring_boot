package cn.icexmoon.demo.books.system.util;

public class TestUtil {
    private static String[] images = {
            "https://www.keaidian.com/uploads/allimg/190424/24110307_6.jpg",
            "https://www.keaidian.com/uploads/allimg/190424/24110307_1.jpg",
            "https://www.keaidian.com/uploads/allimg/190424/24110307_2.jpg",
            "https://www.keaidian.com/uploads/allimg/190424/24110307_4.jpg",
            "https://www.keaidian.com/uploads/allimg/190424/24110307_3.jpg",
    };

    public static String getTestImg(int index) {
        return images[index];
    }
}
