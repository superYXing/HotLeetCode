# HotLeetCode

个人 LeetCode / 数据结构练习仓库（Java）。包含：

- LeetCode 题目按“题号.题名.java”存放，直接可在 LeetCode 编辑器复制粘贴使用。
- `heima/` 目录：基础数据结构与算法练习（数组、链表、栈、队列、堆、递归等）。
- `java_exercise/` 目录：Java 语法/小项目练习与声音合成示例（环形缓冲区、GuitarString 等）。
- `lib/` 目录：本地运行单文件测试用到的 JUnit Console Standalone Jar。

## 运行方式（本地）
仓库未使用 Maven/Gradle，直接用 `javac` + `java`。

示例：编译并运行最大子数组和（普通 main 测试版本在 `heima/test_maxSubArray.java`）

```powershell
# 进入目录
cd e:\Code\leetcode\java_project
# 编译
javac heima\test_maxSubArray.java
# 运行
java heima.test_maxSubArray
```

如果要测试某个 LeetCode 题目文件，可以：
1. 在文件底部临时添加一个 `main` 方法构造输入。
2. 或者写一个新的测试类引用其中的 `Solution`。

> 注意：LeetCode 平台自带 `ListNode` / `TreeNode` 等定义，本地文件里注释块中的结构只用于提示，提交时不要额外再定义同名类。

## 目录说明
- 根目录若干 `*.java`：LeetCode 题解，每题一个文件，类名统一为 `Solution`（LeetCode 要求）。
- `heima/`：
  - `ArrayStack.java`, `ArrayQueue.java`, `LinkedListStack.java`, `LinkedListQueue.java` 等：自实现线性结构。
  - `heapPriorityQueue.java` / `PriorityQueue.java`：二叉堆优先队列实现与测试。
  - `minHeap`（在 `23.合并-k-个升序链表.java` 中）：为合并K链表实现的最小堆（手写版，不依赖 `java.util.PriorityQueue`）。
- `java_exercise/synthesizer/`：环形缓冲、吉他弦物理模拟相关类。

## 手写最小堆实现摘要
示例（来自合并 K 个升序链表）：
```java
class minHeap {
    ListNode[] array; int size;
    public minHeap(int capacity){ array = new ListNode[capacity]; }
    public boolean offer(ListNode node){
        if(size == array.length) return false;
        int child = size++;
        int parent = (child - 1) / 2;
        while(child > 0 && node.val < array[parent].val){
            array[child] = array[parent];
            child = parent;
            parent = (child - 1) / 2;
        }
        array[child] = node; // 上浮结束位置
        return true;
    }
    public ListNode poll(){
        if(size == 0) return null;
        ListNode res = array[0];
        array[0] = array[--size];
        array[size] = null;
        int p = 0;
        while(true){
            int l = p*2 + 1, r = l + 1, m = p;
            if(l < size && array[l].val < array[m].val) m = l;
            if(r < size && array[r].val < array[m].val) m = r;
            if(m == p) break;
            ListNode t = array[p]; array[p] = array[m]; array[m] = t;
            p = m;
        }
        return res;
    }
}
```

## 建议改进
- 可新增简单脚本（PowerShell 或 Batch）批量编译运行指定题号。
- 若题量继续增多，可按数据结构/分类再分子目录。
- 可引入 Gradle 以便统一管理与添加单元测试。

## License
个人学习用途，未设置开源协议。如需引用，请注明来源。
