package com.zhao.base.aspect

//import android.util.Log
//import com.alibaba.android.arouter.launcher.ARouter
//import com.zhao.base.utils.router.RouterUrl
//import org.aspectj.lang.JoinPoint
//
//import org.aspectj.lang.ProceedingJoinPoint
//import org.aspectj.lang.annotation.Around
//import org.aspectj.lang.annotation.Aspect
//import org.aspectj.lang.annotation.Before
//import org.aspectj.lang.annotation.Pointcut

//@Aspect
class LoginAspect {
   /* var logined = false
    @Pointcut("execution(@com.zhao.base.aspect.CheckLogin * *(..))")
    fun checkLoginPc() {
    }
    @Around("checkLoginPc()")
    @Throws(Throwable::class)
    fun checkLoginAround(joinPoint: ProceedingJoinPoint) {
        if (logined) {
            joinPoint.proceed()
        } else {
            ARouter.getInstance().build(RouterUrl.User.LoginActivity).navigation()
        }
    }
    @Before("execution(* com.zhao.home.HomeFragment.initData())")
    @Throws(Throwable::class)
    fun test(joinPoint:JoinPoint){
        Log.i("LoginAspect","HomeFragment.initData0")
    }*/
}
