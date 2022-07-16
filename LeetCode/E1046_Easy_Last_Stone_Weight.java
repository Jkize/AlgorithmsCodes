import java.util.PriorityQueue;

/**
 * 1046. Last Stone Weight
 * #easy #priority #queue
 */
public class E1046_Easy_Last_Stone_Weight {

    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxPQ = new PriorityQueue<>((a, b) -> b - a);
        for (int w : stones) {
            maxPQ.add(w);
        }

        while (maxPQ.size() >= 2) {
            // Substract the two nums. But if the two is null so we put 0
            int smash = maxPQ.poll() - ((maxPQ.peek() != null) ? maxPQ.poll() : 0);
            if (smash > 0) {
                maxPQ.add(smash);
            }
        }

        return (maxPQ.peek() != null) ? maxPQ.poll() : 0;

    }

}
