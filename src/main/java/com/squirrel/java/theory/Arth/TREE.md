### Tree

### BST （Binary Search Tree）

- 解题思维
  - 遍历二叉树得到答案 **traverse** **遍历**的思维模式
  - 定义一个递归函数,通过子问题来推导出原问题的答案,并利用这个函数的返回值, **分解问题**的思维模式

- 左小右大

- BST中任意一个节点的左子树节点的值都要小于这个节点的值,所有右子树节点的值都要大于这个节点的值

- BST中任意一个节点的左右子树都是BST

- **算法框架**

   - ```java
      TreeNode operateNode(TreeNode root, int key) {
          if (root.val == key) {
              // 找到啦，进行删除
          } else if (root.val > key) {
              // 去左子树找
              root.left = deleteNode(root.left, key);
          } else if (root.val < key) {
              // 去右子树找
              root.right = deleteNode(root.right, key);
          }
          return root;
      }
      ```

- **practice**

- Leet 98 **验证二叉搜索树 isValidBST？**.

  - 思路: 不能仅仅判断某个节点的左右子节点的大小,需要判断整个左右子树的值   **left < root < right**

  - ```java
    public boolean isValidBST(TreeNode root) {
            if(root == null){return true;}
            return isValidBST(root,null,null);
    }
    public boolean isValidBST(TreeNode root,TreeNode min,TreeNode max){
      if(root == null){return true;}
      if(min!=null && root.val <= min.val){return false;}
      if(max!=null && root.val >= max.val){return false;}
      return isValidBST(root.left,min,root) && isValidBST(root.right,root,max);
    }
    ```

- Leet 700 二叉树的搜索？

   - 思路: 利用二叉树的特性,优化左右子树节点的逻辑

   - ```java
     public TreeNode searchBST(TreeNode root, int val) {
       if(root==null){
         return null;
       }
       if(val < root.val){
         return searchBST(root.left,val);
       }
       if(val > root.val){
         return searchBST(root.right,val);
       }
       return root;
     }
     ```

- Leet [623] 在二叉树中增加一行 	

   - 思路: 遍历寻找到要插入节点的位置,二叉树的递归分别为**遍历**和**分解**问题两种模式

   - ```java
     public TreeNode addOneRow(TreeNode root, int val, int depth) {
       if(depth ==1){
         TreeNode newNode = new TreeNode(val);
         newNode.left = root;
         return newNode;
       }
       int currentDepth = 0;
       traverse(root,val,depth,currentDepth);
       return root;
     }
     
     public void traverse(TreeNode root,int val,int depth,int currentDepth){
       if(root == null){
         return;
       }
       currentDepth++;
       if(currentDepth == depth-1){
         TreeNode leftNode = new TreeNode(val);
         TreeNode rightNode = new TreeNode(val);
         leftNode.left = root.left;
         rightNode.right = root.right;
         root.left = leftNode;
         root.right = rightNode;
       }
       traverse(root.left,val,depth,currentDepth);
       traverse(root.right,val,depth,currentDepth);
       currentDepth--;
     }
     ```


- Leet[450] 删除二叉搜索树中的节点

     - 思路: 先找到节点，在对该节点进行修改。删除操作有些复杂,需要考虑三种情况
       - 某个节点为末端节点,其子节点都为空,那么直接删除掉这个节点即可。
       - 如果某个节点只有一个非空子节点,那么要让这个孩子接替自己的位置
       - 如果某个节点存在两个子节点，那么其必须找到左子树最大的那个节点或者**右子树中最小的那个节点**来接替自己。

     - ```java
       public TreeNode deleteNode(TreeNode root,int val){
         if(root==null){return null;}
         // 如果匹配到了要删除的key,那么进行一系列逻辑
         if(root.val == val){
           if(root.left == null){return root.right;}
           if(root.right == null){return root.left;}
           // 第三种情况，获取最小的那个节点
           TreeNode minNode = getMinTreeNode(root.right);
           // 指针交换
           root.right = deleteNode(root.right,minNode.val);
           minNode.left = root.left;
           minNode.right = root.right;
           root = minNode;
         }else if(val < root.val){
           root.left = deleteNode(root.left,val);
         }else if(val > root.val){
           root.right = deleteNode(root.right,val);
         }
         return root;
       }
       
       public TreeNode getMinTreeNode(TreeNode root){
         while(root.left!=null){
           root = root.left;
         }
         return root;
       }
       ```

- [124] 二叉树中的最大路径和

  - 思路:  采用二叉树的分解思维,利用二叉树的后序遍历,计算单边最大路径之和,顺带计算最大路径之和

  - ```java
      private int res = Integer.MIN_VALUE;	
      public int maxPathSum(TreeNode root) {
          if(root == null){
            return 0;
          }
          // 计算单边路径之和,并设置最大路径之和
          oneSidePath(root);
          return res;
      }
      public int oneSidePath(TreeNode root){
        if(root == null){
          return 0;
        }
        int leftMax = Math.max(0,oneSidePath(root.left));
        int rightMax = Math.max(0,oneSidePath(root.right));
        res = Math.max(res,leftMax + rightMax + root.val);
        return Math.max(leftMax,rightMax) + root.val;
      }
      ```

- [543] 二叉树的直径

  - 思路:所谓的二叉树的直径,就是左右子树的最大深度之和,那么直接的想法就是对每个节点计算左右子树的最大高度,得出每个节点的直径,从而得出最大的那个直径。但是时间复杂度比较高,所以应该采用二叉树的后序遍历, 在后序遍历位置顺便计算最大直径。

  - ```java
    int maxDiameter = 0;
    public int diameterOfBinaryTree(TreeNode root) {
      maxDepth(root);
      return maxDiameter;
    }
    public int maxDepth(TreeNode root){
      if(root == null){
        return 0;
      }
      int leftMax = maxDepth(root.left);
      int rightMax =maxDepth(root.right);
      maxDiameter = Math.max(maxDiameter,leftMax + rightMax);
      return 1 + Math.max(leftMax,rightMax);
    }
    ```

- [236] 二叉树的最近公共祖先

  - 思路: 

    - 给定两个节点 p 和 q,如果p和q 都在以root为根的树中,那么left和right一定分别是p和q，返回root
    - 如果p和q都不存在 那么返回null
    - 如果只有一个存在于root为根的树中，那么返回该节点

  - ```java
     public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
       if(root == null){
         return root;
       }
       if(root == p || root == q){
         return root;
       }
       TreeNode leftNode = lowestCommonAncestor(root.left,p,q);
       TreeNode rightNode = lowestCommonAncestor(root.right,p,q);
       // 情况判断
       if(leftNode != null && rightNode !=null){
         return root;
       }
       if(leftNode == null && rightNode == null){
         return null;
       }
       return leftNode !=null ? leftNode : rightNode;
     }
    ```

- [297] 二叉树的序列化与反序列化

  - 思路: 序列化以及反序列化其实就讲某组数据按照一定规则进行存储,然后在根据一定的规则进行解析。

  - ```java
       String SEP = ",";
       String STRNULL = "#";
       
       /* 主函数，将二叉树序列化为字符串 */
       public String serialize(TreeNode root) {
           StringBuilder sb = new StringBuilder();
           serialize(root, sb);
           return sb.toString();
       }
       /* 辅助函数，将二叉树存入 StringBuilder */
       void serialize(TreeNode root, StringBuilder sb) {
          if(root == null){
            sb.append(STRNULL).append(SEP);
            return;
          }
         sb.append(root.val).append(SEP);
         serialize(root.left,sb);
         serialize(root.right,sb);   
       }
       
       /* 主函数，将字符串反序列化为二叉树结构 */
       public TreeNode deserialize(String data) {
         if(data==null){return null;}
         LinkedList<String> nodes = new LinkedList<>();
         for(String s:data.split(SEP)){
            nodes.add(s);
         }
         return deserialize(nodes);
       }
       /* 辅助函数，通过 nodes 列表构造二叉树 */
       TreeNode deserialize(LinkedList<String> nodes) {
         if(nodes.isEmpty()){return null;}
         String first = nodes.removeFirst();
         if(first.equals(STRNULL)){return null;}
         TreeNode root = new TreeNode(Integer.parseInt(first));
         
         root.left = deserialize(nodes);
         root.right = deserialize(nodes);
         return root;
       }
       ```

- [273] 二叉搜索树迭代器

- - 思路: 利用**栈模拟递归**对 BST 进行**中序遍历可以认为是一种套路**

     - ```java
            //创建一个栈,进行压栈
             Deque<TreeNode> stack = new LinkedList<>();
             
             // 压栈-左节点
             private void pushLeftBranch(TreeNode p) {
                 while (p != null) {
                     stack.push(p);
                     p = p.left;
                 }
             }
             
             public BSTIterator(TreeNode root) {
                 pushLeftBranch(root);
             }
             
             public int next() {
                 TreeNode node = stack.pop();
                 pushLeftBranch(node.right);
                 return node.val;
             }
             
             public boolean hasNext() {
                 return !stack.isEmpty();
             }
       ```

- **二叉树的下一个节点**

  - 给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回 。注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。

  - 思路: 

    - 我们先来回顾一下中序遍历的过程：先遍历树的左子树，再遍历根节点，最后再遍历右子树。所以最左节点是中序遍历的第一个节点。
    - 如果一个节点的右子树不为空，那么该节点的下一个节点是右子树的最左节点；
    - 否则，向上找第一个左链接指向的树包含该节点的祖先节点。

  - ```java
    public class TreeLinkNode {
            int val;
            TreeLinkNode left = null;
            TreeLinkNode right = null;
            TreeLinkNode next = null; // 指向父结点的指针
    
            TreeLinkNode(int val) {
                this.val = val;
            }
        }
       // 获取下一个节点
        public TreeLinkNode GetNext(TreeLinkNode pNode) {
            if (pNode == null) {
                return null;
            }
            // 右子树不为空
            if (pNode.right != null) {
                TreeLinkNode node = pNode.right;
                while (node.left != null) {
                    node = node.left;
                }
                return node;
            } else {
                // 右子树为空,那么取其祖先节点的第一个左子树节点
                while (pNode.next != null) {
                    TreeLinkNode parent = pNode.next;
                    if (parent.left == pNode) {
                        return parent;
                    }
                    pNode = pNode.next;
                }
                return null;
            }
        }
    ```


- **监控二叉树**

     - 描述: 给定一个二叉树，我们在树的节点上安装摄像头。节点上的每个摄影头都可以监视  其父对象、自身及其直接子对象。计算监控树的所有节点所需的最小摄像头数量。

     - 思路: 后序位置可以接收到子树的信息，同时也可以通过函数参数接收到父节点传递的信息，这道题就可以比较完美地体现这一特点。

     - ```java
       public int minCameraCover(TreeNode root) {
           setCamera(root, false);
           return res;
       }
       
       int res = 0;
       
       // 定义：输入以 root 为根的二叉树，以最优策略在这棵二叉树上放置摄像头，
       // 然后返回 root 节点的情况：
       // 返回 -1 代表 root 为空，返回 0 代表 root 未被 cover，
       // 返回 1 代表 root 已经被 cover，返回 2 代表 root 上放置了摄像头。
       int setCamera(TreeNode root, boolean hasParent) {
           if (root == null) {
               return -1;
           }
           // 获取左右子节点的情况
           int left = setCamera(root.left, true);
           int right = setCamera(root.right, true);
           // 根据左右子节点的情况和父节点的情况判断当前节点应该做的事情
           if (left == -1 && right == -1) {
               // 当前节点是叶子节点
               if (hasParent) {
                   // 有父节点的话，让父节点来 cover 自己
                   return 0;
               }
               // 没有父节点的话，自己 set 一个摄像头
               res++;
               return 2;
           }
           if (left == 0 || right == 0) {
               // 左右子树存在没有被 cover 的
               // 必须在当前节点 set 一个摄像头
               res += 1;
               return 2;
           }
           if (left == 2 || right == 2) {
               // 左右子树只要有一个 set 了摄像头
               // 当前节点就已经是 cover 状态了
               return 1;
           }
           // 剩下 left == 1 && right == 1 的情况
           // 即当前节点的左右子节点都被 cover
           if (hasParent) {
               // 如果有父节点的话，可以等父节点 cover 自己
               return 0;
           } else {
               // 没有父节点，只能自己 set 一个摄像头
               res++;
               return 2;
           }
       }
       ```
     
- [226]翻转二叉树

   - 思路:  层序遍历,交换每个节点

   - ```java
     TreeNode invertTree(TreeNode root) {
       traverse(root);
     }
     public void traverse(TreeNode root){
       if(root == null){
         return;
       }
       TreeNode left = root.left;
       root.left = root.right;
       root.right = left;
       traverse(root.left);
       traverse(root.right);
     }
     ```
   
- [116] [填充每个二叉树节点的右侧指针](https://leetcode.cn/problems/populating-next-right-pointers-in-each-node/)

     - 给定一个 **完美二叉树** ，其所有叶子节点都在同一层，每个父节点都有两个子节点。二叉树定义如下：

       填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 `NULL`。

       初始状态下，所有 next 指针都被设置为 `NULL`。
     
     - 思路: 普通的遍历指向不会将存在空隙的节点进行指向。	
     
     - ```java
        struct Node {
            int val;
            Node *left;
            Node *right;
            Node *next;
          }
          
          public Node connect(Node root) {
            if(root == null){
              return null;
            }
            traverse(root.left,root.right);
          }
          public void traverse(Node leftNode,Node rightNode){
            if(leftNode == null && rightNode == null){
              return;
            }
            leftNode.next = rightNode;
            traverse(leftNode.left,leftNode.right);
            traverse(rightNode.left,rightNode.right);
            // 空隙
            traverse(leftNode.right,rightNode.left);  
          }					
       ```

- 114 题「 [将二叉树展开为链表](https://leetcode.cn/problems/flatten-binary-tree-to-linked-list/)」

    - 思路: 前序遍历 ，采用分解方法

      -   先利用 `flatten(x.left)` 和 `flatten(x.right)` 将 `x` 的左右子树拉平。
      -   将 `x` 的右子树接到左子树下方，然后将整个左子树作为右子树。

    - ```java
         // 前序遍历 - 的方式
         void flatten(TreeNode root) {
             if (root == null) {
                 return;
             }
             // 后续遍历
             flatten(root.left);
             flatten(root.right);
             // 分解
             TreeNode leftNode = root.left;
             TreeNode rightNode = root.right;
             // 将左节点挂在右节点下面
             root.left = null;
             root.right = leftNode;
             // 将原先的右子树接到当前右子树的末端
             TreeNode p = root;
             while (p.right != null) {
                 p = p.right;
             }
             p.right = rightNode;
         }
         ```

- [654] 最大二叉树

  - **思路**：**二叉树的构造问题一般都是使用「分解问题」的思路：构造整棵树 = 根节点 + 构造左子树 + 构造右子树**。

  - ```java
       TreeNode constructMaximumBinaryTree(int[] nums) {
           return build(nums, 0, nums.length - 1);
       }
       // 构建节点-依次
       public TreeNode build(int[] nums,int low,int high){
         // bad case
         if(low > high){
           return null;
       }
       // 寻找到数组的最大值
       int maxVal = Integer.MIN_VALUE;
       int index = -1;  
       for (int i = low; i <= hi; i++) {
         if (maxVal < nums[i]) {
           index = i;
           maxVal = nums[i];
          }
       }
       TreeNode root = new TreeNode(maxVal);
       root.left = build(nums,low,index-1);
       root.right = build(nums,index+1,high);  
       }
       ```


- [105] 通过前序和中序遍历构造二叉树

  - 思路: 根节点为前序遍历的第一个节点

  - ```java
        // 存储 inOrder 中 value 对索引的映射
        Map<Integer, Integer> value2IndexMap = new HashMap<>();
    
        // 构建二叉树
        public TreeNode buildTree(int[] preorder, int[] inorder) {
            for (int i = 0; i < inorder.length; i++) {
                value2IndexMap.put(inorder[i], i);
            }
            return build(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
        }
    
        // 分解
        public TreeNode build(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
            if (preStart > preEnd) {
                return null;
            }
            int rootVal = preorder[preStart];
    // 获取中序遍历下 根节点的下标
            int index = value2IndexMap.get(rootVal);
    // ～ 获取leftSize
            int leftSize = index - inStart;
            TreeNode root = new TreeNode(rootVal);
            root.left = build(preorder, preStart + 1, preStart + leftSize, inorder, inStart, index - 1);
            root.right = build(preorder, preStart + leftSize + 1, preEnd, inorder, index + 1, inEnd);
            return root;
    }
    ```
  
- [106]  根据中序和后序遍历构造二叉树

  - 思路:与前序和中序类似,找好下标即可。

  - ```java
    Map<Integer, Integer> value2IndexMap = new HashMap<>();
    public TreeNode buildTree(int[] inorder, int[] postorder) {
      for (int i = 0; i < inorder.length; i++) {
          value2IndexMap.put(inorder[i], i);
      }
      return build(inorder, 0, inorder.length - 1,postorder,0,postorder.length-1);
    }
    // 构建一颗🌲 - 中序 - 后序
    public TreeNode build(int[] inorder,int inStart,int inEnd,int[] postorder,int postStart,int postEnd){
      if(inStart > inEnd){
        return null;
      }
      // 后序的最后一个节点为根节点  rootVal
      int rootVal = postorder[postEnd];
      TreeNode root = new TreeNode(rootVal);
      // 中序遍历根节点的下标
      int index = value2IndexMap.get(rootVal);
      // ～@#¥%……&&* f k  左子树节点的长度
      int leftSize = index - inStart; 
      // 找下标
      root.left = build(inorder,inStart,index-1,postorder,postStart,postStart+leftSize-1);
      root.right = build(inorder,index+1,inEnd,postorder,postStart+leftSize,postEnd-1);
      return root;
    }
    ```

- [889]  根据前序和后序遍历构造二叉树

  - **前序和后序无法确认唯一的二叉树**

  - **1、首先把前序遍历结果的第一个元素或者后序遍历结果的最后一个元素确定为根节点的值**。

    **2、然后把前序遍历结果的第二个元素作为左子树的根节点的值**。

    **3、在后序遍历结果中寻找左子树根节点的值，从而确定了左子树的索引边界，进而确定右子树的索引边界，递归构造左右子树即可**。

  - ```java
    class Solution {
        // 存储 postorder 中值到索引的映射
        HashMap<Integer, Integer> valToIndex = new HashMap<>();
    
        public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
            for (int i = 0; i < postorder.length; i++) {
                valToIndex.put(postorder[i], i);
            }
            return build(preorder, 0, preorder.length - 1,
                        postorder, 0, postorder.length - 1);
        }
    
        // 定义：根据 preorder[preStart..preEnd] 和 postorder[postStart..postEnd]
        // 构建二叉树，并返回根节点。
        TreeNode build(int[] preorder, int preStart, int preEnd,
                       int[] postorder, int postStart, int postEnd) {
            if (preStart > preEnd) {
                return null;
            }
            if (preStart == preEnd) {
                return new TreeNode(preorder[preStart]);
            }
    
            // root 节点对应的值就是前序遍历数组的第一个元素
            int rootVal = preorder[preStart];
            // root.left 的值是前序遍历第二个元素
            // 通过前序和后序遍历构造二叉树的关键在于通过左子树的根节点
            // 确定 preorder 和 postorder 中左右子树的元素区间
            int leftRootVal = preorder[preStart + 1];
            // leftRootVal 在后序遍历数组中的索引
            int index = valToIndex.get(leftRootVal);
            // 左子树的元素个数
            int leftSize = index - postStart + 1;
    
            // 先构造出当前根节点
            TreeNode root = new TreeNode(rootVal);
            // 递归构造左右子树
            // 根据左子树的根节点索引和元素个数推导左右子树的索引边界
            root.left = build(preorder, preStart + 1, preStart + leftSize,
                    postorder, postStart, index);
            root.right = build(preorder, preStart + leftSize + 1, preEnd,
                    postorder, index + 1, postEnd - 1);
            return root;
        }
    }
      
    ```

- [652] 寻找重复的子树

  - 思路: 寻找子树,需要收集到子节点的结构信息，所以采用后序遍历的方式。

  - ```java
    // 记录所有子树以及出现的次数
    HashMap<String, Integer> memo = new HashMap<>();
    // 记录重复的子树根节点
    LinkedList<TreeNode> res = new LinkedList<>();
    // 寻找重复子树
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
      if(root == null){
        return null;
      }
      traverse(root);
      return res;
    }
    
    // 遍历
    public String traverse(TreeNode root){
      if(root == null){
        return "#";
      }
      // 后序遍历实现
      String leftStr = traverse(root.left);
      String rightStr = traverse(root.right);
      
      String subTree = leftStr + "," + rightStr + "," + root.val;
      
      int freq = memo.getOrDefault(subTree,0);
      if(freq==1){
        res.add(root);
      }
      memo.put(subTree,freq+1);
      return subTree;
    }
    ```
    
