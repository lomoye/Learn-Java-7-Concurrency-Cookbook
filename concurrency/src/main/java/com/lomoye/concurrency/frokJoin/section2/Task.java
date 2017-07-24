package com.lomoye.concurrency.frokJoin.section2;

import java.util.List;
import java.util.concurrent.RecursiveAction;

/**
 * Created by lomoye on 2017/7/21.
 */
public class Task extends RecursiveAction {

    private List<Product> products;

    private int first;

    private int last;

    private double increment;

    public Task(List<Product> products, int first, int last, double increment) {
        this.products = products;
        this.first = first;
        this.last = last;
        this.increment = increment;
    }

    @Override
    protected void compute() {

        if (last - first < 10) {
            updatePrices();
            //如果last和first的差大于或等于10，则创建两个新的Task对象，一个处理产品的前半部分，另一个处理产品的后半部分，然后在ForkJoinPool中，使用invokeAll()方法执行它们。
        } else {

            int middle = (last + first) / 2;
            System.out.printf("section5: 队列任务数:%s\n", getQueuedTaskCount());
            Task t1 = new Task(products, first, middle , increment);
            Task t2 = new Task(products, middle, last, increment);
            invokeAll(t1, t2);

        }


    }

    private void updatePrices() {

        for (int i = first; i < last; i++) {

            Product product = products.get(i);

            product.setPrice(product.getPrice() * (1 + increment));

        }
    }


}
