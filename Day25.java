import java.util.*;

class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int x) { val = x; }
}

public class ValidateBST {
    public boolean isValidBST(TreeNode root) {
        return validate(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean validate(TreeNode node, long min, long max) {
        if (node == null) return true;
        if (node.val <= min || node.val >= max) return false;
        return validate(node.left, min, node.val) && validate(node.right, node.val, max);
    }

    // Helper: Build tree from level order input (with "null")
    private static TreeNode buildTree(String[] values) {
        if (values.length == 0 || values[0].equals("null")) return null;
        TreeNode root = new TreeNode(Integer.parseInt(values[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int i = 1;
        while (!queue.isEmpty() && i < values.length) {
            TreeNode curr = queue.poll();
            if (!values[i].equals("null")) {
                curr.left = new TreeNode(Integer.parseInt(values[i]));
                queue.offer(curr.left);
            }
            i++;
            if (i < values.length && !values[i].equals("null")) {
                curr.right = new TreeNode(Integer.parseInt(values[i]));
                queue.offer(curr.right);
            }
            i++;
        }
        return root;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter tree nodes in level order (use 'null' for empty):");
        String[] input = sc.nextLine().trim().split("\\s+");
        
        TreeNode root = buildTree(input);
        ValidateBST obj = new ValidateBST();
        System.out.println(obj.isValidBST(root));
        sc.close();
    }
}
