## squirrel-没头脑

- mvn配置：https://www.jianshu.com/p/337a9d9a33c0
- brew 命令下载软件
- mvn 命令指定setting文件
  - mvn dependency:resolve -Dclassifier=sources --settings /Users/squirrel/mavenconfig/settings-moka.xml
- install elasticsearch and kibana:  https://www.jianshu.com/p/5467c6f3f1fc
- 显示隐藏文件 ： ctrl + shift + .
- 查看各个文件的权限： ls  -l 
- 查看mac信息：system_profiler SPHardwareDataType

## idea

-  项目可以启动,代码却爆红,清除idea的cache,并重启即可

## JDK

- 切换JDK  https://segmentfault.com/a/1190000020834358
- 查看当前JDK的安装目录    
  - /usr/libexec/java_home
- 查看已安装的 JDK 版本及目录
  - /usr/libexec/java_home -V

### Linux

- 文件权限: 参考: https://blog.csdn.net/X1876631/article/details/70162009

  - ```shell
    -rw-r--r--    1 moka  staff    278  6 21  2021 MemoryAnalyzer.ini
    -rwxr-xr-x    1 moka  staff    342  6  2  2021 ParseHeapDump.sh
    drwxr-xr-x    5 moka  staff    170  6 21  2021 configuration
    -rw-r--r--    1 moka  staff  17300  6  2  2021 epl-2.0.html
    drwxr-xr-x   17 moka  staff    578  6 21  2021 features
    -rw-r--r--    1 moka  staff   9260  6  2  2021 notice.html
    drwxr-xr-x    4 moka  staff    136  6 21  2021 p2
    drwxr-xr-x  192 moka  staff   6528  6 21  2021 plugins
    ```

  - 第一个字符表示类型:         - 表示文件  ｜  d 表示目录

  - 后9个字符分3组，表示该文件对于当前用户(user)、当前用户所在组(group)、其他用户(other)的读/写/执行权限

  - rwx 代表主权限, -代表无权限, r 代表读权限,w代表写权限,x代表执行权限

- 修改文件权限

  - chmod [<权限范围><权限操作><具体权限>] [文件或目录…]
  - 权限范围
    - u:User, 即文件或者目录的拥有者
    - g:Group,即文件或者目录所属群组
    - o:Other,除了文件或目录拥有者或所属群组之外,其他用户皆属于这个范围
    - a:All,即全部的用户,包含拥有着,所属群组以及其他用户
  - 权限操作
    - +：增加权限
    - -：减少权限
    - =：唯一设定权限
  - 具体权限
    - r：表示可读
    - w：表示可写
    - x：表示可执行









