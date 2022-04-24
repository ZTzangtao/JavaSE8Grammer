#JKD8 Stream8详解
##概念
    Stream是JDK8的新成员，它允许以声明式方式处理数据集合。
##特点
  （1）<b>代码简洁</b>: 函数式编程写出的代码简洁且意图明确，使用Stream接口让你从此告别for循环。
  （2）<b>多核友好</b>: java函数式编程使得编写并行程序从未如此简单，你需要的全部就是调用一下方法。
##流程
    1）第一步: 把集合转换为Stream流
    2）第二步: 操作Stream流
    stream流在管道中经过中间操作（intermediate operation）的处理，最后由最终操作（terminal operation）得到前面处理的结果。
##操作符
    两种: 中间操作符、终止操作符