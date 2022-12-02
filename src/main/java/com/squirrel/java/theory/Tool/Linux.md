## Shell

grep -C 20 'dd1149c6-0434-426a-9865-5e9f68703a94'  hcm-universal.log  

### tail （尾巴）

-   -f  循环读取         tail -f  universal.log 

-  -q  不显示处理信息    

-  -v 显示详细信息

-  -c<字节数>          tail -c 50 hcm-universal.log 

-  -n  显示行数         tail -n 100 hcm-universal.log 

-  -q, --quiet, --silent 从不输出给出文件名的首部

-  -s, --sleep-interval=S 与-f合用,表示在每次反复的间隔休眠S秒     tail -s 5 -f hcm-universal.log 

- 使用示例:

  ```shell
  tail  -n  10   file.log   查询日志尾部最后10行的日志;
  tail  -n +10   file.log   查询第10行之后的所有日志;
  tail  -fn 100   file.log   循环实时查看最后100行记录
  // 配合关键字使用
  tail -fn 1001 file.log  | grep 'uid' 
  tail -n 5000  file.log |more -1000
  ```

### head （头）

- head -n  10  file.log   查询日志文件中的头10行日志; 
- head -n -10  file.log   查询日志文件除了最后10行的其他所有日志;

### cat

### more

### less

### sed