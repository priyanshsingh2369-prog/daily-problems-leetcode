// class node {
//         int data;
//         node left, right;
//         node (int value){
//             data = value;
//         }
//     }
// class avltree{

    



// }



// class avltree {

//     public class Node {
//         private int value;
//         private Node left;
//         private Node right;
//         private int height;

//         public Node(int value) {
//             this.value = value;
//         }

//         public int getValue() {
//             return value;
//         }
//     }

//     private Node root;

//     public BST() {
//     }

//     public void insert(int value) {
//         root = insert(value, root);
//     }

//     private Node insert(int value, Node node) {
//         // Base case
//         if (node == null) {
//             node = new Node(value);
//             return node;
//         }

//         // Left side
//         if (value < node.value) {
//             node.left = insert(value, node.left);
//         }

//         // Right side
//         else if (value > node.value) {
//             node.right = insert(value, node.right);
//         }

//         // Return node after insertion
//         return node;
//     }
// }


class Node {
    int data, height;
    Node left, right;

    Node(int data) {
        this.data = data;
        height = 1;
    }
}

class avltree{
    int hight(Node root){
        if(root== null) return 0;
        return root.hight;
    }

    int getbalance (Node root){
        if(root == null )rerturn 0;
        return hight(root.left) - hight(root.right);
    }
    
    Node rr(Node y) {
        Node x = y.left;
        Node T2 = x.right;

        x.right = y;
        y.left = T2;

        y.height = Math.max(height(y.left), height(y.right)) + 1;
        x.height = Math.max(height(x.left), height(x.right)) + 1;

        return x;
    }

    
    Node ll(Node x) {
        Node y = x.right;
        Node T2 = y.left;

        y.left = x;
        x.right = T2;

        x.height = Math.max(height(x.left), height(x.right)) + 1;
        y.height = Math.max(height(y.left), height(y.right)) + 1;

        return y;
    }

    // Node insert(Node node, int key) {
    //     if (node == null)
    //         return (new Node(key));

    //     if (key < node.data)
    //         node.left = insert(node.left, key);
    //     else if (key > node.data)
    //         node.right = insert(node.right, key);
    //     else
    //         return node;

    //     node.height = 1 + Math.max(height(node.left), height(node.right));

    //     int balance = getBalance(node);

    //     if (balance > 1 && key < node.left.data)
    //         return rr(node);

    //     if (balance < -1 && key > node.right.data)
    //         return ll(node);

    //     if (balance > 1 && key > node.left.data) {
    //         node.left = ll(node.left);
    //         return rr(node);
    //     }

    //     if (balance < -1 && key < node.right.data) {
    //         node.right = rr(node.right);
    //         return ll(node);
    //     }

    //     return node;
    // }


    
    Node insert(Node root, int key) {
    // 1. Normal BST insert
    if (root == null)
        return new Node(key);

    if (key < root.data)
        root.left = insert(root.left, key);
    else if (key > root.data)
        root.right = insert(root.right, key);
    else
        return root; // duplicates not allowed

    // 2. Update height
    root.height = 1 + Math.max(height(root.left), height(root.right));

    // 3. Get balance
    int balance = getBalance(root);

    // 4. Rotation cases

    // LL Case
    if (balance > 1 && key < root.left.data)
        return rightRotate(root);

    // RR Case
    if (balance < -1 && key > root.right.data)
        return leftRotate(root);

    // LR Case
    if (balance > 1 && key > root.left.data) {
        root.left = leftRotate(root.left);
        return rightRotate(root);
    }

    // RL Case
    
    if(balance <-1 && balance )

    return root;
}
}
