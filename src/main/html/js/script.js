/*
    js注释
    可以在源码中查看
 */
//单行注释
// alert("这是我的第一行js代码");
//
// document.write("tommy~~~");
//
// console.log("向控制台输出");
/*
1，严格区分大小写。
2，以分号结尾;
3，js自动忽略空格和换行
 */

//字面量，不可改变的值 如 123，字面量都可以直接使用
//变量  用来保存字面量，可以任意改变
// var a
// a = 123;
// console.log(a);
// var b = 789;
// console.log(b);

/*
    标识符：在js中可以由我们自主命名的都可以称为标识符。
    -例如：变量名，函数名，属性名
    标识符可以包括 字母 数字 _ $
    不能以数字开头 不能用关键字
 */

/*
    数据类型
    1 String 字符串
    2 Number 数值
    3 boolean 布尔值        ---->   基本数据类型
    4 null 空值
    5 undefined 未定义
    6 Object 对象    （引用数据类型）
 */
/*
在字符串中用\用作转义符
\n   换行
\t   制表符  一个tab
\\  标识一个\
 */
/*
使用typeof来检查变量的类型
infinity 正无穷  是number类型
NAN not a number  是一个特殊的数字

 */
// var bool = true;
// console.log(typeof bool);

// var a = null;
// console.log(typeof a);
// console.log(a);
// var b = undefined;
// console.log(typeof b);
// console.log(b);
/*
强制类型转换
    转string
        1 调用被转换数据的toString方法
        注意 null和undefined没有tostring方法
        2调用string函数
           会将null直接转"null",undefined也是

    转Number
    1、调用Number函数
        如果不是数字 则是NAN
        如果是空或者是空格，则转为0
    2、parseInt() 把一个字符串转换为一个整数  第一串数字转  后面的不转
        parseFloat()把一个字符串转换成一个浮点数   获取有效的小数
        对非string的数，会先转成string再转换

    转Boolean
    数字-->boolean  除了0 和NAN  其余的都是true
    字符串--->boolean 除了空字符串  其余都是true
    null和undefined都是false
    对象也会转为 true

 */
// var a = 123;
// var b = a.toString();
// console.log(typeof b);
//
// a = String(a);
// console.log(typeof a);
// var a = "123";
// a = Number(a);
// console.log(typeof a);
// console.log(a);

/*
    0x开头表示16进制
    8进制 以0开头
    2进制   0b开头 不是所有浏览器都支持
 */
// var a = "070";
// a = parseInt(a,8);
// console.log(typeof a);
// console.log(a);

/*
任何值与NAN计算，都是NAN
字符串相加是，拼接
数字和字符串相加，会先把数字转成字符串再与后面的字符串做拼接
 */
/*
一元运算符
 */
/*
自增 ++
a++ 是自增前的值
++a 是自增后的值
 */
/*
逻辑运算符
！
&&
||
非布尔值
与 运算 如果两个值都为true，则返回后面的，如果两个值中有false，则返回靠前的false。

 */
//这是16进制
// console.log("\u2620");
// var b = NaN;
// console.log(isNaN(b));
// var score = prompt("print a number");
// console.time("test");
// console.timeEnd("test");
// var fun = new Function("console.log('这是我的函数');");
// fun();
/*
* JS中的数据类型
*   string字符串
*   Number字符串               基本数据类型
*   Boolean布尔值
*   Null空值
*   undefined未定义
*   Object对象          引用数据类型
*
*
* */
/*  对象的分类：
        1、内建对象  任何ES标准定义中的
                比如  MATH，String。

        2宿主对象   由浏览器提供
                // BOM浏览器对象模型
                //DOM 文档对象模型
        3、自定义对象     由开发人员自主创建
    *
 */

var obj = new Object();
obj.name = 'tommy';
//删除对象
delete obj.name;
obj.test1="zz";

console.log("test" in obj);
console.log("test1" in obj);
console.log(obj);







