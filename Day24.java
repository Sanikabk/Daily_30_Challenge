import java.util.*;

class Node {
    int val;
    Node left, right;
    Node(int v) {
        val = v;
        left = right = null;
    }
}

public class Main {
    static Node buildTree(Integer[] arr) {
        if (arr.length == 0 || arr[0] == null) return null;
        Node root = new Node(arr[0]);
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        int i = 1;
        while (!q.isEmpty() && i < arr.length) {
            Node curr = q.poll();
            if (i < arr.length && arr[i] != null) {
                curr.left = new Node(arr[i]);
                q.add(curr.left);
            }
            i++;
            if (i < arr.length && arr[i] != null) {
                curr.right = new Node(arr[i]);
                q.add(curr.right);
            }
            i++;
        }
        return root;
    }

    static Node findNode(Node root, int val) {
        if (root == null) return null;
        if (root.val == val) return root;
        Node left = findNode(root.left, val);
        if (left != null) return left;
        return findNode(root.right, val);
    }

    static Node lca(Node root, Node p, Node q) {
        if (root == null || root == p || root == q) return root;
        Node left = lca(root.left, p, q);
        Node right = lca(root.right, p, q);
        if (left != null && right != null) return root;
        return left != null ? left : right;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Integer[] arr = new Integer[n];
        for (int i = 0; i < n; i++) {
            String s = sc.next();
            if (s.equals("null")) arr[i] = null;
            else arr[i] = Integer.parseInt(s);
        }
        int pVal = sc.nextInt();
        int qVal = sc.nextInt();
        Node root = buildTree(arr);
        Node p = findNode(root, pVal);
        Node q = findNode(root, qVal);
        Node ans = lca(root, p, q);
        System.out.println(ans.val);
    }
}
