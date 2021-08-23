## Java基础-知识点

- 数据类型
    - 基本数据类型 字节
    - boolean 1
    - byte 8
    - char 16
    - short 16
    - int 32
    - float 32
    - long 64
    - double 64

  `Integer x =2(装箱), int y = x(拆箱)`
  
- 缓存池
    - new Integer(123)与Integer.valueOf(123)的区别在于:
    `new 123 是新建一个对象,valueOf是拿的缓存池中的对象,多次获取的是同一个对象`

- String
    - String 被声明为final,因此他不可继承,内部使用final 的char数组,value数组初始化后就不能够在运用
  其他数组.保证了String的不可变性。
    - 不可变的好处?
      - 如果String对象已经被创建过了？那么就会在字符串池中取得引用,String是不可变的。
    - 安全性：String不可变保证参数不可变。
    - 线程安全：String不可变,因此是安全的。
  
  