package com.example.demo;

import java.util.Arrays;

public class StringListImpl implements StringList{

    private final String[] strings;
    private int size;

  public StringListImpl(){
      strings = new String[10];
  }
  public  StringListImpl(int initSize){
      strings = new String[initSize];
  }

    @Override
    public String add(String item) { // method overloading
      validateSize();
      validateItem(item);

        strings[size++] = item;
        return item;
    }

    @Override
    public String add(int index, String item) {
      validateItem(item);
      validateIndex(index);
      validateSize();
      if (index==size){
          strings[size++]=item;
          return item;
      }

         System.arraycopy(strings,index, strings,index+1, size-index);
      strings[index]= item;
      size++;
         return item;
    }

    @Override
    public String set(int index, String item) {
      validateIndex(index);
      validateItem(item);
        strings[index]= item;
        return item;
    }

    @Override
    public String remove(String item) {
      validateItem(item);
      int index = indexOf(item);
      if (index==-1){
          throw  new NotFoundExeption();
      }
      if (index==size){
          strings[size--]=null;
      }
      System.arraycopy(strings,index+1,strings,index,size-index);
      size--;
        return item;
    }

    @Override
    public String remove(int index) {
      validateIndex(index);
      String item = strings[index];
      if (index==-1){
          throw new NotFoundExeption();
      }
      if (index==size){
          strings[size--]=null;
      }
      System.arraycopy(strings,index+1,strings,index,size-index);
        return item;
    }

    @Override
    public boolean contains(String item) {
       return indexOf(item)>-1;
        }
    @Override
    public int indexOf(String item) {
        for (int i = 0; i <size ; i++) {
            String s = strings[i];
            if (s.equals(item))
                return i;
        }
        return -1;
    }

    @Override
    public int lastIndex(String item) {
        for (int i = size-1; i >=0 ; i--) {
         String s = strings[i];
         if (s.equals(item))
         return i;
        }return -1;
    }

    @Override
    public String get(int index) {
      validateIndex(index);

        return strings[index];
    }

    @Override
    public boolean equals(StringList otherList) {
      if (otherList==null){
          throw new SizeExeption();
      }
        return Arrays.equals(this.toArray(), otherList.toArray());
    }
    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
       if(size==0){
           return true;
       }else return false;
    }

    @Override
    public void clear() {
      size=0;

    }

    @Override
    public String[] toArray() {
        return  Arrays.copyOf(strings,size);
    }

    private void validateItem(String item){
      if (item==null){
          throw new ValidateItemExeption();
      }
    }
    private void validateSize(){
      if (size == strings.length){
          throw new SizeExeption();
      }
    }
    private void validateIndex(int index){
      if (index<0||index>size ){
          throw new IndexExeption();
      }
    }

    public int getSize() {
        return size;
    }

    public String[] getStrings() {
        return strings;
    }
}
