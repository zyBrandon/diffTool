# diffTool
diff平台主要做什么
随着项目逐渐的增大，业务逻辑的增加，每个模块之间存在一定的耦合，当新开发或者修改了一部分代码，直接提测，这时候针对修改的代码，针对测试来说可以算的上白盒的，可以去测试相关修改，但是针对整个系统来说，提测的其他代码我们是默认不变的。但是就是因为这个默认，往往会产生一定的危险性。举个栗子，例如下游的一个接口的某个字段废弃了，对应开发可能遗忘了上游有某项接口需要这个字段，测试在回归主功能的时候也没有发现异常，这时候线上bug就可能出现了。



diff平台原理
言简意骇的来说，提测代码的时候，通过jenkins触发diff的job，diff平台通过同时请求线上（mirror）和线下的接口，两者对返回的json进行对比，从而达到对是否影响其他功能的目的

如何实现diff平台
因为对java比较熟悉，使用spring boot+httpclient作为开发工具。虽然Spring boot来实现diff平台稍显笨重，但是实现起来还是比较方便的



细节处理
1.创建两个线程分别访问标准环境和提测环境

2.json对比的规则为：key value一致，增加则不报问题，对于字段减少则报错



代码实现
代码周末coding，后续提到github
