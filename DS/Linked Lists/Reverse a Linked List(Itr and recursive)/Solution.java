import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    static class SinglyLinkedListNode {
        public int data;
        public SinglyLinkedListNode next;

        public SinglyLinkedListNode(int nodeData) {
            this.data = nodeData;
            this.next = null;
        }
    }

    static class SinglyLinkedList {
        public SinglyLinkedListNode head;
        public SinglyLinkedListNode tail;

        public SinglyLinkedList() {
            this.head = null;
            this.tail = null;
        }

        public void insertNode(int nodeData) {
            SinglyLinkedListNode node = new SinglyLinkedListNode(nodeData);

            if (this.head == null) {
                this.head = node;
            } else {
                this.tail.next = node;
            }

            this.tail = node;
        }
    }

    public static void printSinglyLinkedList(SinglyLinkedListNode node, String sep, BufferedWriter bufferedWriter) throws IOException {
        while (node != null) {
            bufferedWriter.write(String.valueOf(node.data));

            node = node.next;

            if (node != null) {
                bufferedWriter.write(sep);
            }
        }
    }
    public static SinglyLinkedListNode recursivereverse(SinglyLinkedListNode curr) {
        if(curr == null) {
            return null;
        } else if(curr.next == null) {
            return curr;
        } else {
            SinglyLinkedListNode NextNode = curr.next;
            curr.next = null;
            SinglyLinkedListNode rest = recursivereverse(NextNode);
            NextNode.next = curr;
            return rest;
        }
    }
    public static SinglyLinkedListNode reverse(SinglyLinkedListNode llist) {
    // Write your code here
    return recursivereverse(llist);
        /*
        SinglyLinkedListNode p = llist;
        SinglyLinkedListNode q = null;
        SinglyLinkedListNode r = null;
        while(p != null) {
            r = q;
            q = p;
            p = p.next;
            q.next = r;
        }
        llist = q;
        return llist;
        */
    }

    private static final Scanner scanner = new Scanner(System.in);
