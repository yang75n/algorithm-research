package com.yqw.algorithm;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * 从一亿个IP中统计出每个IP出现的次数。由于电脑内存不够，所以不能一次将数据全部读取，
 * 只能实行分而治之的方法，才能满足空间的需求。可以创建一个hash表，将数据按一定的Key value分类，
 * 我使用了将IP转化成长整形，然后取其后三位转化成字符串作为Key value，这样就能将所有IP按后三位分类。
 * 在往hash表中存入1000000个IP后就可以将这些IP写出到数个txt文件里，txt文件名为Key value，
 * 这样每个小文件中的IP后三位都相同。如此循环，所有IP就会按后三位分类到1000个小文件中，就实现了大文件的分类。
 * 统计所有小文件中每个IP出现的次数就是结果
 */
public class ApartData {

    /**
     * @param FILE_NAME 所要读取的文件名
     */
    public void Apart(String FILE_NAME) {
        //	System.out.print("3");
        File data = new File(FILE_NAME);
        String tempString = null;
        String PATH = "E:\\Data\\SmallData\\apartedData";

        //创建一个哈希表
        Map<String, StringBuilder> map = new HashMap<String, StringBuilder>();

        //用count控制读取多少条内容，往小文件中写入一次
        int count = 0;
        String tempIP;
        try {
            //System.out.print("4");

            BufferedReader reader = new BufferedReader(new FileReader(data));

            while ((tempString = reader.readLine()) != null) {
                //	tempString = reader.readLine();
                //System.out.println(tempString);
//				if(tempString==null){
//					break;
//				}
                int position1 = tempString.indexOf('.');
                int position2 = tempString.indexOf('.', position1 + 1);
                int position3 = tempString.indexOf('.', position2 + 1);

                long ip1 = Long.parseLong(tempString.substring(0, position1));
                long ip2 = Long.parseLong(tempString.substring(position1 + 1, position2));
                long ip3 = Long.parseLong(tempString.substring(position2 + 1, position3));
                long ip4 = Long.parseLong(tempString.substring(position3 + 1));

                //使用位运算为每条IP构造一个与之对应的long
                long ip = (ip1 << 24) + (ip2 << 16) + (ip3 << 8) + ip4;
                //System.out.print("5");
                //用每个ip的后三位生成HashIP 将HashIp相同的写进同一个文件，从而拆开大文件
                String HashIp = String.valueOf(ip % 1000);
                tempIP = String.valueOf(ip);
                if (map.containsKey(HashIp)) {
                    StringBuilder s1 = (StringBuilder) map.get(HashIp);
                    s1.append(tempIP).append('\n');
                    map.put(HashIp, s1);
                } else {
                    StringBuilder s1 = new StringBuilder(tempIP);
                    s1.append('\n');
                    map.put(HashIp, s1);
                }
                count++;
                //每1000000一起往里写一次 大小根据内存决定
                //写完后清空Hash表
                if (count == 1000000) {
                    //System.out.print("6");
                    Iterator<String> it = map.keySet().iterator();

                    while (it.hasNext()) {
                        String name = it.next();
                        //   System.out.println(name);
                        File ApartedIP = new File(PATH + "\\" + name + ".txt");
                        //  System.out.println(name);
                        FileWriter fw = new FileWriter(ApartedIP, true);
                        StringBuilder s = map.get(name);
                        fw.write(s.toString());
                        fw.close();
                    }
                    //	   System.out.print("1");
                    count = 0;
                    map.clear();
                }
            }
            reader.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    int count2 = 0;

    /**
     * @param FOLDER 小文件所在的路径名
     */
    public void count(String FOLDER) {

//		FileReader fr = null;
//		BufferedReader br = null;
        String temp;
        long ip;
        File f = new File(FOLDER);
        File[] f2 = f.listFiles();
        //再新建一个HashMap用来保存每个IP及其出现的次数
        Map<String, Integer> map1 = new HashMap<>();
        for (File file : f2) {
            try {
                BufferedReader br = new BufferedReader(new FileReader(file));
                Map<Long, Integer> map = new HashMap<>();
                while ((temp = br.readLine()) != null) {
                    ip = Long.valueOf(temp);
                    if (map.containsKey(ip)) {
                        int count = map.get(ip);
                        map.put(ip, count + 1);
                    } else {
                        map.put(ip, 1);
                    }
                }
                br.close();
                Iterator<Long> it = map.keySet().iterator();
                //反向位运算还原IP

                while (it.hasNext()) {
                    long l = it.next();
                    long l1 = l >> 24;
                    long l2 = (l - (l1 << 24)) >> 16;
                    long l3 = (l - (l1 << 24) - (l2 << 16)) >> 8;
                    String IP = String.valueOf(l1) + "." + String.valueOf(l2) + "." + String.valueOf(l3) + "." + (l - ((l >> 8) << 8));
                    System.out.println("IP" + IP + "  被访问次数是: " + map.get(l));
                }
                map.clear();
            } catch (FileNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        }
    }

    public static void main(String[] args) {
        ApartData ad = new ApartData();
        long time = System.currentTimeMillis();
        //ad.Apart("E:\\Data\\SmallData\\ipdata_small.txt");
        ad.Apart("E:\\Data\\ipdata.ipdata");
        ad.count("E:\\Data\\SmallData\\apartedData");
        System.out.println("\r执行耗时 : " + (System.currentTimeMillis() - time)
                / 1000f + " 秒 ");
    }
}