package assessment2.navigation

import assessment2.ui.screen.KEY_ID_Game

sealed class Screen (val route: String){
    data object  Home: Screen("mainScreen")
    data object  FormBaru: Screen("detailScreen")
    data object  About: Screen("aboutScreen")
    data object  Profile: Screen("profileScreen")
    data object  FormUbah: Screen("detailScreen/{$KEY_ID_Game}"){
        fun withId(id: Long) = "detailScreen/$id"
    }
}