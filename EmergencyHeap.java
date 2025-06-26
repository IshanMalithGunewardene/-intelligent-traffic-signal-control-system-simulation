import java.util.*;

public class EmergencyHeap {
    private List<Emergency> heap = new ArrayList<>();

    public void addEmergency(Emergency emergency) {
        heap.add(emergency);
        heapifyUp(heap.size() - 1);
    }

    public Emergency getHighestPriority() {
        if (heap.isEmpty()) return null;
        Emergency emergency = heap.get(0);
        heap.set(0, heap.get(heap.size() - 1));
        heap.remove(heap.size() - 1);
        heapifyDown(0);
        return emergency;
    }

    private void heapifyUp(int index) {
        while (index > 0) {
            int parent = (index - 1) / 2;
            if (heap.get(index).priority > heap.get(parent).priority) {
                Collections.swap(heap, index, parent);
                index = parent;
            } else break;
        }
    }

    private void heapifyDown(int index) {
        int size = heap.size();
        while (index < size) {
            int left = 2 * index + 1;
            int right = 2 * index + 2;
            int largest = index;

            if (left < size && heap.get(left).priority > heap.get(largest).priority)
                largest = left;
            if (right < size && heap.get(right).priority > heap.get(largest).priority)
                largest = right;

            if (largest != index) {
                Collections.swap(heap, index, largest);
                index = largest;
            } else break;
        }
    }
}
