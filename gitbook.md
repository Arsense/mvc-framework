# gitbook常规使用命令

　然后我们回到命令行，在 mybook 文件夹中再次执行 **gitbook init** 命令。GitBook 会查找 SUMMARY.md 文件中描述的目录和文件，如果没有则会将其创建。

接着我们执行 gitbook serve 来预览这本书籍


你可以执行 gitbook build 命令构建书籍，默认将生成的静态网站输出到 _book 目录。实际上，这一步也包含在 gitbook serve 里面，因为它们是 HTML，所以 GitBook 通过 Node.js 给你提供服务了。 

serve 命令也可以指定端口：

$ gitbook serve --port 2333
1
　　你还可以生成 PDF 格式的电子书：

$ gitbook pdf ./ ./mybook.pdf
1
　　生成 epub 格式的电子书：

$ gitbook epub ./ ./mybook.epub
1
　　生成 mobi 格式的电子书：

$ gitbook mobi ./ ./mybook.mobi

参考 [gitbook参考](http://www.chengweiyang.cn/gitbook/index.html "gitbook参考")

把笔记保存到github中我们在自己的github新建一个仓库，然后把笔记上传到github上，添加.gitignore文件添加github忽略文件，忽略_book文件夹，执行以下命令上传到github。
cd gitbook-note

git init
git add -A
git commit -m"msg"
git remote add origin 

https://github.com/sunshineyanghui/gitbook-note.git
git push -u origin master
现在浏览器中访问https://github.com/sunshineyanghui/gitbook-note既可以看到笔记了。编译成html为了部署方便，现在我们修改一下文件的结构


cd gitbook-note
mkdir content

mv *.md content
mv vue content
现在运行gitbookserve会报错，但是会自动创建 docs 文件夹，文件夹中的内容，就是编译后的输出。正确运行执行下列命令

gitbook serve ./content ./docs每次启动的时候，都要敲长长的命令，很不方便，所以，我们就需要把命名简短化，具体就是去写成 npm 脚本。把项目变成一个nodejs的项目

npm init -y生成一个package.json文件，在package.json添加一下代码


"scripts": {
          "build": "gitbook build ./content ./docs"
},        
然后执行命令运行


npm run build这样 html 内容被编译好之后就会被保存到 docs 文件夹中。部署到github pages咱们来把 html 内容部署到公网上，用到的是 github 的 pages 服务。docs 文件夹 Push 到 github运行 git add -A; git commit 操作，把 docs 文件夹保存到版本中，然后 git push 上传。浏览器中，到 https://github.com/sunshineyanghui/gitbook-note.git ，可以看到 docs/ 文件夹上传完毕。配置 pages 服务到 仓库配置页面 到 Github Pages 一项下面。Source 一项设置为 master branch docs folder 意思就是 master 分支的 docs 文件夹。




等待几分钟，到 https://sunshineyanghui.github.io/gitbook-note/，可以看到本笔记上线了。


https://www.jianshu.com/p/4e109a1113b2