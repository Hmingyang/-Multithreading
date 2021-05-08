
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.io.File;
import java.net.URL;
public class TestThread2 extends Thread {
        private String url;
        private String name;

    public TestThread2(String url, String name) {
        this.url = url;
        this.name = name;
    }
    @Override
    public void run() {
        WebDownloader webDownloader=new WebDownloader();
        webDownloader.download(url,name);
        System.out.println("下载了文件名:"+name);
    }


    public static void main(String[] args) {
        TestThread2 t1=new TestThread2("http://pic1.win4000.com/wallpaper/2018-06-13/5b20b1cb0377e.jpg","./pic/2.jpg");
        TestThread2 t2=new TestThread2("https://gimg2.baidu.com/image_search/src=http%3A%2F%2F00.minipic.eastday.com%2F20170724%2F20170724000002_d41d8cd98f00b204e9800998ecf8427e_2.jpeg&refer=http%3A%2F%2F00.minipic.eastday.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=jpeg?sec=1622292820&t=9cdb5e9217e477d111181e6d28d4f7a9","./pic/3.jpg");
        TestThread2 t3=new TestThread2("https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fi1.hdslb.com%2Fbfs%2Farchive%2F1196ddbc13f4f236b58bb2f0fa04e5ee28df1c55.jpg&refer=http%3A%2F%2Fi1.hdslb.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=jpeg?sec=1622293026&t=a00703afafee51bcf1e0800064339857","./pic/4.jpg");
        t1.start();
        t2.start();
        t3.start();
    }

    }
class WebDownloader{
    public  void download(String url,String name) {

        try {
            FileUtils.copyURLToFile(new URL(url), new File(name));
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("IO异常");
        }
    }
}

