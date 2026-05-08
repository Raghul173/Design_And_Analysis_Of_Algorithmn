import java.util.*;

class Item {
    int weight, profit;
    double ratio;

    Item(int w, int p) {
        weight = w;
        profit = p;
        ratio = (double) p / w;
    }
}

class Node {
    int level, profit, weight;
    double bound;
}

public class KnapsackBB {

    // Calculate Upper Bound
    static double bound(Node u, int n, int W, Item[] items) {

        if (u.weight >= W)
            return 0;

        double profitBound = u.profit;
        int j = u.level + 1;
        int totalWeight = u.weight;

        // Add full items
        while (j < n && totalWeight + items[j].weight <= W) {
            totalWeight += items[j].weight;
            profitBound += items[j].profit;
            j++;
        }

        // Add fractional item
        if (j < n) {
            profitBound += (W - totalWeight) * items[j].ratio;
        }

        return profitBound;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of items: ");
        int n = sc.nextInt();

        Item[] items = new Item[n];

        System.out.println("Enter weight and profit:");

        for (int i = 0; i < n; i++) {
            int w = sc.nextInt();
            int p = sc.nextInt();

            items[i] = new Item(w, p);
        }

        System.out.print("Enter capacity: ");
        int W = sc.nextInt();

        // Sort by ratio
        Arrays.sort(items,
                (a, b) -> Double.compare(b.ratio, a.ratio));

        Queue<Node> q = new LinkedList<>();

        Node u = new Node();
        Node v = new Node();

        u.level = -1;
        u.profit = 0;
        u.weight = 0;
        u.bound = bound(u, n, W, items);

        q.add(u);

        int maxProfit = 0;

        while (!q.isEmpty()) {

            u = q.remove();

            if (u.level == n - 1)
                continue;

            // Include item
            v = new Node();

            v.level = u.level + 1;

            v.weight = u.weight + items[v.level].weight;

            v.profit = u.profit + items[v.level].profit;

            if (v.weight <= W && v.profit > maxProfit)
                maxProfit = v.profit;

            v.bound = bound(v, n, W, items);

            if (v.bound > maxProfit)
                q.add(v);

            // Exclude item
            v = new Node();

            v.level = u.level + 1;

            v.weight = u.weight;

            v.profit = u.profit;

            v.bound = bound(v, n, W, items);

            if (v.bound > maxProfit)
                q.add(v);
        }

        System.out.println("Maximum Profit = " + maxProfit);

        sc.close();
    }
}

//Sort items by profit/weight
//Use Queue for Branch and Bound
//Include item / Exclude item
//Use bound() to decide whether to continue
