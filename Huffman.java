import java.util.PriorityQueue;
import java.util.Scanner;

// Node Class
class Node {
    char ch;
    int freq;
    Node left, right;

    Node(char ch, int freq) {
        this.ch = ch;
        this.freq = freq;
    }
}

public class Huffman {

    // Print Huffman Codes
    static void print(Node root, String code) {

        if (root.left == null && root.right == null) {
            System.out.println(root.ch + " : " + code);
            return;
        }

        print(root.left, code + "0");
        print(root.right, code + "1");
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of characters: ");
        int n = sc.nextInt();

        char ch[] = new char[n];
        int freq[] = new int[n];

        System.out.println("Enter characters:");

        for (int i = 0; i < n; i++) {
            ch[i] = sc.next().charAt(0);
        }

        System.out.println("Enter frequencies:");

        for (int i = 0; i < n; i++) {
            freq[i] = sc.nextInt();
        }

        // Priority Queue
        PriorityQueue<Node> pq =
                new PriorityQueue<>((a, b) -> a.freq - b.freq);

        // Create nodes
        for (int i = 0; i < n; i++) {
            pq.add(new Node(ch[i], freq[i]));
        }

        // Build Tree
        while (pq.size() > 1) {

            Node left = pq.poll();
            Node right = pq.poll();

            Node newNode =
                    new Node('-', left.freq + right.freq);

            newNode.left = left;
            newNode.right = right;

            pq.add(newNode);
        }

        Node root = pq.poll();

        System.out.println("Huffman Codes:");

        print(root, "");

        sc.close();
    }
}


//Enter number of characters: 4
//Enter characters:
//A B C D
//Enter frequencies:
//5 1 6 3

//Huffman Codes:
//C : 0
//A : 10
//D : 110
//B : 111

//Create node
//Store in priority queue
//Remove 2 smallest nodes
//Join them and print 0/1
