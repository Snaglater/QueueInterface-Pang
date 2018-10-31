/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package queueinterface;

/**
 *
 * @author PangLinKhai
 */
public class ArrayQueue implements QueueInterface {
    private Object[] a;
    private int front,back;
    public ArrayQueue(int capacity){
        a= new Object[capacity];
    }
    public void add(Object object){
        if(back == a.length) resize();
        a[back++] = object;
    }
    public Object first(){
        if(size()==0)
            throw new IllegalStateException("queue is empty");
        return a[front];
    }
    public boolean isEmpty(){
        return (size()==0);   
    }
    public Object remove(){
        if(size()==0)
            throw new IllegalStateException("queue is empty");
        Object object = a[front];
        a[front++]= null;
        return object;
    }
    public int size(){
        return back - front;
    }
    private void resize(){
        Object[] aa = a;
        a = new Object[2*aa.length];
        System.arraycopy(aa,front,a,0,size());
    }
    public String toString(){
        StringBuffer result = new StringBuffer("[");
        
        for (int i = 0; i < back-front; i++)
        {
            result.append(a[i]);
            if (i< back-front-1) result.append(",");
        }
        return result.toString() + "]";
    }
}//end class
