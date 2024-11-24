import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Exp6SJF {
    static class Process implements Comparable<Process>{
        int pid;
        int burstTime;
        int arrivalTime;
        int turnaroundTime;
        int waitingTime;
        int completionTime;

        public Process(int pid, int burstTime, int arrivalTime) {
            this.pid = pid;
            this.burstTime = burstTime;
            this.arrivalTime = arrivalTime;
        } 
        
        @Override
        public int compareTo(Process p2) {
            return this.burstTime - p2.burstTime;
        }

    }

    public static void main(String[] args) {
        PriorityQueue<Process> pq = new PriorityQueue<>();
        pq.add(new Process(1, 6, 2));
        pq.add(new Process(2, 2, 5));
        pq.add(new Process(3, 8, 1));
        pq.add(new Process(4, 3, 0));
        pq.add(new Process(5, 4, 4));

        Queue<Integer> q = new LinkedList<>();

        

        int currentTime = 0;

        while (!pq.isEmpty()) {
            Process curr = pq.remove();

            if (curr.arrivalTime <= currentTime) {
                currentTime = currentTime + curr.burstTime;
                q.add(curr.pid);
            } else {
                pq.add(curr);
            }
        }

        System.out.println(q);

    }
}