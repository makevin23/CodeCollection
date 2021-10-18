# Hello World

```java
public class HelloWorld {
       public static void main (String[] args){
             // Ausgabe Hello World!
             System.out.println("Hello World!");
       }
}
```

# HashMap

similar to dict in python

- import

```java
      import java.util.HashMap;
```

- Initialize

```java
      HashMap<String, Integer> hashmap = new HashMap<String, Integer>();
```

- add a key-value-pair

```java
      hashmap.put("hinatazaka", 46);
      hashmap.put("AKB", 48);
```

- check if key exists

```java
      hashmap.containsKey("keyakizaka");
```

- remove a key-value-pair

```java
      int returned_value = hashmap.remove("AKB");
```

- size of a HashMap

```java
hashmap.size();
```



# List

## ArrayList

similar to list in python

- Initialize

```java
      ArrayList<Integer> array_list = new ArrayList<Integer>();
```

- add an element
  
```java
      array_list.add(42);
      array_list.add(46);
```

- get an element

```java
      array_list.get(0);
```

- remove an element
  
```java
      array_list.remove(0);
```

- check whether an element is in the arraylist

```java
      boolean exits = array_list.contains(46);
```

- size or length of an arraylist

```java
array_list.size();
```

- get and remove the element at `index` from an arraylist

```java
array_list.remove(int index);
```

# For

## iterate elements in list

```java
      for(int n: array_list){
            System.out.println(n);
      }
```