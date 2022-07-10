package lzf.Hwod;

/**
 * https://blog.csdn.net/csfun1/article/details/124643796?spm=1001.2014.3001.5502
 * 小杨申请了一个保密柜，但是他忘记了密码。只记得密码都是数字，而且所有数字都是不重复的。请你根据他记住的数字范围和密码的最小数字数量，帮他算下有哪些可能的组合，规则如下：
 * 1、输出的组合都是从可选的数字范围中选取的，且不能重复；
 * 2、输出的密码数字要按照从小到大的顺序排列，密码组合需要按照字母顺序，从小到大的顺序排序。
 * 3、输出的每一个组合的数字的数量要大于等于密码最小数字数量；
 * 4、如果可能的组合为空，则返回“None”
 * 输入描述:
 * 1、输入的第一行是可能的密码数字列表，数字间以半角逗号分隔
 * 2、输入的第二行是密码最小数字数量
 * 输出描述:
 * 可能的密码组合，每种组合显示成一行，每个组合内部的数字以半角逗号分隔，从小到大的顺序排列。
 * 输出的组合间需要按照字典序排序。
 * 比如：
 * 2,3,4放到2,4的前面
 * 示例1
 * 输入
 * 2,3,4
 * 2
 * 输出
 * 2,3
 * 2,3,4
 * 2,4
 * 3,4
 * 说明
 * 最小密码数量是两个，可能有三种组合：
 * 2,3
 * 2,4
 * 3,4
 * 三个密码有一种：
 * 2,3,4
 * 示例2
 * 输入
 * 2,0
 * 1
 * 输出
 * 0
 * 0,2
 * 2
 * 说明
 * 可能的密码组合，一个的有两种 ：
 * 0
 * 2
 * 两个的有一个：
 * 0,2
 * 备注:
 * 字典序是指按照单词出现在字典的顺序进行排序的方法，比如：
 * a排在b前
 * a排在ab前
 * ab排在ac前
 * ac排在aca前
 */
public class Code_猜密码 {
}
