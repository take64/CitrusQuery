package tk.citrus.query;

import org.junit.jupiter.api.Test;

public class BenchmarkTest
{
    @Test
    public void 文字列連結ベンチマーク()
    {
        long start;
        long end;
        long loop = 10000;
        String text;

        // +連結
        text = "";
        start = System.currentTimeMillis();
        for (int i = 0; i < loop; i++)
        {
            text += "abc";
        }
        end = System.currentTimeMillis();
        System.out.println("+\t\t:" + (end - start) + "ms");

        // concat連結
        text = "";
        start = System.currentTimeMillis();
        for (int i = 0; i < loop; i++)
        {
            text = text.concat("abc");
        }
        end = System.currentTimeMillis();
        System.out.println("concat\t:" + (end - start) + "ms");

        // builder連結
        StringBuilder builder = new StringBuilder("");
        start = System.currentTimeMillis();
        for (int i = 0; i < loop; i++)
        {
            builder.append("abc");
        }
        end = System.currentTimeMillis();
        text = builder.toString();
        System.out.println("builder\t:" + (end - start) + "ms");

        // buffer連結
        StringBuffer buffer = new StringBuffer("");
        start = System.currentTimeMillis();
        for (int i = 0; i < loop; i++)
        {
            buffer.append("abc");
        }
        end = System.currentTimeMillis();
        text = buffer.toString();
        System.out.println("buffer\t:" + (end - start) + "ms");

        // format連結
        text = "";
        start = System.currentTimeMillis();
        for (int i = 0; i < loop; i++)
        {
            text = String.format("%s%s", text, "abc");
        }
        end = System.currentTimeMillis();
        System.out.println("format\t:" + (end - start) + "ms");

        // buffer連結
        buffer = new StringBuffer("");
        start = System.currentTimeMillis();
        for (int i = 0; i < loop; i++)
        {
            buffer.append("abc");
        }
        end = System.currentTimeMillis();
        text = buffer.toString();
        System.out.println("buffer\t:" + (end - start) + "ms");

    }


}
