# Retrofit2RxjavaDemo

To explain how to retrieve data from non restful response to get the right data.

If you want to retrieve information like below, which is non restful data response, then you can combine Rxjava to decompose the result and get the real part you wanted.

The main method is encapsulate Retrofit2 and retrieve data with Rxjava.

```json    
	{

	“code”:803,

	"msg":"该用户没有注册"

	“result”：{

                //balababla

                }

	}
```

----------

the main part is error check, pass in the raw data json, then use transformer, to transform out the real part!

一定是有code状态码和返回信息的，我之前的用法和教程一样，说将服务器返回的结果复制下来直接在AS上面利用GsonFormat转化就OK了，确实很方便，但是这样下来每个bean里面都会有重复的erroe_code和message或者服务器返回其他，所以我是这样做的：


----------



##Thanks
- [Android基于Retrofit2.0 封装的超好用的RetrofitClient工具类]( http://www.jianshu.com/p/29c2a9ac5abf)
- [Retrofit2.0 再次封装：](http://www.jianshu.com/p/7edc1cce6b93)
- [Retrofit + RxAndroid 实践总结](http://www.jianshu.com/p/f48f6d31314b)
- [RxJava 与 Retrofit 结合的最佳实践]( https://gank.io/post/56e80c2c677659311bed9841)
- [你真的会用Retrofit2吗?Retrofit2完全教程](http://www.jianshu.com/p/308f3c54abdd)

##Contact Me
- Github:   github.com/ysmintor
- Email:    ysmintor@gmail.com
- Linkedin: cn.linkedin.com/in/ysmintor


##License

    Copyright 2015 YorkYu. All rights reserved.

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

        http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
