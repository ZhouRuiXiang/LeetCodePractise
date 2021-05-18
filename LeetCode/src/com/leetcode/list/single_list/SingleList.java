package com.leetcode.list.single_list;
@SuppressWarnings("all")
public class SingleList<E> {
    private Node<E> head;
    private Node<E> last;
    private int size;

    public E getHead() {
        return head.data;
    }

    public int size() {
        return size; // +1 计算的是加上头结点的数量
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        if (head == null) {
            return "[]";
        }
        Node<E> curNode = head;
        for (int i = 0; i < size; i++) {
            E e = curNode.data;
            sb.append(e);
            if (curNode.next == null) {
                return sb.append("]").toString();
            } else {
                curNode = curNode.next;
                sb.append(",").append(" ");
            }

        }
        return sb.toString();
    }



    /**
     * 单链表结点类
     *
     * @param <E> 泛型
     */
    public class Node<E> {
        E data; // 数据
        Node<E> next; // 指向下一个节点

        public Node(E data) {
            this.data = data;
            next = null;
        }
    }

    /**
     * 添加结点至链表头部
     *
     * @param data 添加节点的数据(值)
     */
    private void addHeadNode(E data) {
        Node<E> newNode = new Node<>(data);
        // 头结点不存在
        if (head == null) {
            head = newNode;
            last = newNode;
            size++;
            return;
        }
        // 头结点已经存在 新结点的next指向当前头结点
        newNode.next = head;
        // 新结点成为头结点
        head = newNode;
        size++;
    }

    /**
     * 链表尾部插入结点
     *
     * @param data 添加节点的数据(值)
     */
    private void addLastNode(E data) {
        Node<E> newNode = new Node<>(data);
        // 头结点不存在
        if (last == null) {
            head = newNode;
            last = newNode;
            size++;
            return;
        }
        // 头结点存在 找到当前的最后一个节点
//        Node<E> lastNode = head; // 从头结点开始找
//        while (lastNode.next != null){
//            lastNode = lastNode.next;
//        }
        // 将新节点插入到尾部
        last.next = newNode;
        last = newNode;
        size++;
    }

    /**
     * 任意位置中间位置插入节点
     * addNodeAtIndex
     * @param data  添加节点的数据(值)
     * @param index 添加节点的索引
     */
    public void add(E data, int index) {
        // 判断索引越界问题
        if (index < 0 || index > size) { // 注意index是可以等于size()的 index = size() 表示加在链表末尾
            throw new IndexOutOfBoundsException("您输入的索引超出数组界限");
        }
        if (index == 0) { // 插入到头部
            addHeadNode(data);
        } else if (index == size()) { // 插入到尾部
            addLastNode(data);
        } else { // 插到任意中间位置
            Node<E> newNode = new Node<>(data);
            int position = 0; // 记录当前位置 初始化为头结点的位置
            Node<E> curNode = head; // 标记当前节点
            Node<E> preNode = null; // 标记前驱节点
            while (curNode != null) {
                if (position == index) {
                    newNode.next = curNode;
                    preNode.next = newNode;
                    size++;
                    return;
                } else {
                    preNode = curNode;
                    curNode = curNode.next;
                    position++;
                }
            }

        }
    }

    /**
     * 删除指定索引所在位置的节点
     * deleteNodeAtIndex
     * @param index 指定索引
     */
    public void delete(int index) {
        // 判断索引越界问题
        if (index < 0 || index > size) { // 注意index是可以等于size()的 index = size() 表示加在链表末尾
            throw new IndexOutOfBoundsException("您输入的索引超出数组界限");
        }
        if (index == 0) {
            head = head.next; // 删除头结点
            return;
        }
        int position = 0; //记录当前位置 初始化为头节点的位置
        Node<E> curNode = head; //记录当前结点
        Node<E> preNode = null; //记录前驱节点
        while (curNode != null) { // 当前结点在尾结点之后 循环停止
            // 找到要删除的结点
            if (position == index) {
                preNode.next = curNode.next; // 前驱结点指向当前节点的下一个节点
                curNode.next = null; // 当前结点指向null JVM回收
                size--;
                return;
            } else { // 未找到 一直遍历寻找
                preNode = curNode;
                curNode = curNode.next;
                position++;
            }
        }
    }
    /**
     * 查看索引所在位置的结点元素
     * getNodeDataAtIndex
     */
    public E get(int index){
        Node<E> curNode = geteNode(index);
        return curNode.data;
    }

    /**
     *  修改对应索引位置的元素
     *  setNodeDataAtIndex
     */
    public void set(int index, E newData){
        Node<E> curNode = geteNode(index);
        curNode.data = newData;

    }

    private Node<E> geteNode(int index) {
        // 计数器 表示当前结点的位置
        int position = 0;
        // 标记当前结点的位置
        Node<E> curNode = head;
        if (index < 0 | index >= size){
            throw new IndexOutOfBoundsException("您输入的索引超出数组界限");
        }
        while (position != index){
            curNode = curNode.next;
            position++;
        }
        return curNode;
    }


}
