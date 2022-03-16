package com.example.retrofit_mvvm_coroutine.model

data class RecyclerList(val items: ArrayList<RecyclerData>)   // items là mảng
data class RecyclerData(val name: String, val description: String, val owner: Owner) // items (recyclerData) chứa name, description, Owner
data class Owner(val avatar_url: String)  // Owner chứa ảnh