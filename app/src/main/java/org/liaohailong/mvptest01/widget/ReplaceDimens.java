package org.liaohailong.mvptest01.widget;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 基于xhdpi生成hdpi,xxhdpi,xxxhdpi文件夹
 * dp*ppi/160 = px
 * hdpi = 240
 * xhdpi = 320
 * xxhdpi = 480
 * xxxhdpi = 640
 */
public class ReplaceDimens {

    public static final void main(String args[]) {
        //模板
        File file = new File("D:\\liao\\dimens.xml");
        BufferedReader reader = null;
        StringBuilder hdpi = new StringBuilder();
        StringBuilder xhdpi_720 = new StringBuilder();
        StringBuilder xxhdpi_1080 = new StringBuilder();
        StringBuilder xxxhdpi = new StringBuilder();
        try {
            reader = new BufferedReader(new FileReader(file));
            String tempString;
            while ((tempString = reader.readLine()) != null) {
                if (tempString.contains("</dimen>")) {
                    String start = tempString.substring(0, tempString.indexOf(">") + 1);
                    String end = tempString.substring(tempString.lastIndexOf("<") - 2);
                    //截取<dimen></dimen>标签内的内容，从>右括号开始，到左括号减2，取得配置的数字
                    Float num = Float.parseFloat(tempString.substring(tempString.indexOf(">") + 1,
                            tempString.indexOf("</dimen>") - 2));
                    //根据不同的尺寸，计算新的值，拼接新的字符串，并且结尾处换行。
                    hdpi.append(start).append(getDimenSp(num, 1.0f)).append(end).append("\r\n");
                    xhdpi_720.append(start).append(getDimenSp(num, 1.0f)).append(end).append("\r\n");
                    xxhdpi_1080.append(start).append(getDimenSp(num, 0.66f)).append(end).append("\r\n");
                    xxxhdpi.append(start).append(getDimenSp(num, 0.5f)).append(end).append("\r\n");
                } else {
                    hdpi.append(tempString).append("\r\n");
                    xhdpi_720.append(tempString).append("\r\n");
                    xxhdpi_1080.append(tempString).append("\r\n");
                    xxxhdpi.append(tempString).append("\r\n");
                }
            }
            reader.close();
            //写入文件
            String hdpiFile = generateFile("D:\\liao\\values-hdpi-1280x720\\dimens.xml");
            String xhdpiFile = generateFile("D:\\liao\\values-xhdpi-1920x1080\\dimens.xml");
            String xxhdpiFile = generateFile("D:\\liao\\values-xxhdpi-1920x1080\\dimens.xml");
            String xxxhdpiFile = generateFile("D:\\liao\\values-xxxhdpi\\dimens.xml");

            writeFile(hdpiFile, hdpi.toString());
            writeFile(xhdpiFile, xhdpi_720.toString());
            writeFile(xxhdpiFile, xxhdpi_1080.toString());
            writeFile(xxxhdpiFile, xxxhdpi.toString());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * 转换dimen内的值，使用进一法
     *
     * @param num
     * @param factor
     * @return
     */
    private static String getDimenSp(float num, float factor) {
        float value = num * factor;
        double ceilValue = Math.ceil(value);
        int result = (int) ceilValue;
        return String.valueOf(result);
    }

    /**
     * 生成文件
     *
     * @param filePah
     */
    private static String generateFile(String filePah) throws IOException {
        File file = new File(filePah);
        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }
        if (!file.exists()) {
            file.createNewFile();
        }
        return filePah;
    }

    /**
     * 写入文件
     *
     * @param file
     * @param text
     */
    public static void writeFile(String file, String text) {
        PrintWriter out = null;
        try {
            out = new PrintWriter(new BufferedWriter(new FileWriter(file)));
            out.println(text);
        } catch (IOException e) {
            e.printStackTrace();
        }
        out.close();
    }
}
