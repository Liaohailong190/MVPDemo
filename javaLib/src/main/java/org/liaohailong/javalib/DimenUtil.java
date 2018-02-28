package org.liaohailong.javalib;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class DimenUtil {

    public static void main(String args[]){
        //模板
        File file = new File("D:\\liao\\workspace01\\govservicev2-android\\app\\src\\main\\res\\values\\dimens.xml");
        BufferedReader reader;
        StringBuilder sw360 = new StringBuilder(); //适配4.7,5寸的手机，2k屏手机
        StringBuilder sw540 = new StringBuilder();//适配平板
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
                    sw360.append(start).append(getDimenSp(num,0.72f)).append(end).append("\r\n");
                    sw540.append(start).append(getDimenSp(num ,1f)).append(end).append("\r\n");
                } else {
                    sw360.append(tempString).append("\r\n");
                    sw540.append(tempString).append("\r\n");
                }
            }
            reader.close();
            //写入文件
            String sw360File = generateFile("D:\\liao\\workspace01\\govservicev2-android\\app\\src\\main\\res\\values-sw360dp\\dimens.xml");
            String sw540File = generateFile("D:\\liao\\workspace01\\govservicev2-android\\app\\src\\main\\res\\values-sw540dp\\dimens.xml");

            writeFile(sw360File, sw360.toString());
            writeFile(sw540File, sw540.toString());
        } catch (Exception e) {
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
     * @param filePah
     */
    private static String generateFile(String filePah) throws IOException {
        File file = new File(filePah);
        if (!file.getParentFile().exists()){
            file.getParentFile().mkdirs();
        }
        if (!file.exists()){
            file.createNewFile();
        }
        return filePah;
    }

    /**
     * 写入文件
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
