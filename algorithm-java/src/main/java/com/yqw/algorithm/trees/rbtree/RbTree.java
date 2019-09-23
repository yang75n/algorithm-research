package com.yqw.algorithm.trees.rbtree;

/**
 * Created by iQiwen on 2019/6/18.
 */
public class RbTree {
    int power(int di, int ex) {
        int sum = 1;
        for (int i = 0; i < ex; i++)
            sum *= di;
        return sum;
    }

    public int insert(RbRoot root, int value) {

        RbNode node = new RbNode();

        node.value = value;
        node.color = Color.RED;
        node.parent = null;
        node.left = null;
        node.right = null;

        if (root.node == null) {
            root.node = node;
            node.color = Color.BLACK;
            return 0;
        }

        RbNode i = root.node;
        RbNode parent = null;
        int flag = 0;
        while (i != null) {
            parent = i;
            if (value < i.value) {
                i = i.left;
                flag = 1;
            } else if (value > i.value) {
                i = i.right;
                flag = 0;
            } else {
                node = null;
                return -1;
            }
        }

        node.parent = parent;
        if (flag != 0) {
            parent.left = node;
        } else {
            parent.right = node;
        }
        insert_fix(root, node);
        return 0;

    }

    void insert_fix(RbRoot root, RbNode node) {
        RbNode x = node, y, z, tmp;
        while (x.parent != null) {
            y = x.parent;
            if (x == y.right) {
                if (y.left != null && y.left.color == Color.RED) {
                    y.left.color = Color.BLACK;
                    x.color = Color.BLACK;
                    y.color = Color.RED;
                    x = y;
                    continue;
                }
                rotate_left(root, y);
                tmp = x;
                x = y;
                y = tmp;
            }
            if (y.color == Color.BLACK)
                return;
            z = y.parent;
            rotate_right(root, z);
            x.color = Color.BLACK;
            z.color = Color.BLACK;
            y.color = Color.RED;
            x = y;
        }
        x.color = Color.BLACK;

    }


//    void delete_fix(RbRoot root, RbNode node)
//    {
//        if(node.left!=null && node.left.color == Color.RED)
//            rotate_right(root, node);
//        if(node.color == Color.RED)
//        goto delete;
//
//        struct rbnode *x = node, *y, *z, *w;
//        int borrow_red = 0;
//        while(x.parent){
//            y = x.parent;
//            if(x == y.left){
//                z = y.right;
//                w = z.left;
//                if(w && w.color == RED){
//                    w.color = BLACK;
//                    borrow_red ? (borrow_red = 0) : (x.color = RED);
//                    rotate_right(root, z);
//                    rotate_left(root, y);
//                } else {
//                    borrow_red ? (borrow_red = 0) : (x.color = RED);
//                    z.color = RED;
//                    y.color == RED ? (y.color = BLACK) : (borrow_red = 1);
//                    rotate_left(root, y);
//                    x = z;
//                }
//            } else {
//                int rotated = 0;
//                if(y.left && y.left.color == RED)
//                    rotate_right(root, y), rotated = 1;
//                z = y.left;
//                w = z.left;
//                if(w && w.color == RED){
//                    w.color = BLACK;
//                    borrow_red ? (borrow_red = 0) : (x.color = RED);
//                    rotate_right(root, y);
//                    if(rotated)
//                        rotate_left(root, z.parent);
//                } else {
//                    borrow_red ? (borrow_red = 0) : (x.color = RED);
//                    z.color = RED;
//                    y.color == RED ? (y.color = BLACK) : (borrow_red = 1);
//                    x = y;
//                }
//            }
//            if(!borrow_red)
//                break;
//        }
//
//        struct rbnode *child;
//        delete:
//        child = node.left ? node.left : node.right;
//        if(node.parent){
//            int flag = node == node.parent.left;
//            flag ? (node.parent.left = child) : (node.parent.right = child);
//        } else {
//            root.node = child;
//        }
//
//        if(child)
//            child.parent = node.parent;
//
//        free(node);
//        return;
//
//    }



    static void rotate_left(RbRoot root, RbNode y) {
        RbNode x = y.right;
        if (x == null)
            return;

        x.parent = y.parent;
        if (y.parent != null) {
            boolean flag = y == y.parent.left;
            if (flag) {
                y.parent.left = x;
            } else {
                y.parent.right = x;
            }
        } else {
            root.node = x;
        }

        y.right = x.left;
        if (x.left != null)
            x.left.parent = y;

        x.left = y;
        y.parent = x;

        Color c = x.color;
        x.color = y.color;
        y.color = c;
    }

    static void rotate_right(RbRoot root, RbNode y) {

        RbNode x = y.left;
        if (x == null)
            return;

        x.parent = y.parent;
        if (y.parent != null) {
            boolean flag = y.parent.left == y;
            if (flag) {
                y.parent.left = x;
            } else {
                y.parent.right = x;
            }
        } else {
            root.node = x;
        }

        y.left = x.right;
        if (x.right != null)
            x.right.parent = y;

        x.right = y;
        y.parent = x;
        Color color = x.color;
        x.color = y.color;
        y.color = color;
    }


    public RbNode find(RbNode root, int value) {
        RbNode p = root;
        while (p != null) {
            if (value == p.value)
                return p;
            if (value < p.value)
                p = p.left;
            else
                p = p.right;
        }
        return null;
    }
}
