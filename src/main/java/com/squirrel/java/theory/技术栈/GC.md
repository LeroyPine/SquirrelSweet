## GC-Analysis

#### 工具

- Memory Analyzer Tool

  - mat.app 
  - link: https://www.eclipse.org/mat/
  - /Volumes/mat/mat.app/Contents/MacOS/MemoryAnalyzer -data /Users/squirrel/log -Xmx 3072m -Xms 3072m
  - 🤔️: mac 无法修改 MemoryAnalyzer.ini 文件
  - 😊命令
    - Histogram:  列举所有加载的类实例
    - Dominator Tree: 列举了还未被GC的大对象
    - Top Consumers: 按对象的所占内存的空间排名
    - Leak Suspects: 可疑对象分析报告

- GC 流程

  - ![image-20220608163259018](/Users/squirrel/Library/Application Support/typora-user-images/image-20220608163259018.png)
  - 

  

 

