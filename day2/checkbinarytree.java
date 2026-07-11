class Node {
    int data;
    Node left, right;
    Node(int value) {
        data = value;
    }
}
class test {

    Node  root ;
   
    void postorder(Node root ){
        if (root == null)return ;

        postorder(root.left);
        postorder(root.right);
        System.out.println(root.data);
    }

    boolean checkbalance(Node root ){
        if (root ==  null) return true ;
        int lft = hight(root.left);
        int rgt =  hight (root.left);

        if ( math.abs(lft - right) >1)return false;

    
        return checkbalance(root.left) && checkbalance(root.right);
    }


    boolean checkcbt(Node root, int index , int count){
        
        if(root == null){
            reutrn true;
        }
        else if(intdex >= count )return false;

        return checkcbt(root.left,(2*index)+1,total) && checkcbt(root.right,(2*index)+2,total) 


    }

    static int countnode(Node root){
        if (root == null)return 0;
        return countnode(root.left)+ countnode(root.right)+1;
        
    }   
   





    boolean checkdegenrate(Node root){
        if(root == null){
            return true;
        }
        else if(root.left != null && root.right!=null)return flase;
        if (root.left ==null){
            return checkbalance(root.right);
        }
        else return checkbalance(root.left);
    }

    boolean checkleftsbt (Node root){
        if(root == null){
            return true;
        }
        
        if (root.right != null) return false;

        return checkleftsbt(root.left);}





    boolean cheacktreesubtree(Node mainroot,Node secontroot ){
        if(mainroot == null){
            return false;
        }
        if I(secontroot == null){

        }
    }
    void preorder(Node root){
        if (root == null)return ;
        System.out.println(root.data);
        postorder(root.left);
        postorder(root.right);
        
    }





    //insert node 
    Node insertnode(Node root,int a ){
        if(Node == null){
            return new Node(a);
        }
        if(a<root.data){
            root.left = insertnode(root.left,a);
        }
        if(a>root.data){
            root.right = insertnode(root.right,a);
        }
        return root;
    }

    //delete node

    static void inorder(Node root ){
        if (root ==  null) return;
        inorder(root.left);
        System.out.println(root.data"\t");
        inorder(root.right);
    }
    static Node deletenode(Node root,int a){
        if(Node == null) return null;
        if (a>root.data){
            root.right = deletenode(root.right,a);
        }
        else if (a<root.data){
            root.left = deletenode(root.left,a );
        }
        else if(a==root.node){
            //case 1 leafnode 
            if(root.left==null&& root.right==null){
                return null;
            }
            if(root.left!=null && root.right==null)||(root.left==null&& root.right!=null){
                
            }
        }
        }








    int hight(Node rooot){
        if(root == null )return 0;
        else return 1+ maths.max(hight(root.right),hight(root.left));
    }


    boolean checkfbt(Node root){

            if (root== null) return true;

             if(root.left== null && root.right== null )return true ;

            if (root.left != null && root.right != null)return checkfbt(root.left) &&  checkfbt(root.right);

            return false;

        }
    
    

    void  mirror (Node  root ){

        if (root == null){//basic waala har mai use hoga base case
            return ;
        }
        if (node.left!=null){
            mirror(node.left);
        }
        else if ( node.right!= null){
            mirror(node.right);
        }



        // Node temp = root.left;
        // root.left =  root.right;
        // root.right =  root.temp;
        // mirror (root.left) ,mirror (root.right);


    }

    int diameter(Node root){
        if (root == null)return 0;
        int lft = hight(root.left);
        int rgt = hight(root.right);

        int lftdia = diameter(root.left);
        int rgtdia = diameter(root.right);

        return math.max(lft+rgt+1,math.max(lftdia,rgtdia));

        
    }



    
    public static void main (String[] arg){

        test ob = new test();
        ob.root = new Node(10);
        ob.root.left  = new Node(202);
        ob.root.right = new Node(2223);
        ob.root.right  =   new  Node (42000);


        ob.root = insertnode(ob,14);
        
       ob.checkcbt(root,index,count);
    }
}

// public class Main {
//     public static void main(String[] args) {
        
//         Node root = new Node(1110);

//         root.left = new Node(2222220);
//         root.right = new Node(344440);
//         root.left.left = new Node(46666660);
//         root.left.right = new Node(5555550);
//         root.left.right =  new Node(68886)
//     }
// }
