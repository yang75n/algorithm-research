package algorithm.trees.avlTree;

import java.util.Stack;

/**
 * 平衡二叉树(AVL树)
 */
public class AVLTree<E> {

    /**
     * 根节点
     */
    private Node<E> root = null;

    /**
     * 树中元素的个数
     */
    private int size = 0;


    private static final int LEFT_HIGH = 1;
    private static final int RIGHT_HIGH = -1;
    private static final int EQUAL_HIGH = 0;

    public AVLTree() {
    }


    public boolean insertElement(E element) {

        Node<E> t = root;
        if (t == null) {
            /**将值复制给根节点，其父节点为空*/
            root = new Node(element, null);
            size = 1;
            return true;
        }

        int cmp = 0;
        Node<E> parent; /**用来保存t的父节点*/

        /**查找结点应存放的位置*/
        Comparable<? super E> e = (Comparable<? super E>) element;
        do {
            parent = t;
            cmp = e.compareTo(t.element);
            if (cmp < 0) {
                t = t.left;
            } else if (cmp > 0) {
                t = t.right;
            } else {
                return false;
            }
        } while (t != null);

        /**将结点存放在对应的位置*/
        Node<E> child = new Node(element, parent);
        if (cmp < 0) {
            parent.left = child;
        } else {
            parent.right = child;
        }


        /**開始回溯，为根节点改动balabce，以便进行对应的调整*/
        while (parent != null) {
            cmp = e.compareTo(parent.element);
            if (cmp < 0) {
                parent.balance++;
            } else {
                parent.balance--;
            }

            if (parent.balance == 0) {/**从这以上的结点都不须要改动了，也不须要旋转了*/
                break;
            }

            if (Math.abs(parent.balance) == 2) {
                fixAfterInsertion(parent);
                break;
            }
            parent = parent.parent;
        }
        size++;
        return true;
    }


    private void fixAfterInsertion(Node<E> p) {
        if (p.balance == 2) {
            leftBanance(p);
        }
        if (p.balance == -2) {
            rightBalance(p);
        }
    }


    /**
     * 左平衡操作，即结点t的不平衡是由于左子树过深
     * <p>
     * 1、假设新的结点插入到p的左孩子的左子树中，则直接进行右旋操作就可以
     * t								lc
     * /  \		右旋操作				   /  \
     * lc   rc		------------->		 lcl   t
     * /  \								 /	  /  \
     * lcl  lcr						   lcll  lcr rc
     * /
     * lcll
     * <p>
     * 2、假设新的结点插入到p的左孩子的右子树中，则须要进行分情况讨论
     * <p>
     * 情况a：当p的左孩子的右子树根节点的balance = RIGHT_HIGH
     * <p>
     * 1						1						 	4
     * /  \					   /  \						   /  \
     * 2    6      左旋     	4    6                 右旋		2    1
     * /  \  		------->     /  \        -------->       /    /  \
     * 3    4                  2    5                      3    5    6
     * \                /
     * 5			  3
     * <p>
     * <p>
     * 情况b：当p的左孩子的右子树根节点的balance = LEFT_HIGH
     * <p>
     * 1						1						 	4
     * /  \					   /  \						   /  \
     * 2    6      左旋     	4    6          右旋		2    1
     * /  \  		------->     /          -------->        / \    \
     * 3    4                  2                           3   5    6
     * /                  / \
     * 5   			  	  3   5
     * <p>
     * 情况c：当p的左孩子的右子树根节点的balance = EQUAL_HIGH
     * <p>
     * 1						1						 	4
     * /  \					   /  \						   /  \
     * 2    7      左旋     	 4    7          右旋		2     1
     * /  \  		------->     / \         -------->       / \   / \
     * 3    4                  2   6                       3   5  6  7
     * / \                / \
     * 5   6			  3	  5
     */


    private void leftBanance(Node<E> t) {

        Node<E> lc = t.left;
        switch (lc.balance) {
            case LEFT_HIGH:        /**新结点插入到t的左孩子的左子树上，须要单右旋处理*/
                lc.balance = EQUAL_HIGH;
                t.balance = EQUAL_HIGH;
                break;

            case RIGHT_HIGH:    /**新结点插入到t的左孩子的右子树上，须要双旋处理*/
                Node<E> rd = lc.right;
                switch (rd.balance) {
                    case LEFT_HIGH:
                        lc.balance = EQUAL_HIGH;
                        t.balance = RIGHT_HIGH;
                        break;

                    case RIGHT_HIGH:
                        lc.balance = LEFT_HIGH;
                        t.balance = EQUAL_HIGH;
                        break;
                    case EQUAL_HIGH:
                        t.balance = EQUAL_HIGH;
                        lc.balance = EQUAL_HIGH;
                        break;
                }
                rd.balance = EQUAL_HIGH;
                /**对t的左子树进行左旋处理*/
                left_Rotate(t.left);
                /**对t进行右旋处理*/
                right_Rotate(t);
                break;
        }
    }

    /**
     * 右平衡操作，即结点t的不平衡是由于右子树过深
     * <p>
     * 1、假设新的结点插入到p的右孩子的右子树中，则直接进行左旋操作就可以
     * <p>
     * p											r
     * /   \										   /  \
     * l	   r			   左旋操作 				  p   rr
     * /   \			----------->             / \    \
     * rl    rr								l   rl   rrr
     * \
     * rrr
     * <p>
     * <p>
     * 2、假设新的结点插入到p的右孩子的左子树中，则须要进行分情况讨论
     * <p>
     * 情况a：当p的右孩子的左子树根节点的balance = LEFT_HIGH
     * <p>
     * 1						1							4
     * /  \					   /  \						   /   \
     * 2    3		  右旋	  2	   4		左旋		  1     3
     * /  \	   ------->		  /  \		------->	 /  \     \
     * 4	  5					 6    3					2	6  	   5
     * /							   \
     * 6								5
     * <p>
     * 情况b：当p的右孩子的左子树根节点的balance = RIGHT_HIGH
     * <p>
     * 1						1							4
     * /  \					   /  \						   /   \
     * 2    3		  右旋	  2	   4			左旋		  1     3
     * /  \	   ------->		     \		------->	 /     /  \
     * 4	  5					      3					2	  6	   5
     * \							 /  \
     * 6						6    5
     * <p>
     * <p>
     * 情况C：当p的右孩子的左子树根节点的balance = EQUAL_HIGH
     * 1						1							4
     * /  \					   /  \						   /   \
     * 2    3		  右旋	  2	   4 		左旋		  1     3
     * /  \	   ------->		  /  \		------->	 / \    / \
     * 4	  5					 6    3					2	6  7   5
     * / \							 /  \
     * 6   7						7    5
     */
    private void rightBalance(Node<E> p) {
        Node<E> rc = p.right;
        switch (rc.balance) {
            case RIGHT_HIGH:        /**新结点插入到t的右孩子的右子树上，须要单左旋处理*/
                rc.balance = EQUAL_HIGH;
                p.balance = EQUAL_HIGH;
                break;

            case LEFT_HIGH:        /**新结点插入到t的右孩子的左子树上，须要双旋处理*/
                Node<E> ld = rc.left;
                switch (ld.balance) {
                    case LEFT_HIGH:
                        p.balance = EQUAL_HIGH;
                        rc.balance = RIGHT_HIGH;
                        break;
                    case RIGHT_HIGH:
                        p.balance = LEFT_HIGH;
                        rc.balance = EQUAL_HIGH;
                        break;
                    case EQUAL_HIGH:
                        p.balance = EQUAL_HIGH;
                        rc.balance = EQUAL_HIGH;
                        break;
                }
                ld.balance = EQUAL_HIGH;
                /**对p的右子树进行右旋处理*/
                right_Rotate(p.right);
                /**对p进行左旋处理*/
                left_Rotate(p);
                break;
        }

    }


    /**
     * 左旋操作
     * p											r
     * /   \										   /  \
     * l	   r			   左旋操作 				  p   rr
     * /   \			----------->             / \    \
     * rl    rr								l   rl   rrr
     * \
     * rrr
     */

    private void left_Rotate(Node<E> p) {
        if (p != null) {
            Node<E> r = p.right;    /**获得p的右子树的根节点r*/

            p.right = r.left;        /**将r的左子树转接到p的右子树上*/
            if (r.left != null) {        /**假设r的左子树不为空，将左子树的父节点设置为p*/
                r.left.parent = p;
            }

            r.parent = p.parent;    /**改动r的父节点，改动为p的父节点*/
            if (p.parent == null) {    /**假设p的父节点为null，那么如今r就是根节点了*/
                root = r;
            } else if (p == p.parent.left) {/**假设p为其父节点的左孩子，将其父节点的左孩子指向r*/
                p.parent.left = r;
            } else if (p == p.parent.right) {/**假设p为其父节点的右孩子，将其父节点的右孩子指向r*/
                p.parent.right = r;
            }

            r.left = p;        /**将r的左孩子设置为p*/
            p.parent = r;    /**将p的父节点设置为r*/
        }
    }


    /**
     * 右旋操作
     * <p>
     * p									l
     * /  \			 右旋操作				   /  \
     * l	   r		------------->		  ll   p
     * /  \								 /	  /  \
     * ll   lr								lll	 lr   r
     * /
     * lll
     */
    private void right_Rotate(Node<E> p) {

        if (p != null) {
            Node<E> l = p.left;        /**获取p的左孩子l*/

            p.left = l.right;        /**将l的右子树变为p的左子树*/
            if (l.right != null) {    /**假设l的右子树不为空，将其父节点设置为p*/
                l.right.parent = p;
            }

            l.parent = p.parent;    /**将r的父节点改动为p的父节点*/
            if (p.parent == null) {    /**假设p的父节点为null，即l为root*/
                root = l;
            } else if (p == p.parent.left) {    /**假设p为其父节点的左孩子，将p的父节点的左孩子指向l*/
                p.parent.left = l;
            } else if (p == p.parent.right) { /**假设p为其父节点的右孩子，将p的父节点的右孩子指向l*/
                p.parent.right = l;
            }

            l.right = p;        /**将l的右子树变为p*/
            p.parent = l;        /**改动p的父节点为l*/
        }
    }


    /**
     * 中序非递归方式遍历平衡二叉树
     */
    public void nrInOrderTraverse() {
        Stack<Node<E>> stack = new Stack<Node<E>>();
        Node<E> p = root;
        while (p != null || !stack.isEmpty()) {
            while (p != null) {
                stack.push(p);
                p = p.left;
            }
            p = stack.pop();
            System.out.println(p.element);
            p = p.right;
        }
    }


    /**
     * 平衡二叉树的结点定义
     */
    class Node<E> {
        E element;
        /**
         * 结点的平衡因子
         */
        int balance = 0;
        /**
         * 左孩子结点、右孩子结点、父节点
         */
        Node<E> left;
        Node<E> right;
        Node<E> parent;

        public Node() {
        }

        public Node(E element, Node<E> parent) {
            this.element = element;
            this.parent = parent;
        }

        public String toString() {
            return element + " BF=" + balance;
        }

    }
}
