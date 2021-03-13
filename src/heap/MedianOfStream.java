package heap;

import java.util.PriorityQueue;

public class MedianOfStream {

    PriorityQueue<Integer> maxHeap;
    PriorityQueue<Integer> minHeap;

    public MedianOfStream() {
        maxHeap = new PriorityQueue<>((a, b) -> b - a);
        minHeap = new PriorityQueue<>((a, b) -> a - b);

    }

    public void insertNumber(int num) {

       if(maxHeap.isEmpty() || num<=maxHeap.peek())
       {
           maxHeap.add(num);
       }else{
            minHeap.add(num);
        }
        balanceHeaps();
    }

    private void balanceHeaps() {

        if (maxHeap.size() < minHeap.size()) {
            int temp = minHeap.poll();
            maxHeap.add(temp);
        }else if(maxHeap.size()>minHeap.size()+1)
        {
            minHeap.add(maxHeap.poll());
        }


    }


    public Double findMedian() {

        if (maxHeap.size() == minHeap.size())
            return ((double) maxHeap.peek() / 2 + (double) minHeap.peek() / 2);

        return (double) maxHeap.peek();


    }

    public static void main(String[] args) {
        /*
        * insertNum(3)
2. insertNum(1)
3. findMedian() -> output: 2
4. insertNum(5)
5. findMedian() -> output: 3
6. insertNum(4)
7. findMedian() -> output: 3.5
        * */


        MedianOfStream medianOfStream=new MedianOfStream();

        medianOfStream.insertNumber(3);
        medianOfStream.insertNumber(1);
        System.out.println(medianOfStream.findMedian());
        medianOfStream.insertNumber(5);
        System.out.println(medianOfStream.findMedian());
        medianOfStream.insertNumber(4);
        System.out.println(medianOfStream.findMedian());





    }

}
