class node {
    int data;
    node left, right;
    node (int value){
        data = value;
    }
}
class solution {
    boolean identical(node p, node q){
        if(p == null || q == null) {
        return p == q;
        }
        isleftsub = identical(p.left,q.right);
        isrightsub = identical(p.right,q.left);
        return (p.data == q.data) && isleftsub && isrightsub;
      }
};

class test {
    public static void main(String[] args) {
        node root1 = new node(1);
        root1.left = new node(2);
        root1.right = new node(3);

        node root2 = new node(1);
        root2.left = new node(2);
        root2.right = new node(3);

        solution sol = new solution();
        boolean result = sol.identical(root1, root2);
        System.out.println("The trees are identical: " + result);
    }
}