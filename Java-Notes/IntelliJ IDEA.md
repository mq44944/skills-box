

#### VM options
­Xms2048M   
­Xmx5120M   
-XX:PermSize=256M  
-XX:MaxPermSize=2048m  
  

­vmargs 说明后面是VM的参数,所以后面的其实都是JVM的参数了  
­Xms128m JVM初始分配的堆内存  
­Xmx512m JVM最大允许分配的堆内存,按需分配  
­XX:PermSize=64M JVM初始分配的非堆内存  
­XX:MaxPermSize=128M JVM最大允许分配的非堆内存,按需分配  

#### Editing（编辑）

⌃Space 基本的代码补全（补全任何类、方法、变量）
⌃⇧Space 智能代码补全（过滤器方法列表和变量的预期类型）
⌘⇧↩ 自动结束代码，行末自动添加分号
⌘P 显示方法的参数信息
⌃J, Mid. button click 快速查看文档
⇧F1 查看外部文档（在某些代码上会触发打开浏览器显示相关文档）
⌘+鼠标放在代码上 显示代码简要信息
⌘F1 在错误或警告处显示具体描述信息
⌘N, ⌃↩, ⌃N 生成代码（getter、setter、构造函数、hashCode/equals,toString）
⌃O 覆盖方法（重写父类方法）
⌃I 实现方法（实现接口中的方法）
⌘⌥T 包围代码（使用if..else, try..catch, for, synchronized等包围选中的代码）
⌘/ 注释/取消注释与行注释
⌘⌥/ 注释/取消注释与块注释
⌥↑ 连续选中代码块
⌥↓ 减少当前选中的代码块
⌃⇧Q 显示上下文信息
⌥↩ 显示意向动作和快速修复代码
⌘⌥L 格式化代码
⌃⌥O 优化import
⌃⌥I 自动缩进线
⇥ / ⇧⇥ 缩进代码 / 反缩进代码
⌘X 剪切当前行或选定的块到剪贴板
⌘C 复制当前行或选定的块到剪贴板
⌘V 从剪贴板粘贴
⌘⇧V 从最近的缓冲区粘贴
⌘D 复制当前行或选定的块
⌘⌫ 删除当前行或选定的块的行
⌃⇧J 智能的将代码拼接成一行
⌘↩ 智能的拆分拼接的行
⇧↩ 开始新的一行
⌘⇧U 大小写切换
⌘⇧] / ⌘⇧[ 选择直到代码块结束/开始
⌥⌦ 删除到单词的末尾（⌦键为Fn+Delete）
⌥⌫ 删除到单词的开头
⌘+ / ⌘- 展开 / 折叠代码块
⌘⇧+ 展开所以代码块
⌘⇧- 折叠所有代码块
⌘W 关闭活动的编辑器选项卡


#### 参考资料
* [IntelliJ IDEA 官网快捷键资料 Mac OS X](https://www.jetbrains.com/idea/docs/IntelliJIDEA_ReferenceCard_Mac.pdf)
* [极客学院 Wiki IntelliJ IDEA 使用教程](http://wiki.jikexueyuan.com/project/intellij-idea-tutorial/keymap-mac-introduce.html)
