package org.d3if3004.mobpro1.navigation

import org.d3if3004.mobpro1.ui.screen.KEY_ID_Game

sealed class Screen (val route: String){
    data object  Home: Screen("mainScreen")
    data object  FormBaru: Screen("detailScreen")
    data object  About: Screen("aboutScreen")
    data object  FormUbah: Screen("detailScreen/{$KEY_ID_Game}"){
        fun withId(id: Long) = "detailScreen/$id"
    }
}