package com.careerit.cj.day26;

public class MyList<T> {

      Object[] arr = new Object[10];
      int index = 0;
      public void add(T t) {
            if(index < arr.length) {
                arr[index++] = t;
            }else {
                Object[] temp = new Object[arr.length + arr.length/2];
                System.arraycopy(arr, 0, temp, 0, arr.length);
                arr = temp;
                arr[index++] = t;
            }
      }

        public T get(int index) {
            if(index < 0 || index >= this.index) {
                throw new IndexOutOfBoundsException("Index : "+index+" is invalid, size is : "+this.index);
            }
            return (T)arr[index];
        }

        public void show() {
            for(int i=0;i<index;i++) {
                System.out.println(arr[i]);
            }
        }
}
