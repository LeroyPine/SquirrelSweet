### BackTrack

###### 排列组合&子集相关



**形式一:  元素无重复且不可复选,（集合中的元素是唯一的. && .  每个元素最多使用一次）**

```java
List<List<Integer>> res = new ArrayList<>();
LinkedList<Integer> track = new LinkedList<>();
boolean[] used = new boolean[nums.length];

/**组合/子集问题回溯算法框架 */
void backtrack(int[] nums,int start){
  // base case
  // track
  for(int i = start;i<nums.length;i++){
    track.addLast(nums[i]);
    backtrack(nums,i+1);
    track.removeLast();
  }
}

/* 排列问题回溯算法框架 */
void backtrack(int[] nums){
  //base case
  //track
  for(int i=0;i<nums.length;i++){
    // 做选择
    if(used[i]){
      continue;
    }
    used[i]=true;
    track.addLast(nums[i]);
    backtrack(nums);
    track.removeLast();
    used[i]=false;
  }
}
```

**形式二、元素可重不可复选，即 `nums` 中的元素可以存在重复，每个元素最多只能被使用一次**，其关键在于排序和剪枝，`backtrack` 核心代码如下：

```java
// 可重复,需要将数组进行排序,才能更好的进行剪枝等操作
Array.sort(nums);
/* 组合/子集问题回溯算法框架 */
void backtrack(int[] nums,int start){
  // base case
  // track
  for(int i = start;i<nums.length;i++){
    // 剪枝, 跳过相同的邻枝
    if(i>start && nums[i]==nums[i-1]){
      continue;
    }
    track.addLast(nums[i]);
    backtrack(nums,i+1);
    track.removeLast();
  }
}

/* 排列问题回溯算法框架 */
void backtrack(int[] nums){
  //base case
  //track
  for(int i=0;i<nums.length;i++){
    // 做选择
    if(i > 0 && nums[i] == nums[i-1] && !used[i-1]){
      continue;
    }
    used[i]=true;
    track.addLast(nums[i]);
    backtrack(nums,i+1);
    track.removeLast();
    used[i]=false;
  }
}
```



**形式三、元素无重可复选，即 `nums` 中的元素都是唯一的，每个元素可以被使用若干次**，只要删掉去重逻辑即可，`backtrack` 核心代码如下：

```java
// 去掉去重逻辑即可
/* 组合/子集问题回溯算法框架 */
void backtrack(int[] nums,int start){
  // base case
  // track
  for(int i = start;i<nums.length;i++){
    track.addLast(nums[i]);
    backtrack(nums,i);
    track.removeLast();
  }
}

/* 排列问题回溯算法框架 */
void backtrack(int[] nums){
  //base case
  //track
  for(int i=0;i<nums.length;i++){
    track.addLast(nums[i]);
    backtrack(nums);
    track.removeLast();
  }
}
```







