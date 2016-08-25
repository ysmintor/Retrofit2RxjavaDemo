## English Version

To explain how to retrieve data from non restful response to get the right data.

If you want to retrieve information like below, which is non restful data response, then you can combine Rxjava to decompose the result and get the real part you wanted.

The main method is encapsulate Retrofit2 and retrieve data with Rxjava.

```java   
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