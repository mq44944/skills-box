创建本地仓库   

	git init 

添加到暂存区  

	git add <filename>  
	git add .

添加评注

	git commit -m "代码提交信息"
	
![](http://7xi2wq.com1.z0.glb.clouddn.com/20160317142617.jpg)

将你的仓库连接到某个远程服务器（新仓库，第一次push之前）

	git remote add origin <server>

将改动提交到远程仓库

	git push origin master

远程仓库相关命令

	检出仓库 git clone git://github.com/jquery/jquery.git
	查看远程仓库：$ git remote -v
	添加远程仓库：$ git remote add [name] [url]
	删除远程仓库：$ git remote rm [name]
	修改远程仓库：$ git remote set-url --push [name] [newUrl]
	拉取远程仓库：$ git pull [remoteName] [localBranchName]
	推送远程仓库：$ git push [remoteName] [localBranchName]
	
分支(branch)操作相关命令

	查看本地分支：$ git branch
	查看所有分支：$ git branch -a 
	查看远程分支：$ git branch -r
	创建本地分支：$ git branch [name] ----注意新分支创建后不会自动切换为当前分支
	切换分支：$ git checkout [name]
	创建新分支并立即切换到新分支：$ git checkout -b [name]
	切换到远程dev分支：$ git checkout --track origin/dev
	删除分支：$ git branch -d [name] ---- -d选项只能删除已经参与了合并的分支，对于未有合并的分支是无法删除的。如果想强制删除一个分支，可以使用-D选项
	合并分支：$ git merge [name] ----将名称为[name]的分支与当前分支合并
	创建远程分支(本地分支push到远程)：$ git push origin [name]
	删除远程分支：$ git push origin :heads/[name] 或 $ git push origin :[name] 

------------

## 常用功能
### 1.分支操作
创建一个叫做“feature_x”的分支，并切换过去：  
	
	git checkout -b feature_x  

切换回主分支：  

	git checkout master  
	
除非你将分支推送到远端仓库，不然该分支就是 不为他人所见的：
	
	git push origin <branch>

	git branch -vv
	
删除本地分支：  

	git branch -d feature_x
删除远程分支：

	git push --delete origin [branch]
删除原称跟踪分支：

	git branch -d -r
清理远程跟踪分支：

	git fetch -p

### 2.更新与合并
要更新你的本地仓库至最新改动，执行：  

	git pull <remote> <branch>

以在你的工作目录中 获取（fetch） 并 合并（merge） 远端的改动。
要合并其他分支到你的当前分支（例如 master），执行：

	git merge <branch>


间接合并方式：

	git checkout test README.txt 【把test分支的文件 更新到当前分支上】
	
然后再 git commit -m "修改文件"

在这两种情况下，git 都会尝试去自动合并改动。遗憾的是，这可能并非每次都成功，并可能出现冲突（conflicts）。 这时候就需要你修改这些文件来手动合并这些冲突（conflicts）。改完之后，你需要执行如下命令以将它们标记为合并成功：
	
	git add <filename>

在合并改动之前，你可以使用如下命令预览差异：

	git diff <source_branch> <target_branch>


### 6.解决冲突(git fetch + git merge)
#### 1. 拉取
默认情况下，git fetch取回所有分支(branch)的更新。如果只想取回特定分支的更新，可以指定分支名。  
注意：git fetch命令拉取回来的分支，并不会合并到HEAD中。

	git fetch <远程主机名> <分支名>  
#### 2. 合并

	git checkout <branch>
	git merge FETCH_HEAD
	
	＃ 合并后，git diff 查看冲突的地方，修正，接下来提交
	
	git commit -am "update"
	git push 
	
### 4.替换本地改动

假如你操作失误（当然，这最好永远不要发生），你可以使用如下命令替换掉本地改动：
git checkout -- <filename>
此命令会使用 HEAD 中的最新内容替换掉你的工作目录中的文件。已添加到暂存区的改动以及新文件都不会受到影响。

假如你想丢弃你在本地的所有改动与提交，可以到服务器上获取最新的版本历史，并将你本地主分支指向它：

	git fetch origin
	git reset --hard origin/master


查看仓库信息

	git remote show origin 
	git push origin test:master         // 提交本地test分支作为远程的master分支
	git push origin test:test              // 提交本地test分支作为远程的test分支

------------

### 3.标签
为软件发布创建标签(版本号)是推荐的。这个概念早已存在，在 SVN 中也有。你可以执行如下命令创建一个叫做 1.0.0 的标签：

	git tag 1.0.0 1b2e1d63ff
	1b2e1d63ff 是你想要标记的提交 ID 的前 10 位字符。可以使用下列命令获取提交 ID：
	git log
	git log --graph
	git tag --help
	
你也可以使用少一点的提交 ID 前几位，只要它的指向具有唯一性。  

------------

### 5.使用git rebase合并多次commit
##### 1.首先使用git log查看一下提交历史
##### 2. git 压缩  git rebase -i HEAD~4
该命令执行后，会弹出一个编辑窗口，4次提交的commit倒序排列，最上面的是最早的提交，最下面的是最近一次提交

    pick 5e187c7dbe8    add center style indent  
    squash 6d577eb3440  add center style  
    squash f9b9508a3ab  add center style  
    squash 111ab9cc261  update templates  
    # Rebase 150a643..2fad1ae onto 150a643  
    #  
    # Commands:  
    #  p, pick = use commit  
    #  r, reword = use commit, but edit the commit message  
    #  e, edit = use commit, but stop for amending  
    #  s, squash = use commit, but meld into previous commit  
    #  f, fixup = like "squash", but discard this commit's log message  
    #  x, exec = run command (the rest of the line) using shell 
    
修改第2-4行的第一个单词pick为squash，当然看一下里面的注释就理解含义了

解决冲突后继续重置：

	git rebase --continue
	git add .  
	git rebase --continue  
	
	git push -f 

------------


### 7. 查看历史提交

	显示所有提交：$ git log
	显示某个用户的所有提交：$ git log --author="username"  
	显示某个文件的所有修改：$ git log -p <file>

### 8. 回滚
放弃工作目录下的所有修改：

	$ git reset --hard HEAD
	
将HEAD重置到指定的版本，并抛弃该版本之后的所有修改：

	$ git reset --hard <commit>
移除缓存区的所有文件（i.e. 撤销上次git add）:

	$ git reset HEAD
放弃某个文件的所有本地修改：

	$ git checkout HEAD <file>
重置一个提交（通过创建一个截然不同的新提交）

	$ git revert <commit>
将HEAD重置到上一次提交的版本，并将之后的修改标记为未添加到缓存区的修改：

	$ git reset <commit>
将HEAD重置到上一次提交的版本，并保留未提交的本地修改：

	$ git reset --keep <commit>

------------

#### 参考资料
* [Git教程](http://www.liaoxuefeng.com/wiki/0013739516305929606dd18361248578c67b8067c8c017b000) （本文由 [@廖雪峰](http://weibo.com/liaoxuefeng) 创作）
* [Pro Git 官方中文文档](https://git-scm.com/book/zh/v2)
* [gitlab/github 多账户下设置 ssh keys](https://segmentfault.com/a/1190000002994742)