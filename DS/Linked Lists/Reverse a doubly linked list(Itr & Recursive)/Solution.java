import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    static class DoublyLinkedListNode {
        public int data;
        public DoublyLinkedListNode next;
        public DoublyLinkedListNode prev;

        public DoublyLinkedListNode(int nodeData) {
            this.data = nodeData;
            this.next = null;
            this.prev = null;
        }
    }

    static class DoublyLinkedList {
        public DoublyLinkedListNode head;
        public DoublyLinkedListNode tail;

        public DoublyLinkedList() {
            this.head = null;
            this.tail = null;
        }

        public void insertNode(int nodeData) {
            DoublyLinkedListNode node = new DoublyLinkedListNode(nodeData);

            if (this.head == null) {
                this.head = node;
            } else {
                this.tail.next = node;
                node.prev = this.tail;
            }

            this.tail = node;
        }
    }

    public static void printDoublyLinkedList(DoublyLinkedListNode node, String sep, BufferedWriter bufferedWriter) throws IOException {
        while (node != null) {
            bufferedWriter.write(String.valueOf(node.data));

            node = node.next;

            if (node != null) {
                bufferedWriter.write(sep);
            }
        }
    }
    
    public static DoublyLinkedListNode recursivereverse(DoublyLinkedListNode curr) {
    // Write your code here
        if(curr == null) {
            return null;
        } else if(curr.next == null) {
            return curr;
        } else {
            DoublyLinkedListNode NextNode = curr.next;
            curr.next = null;
            curr.prev = NextNode;
            DoublyLinkedListNode rest = recursivereverse(NextNode);
            NextNode.next = curr;
            NextNode.prev = rest;
            return rest;
        }
    }
    
    public static DoublyLinkedListNode reverse(DoublyLinkedListNode curr) {
    // Write your code here
        DoublyLinkedListNode p = curr;
        DoublyLinkedListNode q = null;
        DoublyLinkedListNode r = null;
        
        while(p != null) {
            r = q;
            q = p;
            p = p.next;
            q.next = r;
            q.prev = p;
        }
        curr = q;
        return curr;
    }

    private static final Scanner scanner = new Scanner(System.in);
