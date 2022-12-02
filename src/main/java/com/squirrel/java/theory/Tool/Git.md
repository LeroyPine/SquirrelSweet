Git

- git clone  "仓库名"   "目录"
  - `git clone "https://github.com/tianqixin/runoob-git-test"   ../kibana/skr`

- git comment -am "提交备注信息"      
  -  -am  :代表直接add 无需进行git add

- git branch  
  - 查看自己本地的branch

- git push orgin "branch name"    
  - 推送代码至某分支

- git branch "分支名"      创建一个新分支

- git checkout "分支名"   切换到新分支

- Patch - 补丁
  - create patch      apply patch 
  - 场景:这个分支的commit  拆出来合到另一个分支上

- cherry-pick：git cherry-pick f0e063b62ad8ee1d02d5a09cad249524f79ccc07 将其他分支的某次提交合并到当前分支

- Git stash  ：保存当前工作进度    git stash save "message"  增加一些注释

- git stash pop  恢复最新的工作进度到工作区

- git stash pop  stash@{0}      --恢复指定的进度到工作区

- git stash clear  清除所有暂存区的进度

- git stash drop stash@{0}     -- 删除指定的暂存区域的东西

- git branch -D  localBranchname      -- 删除本地分支

- git push origin --delete remoteBranchName   --删除远程分支

- Merge request    |   基于自己的分支 merge into  ～ release 分支    ｜ 待other man approve 

- ```bash
  合并出错的情况下:
  还没commit：
  git merge --abort ，丢弃正在进行的合并
  已经commit：
  git revert -m 1 HEAD 新建一个commit，并且回到合并之前的状态
  git reset --hard commit_id 回退到指定的commit节点
  ```

- https://blog.csdn.net/qq_45677671/article/details/122574671

- git config pull.rebase false     

- ```shell
  git status
  git add .
  git commit -m "提交代码"
  git pull origin branchName     -- 拉取远程分支的代码
  git push
  ```

- 查看git 的用户名和邮箱

- ```shell
  git config -l   -- 查看目前全局git配置信息
  git config user.name  "lbs"  设置当前git的用户信息
  git config user.email "xx"   设置当前git的用户邮箱信息
  
  // 设置全局的git用户信息
  git config --global user.name "lbs"
  git config --global user.email "asfas" 
  ```

- **MERGE_MSG.swp**

  - https://blog.csdn.net/qq_32452623/article/details/78395832