package com.lomoye.concurrency.frokJoin.section3;

import java.util.Random;

/**
 * Created by lomoye on 2017/7/21.
 */
public class DocumentMock {
    private String words[] = {"the", "hello", "goodbye", "packt", "java", "thread", "pool", "random", "class", "main"};

    public String[][] generateDocument(int numLines, int numWords, String word) {
        //首先，创建生成这个文档必需的对象：字符串二维对象和生成随机数的Random对象。
        int counter = 0;
        String document[][] = new String[numLines][numWords];
        Random random = new Random();

        //用字符串填充这个数组。存储在每个位置的字符串是单词数组的随机位置，统计这个程序将要在生成的数组中查找的单词出现的次数。你可以使用这个值来检查程序是否执行正确。
        for (int i = 0; i < numLines; i++) {
            for (int j = 0; j < numWords; j++) {
                int index = random.nextInt(words.length);
                document[i][j] = words[index];
                if (document[i][j].equals(word)) {
                    counter++;
                }
            }
        }


        System.out.println("DocumentMock: The word appears " + counter + " times in the document");
        return document;
    }
}
