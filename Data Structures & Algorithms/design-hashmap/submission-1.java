class MyHashMap {
    private final static int SIZE = 2039;
    private Node[] dataMap;

    class Node {
        private int key;
        private int value;
        private Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    public MyHashMap() {
        dataMap = new Node[SIZE];
    }

    private int hash(int key) {
        return (key * 23) % SIZE;
    }
    
    public void put(int key, int value) {
        int index = hash(key);
        Node newNode = new Node(key, value);

        Node curr = dataMap[index];
        if (curr == null) {
            dataMap[index] = newNode;
            return;
        }

        while (true) {
            if (curr.key == key) {
                curr.value = value;
                return;
            }

            if (curr.next == null) break;

            curr = curr.next;
        }

        curr.next = newNode;
    }
    
    public int get(int key) {
        int index = hash(key);
        Node curr = dataMap[index];

        while (curr != null) {
            if (curr.key == key) return curr.value;
            curr = curr.next;
        }

        return -1;
    }
    
    public void remove(int key) {
        int index = hash(key);
        Node curr = dataMap[index];
        Node prev = null;

        while (curr != null) {
            if (curr.key == key) {
                if (prev == null) {
                    dataMap[index] = curr.next;  // first node had that key
                } else {
                    prev.next = curr.next;
                }
                return;
            }

            prev = curr;
            curr = curr.next;
        }
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
