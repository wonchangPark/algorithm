import java.util.*;

class Solution {
    
    static class Time implements Comparable<Time>{
        int startTime;
        int endTime;
        
        public Time(int startTime, int endTime){
            this.startTime = startTime;
            this.endTime = endTime;
        }
        
        public int compareTo(Time time){
            if(this.startTime == time.startTime){
                return this.endTime - time.endTime;
            }
            return this.startTime - time.startTime;
        }
    }
    
    public int solution(String[][] book_time) {
        PriorityQueue<Time> pq = new PriorityQueue<>();
        int reservationCnt = book_time.length;
        for(int i=0; i<reservationCnt; i++){
            String start = book_time[i][0];
            String end = book_time[i][1];
            String[] startArr = start.split(":");
            String[] endArr = end.split(":");
            int startTime = Integer.parseInt(startArr[0]) * 60 + Integer.parseInt(startArr[1]);
            int endTime = Integer.parseInt(endArr[0]) * 60 + Integer.parseInt(endArr[1]) + 10;
            pq.add(new Time(startTime, endTime));
        }
        
        PriorityQueue<Time> pq2 = new PriorityQueue<>(new Comparator<Time>(){
            @Override
            public int compare(Time o1, Time o2){
                return o1.endTime - o2.endTime;
            }
        });
          
        pq2.add(pq.poll());
        while(!pq.isEmpty()){
            Time t1 = pq.poll();
            Time t2 = pq2.peek();
            if(t2.endTime <= t1.startTime){
                pq2.poll();
            }
            pq2.add(t1);
        }
        
        return pq2.size();
    }
}