#### AutoInitialize

> 模块化或者组件化的项目中，每个模块需要一些初始化代码，在APP启动时需要在Application对象中进行初始化。**AutoInitialize** 的目标是对android-library类型的模块初始化提供统一入口，无需在Application对象中逐个进行。

- AutoInitialize以 [AutoRegister](https://github.com/campusboy/AutoRegister) 为基础

对实现 com.campusboy.autoinit.interfaces.IAutoInitializer 接口的类进行扫描，com.android.application类型模块gradle文件中添加如下配置

``` groovy
apply plugin: 'auto-register'
autoregister {
    registerInfo = [
            [
                    'scanInterface'           : 'com.campusboy.autoinit.interfaces.IAutoInitializer'
                    , 'codeInsertToClassName' : 'com.campusboy.autoinit.api.AutoInitialize'
                    , 'codeInsertToMethodName': 'registerInitializers'
                    , 'registerClassName'     : 'com.campusboy.autoinit.api.InitializerRegister'
                    , 'registerMethodName'    : 'register'
            ]
    ]
}
```

- 初始化统一入口

在Application对象中进行初始化的统一入口：com.campusboy.autoinit.api.AutoInitialize#init(Context)

- gradle配置：

1. 仓库地址配置
``` groovy
maven { url 'http://nexus.pri.ibanyu.com/repository/maven-snapshots' }
```

2. autoinitialize库
```groovy
implementation 'com.palfish.android:autoinitialize:1.1.1-SNAPSHOT'
```

3. autoregister插件
```groovy
classpath 'com.palfish.android:autoregister:1.4.2-SNAPSHOT'
```

- 模块初始化实现

```kotlin
import android.content.Context
import android.widget.Toast
import com.campusboy.autoinit.interfaces.IAutoInitializer

class AppInitializer : IAutoInitializer {
    override fun initialize(context: Context) {
        Toast.makeText(context, "调用 AppInitializer", Toast.LENGTH_LONG).show()
    }
}
```