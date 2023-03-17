package com.example.recyclerapp.model

class MainModel(
    var name:String = "",
    var isInComing :Boolean =  false,
    var type :MainModelType =  MainModelType.ITEM,
)

enum class MainModelType {
    TITLE,
    CUSTOM,
    CUSTOM_TEXT_VIEW,
    ITEM
}

enum class SelectedMessageAnimatedMode {
    NONE,
    ANIMATING,
    ANIMATION_OPEN,
    ANIMATION_DONE,
    ANIMATION_CLOSE
}