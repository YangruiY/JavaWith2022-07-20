package com.Collection_;


import java.util.HashMap;
import java.util.HashSet;

public class Set_Method {
    // 1. 以 Set 接口的实现类 HashSet 来讲解 Set 接口的方法
    // 2. set 接口的实现类的对象(Set 接口对象), 不能存放重复的元素, 可以添加一个 null
    // 3. set 接口对象存放数据是无序(即添加的顺序和取出的顺序不一致), 没有索引,所以不能用普通的for循环遍历
    // 4. 注意：取出的顺序的顺序虽然不是添加的顺序，但是他取出的顺序是固定的.
    @SuppressWarnings({"all"})
    public static void main(String[] args) {
       /*
        Set set = new HashSet();
        set.add("john");
        set.add("lucy");
        set.add("john");
        //重复
        set.add("jack");
        set.add("hsp");
        set.add("mary");
        set.add(null);
        set.add(null);// 再次添加 null
        for (int i = 0; i < 10; i++) {
            System.out.println(set);   //[null, hsp, mary, john, lucy, jack]  即存放数据是无序
        }

        //迭代器遍历
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            Object obj = iterator.next();
            System.out.println("obj=" + obj);
        }
        set.remove(null);
            //增强的for循环，注意，因为set没有索引,所以不能用普通的for循环遍历
        for (Object o : set) {
            System.out.println("o=" + o);
        }

        */

      /*
        HashSet hashSet = new HashSet();
        //下面执行add方法之后返回的都是boolean类型的值，add成功就返回true,否则返回的就是false
        //可以通过remove指定删除的是那个对象
        System.out.println(hashSet.add("j"));//true
        System.out.println(hashSet.add("jo"));//true
        System.out.println(hashSet.add("joh"));//true
        System.out.println(hashSet.add("john"));//true
        System.out.println(hashSet.add("john"));//false
        hashSet.remove("john");//false
        System.out.println("hashSet" + hashSet);


        //重置一下hashSet
        hashSet = new HashSet();

        //hashSet不能添加相同的元素/数据
        hashSet.add("john"); //ok
        hashSet.add("john"); //加入失败
        hashSet.add(new Dog("name")); //ok
        hashSet.add(new Dog("name")); //ok
       // System.out.println("hashSet" + hashSet);

        // 看源码，做分析， 先给小伙伴留一个坑，以后讲完源码，你就一目了然了
        // 去看他的源码，即 add 到底发生了什么?=> 底层机制.
        hashSet.add(new String("ry")); //ok
        hashSet.add(new String("ry")); //ok
        System.out.println("hashSet" + hashSet);

       */
        HashSet hashSet = new HashSet();
        hashSet.add("java");//到此位置，第 1 次 add 分析完毕.
        hashSet.add("php");// 到此位置，第 2 次 add 分析完毕
        hashSet.add("java");
        System.out.println("set=" + hashSet);


        //HashSet底层机制
        /*
         HashSet 的源码解读
            1. 执行 HashSet()
               public HashSet() {
                 map = new HashMap<>();
                }
            2.  执行 add()
                public boolean add(E e) {//e = "java"
                    return map.put(e, PRESENT)==null;// (static) PRESENT = new Object();
                }
            3.  执行 put() ,
            该方法会执行 hash(key) 得到 key 对应的 hash 值 算法 h = key.hashCode()) ^ (h >>> 16)
            public V put(K key, V value) {//key = "java"   value = PRESENT 共享
                return putVal(hash(key), key, value, false, true);
            }

            [
                其中 hash(key)的算法为:
                    static final int hash(Object key) {
                         int h;
                         return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
                     }
            ]
            4.执行 putVal
                 final V putVal(int hash, K key, V value, boolean onlyIfAbsent,
                   boolean evict) {
                        // 定义了辅助变量
                        Node<K,V>[] tab; Node<K,V> p; int n, i;

                        // table 就是 HashMap 的一个数组，类型是 Node[]
                        // if 语句表示如果当前 table 是 null, 或者 大小=0，就是第一次扩容到 16 个空间.
                        if ((tab = table) == null || (n = tab.length) == 0)
                            n = (tab = resize()).length;

                            //(1)根据 key，得到 hash 去计算该 key 应该存放到 table 表的哪个索引位置并把这个位置的对象，赋给 p
                            //(2)判断 p 是否为 null
                                //(2.1) 如果 p 为 null, 表示还没有存放元素, 就创建一个 Node (key="java",value=PRESENT)
                                //(2.2) 就放在该位置 tab[i] = newNode(hash, key, value, null)

                        if ((p = tab[i = (n - 1) & hash]) == null)
                            tab[i] = newNode(hash, key, value, null);
                        else {

                        //一个开发技巧提示： 在需要局部变量(辅助变量)时候再创建
                            Node<K,V> e; K k;

                        //如果当前索引位置对应的链表的第一个元素和准备添加的 key 的 hash 值一样并且满足 下面两个条件之一:
                            //(1) 准备加入的 key 和 p 指向的 Node 结点的 key 是同一个对象
                            //(2) p 指向的 Node 结点的 key 的 equals() 和准备加入的 key 比较后相同就不能加入
                            if (p.hash == hash &&
                                ((k = p.key) == key || (key != null && key.equals(k))))
                                e = p;

                                //再判断 p 是不是一颗红黑树,如果是一颗红黑树，就调用 putTreeVal , 来进行添加
                            else if (p instanceof TreeNode)
                                e = ((TreeNode<K,V>)p).putTreeVal(this, tab, hash, key, value);
                            else {

                                //如果 table 对应索引位置，已经是一个链表, 就使用 for 循环比较
                                //(1) 依次和该链表的每一个元素比较后，都不相同, 则加入到该链表的最后，
                                    //当把元素添加到链表后，立即判断该链表是否已经达到 8 个结点
                                    // 如果达到8个结点,就调用 treeifyBin() 对当前这个链表进行树化(转成红黑树)
                                    // 在转成红黑树时,就要进行判断, 其中判断条件如下：
                                    // if (tab == null || (n = tab.length) < MIN_TREEIFY_CAPACITY(64))
                                    // resize();
                                    // 如果上面条件成立，先 table 扩容.
                                    // 只有上面条件不成立时，才进行转成红黑树
                                 //(2) 依次和该链表的每一个元素比较过程中，如果有相同情况,就直接

                                for (int binCount = 0; ; ++binCount) {
                                    if ((e = p.next) == null) {
                                        p.next = newNode(hash, key, value, null);
                                        if (binCount >= TREEIFY_THRESHOLD - 1) // -1 for 1st
                                            treeifyBin(tab, hash);
                                        break;
                                    }
                                    if (e.hash == hash &&
                                        ((k = e.key) == key || (key != null && key.equals(k))))
                                        break;
                                    p = e;
                                }
                            }
                            if (e != null) { // existing mapping for key
                                V oldValue = e.value;
                                if (!onlyIfAbsent || oldValue == null)
                                    e.value = value;  // 替换动作
                                afterNodeAccess(e);
                                return oldValue;
                            }
                        }
                                ++modCount;

                                //size 就是我们每加入一个结点 Node(k,v,h,next), size++

                                if (++size > threshold)
                                    resize(); //扩容
                                afterNodeInsertion(evict);
                                return null;
    }

         */


        HashMap hashMap = new HashMap();
        hashMap.put("java",10);
        hashMap.put("php",10);
        hashMap.put("java",20);
        System.out.println(hashMap);
        /*
            HashMap源码剖析

            1. 执行构造器 new HashMap()
                this.loadFactor = DEFAULT_LOAD_FACTOR(为0.75)
            2. 执行public static Integer valueOf(int i)
            即： public static Integer valueOf(int i) {
                    if (i >= IntegerCache.low && i <= IntegerCache.high)
                        return IntegerCache.cache[i + (-IntegerCache.low)];
                    return new Integer(i);
                }
                对基本数据类型进行装箱操作
            3. 执行 public V put(K key, V value)
                该方法会调用 hash(key) 得到 key 对应的 hash 值 算法 h = key.hashCode()) ^ (h >>> 16)
            即： public V put(K key, V value) {
                    return putVal(hash(key), key, value, false, true);
                }
             4. 执行putVal
             final V putVal(int hash, K key, V value, boolean onlyIfAbsent,
                               boolean evict) {
                    Node<K,V>[] tab; Node<K,V> p; int n, i;
                    if ((tab = table) == null || (n = tab.length) == 0)
                        n = (tab = resize()).length;
                    if ((p = tab[i = (n - 1) & hash]) == null)
                        tab[i] = newNode(hash, key, value, null);
                    else {
                        Node<K,V> e; K k;

                        如果 table 的索引位置的 key 的 hash 相同和新的 key 的 hash 值相同，
                        并满足(table 现有的结点的 key 和准备添加的 key 是同一个对象 || equals 返回真),就认为不能加入新的 k-v

                        if (p.hash == hash &&
                            ((k = p.key) == key || (key != null && key.equals(k))))
                            e = p;

                          如果当前的 table 的已有的 Node 是红黑树，就按照红黑树的方式处 理
                        else if (p instanceof TreeNode)
                            e = ((TreeNode<K,V>)p).putTreeVal(this, tab, hash, key, value);
                        else {

                        如果找到的结点后面是链表，就循环比较

                            for (int binCount = 0; ; ++binCount) {    死循环

                            如果整个链表，没有和他相同,就加到该链表的最后

                                if ((e = p.next) == null) {

                       加入后，判断当前链表的个数，是否已经到8个，到 8 个后就调用 treeifyBin 方法进行红黑树的转换

                                    p.next = newNode(hash, key, value, null);
                                    if (binCount >= TREEIFY_THRESHOLD - 1) // -1 for 1st
                                        treeifyBin(tab, hash);
                                    break;
                                }

                                如果在循环比较过程中，发现有相同,就 break,就只是替换 value

                                if (e.hash == hash &&
                                    ((k = e.key) == key || (key != null && key.equals(k))))
                                    break;
                                p = e;
                            }
                        }
                        if (e != null) { // existing mapping for key
                            V oldValue = e.value;
                            if (!onlyIfAbsent || oldValue == null)
                                e.value = value;   //替换，key 对应 value
                            afterNodeAccess(e);
                            return oldValue;
                        }
                    }
                    ++modCount;每增加一个 Node ,就 size++ ，如果 size > 临界值，就扩容
                    if (++size > threshold)
                        resize();
                    afterNodeInsertion(evict);
                    return null;
                   }
            5. 5. 关于树化(转成红黑树)
            如果 table 为 null ,或者大小还没有到 64，暂时不树化，而是进行扩容. 否则才会真正的树化 -> 剪枝

              final void treeifyBin(Node<K,V>[] tab, int hash) {
                  int n, index;Node<K,V> e;
                  if (tab == null || (n = tab.length) < MIN_TREEIFY_CAPACITY)
                  resize();
              }
         */


    }

}

//class Dog{
//    private  String name;
//
//    public Dog(String name) {
//        this.name = name;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    @Override
//    public String toString() {
//        return "Dog{" +
//                "name='" + name + '\'' +
//                '}';
//    }
//}