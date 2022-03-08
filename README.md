# codeTest

![code_test.png](https://github.com/xujians/codeTest/blob/main/image/code_test.png)

#### 思路
1. 在字符串中，对字符两两比较
2. 记录当前字符 currentChar<br/>
    下一个字符 nextChar<br/>
    与当前字符相同的字符的个数 identicalNum，默认为1
3. 比较currentChar nextChar
  + currentChar == nextChar
    - identicalNum++
    - 如果nextChar是最后一个字符，判断identicalNum是否大等于3，是的话，将该字符组成的字符串保存至list
  + currentChar != nextChar
    - 判断identicalNum是否大等于3，是的话，将该字符组成的字符串保存至list
    - identicalNum重置为1
4. 获得相同的字符的字符串的list，在原有的字符串中将它们去除，或替换

