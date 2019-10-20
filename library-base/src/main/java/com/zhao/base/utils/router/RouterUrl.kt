package com.zhao.base.utils.router

class RouterUrl {

    companion object {

        const val NONE = ""//无跳转目标 可以选择finish当前界面
    }
    //=====================================================

    object App {
        private const val model = "/app/"
        const val Main = model + "MainActivity"
        const val Welcome = model + "WelcomeActivity"
    }

    object Home {
        private const val model = "/home/"
    }

    object Msg {
        private const val model = "/Msg/"
    }
    object User {
        private const val model = "/user/"
        const val LoginActivity = model + "LoginActivity"
    }


    object Web {
        private const val model = "/web/"
        const val H5 = model + "webActivity" //vm版H5 web
    }
}