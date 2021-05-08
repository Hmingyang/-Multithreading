import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.io.File;
import java.net.URL;
import java.util.concurrent.*;

public class TestThread_callable implements Callable<Boolean> {
    private String url;
    private String name;

    public TestThread_callable(String url, String name) {
        this.url = url;
        this.name = name;
    }

    @Override
    public Boolean call() {
        WebDownloader webDownloader = new WebDownloader();
        webDownloader.download(url, name);
        System.out.println("下载了文件名:" + name);
        return  true;
    }


    public static void main(String[] args) throws ExecutionException, InterruptedException {
        TestThread_callable t1 = new TestThread_callable("https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fpic1.zhimg.com%2Fv2-8645a0264722f4dedff1b6df3b009d70_r.jpg&refer=http%3A%2F%2Fpic1.zhimg.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=jpeg?sec=1622785995&t=154ccd87c7c759f9b9116c952e555694", "./pic/5.jpg");
        TestThread_callable t2 = new TestThread_callable("https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fi0.hdslb.com%2Fbfs%2Farticle%2F5d7b7e7bc422d8c0d0d55b6a8e69b21f90a5f29a.jpg&refer=http%3A%2F%2Fi0.hdslb.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=jpeg?sec=1622785978&t=4dafb551e2ef40f15463a22c4d44d082", "./pic/6.jpg");
        TestThread_callable t3 = new TestThread_callable("https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fi1.hdslb.com%2Fbfs%2Farchive%2F1196ddbc13f4f236b58bb2f0fa04e5ee28df1c55.jpg&refer=http%3A%2F%2Fi1.hdslb.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=jpeg?sec=1622293026&t=a00703afafee51bcf1e0800064339857", "./pic/4.jpg");
        ExecutorService ser= Executors.newFixedThreadPool(3);//线程池
        Future<Boolean> r1= ser.submit(t1);
        Future<Boolean> r2=  ser.submit(t2);
        Future<Boolean> r3= ser.submit(t3);
        boolean rs1=r1.get();
        boolean rs2=r2.get();
        boolean rs3=r3.get();
        ser.shutdown();
    }

    class WebDownloader {
        public void download(String url, String name) {

            try {
                FileUtils.copyURLToFile(new URL(url), new File(name));
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("IO异常");
            }
        }
    }
}


