package york.com.retrofit2rxjavademo.di.scope;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * @author: YorkYu
 * @version: V2.0.0
 * @project: Retrofit2RxjavaDemo
 * @package: york.com.retrofit2rxjavademo.di.scope
 * @description: AppScope like singleton in the whole application
 * @date: 2017/7/7
 * @time: 17:32
 */
@Scope
@Retention(RetentionPolicy.CLASS)
public @interface AppScope {
}
